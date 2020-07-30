package com.sdstc.word.wordchart;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdstc.word.pub.FreeMarker;

import lombok.extern.log4j.Log4j2;

/**
 * 
 * @author cheng
 *
 */
@Service("reportUtil")
@Log4j2
public class ReportUtil {

	@Autowired
	private FreeMarker freeMarker;

	// 生成chart
	public String genChart(TableDto dto, String reportType) {
		return freeMarker.process("/wordchartTemp/" + reportType + "/chart.xml", dto);
	}

	public void genChart(TableDto dto, String reportType, File file) {
		freeMarker.process("/wordchartTemp/" + reportType + "/chart.xml", dto, file);
	}

	// 生成colors
	public String genColors(TableDto dto, String reportType) {
		return freeMarker.process("/wordchartTemp/" + reportType + "/colors.xml", dto);
	}

	public void genColors(TableDto dto, String reportType, File file) {
		freeMarker.process("/wordchartTemp/" + reportType + "/colors.xml", dto, file);
	}

	// 生成style
	public String genStyle(TableDto dto, String reportType) {
		return freeMarker.process("/wordchartTemp/" + reportType + "/style.xml", dto);
	}

	public void genStyle(TableDto dto, String reportType, File file) {
		freeMarker.process("/wordchartTemp/" + reportType + "/style.xml", dto, file);
	}

	// 生成chartRes
	public String genChartRes(TableDto dto, String reportType) {
		return freeMarker.process("/wordchartTemp/" + reportType + "/chart.xml.rels", dto);
	}

	public void genChartRes(TableDto dto, String reportType, File file) {
		freeMarker.process("/wordchartTemp/" + reportType + "/chart.xml.rels", dto, file);
	}
	
	//生成 document 片段
	public String genDoc(TableDto dto, String reportType) {
		return freeMarker.process("/wordchartTemp/" + reportType + "/document.xml", dto);
	}
	
	//生成 document rels片段
	public String genDocRels(TableDto dto, String reportType) {
		return freeMarker.process("/wordchartTemp/" + reportType + "/document.xml.rels", dto);
	}

	public void genExcel(TableDto dto, File file) {
		try {
			SXSSFWorkbook workbook = new SXSSFWorkbook();
			SXSSFSheet sheet = workbook.createSheet("Sheet1");
			// 创建表头
			Row headRow = sheet.createRow(0);
			for (int i = 0; i < dto.getCols().size(); i++) {
				Cell cell = headRow.createCell((i + 1));
				cell.setCellValue(dto.getCols().get(i).getName());
			}
			
			// 创建数据
			for (int i = 0; i < dto.getRowSize(); i++) {
				Row dataRow = sheet.createRow((i + 1));
				// 第一列名称
				Cell firstCell = dataRow.createCell(0);
				firstCell.setCellValue(dto.getRowNames().get(i));
				// 创建数据
				List<Number> datas = dto.getRowDatas().get(i);
				for (int j = 0; j < datas.size(); j++) {
					Cell dataCell = dataRow.createCell((j + 1));
					Number val=datas.get(j);
					if(val instanceof Integer) {
						dataCell.setCellValue((Integer)val);
					}else if(val instanceof Long) {
						dataCell.setCellValue((Long)val);
					}else if(val instanceof Double) {
						dataCell.setCellValue((Double)val);
					}else if(val instanceof Float) {
						dataCell.setCellValue((Float)val);
					}else {
						log.error("un support this type!");
					}
				}
			}
			workbook.write(new FileOutputStream(file));
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
