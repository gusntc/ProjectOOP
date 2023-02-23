package SyntaxofGrammar.AST;

import java.util.Map;

public class NodeRelocate implements NodeExpr{
    @Override
    public String toString() {
        return "City Center change";
    }

    @Override
    public long eval(Map<String, Long> variable) {
        return 0;
    }
}
