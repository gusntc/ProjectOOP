package SyntaxofGrammar.AST;

import java.util.Map;

public class NodeIfElse implements NodeExpr{

    private NodeExpr condition;
    private NodeExpr trueState;
    private NodeExpr falseState;

    public NodeIfElse(NodeExpr condition,NodeExpr trueState,NodeExpr falseState){
        this.condition = condition;
        this.trueState = trueState;
        this.falseState = falseState;
    }

    @Override
    public String toString() {
        return "if" + condition + "then" + trueState + "else" + falseState;
    }

    @Override
    public long eval(Map<String, Long> variable) {
        return 0;
    }
}
