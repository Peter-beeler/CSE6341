package ast;
import java.io.PrintStream;
import java.util.Map;
import interpreter.*;

public class IntVarDecl extends VarDecl {
    public Location loc;
    public String id;
    public IntVarDecl(String i, Location l) {
	super(i,l);
    loc = l;
    id = i;
    }
    public void print(PrintStream ps) {
	ps.print("int " + ident);
    }
    @Override
    public void check(TableStack globalSingleTable){
        if(globalSingleTable.containsKey(id))
        {
            Interpreter.fatalError("line " + loc.line + ": " + id + " has been declared!", Interpreter.EXIT_STATIC_CHECKING_ERROR);
        }
        else
            // globalSingleTable.put(i, TypeInt);
            this.type = TypeInt;
    }
}