package com.xhj.dddrug.pojo;

import java.util.List;

/**
 * User: asus
 * Date: 2018/4/2
 * Time: 17:51
 * Version:V1.0
 */
public class ResultMetabolite {

    private Metabolite metabolite;
    private List<Drug> drugs;
    private List<Protein> proteins;

    public Metabolite getMetabolite() {
        return metabolite;
    }

    public void setMetabolite(Metabolite metabolite) {
        this.metabolite = metabolite;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }

    public List<Protein> getProteins() {
        return proteins;
    }

    public void setProteins(List<Protein> proteins) {
        this.proteins = proteins;
    }

    @Override
    public String toString() {
        return "ResultMetabolite{" +
                "metabolite=" + metabolite +
                ", drugs=" + drugs +
                ", proteins=" + proteins +
                '}';
    }
}
