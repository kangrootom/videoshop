package cn.itcast.action;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SayAction {

	@RequestMapping("/say")
	public String handleRequest(Model model) throws Exception {
		// TODO Auto-generated method stub
		model.addAttribute("msg", "GO TO SAYACTION SUCCESS");
		return "success";
	}

}
