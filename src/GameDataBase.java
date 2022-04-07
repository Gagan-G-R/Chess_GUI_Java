import java.io.*;
import java.sql.*;

public class GameDataBase {

	String WPlayerName;
	String BPlayerName;
	String Time;
	String Game;
	String Result;

	GameDataBase(String WPlayerName, String BPlayerName , String Time, String Result , String Game) {
		this.WPlayerName = WPlayerName;
		this.BPlayerName = BPlayerName;
		this.Time = Time;
		this.Result = Result;
		this.Game = Game;
	}

	public void PutData(){
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");  
    	    Connection con=DriverManager.getConnection(  
    	    "jdbc:mysql://localhost:3306/MVC_Project","gagan","password");  
    	    Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	       ResultSet.CONCUR_READ_ONLY);  
    	    stmt.executeUpdate("insert into Games values(\""+this.Time+"\",\""+this.WPlayerName+"\",\""+this.BPlayerName+"\",\""+this.Result+"\",\""+this.Game+"\");");
    	    con.close();  
    	    }
		catch(Exception e){ 
			System.out.println(e);
		}
	}
}