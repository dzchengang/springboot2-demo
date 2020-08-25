package com.sdstc.sys.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdstc.sys.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserDaoTest {
	@Autowired
	private UserDao userDao;

	@Test
	public void testInsert() throws FileNotFoundException, IOException {
		User dto=new User();
		dto.setId(4);
		dto.setName("aa");
		byte[] content=IOUtils.toByteArray(new FileInputStream("D://a.jpg"));
		dto.setInfo(Base64.encodeBase64(content));
		//dto.setInfo(Base64.encodeBase64String(content));
		userDao.insert(dto);
	}

	@Test
	public void testSelect() throws FileNotFoundException, IOException {
		User dto=new User();
		dto.setId(4);
		User result=userDao.getUser(dto);
		
		byte[] content=Base64.decodeBase64(result.getInfo());
		
		IOUtils.write(content, new FileOutputStream("D://d.jpg"));
		
		
	}
}
