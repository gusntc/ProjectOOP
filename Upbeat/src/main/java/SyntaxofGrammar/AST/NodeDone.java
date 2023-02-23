package SyntaxofGrammar.AST;

import java.util.Map;

public class NodeDone implements NodeExpr{

    @Override
    public String toString() {
        return "END ACTION";
    }

    @Override
    public long eval(Map<String, Long> variable) {
        return 0;
    }
}
