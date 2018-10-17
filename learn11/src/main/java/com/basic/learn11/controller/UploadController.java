package com.basic.learn11.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.UUID;

@Controller
public class UploadController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(){
        return "index";
    }

    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody String upload(HttpServletRequest request, MultipartFile file){
        try {
            //上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") +"upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if(!dir.exists())
            {
                dir.mkdir();
            }
            //调用上传方法
            executeUpload(uploadDir,file);
        }catch (Exception e)
        {
            //打印错误堆栈信息
            e.printStackTrace();
            return "upload failure";
        }
        return "upload successful";
    }

    @RequestMapping(value = "/uploads",method = RequestMethod.POST)
    public @ResponseBody String uploads(HttpServletRequest request,MultipartFile[] file)
    {
        try {
            //上传目录地址
            String uploadDir = request.getSession().getServletContext().getRealPath("/") +"upload/";
            //如果目录不存在，自动创建文件夹
            File dir = new File(uploadDir);
            if(!dir.exists())
            {
                dir.mkdir();
            }
            //遍历文件数组执行上传
            for (int i =0;i<file.length;i++) {
                if(file[i] != null) {
                    //调用上传方法
                    executeUpload(uploadDir, file[i]);
                }
            }
        }catch (Exception e)
        {
            //打印错误堆栈信息
            e.printStackTrace();
            return "上传失败";
        }
        return "上传成功";
    }

    private void executeUpload(String uploadDir,MultipartFile file) throws Exception
    {
        //文件后缀名
        String suffix = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
        //上传文件名
        String filename = UUID.randomUUID() + suffix;
        //服务器端保存的文件对象
        File serverFile = new File(uploadDir + filename);
        //将上传的文件写入到服务器端文件内
        file.transferTo(serverFile);
    }
}
