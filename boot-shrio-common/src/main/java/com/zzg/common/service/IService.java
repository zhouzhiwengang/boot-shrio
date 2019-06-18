package com.zzg.common.service;

import java.util.List;

import org.springframework.stereotype.Service;

/**
 * 
 * @ClassName:  IService   
 * @Description: 通用公共service 实现   
 * @author: 世纪伟图 -zzg
 * @date:   2019年6月14日 上午9:53:40   
 *   
 * @param <T>  
 * @Copyright: 2019 www.digipower.cn 
 * 注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
 */
@Service
public interface IService<T> {
	List<T> selectAll();

	T selectByKey(Object key);

	int save(T entity);

	int delete(Object key);

	int batchDelete(List<String> list, String property, Class<T> clazz);

	int updateAll(T entity);

	int updateNotNull(T entity);

	List<T> selectByExample(Object example);

}
