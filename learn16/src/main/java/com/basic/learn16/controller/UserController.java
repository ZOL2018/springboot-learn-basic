package com.basic.learn16.controller;

import com.basic.learn16.entity.UserEntity;
import com.basic.learn16.jpa.UserJPA;
import com.basic.learn16.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserJPA userJPA;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
//    public List<UserEntity> list(){
//        return userJPA.findAll();
//    }
    public List<UserEntity> list(){
        return userService.list();
    }

    @RequestMapping(value = "/save",method = RequestMethod.GET)
    public UserEntity save(UserEntity userEntity){
        return userJPA.save(userEntity);
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public List<UserEntity> delete(Long id){
        userJPA.delete(id);
        return userJPA.findAll();
    }
    @RequestMapping(value = "/ages")
    public List<UserEntity> ages(){
        return userJPA.nativeQuery(50);
    }

    @RequestMapping(value = "/del")
    public String del(){
        userJPA.deleteQuery("test1","123");
        return "success";
    }

    /**
     * 分页功能
     * 默认分页 不可修改 但会返回设置的页码数
     * @param page
     * @return
     */
    @RequestMapping(value = "/pages")
    public List<UserEntity> pages(int page){
        UserEntity userEntity = new UserEntity();
        userEntity.setSize(5);
        userEntity.setPage(page);
        Sort.Direction sortDirection = Sort.Direction.ASC.toString().equalsIgnoreCase(userEntity.getSort())?Sort.Direction.ASC:Sort.Direction.DESC;
        //设置排序对象
        Sort sort = new Sort(sortDirection,userEntity.getSelectId());
        //设置分页对象
        PageRequest pageRequest = new PageRequest(userEntity.getPage() - 1,userEntity.getSize(),sort);
        //返回分页数据
        return userJPA.findAll(pageRequest).getContent();
    }
}
