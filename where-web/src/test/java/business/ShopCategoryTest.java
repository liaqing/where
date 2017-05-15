package business;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.where.where_web.business.model.ShopCategory;
import com.where.where_web.business.service.ShopCategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class ShopCategoryTest {
	@Inject
	private ShopCategoryService shopCategoryService;
	
	@Test
	public void  testInsert(){
		ShopCategory shopCategory=new ShopCategory();
		shopCategory.setName("小吃");
		shopCategory.setSort(1);
		shopCategoryService.insertSelective(shopCategory);
	}
	@Test
	public void testSelect(){
		List<ShopCategory> list=shopCategoryService.select();
		for (ShopCategory shopCategory : list) {
			System.out.println(shopCategory);
		}
	}
	
	@Test
	public void testSelectByPramaryKey(){
		ShopCategory shopCategory=shopCategoryService.selectByPrimaryKey(1);
		System.out.println(shopCategory);
	}
}
