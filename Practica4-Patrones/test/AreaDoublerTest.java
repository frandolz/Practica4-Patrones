/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Fran,Oriol,Alberto
 */
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
    
 
    @Test
    public void testVisit_Circle() {
        cir.accept(ad);
        Circle circle = ad.getmiCircle();
        //System.out.println(circle.getR());
        double comprob = 5*Math.sqrt(2.0);
        assertEquals(comprob,circle.getR(),DELTA);
    }

    @Test
    public void testVisit_Rectangle() {
        rect.accept(ad);
        Rectangle rect = ad.getRectangle();
        double comprob = 5*Math.sqrt(2.0);
         
        assertEquals(comprob,rect.getHeight(),DELTA);
        assertEquals(comprob,rect.getWidth(),DELTA);
    }

    @Test
    public void testVisit_Drawing() {
                        
        
        double comprob = 5*Math.sqrt(2.0);
       
        
        DrawingBuilder drawbuilder = new DrawingBuilder(x,y);
   
        Drawing drawing = drawbuilder.addFigure(cir).addFigure(rect).create();
        drawing.accept(ad);
       
        
        Drawing ndrawing = (Drawing) ad.getdrawing();
        Circle ncircle = (Circle) ndrawing.getList().get(0);
        Rectangle nrectangle = (Rectangle) ndrawing.getList().get(1);
       
       
      
        assertEquals(comprob,nrectangle.getHeight(),DELTA);
        assertEquals(comprob,nrectangle.getWidth(),DELTA);
        
        assertEquals(comprob,ncircle.getR(),DELTA);
        
    }
    
}
