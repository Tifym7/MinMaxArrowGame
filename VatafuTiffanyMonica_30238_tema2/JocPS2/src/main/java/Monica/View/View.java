package Monica.View;

import Monica.Model.Direction;
import Monica.ViewModel.ViewModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class View extends JFrame{
    JLabel titleField;
    JPanel title_panel;
    JPanel moves_panel;
    JPanel button_panel;
    JButton[] buttons;
    JButton level;
    JButton reset;
    JButton add;
    JComboBox directionLv1;
    JComboBox directionLv2;
    ViewModel vm;

    public View() {
        vm = new ViewModel();
        titleField = new JLabel();
        title_panel = new JPanel();
        moves_panel = new JPanel();
        button_panel = new JPanel();
        buttons = new JButton[16];
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.getContentPane().setBackground(new Color(50,50,50));
        this.setLayout(new BorderLayout());
        this.setVisible(true);


        titleField.setBackground(new Color(171, 214, 230));
        titleField.setForeground(new Color(10, 34, 57));
        titleField.setFont(new Font(Font.SERIF,Font.BOLD,75));
        titleField.setHorizontalAlignment(JLabel.CENTER);
        titleField.setOpaque(true);
        titleField.setText("Level 1");
        level = new JButton("Change Level");
        level.setFont(new Font(Font.DIALOG,Font.BOLD,20));
        level.addActionListener(new ChangeLevelListener());
        reset = new JButton("Restart Game");
        reset.addActionListener(new RestartListener());
        reset.setFont(new Font(Font.DIALOG,Font.BOLD,20));

        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);


        button_panel.setLayout(new GridLayout(4,4));


        for(int i=0;i<16;i++) {
            buttons[i] = new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font(Font.DIALOG,Font.BOLD,120));
            buttons[i].setBackground(new Color(250, 243, 221));
            buttons[i].addActionListener(new WhereArrowListener());

        }

        directionLv1 = new JComboBox();
        directionLv1.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        directionLv1.setBackground(new Color(255, 255, 255));
        directionLv1.addItem(Direction.N);
        directionLv1.addItem(Direction.S);
        directionLv1.addItem(Direction.E);
        directionLv1.addItem(Direction.V);

        directionLv2 = new JComboBox();
        directionLv2.setFont(new Font(Font.DIALOG,Font.BOLD,17));
        directionLv2.setBackground(new Color(255, 255, 255));
        directionLv2.addItem(Direction.N);
        directionLv2.addItem(Direction.S);
        directionLv2.addItem(Direction.E);
        directionLv2.addItem(Direction.V);
        directionLv2.addItem(Direction.NV);
        directionLv2.addItem(Direction.SV);
        directionLv2.addItem(Direction.NE);
        directionLv2.addItem(Direction.SE);


        moves_panel = new JPanel();
        moves_panel.setLayout(new BorderLayout());

        JLabel positionArrow = new JLabel();
        positionArrow.setFont(new Font(Font.SERIF,Font.BOLD,20));
        positionArrow.setHorizontalAlignment(JLabel.CENTER);
        positionArrow.setOpaque(true);
        positionArrow.setBackground(new Color(255, 255, 255));
        positionArrow.setText("Choose arrow type:");

        add = new JButton("Add arrow");
        add.setFont(new Font(Font.SERIF,Font.BOLD,20));
        add.addActionListener(new SubmitArrowListener());

        JPanel textfieldsXYPanel = new JPanel();
        JPanel textfieldsXYPanelAux = new JPanel();
        textfieldsXYPanel.setBackground(new Color(255, 255, 255));
        textfieldsXYPanel.setLayout(new BoxLayout(textfieldsXYPanel,BoxLayout.Y_AXIS));

        textfieldsXYPanel.add( Box.createRigidArea(new Dimension(0,200)) );
        textfieldsXYPanel.add(positionArrow);
        textfieldsXYPanel.add( Box.createRigidArea(new Dimension(0,20)) );
        textfieldsXYPanel.add(directionLv1);
        textfieldsXYPanel.add(directionLv2);
        directionLv2.setVisible(false);
        textfieldsXYPanelAux.setBackground(new Color(255, 255, 255));
        textfieldsXYPanel.add( Box.createRigidArea(new Dimension(0,20)) );
        textfieldsXYPanel.add(add);
        textfieldsXYPanelAux.add(textfieldsXYPanel);

        moves_panel.add(textfieldsXYPanelAux,BorderLayout.CENTER);

        JPanel title_aux = new JPanel();
        title_aux.setBackground(new Color(171, 214, 230));
        title_aux.add(titleField);
        title_aux.add(level);
        title_aux.add(reset);
        title_panel.add(title_aux);
        this.add(title_panel,BorderLayout.NORTH);
        this.add(moves_panel,BorderLayout.EAST);
        this.add(button_panel,BorderLayout.CENTER);

        this.setVisible(true);
    }
    class RestartListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton buttonPressed = (JButton) e.getSource();
            button_panel.removeAll();
            int dimensions = vm.getDimensionPanel();
            for(int i=0;i<dimensions*dimensions;i++) {
                buttons[i] = new JButton();
                button_panel.add(buttons[i]);
                buttons[i].setFont(new Font(Font.DIALOG,Font.BOLD,120));
                buttons[i].addActionListener(new WhereArrowListener());
                buttons[i].setBackground(new Color(250, 243, 221));

            }
            vm.resetGame.execute();
            titleField.setText(vm.getTitle());
        }
    }
    class SubmitArrowListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Direction dir  = readFromCombo();
            int position = vm.getIndexButtonGame();
            setArrow(true,position,dir);
            vm.setDirectionArrow(dir);
            vm.addArrows.execute();
            if(!vm.isLostGame()){
                enableSubmitArrow(false);
                vm.nextMove.execute();
                setArrow(false,vm.getIndexButtonGame(),vm.getDirectionArrow());
                enableSubmitArrow(true);
            }
            titleField.setText(vm.getTitle());

        }

    }
    public void enableSubmitArrow(boolean enable){
        add.setEnabled(enable);
    }


    public void setArrow(boolean me,int position, Direction dir) {
        ImageIcon icon = null;
        String fileName = "";
        if(me){
            fileName += "blue";
        }else{
            fileName += "green";
        }
        fileName += dir;
        fileName += ".png";
        icon = new ImageIcon(new ImageIcon(fileName).getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        icon.setDescription(dir.name());
        buttons[position].setIcon(icon);
        buttons[position].setBackground(new Color(250, 243, 221));
    }

    public Direction readFromCombo() {
        Direction dir = vm.getVisibleLevel1() ? (Direction) directionLv1.getSelectedItem() : (Direction) directionLv2.getSelectedItem();
        System.out.println(dir);
        return dir;
    }

    class ChangeLevelListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            button_panel.removeAll();
            vm.changeLevel.execute();
            int dimensions = vm.getDimensionPanel();
            titleField.setText(vm.getTitle());
            buttons = new JButton[dimensions*dimensions];
            button_panel.setLayout(new GridLayout(dimensions,dimensions));
            for(int i=0;i<dimensions*dimensions;i++) {
                buttons[i] = new JButton();
                button_panel.add(buttons[i]);
                buttons[i].setFont(new Font(Font.DIALOG,Font.BOLD,120));
                buttons[i].setBackground(new Color(250, 243, 221));
                buttons[i].addActionListener(new WhereArrowListener());
            }
            directionLv1.setVisible(vm.getVisibleLevel1());
            directionLv2.setVisible(vm.getVisibleLevel2());
        }
    }
    class WhereArrowListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            JButton buttonPressed = (JButton) e.getSource();
            int index = 0;
            int dimensions  = vm.getDimensionPanel();
            for(int i=0;i<dimensions*dimensions;i++) {
                button_panel.add(buttons[i]);
                buttons[i].setBackground(new Color(250, 243, 221));
                if(buttons[i] == buttonPressed){
                    index = i;
                }
            }
            buttonPressed.setBackground(new Color(104, 176, 171));
            vm.setIndexButtonGame(index);
            vm.coordinatesUserArrow.execute();
            System.out.println(vm.getIndexButtonGame());
            System.out.println(vm.getxNewArrow());
            System.out.println(vm.getyNewArrow());
        }
    }

}