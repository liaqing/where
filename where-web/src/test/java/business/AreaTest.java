package business;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.where.where_web.business.service.AreaService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class AreaTest {
	@Inject
	private AreaService areaService;
	@Test
	public void testSelect(){
		System.out.println(areaService.selectByCode(110105));
	}
}
