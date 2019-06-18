package com.zzg.job.dao;

import java.util.List;
import com.common.dao.MyMapper;
import com.zzg.job.domain.Job;

public interface JobMapper extends MyMapper<Job> {
	
	List<Job> queryList();
}