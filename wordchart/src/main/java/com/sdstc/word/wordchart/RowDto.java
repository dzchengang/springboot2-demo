package com.sdstc.word.wordchart;

import java.util.List;

import lombok.Data;

/**
 * 
 * @author cheng
 *
 */

@Data
public class RowDto {
	/**
	 * 行名称
	 */
	private String rowName;
	/**
	 * 数据
	 */
	private List<String> datas;

	public RowDto(String rowName, List<String> datas) {
		this.rowName = rowName;
		this.datas = datas;
	}
	
	public RowDto(List<String> datas) {
		this.datas = datas;
	}
}
