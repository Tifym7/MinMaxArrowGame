package Monica;

import Monica.Model.Arrow;
import Monica.Model.ArrowTable;
import Monica.Model.Direction;
import Monica.Model.GameState;
import Monica.View.View;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )



    {
//        System.out.println( "Hello World!" );
//        Arrow a1 = new Arrow(Direction.S,true);
//        Arrow a2 = new Arrow(Direction.N,false);
//        Arrow a3 = new Arrow(Direction.V,true);
//        Arrow a4 = new Arrow(Direction.E,false);
//        Arrow a5 = new Arrow(Direction.S,true);
//        ArrowTable game = new ArrowTable(1);
//        game.addArrow(0,0,a1);
//        game.addArrow(0,1,a2);
//        game.addArrow(0,2,a3);
//        game.addArrow(0,3,a4);
//        game.addArrow(1,2,a5);
//
//        System.out.println(game.getGameTable()[1][2].getType());
//        GameState firstState = new GameState(true,game,1,2,a5);
//        System.out.println("fist \n"+game);
//        System.out.println(firstState.evaluateFunction(1,2,a5));
//        GameState state = null;
//        int maxim = -999;
//        for (GameState nextState:firstState.nextStates()
//             ) {
//            int utility = GameState.minimax(false,0,nextState);
//            System.out.println(nextState+" ->utility: "+utility);
//            if(utility > maxim){
//                maxim = utility;
//                state = nextState;
//            }
//
//        }
//        System.out.println("Final\n"+state);
//        GameState secondState = null;
//        Arrow a6 = new Arrow(Direction.E,true);
//        state.getArrowTable().addArrow(2,0,a6);
//        System.out.println(state);
//        maxim = -999;
//        int utility = 0;
//        for (GameState nextState:state.nextStates()
//        ) {
//            utility = GameState.minimax(false,0,nextState);
//            System.out.println(nextState+" ->utility: "+utility);
//            if(utility > maxim){
//                maxim = utility;
//                secondState = nextState;
//            }
//        }
//        System.out.println("First\n"+state);
//        System.out.println("Ramane\n"+secondState+ "->utility "+maxim);
        View view = new View();



    }
}
