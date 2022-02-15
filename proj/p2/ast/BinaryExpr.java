package ast;
import java.io.PrintStream;
import java.util.Map;
import interpreter.Interpreter;
public class BinaryExpr extends Expr {
    public static final int PLUS = 1;
    public static final int MINUS = 2;
    public static final int TIMES = 3;
    public static final int DIV = 4;
    public final Expr expr1, expr2;
    public final int op;
    public BinaryExpr(Expr e1, int oper, Expr e2, Location loc) {
	super(loc);
	expr1 = e1; 
	expr2 = e2;
	op = oper;
    }
    public void print(PrintStream ps) {
	ps.print("(");
	expr1.print(ps);
	switch (op) {
	case PLUS: ps.print("+"); break;
	case MINUS: ps.print("-"); break;
	case TIMES: ps.print("*"); break;
	case DIV: ps.print("/"); break;
	}
	expr2.print(ps);
	ps.print(")");
    }
	@Override
	public void check(TableStack globalSingleTable){
		expr1.check(globalSingleTable);
		expr2.check(globalSingleTable);
		if(expr1.type != expr2.type)
		{
			Interpreter.fatalError("line " + loc.line + ": " + "ops two values of different types!", Interpreter.EXIT_STATIC_CHECKING_ERROR);
		}
		this.type = expr1.type;
	}
}
