package ast;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.lang.System;
public class TableStack {
    protected static Stack<Map<String, Integer>> table = new Stack<Map<String, Integer>>();
    public void newTable()
    {
        Map<String, Integer> tmp = new HashMap<String, Integer>();
        table.push(tmp);
    }
    public Map<String, Integer> tablePop()
    {
        return table.pop();
    }
    public int get(String id)
    {
        int size = table.size();
        for (int i = size - 1; i >= 0; i--) {
            if(table.get(i).containsKey(id))
                return table.get(i).get(id);
        }
        return -1;
    }
    public boolean containsKey(String id)
    {
        return table.peek().containsKey(id);
    }
    public void put(String id, int type)
    {
        table.peek().put(id, type);
    }
    public void pop()
    {
        table.pop();
    }

}
