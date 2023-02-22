package org.example;

public class TestCase {
    public void prase() {
        ExprTokenizer t = new ExprTokenizer("if (");
        System.out.println(t.peek());
        t.consume();
        System.out.println(t.peek());
        ExprParser p = new ExprParser(t);
        p.parse();
    }
}
