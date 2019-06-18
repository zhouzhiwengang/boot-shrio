package com.zzg.shrio.listener;

import java.util.concurrent.atomic.AtomicInteger;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

/**
 * 
 * @ClassName:  ShiroSessionListener   
 * @Description: 统计系统实时使用人数  
 * @author: 世纪伟图 -zzg
 * @date:   2019年6月14日 下午3:08:48   
 *     
 * @Copyright: 2019 www.digipower.cn 
 * 注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
 */
public class ShiroSessionListener implements SessionListener{

	private final AtomicInteger sessionCount = new AtomicInteger(0);
	
	@Override
	public void onStart(Session session) {
		sessionCount.incrementAndGet();
	}

	@Override
	public void onStop(Session session) {
		sessionCount.decrementAndGet();
		
	}

	@Override
	public void onExpiration(Session session) {
		sessionCount.decrementAndGet();
	}
}
