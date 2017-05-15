package business;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.where.where_web.business.model.GoodsCategory;
import com.where.where_web.business.service.GoodsCategoryService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class GoodsCategoryTest {
	@Inject
	private GoodsCategoryService goodsCategoryService;
	
	@Test
	public void testSelect(){
		GoodsCategory goodsCategory=goodsCategoryService.selectByPrimaryKey(1);
		System.out.println(goodsCategory);
	}
	@Test 
	public void testSelectByShopId(){
		List<GoodsCategory> list=goodsCategoryService.selectByShopId(1);
		for (GoodsCategory goodsCategory : list) {
			System.out.println(goodsCategory);
		}
	}
}
