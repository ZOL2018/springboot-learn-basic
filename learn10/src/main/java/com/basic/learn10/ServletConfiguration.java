package com.basic.learn10;

import com.basic.learn10.servlet.TestServlet;
import org.omg.CORBA.PUBLIC_MEMBER;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ServletComponentScan //自动扫描servlet 服务
public class ServletConfiguration {
//    @Bean
//    public ServletRegistrationBean servletRegistrationBean(){
//        return new ServletRegistrationBean(new TestServlet(),"/test");
//    }
}
