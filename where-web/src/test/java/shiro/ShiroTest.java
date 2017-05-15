package shiro;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.where.where_web.shiro.entity.UserTest;
import com.where.where_web.shiro.service.UserTestService;
import com.where.where_web.shiro.test.LoginEnum;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class ShiroTest {
	@Resource
	private UserTestService  userTestService;
	@Test
	public void testInsert(){
		
		UserTest record =new UserTest("ll", "ff");
		record.setId(6);
		record.setLocked((short) 1);
		userTestService.insert(record);
	}
	@Test
	public void testInsertEncryption(){
		UserTest record = new UserTest("lisi","123");
		record.setId(10);
		record.setLocked((short) 1);
		userTestService.insert(record);
		
	}
	
	@Test
	public void testEnum(){
		System.out.println(LoginEnum.users.toString());
	}
}
