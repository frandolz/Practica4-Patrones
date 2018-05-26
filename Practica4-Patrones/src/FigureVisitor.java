/**
 * @author F.Dolz
 * @author Oriol
 * @author Alberto
 */
public interface FigureVisitor {
    void visit(Circle circle);
    void visit(Rectangle rectangle);
    void visit(Drawing drawing);
}
