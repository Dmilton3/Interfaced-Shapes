import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * Created by Dewey Milton on 10/18/2016.
 * Name: mainFrame
 * Description: Creates the main window creating an user interface
 * to display a sub-frame, add/remove shapes, and exit the program
 */
public class mainFrame {

    private JFrame frame;
    private Panel mainPanel;
    private Panel buttonPanel;
    private Panel checkBoxPanel;
    private JButton show;
    private JButton add;
    private JButton remove;
    private JButton exit;
    private JCheckBox uFO;
    private JCheckBox cloud;
    private JCheckBox bird;
    private subPanel subP;
    private GridBagConstraints c;

    /*
      mainFrame constructor
     */
    public mainFrame(){


        subP = new subPanel(); //Creates the subPanel

        //Setup for the frame
        frame = new JFrame();
        frame.setSize(600,400);
        frame.setTitle("Program 2");

        //setup for the main content panel in the frame
        mainPanel = new Panel();
        mainPanel.setSize(600,400);
        mainPanel.setLayout(new GridLayout(1, 2));
        mainPanel.setBackground(new Color(92, 45, 57));
        frame.add(mainPanel);

        //Creates a Panel to hold the buttons
        buttonPanel = new Panel();
        buttonPanel.setLayout(new GridBagLayout());
        buttonPanel.setBackground(new Color(5, 10, 45));

        //Creates a Panel for the checkboxes
        checkBoxPanel = new Panel();
        checkBoxPanel.setLayout(new GridBagLayout());
        checkBoxPanel.setBackground(new Color(29, 62, 19));

        //Grid constraints to space out buttons and checkboxes
        c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.anchor = GridBagConstraints.CENTER;
        c.insets = new Insets(5,5,5,5);
        c.gridwidth = 100;

        //Setup for buttonPanel
        buttonPanel.setSize(300,400);
        buttonPanel.setPreferredSize(new Dimension(300,400));
        buttonPanel.setVisible(true);
        mainPanel.add(buttonPanel);

        //Setup for checkBoxPanel
        checkBoxPanel.setSize(300,400);
        checkBoxPanel.setPreferredSize(new Dimension(300,400));
        checkBoxPanel.setVisible(true);
        mainPanel.add(checkBoxPanel);

        //Create buttons for button Panel
        show = new JButton("Show");
        show.setSize(75,50);

        buttonPanel.add(show, c);
        c.gridy ++;
        show.setVisible(true);

        add = new JButton("Add");
        add.setSize(75,50);
        add.setVisible(true);
        buttonPanel.add(add, c);
        c.gridy ++;

        remove = new JButton("Remove");
        remove.setSize(50,50);
        remove.setVisible(true);

        //ActionListener for button to call remove operation
        //in the subPanel class.
        remove.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(subP.getShown()) {
                    subP.remove();
                }
            }
        });
        buttonPanel.add(remove);


        //Create an Exit button
        exit = new JButton("Exit");
        exit.setVisible(true);
        buttonPanel.add(exit, c);

        //ActionListener to exit the program completely
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        c.gridy = 0;
        c.gridx = 0;

        //Create check boxes for user selection
        uFO = new JCheckBox("UFO");
        uFO.setVisible(true);
        checkBoxPanel.add(uFO, c);
        c.gridy++;

        cloud = new JCheckBox("Cloud");
        cloud.setVisible(true);
        checkBoxPanel.add(cloud, c);
        c.gridy++;

        bird = new JCheckBox("Bird");
        bird.setVisible(true);
        bird.setSelected(true);
        checkBoxPanel.add(bird, c);

        //ActionListener to create a new subPanel if one does not exist
        // Or has existing sub panel become visible again
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!subP.getShown()){
                    subP.newPane();
                    subP.setShown();
                    subP.start();
                }
                else
                subP.display(true);
                subP.start();
            }
        });

        //ActionListener for add button to call the add shapes
        // methods of  specified type in sub Panel
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cloud.isSelected() && bird.isSelected() && uFO.isSelected()){
                    subP.addBird();
                    subP.addCloud();
                    subP.addUfo();
                }
                else if(cloud.isSelected() && uFO.isSelected()){
                    subP.addUfo();
                    subP.addCloud();
                }
                else if(cloud.isSelected() && bird.isSelected()){
                    subP.addCloud();
                    subP.addBird();
                }
                else if(bird.isSelected() && uFO.isSelected()){
                    subP.addBird();
                    subP.addUfo();
                }
                else if(cloud.isSelected()){
                    subP.addCloud();
                }
                else if(uFO.isSelected()){
                    subP.addUfo();
                }
                else if(bird.isSelected()){
                    subP.addBird();
                }
            }
        });


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //Opens the mainFrame upon program startup
    public void run(){
        frame.setVisible(true);
    }


}
