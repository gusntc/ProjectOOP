package SyntaxofGrammar.Tokenizer;

import java.util.NoSuchElementException;

public class ExprTokenizer extends Error{

    private String src;
    private String next;
    private int pos;

    public ExprTokenizer(String src){
        this.src = src;
        ComputeNext();
    }

    public boolean hasNextToken(){
        return next != null;
    }

    public String peek() {
        if(!hasNextToken()){
            throw new NoSuchElementException("no more token");
        }
        return next;
    }

    public String consume() {
        if(!hasNextToken()){
            throw new NoSuchElementException("no more token");
        }
        String result = next;
        ComputeNext();
        return result;
    }

    public boolean peek(String s) {
        return peek().equals(s);
    }

    public void consume(String s) {
        if(peek(s)){
            consume();
        }else{
            throw  new RuntimeException();
        }
    }

    public void ComputeNext(){
       StringBuilder s = new StringBuilder();
        while (pos < src.length() && Character.isWhitespace(src.charAt(pos))) pos++;
        if(pos == src.length()) {
            next = null;
            return;
        }
        char c = src.charAt(pos);
        if(Character.isAlphabetic(c)){
            s.append(c);
            for(pos++; pos < src.length() && Character.isAlphabetic(src.charAt(pos)); pos++) {
                s.append(src.charAt(pos));
            }
        } else if (c == '=' || c == '+' || c == '-' || c == '*' || c == '/' || c == '%') {
            s.append(c);
            pos++;
        } else if (c == '(' || c == ')' || c == '{' || c == '}' || c== '^') {
            s.append(c);
            pos++;
        } else if (Character.isDigit(c)) {
            s.append(c);
            for(pos++;pos < src.length() && Character.isDigit(src.charAt(pos));pos++){
                s.append(src.charAt(pos));
            }
        } else throw new IllegalArgumentException();
        next = s.toString();
    }
}
