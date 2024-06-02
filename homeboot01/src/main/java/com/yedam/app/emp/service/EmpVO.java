package com.yedam.app.emp.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class EmpVO {
	private Integer employeeId; //PK키는 사용 / DB와 상관없지만 통신할때 포괄적인 역할가능(NULL 처리)
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	//HandlerAdapter가 파라미터 자동 맵핑 시 적용할 포맷
	@DateTimeFormat(pattern ="yyyy-MM-dd")
	private Date hireDate;
	private String jobId;
	private double salary;
	private double commissionPct;
	private int  managerId;
	private int departmentId;
}
