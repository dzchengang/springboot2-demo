package com.sdstc.project.dto;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;


/**
 * @author system
 */

public class ProjectProInfoDto  implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 5536143839096518372L;
	/**
	 * 
	 */
	@JsonSerialize(using = ToStringSerializer.class)
    private Long id;
    /**
	 * 客户ID
	 */
    private Long customerId;
    
    private Date gmtCreate;
    private Date gmtModified;
    private String createAccount;
    private String modifiedAccount;
    private String isDelete;
    
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
    @JsonSerialize(using = ToStringSerializer.class)
    private Long projectId;
    
    private String projectName;
    
    //主机限制
    private Integer lreHostsLimit;
    //测试许可数量
    private Integer lreVusersLimit;
    //并发许可数量
    private Integer lreConcurrentRunsLimit;
    
    
    private List<ProjectUserDto> projectUsers;
    
    private Long domainId;

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

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModified() {
		return gmtModified;
	}

	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}

	public String getCreateAccount() {
		return createAccount;
	}

	public void setCreateAccount(String createAccount) {
		this.createAccount = createAccount;
	}

	public String getModifiedAccount() {
		return modifiedAccount;
	}

	public void setModifiedAccount(String modifiedAccount) {
		this.modifiedAccount = modifiedAccount;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getProTypeCode() {
		return proTypeCode;
	}

	public void setProTypeCode(String proTypeCode) {
		this.proTypeCode = proTypeCode;
	}

	public Long getProjectId() {
		return projectId;
	}

	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Integer getLreHostsLimit() {
		return lreHostsLimit;
	}

	public void setLreHostsLimit(Integer lreHostsLimit) {
		this.lreHostsLimit = lreHostsLimit;
	}

	public Integer getLreVusersLimit() {
		return lreVusersLimit;
	}

	public void setLreVusersLimit(Integer lreVusersLimit) {
		this.lreVusersLimit = lreVusersLimit;
	}

	public Integer getLreConcurrentRunsLimit() {
		return lreConcurrentRunsLimit;
	}

	public void setLreConcurrentRunsLimit(Integer lreConcurrentRunsLimit) {
		this.lreConcurrentRunsLimit = lreConcurrentRunsLimit;
	}

	public List<ProjectUserDto> getProjectUsers() {
		return projectUsers;
	}

	public void setProjectUsers(List<ProjectUserDto> projectUsers) {
		this.projectUsers = projectUsers;
	}

	public Long getDomainId() {
		return domainId;
	}

	public void setDomainId(Long domainId) {
		this.domainId = domainId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
    
}
