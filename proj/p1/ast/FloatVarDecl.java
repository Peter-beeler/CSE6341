package ast;
import java.io.PrintStream;
import interpreter.*;
import java.util.*;

public class FloatVarDecl extends VarDecl {
    public Location loc;
    public String id;
    public FloatVarDecl(String i, Location l) {
    super(i,l);
    loc = l;
    id = i;
    }
    public void print(PrintStream ps) {
	ps.print("float " + ident);
    }
    @Override
    public void check(Map<String, Integer> globalSingleTable){
        if(globalSingleTable.containsKey(id))
        {
            Interpreter.fatalError("line " + loc.line + ": " + id + " has been declared!", Interpreter.EXIT_STATIC_CHECKING_ERROR);
        }
        else
            // globalSingleTable.put(i, TypeFloat);
            this.type = TypeFloat;
        
    }
}
