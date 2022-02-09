package ast;
import java.io.PrintStream;
import java.util.Map;
import interpreter.*;
public class Decl extends Unit {
    public final VarDecl varDecl;
    public final Expr expr;
	public final Location loc;
    public Decl(VarDecl d, Location l) {
	super(l);
	varDecl = d;
	expr = null;
	loc = l;
    }
    public Decl(VarDecl d, Expr e, Location l) {
	super(l);
	varDecl = d;
	expr = e;
	loc = l;
    }
    public void print(PrintStream ps) { 
	varDecl.print(ps); 
	if (expr != null) {
	    ps.print(" = ");
	    expr.print(ps);
	}
	ps.print(";");
    }
	@Override
	public void check(Map<String, Integer> globalSingleTable){
	varDecl.check(globalSingleTable);
	if(expr != null){
		expr.check(globalSingleTable);
		if(varDecl.type != expr.type)
		{
			Interpreter.fatalError("line " + loc.line + ": " + "The value of variable does not match the value of expression!", Interpreter.EXIT_STATIC_CHECKING_ERROR);
		}
		globalSingleTable.put(varDecl.ident, expr.type);
	}
	else{
		globalSingleTable.put(varDecl.ident, expr.type);
	}
	}
	
}
