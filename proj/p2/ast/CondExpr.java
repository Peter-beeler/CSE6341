package ast;
import java.io.PrintStream;

public abstract class CondExpr extends ASTNode {
    public int type = TypeNull;
    public CondExpr(Location loc) {
	super(loc);
    }
}
