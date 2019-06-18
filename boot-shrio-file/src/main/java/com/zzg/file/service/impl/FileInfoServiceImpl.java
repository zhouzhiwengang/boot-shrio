package com.zzg.file.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zzg.common.service.impl.BaseService;

import com.zzg.file.dao.FileInfoMapper;
import com.zzg.file.domain.FileInfo;
import com.zzg.file.service.FileInfoService;

@Service("fileInfoService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class FileInfoServiceImpl extends BaseService<FileInfo> implements FileInfoService {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private FileInfoMapper fileInfoMapper;
}
