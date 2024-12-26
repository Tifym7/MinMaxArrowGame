package Monica.Presenter;

import Monica.Model.Arrow;
import Monica.Model.Direction;
import Monica.Model.GameState;
import Monica.View.IView;

public class PMinimax {
    private IView iView;
    private GameState state;

    public PMinimax(IView iView) {
        this.iView = iView;
        state = new GameState(iView.getLevel());

    }

    public boolean addArrowP(boolean me){
        int level = iView.getLevel();
        int position = iView.getPosition();
        int y = position/level;
        int x = position-level*y;
        Arrow arrow = new Arrow(iView.readFromCombo(), me);
        state.getArrowTable().addArrow(x,y,arrow);
        state.setLastArrow(arrow);
        state.setLastMoveX(x);
        state.setLastMoveY(y);
        return !state.getArrowTable().gameOver(x,y,arrow);
    }
    public void gameOverP(boolean me){
        if(me){
            iView.setMessageTitle("You lost :(");
        }else{
            iView.setMessageTitle("You won ! ");
        }
    }
    public boolean nextMove(){
        int maxim = -999;
        GameState newState = null;
        for(GameState nextState:state.nextStates()) {
            int utility = GameState.minimax(false, 0, nextState);
            if (utility > maxim) {
                maxim = utility;
                newState = nextState;
            }
        }
        System.out.println(maxim);
        state = newState;
        int x = state.getLastMoveX();
        int y = state.getLastMoveY();
        int position = y*iView.getLevel() + x;
        Direction dir = state.getLastArrow().getType();
        iView.setArrow(false,position,dir);
        return state.getArrowTable().gameOver(x,y,state.getLastArrow());



    }



}
