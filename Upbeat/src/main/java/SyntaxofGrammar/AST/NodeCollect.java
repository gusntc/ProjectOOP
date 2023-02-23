package SyntaxofGrammar.AST;

import java.util.Map;

public class NodeCollect implements NodeExpr{
    private NodeExpr expr;

    public NodeCollect(NodeExpr expr){
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "Collect";
    }

    @Override
    public long eval(Map<String, Long> variable) {
        return 0;
    }
}
