package ast;
import java.io.PrintStream;
import java.util.Map;
public class UnitList extends ASTNode {
    public final Unit unit;
    public final UnitList unitList; 
    public UnitList(Unit u, UnitList ul, Location loc) {
        super(loc);
	unit = u;
	unitList = ul;
    }
    public UnitList(Unit u, Location loc) { 
        super(loc);
	unit = u;
        unitList = null;
    }
    public void print(PrintStream ps, String indent) {
	unit.print(ps,indent);
	ps.println();
	if (unitList != null)
	    unitList.print(ps,indent);
    }
    public void print(PrintStream ps) { 
	print(ps,""); 
    }
    @Override
    public void check(TableStack globalSingleTable)
    {
        // globalSingleTable.newTable();
        unit.check(globalSingleTable);
        if(unitList != null)
            unitList.check(globalSingleTable);
        // globalSingleTable.pop();
    }
}
