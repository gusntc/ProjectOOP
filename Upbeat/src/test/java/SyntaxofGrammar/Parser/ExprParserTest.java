package SyntaxofGrammar.Parser;

import SyntaxofGrammar.AST.BinaryArithExpr;
import SyntaxofGrammar.AST.LongLit;
import SyntaxofGrammar.AST.NodeExpr;
import SyntaxofGrammar.AST.Variable;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExprParserTest {
    @Test
    public void test(){
//        NodeExpr x = new Variable("x");
        NodeExpr four = new LongLit(4);
        NodeExpr two = new LongLit(2);
        NodeExpr xPowerFour = new BinaryArithExpr(two,"+",four);

    }
}