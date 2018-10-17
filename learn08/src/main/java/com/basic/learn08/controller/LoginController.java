package com.basic.learn08.controller;

import com.alibaba.fastjson.JSONObject;
import com.basic.learn08.entity.UserEntity;
import com.basic.learn08.jpa.UserJPA;
import com.basic.learn08.utils.LoggerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.servlet.http.HttpServletRequest;
import java.util.Optional;

@RestController
@RequestMapping(value = "/user")
public class LoginController {
    @Autowired
    private UserJPA userJPA;

    /**
     * 未解决 name 不唯一 的bug //可使用唯一name 进行登录验证
     * @param user
     * @param request
     * @return
     */
    @RequestMapping(value = "/login")
    public JSONObject login(UserEntity user, HttpServletRequest request) {

        JSONObject obj = new JSONObject();
        obj.put("msg","用户:"+ user.getName()+"登录成功");
        request.setAttribute(LoggerUtils.LOGGER_RETURN, obj);
        return obj;
    }
}
