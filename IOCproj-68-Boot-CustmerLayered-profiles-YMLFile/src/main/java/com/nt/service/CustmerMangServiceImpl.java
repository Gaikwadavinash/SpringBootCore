package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.nt.bo.CustmerBO;
import com.nt.dao.ICustmerDAO;
import com.nt.dto.CustmerDTO;
@Service("service")
public class CustmerMangServiceImpl implements ICustmerMangService {
@Autowired
private ICustmerDAO dao;
	@Override
	public String calulateSimpleIntr(CustmerDTO dto) throws Exception {
	float intrAmt=(dto.getPAmt()*dto.getRate()*dto.getTime())*100.0f;
	//prepare  CustomerBO obj having persistable data
	CustmerBO cutBo=new CustmerBO();
	cutBo.setCName(dto.getCName());
	cutBo.setCAddrs(dto.getCAddrs());
	cutBo.setPAmt(dto.getPAmt());
	cutBo.setRate(dto.getRate());
	cutBo.setTime(dto.getTime());
	cutBo.setIntrAmt(intrAmt);
	int count=dao.insertRecord(cutBo);
	
		return count==0?"Record Not Inserted":"Record Inserted Sucessfully:: principlet amount::"+dto.getPAmt()+"Time:: "+dto.getTime()+" rate::"+dto.getRate()+" Intrest amount:: "+intrAmt;
				
	}

}
