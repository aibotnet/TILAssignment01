package com.til.spring;

import java.lang.reflect.Type;
import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;
import com.til.spring.model.UserURLTable;
import com.til.spring.model.SystemURLTable;
import com.til.spring.service.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class URLController {
	
	private UserURLTableService userURLTableService;
	private SystemURLTableService systemURLTableService;
	
	@Autowired(required=true)
	@Qualifier(value="userURLTableService")
	public void setUserURLTableService(UserURLTableService userURLTableService) {
		this.userURLTableService = userURLTableService;
	}
	
	@Autowired(required=true)
	@Qualifier(value="systemURLTableService")
	public void setSystemURLTableService(SystemURLTableService systemURLTableService) {
		this.systemURLTableService = systemURLTableService;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String listUrls(Model model) {
		List<String> ul = new ArrayList<String>();
		for(SystemURLTable sut :this.systemURLTableService.listUrls() ){
			ul.add(sut.getUrl().trim());
		}
		Gson gson = new Gson();
		String element = gson.toJson(ul);

		System.out.println(element);
		model.addAttribute("urlList",ul);	
		model.addAttribute("userurlt", new UserURLTable());
		return "index";
	}
	
	@RequestMapping(value= "/index/add", method = RequestMethod.POST)
	public String add(@ModelAttribute("userurlt") UserURLTable ut){
		if(ut.getUrl().trim()=="")
			return "redirect:/index";
		
		this.userURLTableService.updateUserUrl(ut);
		
		return "redirect:/index";	
	}
	
	@RequestMapping(value = "/index/auto", method = RequestMethod.GET)
	public void  autoComplete(HttpServletRequest request,
            HttpServletResponse response) {
		response.setContentType("application/json");
		String searchList="";
		try {
            String term = request.getParameter("term");
           
            System.out.println(term);
            ArrayList<String> list  = new ArrayList<String>();
            for(SystemURLTable sut :this.systemURLTableService.listUrls() ){
            	if(sut.getUrl().contains(term))
            		list.add(sut.getUrl().trim());
    		}
            searchList = new Gson().toJson(list);
            response.getWriter().write(searchList);
        } catch (Exception e) {
            System.err.println(e.getMessage());
    	}
	}
}
