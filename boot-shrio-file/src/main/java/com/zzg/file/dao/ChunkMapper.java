package com.zzg.file.dao;

import com.common.dao.MyMapper;
import com.zzg.file.domain.Chunk;


public interface ChunkMapper extends MyMapper<Chunk>  {
	
	Chunk findChunkDomain(Chunk chunk);

}
