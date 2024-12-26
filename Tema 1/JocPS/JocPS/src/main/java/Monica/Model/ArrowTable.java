package Monica.Model;

import java.util.Arrays;

public class ArrowTable implements Cloneable{
    private int level;
    private Arrow[][] gameTable;

    public ArrowTable(int level) {
        this.level = level;
        gameTable = new Arrow[this.level][this.level];
        for (int i=0;i<this.level;i++){
            for(int j=0;j<this.level;j++)
            gameTable[i][j] = new Arrow();
        }

    }

    public ArrowTable(int level, Arrow[][] gameTable) {
        this.level = level;
        this.gameTable = new Arrow[this.level][this.level] ;
        for(int i=0;i<this.level;i++){
            for(int j=0;j<this.level;j++){
                this.gameTable[i][j] = gameTable[i][j];
            }
        }
    }

    public Arrow[][] getGameTable() {
        return gameTable;
    }

    public int getLevel() {
        return level;
    }

    public void addArrow(int x, int y, Arrow arrow){
        if(gameTable[x][y].getType()==Direction.noDir)
            gameTable[x][y] = (Arrow) arrow.clone();

    }
    public boolean gameOver(int x,int y,Arrow arrow){ //verified
        for(int i=0;i<level;i++){ // verificare verticala si orizontala
            if(gameTable[x][i].equals(arrow) && i != y)
                return true;
            if(gameTable[i][y].equals(arrow) && i!=x){
                return true;
            }
        }
        //pentru diagonale
        int ixLeft,iyLeft,ixRight,iyRight;
        if(x>y){
            iyLeft = 0;
            ixLeft = x-y;
        }else{
            ixLeft = 0;
            iyLeft = y-x;
        }
        while(ixLeft < level && iyLeft < level){
            if(gameTable[ixLeft][iyLeft].equals(arrow) && ixLeft!=x && iyLeft!=y){
                return true;
            }
            ixLeft ++;
            iyLeft ++;
        }
        ixRight = x;
        iyRight = y;
        while(ixRight < level && iyRight >= 0){
            if(gameTable[ixRight][iyRight].equals(arrow) && ixRight!=x && iyLeft!=y){
                return true;
            }
            ixRight ++;
            iyRight --;
        }
        ixRight = x;
        iyRight = y;
        while(ixRight >= 0 && iyRight < level){
            if(gameTable[ixRight][iyRight].equals(arrow) && ixRight!=x && iyLeft!=y){
                return true;
            }
            ixRight --;
            iyRight ++;
        }
        return false;
}
    public int getNoBlockedPositions(int x,int y, Arrow arrow){
        int blocked = 0;
        for(int i=0;i<level;i++){ // verificare verticala si orizontala
            if(gameTable[x][i].getType()==Direction.noDir){
                blocked++;
            }
            if(gameTable[i][y].getType()==Direction.noDir){
                blocked++;
            }
        }
        //pentru diagonale
        int ixLeft,iyLeft,ixRight,iyRight;
        if(x>y){
            iyLeft = 0;
            ixLeft = x-y;
        }else{
            ixLeft = 0;
            iyLeft = y-x;
        }
        while(ixLeft < level && iyLeft < level){
            if(gameTable[ixLeft][iyLeft].getType()==Direction.noDir){
                blocked++;
            }
            ixLeft ++;
            iyLeft ++;
        }
        ixRight = x;
        iyRight = y;
        while(ixRight < level && iyRight >= 0){
            if(gameTable[ixRight][iyRight].getType()==Direction.noDir){
                blocked++;
            }
            ixRight ++;
            iyRight --;
        }
        ixRight = x;
        iyRight = y;
        while(ixRight >= 0 && iyRight < level){
            if(gameTable[ixRight][iyRight].getType()==Direction.noDir){
                blocked++;
            }
            ixRight --;
            iyRight ++;
        }
        return blocked;
    }

    @Override
    public String toString() {
        String s="";
        for(int i=0;i<level;i++){
            for(int j=0;j<level;j++){
                s += " ";
                s += gameTable[j][i].getType();
            }
            s += "\n";
        }
        return s;
    }
}
