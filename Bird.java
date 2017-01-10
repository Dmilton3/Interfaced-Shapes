import java.awt.*;
import java.awt.geom.*;

/**
 * Created by Dewey Milton on 10/25/2016.
 * Bird class holds methods for obtaining a bird Shape
 *
 */
public class Bird implements MoveableShape {

    private int x;
    private int y;
    private int wing1;
    private int wing2;
    private int width;
    private int turnCount;
    private boolean turn;

    /*
      Name: Bird()
      Constructor for the bird class
      @param _x value for the x Position
      @param _y value for the y Position
      @param _width value for the Width of the bird
     */
    public Bird(int _x, int _y, int _width){
        this.x = _x;
        this.y = _y;
        this.wing1 = 50;
        this.wing2 = 60;
        this.width = _width;
        this.turnCount = 0;
        turn = false;
    }

    /*
       Name: Draw()
       draws the bird shape
       @param g2 Graphics2D object
     */
    public void draw(Graphics2D g2)
    {
        if(this.x < 0){
            this.x = 1000;
        }

        if(this.y > 600){
            this.y = 80;
        }
        this.wing1 = wing1 + 20;
        this.wing2 = wing2 - 10;

        if(this.wing1 > 200){
            wing1 = 50;
        }
        if(this.wing2 < 50){
            wing2 = 150;
        }
        g2.setPaint(new Color(222,22,222));
        g2.setPaint(new Color(93, 1, 18));
        g2.draw(new Arc2D.Double(this.x, this.y, (wing2 + 10) * -1, wing2, 100, 120, Arc2D.OPEN));
        g2.draw(new Arc2D.Double(this.x, this.y, wing2 + 10, wing2, 100, 120, Arc2D.OPEN));
        Ellipse2D.Double body
                = new Ellipse2D.Double(this.x - 15, this.y + 20,
                30,30);
        g2.fill(body);
        g2.draw(body);
    }

    /*
      Name: getX()
      @return x value of the bird
     */
    public int getX(){
        return this.x;
    }

    /*
       Name: setX()
       @param _x value of the new x Position
     */
    public void setX(int _x){
        this.x = _x;
    }

    /*
      Name: getY()
      @return y value of shape
     */
    public int getY(){
        return this.y;
    }

    /*
      Name: setY()
      @param _y value of new Y
     */
    public void setY(int _y) {
        this.y = _y;
    }

    /*
      Name: translate()
      sets the animation motion of the MoveableShape
      @param dx value of the new xPosition
      @param dy value of the new yPosition
     */
    public void translate(int dx, int dy)
    {
        turnCount = turnCount + 1;

        if(turnCount == 300){
            if(!turn) {
                turn = true;
            }else
            turn = false;

            turnCount = 0;
        }

        if(!turn) {
            this.x += dx;
            this.y += dy;
        }else{
            this.x -= dx;
            this.y -= dy;
        }

    }
}