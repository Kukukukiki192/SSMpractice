package com.controller;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * SpringMVC文件上传
     * @return
     */
    @RequestMapping("/fileUpload1")
    public String fileUpload1(HttpServletRequest request, MultipartFile upload) throws IOException {
        System.out.println("开始SpringMVC文件上传...");

        //使用fileupload组件完成上传
        //上传的位置
        String path=request.getSession().getServletContext().getRealPath("/uploads");
        //判定路径是否存在
        File file=new File(path);
        if(!file.exists()){
            file.mkdir();//若不存在 创建该文件夹
        }

        //说明上传文件项
        //获取文件名
        String fileName=upload.getOriginalFilename();
//        fileName= URLEncoder.encode(fileName,"UTF-8");
        //文件名设为唯一值uuid
        String uuid= UUID.randomUUID().toString().replace("-","");
        fileName=uuid+"_"+fileName;
        //完成上传
        upload.transferTo(new File(path,fileName));

        System.out.println("SpringMVC文件上传成功");

        return "success";
    }

    /**
     * SpringMVC多个文件上传
     * @return
     */
    @RequestMapping("/fileUpload2")
    public String fileUpload2(HttpServletRequest request, @RequestParam("files") MultipartFile[] uploads) throws IOException {
        System.out.println("开始SpringMVC多个文件上传...");
        //上传的位置
        String path=request.getSession().getServletContext().getRealPath("/uploads");
        //判定路径是否存在
        File file=new File(path);
        if(!file.exists()){
            file.mkdir();//若不存在 创建该文件夹
        }

        //判断uploads数组不能为空并且长度大于0
        if (uploads != null && uploads.length > 0) {
            //循环获取file数组中得文件
            for (int i = 0; i < uploads.length; i++) {
                //获取每个文件
                MultipartFile upload = uploads[i];
                //获取每个文件的文件名
                String fileName=upload.getOriginalFilename();
                //文件名设为唯一值uuid
                String uuid= UUID.randomUUID().toString().replace("-","");
                fileName=uuid+"_"+fileName;
                // 转存文件
                upload.transferTo(new File(path,fileName));
                System.out.println("上传第"+(i+1)+"个文件...");
            }
        }
        System.out.println("SpringMVC多个文件上传成功");
        return "success";
    }

    /**
     * 跨服务器文件上传
     * @return
     */
    @RequestMapping("/fileUpload3")
    public String fileUpload3(MultipartFile upload) throws IOException {
        System.out.println("开始跨服务器上传...");

        //定义上传文件的服务器路径
        String path="http://localhost:9090/uploads/";//这里不加'/'的话后面'path + fileName'就要写成'path +"/" + fileName'

        //说明上传文件项
        //获取文件名
        String fileName=upload.getOriginalFilename();
//        fileName= URLEncoder.encode(fileName,"UTF-8");
        //文件名设为唯一值uuid
        String uuid= UUID.randomUUID().toString().replace("-","");
        fileName=uuid+"_"+fileName;

        //完成跨服务器上传
        //创建客户端对象
        Client client = Client.create();
        WebResource webResource = client.resource(path + fileName);
        //上传文件
        webResource.put(upload.getBytes());// <--500内部服务器错误 400bad request->不能上传中文名文件
        System.out.println("跨服务器上传成功");

        return "success";
    }

    /**
     * 跨服务器多个文件上传
     * @return
     */
    @RequestMapping("/fileUpload4")
    public String fileUpload4(@RequestParam("files") MultipartFile[] uploads) throws IOException {
        System.out.println("开始跨服务器多文件上传...");

        //定义上传文件的服务器路径
        String path="http://localhost:9090/uploads/";//这里不加'/'的话后面'path + fileName'就要写成'path +"/" + fileName'

        //判断uploads数组不能为空并且长度大于0
        if (uploads != null && uploads.length > 0) {
            //循环获取file数组中得文件
            for (int i = 0; i < uploads.length; i++) {
                MultipartFile upload = uploads[i];
                //获取每个文件的文件名
                String fileName=upload.getOriginalFilename();
                //文件名设为唯一值uuid
                String uuid= UUID.randomUUID().toString().replace("-","");
                fileName=uuid+"_"+fileName;

                //完成跨服务器上传
                //创建客户端对象
                Client client = Client.create();
                WebResource webResource = client.resource(path + fileName);
                //上传文件
                webResource.put(upload.getBytes());
                System.out.println("上传第"+(i+1)+"个文件...");
            }
        }
        System.out.println("跨服务器多文件上传成功");

        return "success";
    }
}
