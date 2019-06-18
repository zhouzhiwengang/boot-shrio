package com.common.dao;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zzg.common.domain.QueryRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
/**
 * 
 * @ClassName:  BaseController   
 * @Description: 基础功能controller 
 * @author: 世纪伟图 -zzg
 * @date:   2019年6月14日 上午11:45:50   
 *     
 * @Copyright: 2019 www.digipower.cn 
 * 注意：本内容仅限于深圳市世纪伟图科技开发有限公司内部使用，禁止用于其他的商业目的
 */
public class BaseController {
	protected static Subject getSubject() {
        return SecurityUtils.getSubject();
    }


//    protected User getCurrentUser() {
//        return  (User)getSubject().getPrincipal();
//    }

    protected Session getSession() {
        return getSubject().getSession();
    }

    protected Session getSession(Boolean flag) {
        return getSubject().getSession(flag);
    }

    protected void login(AuthenticationToken token) {
        getSubject().login(token);
    }

    private Map<String, Object> getDataTable(PageInfo<?> pageInfo) {
        Map<String, Object> rspData = new HashMap<>();
        rspData.put("rows", pageInfo.getList());
        rspData.put("total", pageInfo.getTotal());
        return rspData;
    }

    protected Map<String, Object> selectByPageNumSize(QueryRequest request, Supplier<?> s) {
        PageHelper.startPage(request.getPageNum(), request.getPageSize());
        PageInfo<?> pageInfo = new PageInfo<>((List<?>) s.get());
        PageHelper.clearPage();
        return getDataTable(pageInfo);
    }
}
