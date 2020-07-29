package com.sdstc.word.wordchart;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdstc.word.pub.FreeMarker;

/**
 * 
 * @author cheng
 *
 */
@Service("reportUtil")
public class ReportUtil {
	private  String reportType;
	
	public void setReportType(String reportType) {
		this.reportType=reportType;
	}
	
	@Autowired
	private FreeMarker freeMarker;

	
	public void genChart() {
		String result = freeMarker.process("/wordchartTemp/bar/style1.xml", new HashMap());
		System.out.println(result);
	}

	public void genColors() {
		String result = freeMarker.process("/wordchartTemp/bar/colors1.xml", new HashMap());
		System.out.println(result);
	}

	public void genStyle() {
		String result = freeMarker.process("/wordchartTemp/bar/style1.xml", new HashMap());
		System.out.println(result);
	}

	public void genChartRes() {
		String result = freeMarker.process("/wordchartTemp/bar/chart.xml.rels", new HashMap());
		System.out.println(result);
	}
	
	
}
