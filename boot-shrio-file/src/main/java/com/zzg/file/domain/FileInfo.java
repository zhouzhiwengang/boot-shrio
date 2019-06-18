package com.zzg.file.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "t_fileinfo")
public class FileInfo implements Serializable {
	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = -8296723727863992359L;

	@Id
	@GeneratedValue(generator = "JDBC")
	private Long id;

	@Column(nullable = false)
    private String filename;

	@Column(nullable = false)
    private String identifier;

	@Column(nullable = false)
    private Long totalSize;

	@Column(nullable = false)
    private String type;

	@Column(nullable = false)
    private String location;

	public Long getId() {
		return id;
	}

	// set 和  get 方法
	public void setId(Long id) {
		this.id = id;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public Long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
