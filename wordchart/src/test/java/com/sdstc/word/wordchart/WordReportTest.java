package com.sdstc.word.wordchart;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sdstc.Start;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = { Start.class })
public class WordReportTest {
	@Autowired
	private ReportUtil reportUtil;

	@Test
	public void genChart() {

	}

	@Test
	public void genColors() {
	}

	@Test
	public void genStyle() {
	}
	
	@Test
	public void genExcel() {
		List<String> colNames=new ArrayList<>();
		colNames.add("系列1");
		colNames.add("系列2");
		colNames.add("系列3");
		
		List<String> rowNames=new ArrayList<>();
		rowNames.add("类别1");
		rowNames.add("类别2");
		rowNames.add("类别3");
		rowNames.add("类别4");
		
		List<List<Number>> rowDatas=new ArrayList<>();
		
		List<Number> data1= Arrays.asList(100,8,70);
		List<Number> data2= Arrays.asList(90,80.5,100);
		List<Number> data3= Arrays.asList(100,100.78,100);
		List<Number> data4= Arrays.asList(6.90,80,70);
		
		rowDatas.add(data1);
		rowDatas.add(data2);
		rowDatas.add(data3);
		rowDatas.add(data4);
		
		String lastIndex="abc";
		String type="bar";
		
		TableDto dto=new TableDto(lastIndex,"xxx", colNames, rowNames, rowDatas);
		
		//File excelFile=new File("D:/test/ExcelBar"+lastIndex+".xlsx");
		//reportUtil.genExcel(dto, excelFile);
		
		File chartFile=new File("D:/test/chart"+lastIndex+".xml");
		reportUtil.genChart(dto,type,chartFile);
		
		/*
		File excelFile=new File("D:/test/ExcelBar"+lastIndex+".xlsx");
		reportUtil.genExcel(dto, excelFile);
		File chartRelsFile=new File("D:/test/chart"+lastIndex+".xml.rels");
		reportUtil.genChartRes(dto,type,chartRelsFile);
		File colorsFile=new File("D:/test/colorsBar"+lastIndex+".xml");
		reportUtil.genColors(dto, type, colorsFile);
		File styleFile=new File("D:/test/styleBar"+lastIndex+".xml");
		reportUtil.genStyle(dto, type, styleFile);
		
		System.out.println(reportUtil.genDoc(dto, type));
		System.out.println(reportUtil.genDocRels(dto, type));
		 * */
		
	}
	
}
