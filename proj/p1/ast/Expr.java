package ast;
import java.io.PrintStream;
import java.util.Map;

public abstract class Expr extends ASTNode {
    protected int type = TypeNull;
    public Expr(Location loc) {
	super(loc);
    }
    public abstract void check(Map<String, Integer> globalSingleTable);
    public abstract void print(PrintStream ps);
}
