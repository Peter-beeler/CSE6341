package ast;
import java.io.PrintStream;
import java.util.Map;
public class WhileStmt extends Stmt {
    public final CondExpr expr;
    public final Stmt body;
    public WhileStmt(CondExpr e, Stmt s, Location loc) {
	super(loc);
	expr = e;
	body = s;
    }
    public void print(PrintStream ps, String indent) { 
	ps.print(indent + "while (");
	expr.print(ps);
	ps.print(")\n");
	body.print(ps, indent + "  ");
    }
    public void print(PrintStream ps) {     
	print(ps,"");
    }
    @Override 
    public void check(TableStack globalSingleTable)
    {
        expr.check(globalSingleTable);
        body.check(globalSingleTable);
    }
}
