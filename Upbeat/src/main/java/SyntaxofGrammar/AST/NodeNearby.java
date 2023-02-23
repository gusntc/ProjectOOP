package SyntaxofGrammar.AST;

import java.util.Map;

public class NodeNearby implements NodeExpr{

    private String direction;

    public NodeNearby(String direction){
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Nearby" + direction;
    }

    @Override
    public long eval(Map<String, Long> variable) {
        return 0;
    }
}
