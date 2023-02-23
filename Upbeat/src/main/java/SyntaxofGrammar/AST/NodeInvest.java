package SyntaxofGrammar.AST;

import java.util.Map;

public class NodeInvest implements NodeExpr{

    private NodeExpr expr;
    public NodeInvest(NodeExpr expr){
        this.expr = expr;
    }

    @Override
    public String toString() {
        return "Invest";
    }

    @Override
    public long eval(Map<String, Long> variable) {
        return 0;
    }
}
