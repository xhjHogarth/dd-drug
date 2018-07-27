package com.xhj.dddrug.service;

import com.xhj.dddrug.pojo.Drug;
import com.xhj.dddrug.pojo.Metabolite;
import com.xhj.dddrug.pojo.Protein;

import java.util.Map; /**
 * User: asus
 * Date: 2018/4/23
 * Time: 21:55
 * Version:V1.0
 */
public interface SearchService {
    public Drug selectDrugByDrugName(Map<String, Object> map);

    public Drug selectDrugByDrugbank(Map<String, Object> map);

    public Protein selectProteinByPname(Map<String, Object> map);

    public Protein selectProteinByGeneSymbol(Map<String, Object> map);

    public Protein selectProteinByGeneId(Map<String, Object> map);

    public Protein selectProteinByUpkb(Map<String, Object> map);

    public Metabolite selectMetaboliteByMname(Map<String, Object> map);

    public Metabolite selectMetaboliteByKc(Map<String, Object> map);

    public Metabolite selectMetaboliteByHmdb(Map<String, Object> map);
}
