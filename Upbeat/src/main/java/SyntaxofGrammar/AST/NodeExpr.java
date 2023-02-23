package SyntaxofGrammar.AST;

import java.util.Map;

public interface NodeExpr extends Node {
    long eval(Map<String, Long> variable);


}
