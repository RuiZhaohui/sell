package com.zcc.mobile.sell.web;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.awt.*;
import java.net.URI;

/**
 * @author Devin sun
 * @date 2022/2/27
 */
@SpringBootApplication(scanBasePackages = {"com.zcc.mobile"})
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(Application.class).run(args);
        int port = context.getEnvironment().getProperty("server.port", int.class);
        System.setProperty("java.awt.headless", "false");
//        try {
//            Desktop.getDesktop().browse(new URI("http://127.0.0.1:" + port));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }
}
