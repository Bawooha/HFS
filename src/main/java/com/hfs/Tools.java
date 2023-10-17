package com.hfs;

import com.alibaba.fastjson.JSON;
import com.sun.istack.internal.Nullable;
import sun.nio.cs.ext.GBK;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

public class Tools {
    public static String BASE_PATH;

    public static boolean DEFAULT;

    public static int MAX_NUM_OF_FLIES;

    public static void init(String absolutePath) throws UnsupportedEncodingException {
        byte[] data;
        try{

            //
            Tools.terminalLogOut("接收到的配置文件绝对路径："+absolutePath);

            File file = new File(absolutePath);
            FileInputStream fis = new FileInputStream(file);
            //创建缓冲区，准备接受配置文件
            data = new byte[(int) file.length()];
            //读入配置文件
            fis.read(data);
            // 关闭输入流
            fis.close();
        } catch (IOException e) {
            Tools.terminalLogOut("wu fa jia zai conf.json");
            return;
        }
        String json;
        // 将字节数组转换为字符串
        json = new String(data, StandardCharsets.UTF_8);
        // 使用fastjson的parseObject()方法，将字符串转换为Java对象
        conf conf = JSON.parseObject(json, conf.class);
        //将conf对象属性转化存储到常量
        BASE_PATH = conf.BASE_PATH;
        MAX_NUM_OF_FLIES = conf.MAX_NUM_OF_FILES;
        DEFAULT = conf.DEFAULT;

        //输出配置信息
        System.out.println(BASE_PATH);
        System.out.println(MAX_NUM_OF_FLIES);
        System.out.println(DEFAULT);

    }

    public static String[] alreadyExistFiles() throws UnsupportedEncodingException {

        if (BASE_PATH == null) return null;
        //
        String[] list = new File(BASE_PATH).list();
        //
        for (int i = 0;i < list.length; i++ ) {

            String temp ;
            //由于此时在Windows环境下读取到的文件名数组为GBK格式，而Tomcat向控制台输出的格式为utf-8
            //所以分别对向控制台输出的字符串与返回至jsp页面的字符串做不同处理

            //将读取到的每一个文件名(字符串类型)都转换成对应的字节数组，并按照utf-8的编码格式读取，按照GBK的编码格式穿件一个新的字符串

            temp = new String(list[i].getBytes(StandardCharsets.UTF_8));

                /*
                temp = new String(list[i].getBytes(StandardCharsets.UTF_8),"GBK");
                    若getBytes方法的第二个参数缺省，将转化为系统默认的编码格式，在中文的Windows环境下为gbk
                    所以为使得，将来系统可在不同环境下运行，这里应当指定为空值。
                * */

            //将返回值转化为utf-8编码格式
            list[i] = new String(list[i].getBytes(StandardCharsets.UTF_8), StandardCharsets.UTF_8);
            //向控制台输出
            System.out.println(BASE_PATH+" has " + temp);
        }
        //
        return list;
    }

    public static void terminalLogOut(String info) throws UnsupportedEncodingException {
        System.out.println(new String(info.getBytes(StandardCharsets.UTF_8)));
    }

    public static void addFileNameToDataBase(){

    }
}
