package SyntaxofGrammar.AST;

import SyntaxofGrammar.Error.SyntaxError;

import java.util.Map;

public class Variable implements NodeExpr{
    private String name;
    public Variable(String name){
        this.name = name;
    }

    @Override
    public long eval(Map<String, Long> variable) {
        if(variable.containsKey(name)) return variable.get(name);
        throw new SyntaxError("undefined variable: " + name);
    }

    @Override
    public String toString(){
        return name;
    }
}
