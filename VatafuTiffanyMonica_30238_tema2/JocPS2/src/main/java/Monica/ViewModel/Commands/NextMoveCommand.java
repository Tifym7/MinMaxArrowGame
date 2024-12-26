package Monica.ViewModel.Commands;

import Monica.Model.Direction;
import Monica.Model.GameState;
import Monica.ViewModel.ViewModel;

public class NextMoveCommand implements ICommand{
    private ViewModel vm;

    public NextMoveCommand(ViewModel vm) {
        this.vm = vm;
    }

    @Override
    public void execute() {
        GameState game = vm.getGame();
        int maxim = -999;
        GameState newState = null;
        for(GameState nextState:game.nextStates()) {
            int utility = GameState.minimax(false, 0, nextState);
            if (utility > maxim) {
                maxim = utility;
                newState = nextState;
            }
        }
        vm.setGame(newState);
        game = newState;
        int x = game.getLastMoveX();
        int y = game.getLastMoveY();
        int position = y*vm.getDimensionPanel() + x;
        Direction dir = game.getLastArrow().getType();
        vm.setyNewArrow(x);
        vm.setyNewArrow(y);
        vm.setIndexButtonGame(position);
        vm.setDirectionArrow(dir);
        vm.setLostGame(game.getArrowTable().gameOver(x,y,game.getLastArrow()));
        if(vm.isLostGame()){
            vm.setTitle("You won ! :)");
        }



    }
}
