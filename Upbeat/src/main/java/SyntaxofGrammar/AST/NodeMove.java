package SyntaxofGrammar.AST;

import java.util.Map;

public class NodeMove implements NodeExpr {
    private String direction;

    public NodeMove(String direction){
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Move" + direction;
    }

    @Override
    public long eval(Map<String, Long> variable) {
        return 0;
    }
}
