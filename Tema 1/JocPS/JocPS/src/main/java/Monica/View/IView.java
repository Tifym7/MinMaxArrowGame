package Monica.View;

import Monica.Model.Direction;

import javax.swing.*;

public interface IView {
    void setArrow(boolean me, int position, Direction dir);
    Direction readFromCombo();
    int getLevel();
    int getPosition();
    JButton getButton(int pos);
    void setMessageTitle(String message);
}
