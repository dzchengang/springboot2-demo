package com.sdstc.project.dto;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author system
 */
@Data
@EqualsAndHashCode(callSuper=false)
public class ProjectProInfoDto extends BaseModel implements Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 5536143839096518372L;
	/**
	 * 
	 */
    private Long id;
    /**
	 * 客户ID
	 */
    private Long customerId;
    /**
	 * 测试项目项目状态 根据各个项目决定
	 */
    private String state;
    /**
	 * 项目类型
	 */
    private String proTypeCode;
    /**
	 * 项目ID
	 */
    private Long projectId;
    
    //主机限制
    private Integer lreHostsLimit;
    //虚拟用户限制
    private Integer lreVusersLimit;
}
