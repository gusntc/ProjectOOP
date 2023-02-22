
package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExprParserTest {

    @Test
    public void test(){
        ExprTokenizer t = new ExprTokenizer("t = t + 1" +
                "m = 0");
        ExprParser p = new ExprParser(t);
        p.parse();
    }



}