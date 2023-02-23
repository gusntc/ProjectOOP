package SyntaxofGrammar.AST;

import java.util.Map;

public class NodeOpponent implements NodeExpr{


    @Override
    public String toString() {
        return "Opponent!!!";
    }

    @Override
    public long eval(Map<String, Long> variable) {
        return 0;
    }
}
