package whereUserManagement;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.where.where_web.shiro.entity.UserTest;
import com.where.where_web.shiro.service.UserTestService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class TestUsers {
	@Resource
	private UserTestService  userTestService;
	
	
	
	@Test
	public void testInsert(){
		UserTest users=new UserTest();
		users.setId(445);
		users.setUsername("110");
		users.setPassword("110");
		users.setLocked((short) 1);
		userTestService.insert(users);
	}
}
