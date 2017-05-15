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
import com.where.where_web.business.model.GoodsCategory;
import com.where.where_web.business.model.Shop;
import com.where.where_web.business.service.GoodsCategoryService;

@Controller
@RequestMapping("/goodsCategory")
public class GoodsCategoryController {
	@Inject
	private GoodsCategoryService goodsCategoryService;
	
	@ResponseBody
	@RequestMapping("/select")
	public String select(){
		Subject subject = SecurityUtils.getSubject();
		Shop shop=(Shop)subject.getSession().getAttribute("shop");
		if(shop==null){
			return "";//session过期，或session中没有shop对象
		}
		List<GoodsCategory> list=goodsCategoryService.selectByShopId(shop.getId());
		Gson gson=new Gson();
		String json=gson.toJson(list);
		return json;
	}
	
	@RequestMapping("/selectHelper")
	public String selectHelper(){
		return "business/findGoodsCategory";
	}
	
	
	@RequestMapping("/addGoodsCategory")
	public String addGoodsCategory(@Valid GoodsCategory goodsCategory,BindingResult result,Model model){
		if(result.getErrorCount()!=0){//验证是否出错，如果报错，就会返回到原页面
			return "business/addGoodsCategory";
		}
		Subject subject = SecurityUtils.getSubject();
		Shop shop=(Shop)subject.getSession().getAttribute("shop");
		if(shop==null){
			return "error";
		}
		goodsCategory.setShopId(shop.getId());
		try {
			int isSuccess=goodsCategoryService.insertSelective(goodsCategory);
			if(isSuccess==0){//查看是否插入成功，为0，跳转到错误页面，否则跳转到成功页面
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		
		
		model.addAttribute("goodsCategory",goodsCategory);
		return "business/addGoodsCategorySuccess";
	}
	@RequestMapping("/addGoodsCategoryHelper")
	public String addGoodsCategoryHelper(Model model){
		GoodsCategory goodsCategory=new GoodsCategory();
		model.addAttribute("goodsCategory", goodsCategory);
		return "business/addGoodsCategory";
	}
	
	@RequestMapping("/selectGoodsCategoryName")
	@ResponseBody
	public String selectGoodsCategoryName(Integer id ){
		GoodsCategory goodsCategory=goodsCategoryService.selectByPrimaryKey(id);
		return goodsCategory.getName();
	}
	
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(@RequestParam Integer id){
		try {
			int isSuccess=goodsCategoryService.deleteByPrimaryKey(id);
			if(isSuccess==0){
				return "0";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
		
		return "1";
	}
	
	@RequestMapping("/updateGoodsCategoryHelper")
	public String updateGoodsCategoryHelper( GoodsCategory goodsCategory ,Model model){
		try {
			goodsCategory.setName(new String(goodsCategory.getName().getBytes("iso8859-1"),"utf8"));
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("goodsCategory", goodsCategory);
		return "business/updateGoodsCategory";
	}
	
	@RequestMapping("/updateGoodsCategory")
	public String updateGoodsCategory(@Valid GoodsCategory goodsCategory,BindingResult result,Model model){
		if(result.getErrorCount()!=0){//验证是否出错，如果报错，就会返回到原页面
			return "business/updateGoodsCategory";
		}
		try {
			int isSuccess=goodsCategoryService.updateByPrimaryKeySelective(goodsCategory);
			if(isSuccess==0){//查看是否修改成功，为0，跳转到错误页面，否则跳转到成功页面
				return "error";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("goodsCategory",goodsCategory);
		return "business/updateGoodsCategorySuccess";
		
	}
	
}
