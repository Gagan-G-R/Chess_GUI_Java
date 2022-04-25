package Model;

public class Game {
    private String time;
    private String White_Player;
    private String Black_Player;
    private String Result;
    private String game_string;

    public Game() {
        // empty constructor
    }

    public Game(String time, String White_Player, String Black_Player , String Result,String game_string) {
        this.time = time;
        this.Black_Player = Black_Player;
        this.White_Player = White_Player;
        this.game_string = game_string;
        this.Result = Result;
    }

    // getters
    public String getTime() {
        return time;
    }

    public String getWhite_Player() {
        return White_Player;
    }

    public String getBlack_Player() {
        return Black_Player;
    }

    public String getResult() {
        return Result;
    }
    
    public String getGame_String() {
        return game_string;
    }
    
    public String toString() {
    	return getTime()+","+getWhite_Player()+","+getBlack_Player()+","+getResult()+","+getGame_String();
    }
}
