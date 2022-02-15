package ast;
import java.io.PrintStream;
import java.util.Map;
import interpreter.Interpreter;
public class CompExpr extends CondExpr {
    public static final int GE = 1;
    public static final int GT = 2;
    public static final int LE = 3;
    public static final int LT = 4;
    public static final int EQ = 5;
    public static final int NE = 6;
    public final Expr expr1, expr2;
    public final int op;
    public CompExpr(Expr e1, int oper, Expr e2, Location loc) {
	super(loc);
	expr1 = e1; 
	expr2 = e2;
	op = oper;
    }
    public void print(PrintStream ps) {
	ps.print("(");
	expr1.print(ps);
	switch (op) { 
	case GE: ps.print(">="); break;
	case GT: ps.print(">"); break;
	case LE: ps.print("<="); break;
	case LT: ps.print("<"); break;
	case EQ: ps.print("=="); break;
	case NE: ps.print("!="); break;
	}
	expr2.print(ps);
	ps.print(")");
    }
	@Override
	public void check(TableStack globalSingleTable)
	{
		expr1.check(globalSingleTable);
		expr2.check(globalSingleTable);
		if(expr1.type != expr2.type)
		{
			Interpreter.fatalError("line " + loc.line + ": " + "op two values of different types!", Interpreter.EXIT_STATIC_CHECKING_ERROR);
		}
		this.type = TypeCond;
	}
}
