package com.sdstc.rabbitmq.fanout;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdstc.Start;
import com.sdstc.dto.User;
import com.sdstc.rabbitmq.redirect.DirectSender;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Start.class })
public class FanoutServiceTest {
	@Autowired
	private FanoutSender fanoutSender;
	@Autowired
    private DirectSender directSender;
	@Test
	public void test() {
		User user=new User();
		user.setId("1");
		user.setName("陈刚");
		//fanoutSender.send(user);
		directSender.send(user);
	}

}
