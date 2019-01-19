package customerLogin;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Database {
	
	final private String dbName = "POSDatabase.db"; 
	final private String url = "jdbc:sqlite:db_file/"+dbName;
	final private String customerTable = "customerTable";
	final private String productTable = "productTable";
	final private String catagoryTable = "catagoryTable";
	final private String adminTable = "adminTable";

    private Connection connect() {
        // SQLite connection string
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void createNewDatabase() {
   	 
      try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void createNewCustomerTable() {
       // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS " + customerTable+ " (\n"
                + "	id text PRIMARY KEY NOT NULL,\n"
                + "	name text NOT NULL,\n"
                + "	password text NOT NULL,\n"
                + "	phoneNumber text NOT NULL,\n"
                + "	balance text NOT NULL,\n"
                + "	type text NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            System.out.println("Customer Table created sucessfully.");
            System.out.println(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void createNewAdminTable() {
        // SQL statement for creating a new table
         String sql = "CREATE TABLE IF NOT EXISTS " + adminTable+ " (\n"
                 + "	id text PRIMARY KEY NOT NULL,\n"
                 + "	name text NOT NULL,\n"
                 + "	password text NOT NULL\n"
                 
                 
                
                 + ");";
         
         try (Connection conn = DriverManager.getConnection(url);
                 Statement stmt = conn.createStatement()) {
             // create a new table
             stmt.execute(sql);
             System.out.println("Admin Table created sucessfully.");
             System.out.println(sql);
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
     }
    
    
    public void insertCustomer(String id, String name, String password, String phoneNumber, String balance, String type) {
        String sql = "INSERT INTO " + customerTable+ " (id,name,password,phoneNumber,balance,type) VALUES(?,?,?,?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, password);
            pstmt.setString(4, phoneNumber);
            pstmt.setString(5, balance);
            pstmt.setString(6, type);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void insertAdmin(String id, String name, String password) {
        String sql = "INSERT INTO " + adminTable+ " (id,name,password) VALUES(?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, password);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void showAllCustomer(){
        String sql = "SELECT id, name,password,phoneNumber,balance,type  FROM " + customerTable+ "";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getString("password") + "\t" +
                                   rs.getString("phoneNumber") + "\t" +
                                   rs.getString("balance") + "\t" +
                                   rs.getString("type"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void showAllAdmin(){
        String sql = "SELECT id, name,password FROM " + adminTable+ "";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean searchAdmin(String id, String password){
        String sql = "SELECT id, name,password  FROM " + adminTable+ "";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                if(rs.getString("id").equals(id) && rs.getString("password").equals(password)){
                	JOptionPane.showMessageDialog(null, "Login Successful");
                	return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Id doesn't match with the password");
        return false;
    }
    
    public boolean searchCustomer(String id, String password){
        String sql = "SELECT id, name,password,phoneNumber,balance,type  FROM " + customerTable+ "";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                if(rs.getString("id").equals(id) && rs.getString("password").equals(password)){
                	JOptionPane.showMessageDialog(null, "Login Successful");
                	return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Id doesn't match with the password");
        return false;
    }
    
    public String getCustomerName(String id){
        String sql = "SELECT id, name,password,phoneNumber,balance,type  FROM " + customerTable+ "";
        String s="";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                if(rs.getString("id").equals(id) ){
                	s = rs.getString("name");
                	
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return s;
    }
    
    public String getCustomerType(String id){
        String sql = "SELECT id, name,password,phoneNumber,balance,type  FROM " + customerTable+ "";
        String s="";
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                if(rs.getString("id").equals(id) ){
                	s = rs.getString("type");
                	
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        return s;
    }
    
    public String getCustomerBalance(String id){
        String sql = "SELECT id, name,password,phoneNumber,balance,type  FROM " + customerTable+ "";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                if(rs.getString("id").equals(id) ){
                	//JOptionPane.showMessageDialog(null, "Login Successful");
                	return rs.getString("balance");
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    
    
    
    public void customerBalanceUpdate(String id, String balance) {
        String sql = "UPDATE " + customerTable+ " SET balance = ? "
                + "WHERE id = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
        	
            pstmt.setString(1, balance);
            pstmt.setString(2, id);
            
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void customerTypeUpdate(String id, String type) {
        String sql = "UPDATE " + customerTable+ " SET balance = ? "
                + "WHERE id = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
        	
            pstmt.setString(1, type);
            pstmt.setString(2, id);
            
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<String[]> returnAllCustomerInfo(){
    	String sql = "SELECT id, name,password,phoneNumber,balance,type  FROM " + customerTable+ "";
        
        ArrayList<String[]> arr = new ArrayList<String[]>(); 
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
        	
            while (rs.next()) {
            	String[] s = new String[6];
            	
                				s[0]  = rs.getString("id"); 
                				s[1]  = rs.getString("name");
                				s[2]  = rs.getString("password");
                				s[3]  = rs.getString("phoneNumber");
                				s[4]  = rs.getString("balance");
                				s[5]  = rs.getString("type");
               arr.add(s);                   
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return arr;
    }    
    
    public void productQuantityUpdate(String id, String quantity) {
        String sql = "UPDATE " + productTable+ " SET quantity = ? "
                + "WHERE id = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
        	
            pstmt.setString(1, quantity);
            pstmt.setString(2, id);
            
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void deleteCutomer(String id) {
        String sql = "DELETE FROM " + customerTable+ " WHERE id = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, id);
            // execute the delete statement
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Customer profile deleted successfully");
    }
    
    public void deleteCatagory(String id) {
        String sql = "DELETE FROM " + catagoryTable+ " WHERE id = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, id);
            // execute the delete statement
            pstmt.executeUpdate();
            
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        JOptionPane.showMessageDialog(null, "Catagory deleted successfully");
    }
    
    public void createNewProductTable() {
        // SQL statement for creating a new table
         String sql = "CREATE TABLE IF NOT EXISTS " + productTable+ " (\n"
                 + "	id text PRIMARY KEY NOT NULL,\n"
                 + "	name text NOT NULL,\n"
                 + "	price text NOT NULL,\n"
                 + "	catagory text NOT NULL,\n"
                 + "	quantity text NOT NULL\n"
                 + ");";
         
         try (Connection conn = DriverManager.getConnection(url);
                 Statement stmt = conn.createStatement()) {
             // create a new table
             stmt.execute(sql);
             System.out.println("Product Table created sucessfully.");
             System.out.println(sql);
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
     }
    
    public void insertProduct(String id, String name, String price, String catagory, String quantity) {
        String sql = "INSERT INTO " + productTable+ " (id, name, price, catagory, quantity) VALUES(?,?,?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            pstmt.setString(2, name);
            pstmt.setString(3, price);
            pstmt.setString(4, catagory);
            pstmt.setString(5, quantity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void showAllProduct(){
        String sql = "SELECT id, name,price,catagory,quantity  FROM " + productTable+ "";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getString("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getString("price") + "\t" +
                                   rs.getString("catagory") + "\t" +
                                   rs.getString("quantity"));
                                  
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public boolean searchProduct(String name){
        String sql = "SELECT id, name,price,catagory,quantity  FROM " + productTable+ "";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            
            while (rs.next()) {
                if(rs.getString("name").equals(name) ){
                	JOptionPane.showMessageDialog(null, "Product Found");
                	return true;
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        JOptionPane.showMessageDialog(null, "No product of this type present in our stock");
        return false;
    }
    
    public ArrayList<String[]> returnAllProductInfo(){
        String sql = "SELECT id, name,price,catagory,quantity  FROM " + productTable+ "";
        
        ArrayList<String[]> arr = new ArrayList<String[]>(); 
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
        	
            while (rs.next()) {
            	String[] s = new String[5];
            	
                				s[0]  = rs.getString("id"); 
                				s[1]  = rs.getString("name");
                				s[2]  = rs.getString("price");
                				s[3]  = rs.getString("catagory");
                				s[4]  = rs.getString("quantity");
               arr.add(s);                   
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return arr;
    }    

    
//    public void customerUpdate(int id, String name, double points) {
//        String sql = "UPDATE " + customerTable+ " SET name = ? , "
//                + "points = ? "
//                + "WHERE id = ?";
// 
//        try (Connection conn = this.connect();
//                PreparedStatement pstmt = conn.prepareStatement(sql)) {
// 
//            // set the corresponding param
//            pstmt.setString(1, name);
//            pstmt.setDouble(2, points);
//            pstmt.setInt(3, id);
//            // update 
//            pstmt.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//    }
    
    public void createNewCatagoryTable() {
        // SQL statement for creating a new table
         String sql = "CREATE TABLE IF NOT EXISTS " + catagoryTable+ " (\n"
                 + "	id text PRIMARY KEY NOT NULL,\n"
                 + "	name text NOT NULL\n"
                 + ");";
         
         try (Connection conn = DriverManager.getConnection(url);
                 Statement stmt = conn.createStatement()) {
             // create a new table
             stmt.execute(sql);
             System.out.println("CATAGORY Table created sucessfully.");
             System.out.println(sql);
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
     }
     
     
     public void insertCatagory(String id, String name) {
         String sql = "INSERT INTO " + catagoryTable+ " (id,name) VALUES(?,?)";
  
         try (Connection conn = this.connect();
                 PreparedStatement pstmt = conn.prepareStatement(sql)) {
             pstmt.setString(1, id);
             pstmt.setString(2, name);
        
             pstmt.executeUpdate();
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
     }
     
     
     
     public void showAllCatagory(){
         String sql = "SELECT id, name  FROM " + catagoryTable+ "";
         
         try (Connection conn = this.connect();
              Statement stmt  = conn.createStatement();
              ResultSet rs    = stmt.executeQuery(sql)){
             
             // loop through the result set
             while (rs.next()) {
                 System.out.println(rs.getString("id") +  "\t" + 
                                    rs.getString("name"));
             }
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
     }
     
     public ArrayList<String[]> returnAllCatagoryInfo(){
    	 String sql = "SELECT id, name  FROM " + catagoryTable+ "";
         ArrayList<String[]> a = new ArrayList<String[]>(); 
         String[] st = new String[2];
         try (Connection conn = this.connect();
              Statement stmt  = conn.createStatement();
              ResultSet rs    = stmt.executeQuery(sql)){
             
             
             while (rs.next()) {
            	 st[0] = rs.getString("id");
            	 st[1] = rs.getString("name");  
                                    
            	 a.add(st);
             }
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
         return a;
     }
     
     public ArrayList<String> returnAllCatagoryName(){
    	 String sql = "SELECT id, name  FROM " + catagoryTable+ "";
         ArrayList<String> a = new ArrayList<String>(); 
         try (Connection conn = this.connect();
              Statement stmt  = conn.createStatement();
              ResultSet rs    = stmt.executeQuery(sql)){
             
             // loop through the result set
             while (rs.next()) {
                 a.add(rs.getString("name"));  
                                    
             }
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
         return a;
     }
     
     public boolean searchCatagory(String name){
         String sql = "SELECT id, name  FROM " + catagoryTable+ "";
         
         try (Connection conn = this.connect();
              Statement stmt  = conn.createStatement();
              ResultSet rs    = stmt.executeQuery(sql)){
             
             
             while (rs.next()) {
                 if(rs.getString("name").equals(name) ){
                 	JOptionPane.showMessageDialog(null, "Catagory Found");
                 	return true;
                 }
             }
         } catch (SQLException e) {
             System.out.println(e.getMessage());
         }
         JOptionPane.showMessageDialog(null, "No catagory of this type present in our stock");
         return false;
     }
     
    
}
