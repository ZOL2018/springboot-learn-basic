package com.basic.learn06.controller;

import com.basic.learn06.entity.UserEntity;
import com.basic.learn06.jpa.UserJPA;
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
    public String login(UserEntity user, HttpServletRequest request) {
        //登录成功
        boolean flag = true;
        String result = "登录成功！";
        //根据用户名查询用户是否存在
        UserEntity userEntity = userJPA.findOne(new Specification<UserEntity>() {
            @Override
            public Predicate toPredicate(Root<UserEntity> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                criteriaQuery.where(criteriaBuilder.equal(root.get("name"), user.getName()));
                return null;
            }
        });
        //用户不存在
        if(userEntity == null){
            flag = false;
            result = "用户账号不相符，登录失败！";}
        //密码错误
        else if(!userEntity.getPwd().equals(user.getPwd())){
            flag = false;
            result = "用户密码不相符，登录失败";
        }
        //登录成功
        if(flag){
            //将用户写入session
            request.getSession().setAttribute("session_user",userEntity);
        }
        return result;
    }
}
