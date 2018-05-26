import java.util.Collections;
import java.util.List;

/**
 * @author F.Dolz
 * @author Oriol
 * @author Alberto
 */

public class Drawing extends Figure {
    private final List<Figure> components;
    
    public Drawing(double x , double y, List<Figure> components) {
        super(x,y);
        this.components = components;
    }
    
    public List<Figure> getList(){
        return Collections.unmodifiableList(components);
    }

    @Override
    public void accept(FigureVisitor fv) {
        fv.visit(this);
    }
    
}
