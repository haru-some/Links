package kr.co.iei.admin.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.iei.admin.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/management")
	public String management() {
		return "admin/management";
	}
	
	@RequestMapping
	@GetMapping("/stats")
	public Map stats() {
		Map stats  = adminService.stats();
		
		
		return stats;
	}
}
