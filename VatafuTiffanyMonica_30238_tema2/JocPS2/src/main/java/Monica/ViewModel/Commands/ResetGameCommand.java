package Monica.ViewModel.Commands;

import Monica.Model.Direction;
import Monica.Model.GameState;
import Monica.ViewModel.ViewModel;

public class ResetGameCommand  implements ICommand{
    private ViewModel vm;

    public ResetGameCommand(ViewModel vm) {
        this.vm = vm;
    }

    @Override
    public void execute() {
        vm.setDirectionArrow(Direction.noDir);
        vm.setxNewArrow(0);
        vm.setyNewArrow(0);
        String title = "Level" + (vm.getVisibleLevel1() ? " 1" : " 2");
        vm.setTitle(title);
        vm.setGame(new GameState(vm.getDimensionPanel()));

    }
}
