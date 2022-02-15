package ast;
import java.io.PrintStream;
import interpreter.Interpreter;
import java.util.Map;
public class AssignStmt extends Stmt {
    public final String ident;
    public final Expr expr;
    public final Location loc;
    public AssignStmt(String i, Expr e, Location l) {
	super(l);
	ident = i;
	expr = e;
    loc = l;
    }
    public void print(PrintStream ps, String indent) { 
	ps.print(indent + ident + " = ");
	expr.print(ps);
	ps.print(";");
    }
    public void print(PrintStream ps) {     
	print(ps,"");
    }
    @Override
    public void check(TableStack globalSingleTable){
        expr.check(globalSingleTable);
        if(globalSingleTable.get(ident) == -1)
        {
            Interpreter.fatalError("line " + loc.line + ": " + ident + " has not been declared before use!", Interpreter.EXIT_STATIC_CHECKING_ERROR);
        }
        if(globalSingleTable.get(ident) != expr.type)
        {
            Interpreter.fatalError("line " + loc.line + ": "+  "Cannot assign values to different type variables!", Interpreter.EXIT_STATIC_CHECKING_ERROR);
        }
    }
}
