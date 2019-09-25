package com.sdstc.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class FreemarkerTest {
	public static void main(String[] args) {
		try {
			Configuration configuration = new Configuration(Configuration.getVersion());
			String path = FreemarkerTest.class.getResource("./").getPath();
			configuration.setDirectoryForTemplateLoading(new File(path));
			Template template = configuration.getTemplate("report.xml");
			
			Map dataModel = new HashMap();
			dataModel.put("hello", "this is my first freemarker test.");
			
			
			Writer out = new FileWriter(new File("D:\\report.xml"));
			template.process(dataModel, out);
			out.close();
		} catch (IOException | TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
