package SyntaxofGrammar.AST;

import java.util.Map;

public class NodeIdentifier implements NodeExpr{
    private String identifier;
    public NodeIdentifier(String identifier){
        this.identifier = identifier;
    }

    @Override
    public String toString() {
        return identifier;
    }

    @Override
    public long eval(Map<String, Long> variable) {
        return 0;
    }
}
