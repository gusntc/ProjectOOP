package SyntaxofGrammar.AST;


import java.util.Map;

public class NodeShoot implements NodeExpr{

    private String direction;
    private NodeExpr expr;
    public NodeShoot(NodeExpr expr,String direction){
        this.expr = expr;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "shoot" + direction;
    }

    @Override
    public long eval(Map<String, Long> variable) {
        return 0;
    }
}
