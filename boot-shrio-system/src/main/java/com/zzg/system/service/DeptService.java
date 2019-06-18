package com.zzg.system.service;

import java.util.List;

import com.zzg.common.domain.Tree;
import com.zzg.common.service.IService;
import com.zzg.system.domain.Dept;


public interface DeptService extends IService<Dept> {

	Tree<Dept> getDeptTree();

	List<Dept> findAllDepts(Dept dept);

	Dept findByName(String deptName);

	Dept findById(Long deptId);
	
	void addDept(Dept dept);
	
	void updateDept(Dept dept);

	void deleteDepts(String deptIds);
}
