package ast;
import java.io.PrintStream;
import java.util.Map;
public class BlockStmt extends Stmt {
    public final UnitList block;
    public BlockStmt(UnitList b, Location loc) {
	super(loc);
	block = b;
    }
    public void print(PrintStream ps, String indent) { 
	ps.print(indent + "{\n");
	block.print(ps, indent + "  ");
	ps.print(indent + "}");
    }
    public void print(PrintStream ps) {     
	print(ps,"");
    }
    public void check(TableStack globalSingleTable)
    {
        globalSingleTable.newTable();
        block.check(globalSingleTable);
        globalSingleTable.pop();
    }
}
