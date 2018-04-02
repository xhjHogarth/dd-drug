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
    private String type;
    private List<Protein> proteins;
    private List<Metabolite> metabolites;
    private List<Reference> references;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Protein> getProteins() {
        return proteins;
    }

    public void setProteins(List<Protein> proteins) {
        this.proteins = proteins;
    }

    public List<Metabolite> getMetabolites() {
        return metabolites;
    }

    public void setMetabolites(List<Metabolite> metabolites) {
        this.metabolites = metabolites;
    }

    public List<Reference> getReferences() {
        return references;
    }

    public void setReferences(List<Reference> references) {
        this.references = references;
    }

    @Override
    public String toString() {
        return "ResultDrug{" +
                "drugName='" + drugName + '\'' +
                ", drugBank='" + drugBank + '\'' +
                ", type='" + type + '\'' +
                ", proteins=" + proteins +
                ", metabolites=" + metabolites +
                ", references=" + references +
                '}';
    }
}
