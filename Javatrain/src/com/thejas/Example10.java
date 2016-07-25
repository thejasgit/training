package com.thejas;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
public class Example10 {
       public static void main(String args[])throws Exception
       {
              Properties prop=new Properties();
              prop.load(new java.io.FileInputStream("C:/Training/Javatrain/src/db.properties"));
              String url=prop.getProperty("dburl");
              String driverclass= prop.getProperty("driverclass");
              String user = prop.getProperty("dbuser");
              String password= prop.getProperty("dbpassword");
              String query="";
              Scanner sc=new Scanner(System.in);
              Connection con=null;
              try
              {
          
       Class.forName(driverclass);
       con=DriverManager.getConnection(url,user,password);
       Statement st=con.createStatement();
       if(con!=null)
       {
              /*System.out.println("connected to the oracle database");
              while(!query.equalsIgnoreCase("exit"))
              {
                     System.out.print("\nmySql>");
                     query=sc.nextLine();
                     if(!query.equalsIgnoreCase("exit"))
                           if(st.execute(query))
                                  showResult(st.getResultSet());
                           else
                                  System.out.println("rows updated "+st.getUpdateCount());      */
    	   
    	   String sql="{call thejas_insertstd(?,?,?,?)}";
    	   CallableStatement cs= con.prepareCall(sql);
    	   cs.setString(1, "thejas");
    	   cs.setInt(2, 20);
    	   cs.setInt(3, 39);
    	   cs.setInt(4, 20);
    	   cs.execute();
             // }
       }
              }
              
              catch(SQLException sqle)
              {
                     sqle.printStackTrace();
              }
              
              finally
              {
       
       if(con!=null)
       {
       con.close();
       System.out.println("connection closed");
       }
              }
       
       }
       






private static void showResult(ResultSet rs)throws SQLException
{
       ResultSetMetaData rm=rs.getMetaData();
       int cc=rm.getColumnCount();
       for(int i=1;i<=cc;i++)
              System.out.print("|"+rm.getColumnName(i));
       while(rs.next())
       {
              System.out.println("");
              for(int i=1;i<=cc;i++)
                     System.out.print("|"+rs.getString(i));
       }
}

}

