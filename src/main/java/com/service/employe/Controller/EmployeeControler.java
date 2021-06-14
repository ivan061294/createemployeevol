package com.service.employe.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.employe.Interfaces.IEmployees;
import com.service.employe.Models.ResponseHeader;
import com.service.employe.Models.employeeModels;

@RestController
@RequestMapping("/employee")
public class EmployeeControler {
	@GetMapping
	public String jaja() {
		return "hola";
	}

	@PostMapping("/create")
	public ResponseHeader CreateEmployee() {
		ResponseHeader res=new ResponseHeader();
        
		res.setEstado("0");
		res.setMensaje("EmployeeCreated");
		return res;
	}
	@PostMapping("/createsp")
	public ResponseHeader CreateEmployeeSp(employeeModels employee) {
		
        ResponseHeader res=new ResponseHeader();
        
		res.setEstado("0");
		res.setMensaje("EmployeeCreated");
		return res;
	}
	
 
}
