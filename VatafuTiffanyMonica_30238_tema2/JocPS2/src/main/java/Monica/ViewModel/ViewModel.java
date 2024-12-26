package Monica.ViewModel;

import Monica.Model.Direction;
import Monica.Model.GameState;
import Monica.ViewModel.Commands.*;

public class ViewModel {
    private String title;
    private Boolean visibleLevel1;
    private Boolean visibleLevel2;
    private int indexButtonGame;
    private int xNewArrow;
    private int yNewArrow;
    private Direction directionArrow;
    private int dimensionPanel;
    private GameState game;
    private boolean myturn;
    private boolean lostGame;


    public ICommand changeLevel;
    public ICommand resetGame;
    public ICommand coordinatesUserArrow;
    public ICommand addArrows;
    public ICommand nextMove;

    public ViewModel() {
        visibleLevel1 = true;
        visibleLevel2 = false;
        dimensionPanel = 4;
        title = "Level 1";
        game = new GameState(dimensionPanel);
        lostGame = false;
        this.changeLevel = new ChangeLevelCommand(this);
        this.resetGame = new ResetGameCommand(this);
        this.coordinatesUserArrow = new CoordinatesUserArrowCommand(this);
        this.addArrows = new addArrowsCommand(this);
        this.nextMove = new NextMoveCommand(this);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getVisibleLevel1() {
        return visibleLevel1;
    }

    public void setVisibleLevel1(Boolean visibleLevel1) {
        this.visibleLevel1 = visibleLevel1;
    }

    public Boolean getVisibleLevel2() {
        return visibleLevel2;
    }

    public void setVisibleLevel2(Boolean visibleLevel2) {
        this.visibleLevel2 = visibleLevel2;
    }

    public int getxNewArrow() {
        return xNewArrow;
    }

    public void setxNewArrow(int xNewArrow) {
        this.xNewArrow = xNewArrow;
    }

    public int getyNewArrow() {
        return yNewArrow;
    }

    public void setyNewArrow(int yNewArrow) {
        this.yNewArrow = yNewArrow;
    }

    public Direction getDirectionArrow() {
        return directionArrow;
    }

    public void setDirectionArrow(Direction directionArrow) {
        this.directionArrow = directionArrow;
    }

    public int getDimensionPanel() {
        return dimensionPanel;
    }

    public void setDimensionPanel(int dimensionPanel) {
        this.dimensionPanel = dimensionPanel;
    }

    public int getIndexButtonGame() {
        return indexButtonGame;
    }

    public void setIndexButtonGame(int indexButtonGame) {
        this.indexButtonGame = indexButtonGame;
    }

    public GameState getGame() {
        return game;
    }

    public void setGame(GameState game) {
        this.game = game;
    }

    public boolean isLostGame() {
        return lostGame;
    }

    public void setLostGame(boolean lostGame) {
        this.lostGame = lostGame;
    }

    public boolean isMyturn() {
        return myturn;
    }

    public void setMyturn(boolean myturn) {
        this.myturn = myturn;
    }
}
