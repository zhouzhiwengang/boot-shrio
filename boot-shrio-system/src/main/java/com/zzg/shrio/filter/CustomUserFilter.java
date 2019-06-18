package com.zzg.shrio.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.shiro.web.filter.authc.UserFilter;
import com.alibaba.fastjson.JSON;
import com.zzg.common.domain.ResponseBo;
import com.zzg.common.util.HttpUtils;


public class CustomUserFilter extends UserFilter {

	/**
	 * 判断是否是 ajax 请求
	 * 如果是，则返回 403 状态码
	 */
	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		if (HttpUtils.isAjaxRequest((HttpServletRequest) request)) {
			HttpServletResponse httpServletResponse = (HttpServletResponse) response;
			//httpServletResponse.setStatus(HttpStatus.FORBIDDEN.value());
			httpServletResponse.setStatus(403);
			httpServletResponse.setContentType("application/json; charset=utf-8");
			httpServletResponse.getWriter().print(JSON.toJSON(ResponseBo.error()));
			return false;
		} else {
			saveRequestAndRedirectToLogin(request, response);
			return false;
		}
	}
}
