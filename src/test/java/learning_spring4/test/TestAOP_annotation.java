package learning_spring4.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.xywei.service.UserServiceAnnotation;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(value = { "classpath:applicationContext_aop_annotation.xml" })
public class TestAOP_annotation {

	@Autowired
	private UserServiceAnnotation userServiceImplAnnotation;

	@Test
	public void testAnnotationAOP() {
		userServiceImplAnnotation.saveUser();
//		userServiceImplAnnotation.findUser();
//		userServiceImplAnnotation.deleteUser();
	}

}
