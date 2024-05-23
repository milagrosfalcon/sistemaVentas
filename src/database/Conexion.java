/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Mili
 */
public class Conexion {
    //declaramos constantes privadas
    //la conexion al driver se hace haciendo referencia al driver de la libreria de jdbc
    private final String DRIVER="com.mysql.cj.jdbc.Driver";
     private final String DB="dbsistema";
    private final String URL="jdbc:mysql://localhost:3306/dbsistema?serverTimezone=UTC";
    //DB?useSSL=false
    private final String USER="root";
    private final String PASSWORD="root";
    public Connection cadena;
    //patron singleton
    public static Conexion instancia;
    
    
    private Conexion(){
    this.cadena=null;
}
    public Connection conectar(){
        try {
            Class.forName(DRIVER);
            this.cadena=DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
        return this.cadena;
    }
    
    
    public void desconectar(){
        try {
            this.cadena.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e.getMessage());
        }
    }
    
    public synchronized static Conexion getInstancia(){
        if(instancia==null){
            instancia= new Conexion();
        }
        return instancia;
    }
}

