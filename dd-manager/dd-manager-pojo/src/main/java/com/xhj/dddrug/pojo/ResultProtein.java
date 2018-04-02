package com.xhj.dddrug.pojo;

import java.util.List;

/**
 * User: asus
 * Date: 2018/2/6
 * Time: 23:55
 * Version:V1.0
 */
public class ResultProtein {
    private Protein protein;
    private List<Drug> drugs;
    private List<Metabolite> metabolites;

    public Protein getProtein() {
        return protein;
    }

    public void setProtein(Protein protein) {
        this.protein = protein;
    }

    public List<Drug> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<Drug> drugs) {
        this.drugs = drugs;
    }

    public List<Metabolite> getMetabolites() {
        return metabolites;
    }

    public void setMetabolites(List<Metabolite> metabolites) {
        this.metabolites = metabolites;
    }

    @Override
    public String toString() {
        return "ResultProtein{" +
                "protein=" + protein +
                ", drugs=" + drugs +
                ", metabolites=" + metabolites +
                '}';
    }
}
