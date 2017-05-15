package business;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.where.where_user_management.model.Users;
import com.where.where_web.business.model.Comments;
import com.where.where_web.business.service.CommentsService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class CommentsTest {
	@Inject
	private CommentsService commentsService;
	
	@Test
	public void testInsert(){
		Comments comments=new Comments();
		comments.setContent("恩，不错");
		Users users =new Users();
		users.setId(1);
		comments.setUsers(users);
		commentsService.insertSelective(comments);
	}
	
	@Test 
	public void testselectByPrimaryKey(){
		Comments comments=commentsService.selectByPrimaryKey(1);
		System.out.println(comments.toString());
	}
	@Test
	public void testSelect() throws ParseException{
		List<Comments> list=commentsService.select();
		for (Comments comments : list) {
			System.out.println(comments);
		}
	}
}
