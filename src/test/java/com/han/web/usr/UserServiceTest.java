package com.han.web.usr;

import static org.junit.Assert.*;
import javax.servlet.ServletContext;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import com.han.web.cfg.ServletConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ServletConfig.class}, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
public class UserServiceTest {
	@Autowired UserService userService;
	@Test
	public void testTest() {
		assertThat(null, not(equalTo(5)));
	}
	public void testSelectAll() {
		assertThat(userService.selectAll(), is(equalTo(1)));
	}
}
