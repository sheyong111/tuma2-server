package org.tuma.vo.search;
import lombok.Data;

@Data
public class TumaSearchPart {

    private Integer tumaId;

    private String study;

    private String project;

    private String assay;

    private String sample;

    private String cancer;

    private String treatment;

    private String sex;

    private String age;

    private String response;

    private String treatmentSubtype;

    private String geographicLocation;

    private String instrument;

    private String antibiotic;

    private String timepoint;

    private String patientId;

}
