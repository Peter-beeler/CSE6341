package ast;
import java.io.PrintStream;
import java.util.Map;
public class UnaryMinusExpr extends Expr {
    public final Expr expr;
    public UnaryMinusExpr(Expr e, Location loc) {
	super(loc);
	expr = e; 
    }
    public void print(PrintStream ps) {
	ps.print("-(");
	expr.print(ps);
	ps.print(")");
    }
    @Override 
    public void check(TableStack globalSingleTable)
    {
        expr.check(globalSingleTable);
        this.type = expr.type;
    }
}
