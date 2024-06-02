package com.yedam.app.test.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@Controller
public class TestController {
	
	@RequestMapping(path="dept", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String commandObject(DeptVO deptVO) {
		String result = "";
		result += "path : / comobj\n";
		result += "\t getDepartmentId : " + deptVO.getDepartmentId();
		result += "\t getDepartmentName : " + deptVO.getDepartmentName();
		result += "\t getManagerId : " + deptVO.getManagerId();
		return result;
	}
	
	
	//QueryString => @RequestParam : 기본타입, 단일값
	@RequestMapping(path="reqparm", method= {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String requestParam(@RequestParam Integer departmentId, String departmentName, // (RequestParam 있어서) employeeId-필수 lastName- 필수아님
			@RequestParam(name="message", defaultValue="No message", required = true)String msg ) {
		
		String result = "";
		result += "path : / reqparm\n";
		result += "\t departmentId : " + departmentId;
		result += "\t departmentName : " + departmentName;
		result += "\t message : " + msg;
		return result;
	}
	
	//@PathVariable : 경로에 값을 포함하는 방식, 단일 값
	//Method는 상관없음
	// Content-type도 상관없음
	@RequestMapping("path/{id}")
	@ResponseBody
	public String pathVariable(@PathVariable String id) {
		String result ="";
		result += "path : /path/{id} \n";
		result += "\t id : " + id;
		return result;
	}
	
	//@RequestBody : JSON 포캣, 배열 or 객체
	//Method : POST, PUT
	//Content-type : application/json
	@PostMapping("resbody")
	@ResponseBody
	public String requestBody(@RequestBody DeptVO deptVO) {
		String result = "path : /resbody \n";
		result += "\t getDepartmentId : "+deptVO.getDepartmentId();
		result += "\t getDepartmentName : " + deptVO.getDepartmentName();
		return result;
	}
	
	@PostMapping("resbodyList")
	@ResponseBody
	public String requestBodyList(@RequestBody List<DeptVO> list) {
		String result = "path : /resbody \n";
		for(DeptVO deptVO : list) {
			result += "\t getDepartmentId : "+deptVO.getDepartmentId();
			result += "\t getDepartmentName : " + deptVO.getDepartmentName();
			result += "\n";
		}

		return result;
	}
}

/*
@RequestMapping(path="dept", method= {RequestMethod.GET, RequestMethod.POST})
@ResponseBody
public String commandObject(DeptVO deptVO) {
	String result = "";
	result += "path : / comobj\n";
	result += "\t department_id : " + deptVO.getDepartmentId();
	result += "\t department_name : " + deptVO.getDepartmentName();
	result += "\t managerId: " + deptVO.getManagerId();
	result += "\t location_id: " + deptVO.getLocationId();
	
	return result;
}

*/