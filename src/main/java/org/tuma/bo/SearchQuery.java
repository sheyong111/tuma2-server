package org.tuma.bo;

import lombok.Data;

import java.util.ArrayList;

@Data
public class SearchQuery {

    private ArrayList<String> tumaIds;

    private ArrayList<String> studys;

    private ArrayList<String> projects;

    private ArrayList<String> assays;

    private ArrayList<String> samples;

    private ArrayList<String> cancers;

    private ArrayList<String> treatments;

    private ArrayList<String> sexs;

    private ArrayList<String> ages;

    private ArrayList<String> response;

    private ArrayList<String> treatmentSubtypes;

    private ArrayList<String> geographicLocations;

    private ArrayList<String> instrument;

    private ArrayList<String> antibiotics;

    private ArrayList<String> timepoints;

    private ArrayList<String> patientIds;

    private Integer pageSize;

    private Integer offset;

}
