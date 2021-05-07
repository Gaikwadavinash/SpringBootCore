package com.nt.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class CustmerVO implements Serializable {
	private String cName;
	private String cAddrs;
	private String pAmt;
	private String rate;
	private String time;
}
