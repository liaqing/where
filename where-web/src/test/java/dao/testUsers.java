package dao;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.where.where_user_management.model.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})

public class testUsers {
	
	@Inject
	private  SqlSessionTemplate sqlSession;
	
	@Test
	public  void testSelect(){
		
		Users user=new Users();
		
		user=sqlSession.selectOne(Users.class.getName()+".select",1);
		System.out.println(user.toString());
	}
}
