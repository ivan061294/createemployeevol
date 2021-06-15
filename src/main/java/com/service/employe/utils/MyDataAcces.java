package com.service.employe.utils;

import java.sql.*;

public class MyDataAcces {

	 
	 /* Usuario y pass de la Base de Datos. */
	  private String user = "apps";
	  private String pass = "apps";
	  
	  /* URL de la Base de Datos */
	  static String url ="jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS=(PROTOCOL=tcp)(HOST=evolpesrv057.tsnetglobal.com)(PORT=1521))(CONNECT_DATA=(SERVICE_NAME=EVOLTEST)(INSTANCE_NAME=EVOLTEST)))";
	  
	  /* Conexion a la Base de Datos */
	  private Connection conn = null;
	  
	  
	  /**
	   * Conexion a la Base de Datos.
	   */
	  public MyDataAcces() {
	 
	   try {
	    Class.forName("oracle.jdbc.driver.OracleDriver");
	    conn = (Connection)DriverManager.getConnection(url, user, pass);
	    
	    if (conn != null) {
	     System.out.println("Conexion a base de datos  . . . Ok");
	     
	    }
	    
	   } catch(SQLException ex) {
	    System.out.println("Hubo un problema al intentar conecarse a la base de datos");
	    
	   } catch(ClassNotFoundException ex) {
	    System.out.println("Error... "+ex);
	   }
	    
	  }
	  public Connection getconect() {
		  Connection con= null;
		  try {
			  Class.forName("oracle.jdbc.driver.OracleDriver");
			    con = (Connection)DriverManager.getConnection(url, user, pass);
			    
			    if (con != null) {
			     System.out.println("Conexion a base de datos  . . . Ok");
			     
			    }
			  
		  } catch(SQLException ex) {
			    System.out.println("Hubo un problema al intentar conecarse a la base de datos");
			    
			   } catch(ClassNotFoundException ex) {
			    System.out.println("Error... "+ex);
			   }
		  return con;
	  }
	  
	  /**
	   * Consultas a la Base de Datos.
	   * @param _query
	   * @return
	   */
	  public ResultSet getQuery(String _query) {
	   Statement state = null;
	   ResultSet resultado = null;
	   
	   try {
	   if (conn != null) {
	   System.out.println("Conexion a base de datos  . . . Ok"+_query);
			     
	 }
	    state = (Statement) conn.createStatement();
	    resultado = state.executeQuery(_query);
	   } catch(SQLException e) {
	    e.printStackTrace();  
	   }
	   
	   return resultado;
	  }
	  
	 
	  /**
	   * Modificacion a la Base de Datos.
	   * @param _query
	   */
	  public void setQuery(String _query) {
	   Statement state = null;
	   
	   try {
	    state=(Statement) conn.createStatement();
	    state.execute(_query);

	          } catch (SQLException e) {
	             e.printStackTrace();
	        }
	  }

	
	
}
