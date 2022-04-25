package Model;
import java.sql.*;
import java.io.*;
import java.util.ArrayList;

public class Database {

    
    // reads user from database file
    public User[] loadUsers() {
    	String first_name,last_name,emp_id,dept_name;
    	
    	User[] objects = new User[10];
    
    	try{
    		int i = 0;
    	    Class.forName("com.mysql.cj.jdbc.Driver");  
    	    Connection con=DriverManager.getConnection(  
    	    "jdbc:mysql://localhost:3306/MVC_Project","gagan","password");  
    	    Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	       ResultSet.CONCUR_READ_ONLY);  
    	    ResultSet rs=stmt.executeQuery("select * from Players order by wins desc");
    	    while(rs.next()) {
    	    	first_name = rs.getString(1);
    	    	last_name = rs.getString(2);
    	    	emp_id = rs.getString(3);
    	    	dept_name = rs.getString(4);
    	    	objects[i] = new User(first_name,last_name,emp_id,dept_name);
    	    	i++;
    	    	System.out.println("User details : "+first_name+","+last_name+","+emp_id+","+dept_name);
    	    }
    	    con.close();
    	    
    	    return objects;
    	    }catch(Exception e){ System.out.println(e);}
    	
    	

        return null;
    	
    }
    
    public Game[] loadGames() {
    	String time,white_name,black_name,result,game_string;
    	
    	Game[] objects = new Game[10];
    
    	try{
    		int i = 0;
    	    Class.forName("com.mysql.cj.jdbc.Driver");  
    	    Connection con=DriverManager.getConnection(  
    	    "jdbc:mysql://localhost:3306/MVC_Project","gagan","password");  
    	    Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	       ResultSet.CONCUR_READ_ONLY);  
    	    ResultSet rs=stmt.executeQuery("select * from Games");
    	    while(rs.next()) {
    	    	time = rs.getString(1);
    	    	white_name = rs.getString(2);
    	    	black_name = rs.getString(3);
    	    	result = rs.getString(4);
    	    	game_string = rs.getString(5);
    	    	objects[i] = new Game(time,white_name,black_name,result,game_string);
    	    	i++;
    	    }
    	    con.close();
    	    
    	    return objects;
    	    }catch(Exception e){ System.out.println(e);}
    	
    	

        return null;
    	
    }


}
