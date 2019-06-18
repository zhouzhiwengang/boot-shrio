package com.zzg.common.handler;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.session.ExpiredSessionException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.zzg.common.domain.ResponseBo;
import com.zzg.common.exception.FileDownloadException;
import com.zzg.common.util.HttpUtils;

/**
 * 
 * @ClassName:  GlobalExceptionHandler   
 * @Description: 系统全局异常处理
 * @author: 世纪伟图 -zzg
 * @date:   2019年6月14日 下午2:54:52   
 *     
 * @Copyright: 2019 www.digipower.cn 
 * 注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
 */
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {
	// 认证异常
	@ExceptionHandler(value = AuthorizationException.class)
	public Object handleAuthorizationException(HttpServletRequest request) {
		if (HttpUtils.isAjaxRequest(request)) {
			return ResponseBo.error("暂无权限，请联系管理员！");
		} else {
			ModelAndView mav = new ModelAndView();
			mav.setViewName("error/403");
			return mav;
		}
	}
	// 会话异常
	@ExceptionHandler(value = ExpiredSessionException.class)
	public String handleExpiredSessionException() {
		return "login";
	}
	
	// 文件下载异常
	@ExceptionHandler(value = FileDownloadException.class)
	public ResponseBo handleFileDownloadException(FileDownloadException e){
		return ResponseBo.error(e.getMessage());
	}
}
