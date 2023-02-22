package org.example;

import java.util.NoSuchElementException;

public class ExprTokenizer implements Tokenizer {
    private String src;
    private String next;
    private int pos;

    public ExprTokenizer(String src){
        this.src = src;
        ComputeNext();
    }

    @Override
    public boolean hasNextToken(){
        return next != null;
    }

    @Override
    public String peek() {
        if(!hasNextToken()){
            throw new NoSuchElementException("no more tokens");
        }
        return next;
    }

    @Override
    public String consume() {
        if(!hasNextToken()){
            throw new NoSuchElementException("no more tokens");
        }
        String result = next;
        ComputeNext();
        return result;
    }

    @Override
    public boolean peek(String s) {
        return peek().equals(s);
    }

    @Override
    public void consume(String s) {
        if(peek(s)){
            consume();
        }else{
            throw  new SyntaxError(s + "expected");
        }
    }

    public void ComputeNext(){
        StringBuilder s = new StringBuilder();
        while (pos < plan.length() && Character.isWhitespace(plan.charAt(pos))) pos++;
        if(pos == plan.length()) {
            next = null;
            return;
        }
        char c = plan.charAt(pos);
        if(Character.isAlphabetic(c)){
            s.append(c);
            for(pos++; pos < plan.length() && Character.isAlphabetic(plan.charAt(pos)); pos++) {
                s.append(plan.charAt(pos));
            }
        } else if (c == '=' || c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
            s.append(c);
            pos++;
        } else if (c == '(' || c == ')' || c == '{' || c == '}' || c== '^') {
            s.append(c);
            pos++;
        } else if (Character.isDigit(c)) {
            s.append(c);
            for(pos++;pos < plan.length() && Character.isDigit(plan.charAt(pos));pos++){
                s.append(plan.charAt(pos));
            }
        } else throw new IllegalArgumentException();
        next = s.toString();
    }
}
