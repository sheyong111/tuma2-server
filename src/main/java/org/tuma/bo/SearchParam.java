package org.tuma.bo;

import lombok.Data;

import java.util.ArrayList;

@Data
public class SearchParam {

    private String tumaId;

    private ArrayList<String> cancer;

    private Integer pageSize = 20 ;

    private Integer pageNo = 1;

    private Boolean hasCountTotal = Boolean.FALSE;


}
