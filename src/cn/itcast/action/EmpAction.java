package cn.itcast.action;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.entity.Employee;
import cn.itcast.service.EmpService;
import cn.itcast.util.PageResult;

@Controller
public class EmpAction {
	
	
	/**
	 * 自定义类型转换器
	 */
	@InitBinder
	public void initBinder(HttpServletRequest request,ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(
				Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy年MM月dd日"),true));
	}
	
	private Integer pageSize = PageResult.PAGE_PAGESIZE;
	@Resource
	private EmpService empService;
	
	@RequestMapping("/add")
	public String addEmp(Employee emp){
		empService.insert(emp);
		return "redirect:/show.action";
	}
	
	@RequestMapping("/show")
	public String showEmp(Model model,Integer pageNo,String like_name){
		if(pageNo==null || pageNo<1){
			pageNo=1;
		}
		if(like_name==null || like_name.trim()==""){
			like_name = null;
		}
		PageResult pageResult = empService.findByPageResult(pageNo, pageSize,like_name);
		model.addAttribute("pageResult", pageResult);
		model.addAttribute("like_name",like_name);
		return "forward:/WEB-INF/secret/emps.jsp";
	}
	
	@RequestMapping("/getinfo")
	public String getinfo(int eid,Model model){
		Employee emp = empService.findOne(eid);
		model.addAttribute("emp", emp);
		return "forward:/WEB-INF/secret/emp_edit.jsp";
	}
	
	@RequestMapping("/edit")
	public String edit(Employee emp){
		empService.updateOne(emp);
		return "redirect:/show.action";
	}
	
	@RequestMapping("/fillinfo")
	public String fillinfo(){
		return "forward:/WEB-INF/secret/emp_fill.jsp";
	}
	
	@RequestMapping("/del")
	public String del(HttpServletRequest request){
		String str = request.getParameter("ids");
		String[] s = str.split(",");
		int[] ids = new int[s.length];
		for(int i=0;i<s.length;i++){
			System.out.println(s[i]);
			ids[i] = Integer.parseInt(s[i]);
		}
		empService.dynaDeleteArray(ids);
		return "redirect:/show.action";
	}
}
