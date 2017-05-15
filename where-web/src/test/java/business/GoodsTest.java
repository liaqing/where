package business;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.where.where_web.business.model.Goods;
import com.where.where_web.business.service.GoodsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class GoodsTest {
	@Inject
	private GoodsService goodsService;
	
	@Test
	public void testSelect(){
		Goods goods=goodsService.selectByPrimaryKey(2);
		System.out.println(goods);
	}
}
