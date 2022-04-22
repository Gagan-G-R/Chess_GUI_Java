package Model;
import java.sql.*;
import java.io.*;
import java.util.ArrayList;

public class Database {

    private ArrayList<User> userArrayList;

    public Database() {
        userArrayList = new ArrayList<>();
        
    }

    // adds user to our collection
    public void addUser(User user) {
        userArrayList.add(user);
    }


    // reads user from database file
    public Object[] loadUsers(File file) {
    	String time,White_Player,Black_Player,Result,Game;
    	try{  
    	    Class.forName("com.mysql.cj.jdbc.Driver");  
    	    Connection con=DriverManager.getConnection(  
    	    "jdbc:mysql://localhost:3306/MVC_Project","gagan","password");  
    	    Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	       ResultSet.CONCUR_READ_ONLY);  
    	    ResultSet rs=stmt.executeQuery("select * from Games;");
    	    while(rs.next()) {
    	    	time = rs.getString(1);
    	    	White_Player  = rs.getString(2);
    	    	Black_Player  =  rs.getString(3);
    	    	Result = rs.getString(4);
    	    	Game = rs.getString(5);
    	    }
    	    
    	    con.close();  
    	    }catch(Exception e){ System.out.println(e);}
    	
    	
        Object[] objects;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            // each lines to array
            objects = bufferedReader.lines().toArray();
            bufferedReader.close();
            return objects;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    	
    }


}
