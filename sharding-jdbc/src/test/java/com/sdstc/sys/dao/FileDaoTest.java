package com.sdstc.sys.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdstc.sys.model.File;
import com.sdstc.sys.model.FileRelation;
import com.sdstc.sys.model.Product;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FileDaoTest {
	@Autowired
	private FileDao fileDao;

	@Test
	public void testInsert() {
		File file = new File();
		file.setId("2");
		file.setTenantId(2);
		file.setName("file2");

		fileDao.insertFile(file);

		FileRelation fr = new FileRelation();
		fr.setId("2");
		fr.setTenantId(2);
		fr.setFileId("2");
		fr.setName("fr2");

		fileDao.insertFileRelation(fr);
	}

	@Test
	public void sel() {
		List<Product> results = fileDao.getProduct();
		System.out.println(results);
	}

	@Test
	public void test1() {
		File file = new File();
		file.setId("6");
		file.setTenantId(6);
		file.setName("file2");

		File file1 = new File();
		file1.setId("7");
		file1.setTenantId(7);
		file1.setName("file3");

		List<File> files = new ArrayList<File>();
		files.add(file);
		files.add(file1);

		File fileDto = new File();
		fileDto.setFiles(files);

		fileDao.insertFiles(fileDto);

	}
}
