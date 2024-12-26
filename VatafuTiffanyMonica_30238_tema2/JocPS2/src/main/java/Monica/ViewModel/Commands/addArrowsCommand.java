package Monica.ViewModel.Commands;

import Monica.Model.Arrow;
import Monica.Model.GameState;
import Monica.ViewModel.ViewModel;

public class addArrowsCommand implements ICommand{
    private ViewModel vm;

    public addArrowsCommand(ViewModel vm) {
        this.vm = vm;
    }

    @Override
    public void execute() {
        Arrow arrow = new Arrow(vm.getDirectionArrow(),vm.isMyturn());
        GameState game = vm.getGame();
        game.getArrowTable().addArrow(vm.getxNewArrow(),vm.getyNewArrow(),arrow);
        game.setLastArrow(arrow);
        game.setLastMoveX(vm.getxNewArrow());
        game.setLastMoveY(vm.getyNewArrow());
        vm.setLostGame(game.getArrowTable().gameOver(vm.getxNewArrow(),vm.getyNewArrow(),arrow));
        if(vm.isLostGame()){
            vm.setTitle("You lost :(");
        }
    }
}
