package com.sdstc.word.wordchart;

import lombok.Data;

@Data
public class ColDto {
   /**
    * 列名	
    */
   private String  name;
   
   /**
	 * 对应标签的c:f 取值范围
	 */
   private String  colSheetIndex;

	/**
	 * 对应标签的c:f 取值范围
	 */
	private String rowNameSheetIndex;
	/**
	 * 对应标签的c:f 取值范围
	 */
	private String rowDataSheetIndex;
}
