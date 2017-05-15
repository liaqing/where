package users;

import java.math.BigDecimal;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.where.where_web.business.model.Orders;
import com.where.where_web.business.service.OrdersService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class OrdersTest {
	@Inject
	private OrdersService ordersService;
	
	@Test 
	public void testInsert(){
		Orders orders=new Orders();
		orders.setBusinessId(1);
		orders.setDeliveryAddressId("");getClass();
		orders.setRemarks("嗯嗯呃");
		orders.setStatus(0);
		orders.setTotalPrice(new BigDecimal(5.5));
		ordersService.insertSelective(orders);
		
	}
	@Test
	public void testselectBybusinessid(){
		System.out.println(ordersService.selectByBusinessId(1));
	}
}
