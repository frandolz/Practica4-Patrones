import java.util.ArrayList;
import java.util.List;

/**
 * @author F.Dolz
 * @author Oriol
 * @author Alberto
 */

public abstract class Figure {
    private double x;
    private double y;
    
    public Figure(double x, double y){
         this.x = x;
         this.y = y;
            
    }

    /*      GETTERS     */
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    /*      SETTERS     */
    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }
    public abstract void accept (FigureVisitor fv);
}
