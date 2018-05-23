import java.beans.Statement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class sqlLiteDatabase {


	
	/*
	 * Database connection establishment.
	 */
	public static void newSqlLiteDatabase()
	{
		   Connection conn = null;  
	        try {  
	            // db parameters  
	            String url = "jdbc:sqlite:recordsDatabase.db";  
	            // create a connection to the database  
	            conn = DriverManager.getConnection(url);  
	              
	            System.out.println("Connection to SQLite has been established.");  
	              
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        } finally {  
	            try {  
	                if (conn != null) {  
	                    conn.close();  
	                }  
	            } catch (SQLException ex) {  
	                System.out.println(ex.getMessage()+" A");  
	            }  
	        }  
	}
	
	
	
	
	
	
	
	public static void createNewTable() {  
        // SQLite connection string  
        String url = "jdbc:sqlite:recordsDatabase.db";  
          
        // SQL statement for creating a new table  
        String sql = "CREATE TABLE IF NOT EXISTS Profiles (\n" 
        		+ " Name text,\n"
                + " Age integer,\n"  
                + " Status text NOT NULL,\n"  
                + " ImageUrl text\n"  
                + ");";  
          
        try{  
            Connection conn = DriverManager.getConnection(url);  
            java.sql.Statement stmt = conn.createStatement();  
            stmt.execute(sql);  
        } catch (SQLException e) {  
            System.out.println(e.getMessage()+"B");  
        }  
    }
	
	
	
	public static void insert(String name, int age, String status, String imageUrl) {  
        String sql = "INSERT INTO Profiles(name, age, status, imageUrl) VALUES(?,?,?,?)";  
   
        try{  
        	 // db parameters  
            String url = "jdbc:sqlite:recordsDatabase.db";  
            // create a connection to the database  
            Connection conn = DriverManager.getConnection(url);    
            PreparedStatement pstmt = conn.prepareStatement(sql);  
            pstmt.setString(1, name);  
            pstmt.setInt(2, age);
            pstmt.setString(3, status);
            pstmt.setString(4, imageUrl);
            pstmt.executeUpdate();  
            
            System.out.println("data added !!!");
        } catch (SQLException e) {  
            System.out.println(e.getMessage()+"C");  
        }  
    }  
	
	
	
	 public static void selectAll(){  
	        String sql = "SELECT * FROM Profiles";  
	          
	        try {  
	        	String url = "jdbc:sqlite:recordsDatabase.db";  
	            // create a connection to the database  
	            Connection conn = DriverManager.getConnection(url);  
	            java.sql.Statement stmt  = conn.createStatement();  
	            ResultSet rs    = stmt.executeQuery(sql);  
	              
	            // loop through the result set  
	            while (rs.next()) {  
	                System.out.println(rs.getString("Name") +  "\t" +   
	                                   rs.getInt("Age") + "\t" +  
	                                   rs.getString("Status")+ "\t" +
	                                   rs.getString("ImageUrl"));  
	            }  
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage()+"D");  
	        }  
	    }  
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		newSqlLiteDatabase();
		createNewTable();
		insert("ram", 21, "single", "nullllll");
		selectAll();

	}

}
