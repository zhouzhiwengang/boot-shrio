package com.zzg.common.domain;

import java.io.Serializable;

import com.google.common.base.MoreObjects;

/**
 * 
 * @ClassName:  QueryRequest   
 * @Description: 通用查询请求对象
 * @author: 世纪伟图 -zzg
 * @date:   2019年6月14日 上午10:01:05   
 *     
 * @Copyright: 2019 www.digipower.cn 
 * 注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
 */
public class QueryRequest implements Serializable {

	/**   
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)   
	 */   
	private static final long serialVersionUID = 3488916415975077242L;
	
	private int pageSize;
	private int pageNum;

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("pageSize", pageSize)
				.add("pageNum", pageNum)
				.toString();
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}
}
