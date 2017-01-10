import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by Dewey Milton on 10/25/2016.
 * Creates a cloud MoveableShape object
 */
public class cloud implements MoveableShape {

    private int x;
    private int y;
    private int flow1;
    private int flow2;
    private int width;
    private boolean shrink1;
    private boolean shrink2;

    /*
       Name: cloud()
       Constructor method for cloud object
       @param _x value of xPosition
       @param _y value of yPosition
       @param _width value of object width
     */
    public cloud(int _x, int _y, int _width){
        this.x = _x;
        this.y = _y;
        this.width = _width;
        this.shrink1 = false;
        this.shrink2 = false;
        this.flow1 = 60;
        this.flow1 = 60;
    }

    /*
       Name: draw()
       @param g2 Graphics object to draw Cloud shape
     */
    public void draw(Graphics2D g2)
    {
        if(this.x < 0){
            this.x = 1000;
        }

        if(this.y > 600){
            this.y = 80;
        }



        if(!this.shrink1) {
            this.flow1 = this.flow1 + 1;
            if(this.flow1 > 70){
                this.shrink1 = true;
            }
        }
        else if(shrink1){
            flow1 = flow1 - 1;
            if(flow1 < 40){
                shrink1 = false;
            }
        }

        if(!shrink2) {
            flow2 = flow2 + 1;
            if(flow2 > 70){
                shrink2 = true;
            }
        }
        else if(shrink2){
            flow2 = flow2 - 1;
            if(flow2 < 40){
                shrink2 = false;
            }
        }




        Ellipse2D.Double puff1
                = new Ellipse2D.Double(this.x - 15, this.y - 10,
                flow1, flow1);
        Ellipse2D.Double puff2
                = new Ellipse2D.Double(this.x + 10, this.y + 10,
                flow2, flow1);
        Ellipse2D.Double puff3
                = new Ellipse2D.Double(this.x, this.y + 10,
                flow2, flow2);
        Ellipse2D.Double puff
                = new Ellipse2D.Double(this.x, this.y,
                flow1, flow2);
        g2.setPaint(new Color(236, 248, 255));
        g2.fill(puff1);
        g2.setPaint(new Color(239, 255, 238));
        g2.fill(puff2);

        g2.setPaint(new Color(251, 255, 249));
        g2.fill(puff3);
        g2.setPaint(new Color(251, 251, 250));
        g2.fill(puff);
        g2.draw(puff);
        g2.draw(puff1);
        g2.draw(puff2);
        g2.draw(puff3);

    }

    /*
       Name: getX()
       @return int value of xPosition
     */
    public int getX(){
        return this.x;
    }

    /*
      Name: setX()
      @param _x value of new xPosition
     */
    public void setX(int _x){
        this.x = _x;
    }

    /*
      Name: getY()
      @return int value of yPosition
     */
    public int getY(){
        return this.y;
    }

    /*
      Name: setY()
      @param _y value of new yPosition
     */
    public void setY(int _y) {
       this.y = _y;
    }

    /*
      Name: translate()
      @param dx value of xPosition in motion
      @param dy value of yPosition in motion
     */
    public void translate(int dx, int dy)
    {
        this.x += dx;
        this.y += dy;
    }
}
