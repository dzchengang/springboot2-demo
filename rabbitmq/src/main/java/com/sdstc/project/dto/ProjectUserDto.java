package com.sdstc.project.dto;


import java.io.Serializable;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

/**
 * @author system
 */

public class ProjectUserDto implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -8668804724305902300L;
	/**
	 * 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
	 * 客户ID
	 */
    private Long customerId;
    /**
	 * 项目ID
	 */
    @JsonSerialize(using = ToStringSerializer.class)
    private Long projectId;
    /**
	 * 用户账户
	 */
    private String userAccount;
    
    private Long lreProjectId;
    /**
	 * 产品类型
	 */
    private String productType;
    
    private String roleCode;
    
    private String roleCodeName;
    
    private String lreRoleId;
    
    private String lreUserId;
    private String lreUsername;
    
    private String lreUserpwd;
    
    private String lreUserstate;
    
    private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(String userAccount) {
		this.userAccount = userAccount;
	}

	public Long getLreProjectId() {
		return lreProjectId;
	}

	public void setLreProjectId(Long lreProjectId) {
		this.lreProjectId = lreProjectId;
	}

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public String getRoleCode() {
		return roleCode;
	}

	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
	}

	public String getRoleCodeName() {
		return roleCodeName;
	}

	public void setRoleCodeName(String roleCodeName) {
		this.roleCodeName = roleCodeName;
	}

	public String getLreRoleId() {
		return lreRoleId;
	}

	public void setLreRoleId(String lreRoleId) {
		this.lreRoleId = lreRoleId;
	}

	public String getLreUserId() {
		return lreUserId;
	}

	public void setLreUserId(String lreUserId) {
		this.lreUserId = lreUserId;
	}

	public String getLreUsername() {
		return lreUsername;
	}

	public void setLreUsername(String lreUsername) {
		this.lreUsername = lreUsername;
	}

	public String getLreUserpwd() {
		return lreUserpwd;
	}

	public void setLreUserpwd(String lreUserpwd) {
		this.lreUserpwd = lreUserpwd;
	}

	public String getLreUserstate() {
		return lreUserstate;
	}

	public void setLreUserstate(String lreUserstate) {
		this.lreUserstate = lreUserstate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
