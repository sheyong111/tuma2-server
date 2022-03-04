package org.tuma.vo;

import lombok.Data;

import java.util.ArrayList;
@Data
public class PageResultVO<T> {

    private Integer total;

    private ArrayList<T> result;

}
