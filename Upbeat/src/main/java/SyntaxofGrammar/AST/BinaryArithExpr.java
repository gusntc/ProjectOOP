package SyntaxofGrammar.AST;

import SyntaxofGrammar.Error.SyntaxError;

import java.util.Map;

public class BinaryArithExpr implements NodeExpr{
    private NodeExpr left, right;
    private String op;
    public BinaryArithExpr(NodeExpr left,String op,NodeExpr right){
        this.left = left;
        this.op = op;
        this.right = right;
    }

    @Override
    public long eval(Map<String, Long> variable) {
        long lv = left.eval(variable);
        long rv = right.eval(variable);
        if(op.equals("+")) return lv+rv;
        if(op.equals("-")) return lv-rv;
        if(op.equals("*")) return lv*rv;
        if(op.equals("/")) return lv/rv;
        if(op.equals("%")) return lv%rv;
        if(op.equals("^")) return (long) Math.pow(lv,rv);
        throw new SyntaxError("unknown op" + op);
    }

}
