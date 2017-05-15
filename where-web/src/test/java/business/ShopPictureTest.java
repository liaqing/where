package business;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.where.where_web.business.model.ShopPicture;
import com.where.where_web.business.service.ShopPictureService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class ShopPictureTest {
	@Inject
	private ShopPictureService shopPictureService;
	
	@Test
	public void testInsert(){
		ShopPicture shopPicture=new ShopPicture();
		shopPicture.setName("pp");
		shopPicture.setShopId(1);
		shopPicture.setSuffixName("jpg");
		shopPicture.setFileSize((long) 4);
		shopPictureService.insertSelective(shopPicture);
	}
	
	@Test
	public void testSelectByShopId(){
		ShopPicture shopPicture=shopPictureService.selectByShopId(1);
		System.out.println(shopPicture);
		String s = UUID.randomUUID().toString();
		System.out.println(s);
		System.out.println(new Date());
		new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		
	}
	
}
