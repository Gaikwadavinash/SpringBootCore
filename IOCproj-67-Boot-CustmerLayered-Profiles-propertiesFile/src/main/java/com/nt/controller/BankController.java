package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import com.nt.dto.CustmerDTO;
import com.nt.service.ICustmerMangService;
import com.nt.vo.CustmerVO;

@Controller("controller")
public class BankController {
@Autowired
private ICustmerMangService service;	

public final String processCustmer(CustmerVO vo)throws Exception{
//covert CustmerVo to CutmerDTO
	CustmerDTO dto= new CustmerDTO();
	dto.setCName(vo.getCName());
	dto.setCAddrs(vo.getCAddrs());
	dto.setPAmt(Float.parseFloat(vo.getPAmt()));
	dto.setRate(Float.parseFloat(vo.getRate()));
	dto.setTime(Float.parseFloat(vo.getTime()));
	
	String result=service.calulateSimpleIntr(dto);
	return result;
}
}
