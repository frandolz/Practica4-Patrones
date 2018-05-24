
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fran
 */
public abstract class Figure {
    private List<Figure> components;
    private double x;
    private double y;
    
    public Figure(double x, double y){
         components = new ArrayList();
         this.x = x;
         this.y = y;
            
    }
    public void addComponent(Figure component){
        components.add(component);
    }
}
