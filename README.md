# HFS (Http File Service)

这是一个基于Http协议的，利用servlet技术实现一个可以在局域网范围内共享文件的系统。

#### 如何部署这个项目？

###### 方法1：

将项目中 target/hfs目录复制到您的Tomcat (8/9)根目录下的webapps文件夹下面；

并将target/hfs/WEB-INF/classes/com/hfs目录下的conf.json文件中的<base_path>标签的值修改为您想要存放文件的位置

###### 方法2：

你可以将本项目的war包复制到你的Tomcat(推荐Tomcat 8/9)安装路径下的webapps目录下面；

并修改 hfs.war\WEB-INF\classes\com\hfs 中的conf.json文件中的<base_path>标签的值为您想要存放文件的位置

#### 待实现的技术

- [x] 1.基本的文件上传、下载功能；最基本的交互页面

- [ ] 2.前端交互页面优化；并搭建合理的项目框架（前端+后端），便于日后项目功能上的扩展；

- [ ] 3.基本的文件管理功能：查询系统中已上传的文件(关键字、文件类型、筛选等方式)、系统内文件的统计信息(总大小、数量、各个类型的文件的数量)，对于上传已经上传过的文件时应当提示两个文件的对比信息，并提示用户替换或者重名保存

- [ ] 4.对用户自定义多个存储位置，并可以设置每个位置总容量的限制

- [ ] 5.在线的文件预览，应包含对视频、音频、PDF、文档的支持

- [ ] 6.为同一局域网内的两台设备提供文件传输的中介功能

- [ ] 7.分布式存储

# HFS (Http File Service)

This is a system that uses servlet technology based on the Http protocol to share files within a local area network.

#### How to deploy this project?

###### Method 1:

Copy the target/hfs directory in the project to the webapps folder under your Tomcat (8/9) root directory;

And modify the value of the <base_path> tag in the conf.json file under the target/hfs/WEB-INF/classes/com/hfs directory to the location where you want to store the files

###### Method 2:

You can copy the war package of this project to the webapps directory under your Tomcat (recommended Tomcat 8/9) installation path;

And modify the value of the <base_path> tag in the conf.json file in hfs.war\WEB-INF\classes\com\hfs to the location where you want to store the files

#### Technologies to be implemented

- [x] 1. Basic file upload and download functions; basic interaction page

- [ ] 2. Optimize the front-end interaction page; and build a reasonable project framework (front-end + back-end) for future project function expansion;

- [ ] 3. Basic file management functions: query the files that have been uploaded to the system (keywords, file types, filtering, etc.), statistics of files in the system (total size, number, number of files of each type), when uploading files that have been uploaded before, it should prompt the comparison information of the two files, and prompt the user to replace or save with a different name

- [ ] 4. Allow users to customize multiple storage locations and set the total capacity limit for each location

- [ ] 5. Online file preview, which should include support for video, audio, PDF, and documents

- [ ] 6. Provide file transfer intermediary function for two devices in the same local area network

- [ ] 7. Distributed storage
