package business;


import java.math.BigDecimal;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.where.where_user_management.model.Pager;
import com.where.where_user_management.model.SystemContext;
import com.where.where_web.business.model.Goods;
import com.where.where_web.business.service.GoodsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})

public class BusinessTest {
	@Inject
	private GoodsService goodsService;
	
	
	@Test
	public void testInsert(){
		Goods goods=new Goods();
		
		goods.setName("西红柿");
		goods.setPrice(new BigDecimal(11.50));
		goods.setRepertory("无限");
		goodsService.insert(goods);
	}
	@Test
	public void testselect(){
		List<Goods> list =goodsService.select();
		for (Goods goods : list) {
			System.out.println(goods.toString());
		}
	}
	
	@Test
	public void testSelectLike(){
		Goods goods=new Goods();
		goods.setName("t");
		List<Goods> list=goodsService.selectLike(goods);
		for (Goods goods2 : list) {
			System.out.println(goods2);
		}
	}
	
	@Test
	public  void testFind(){
		SystemContext.setPageNo(3);
		SystemContext.setPageSize(4);
		Goods goods=new Goods();
		Pager<Goods> pager=goodsService.find(goods);
		List<Goods> list=pager.getList();
		for (Goods goods2 : list) {
			System.out.println(goods2.toString());
		}
		System.out.println(pager.getTotalNum());
	}
	
	
	@Test
	public void testGson(){
		Gson gson=new Gson();
		String jsonNumber=gson.toJson(100);
		System.out.println(jsonNumber);
	}
}
