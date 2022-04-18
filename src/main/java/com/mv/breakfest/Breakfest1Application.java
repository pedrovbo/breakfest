package com.mv.breakfest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@Controller
@RequestMapping("/")
public class Breakfest1Application {

	
	@GetMapping
	public ModelAndView swaggerUi() {
	return new ModelAndView("redirect:/swagger-ui/");
	}
	
	public static void main(String[] args) {
		SpringApplication.run(Breakfest1Application.class, args);
	}

}
