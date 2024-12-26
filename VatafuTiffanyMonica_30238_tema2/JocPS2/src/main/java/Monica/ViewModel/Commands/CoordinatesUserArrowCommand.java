package Monica.ViewModel.Commands;

import Monica.ViewModel.ViewModel;

public class CoordinatesUserArrowCommand implements ICommand{

    private ViewModel vm;

    public CoordinatesUserArrowCommand(ViewModel vm) {
        this.vm = vm;
    }

    @Override
    public void execute() {
        int buttonIndex = vm.getIndexButtonGame();
        int y = buttonIndex/vm.getDimensionPanel();
        int x = buttonIndex-vm.getDimensionPanel()*y;
        vm.setxNewArrow(x);
        vm.setyNewArrow(y);
    }
}
