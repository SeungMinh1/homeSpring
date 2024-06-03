package com.yedam.app.dept.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@Controller
public class DeptController {
	@Autowired
	DeptService deptService;

	@GetMapping("deptList")
	public String deptList(Model model) {
		List<DeptVO> list = deptService.deptList();
		model.addAttribute("deptList", list);
		return "dept/list";
	}

	@GetMapping("deptInfo")
	public String deptInfo(DeptVO deptVO, Model model) {
		DeptVO findVO = deptService.deptInfo(deptVO);
		model.addAttribute("deptInfo", findVO);
		return "dept/info";
	}

	// 등록 - 페이지
	@GetMapping("deptInsert")
	public String deptInsertForm(Model model) {
		model.addAttribute("deptVO", new DeptVO());
		return "dept/insert";
	}

	// 등록 - 처리
	@PostMapping("deptInsert")
	public String empInsertProcess(DeptVO deptVO) {
		// 1)해당 기능 수행 -> Service
		int deptid = deptService.deptInsert(deptVO);
		String url = null;
		if (deptid > -1) {
			// 정상적으로 등록된 경우
			url = "redirect:deptInfo?departmentId=" + deptid;
		} else {
			// 정상적으로 등록안된경우
			url = "deptList";
		}
		return url;
	}

	// 수정 - 페이지
	@GetMapping("deptUpdate")
	public String deptUpdateForm(Integer departmentId, Model model) {
		DeptVO deptVO = new DeptVO();
		deptVO.setDepartmentId(departmentId);

		DeptVO findVO = deptService.deptInfo(deptVO);
		model.addAttribute("deptInfo", findVO);

		return "dept/update";
	}

	// 수정 - 처리 : AJAX => QueryString
	//@PostMapping("deptUpdate")
	@ResponseBody // AJAX용 이라는 annotation
	public Map<String, Object> deptUpdateAJAXQueryString(DeptVO deptVO) {
		return deptService.deptUpdate(deptVO);
	}

	// 수정 - 처리 : AJAX => JSON
	@PostMapping("deptUpdate")
	@ResponseBody // AJAX용 이라는 annotation
	public Map<String, Object> deptUpdateAJAXJSON(@RequestBody DeptVO deptVO) {
		return deptService.deptUpdate(deptVO);
	}

	// 삭제 - 처리
	@GetMapping("deptDelete")
	public String deptDelete(DeptVO deptVO) {
		deptService.deptDelete(deptVO);
		return "redirect:deptList";
	}

}
