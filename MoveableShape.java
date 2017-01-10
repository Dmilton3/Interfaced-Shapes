import java.awt.*;

/**
   A shape that can be moved around.
*/
public interface MoveableShape
{
   /**
      Draws the shape.
      @param g2 the graphics context
   */
   void draw(Graphics2D g2);
   /**
      Moves the shape by a given amount.
      @param dx the amount to translate in x-direction
      @param dy the amount to translate in y-direction
   */
   void translate(int dx, int dy);

   /*
      Name: getX()
      @return int value of x
    */
   int getX();

   /*
     Name: setX
     @param x value of new xPosition
    */
   void setX(int x);

   /*
     Name: getY()
     @return int value of new yPosition
    */
   int getY();

   /*
      Name: setY
      @param y value of new yPosition
    */
   void setY(int y);

}
