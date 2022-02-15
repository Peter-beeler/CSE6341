package ast;
import java.io.PrintStream;
import java.util.Map;
public abstract class Stmt extends Unit {
    public Stmt(Location loc) {
	super(loc);
    }
    
}
