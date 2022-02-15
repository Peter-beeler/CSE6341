package ast;
import java.io.PrintStream;
import interpreter.Interpreter;
import java.util.Map;
public class LogicalExpr extends CondExpr {
    public static final int AND = 1;
    public static final int OR = 2;
    public static final int NOT = 3;
    public final CondExpr expr1, expr2;
    public final int op;
    public LogicalExpr(CondExpr e1, int oper, CondExpr e2, Location loc) {
	super(loc);
	expr1 = e1; 
	expr2 = e2;
	op = oper;
    }
    public LogicalExpr(CondExpr e1, int oper, Location loc) {
	this(e1,oper,null,loc); // used for NOT
    }
    public void print(PrintStream ps) {
	if (op == NOT) {
	    ps.print("!(");
	    expr1.print(ps);
	    ps.print(")");
	    return;
	}
	ps.print("(");
	expr1.print(ps);
	switch (op) { 
	case AND: ps.print("&&"); break;
	case OR: ps.print("||"); break;
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
		this.type = expr1.type;
	}
}
