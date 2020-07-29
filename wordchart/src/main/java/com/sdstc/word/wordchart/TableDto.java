package com.sdstc.word.wordchart;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import lombok.Data;

/**
 * 
 * @author cheng
 *
 */

@Data
public class TableDto {
	private String  lastIndex;
	/**
	 * 标题
	 */
	private String title;

	/**
	 * 列
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
	 * 行标题
	 */
	private List<String> rowNames;

	public TableDto(String lastIndex,String title, List<String> colNames,List<String> rowNames,List<List<String>> rowDatas) {
		List<ColDto> cols=colNames.stream().map(colName->{
			return new ColDto(colName);
		}).collect(Collectors.toList());
		
		AtomicInteger index=new AtomicInteger(0);
		List<RowDto> rows=rowDatas.stream().map(rowData->{
			String rowName=rowNames.get(index.get());
			index.incrementAndGet();
			return new RowDto(rowName,rowData);
		}).collect(Collectors.toList());
		
		this.lastIndex=lastIndex;
		this.title = title;
		this.cols = cols;
		this.rows = rows;
		handleData();
	}
	
	public TableDto(String lastIndex,String title, List<ColDto> cols, List<RowDto> rows) {
		this.lastIndex=lastIndex;
		this.title = title;
		this.cols = cols;
		this.rows = rows;
		handleData();
	}
	
	/**
	 * 数据转换
	 */
	public void handleData() {
		List<ColDto> cols = this.getCols();
		int rowSize = this.getRows().size();
		
		//设置行名
        this.rowNames=this.getRows().stream().map(row->{
        	return row.getRowName();
        }).collect(Collectors.toList());	
        
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
			//设置该列的数据
			final int j=i;
			List<String> colRowData=this.rows.stream().map(row->{
				return row.getDatas().get(j);
			}).collect(Collectors.toList());
			colDto.setRowDatas(colRowData);
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

	

	
	
}
