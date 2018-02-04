package com.xhj.dddrug.pojo;

import java.util.List;

/**
 * User: asus
 * Date: 2018/1/26
 * Time: 0:56
 * Version:V1.0
 */
public class ResultDrug {

    private String drugName;
    private String drugBank;
    private List<String> proteins;
    private List<String> metabolites;
    private List<String> references;

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugBank() {
        return drugBank;
    }

    public void setDrugBank(String drugBank) {
        this.drugBank = drugBank;
    }

    public List<String> getProteins() {
        return proteins;
    }

    public void setProteins(List<String> proteins) {
        this.proteins = proteins;
    }

    public List<String> getMetabolites() {
        return metabolites;
    }

    public void setMetabolites(List<String> metabolites) {
        this.metabolites = metabolites;
    }

    public List<String> getReferences() {
        return references;
    }

    public void setReferences(List<String> references) {
        this.references = references;
    }

    @Override
    public String toString() {
        return "ResultDrug{" +
                "drugName='" + drugName + '\'' +
                ", drugBank='" + drugBank + '\'' +
                ", proteins=" + proteins +
                ", metabolites=" + metabolites +
                ", references=" + references +
                '}';
    }
}
