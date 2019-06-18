package com.zzg.file.service;

import com.zzg.common.service.IService;
import com.zzg.file.domain.Chunk;


public interface ChunkService extends IService<Chunk> {
	Chunk findChunkDomain(Chunk chunk);
}
