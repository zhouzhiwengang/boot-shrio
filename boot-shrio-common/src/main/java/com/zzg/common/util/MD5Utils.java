package com.zzg.common.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * 
 * @ClassName:  MD5Utils   
 * @Description: md5 + 盐值 加密   
 * @author: 世纪伟图 -zzg
 * @date:   2019年6月14日 上午10:52:36   
 *     
 * @Copyright: 2019 www.digipower.cn 
 * 注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
 */
public class MD5Utils {
	protected MD5Utils(){

	}

	private static final String SALT = "mrbird";

	private static final String ALGORITH_NAME = "md5";

	private static final int HASH_ITERATIONS = 2;

	public static String encrypt(String pswd) {
		return new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(SALT), HASH_ITERATIONS).toHex();
	}

	public static String encrypt(String username, String pswd) {
		return new SimpleHash(ALGORITH_NAME, pswd, ByteSource.Util.bytes(username.toLowerCase() + SALT),
				HASH_ITERATIONS).toHex();
	}
}
