package com.nt.dto;

import java.io.Serializable;

import lombok.Data;
@Data
public class CustmerDTO implements Serializable {
private String cName;
private String cAddrs;
private float pAmt;
private float rate;
private float time;
}
