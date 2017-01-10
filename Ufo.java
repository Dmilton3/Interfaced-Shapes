import java.awt.*;
import java.awt.geom.*;

/**
 * Created by Dewey Milton on 10/25/2016.
 * Desription: creates a Ufo MoveableShape object
 */
public class Ufo implements MoveableShape {

    private int x;
    private int y;
    private int width;
    private int wing1;
    private int wing2;
    private int rgb1;
    private int rgb2;
    private int rgb3;

    /*
      Name: Ufo()
      Constructor for Ufo object
      @param _x value of xPosition
      @param _y value of yPosition
      @param _width value of Shape Width
     */
    public Ufo(int _x, int _y, int _width){
        this.x = _x;
        this.y = _y;
        this.wing1 = 50;
        this.wing2 = 60;
        this.width = _width;
        this.rgb1 = 168;
        this.rgb2 = 230;
        this.rgb3 = 93;
    }

    /*
      Name: draw()
      draws Ufo
      @param g2 Graphics object to build and paint Ufo Object
     */
    public void draw(Graphics2D g2)
    {
        if(this.x < 0){
            this.x = 1000;
        }

        if(this.y > 600){
            this.y = 80;
        }

        this.rgb1++;
        this.rgb2++;
        this.rgb3++;

        if(rgb1 > 255){
            rgb1 = 33;
        }else if(rgb2 > 255){
            rgb2 = 28;
        }else if(rgb3 > 255){
            rgb3 = 10;
        }
        this.wing1 = wing1 + 20;
        this.wing2 = wing2 - 10;

        if(this.wing1 > 400){
            wing1 = 50;
        }
        if(this.wing2 < 50){
            wing2 = 250;
        }
        g2.setPaint(new Color(rgb2, rgb3, rgb1));
        g2.fill((new Arc2D.Double(this.x, this.y, this.x + 5, this.y + 10, wing1, wing1, Arc2D.OPEN)));

        Ellipse2D.Double ufo
                = new Ellipse2D.Double(this.x, this.y,
                this.x - 20, this.y - 20);

        g2.draw(ufo);

        g2.setPaint(new Color(rgb3, rgb1, rgb2));
        g2.fill(ufo);

        Ellipse2D.Double pilot
                = new Ellipse2D.Double(this.x, this.y - 20,
                this.x - 10, this.y - 10);

        g2.setPaint(new Color(15, 238, 26));
        g2.fill(pilot);
        g2.draw(pilot);
    }

    /*
      Name: getX
      @return x value of Ufo object
     */
    public int getX(){
        return this.x;
    }

    /*
      Name: setX
      @param _x value to set xPosition
     */
    public void setX(int _x){
        this.x = _x;
    }

    /*
      Name: getY()
      @return y value of UFO object
     */
    public int getY(){
        return this.y;
    }

    /*
     Name: setY()
     @param _y value of the new yPosition
     */
    public void setY(int _y) {
        this.y = _y;
    }


    /*
      Name: translate()
      @param dx value of new xPostion in motion
      @param dy value of new yPosition in motion
     */
    public void translate(int dx, int dy)
    {
        this.x += dx;
        this.y += dy;
    }
}