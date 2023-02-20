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

    private void ComputeNext(){
        StringBuilder s = new StringBuilder();
        while (pos < src.length() && Character.isWhitespace(src.charAt(pos))) pos++;
        if(pos == src.length()) {
            next = null;
            return;
        }
        char c = src.charAt(pos);
        if(Character.isDigit(c)){
            s.append(c);
            for(pos++; pos < src.length() && Character.isDigit(src.charAt(pos)); pos++) {
                s.append(src.charAt(pos));
            }
        }else if(c == '+' || c == '-' || c == '*' || c == '/' || c == '%' || c == '(' || c == ')'){
            s.append(c);
            pos++;
        }else throw new IllegalArgumentException("unknown character : " + c);
        next = s.toString();
    }
}
