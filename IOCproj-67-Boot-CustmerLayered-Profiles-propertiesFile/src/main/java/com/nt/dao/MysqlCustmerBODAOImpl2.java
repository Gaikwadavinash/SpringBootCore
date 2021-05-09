package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nt.bo.CustmerBO;

@Primary
@Repository("oraDAO")
@Profile({"dev","test"} )
//@Profile("test")
public class MysqlCustmerBODAOImpl2 implements ICustmerDAO {

private static final String INSERT_CUST_QUERY="INSERT INTO CUSTMERLAYERED VALUES(?,?,?,?,?,?)";	

@Autowired
private	DataSource ds;
	@Override
	public int insertRecord(CustmerBO bo) throws Exception {
	System.out.println("DS object class:"+ds.getClass());
	//craete a connecction
	Connection con=ds.getConnection();
	//create prepared statement object
	PreparedStatement ps= con.prepareStatement(INSERT_CUST_QUERY);
	//set the object to the param value
	
	ps.setString(1,bo.getCName() );
ps.setString(2, bo.getCAddrs());
ps.setFloat(3, bo.getPAmt());
ps.setFloat(4, bo.getRate());
ps.setFloat(5, bo.getTime());
ps.setFloat(6, bo.getIntrAmt());
//execute Query
int count=ps.executeUpdate()	;

//return count
	return  count;
	}

}
