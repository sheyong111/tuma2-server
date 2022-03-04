package org.tuma.service;

import org.tuma.bo.SearchParam;
import org.tuma.vo.PageResultVO;
import org.tuma.vo.search.TumaSearchPart;

public interface SearchService {

    PageResultVO<TumaSearchPart> searchByParam(SearchParam param);

}
