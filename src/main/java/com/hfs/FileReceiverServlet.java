package com.hfs;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
@MultipartConfig(fileSizeThreshold = 1024*1024*2
                ,maxFileSize = 1024*1024*1024
                ,maxRequestSize = 1024*1024*1024)
@WebServlet(name = "FileReceiverServlet", value = "/FileReceiverServlet")
public class FileReceiverServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("建立链接成功...");
        doPost(request,response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置解析请求的编码格式
        request.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        //获取上传的文件
        Part up = request.getPart("up");
        //获取上传文件名称
        String submittedFileName = up.getSubmittedFileName();
        String osName = System.getProperty("os.name");
        String savePath;
        //设置保存位置
        if (osName.toLowerCase().startsWith("linux")){
            savePath = Tools.BASE_PATH +"/"+ submittedFileName;
            System.out.println("test out Receive:savePath " + savePath);
        }else {
            savePath = Tools.BASE_PATH +"\\"+ submittedFileName;
            System.out.println("test out Receive:savePath " + savePath);
        }
        //保存用户上传的数据
        Tools.terminalLogOut(savePath);
        up.write(savePath);
        Tools.terminalLogOut("成功保存"+savePath);
        writer.println(savePath);
        response.sendRedirect("index.jsp");
    }
}
