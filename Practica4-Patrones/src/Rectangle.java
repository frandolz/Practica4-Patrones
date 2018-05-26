/**
 *
 * @author F.Dolz
 * @author Oriol
 * @author Alberto
 */

public class Rectangle extends Figure {
    private double width;
    private double height;


    public Rectangle(double x, double y, double w, double h) {
        super(x, y);
        this.width = w;
        this.height = h;               
    }

    /*      SETTERS     */
    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    /*      GETTERS     */
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
