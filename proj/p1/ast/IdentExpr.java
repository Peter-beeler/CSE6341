package ast;
import java.io.PrintStream;
import java.util.Map;
import interpreter.*;

public class IdentExpr extends Expr {
    public final String ident; 
    public Location loc;
    public IdentExpr(String i, Location l) {
        super(l);
        ident = i;
        loc = l;
    }
    public void print(PrintStream ps) {
	    ps.print(ident);
    }
    @Override
    public void check(Map<String, Integer> globalSingleTable){
        if(!globalSingleTable.containsKey(ident))
        {
            Interpreter.fatalError("line " + loc.line + ": " + ident + " has not been declared before use!", Interpreter.EXIT_STATIC_CHECKING_ERROR);
        }
        this.type = globalSingleTable.get(ident);
    }
}
