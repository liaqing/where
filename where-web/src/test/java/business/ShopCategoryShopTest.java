package business;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.where.where_web.business.model.ShopCategoryShop;
import com.where.where_web.business.service.ShopCategoryShopService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class ShopCategoryShopTest {
	@Inject
	private ShopCategoryShopService shopCategoryShopService;
	
	@Test
	public void testInsert(){
		ShopCategoryShop shopCategoryShop=new ShopCategoryShop();
		shopCategoryShop.setShopCategoryId(1);
		shopCategoryShop.setShopId(1);
		shopCategoryShopService.insertSelective(shopCategoryShop);
	}
	
	@Test
	public void testShopId(){
		List<ShopCategoryShop> list=shopCategoryShopService.selectByShopId(1);
		for (ShopCategoryShop shopCategoryShop : list) {
			System.out.println(shopCategoryShop);
		}
	}
}
