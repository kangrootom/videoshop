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

import cn.itcast.entity.AvShop;
import cn.itcast.service.AvShopService;
import cn.itcast.util.PageResult;

@Controller
@RequestMapping("/avshop")
public class AvShopAction {
	
	
	/**
	 * 自定义类型转换器
	 */
	@InitBinder
	public void initBinder(HttpServletRequest request,ServletRequestDataBinder binder) throws Exception {
		binder.registerCustomEditor(
				Date.class, 
				new CustomDateEditor(new SimpleDateFormat("yyyy年MM月dd日"),true));
	}
	
	
	@Resource
	private AvShopService avshopService;
	
	@RequestMapping("/add")
	public String addAvShop(AvShop avshop){
		avshopService.insert(avshop);
		return "redirect:/avshop/show.action";
	}
	
	@RequestMapping("/show")
	public String showAvShop(Model model,Integer pageNo,String like_name,Integer pageSize){
		if(pageNo==null || pageNo<1){
			pageNo=1;
		}
		if(like_name==null || like_name.trim()==""){
			like_name = null;
		}
		if(pageSize==null){
			pageSize = PageResult.PAGE_PAGESIZE;
		}
		PageResult pageResult = avshopService.findByPageResult(pageNo, pageSize,like_name);
		model.addAttribute("pageResult", pageResult);
		model.addAttribute("like_name",like_name);
		return "forward:/WEB-INF/secret/avshops.jsp";
	}
	
	@RequestMapping("/getinfo")
	public String getinfo(int eid,Model model){
		AvShop avshop = avshopService.findOne(eid);
		model.addAttribute("avshop", avshop);
		return "forward:/WEB-INF/secret/avshop_edit.jsp";
	}
	
	@RequestMapping("/edit")
	public String edit(AvShop avshop){
		avshopService.updateOne(avshop);
		return "redirect:/avshop/show.action";
	}
	
	@RequestMapping("/fillinfo")
	public String fillinfo(){
		return "forward:/WEB-INF/secret/avshop_fill.jsp";
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
		avshopService.dynaDeleteArray(ids);
		return "redirect:/avshop/show.action";
	}
}
