package com.sdstc.word.pub;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import freemarker.cache.FileTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * 
 * @author cheng
 *
 */
@Service
public class FreeMarker {

	@Autowired
	private Configuration configuration;

	/**
	 * 生成freemark文件
	 * 
	 * @param tempPath
	 * @param dataModel
	 * @param out
	 * @return
	 */
	public boolean process(String tempPath, Object dataModel, Writer out) {
		boolean success = false;
		try {
			configuration.setAPIBuiltinEnabled(true);
			configuration.setDefaultEncoding("UTF-8");
			Template template = configuration.getTemplate(tempPath, "UTF-8");
			template.process(dataModel, out);
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	public String process(String tempPath, Object dataModel) {
		StringWriter sw = new StringWriter();
		process(tempPath, dataModel, sw);
		return sw.toString();
	}

	public void process(String tempPath, Object dataModel, File outFile) {
		try {
			FileWriter fw = new FileWriter(outFile);
			process(tempPath, dataModel, fw);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
