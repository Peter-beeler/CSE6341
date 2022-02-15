package ast;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;
abstract class ASTNode {
    public final Location loc;
    ASTNode(Location loc) { this.loc = loc; }
    public abstract void print(PrintStream ps);
    public String toString() { 
	ByteArrayOutputStream b = new ByteArrayOutputStream();
	print(new PrintStream(b));
	return new String(b.toByteArray(),java.nio.charset.StandardCharsets.UTF_8);
    } 
    public static final int TypeInt = 0;
    public static final int TypeFloat = 1;
    public static final int TypeNull = 2;
    public static final int TypeCond = 3;
    public abstract void check(TableStack globalSingleTable);
}
