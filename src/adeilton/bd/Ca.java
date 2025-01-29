/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adeilton.bd;

import java.sql.*;
/**
 *
 * @author 20221074010053
 */
public class Ca {
    
    public static void main (String [] args) throws SQLException {
    
    String url = "jdbc:myslq://localhost/sakila";
    String usr = "root";
    String pwd = "1234";

    Connection con = null;
    
//    try / catch

    try {
    
        con = DriverManager.getConnection(url, usr, pwd);
    
    String sql = "insert into customer (store_id, first_name, last_name, email, address_id, active)"
               + " values (?,?,?,?,?,?)";
    
    
    PreparedStatement pst = con.prepareStatement(sql);
    
    pst.setInt(1,2);
    pst.setString(2,"antonio");
    pst.setString(3,"flavio" );
    pst.setString(4,"asdasdsaffas");
    pst.setInt(5,21);
    pst.setInt(6,1);
    
   
    
    sql = "update customer "
            + " set last_name = ?"
            + " where customer_id = ?";
    
    pst = con.prepareStatement(sql);
    
    pst.setString(1, "maria");
    pst.setInt(2, 607);
    
    pst.execute();
    pst.close();
    
//    read

    String query = "select * from customer"
        + " order by customer_id desc"
        + " limit 10";

    Statement st = con.createStatement();
    
    ResultSet rs = st.executeQuery(query);
    ResultSetMetaData md = rs.getMetaData();
    int col = md.getColumnCount();
    
        for (int i = 1; i <= col; i++) {
            System.out.print(md.getColumnName(i) + "\t");
        } System.out.println("");
    
        while (rs.next()){
            for (int i = 1; i <= col; i++) {
                System.out.print(rs.getString(i) + "\t");
            }System.out.println("");
      
        }    
        
    } 
    
    catch (SQLException e){
       e.printStackTrace();
    }
    
    finally {
      con.close();
    }

    };
  }


