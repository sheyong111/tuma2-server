package org.tuma.service.impl;



import org.tuma.bo.SearchParam;
import org.tuma.bo.SearchQuery;
import org.tuma.dao.mapper.TumaInfoMapper;
import org.tuma.service.SearchService;
import org.tuma.vo.PageResultVO;
import org.tuma.vo.search.TumaSearchPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    private TumaInfoMapper tumaInfoMapper;

    private SearchQuery convertSearchParamToQuery(SearchParam param) {
        SearchQuery searchQuery = new SearchQuery();
        if (null != param.getTumaId() && !param.getTumaId().isEmpty()) {
            ArrayList<String> tumaIds = new ArrayList<>(Arrays.asList(param.getTumaId().split("\\s*,\\s*")));
            searchQuery.setTumaIds(tumaIds);
        }
        if (null != param.getCancer() && !param.getCancer().isEmpty()){
            searchQuery.setCancers(param.getCancer());
        }
        Integer offset = (param.getPageNo() - 1)* param.getPageSize();
        searchQuery.setOffset(offset);
        searchQuery.setPageSize(param.getPageSize());
        return searchQuery;
    }

    @Override
    public PageResultVO<TumaSearchPart> searchByParam(SearchParam param) {
        PageResultVO<TumaSearchPart> pageResult = new PageResultVO<>();
        SearchQuery searchQuery = convertSearchParamToQuery(param);

        int total = 0;
        if (!param.getHasCountTotal()) {
            total = tumaInfoMapper.countByQuery(searchQuery);
        }
        ArrayList<TumaSearchPart> tumaList = tumaInfoMapper.searchByQuery(searchQuery);

        pageResult.setTotal(total);
        pageResult.setResult(tumaList);
        return pageResult;
    }

}
