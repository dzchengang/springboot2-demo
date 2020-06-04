package com.sdstc.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.sdstc.sys.model.File;
import com.sdstc.sys.model.FileRelation;
import com.sdstc.sys.model.Product;



public interface FileDao {
	void insertFile(File dto);
	void insertFileRelation(FileRelation dto);
	List<File> selFile(@Param("name")String name,@Param("tenantId")Integer tenantId);
	void insertFiles(File dto);
	
	List<Product> getProduct();
}
