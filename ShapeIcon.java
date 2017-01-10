import java.awt.*;
import java.util.*;
import javax.swing.*;

/**
   Name: ShapeIcon
 Creates an array of MoveableShape Objects
*/
public class ShapeIcon implements Icon
{
   /*
      Constructor
     */
   public ShapeIcon()
   {
      this.shapes = new ArrayList<>();

      this.width = 100;
      this.height = 100;
   }

    /*
      Name: addShape
      Adds  shape the array
      @param _shape object to be addad to the array
     */
   public void addShape(MoveableShape _shape){
      this.shapes.add(_shape);

   }

    /*
       Name: removeShape()
       removes the most recent shape from the array
     */
    public void removeShape(){
        if(this.shapes.size() > 0) {
            this.shapes.remove(this.shapes.size() - 1);
        }
    }

    /*
        Name: translate()
        sets the moveable positions of shapes in the array
        @param dx value of the moveable xPosition
        @param dy value of the moveable yPosition
     */
    public void translate(int dx, int dy){
        int tempX;
        int tempY;

        for(int pos = 0; pos < shapes.size(); pos++){
            tempX = this.shapes.get(pos).getX();
            tempY = this.shapes.get(pos).getY();

            if(tempX == 0){
                this.shapes.get(pos).setX(1300);
            }else if(tempX == 1300){
                this.shapes.get(pos).setX(0);
            }

            if(tempY == 600){
                this.shapes.get(pos).setY(0);
            }else if(tempY == 0){
                this.shapes.get(pos).setY(600);
            }

            this.shapes.get(pos).translate(dx,dy);
        }
    }

    /*
       Name: reset()
       Resets the array to a brand new array
     */
    public void reset(){
        this.shapes = new ArrayList<>();
    }

    /*
       Name: getIconWidth()
       @return int value of icon width
     */
   public int getIconWidth()
   {
      return width;
   }

    /*
      Name: getIconHeight()
      @return int value of icon height
     */
   public int getIconHeight()
   {
      return height;
   }

    /*
       Name: hasShape()
       @return boolean value of the array being empty
     */
    public boolean hasShape(){
        boolean hasShape = false;
        if(this.shapes.size() != 0){
            hasShape = true;
        }
        return hasShape;
    }


    /*
      Name: paintIcon
       draws and animates shapes within the array
       @param c Component to be animated
       @param g Graohics object to assist in drawing shapes
       @param x value of new xPosition
       @param y value of new yPosition
     */
   public void paintIcon(Component c, Graphics g, int x, int y)
   {
   Graphics2D g2 = (Graphics2D) g;


   for(int pos = 0; pos < shapes.size(); pos++) {
      shapes.get(pos).draw(g2);

   }
}

   private int height;
   private int width;

   private ArrayList<MoveableShape> shapes;

}


