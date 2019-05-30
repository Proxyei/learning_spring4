package learning_spring4.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xywei.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "classpath:applicationContext_aop_xml.xml" })
public class TestAOP_xml {

	@Autowired
	private UserService userService;

	@Test
	public void testAOPXML() {
		// 前置通知，最终通知
		userService.saveUser();
		// 后置带返回值
		userService.findUser();
		//环绕增强
		userService.updateUser();
		//异常抛出通知
		userService.deleteUser();
	}

}
