package com.sdstc.word.wordchart;

import java.util.List;

import lombok.Data;

/**
 * 
 * @author cheng
 *
 */

@Data
public class TableDto {
	/**
	 * 标题
	 */
	private String title;

	/**
	 * 列标题
	 */
	private List<ColDto> cols;

	/**
	 * 行
	 */
	private List<RowDto> rows;

	/**
	 * 行数
	 */
	private Integer rowSize;

	/**
	 * 处理列
	 */
	public void handleCol() {
		List<ColDto> cols = this.getCols();
		int rowSize = this.getRows().size();
		// 最后一条数据所在excel的行数
		Integer colEndIndex = (rowSize + 1);
		this.setRowSize(rowSize);
		for (int i = 0; i < cols.size(); i++) {
			// 列所在的EXCEL的列名
			String colName = this.index2ColName((i + 1));
			ColDto colDto = cols.get(i);
			colDto.setColSheetIndex("Sheet1!$" + colName + "$1");
			colDto.setRowNameSheetIndex("Sheet1!$A$2:$A$" + colEndIndex);
			colDto.setRowDataSheetIndex("Sheet1!$" + colName + "$2:$" + colName + "$" + colEndIndex);
		}
	}

	/**
	 * excel index转列名
	 * 
	 * @param index
	 * @return
	 */
	public String index2ColName(int index) {
		if (index < 0) {
			return null;
		}
		int num = 65;
		String colName = "";
		do {
			if (colName.length() > 0) {
				index--;
			}
			int remainder = index % 26;
			colName = ((char) (remainder + num)) + colName;
			index = (int) ((index - remainder) / 26);
		} while (index > 0);
		return colName;
	}

	public TableDto(String title, List<ColDto> cols, List<RowDto> rows) {
		this.title = title;
		this.cols = cols;
		this.rows = rows;
	}

}
