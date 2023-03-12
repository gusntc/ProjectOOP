package GameState;

import SyntaxofGrammar.AST.Node;

import java.util.LinkedList;

public class Territory {
    private int m=20;
    private int n=15;

    public LinkedList<Node>[] array = new LinkedList[m*n];
}
