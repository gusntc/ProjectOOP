package SyntaxofGrammar.Parser;

import SyntaxofGrammar.Tokenizer.ExprTokenizer;
import SyntaxofGrammar.Error.SyntaxError;

public class ExprParser {
    private final ExprTokenizer tkz;

    public ExprParser(ExprTokenizer tkz) {
        if (!tkz.hasNextToken()) System.out.println("error at construct");
        this.tkz = tkz;
    }

    public void parse() {
        parsePlan();
    }
    private void parsePlan() {
        parseStatement();
    }
    private void parseStatement() {
        switch (tkz.peek()){
            case "{" :
                parseBlockStatement();
            case "while" :
                parseWhileStatement();
            case "if" :
                parseIfStatement();
            default:
                parseCommand();
        }
    }
    private void parseCommand() {
        if (tkz.peek("done") || tkz.peek("relocate") || tkz.peek("invest") || tkz.peek("move") || tkz.peek("collect") || tkz.peek("shoot")) parseActionCommand();
        else parseAssignmentStatement();
    }
    private void parseBlockStatement() {
        if(tkz.peek("{")){
            tkz.consume();
            parseStatement();
            tkz.consume("}");
        }else{
            System.out.println("error in block statement");
        }
    }
    private void parseIfStatement() {
        if(tkz.peek("if")){
            tkz.consume();
            if(tkz.peek("(")){
                parseExpression();
                tkz.consume(")");
                if(tkz.peek("then")){
                    tkz.consume();
                    parseStatement();
                    tkz.consume();
                    parseExpression();
                }
            }
        }else{
            System.out.println("error in if statement");
        }
    }
    private void parseWhileStatement() {
        if(tkz.peek("while")){
            tkz.consume();
            if(tkz.peek("(")){
                parseExpression();
                tkz.consume();
                parseStatement();
            }
        }
    }
    private void parseAssignmentStatement() {
        String identifier = tkz.consume();
        if (tkz.peek("done") || tkz.peek("relocate") || tkz.peek("invest") || tkz.peek("move") || tkz.peek("collect") || tkz.peek("shoot")||
                tkz.peek("opponent") || tkz.peek("nearby") || tkz.peek("up") || tkz.peek("upleft") || tkz.peek("upright") || tkz.peek("down") ||
                tkz.peek("downleft") || tkz.peek("downright") || tkz.peek("else") || tkz.peek("if") || tkz.peek("then") || tkz.peek("while"))
            System.out.println("error at parseAS");
        if (tkz.peek("="))
            tkz.consume();
        else
            System.out.println("error at parseAs");
        parseExpression();
    }
    private void parseActionCommand() {
        String command = tkz.consume();
        switch (command) {
            case "done" :
                //done
            case "relocate" :
                //relocate
            case "invest" :
                parseInvest();
            case "move" :
                parseMove();
            case "collect" :
                parseCollect();
            case "shoot" :
                parseShoot();
            default :
                throw new SyntaxError("Error in ActionCom");
        }
    }
    private void parseInvest() {
        parseExpression();
    }
    private void parseMove() {
        parseDirection();
    }
    private void parseCollect() {
        parseExpression();
    }
    private void parseShoot() {
        parseDirection();
        parseExpression();
    }
    private void parseExpression() {
        parseTerm();
        while(tkz.hasNextToken() && (tkz.peek("+") || tkz.peek("-"))){
            if(tkz.peek("+")){
                tkz.consume();
                parseExpression();
            } else if (tkz.peek("-")) {
                tkz.consume();
                parseExpression();
            }
        }
    }

    private void parseTerm() {
        parseFactor();
        while (tkz.hasNextToken() && (tkz.peek("*") || tkz.peek("/") || tkz.peek("%"))){
            if(tkz.peek("*")){
                tkz.consume();
                parseFactor();
            }else if(tkz.peek("/")){
                tkz.consume();
                parseFactor();
            }else if(tkz.peek("%")){
                tkz.consume();
                parseFactor();
            }
        }
    }

    private void parseFactor() {
        parsePower();
        if(tkz.hasNextToken() && tkz.peek("^")){
            tkz.consume();
            parseFactor();
        }
    }

    private void parsePower() {
        if(Character.isDigit((tkz.peek().charAt(0)))){
            System.out.println("now in digit");
        } else if (tkz.peek("opponent") || tkz.peek("nearby")) {
            parseInfoExpression();
        }
        if(tkz.hasNextToken() && tkz.peek("(")){
            tkz.consume("(");
            parseExpression();
            tkz.consume(")");
        }
    }
    private void parseInfoExpression() {
        if (tkz.peek("opponent")) {
            tkz.consume();
        } else if (tkz.peek("nearby")) {
            tkz.consume();
            parseDirection();
        } else {
            System.out.println("error in info expr");
        }
    }
    private void parseDirection() {
        if(tkz.peek("up")){
            //Up
            tkz.consume();
        } else if (tkz.peek("down")) {
            //down
            tkz.consume();
        } else if (tkz.peek("upleft")) {
            //upleft
            tkz.consume();
        } else if (tkz.peek("upright")) {
            //upright
            tkz.consume();
        } else if (tkz.peek("downleft")) {
            //downleft
            tkz.consume();
        } else if (tkz.peek("downright")) {
            //downright
            tkz.consume();
        }else throw new SyntaxError("unknown direction");
    }
}
