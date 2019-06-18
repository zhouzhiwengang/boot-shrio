package com.zzg.common.service.redis;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.zzg.common.domain.RedisInfo;

/**
 * 
 * @ClassName:  RedisService   
 * @Description: redis 公共服务接口
 * @author: 世纪伟图 -zzg
 * @date:   2019年6月14日 下午12:25:17   
 *     
 * @Copyright: 2019 www.digipower.cn 
 * 注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
 */
public interface RedisService {
	 /**
     * 获取 redis 的详细信息
     *
     * @return List
     */
    List<RedisInfo> getRedisInfo();

    /**
     * 获取 redis key 数量
     *
     * @return Map
     */
    Map<String, Object> getKeysSize();

    /**
     * 获取 redis 内存信息
     *
     * @return Map
     */
    Map<String, Object> getMemoryInfo();

    /**
     * 获取 key
     * @param pattern 正则
     * @return Set
     */
    Set<String> getKeys(String pattern);

    /**
     * get命令
     *
     * @param key key
     * @return String
     */
    String get(String key);

    /**
     * set命令
     *
     * @param key   key
     * @param value value
     * @return String
     */
    String set(String key, String value);

    /**
     * del命令
     *
     * @param key key
     * @return Long
     */
    Long del(String... key);

    /**
     * exists命令
     *
     * @param key key
     * @return Boolean
     */
    Boolean exists(String key);

    /**
     * pttl命令
     *
     * @param key key
     * @return Long
     */
    Long pttl(String key);

    /**
     * pexpire命令
     *
     * @param key         key
     * @param milliscends 毫秒
     * @return Long
     */
    Long pexpire(String key, Long milliscends);
}
