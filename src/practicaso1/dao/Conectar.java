/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaso1.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class Conectar {
    private static Connection conn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String usuario = "root";
    private static final String password = "";
    private static final String url = "jdbc:mysql://localhost:3306/tienda";


public Conectar(){
    conn=null;
    try{
        Class.forName(driver);
        conn = (Connection) DriverManager.getConnection(url, usuario, password);
        if (conn != null){
            System.out.println("Conexion establecida..");
        }
    }catch(ClassNotFoundException | SQLException e){
        System.out.println("Error al conectar: "+ e);
    }
}
//Este metodo nos retorna la conexion
public Connection getConnection(){
    return conn;
}

public void desconectar(){
    conn=null;
    if(conn==null){
        System.out.println("Conexion terminada...");
    }
} 

}