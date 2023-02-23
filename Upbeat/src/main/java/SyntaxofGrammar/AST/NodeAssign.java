package SyntaxofGrammar.AST;

import java.util.Map;

public class NodeAssign implements NodeExpr {
    private String idenifer;
    private NodeExpr expr;

    public NodeAssign(String idenifer,NodeExpr expr){
        this.idenifer = idenifer;
        this.expr = expr;
    }

    public String getIdenifer() {
        return idenifer;
    }

    public NodeExpr getExpr(){
        return expr;
    }

    @Override
    public String toString() {
        return idenifer + " = " + expr;
    }

    @Override
    public long eval(Map<String, Long> variable) {
        return 1;
    }
}
