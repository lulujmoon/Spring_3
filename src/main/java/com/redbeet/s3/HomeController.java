package com.redbeet.s3;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/test")
	public void test(int num, Model model) {
		System.out.println(num);
		model.addAttribute("str", "Ajax");
	}
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );

		
		return "home";
	}
	
	@GetMapping("/testJson")
	public ModelAndView test(String name) throws Exception {
		//JSON, name은 iu, 나이는 30
		String json= "{\"name\":\""+name+"\", \"age\":30}";
		//{"name":"iu", "age":30}
		System.out.println(json);
		ModelAndView mv = new ModelAndView();
		mv.addObject("result", json);
		mv.setViewName("common/ajaxResult");
		return mv;
	}
}
