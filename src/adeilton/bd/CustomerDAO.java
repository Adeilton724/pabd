/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adeilton.bd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author 20221074010053
 */
public class CustomerDAO {
    
  private Connection con;

    public CustomerDAO() throws SQLException {
        this.con = new ConnectionFactory().getConnection();
        System.out.println("Conexão OK!");
    }

    public void insertCustomer(Customer c) throws SQLException {
        String sql = "insert into customer"
                + " (Store_id, First_name, Last_name, Email, Address_id, Active)"
                + " values"
                + " (?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = con.prepareStatement(sql);

        pst.setInt(1, c.getStore_id());
        pst.setString(2, c.getFirst_name());
        pst.setString(3, c.getLast_name());
        pst.setString(4, c.getEmail());
        pst.setInt(5, c.getAddress_id());
        pst.setInt(6, c.getActive());

        pst.execute();
        pst.close();
        System.out.println("Insert OK!");
    }

    public void deleteCustomer(int id) throws SQLException {
     String sql = "delete from customer"
                + " where customer_id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setInt (1 , id);
        
        pst.execute();
        pst.close();
        System.out.println("deleted");
        
    }

    public void updateCustomer(int id) throws SQLException {
String sql = "update customer"
        + " set first_name = ?"
        + " where customer_id = ?";
     
        PreparedStatement pst = con.prepareStatement(sql);
        
        pst.setString (1, "Wesley");
        pst.setInt (2, id);
        
        pst.execute();
        pst.close();
        System.out.println("atualizado");
       
        
    }

    public void showCustomers() throws SQLException {
        Statement st = con.createStatement();

        String query = "select * from customer"
                + " order by customer_id desc"
                + " limit 5";

        ResultSet rs = st.executeQuery(query);

        ResultSetMetaData md = rs.getMetaData();
        int col = md.getColumnCount();

        System.out.println("Tabela: " + md.getTableName(1));
        for (int i = 1; i <= col; i++) {
            System.out.print(md.getColumnName(i) + "\t");
        }
        System.out.println("");

        while (rs.next()) {
            for (int i = 1; i <= col; i++) {
                System.out.print(rs.getString(i) + "\t");
            }
            System.out.println("");
        }

        st.close();
    }
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
}
