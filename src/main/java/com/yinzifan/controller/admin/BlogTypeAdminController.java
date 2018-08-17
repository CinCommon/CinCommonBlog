package com.yinzifan.controller.admin;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.yinzifan.entity.BlogTypeEntity;
import com.yinzifan.entity.PageBean;
import com.yinzifan.service.BlogInfoService;
import com.yinzifan.service.BlogTypeService;
import com.yinzifan.util.ResponseUtil;

/**
* @author Cin
* @time 2018/01/28 14:50:44
* 博客类别管理Controller
*/
@Controller
@RequestMapping("/admin/blogType")
public class BlogTypeAdminController {
	@Autowired
	private BlogTypeService blogTypeService;
	@Autowired
	private BlogInfoService blogInfoService;
	private final static Logger LOGGER = LoggerFactory.getLogger(BlogTypeAdminController.class);
	
	@RequestMapping("queryPageBlogTypes")
	public void querypageBlogTypes(@RequestParam(value = "page", required = false) String page,
			@RequestParam(value = "rows", required = false) String rows, BlogTypeEntity type, HttpServletResponse resp) throws IOException {
		PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
		Map<String, Object> map = new HashMap<>();
		map.put("start", pageBean.getStart());
		map.put("size", pageBean.getPageSize());
		List<BlogTypeEntity> lists = blogTypeService.queryPageBlogType(map);
		JSONObject json = new JSONObject();
		LOGGER.debug("BlogInfoEntity: {}", lists);
		json.put("rows", lists);
		json.put("total", blogTypeService.queryPageTotal());
		ResponseUtil.write(resp, json);
	}
	/**
	 * 添加或者修改博客类别信息
	 * @param entity
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/insertBlogType")
	public String insertBlogType(BlogTypeEntity entity,HttpServletResponse response)throws Exception{
		int resultTotal=0; 
			resultTotal=blogTypeService.insertBlogType(entity);
		JSONObject result=new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
		return null;
	}
	
	/**
	 * 添加或者修改博客类别信息
	 * @param entity
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/updateBlogType")
	public void updateBlogType(BlogTypeEntity entity,HttpServletResponse response)throws Exception{
		int resultTotal=0; 
		resultTotal=blogTypeService.updateBlogType(entity);
		JSONObject result=new JSONObject();
		if(resultTotal>0){
			result.put("success", true);
		}else{
			result.put("success", false);
		}
		ResponseUtil.write(response, result);
	}
	
	/**
	 * 博客类别信息删除
	 * @param ids
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/deleteBlogType")
	public void deleteBlogType(@RequestParam(value="ids",required=false)String ids,HttpServletResponse response)throws Exception{
		String []idsStr=ids.split(",");
		JSONObject result=new JSONObject();
		for(int i=0;i<idsStr.length;i++){
			if(blogInfoService.queryBlogInfoByTypeId(Integer.parseInt(idsStr[i]))>0){
				result.put("exist", true);
			}else{
				blogTypeService.deleteBlogType(Integer.parseInt(idsStr[i]));				
			}
		}
		result.put("success", true);
		ResponseUtil.write(response, result);
	}
	
}
