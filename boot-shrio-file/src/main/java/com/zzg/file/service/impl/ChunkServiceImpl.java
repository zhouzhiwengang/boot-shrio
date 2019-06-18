package com.zzg.file.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.zzg.common.service.impl.BaseService;
import com.zzg.file.dao.ChunkMapper;
import com.zzg.file.domain.Chunk;
import com.zzg.file.service.ChunkService;


@Service("chunkService")
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ChunkServiceImpl extends BaseService<Chunk> implements ChunkService {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private ChunkMapper chunkMapper;

	@Override
	public Chunk findChunkDomain(Chunk chunk) {
		// TODO Auto-generated method stub
		return chunkMapper.findChunkDomain(chunk);
	}
	
	

}
