/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adeilton.bd;

import java.sql.*;

/**
 *
 * @author 20221074010053
 */
public class AdeiltonBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        
        Customer c = new Customer (2, "Arthur","marinho", "arthurmarinho@gmail.com", 111, 1 );
        CustomerDAO dao = new CustomerDAO ();
        
//        dao.insertCustomer(c);
dao.updateCustomer(601);
dao.deleteCustomer(600);
dao.showCustomers();
    
    }
}