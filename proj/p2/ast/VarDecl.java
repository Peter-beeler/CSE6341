package ast;
import java.io.PrintStream;
import java.util.Map;
public abstract class VarDecl extends ASTNode {
    public final String ident;
    public int type = TypeNull;
    public VarDecl(String i, Location loc) {
	super(loc);
	ident = i;
    }
    public abstract void print(PrintStream ps);
    public abstract void check(TableStack globalSingleTable);
}
