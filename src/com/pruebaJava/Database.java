package com.pruebaJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class Database {
  
	private List<Object> listado = new ArrayList<Object>();
  
	public static void main(String[] args)
	{
		try
		{
    	  Class.forName("org.h2.Driver");
          Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "" );
          Statement stmt = con.createStatement();
          stmt.executeUpdate( "DROP TABLE personas" );
          stmt.executeUpdate( "CREATE TABLE personas ( "
          		+ "id_persona int(11) PRIMARY KEY AUTO_INCREMENT,"
          		+ "nombre varchar(50),"
          		+ "apellido varchar(50),"
          		+ "procesado boolean,"
          		+ "fecha_registro date,"
          		+ "estado_registro varchar(10))" );
          
          //stmt.executeUpdate( "INSERT INTO personas ( id_persona, nombre, apellido, procesado, fecha_registro, estado_registro ) VALUES ( 1, 'FELIPE', 'GARZON', FALSE, NOW(), 'ACTIVO' )" );
          
          //ResultSet rs = stmt.executeQuery("SELECT * FROM personas");
          
	      /*while( rs.next() )
	      {
	          String name = rs.getString("nombre");
	          System.out.println( name );
	      }*/
          
	      stmt.close();
	      con.close();
	    }
	    catch( Exception e )
	    {
	      System.out.println( e.getMessage() );
	    }
	}
	
	// Registrar persona
	public String register(String nombre, String apellido) {
		
		String respuesta;
		
		try
		{
    	  Class.forName("org.h2.Driver");
          Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "" );
          Statement stmt = con.createStatement();
          
          ResultSet rs1 = stmt.executeQuery("SELECT MAX(id_persona) id_persona FROM personas");
          rs1.next();
          int consecutivo = (rs1.getString(1) == null)?1:(Integer.parseInt(rs1.getString(1))+1);
          
          boolean procesado = false;
          
          stmt.execute( "INSERT INTO personas ( id_persona, nombre, apellido, procesado, fecha_registro, estado_registro ) "
          		+ "VALUES ( "+consecutivo+", '"+nombre+"', '"+apellido+"', "+procesado+", NOW(), 'ACTIVO' )" );
          
          respuesta = "Registro exitoso";
          
	      stmt.close();
	      con.close();
	    
		}catch( Exception e ){
	      System.out.println( e.getMessage() );
	      
	      respuesta = "Error en la conexión a la base de datos\n"+e.getMessage();
	      
	    }
		
		return respuesta;
	}
	
	// Consultar registros
	public List<Object> verRegistros() {
		listado = new ArrayList<Object>();
		try
		{
    	  Class.forName("org.h2.Driver");
          Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "" );
          Statement stmt = con.createStatement();
          
          //stmt.executeUpdate( "DROP TABLE table1" );
          ResultSet rs = stmt.executeQuery("SELECT * FROM personas");
	      
          while( rs.next() )
	      {
        	  int id_persona = Integer.parseInt(rs.getString("id_persona"));
	          String nombre = rs.getString("nombre");
	          String apellido = rs.getString("apellido");
	          boolean procesado = rs.getBoolean("procesado");
	          String fecha_registro = rs.getString("fecha_registro");
	          
	          listado.add(new Object[] {id_persona,nombre,apellido,procesado,fecha_registro});
	      }
	      stmt.close();
	      con.close();
	      
	    }
	    catch( Exception e )
	    {
	      System.out.println( e.getMessage() );
	      listado = new ArrayList<Object>();
	    } 
		
		return listado;
	}
	
	// Procesar registros
	public void procesarRegistros(int[] identificadores) {
		
		try
		{
    	  Class.forName("org.h2.Driver");
          Connection con = DriverManager.getConnection("jdbc:h2:~/test", "sa", "" );
          Statement stmt = con.createStatement();
          
          boolean procesado = true;
          
          for (int id : identificadores) {
        	  stmt.executeUpdate("UPDATE personas SET procesado = "+procesado+" WHERE id_persona = "+id);
          }
          
	      stmt.close();
	      con.close();
	      
	    }
	    catch( Exception e )
	    {
	      System.out.println( e.getMessage() );
	    } 
		
	}
	
}