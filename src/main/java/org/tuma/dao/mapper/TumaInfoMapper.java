package org.tuma.dao.mapper;

import org.apache.ibatis.annotations.Param;
import org.tuma.bo.SearchQuery;
import org.tuma.vo.search.TumaSearchPart;

import java.util.ArrayList;

public interface TumaInfoMapper {

    ArrayList<TumaSearchPart> searchByQuery(@Param("query")SearchQuery query);

    int countByQuery(@Param("query") SearchQuery query);

}
