package com.zzg.elasticjob.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_job_task")
public class JobTask implements Serializable  {

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 1594831999137384253L;
	
	@Id
	@GeneratedValue(generator = "JDBC")
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "CONTENT")
	private String content;
	
	@Column(name = "BEAN_NAME")
	private String beanName;
	
	@Column(name = "CRON_EXPRESSION")
	private String cronExpression;
	/**
	 * 0-未执行 1-已执行
	 */
	@Column(name = "STATUS")
	private Integer status;
	
	@Column(name = "SEND_TIME")
	private Date sendTime;
	
	// set 和   get 请求

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}
	
	public String getBeanName() {
		return beanName;
	}

	public void setBeanName(String beanName) {
		this.beanName = beanName;
	}

}
