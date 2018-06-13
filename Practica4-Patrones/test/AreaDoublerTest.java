import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author F.Dolz
 * @author Oriol
 * @author Alberto
 */

//TESTING para comprobar que se escalan las proporciones de la figura.
public class AreaDoublerTest {
    private Circle cir;
    private Rectangle rect;
    private Drawing draw;
    private FigureVisitor fv;
    private static final double DELTA = 1e-15;
    AreaDoubler ad = new AreaDoubler();
    
    private double x = 10;
    private double y = 10;
    List<Figure> ddr = new ArrayList<>();
    

    public AreaDoublerTest() {
        cir = new Circle(x,y,5);
        rect = new Rectangle (x,y,5,5);
        misetUp();
        draw = new Drawing(x,y,ddr);
    }
    
    public void misetUp(){
        ddr.add(cir);
        ddr.add(rect);
    }
    
    //TEST para comprobar el radio de un circulo 
    @Test
    public void testVisit_Circle() {
        cir.accept(ad);
        Circle circle = ad.getmiCircle();
        double comprob = 5*Math.sqrt(2.0);
        assertEquals(comprob,circle.getR(),DELTA);
    }

    //TEST para comprobar el ancho y alto del Rectangulo
    @Test
    public void testVisit_Rectangle() {
        rect.accept(ad);
        Rectangle rect = ad.getRectangle();
        double comprob = 5*Math.sqrt(2.0);
         
        assertEquals(comprob,rect.getHeight(),DELTA);
        assertEquals(comprob,rect.getWidth(),DELTA);
    }

    //TEST que comprobamos en un Drawing que tiene un circulo y un rectangulo.
    @Test
    public void testVisit_Drawing() {
                        
        double comprob = 5*Math.sqrt(2.0);
       
        //Creamos un DrawingBuilder añadiendo figuras 
        DrawingBuilder drawbuilder = new DrawingBuilder(x,y);
        Drawing drawing = drawbuilder.addFigure(cir).addFigure(rect).create();
        drawing.accept(ad);
       
        //Extraemos las figuras del areaDoubler
        Drawing ndrawing = (Drawing) ad.getdrawing();
        Circle ncircle = (Circle) ndrawing.getList().get(0);
        Rectangle nrectangle = (Rectangle) ndrawing.getList().get(1);
       
       
        //Comprobaciones del rectangulo y del circulo
        assertEquals(comprob,nrectangle.getHeight(),DELTA);
        assertEquals(comprob,nrectangle.getWidth(),DELTA);
        assertEquals(comprob,ncircle.getR(),DELTA);
        
    }
    
}
