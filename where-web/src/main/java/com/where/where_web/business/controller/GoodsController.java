package com.where.where_web.business.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.inject.Inject;

import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.where.where_user_management.model.Pager;
import com.where.where_user_management.model.SystemContext;
import com.where.where_web.business.model.Goods;
import com.where.where_web.business.model.Shop;
import com.where.where_web.business.service.GoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Inject
	private GoodsService goodsService;
	/**
	 * 该方法用于用餐品名来查询餐品
	 * @param name
	 * @return
	 */
	@RequestMapping("/selectByName")
	@ResponseBody
	public String selectByName(@RequestParam String name){
		Goods goods=new Goods();
		Subject subject = SecurityUtils.getSubject();
		Shop shop=(Shop)subject.getSession().getAttribute("shop");
		if(shop==null){
			return "error";//表示session过期，或session没有shop对象
		}
		goods.setShopId(shop.getId());
		goods.setName(name);
		List<Goods> list=goodsService.selectLike(goods);
		for (Goods goods2 : list) {
			System.out.println(goods2);
		}
		Gson gson=new Gson();
		String json=gson.toJson(list);//转化为json数据
		return json;
	}
	
	@RequestMapping("/find")
	@ResponseBody
	public String Find(@RequestParam Integer pageNo){
		Goods goods=new Goods();
		Subject subject = SecurityUtils.getSubject();
		Shop shop=(Shop)subject.getSession().getAttribute("shop");
		if(shop==null){
			return "error";//表示session过期，或session没有shop对象
		}
		goods.setShopId(shop.getId());
		SystemContext.setPageNo(pageNo);//设置当前页码
		SystemContext.setPageSize(20);//设置页面大小
		Pager<Goods> pager=goodsService.find(goods);
		Gson gson=new Gson();
		String json=gson.toJson(pager);
		
		return json;
	}
	@RequestMapping("/findHelper")
	public String findHelper(){
		return "business/findGoods";
	}
	
	@RequestMapping("/addGoods")
	public String addGoods(@Valid  Goods goods ,BindingResult result ){
		if(result.getErrorCount()!=0){//验证是否出错，如果报错，就会返回到原页面
			return "/business/addGoods";
		}
		
		Subject subject = SecurityUtils.getSubject();
		Shop shop=(Shop)subject.getSession().getAttribute("shop");
		if(shop==null){
			return "error";//表示session过期，或session没有shop对象
		}
		goods.setShopId(shop.getId());
		int isSuccess=0;
		try {
			isSuccess=goodsService.insertSelective(goods);
			if(isSuccess==0){//查看是否插入成功，为0，跳转到错误页面，否则跳转到成功页面
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		return "insertSuccess";
	}
	@RequestMapping("/addGoodsHelper")
	public String addFoodHelper(Model model){
		Goods goods=new Goods();
		model.addAttribute("goods", goods);
		return "/business/addGoods";
	}
	
	@RequestMapping("/updateGoods")
	public String updateGoods(@Valid Goods goods ,BindingResult result ,Model model){
		if(result.getErrorCount()!=0){//验证是否出错，如果报错，就会返回到原页面
			return "/business/updateGoods";
		}
		
		Subject subject = SecurityUtils.getSubject();
		Shop shop=(Shop)subject.getSession().getAttribute("shop");
		if(shop==null){
			return "error";//表示session过期，或session没有shop对象
		}
		goods.setShopId(shop.getId());
		Goods oldGoods=goodsService.selectByName(goods);
		goods.setId(oldGoods.getId());
		int isSuccess=goodsService.updateByPrimaryKeySelective(goods);
		if(isSuccess==0){
			return "error";
		}
		model.addAttribute("goods", goods);
		return "business/updateGoodsSuccess";
	}
	@RequestMapping("/updateGoodsHelper")
	public String updateGoodsHelper(Integer id,Model model){
		Goods goods=goodsService.selectByPrimaryKey(id);
		model.addAttribute("goods", goods);
		return "/business/updateGoods";
	}
	
	@RequestMapping("/deleteGoods")
	public String deleteGoods(@RequestParam Integer id, @RequestParam String name ,Model model){
		int isSuccess=goodsService.deleteByPrimaryKey(id);
		if(isSuccess==0){
			return "error";
		}
		try {
			name = new String(name.getBytes("iso8859-1"),"utf8");
			model.addAttribute("name", name);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}	
		return "business/deleteGoodsSuccess";
	}
}
