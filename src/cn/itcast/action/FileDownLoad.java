package cn.itcast.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class FileDownLoad {
	@RequestMapping("/listFiles")
	public String listFiles(HttpServletRequest request) throws IOException{
		
		String realPath = request.getServletContext().getRealPath("/upload");
		File directory = new File(realPath);
		System.out.println("directory.getParentFile()"+directory.getParentFile());
		System.out.println("directory.getAbsolutePath()"+directory.getAbsolutePath());
		System.out.println("directory.getCanonicalPath()"+directory.getCanonicalPath());
		System.out.println("directory.getPath()"+directory.getPath());
		System.out.println("directory.getParent()"+directory.getParent());
		System.out.println("directory.getParentFile()"+directory.getParentFile());
		File[] fileList = directory.listFiles();
		request.setAttribute("fileList", fileList);
		return "forward:/WEB-INF/secret/listFiles.jsp";
	}
	
	@RequestMapping("/downLoad2")
	public ResponseEntity<byte[]> export2(String fileName,String filePath) throws IOException {
		fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
        HttpHeaders headers = new HttpHeaders();    
        File file = new File(filePath,fileName);
        fileName=new String(fileName.getBytes("utf-8"),"iso8859-1");
        
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);    
        headers.setContentDispositionFormData("attachment",fileName);    
       
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
                                              headers, HttpStatus.CREATED);    
    } 
	
	@RequestMapping("/downLoad")
	public ResponseEntity<byte[]> export(String fileName,String filePath) throws IOException {
		
		fileName = new String(fileName.getBytes("ISO-8859-1"),"UTF-8");
		File file = new File(filePath,fileName);
        byte[] body = null;
        InputStream is = new FileInputStream(file);
        body = new byte[is.available()];
        is.read(body);
        HttpHeaders headers = new HttpHeaders();
        fileName=URLEncoder.encode(fileName, "utf-8");
        headers.add("Content-Disposition", "attachment;filename="+fileName);
        HttpStatus statusCode = HttpStatus.OK;
        ResponseEntity<byte[]> entity =  new ResponseEntity<byte[]>(body,headers,statusCode);
        return entity;
    }
	public static void main(String[] args) {
		System.out.println(1520*1024*1024);
	}
}
