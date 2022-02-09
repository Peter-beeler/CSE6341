package ast;
import java.io.*;
import java.io.PrintStream;
import java.util.Map;

public abstract class VarDecl extends ASTNode {
    public final String ident;
    public int type;
    public VarDecl(String i, Location loc) {
	super(loc);
	ident = i;
    }
    public abstract void print(PrintStream ps);
    public abstract void check(Map<String, Integer> globalSingleTable);
}
