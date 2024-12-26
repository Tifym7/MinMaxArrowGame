package Monica;

import Monica.DAO.ScoreDAO;
import Monica.DAO.UserDAO;
import Monica.GUI.View.*;
import Monica.Model.Score;
import Monica.Model.User;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        //GameView gView = new GameView();
        LanguageObservable lang = new LanguageObservable();
        LogView logView = new LogView(lang);

    }
}
