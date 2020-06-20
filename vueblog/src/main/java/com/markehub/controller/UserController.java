package com.markehub.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.markehub.config.ResultMessage;
import com.markehub.entity.UserBean;
import com.markehub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/*
 * 文 件 名:  UserAction.java
 * 描       述:  唯一编号
 * 作者:  xiangmiao
 * 新增时间:  2020-06-11 11:10:43 星期四
 */

@Controller
@RequestMapping("user") 
public class UserController{

	@Autowired(required=false) //自动注入，不需要生成set方法了，required=false表示没有实现类，也不会报错。
	private UserService userService;
	
	/**
	 * @Title: index
	 * @Description: 首页
	 * @param @param model
	 * @param @param request
	 * @param @return
	 * @param @throws Exception
	 * @return ModelAndView 返回类型
	 * @throws
	 */
	@RequestMapping("/index") 
	public ModelAndView index(UserBean model, HttpServletRequest request) throws Exception{
		return null; 
	}
	
	
	/**
	 * @Title: queryByList
	 * @Description: 查询列表数据
	 * @param @param model
	 * @param @param response
	 * @param @throws Exception
	 * @return void 返回类型
	 * @throws
	 */
	@RequestMapping("/queryByList") 
	public @ResponseBody
	ResultMessage queryByList(UserBean model, HttpServletResponse response) throws Exception{
		List<UserBean> dataList = userService.queryByPage(model);
		//设置页面数据
		Map<String,Object> returnObject = new HashMap<String,Object>();
		returnObject.put("rows", dataList);
		return null;
	}
	
	/**
	 * 
	 * @Title: queryByPage
	 * @Description: 查询分页数据
	 * @param @param model
	 * @param @param response
	 * @param @throws Exception
	 * @return void 返回类型
	 * @throws
	 */
	@RequestMapping("/queryByPage") 
	public @ResponseBody  ResultMessage queryByPage(UserBean model,HttpServletResponse response) throws Exception{
		ResultMessage res = new ResultMessage();
		res.setData(userService.queryByPage(model));
		res.setMsg("");
		res.setStatus(0);
		return res;
	}

	/**
	 * 
	 * @Title: save
	 * @Description: 添加或修改数据
	 * @param @param dto
	 * @param @param typeIds
	 * @param @param response
	 * @param @throws Exception
	 * @return void 返回类型
	 * @throws
	 */
	@RequestMapping("/save")
	public @ResponseBody ResultMessage save(UserBean dto,Integer[] typeIds,HttpServletResponse response) throws Exception{
		if(dto.getId() == null){
			userService.add(dto);
		}else{
			userService.updateBySelective(dto);
		}
		return null;
	}
	
	/**
	 * 
	 * @Title: getId
	 * @Description: 根据ID获取数据对象
	 * @param @param id
	 * @param @param response
	 * @param @param request
	 * @param @throws Exception
	 * @return void 返回类型
	 * @throws
	 */
	@RequestMapping("/queryById")
	public @ResponseBody ResultMessage queryById(Long id,HttpServletResponse response) throws Exception{
		UserBean dto  = userService.queryById(id);
		if(dto == null){
			return null;
		}
		
		return null;

	}
	
	/**
	 * 
	 * @Title: delete
	 * @Description: 删除
	 * @param @param id
	 * @param @param response
	 * @param @throws Exception
	 * @return void 返回类型
	 * @throws
	 */
	@RequestMapping("/delete")
	public @ResponseBody ResultMessage delete(Long id,HttpServletResponse response) throws Exception{
		userService.delete(id);
		return null;
	}
	
	/**
	 * 
	 * @Title: batchDelete
	 * @Description: 批量删除
	 * @param @param id
	 * @param @param response
	 * @param @throws Exception
	 * @return void 返回类型
	 * @throws
	 */
	@RequestMapping("/batchDelete")
	public @ResponseBody ResultMessage batchDelete(String ids,HttpServletResponse response) throws Exception{
		String[] idArray = ids.split(",");
		List<Long> idlist = new ArrayList<Long>();
		for (String s : idArray){
			Long id = Long.valueOf(s);
			idlist.add(id);
		}
		userService.batchDelete(idlist);
		return null;
	}

}
