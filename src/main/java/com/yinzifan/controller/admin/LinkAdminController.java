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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONObject;
import com.yinzifan.entity.LinkEntity;
import com.yinzifan.entity.PageBean;
import com.yinzifan.service.LinkService;
import com.yinzifan.util.ResponseUtil;

/**
 * @author yinzf2 2018/03/01 17:12:22
 */
@Controller
@RequestMapping("/admin/link")
public class LinkAdminController {
    @Autowired
    private LinkService linkService;
    private static final Logger LOGGER = LoggerFactory.getLogger(LinkAdminController.class);
    
    @RequestMapping("/queryPageLinks")
    public void queryPageLinks(@RequestParam(value = "page", required = false) String page,
            @RequestParam(value = "rows", required = false) String rows, LinkEntity link, HttpServletResponse resp) throws IOException {
        PageBean pageBean = new PageBean(Integer.parseInt(page), Integer.parseInt(rows));
        Map<String, Object> map = new HashMap<>();
        map.put("start", pageBean.getStart());
        map.put("size", pageBean.getPageSize());
        List<LinkEntity> lists = linkService.query(map);
        JSONObject json = new JSONObject();
        LOGGER.debug("LinkEntity: {}", lists);
        json.put("rows", lists);
        json.put("total", linkService.queryPageTotal());
        ResponseUtil.write(resp, json);
    }

    @RequestMapping(value="/update", method=RequestMethod.POST)
    public void update(LinkEntity link, HttpServletResponse resp) throws IOException {
        LOGGER.debug("LinkAdminController.update()");
        
        
    }
}
