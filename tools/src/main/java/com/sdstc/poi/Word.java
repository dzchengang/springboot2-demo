package com.sdstc.poi;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ooxml.POIXMLDocument;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

public class Word {
	public static void main(String[] args) {
		try {
			// 解析docx模板并获取document对象
			String path = Word.class.getResource("./report.docx").getPath();
			XWPFDocument document = new XWPFDocument(POIXMLDocument.openPackage(path));
			// 获取整个文本对象
			List<XWPFParagraph> allParagraph = document.getParagraphs();

			// 获取XWPFRun对象输出整个文本内容
			StringBuffer tempText = new StringBuffer();
			for (XWPFParagraph xwpfParagraph : allParagraph) {
				List<XWPFRun> runList = xwpfParagraph.getRuns();
				for (XWPFRun xwpfRun : runList) {
					tempText.append(xwpfRun.toString() + "\n");
				}
			}
			System.out.println(tempText.toString());

			// 获取表格
			List<XWPFTable> tables = document.getTables();
			for (XWPFTable table : tables) {
				//获取行
				List<XWPFTableRow> rows = table.getRows();
				for(XWPFTableRow row:rows) {
					List<XWPFTableCell> cells=row.getTableCells();
					for(XWPFTableCell cell:cells) {
						System.out.println(cell.getText());
					}
				}
			}

			document.close();
			System.out.println("xx");
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
