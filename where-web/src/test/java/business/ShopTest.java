package business;

import java.io.File;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.where.where_user_management.model.Business;
import com.where.where_web.business.model.Shop;
import com.where.where_web.business.service.ShopService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})

public class ShopTest {
	@Inject
	private ShopService shopService;
	
	@Test
	public void testInsert(){
		Shop shop=new Shop();
		Business business=new Business();
		business.setId(1);
		shop.setBusiness(business);
		shop.setName("美食");
		shop.setStatus("s");
		shopService.insertSelective(shop);
	}
	
	@Test
	public void testSelect(){
		Shop shop=shopService.selectByPrimaryKey(1);
		System.out.println(shop);
		
		
	}
	
	
	@Test
	public void dd(){
		deleteFile("C:/Users/AQing/Desktop/test.txt");
		
	}
	File file;
	boolean flag;
	public boolean deleteFile(String sPath) {  
	    flag = false;  
	    file = new File(sPath);  
	    // 路径为文件且不为空则进行删除  
	    if (file.isFile() && file.exists()) {  
	        file.delete();  
	        flag = true;  
	    }  
	    return flag;  
	} 
}
