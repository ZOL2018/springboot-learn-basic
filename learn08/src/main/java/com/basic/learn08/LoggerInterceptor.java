package com.basic.learn08;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.basic.learn08.entity.LoggerInfoEntity;
import com.basic.learn08.jpa.LoggerJPA;
import com.basic.learn08.utils.LoggerUtils;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoggerInterceptor implements HandlerInterceptor {
    //请求开始时间标识
    private static final String LOGGER_SEND_TIME = "_send_time";
    //请求日志实体标识
    private static final String LOGGER_ENTITY = "_logger_entity";

    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //创建日志实体
        LoggerInfoEntity logger = new LoggerInfoEntity();
        //获取请求sessionId
        String sessionId = httpServletRequest.getRequestedSessionId();
        //请求路径
        String url = httpServletRequest.getRequestURI();
        //获取请求参数信息
        String paramData = JSON.toJSONString(httpServletRequest.getParameterMap(),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue);
        //设置客户端ip
        logger.setClientIp(LoggerUtils.getClientIp(httpServletRequest));
        //设置请求方法
        logger.setMethod(httpServletRequest.getMethod());
        //设置请求类型（json|普通请求）
        logger.setType(LoggerUtils.getRequestType(httpServletRequest));
        //设置请求参数内容json字符串
        logger.setParamData(paramData);
        //设置请求地址
        logger.setUrl(url);
        //设置sessionId
        logger.setSessionId(sessionId);
        //设置请求开始时间
        httpServletRequest.setAttribute(LOGGER_SEND_TIME,System.currentTimeMillis());
        //设置请求实体到request内，方面afterCompletion方法调用
        httpServletRequest.setAttribute(LOGGER_ENTITY,logger);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        //获取请求错误码
        int status = httpServletResponse.getStatus();
        //当前时间
        long currentTime = System.currentTimeMillis();
        //请求开始时间
        long time = Long.valueOf(httpServletRequest.getAttribute(LOGGER_SEND_TIME).toString());
        //获取本次请求日志实体
        LoggerInfoEntity loggerEntity = (LoggerInfoEntity) httpServletRequest.getAttribute(LOGGER_ENTITY);
        //设置请求时间差
        loggerEntity.setTimeConsuming(Integer.valueOf((currentTime - time)+""));
        //设置返回时间
        loggerEntity.setrTime(currentTime + "");
        //设置返回错误码
        loggerEntity.setHttpStatusCode(status+"");
        //设置返回值
        loggerEntity.setrData(JSON.toJSONString(httpServletRequest.getAttribute(LoggerUtils.LOGGER_RETURN),
                SerializerFeature.DisableCircularReferenceDetect,
                SerializerFeature.WriteMapNullValue));
        //执行将日志写入数据库
        LoggerJPA loggerDAO = getDAO(LoggerJPA.class,httpServletRequest);
        loggerDAO.save(loggerEntity);
    }
    /**
     * 根据传入的类型获取spring管理的对应dao
     * @param clazz 类型
     * @param request 请求对象
     * @param <T>
     * @return
     */
    private <T> T getDAO(Class<T> clazz,HttpServletRequest request)
    {
        BeanFactory factory = WebApplicationContextUtils.getRequiredWebApplicationContext(request.getServletContext());
        return factory.getBean(clazz);
    }
}
