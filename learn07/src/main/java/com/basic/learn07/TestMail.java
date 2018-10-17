package com.basic.learn07;

import com.basic.learn07.core.MailContentTypeEnum;
import com.basic.learn07.core.MailSender;

import java.util.ArrayList;

public class TestMail {
    public static void main(String[] args) throws Exception{
        new MailSender()
                .title("测试")
                .content("测试")
                .contentType(MailContentTypeEnum.TEXT)
                .targets(new ArrayList<String>(){{
                    add("501139260@qq.com");
                }})
                .send();
        System.out.println("send!");
    }
}
