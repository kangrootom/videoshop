package cn.itcast.action;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
@Controller
public class FileUpload {
	
	
	/*
     * 通过流的方式上传文件
     * @RequestParam("file") 将name=file控件得到的文件封装成CommonsMultipartFile 对象
     */
    @RequestMapping("fileUpload")
    public String  fileUpload(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request) throws IOException {
         
         
        //用来检测程序运行时间
        long  startTime=System.currentTimeMillis();
        String realPath = request.getServletContext().getRealPath("/upload");
        System.out.println(realPath);
        String prefix = UUID.randomUUID().toString().replace("-", "");
        String fileName = prefix + file.getOriginalFilename();
        try {
            //获取输出流
            OutputStream os=new FileOutputStream(new File(realPath,fileName));
            //获取输入流 CommonsMultipartFile 中可以直接得到文件的流
            InputStream is=file.getInputStream();
            int temp;
            byte[] buffer = new byte[1024];
            //一个一个字节的读取并写入
            while((temp=is.read())!=-1)
            {
                os.write(buffer,0,temp);
                os.flush();
            }
           
           os.close();
           is.close();
         
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        long  endTime=System.currentTimeMillis();
        System.out.println("方法一的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "forward:index.jsp"; 
    }
	
	/*
     * 采用file.Transto 来保存上传的文件
     */
    @RequestMapping("/fileUpload2")
    public String  fileUpload2(@RequestParam("file") CommonsMultipartFile file,HttpServletRequest request) throws IOException {
    	
       long startTime = System.currentTimeMillis();
       String realPath = request.getServletContext().getRealPath("/upload");
       String prefix = UUID.randomUUID().toString().replace("-", "");
       String fileName = prefix + file.getOriginalFilename();
       File toFile=new File(realPath,fileName);
       if(!toFile.exists()){
    	   toFile.mkdirs();
       }
       //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
       file.transferTo(toFile);
       long  endTime=System.currentTimeMillis();
       System.out.println("方法二的运行时间："+String.valueOf(endTime-startTime)+"ms");
       return "forward:index.jsp"; 
   }
    
    /*
     *采用spring提供的上传文件的方法
     */
    @RequestMapping("springUpload")
    public String  springUpload(HttpServletRequest request) throws IllegalStateException, IOException{
    	long  startTime=System.currentTimeMillis();
         //将当前上下文初始化给  CommonsMutipartResolver （多部分解析器）
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(
                request.getSession().getServletContext());
        //检查form中是否有enctype="multipart/form-data"
        if(multipartResolver.isMultipart(request)){
        	String realPath = request.getServletContext().getRealPath("/upload");
            //将request变成多部分request
            MultipartHttpServletRequest multiRequest=(MultipartHttpServletRequest)request;
           //获取multiRequest 中所有的文件名
            Iterator iter=multiRequest.getFileNames();
             
            while(iter.hasNext()) {
                //一次遍历所有文件
                MultipartFile file=multiRequest.getFile(iter.next().toString());
                if(file!=null) {
                    String fileName = UUID.randomUUID().toString().replace("-", "")+file.getOriginalFilename();
                    //上传
                    File toFile = new File(realPath,fileName);
                    if(!toFile.exists()){
                    	toFile.mkdirs();
                    }
                    file.transferTo(toFile);
                }
                 
            }
           
        }
        
        long  endTime=System.currentTimeMillis();
        System.out.println("方法三的运行时间："+String.valueOf(endTime-startTime)+"ms");
        return "forward:index.jsp"; 
    }

}
