package ast;
import java.io.PrintStream;
import interpreter.*;
import java.util.*;

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
    public void print(PrintStream ps) { 
	ps.print(ident + " = ");
	expr.print(ps);
	ps.print(";");
    }

    @Override
    public void check(Map<String, Integer> globalSingleTable){
        expr.check(globalSingleTable);
        if(!globalSingleTable.containsKey(ident))
        {
            Interpreter.fatalError("line " + loc.line + ": " + ident + " has not been declared before use!", Interpreter.EXIT_STATIC_CHECKING_ERROR);
        }
        if(globalSingleTable.get(ident) != expr.type)
        {
            Interpreter.fatalError("line " + loc.line + ": "+  "Cannot assign values to different type variables!", Interpreter.EXIT_STATIC_CHECKING_ERROR);
        }
    }
}
