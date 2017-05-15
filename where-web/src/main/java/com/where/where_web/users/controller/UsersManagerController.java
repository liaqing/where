package com.where.where_web.users.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.inject.Inject;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.where.where_user_management.model.Business;
import com.where.where_user_management.model.DeliveryAddress;
import com.where.where_user_management.model.Users;
import com.where.where_web.business.model.Area;
import com.where.where_web.business.model.Goods;
import com.where.where_web.business.model.GoodsCategory;
import com.where.where_web.business.model.Orders;
import com.where.where_web.business.model.Shop;
import com.where.where_web.business.model.ShopAddress;
import com.where.where_web.business.model.ShopCategory;
import com.where.where_web.business.model.ShopPicture;
import com.where.where_web.business.service.AreaService;
import com.where.where_web.business.service.GoodsCategoryService;
import com.where.where_web.business.service.GoodsService;
import com.where.where_web.business.service.ShopAddressService;
import com.where.where_web.business.service.ShopCategoryService;
import com.where.where_web.business.service.ShopPictureService;
import com.where.where_web.business.service.ShopService;

@Controller
@RequestMapping("/usersManager")
public class UsersManagerController {
	@Inject
	private ShopAddressService shopAddressService;
	
	@Inject
	private AreaService areaService;
	@Inject
	private ShopCategoryService shopCategoryService;
	
	@Inject
	private ShopService shopService;
	
	@Inject
	private ShopPictureService shopPictureService;
	
	@Inject
	private GoodsCategoryService goodsCategoryService;
	
	@Inject
	private GoodsService goodsService;
	
	
	@RequestMapping("/selectAddress")
	public ModelAndView selectAddress(ShopAddress  shopAddress){
		List<Shop> restList = new ArrayList<>();//放搜索到的店铺中休息的店铺
		List<Shop> runList = new ArrayList<>();//放搜索的店铺中正在营业中的店铺
		Area areaProvince=areaService.selectByCode(Integer.parseInt(shopAddress.getProvince()));
		String province=areaProvince.getName();
		Area areaCity=areaService.selectByCode(Integer.parseInt(shopAddress.getCity()));
		String city=areaCity.getName();
		List<ShopAddress> list=shopAddressService.selectByProCity(shopAddress);
		for (ShopAddress shopAddress2 : list) {
			Shop shop=shopService.selectByPrimaryKey(shopAddress2.getShopId());
			ShopPicture shopPicture= shopPictureService.selectByShopId(shop.getId());
			shop.setShopPicture(shopPicture);
			if(shop.getStatus().equals("休息")){
				restList.add(shop);
			}else{
				runList.add(shop);
			}
		}
		//查询出所有店铺分类
		List<ShopCategory> shopCategoryList=shopCategoryService.select();
		
		ModelAndView mav=new ModelAndView("users/shopShow");
		mav.addObject("restList", restList);
		mav.addObject("runList", runList);
		mav.addObject("province", province);
		mav.addObject("city", city);
		mav.addObject("shopCategoryList", shopCategoryList);
		return mav;
	}
	
	@RequestMapping("/specificShop")
	public ModelAndView specificShop(Integer id){
		ModelAndView mav =new ModelAndView("users/specificShop");
		Shop shop=shopService.selectByPrimaryKey(id);
		ShopAddress shopAddress=shopAddressService.selectByShopId(id);
		ShopPicture shopPicture=shopPictureService.selectByShopId(id);
		mav.addObject("shop", shop);
		mav.addObject("shopPicture", shopPicture);
		mav.addObject("shopAddress", shopAddress);
		List<GoodsCategory> list=goodsCategoryService.selectByShopId(id);
		
		for (GoodsCategory goodsCategory : list) {
			System.out.println(goodsCategory);
			List<Goods> goodsList=goodsService.selectByShopCategoryId(goodsCategory.getId());
			goodsCategory.setList(goodsList);
			
		}
		mav.addObject("list", list);
		return mav;
	}
	@RequestMapping("/confirmOrdersHelper")
	public ModelAndView confirmOrdersHelper(Integer goodsId){
		ModelAndView mav = new ModelAndView("users/confirmOrders");
		Goods goods=goodsService.selectByPrimaryKey(goodsId);
		Subject subject = SecurityUtils.getSubject();
		Users users=(Users)subject.getSession().getAttribute("users");
		mav.addObject("goods", goods);
		mav.addObject("users", users);
		return mav;
	}
	
	@RequestMapping("/confirmOrders")
	public String confirmOrders(Orders orders,DeliveryAddress deliveryAddress,Integer goodsId){
		
		Goods goods=goodsService.selectByPrimaryKey(goodsId);
		Integer shopId=goods.getShopId();
		Shop shop=shopService.selectByPrimaryKey(shopId);
		Business business=shop.getBusiness();
		try {
			Subject subject = SecurityUtils.getSubject();
			Users users = (Users) subject.getSession().getAttribute("users");
			if(users!=null){
				orders.setUsersId(users.getId());
				deliveryAddress.setUsersId(users.getId());
			}
		} catch (Exception e) {
			return "error";
		}
		String deliveryAddressId=UUID.randomUUID().toString();
		deliveryAddress.setId(deliveryAddressId);
		orders.setDeliveryAddressId(deliveryAddressId);
		orders.setBusinessId(business.getId());
		System.out.println(orders);
		System.out.println(deliveryAddress);
		return "";
		
	}
}
