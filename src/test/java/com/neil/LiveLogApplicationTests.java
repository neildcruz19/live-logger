package com.neil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.livelog.LiveLogApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = LiveLogApplication.class)
@WebAppConfiguration
public class LiveLogApplicationTests {

	@Test
	public void contextLoads() {
	}

}
