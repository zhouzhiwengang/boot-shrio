package com.zzg.file.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Table(name = "t_chunk")
public class Chunk implements Serializable {

	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = 1272190992448172777L;
	
	@Id
	@GeneratedValue(generator = "JDBC")
	private Long id;
	/**
	 * 当前文件块，从1开始
	 */
	@Column(nullable = false)
	private Integer chunkNumber;
	/**
	 * 分块大小
	 */
	@Column(nullable = false)
	private Long chunkSize;
	/**
	 * 当前分块大小
	 */
	@Column(nullable = false)
	private Long currentChunkSize;
	/**
	 * 总大小
	 */
	@Column(nullable = false)
	private Long totalSize;
	/**
	 * 文件标识
	 */
	@Column(nullable = false)
	private String identifier;
	/**
	 * 文件名
	 */
	@Column(nullable = false)
	private String filename;
	/**
	 * 相对路径
	 */
	@Column(nullable = false)
	private String relativePath;
	/**
	 * 总块数
	 */
	@Column(nullable = false)
	private Integer totalChunks;
	/**
	 * 文件类型
	 */
	@Column
	private String type;

	@Transient
	private MultipartFile file;

	// set 和 get 方法
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getChunkNumber() {
		return chunkNumber;
	}

	public void setChunkNumber(Integer chunkNumber) {
		this.chunkNumber = chunkNumber;
	}

	public Long getChunkSize() {
		return chunkSize;
	}

	public void setChunkSize(Long chunkSize) {
		this.chunkSize = chunkSize;
	}

	public Long getCurrentChunkSize() {
		return currentChunkSize;
	}

	public void setCurrentChunkSize(Long currentChunkSize) {
		this.currentChunkSize = currentChunkSize;
	}

	public Long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getRelativePath() {
		return relativePath;
	}

	public void setRelativePath(String relativePath) {
		this.relativePath = relativePath;
	}

	public Integer getTotalChunks() {
		return totalChunks;
	}

	public void setTotalChunks(Integer totalChunks) {
		this.totalChunks = totalChunks;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	
	

}
