package ast;
import java.io.PrintStream;
import java.util.Map;
public class ReadFloatExpr extends Expr {
    public ReadFloatExpr(Location loc) {
	super(loc);
    }
    public void print(PrintStream ps) {
	ps.print("readfloat");
    }
    @Override
    public void check(TableStack globalSingleTable)
    {
        this.type = TypeFloat;
    }
}
