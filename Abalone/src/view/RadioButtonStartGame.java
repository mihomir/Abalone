package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import controller.ActionGameStart;
import controller.PopupController;

/*
 * RadioButtonDemo.java requires these files:
 *   images/Bird.gif
 *   images/Cat.gif
 *   images/Dog.gif
 *   images/Rabbit.gif
 *   images/Pig.gif
 */
public class RadioButtonStartGame extends JPanel
                             implements ActionListener {
    static String human = "Human-Human";
    static String computer = "Human-Ordinateur";
    public ButtonGroup group;
   

    public RadioButtonStartGame() {
        super(new BorderLayout());

        //Create the radio buttons.
        JRadioButton humanButton = new JRadioButton(human);
        humanButton.setMnemonic(KeyEvent.VK_B);
        humanButton.setActionCommand(human);
//        humanButton.setSelected(true);

        JRadioButton computerButton = new JRadioButton(computer);
        computerButton.setMnemonic(KeyEvent.VK_C);
        computerButton.setActionCommand(computer);
        computerButton.setSelected(true);



        //Group the radio buttons.
        ButtonGroup groupbuttons = new ButtonGroup();
        JTextField jtf = new JTextField("ASD");

        groupbuttons.add(humanButton);
        groupbuttons.add(computerButton);
        group=groupbuttons;
        System.out.println("Group in constructor is "+ group);


        //Register a listener for the radio buttons.
        humanButton.addActionListener(this);
        computerButton.addActionListener(this);
       
        //Put the radio buttons in a column in a panel.
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(humanButton);
        radioPanel.add(computerButton);
        
        add(radioPanel, BorderLayout.LINE_START);
        setBorder(BorderFactory.createEmptyBorder(60,60,60,60));
    }

    /** Listens to the radio buttons. */
    public void actionPerformed(ActionEvent e) {
     String choice = group.getSelection().getActionCommand();
        System.out.println("Action button Selected: " + choice);
    	;
    }

    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = RadioButtonStartGame.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }

    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event-dispatching thread.
     */
    public  void createAndShowGUI(DrawMain dm, boolean exitGame) {

        JDialog jd = new JDialog();
        jd.setBounds(450,300,200,200);
        if(exitGame){jd.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);}
        dm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    	 JComponent newContentPane = new RadioButtonStartGame();
    	 
    	 newContentPane.setOpaque(true);
    	 jd.setContentPane(newContentPane);
    	 JButton choose = new JButton("Choisir");
    	 newContentPane.add(choose);
    	 jd.pack();

    	  String choice = group.getSelection().getActionCommand();

    	 choose.addActionListener(new ActionGameStart("New Game", dm, jd,choice));

   	 jd.setModalityType(Dialog.ModalityType.APPLICATION_MODAL );

    	 jd.setVisible(true);
    }

}
