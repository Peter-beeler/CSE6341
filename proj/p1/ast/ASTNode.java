package ast;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
abstract class ASTNode {
    public final Location loc;
    public static final int TypeInt = 0;
    public static final int TypeFloat = 1;
    public static final int TypeNull = 2;
    public abstract void check(Map<String, Integer> globalSingleTable);
    ASTNode(Location loc) { this.loc = loc; }
    public abstract void print(PrintStream ps);
}
