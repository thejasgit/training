package com.thejas;
import java.sql.*;
import java.util.Properties;

public class Jdbcdemo {
	
	public static void main(String []args) throws Exception{
		
	
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Properties pro = new Properties();
	pro.load(new java.io.FileInputStream("C:/Training/Javatrain/src/db.properties"));
	Connection con = DriverManager.getConnection(pro.getProperty("dburl"), pro.getProperty("dbuser"),pro.getProperty("dbpassword"));
	
	
	//Statement  st = con.createStatement();
	

	String quer="select * from thejas_account";
	String quer1="insert into thejas_account values(?,?,?)";
//	String query2="delete from thejas_account where accno=12";
	//String query3="update thejas_account set name='thejas' where accno=17";
	ResultSet re;
	
	PreparedStatement st=con.prepareStatement(quer1);
	st.setInt(1,19);
	st.setString(2,"lucy");
	st.setInt(3,4000);
	
	
	int r=st.executeUpdate();
	
	System.out.println(r + " rows inserted");
	
	
	re=con.createStatement().executeQuery(quer);
	ResultSetMetaData rt= re.getMetaData();
	int cc=rt.getColumnCount();
	
	for(int i=1;i<=3;i++){
		System.out.print("|"+rt.getColumnName(i));
	}
	System.out.println(cc);
	while(re.next()){
		System.out.println(re.getInt(1)+"|  "+re.getString(2)+"|  "+re.getInt(3));
		
	}
	
	
	con.close();
	
	
	
	
	
	
	
	}
	
}
