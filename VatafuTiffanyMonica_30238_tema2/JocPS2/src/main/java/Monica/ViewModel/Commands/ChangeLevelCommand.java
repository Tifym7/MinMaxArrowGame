package Monica.ViewModel.Commands;


import Monica.Model.GameState;
import Monica.ViewModel.ViewModel;

public class ChangeLevelCommand implements ICommand{

    private ViewModel vm;

    public ChangeLevelCommand(ViewModel vm) {
        this.vm = vm;
    }

    @Override
    public void execute() {
        vm.setVisibleLevel1(!vm.getVisibleLevel1());
        vm.setVisibleLevel2(!vm.getVisibleLevel2());
        String title = "Level" + (vm.getVisibleLevel1() ? " 1" : " 2");
        vm.setTitle(title);
        int dimensionPanel = vm.getVisibleLevel1() ? 4 : 8;
        vm.setDimensionPanel(dimensionPanel);
        vm.setGame(new GameState(dimensionPanel));
    }
}
