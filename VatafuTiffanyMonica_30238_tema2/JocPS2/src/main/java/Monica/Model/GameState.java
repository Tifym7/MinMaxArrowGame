package Monica.Model;

import java.util.*;

public class GameState {
    private boolean isMe;
    private int lastMoveX;
    private int lastMoveY;
    private Arrow lastArrow;
    private ArrowTable arrowTable;

    public GameState(boolean isMe, ArrowTable arrowTable,int x,int y,Arrow arrow) {
        this.isMe = isMe;
        this.arrowTable = arrowTable;
        this.lastArrow = arrow;
        this.lastMoveX = x;
        this.lastMoveY = y;
    }

    public GameState(int level) {
        this.isMe = true;
        this.arrowTable = new ArrowTable(level);
    }

    public ArrowTable getArrowTable() {
        return arrowTable;
    }

    public int getLastMoveX() {
        return lastMoveX;
    }

    public int getLastMoveY() {
        return lastMoveY;
    }

    public Arrow getLastArrow() {
        return lastArrow;
    }

    public void setLastMoveX(int lastMoveX) {
        this.lastMoveX = lastMoveX;
    }

    public void setLastMoveY(int lastMoveY) {
        this.lastMoveY = lastMoveY;
    }

    public void setLastArrow(Arrow lastArrow) {
        this.lastArrow = lastArrow;
    }

    public List<GameState> nextStates(){
        ArrowTable currentGame = this.arrowTable;
        Direction[] dirLev2 = {Direction.NV,Direction.NE,Direction.SV,Direction.SE};
        int level = currentGame.getLevel();
        ArrayList<GameState> nextStatesList = new ArrayList<>();
        ArrowBuilder arrowBuilder = new ArrowBuilder();
        for(int i=0;i<level;i++){
            for(int j=0;j<level;j++){
                if(arrowTable.getGameTable()[i][j].getType() == Direction.noDir){ //daca e libera pozitia
                    for (Direction dir:Direction.values()) {
                            if(dir!=Direction.noDir && !(arrowTable.getLevel() == 4 && Arrays.asList(dirLev2).contains(dir)) ){
                                Arrow arrow = arrowBuilder.createDirectionArrow(dir,!this.isMe);
                                GameState gameState = new GameState(!this.isMe,new ArrowTable(level,currentGame.getGameTable().clone()),i,j,arrow);
                                gameState.arrowTable.addArrow(i,j,arrow);
                                nextStatesList.add(gameState);
                            }
                    }
                }
            }
        }
        return nextStatesList;
    }
    public static int minimax(boolean isMax,int depth,GameState gameState){
        if(gameState.arrowTable.gameOver(gameState.lastMoveX,gameState.lastMoveY,gameState.lastArrow)){
            return -100;
        }else{
            if(depth ==0 || gameState.arrowTable.gameOver(gameState.lastMoveX,gameState.lastMoveY,gameState.lastArrow)){
                return gameState.evaluateFunction(gameState.lastMoveX, gameState.lastMoveY,gameState.lastArrow);
            }
        }
        if(isMax){
            int maxim = -999;
            for (GameState nextState:gameState.nextStates()
                 ) {
                maxim = Math.max(minimax(!isMax,depth+1,nextState),maxim);
            }
            return maxim;
        }else{
            int minim  = -999;
            for(GameState nextState:gameState.nextStates()){
                minim = Math.max(minimax(!isMax,depth+1,nextState),minim);
            }
            return minim;
        }
    }
    public int evaluateFunction(int x,int y,Arrow arrow){
        int utility = arrowTable.getNoBlockedPositions(x, y, arrow);
        return utility;
    }

    @Override
    public String toString() {
        return arrowTable.toString();
    }
}
