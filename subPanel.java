import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * Created by Dewey Milton on 10/25/2016.
 * subPanel Class creates a subPanel which holds shape animations
 * and two buttons two either Hide the panel or Exit the Panel
 */
public class subPanel {
    private JFrame frame;
    private JPanel screen;
    private JPanel menu;
    private Container pane;
    private JButton hide;
    private JButton exit;
    private GridBagConstraints c;
    private boolean shown;
    private final JLabel label;
    private final ShapeIcon icon;
    private final int delay = 20;
    private Timer timer;
    private MoveableShape shape;
    private Random rand;

    /*
      Name: subPanel()
      Constructor for the subPanel
     */
    public subPanel(){
        shown = false;
        rand = new Random(200);
        this.icon = new ShapeIcon();
        this.label = new JLabel(icon);
    }

    /*
      Name: getShown()
      @return boolean value of whether the sub panel is visible or not
     */
    public boolean getShown(){
        return this.shown;
    }

    /*
       Name: setShown()
        sets the sub panel visibility to true
     */
    public void setShown(){
        this.shown = true;
    }

    /*
       Name: newPane()
       Creates a new subpanel screen that displays animations of shapes
     */
    public void newPane(){

        frame = new JFrame("SubPanel");
        frame.setSize(600,600);
        frame.setVisible(true);
        label.setVisible(true);

        menu = new JPanel(new GridBagLayout());
        c = new GridBagConstraints();
        c.gridy = 0;
        c.gridx = 0;
        c.insets = new Insets(20, 125, 20, 125);

        menu.setSize(600, 100);
        menu.setBackground(Color.lightGray);
        menu.setVisible(true);

        hide = new JButton("Hide");
        hide.setSize(50,10);
        hide.setVisible(true);
        menu.add(hide, c);
        c.gridx++;

        exit = new JButton("Exit");
        exit.setSize(50,10);
        exit.setVisible(true);
        menu.add(exit, c);

        pane = frame.getContentPane();

        pane.setBackground(Color.CYAN);
        pane.setSize(600,600);
        pane.add(menu, BorderLayout.NORTH);
        pane.add(label);

        //ActionListener for the hide button
        //sets supPanel visiblitiy to false
        hide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display(false);
                stop();
            }
        });

        //ActionListener for the button that closes
        //the subPanel completely
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                stop();
                reset();
            }
        });

        //Timer for the animation of the shape icons
        timer = new Timer(delay, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                label.repaint();
                if(hasShapes()) {
                    translate();

                }

            }
        });

    }

    /*
      Name: reset()
      Empties the ShapeIcon array when the subPanel
      is disposed.
     */
    public void reset(){
        this.icon.reset();
    }

    /*
      Name: display
      @param Boolean value that sets whether the
      subPanel is visible or not
     */
    public void display(Boolean show){

        frame.setVisible(show);
    }

    /*
       Name: remove()
       Calls the remove method in the ShapeIcon class
       Removes the newest shape from the ShapeIcon array
     */
    public void remove(){
        icon.removeShape();
    }

    /*
      Name: addCloud()
      Creates a cloud MoveableShape object
      stores the shape into the ShapeIcon Array
     */
    public void addCloud(){
        int rX = getRandomX();

        int rY = getRandomY();
        int rW = getRandomW();
        this.shape = new cloud(rX,rY,rW);
        this.icon.addShape(shape);

    }

    /*
      Name: addUfo()
      Creates a Ufo MoveableShape object
      Stores the object in the ShapeIcon array
     */
    public void addUfo(){

        int rX = getRandomX();
        int rY = getRandomY();
        int rW = getRandomW();

        this.shape = new Ufo(rX,rY,rW);
        this.icon.addShape(shape);
    }

    /*
      Name: addBird()
      Creates a moveableShape object of a bird
       places the object into the shapeIcon array
     */
    public void addBird(){
        int rX = getRandomX();

        int rY = getRandomY();
        int rW = getRandomW();

        this.shape = new Bird(rX,rY,rW);
        this.icon.addShape(shape);
    }

    /*
      Name: getRandomX()
      Creates a random x value for new shape
      @return int value of new random X
     */
    public int getRandomX(){
        int _x = 0;
        while(_x < 10){
            _x = rand.nextInt(500);
        }
        return _x;
    }

    /*
       Name: getRandomY()
       Creates a random Y value for a new shape
       @return int of new random Y value
     */
    public int getRandomY(){
        int _y = 0;
        while(_y < 100){
            _y = rand.nextInt(500);
        }
        return _y;
    }

    /*
       Name: getRandomW()
       Creates a random width for a shape
       @return int value of new random width
     */
    public int getRandomW(){
        int _W = 0;

        while(_W < 50){
            _W = rand.nextInt(250);
        }
        return _W;
    }

    /*
      Name: hasShapes()
      Checks the ShapeIcon class if it has any shapes
      @return boolean value, True if icon contains shapes
     */
    public boolean hasShapes(){
        return this.icon.hasShape();
    }

    /*
      Name: translate()
      Sets the movement of shapes
     */
    public void translate(){
        this.icon.translate(-2,1);

    }

    /*
      Name: start()
      Starts the timer in newPane method
     */
    public void start(){
        timer.start();
    }

    /*
      Name: stop()
      Stops timer in the newPane method
     */
    public void stop(){
        timer.stop();
    }
}
