package com.xhj.dddrug.service;

import com.xhj.dddrug.dto.Result;
import com.xhj.dddrug.pojo.Drug;
import com.xhj.dddrug.pojo.Metabolite;
import com.xhj.dddrug.pojo.Protein;
import com.xhj.dddrug.pojo.ResultMetabolite;
import com.xhj.dddrug.utils.Link;
import com.xhj.dddrug.utils.Node;

import java.util.List;
import java.util.Map; /**
 * User: asus
 * Date: 2018/4/2
 * Time: 17:46
 * Version:V1.0
 */
public interface MetaboliteService {
    public ResultMetabolite listMetabolite(Map<String, Object> map,ResultMetabolite resultMetabolite);

    public Result<Drug> listDrugs(Map<String, Object> map);

    public Result<Protein> listProtein(Map<String, Object> map);

    public List<Node> setNodes(Map<String, Object> map);

    public List<Link> setLinks(Map<String, Object> map, Metabolite metabolite);

    public Result<Link> listEdgeByPage(Map<String, Object> map,Metabolite metabolite);
}
