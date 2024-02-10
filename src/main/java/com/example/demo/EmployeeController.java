package com.example.demo;

import java.util.List;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.pogo.Employee;
import com.example.demo.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeService service;

	Logger log = Logger.getAnonymousLogger();

	@RequestMapping("/")
	public ModelAndView defaultpage(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index.jsp");
		return mv;
	}

	@RequestMapping("/insert")
	public ModelAndView insert(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Employee e = new Employee();
		e.setEname(request.getParameter("ename"));
		e.setPhone(request.getParameter("phone"));

		if (service.insert(e) != null) {
			mv.setViewName("display.jsp");
		}

		return mv;
	}

	@RequestMapping("/getAll")
	public ModelAndView getAllOpr(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Employee e = new Employee();
		List<Employee> list = service.getAll();
		mv.setViewName("employeelist.jsp");
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("/delete")
	public ModelAndView delete(@RequestParam("id") Integer id, HttpServletRequest request,
			HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Employee e = new Employee();
		// Integer id = Integer.parseInt(request.getParameter("empno"));
		service.deletebyId(id);
		List<Employee> list = service.getAll();
		mv.setViewName("employeelist.jsp");
		mv.addObject("list", list);
		return mv;
	}

	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView();
		Employee e = new Employee();
		e.setEmpno(Integer.parseInt(request.getParameter("empno")));
		e.setEname(request.getParameter("ename"));
		e.setPhone(request.getParameter("phone"));

		service.updateEmployee(e);
		List<Employee> list = service.getAll();
		mv.setViewName("employeelist.jsp");
		mv.addObject("list", list);
		return mv;
	}

}
