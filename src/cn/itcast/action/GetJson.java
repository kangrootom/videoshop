package cn.itcast.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.itcast.entity.Employee;

@Controller
public class GetJson {

	@RequestMapping("/getJson")
	@ResponseBody
	public Model getJson(String name,Model model) throws UnsupportedEncodingException{
		if(name!=null){
			String nameStr = new String(name.getBytes("iso-8859-1"),"utf-8");
			System.out.println(nameStr);
		}
		Employee e = new Employee(1,"jack","male",new Date());
		model.addAttribute("emp", e);
		model.addAttribute("status", "you have succeed");
		return model;
	}
 }
