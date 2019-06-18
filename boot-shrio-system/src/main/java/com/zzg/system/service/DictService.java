package com.zzg.system.service;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;

import com.zzg.common.domain.QueryRequest;
import com.zzg.common.service.IService;
import com.zzg.system.domain.Dict;

@CacheConfig(cacheNames = "DictService")
public interface DictService extends IService<Dict> {

    @Cacheable(key = "#p0.toString() + (#p1 != null ? #p1.toString() : '')")
    List<Dict> findAllDicts(Dict dict, QueryRequest request);

    @Cacheable(key = "#p0")
    Dict findById(Long dictId);

    @CacheEvict(allEntries = true)
    void addDict(Dict dict);

    @CacheEvict(key = "#p0", allEntries = true)
    void deleteDicts(String dictIds);

    @CacheEvict(key = "#p0", allEntries = true)
    void updateDict(Dict dicdt);
}
