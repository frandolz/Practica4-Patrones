/**
 * @author F.Dolz
 * @author Oriol
 * @author Alberto
 */

public class Circle extends Figure{
   
   private double r;
   
   public Circle(double x, double y, double r){
       super(x,y);
       this.r = r;
   }
   
    public double getR() {
        return r;
    }

    @Override
    public void accept(FigureVisitor fv) {
      fv.visit(this);
    }
}
