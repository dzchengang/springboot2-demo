package com.sdstc.sys.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdstc.sys.model.File;
import com.sdstc.sys.model.FileRelation;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileDaoTest {
	@Autowired
	private FileDao fileDao;

	@Test
	public void testInsert() {
		File file=new File();
		file.setId("2");
		file.setTenantId(2);
		file.setName("file2");
		
		fileDao.insertFile(file);
		
		FileRelation fr=new FileRelation();
		fr.setId("2");
		fr.setTenantId(2);
		fr.setFileId("2");
		fr.setName("fr2");
		
		fileDao.insertFileRelation(fr);
	}

	@Test
	public void sel() {
		fileDao.selFile("fr2", 2);
	}
}
