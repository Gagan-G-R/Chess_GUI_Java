import java.io.*;
import java.sql.*;
import java.util.*;

public class PlayerDataBase {

	String Name;
	COLOUR winner;
	String type;
	int count=0;
	int Lcount=1;
	int wins=0;
	int loss=0;
	int draws=0;

	PlayerDataBase(String Name,COLOUR turn, String type) {
		this.Name = Name;
		this.type = type;
		this.winner = turn;
	}


	
	public void getData(){
		
		
	}

	public void PutData(){
		
		if(this.type == "B") {
			if(this.winner == COLOUR.W) {
				count =1;
				Lcount=0;
			}
		}
		if(this.type == "W") {
			if(this.winner == COLOUR.B) {
				count =1;
				Lcount=0;
			}
		}
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");  
    	    Connection con=DriverManager.getConnection(  
    	    "jdbc:mysql://localhost:3306/MVC_Project","gagan","password");  
    	    Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	       ResultSet.CONCUR_READ_ONLY);  
    	    ResultSet res = stmt.executeQuery("select * from Players where Name=\""+this.Name+"\"");
    	    while(res.next()) {
    	    	wins = res.getInt(2);
        	    loss  = res.getInt(3);
        	    draws = res.getInt(4);
        	    System.out.println("Wins: "+wins);
        	    System.out.println("Loss: "+loss);
        	    System.out.println("Draw: "+draws);
        	    
    	    }
    	    stmt.executeUpdate("delete from Players where Name=\""+this.Name+"\"");
    	    
    	    con.close();  
    	    }
		catch(Exception e){ 
			System.out.println("Bro full errors: "+e);
		}
		
		try{
			Class.forName("com.mysql.cj.jdbc.Driver");  
    	    Connection con=DriverManager.getConnection(  
    	    "jdbc:mysql://localhost:3306/MVC_Project","gagan","password");  
    	    Statement stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
    	       ResultSet.CONCUR_READ_ONLY);  
    	    stmt.executeUpdate("insert into Players values(\""+this.Name+"\",\""+(this.count+wins)+"\",\""+(this.Lcount+loss)+"\",\""+draws+"\");");
    	    con.close();  
    	    }
		catch(Exception e){ 
			System.out.println(e);
		}
		
	}
}