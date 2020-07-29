package com.sdstc.word.wordchart;

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
		reportUtil.genChart();

	}

	@Test
	public void genColors() {
		reportUtil.genColors();
	}

	@Test
	public void genStyle() {
		reportUtil.genStyle();
	}
	
}
