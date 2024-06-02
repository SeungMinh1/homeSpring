package com.yedam.app.dept.service;

import java.util.List;
import java.util.Map;

public interface DeptService {
	//부서정보 전체조회
	public List<DeptVO> deptList();
	//부서정보 단건조회
	public DeptVO deptInfo(DeptVO deptVO);
	//부서정보등록
	public int deptInsert(DeptVO deptVO);
	//부서정보수정
	public Map<String, Object> deptUpdate(DeptVO deptVO);
	//부서정보 삭제
	public Map<String, Object> deptDelete(DeptVO deptVO);
}
