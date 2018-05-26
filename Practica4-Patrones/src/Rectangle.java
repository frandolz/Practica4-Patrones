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

    /*      GETTERS     */
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public void accept(FigureVisitor fv) {
       fv.visit(this);
    }
}
