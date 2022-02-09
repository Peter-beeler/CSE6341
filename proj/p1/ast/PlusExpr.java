package ast;
import java.io.PrintStream;
import interpreter.*;
import java.util.Map;
public class PlusExpr extends Expr {
    public final Expr expr1, expr2;
	public Location loc;
    public PlusExpr(Expr e1, Expr e2, Location l) {
	super(l);
	expr1 = e1; 
	expr2 = e2;
	loc = l;
    }
    public void print(PrintStream ps) {
	ps.print("(");
	expr1.print(ps);
	ps.print("+");
	expr2.print(ps);
	ps.print(")");
    }
	@Override
	public void check(Map<String, Integer> globalSingleTable){
		expr1.check(globalSingleTable);
		expr2.check(globalSingleTable);
		if(expr1.type != expr2.type)
		{
			Interpreter.fatalError("line " + loc.line + ": " + "+ adds two values of different types!", Interpreter.EXIT_STATIC_CHECKING_ERROR);
		}
		this.type = expr1.type;
	}
}
