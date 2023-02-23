package SyntaxofGrammar.AST;

import java.util.Map;

public class LongLit implements NodeExpr {
    private long val;
    public LongLit(long val){
        this.val = val;
    }

    @Override
    public long eval(Map<String, Long> variable) {
        return val;
    }


}
