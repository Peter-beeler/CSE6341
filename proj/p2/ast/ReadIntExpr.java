package ast;
import java.io.PrintStream;
import java.util.Map;
public class ReadIntExpr extends Expr {
    public ReadIntExpr(Location loc) {
	super(loc);
    }
    public void print(PrintStream ps) {
	ps.print("readint");
    }
    @Override
    public void check(TableStack globalSingleTable)
    {
        this.type = TypeInt;
    }
}
