package SyntaxofGrammar.AST;

import java.util.Map;

public class NodeWhile implements NodeExpr{

    private NodeExpr condition;
    private NodeExpr statement;

    public NodeWhile(NodeExpr condition,NodeExpr statement){
        this.condition = condition;
        this.statement = statement;

    }

    @Override
    public String toString() {
        return "While" + condition + "then" + statement;
    }

    @Override
    public long eval(Map<String, Long> variable) {
        return 0;
    }
}
