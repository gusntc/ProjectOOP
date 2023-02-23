package SyntaxofGrammar.AST;

import java.util.Map;

public class NodeNumber implements NodeExpr{
    private long num;

    public NodeNumber(long num){
        this.num = num;
    }

    @Override
    public String toString() {
        return String.valueOf(num);
    }

    @Override
    public long eval(Map<String, Long> variable) {
        return 0;
    }
}
