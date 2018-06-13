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
        this.circ = new Circle (circle.getX(),
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
          AreaDoubler ad = new AreaDoubler();
          figure.accept(ad); //llama al visit
          addDoubleFigure(ad,db,figure);          
        }    
        draw = db.create(); //creamos la figura 
    }
  
    
    /*       GETTERS           */
    public Circle getmiCircle(){
        return circ;
    }
  
    public Rectangle getRectangle(){
        return rect;
    }
    
    public Drawing getdrawing(){
        return draw;
    }

    /* Comprobamos que añadir al DrawingBuilder desde el AreaDoubler   */
    private void addDoubleFigure(AreaDoubler ad, DrawingBuilder db, Figure figure) {
        if( figure instanceof Drawing){
            db.addFigure(ad.getdrawing());
        }
        
        if( figure instanceof Rectangle){
            db.addFigure(ad.getRectangle());
        }
        if( figure instanceof Circle){
            db.addFigure(ad.getmiCircle());
        }
    }
}
