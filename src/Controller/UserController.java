package Controller;

import Model.Database;
import Model.User;
import View.Form;
import View.GameDetails;
import View.UserDetails;

import javax.swing.*;
import java.io.File;

public class UserController {
	
    // database file
    private Database database;
    private Form form;
    private UserDetails userDetails;
    private GameDetails gameDetails;

    public UserController(Form form, UserDetails userDetails, GameDetails gameDetails) {
        this.database = new Database();
        this.form = form;
        this.userDetails = userDetails;
        this.gameDetails = gameDetails;


        // load users
        this.form.viewPlayers(e -> {
            this.userDetails.getPlayers(this.database.loadUsers());
        });
        
        // load games
        this.form.viewGames(e -> {
            this.gameDetails.getGames(this.database.loadGames());
        });
    }
}
