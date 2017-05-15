package business;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.where.where_web.business.model.ShopAddress;
import com.where.where_web.business.service.ShopAddressService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class ShopAddressTest {
	@Inject  
	private ShopAddressService shopAddressService;
	
	@Test
	public void testInsert(){
		ShopAddress shopAddress=new ShopAddress();
		shopAddress.setProvince("安徽省");
		shopAddress.setCity("亳州市");
		shopAddress.setCounty("利辛县");
		shopAddress.setShopId(1);
		shopAddressService.insertSelective(shopAddress);
	}
	
	@Test
	public void testselect(){
		System.out.println(shopAddressService.selectByShopId(1));
	}
	
	@Test 
	public void testSelectByProCity(){
		ShopAddress shopAddress=new ShopAddress();
		shopAddress.setProvince("130000");
		shopAddress.setCity("130400");
		List<ShopAddress> list=shopAddressService.selectByProCity(shopAddress);
		for (ShopAddress shopAddress2 : list) {
			System.out.println(shopAddress2);
		}
		
	}
}
