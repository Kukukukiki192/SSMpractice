package com.interceptor;

import com.dao.IIpFilterDao;
import com.domain.IpFilter;
import com.util.IpUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Slf4j
public class IpInterceptor implements HandlerInterceptor {

    @Autowired
    private IIpFilterDao ipFilterDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //过滤ip,若用户在白名单内，则放行 request.getRemoteAddr()
        String ipAddress = IpUtil.getRealIP(request);
//        String ipAddress = request.getRemoteAddr();
        log.info("user IP address: "+ipAddress);
        if(StringUtils.isBlank(ipAddress))
            return false;
//            throw new Exception("IP为空!");
        IpFilter ipFilter=new IpFilter();
        ipFilter.setModule("user-login");//模块
        ipFilter.setIp(ipAddress);//ip地址
        ipFilter.setMark(0);//白名单
        List<IpFilter> ips=ipFilterDao.selectList(ipFilter);
        if(ips.isEmpty()){
            response.getWriter().append("<h1 style=\"text-align:center;\">Not allowed!</h1>");
            log.info("Not allowed!");
//            throw new Exception("非法访问！");
            return false;
        }
        log.info("Allowed!");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
