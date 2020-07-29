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
		//reportUtil.genChart();

	}

	@Test
	public void genColors() {
		//reportUtil.genColors();
	}

	@Test
	public void genStyle() {
		//reportUtil.genStyle();
	}
	
	@Test
	public void genExcel() {
		List<String> colNames=new ArrayList<>();
		colNames.add("cpu");
		colNames.add("内存");
		colNames.add("磁盘");
		
		List<String> rowNames=new ArrayList<>();
		rowNames.add("3:23");
		rowNames.add("3:24");
		rowNames.add("3:25");
		rowNames.add("3:26");
		rowNames.add("3:27");
		rowNames.add("3:28");
		
		List<List<String>> rowDatas=new ArrayList<>();
		
		List<String> data1= Arrays.asList("100","80","70");
		List<String> data2= Arrays.asList("90","80","100");
		List<String> data3= Arrays.asList("100","100","100");
		List<String> data4= Arrays.asList("60","80","70");
		List<String> data5= Arrays.asList("100","20","0");
		List<String> data6= Arrays.asList("0","80","70");
		
		rowDatas.add(data1);
		rowDatas.add(data2);
		rowDatas.add(data3);
		rowDatas.add(data4);
		rowDatas.add(data5);
		rowDatas.add(data6);
		
		TableDto dto=new TableDto("aa","xxx", colNames, rowNames, rowDatas);
        
		
		
		System.out.println(reportUtil.genChart(dto,"bar"));
		
	}
	
}
