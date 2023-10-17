package com.hfs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;

@WebListener
public class MyListener implements ServletContextListener, HttpSessionListener, HttpSessionAttributeListener {

    public MyListener() {
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        try {
            System.out.println(System.getProperty("java.class.path"));
            Tools.terminalLogOut("zhe shi init module!" + "这是初识化模块");
        } catch (UnsupportedEncodingException e) {
            System.out.println("chu shi hua module error!");
        }
        try {
            //获取配置文件的绝对路径
            URL resource = getClass().getResource("conf.json");
            System.out.println("conf json"+resource.getPath());
            String osName = System.getProperty("os.name");
            if (osName.toLowerCase().startsWith("windows")) {
                // 当前系统是Windows
                String[] split = String.valueOf(resource).split("file:/");
                Tools.init(split[1]);
            } else if (osName.toLowerCase().startsWith("linux")) {
                // 当前系统是Linux
                String[] split = String.valueOf(resource).split("file:/");
                Tools.init("/"+split[1]);
            }

        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        /* This method is called when the servlet Context is undeployed or Application Server shuts down. */
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        /* Session is created. */
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        /* Session is destroyed. */
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is added to a session. */
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is removed from a session. */
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent sbe) {
        /* This method is called when an attribute is replaced in a session. */
    }


}
