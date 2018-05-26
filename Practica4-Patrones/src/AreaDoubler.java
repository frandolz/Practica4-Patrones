/**
 * @author F.Dolz
 * @author Oriol
 * @author Alberto
 */
public class AreaDoubler implements FigureVisitor{

    private Drawing draw;
    private Circle circ;
    private Rectangle rect;
    
    private final double math_sqrt = Math.sqrt(2.0);
    
    @Override
    public void visit(Circle circle) {
        circ = new Circle (circle.getX(),
              circle.getY(),
              circle.getR()* math_sqrt);
    }

    @Override
    public void visit(Rectangle rectangle) {
        rect = new Rectangle(rectangle.getX(), 
                    rectangle.getY(),
                    rectangle.getHeight()* math_sqrt,
                    rectangle.getWidth()* math_sqrt);
    }

    @Override
    public void visit(Drawing drawing) {
      DrawingBuilder db = new DrawingBuilder(drawing.getX(),drawing.getY());
      
      for (Figure figure: drawing.getList()){
          figure.accept(this); //llama al visit
          db.addFigure(figure); //añadimos la figura a la lista 
      }    
       draw = db.create(); //creamos la figura 
    }
}
