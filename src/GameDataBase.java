import java.io.*;

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

			String loc = "/home/gagan/Desktop/6th SEM/My-Chess/games.csv";
	
			FileWriter fstream = new FileWriter(loc, true);
			BufferedWriter out = new BufferedWriter(fstream);

			int lines = 0;
			try (BufferedReader reader = new BufferedReader(new FileReader(loc))) {
				while (reader.readLine() != null) lines++;
			} catch (IOException e) {
				e.printStackTrace();
			}

			int gameno;
			if(lines%2==0){
				gameno = (lines/2)+1;
			}
			else{
				gameno = ((lines-1)/2)+1;
			}
	
			System.out.print("no of lines are : "+lines+" Writing....");
			out.write("\n"+gameno+","+Time+","+WPlayerName+","+BPlayerName+","+Result+","+Game);
			System.out.print("Written!");
			out.newLine();
	
			//close buffer writer
			out.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}