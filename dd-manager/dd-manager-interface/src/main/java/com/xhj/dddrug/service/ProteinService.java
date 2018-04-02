package com.xhj.dddrug.service;

import com.xhj.dddrug.dto.Result;
import com.xhj.dddrug.pojo.Drug;
import com.xhj.dddrug.pojo.Metabolite;
import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.utils.Link;
import com.xhj.dddrug.utils.Node;
import com.xhj.dddrug.utils.PageBean;
import com.xhj.dddrug.vo.QueryVo;

import java.util.List;
import java.util.Map;

/**
 * User: asus
 * Date: 2018/1/19
 * Time: 21:01
 * Version:V1.0
 */
public interface ProteinService {

    public PageBean<Protein> selectProteins(QueryVo vo);

    public List<Drug> selectDrugs(Map<String, Object> map);

    public List<Metabolite> selectMetabolites(Map<String, Object> map);

    public Result<Drug> selectDrugsByPage(Map<String, Object> map);

    public List<Node> setNodes(Map<String, Object> map);

    public List<Link> setLinks(Map<String, Object> map);

    public Result<Metabolite> selectMetabolitesByPage(Map<String, Object> map);

    public Result<Link> listEdges(Map<String, Object> map);
}
