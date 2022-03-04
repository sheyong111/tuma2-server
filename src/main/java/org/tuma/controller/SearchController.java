package org.tuma.controller;


import org.tuma.bo.RemoteResponse;
import org.tuma.bo.SearchParam;
import org.tuma.service.SearchService;
import org.tuma.vo.PageResultVO;
import org.tuma.vo.search.TumaSearchPart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api")
public class SearchController {

    @Autowired
    private SearchService searchService;

    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public RemoteResponse<PageResultVO<TumaSearchPart>> searchTumaInfo(@RequestBody SearchParam param){
        RemoteResponse<PageResultVO<TumaSearchPart>> response;
        try {
            PageResultVO<TumaSearchPart> searchResultVo = searchService.searchByParam(param);
            response = RemoteResponse.custom().setSuccess().setData(searchResultVo).build();
        } catch (Exception e) {
            response = RemoteResponse.custom().setFailure(e.getMessage()).build();
        }
        return response;

    }

}
