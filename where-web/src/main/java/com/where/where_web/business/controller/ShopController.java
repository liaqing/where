package com.where.where_web.business.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.where.where_user_management.model.Business;
import com.where.where_user_management.service.BusinessService;
import com.where.where_web.business.model.Area;
import com.where.where_web.business.model.Shop;
import com.where.where_web.business.model.ShopAddress;
import com.where.where_web.business.model.ShopCategory;
import com.where.where_web.business.model.ShopCategoryShop;
import com.where.where_web.business.model.ShopPicture;
import com.where.where_web.business.service.AreaService;
import com.where.where_web.business.service.ShopAddressService;
import com.where.where_web.business.service.ShopCategoryService;
import com.where.where_web.business.service.ShopCategoryShopService;
import com.where.where_web.business.service.ShopPictureService;
import com.where.where_web.business.service.ShopService;

@Controller
@RequestMapping("/shop")
public class ShopController {
	/*@Inject
	private ShopService shopService;*/
	
	@Inject
	private ShopService shopService;
	
	@Inject
	private ShopCategoryService shopCategoryService;
	
	@Inject
	private ShopCategoryShopService shopCategoryShopService;
	
	@Inject
	private ShopPictureService shopPictureService;
	
	@Inject
	private ShopAddressService ShopAddressService;
	
	@Inject
	private AreaService areaService;
	
	@Inject
	private BusinessService businessService;
	
	@RequestMapping("/updateShopHelper")
	public String updateShopHelper(Map<String, Object> map){
		Subject subject = SecurityUtils.getSubject();
		Shop shop=(Shop)subject.getSession().getAttribute("shop");
		
		List<ShopCategory> shopCategoryList=shopCategoryService.select();//获取全部店铺分类
		List<String> shopCategoryListName =new ArrayList<>();
		for(ShopCategory a:shopCategoryList){
			shopCategoryListName.add(a.getName());
		}
		if(shop==null){
			//如果session过期，便会出现shop对象为空，这时把页面跳转到提示页面，提示session过期，请重新登录
		}
		List<ShopCategoryShop> ShopCategoryShopList=shopCategoryShopService.selectByShopId(shop.getId());//获取该店铺所属店铺分类
		List<String> shopCategoryListPresentName=new ArrayList<>();//存放该店铺所属的店铺分类
		for (ShopCategoryShop shopCategoryShop : ShopCategoryShopList) {
			Integer id=shopCategoryShop.getShopCategoryId();
			ShopCategory shopCategory2=shopCategoryService.selectByPrimaryKey(id);
			shopCategoryListPresentName.add(shopCategory2.getName());
		}
		shop.setList(shopCategoryListPresentName);//设置店铺类别哪些被选中
		ShopAddress shopAddress=ShopAddressService.selectByShopId(shop.getId());//获取店铺地址对象
		String province=shopAddress.getProvince();
		String city=shopAddress.getCity();
		String county=shopAddress.getCounty();
		String specificAddress=shopAddress.getSpecificAddress();
		shop.setProvince(province);//设置哪些被选中
		shop.setCity(city);//设置哪些被选中
		shop.setCounty(county);//设置哪些被选中
		shop.setSpecificAddress(specificAddress);
		
		
		//获取省市县
		Area areaProvince=areaService.selectByCode(Integer.parseInt(province));
		Area areaCity=areaService.selectByCode(Integer.parseInt(city));
		Area areaCounty=areaService.selectByCode(Integer.parseInt(county));
		
		//把省市县名放到map中
		map.put("areaProvince", areaProvince.getName());
		map.put("areaCity", areaCity.getName());
		map.put("areaCounty", areaCounty.getName());
		
		map.put("shop", shop);
		map.put("shopCategoryListName", shopCategoryListName);
		//把省市县code放入map中
		map.put("province",province);
		map.put("city",city);
		map.put("county",county);
		try {
			ShopPicture shopPicture=shopPictureService.selectByShopId(shop.getId());
			map.put("shopPicture", shopPicture);
			String suffixName=shopPicture.getSuffixName();
			/*if("JPG".toLowerCase().equals(suffixName.toLowerCase())){//解决图片后缀为JPG时，不论原文件后缀大小写，上传文件都为小写jpg方案
				suffixName="jpg";
			}*/
			
			map.put("suffixName",suffixName);
		} catch (Exception e) {
			return "error";
		}
		return "business/shop/updateShop";
	}
	
	@RequestMapping("/fileUpLoad")
	@ResponseBody
	/**
	 * 
	 * @param file
	 * @param request
	 * @return 返回值为"0",表示文件大于10M;返回值为"1",表示文件类型不正确;返回值为“2”,文件未获取；返回值为"3",表示文件写入异常;返回值为"4",表示文件上传成功
	 */
	public String fileUpLoad(@RequestParam(value = "fileUpLoad", required = false)MultipartFile file ,HttpServletRequest request,Model model){
		
		 if (!file.isEmpty()) {
			 ShopPicture shopPicture=new ShopPicture();
			 String fileName = file.getOriginalFilename(); //获取文件名
				System.out.println(fileName);
				long fileSize=file.getSize();
				if(fileSize>10485760){
					return "0";
				}
				String suffixName=fileName.split("\\.")[1].toUpperCase();
				
				if(!suffixName.equals("JPG") && !suffixName.equals("GIF") && suffixName.equals("JPEG") && suffixName.equals("PNG")){
					return "1";
				}
				shopPicture.setName(fileName);
				shopPicture.setFileSize(fileSize);
				shopPicture.setSuffixName(suffixName);
				Subject subject = SecurityUtils.getSubject();
				Session session=subject.getSession();
				Shop shop=(Shop)session.getAttribute("shop");
				shopPicture.setShopId(shop.getId());
				//注意图片缓存问题
				String currentDate=new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				shopPicture.setName(currentDate+shop.getId());
				//String separator=File.separator;
				String url="/where-web"+"/image";
				shopPicture.setUrl(url);
				
				try {
					//此处需加事务，在插入之间要先删除本店铺下的图片，再进行添加，，，当完成删除，而插入操作发生异常，需要把事务回滚
					ShopPicture shopPictureOld=shopPictureService.selectByShopId(shop.getId());
					deleteFile("D:/eclipse/workspace/where-parent/where-web/src/main/webapp/WEB-INF/image/"+shopPictureOld.getName()+"."+shopPictureOld.getSuffixName());
					shopPictureService.deleteByShopId(shop.getId());
					
					shopPictureService.insertSelective(shopPicture);
				} catch (Exception e) {
					return "3";
				}
			 OutputStream out=null;
	            try {  
	            	//String s=request.getSession().getServletContext().getRealPath("WEB-INF")+separator+"image"+separator+"shop.jpg";         //开发中使用
	            	
	            	 out=new FileOutputStream(new File("D:/eclipse/workspace/where-parent/where-web/src/main/webapp/WEB-INF/image/"+shopPicture.getName()+"."+suffixName));
	            	// out=new FileOutputStream(new File( url+"/shop."+suffixName));
	                    byte[] buf = file.getBytes();//文件二进制
	                    out.write(buf);
	                    out.flush();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                    return "3";
	                }finally{
	                	if(out!=null){
	                		try {
								out.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
	                	}
	                }
		 	}else{
		 		return "2";
		 	}
		 return "4";
	}
	
	@RequestMapping("/statusManagerHelper")
	public String statusManagerHelper(Model model){
		Subject subject = SecurityUtils.getSubject();
		Shop shop=(Shop)subject.getSession().getAttribute("shop");
		model.addAttribute("shop", shop);
		return "/business/shop/statusManager";
	}
	
	@RequestMapping("/statusManager")
	@ResponseBody
	public String statusManager(@RequestParam String status){
		try {
			Subject subject = SecurityUtils.getSubject();
			Shop shopcurrent = (Shop) subject.getSession().getAttribute("shop");
			shopcurrent.setStatus(status);
			shopService.updateByPrimaryKeySelective(shopcurrent);
		} catch (Exception e) {
			e.printStackTrace();
			return "0";
		}
		return "1";
	}
	
	@RequestMapping("/updateBusinessHelper")
	public String updateBusinessHelper(Model model){
		Subject subject = SecurityUtils.getSubject();
		Business business=(Business)subject.getSession().getAttribute("business");
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		String birthdayStr=simpleDateFormat.format(business.getBirthday());
		business.setBirthdayStr(birthdayStr);
		model.addAttribute("business", business);
		return "business/updateBusiness";
	}
	
	@RequestMapping("/updateBusiness")
	public String updateBusiness(@Valid Business business ,BindingResult result ,Model model){
		if(result.getErrorCount()!=0){//验证是否出错，如果报错，就会返回到原页面
			return "/business/updateBusiness";
		}
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
		try {
			Subject subject = SecurityUtils.getSubject();
			Business businessCurrent=(Business)subject.getSession().getAttribute("business");
			int id=businessCurrent.getId();
			business.setId(id);
			business.setBirthday(simpleDateFormat.parse(business.getBirthdayStr()));
			int isBusiness=businessService.updateByPrimaryKeySelective(business);
			if(isBusiness==0){
				return "error";
			}
			
		} catch (ParseException e) {
			e.printStackTrace();
			return "error";
		}
		model.addAttribute("business", business);
		System.out.println(business);
		return "business/updateBusinessSuccess";
	}
	
	
	public boolean deleteFile(String sPath) { 
		
	    boolean flag = false;  
	    File file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	} 
	
}
