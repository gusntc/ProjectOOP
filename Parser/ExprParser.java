package org.example;

public class ExprParser implements Parser {

    private final Tokenizer tkz;

    public  ExprParser(Tokenizer tkz){
        this.tkz = tkz;
    }

    @Override
    public void parse() throws SyntaxError {
        System.out.println("plan");
        parsePlan();
    }

    private void parsePlan() throws SyntaxError{
        System.out.println("state");
        parseStatement();
    }

    private void parseStatement() {
        System.out.println("in state");
        if(tkz.peek("if")){
            tkz.consume();
            parseIfStatement();
        } else if (tkz.peek("{")) {
            tkz.consume();
            parseBlockStatement();
            if(tkz.peek("}")) tkz.consume();
            else throw new SyntaxError("expected : " + "}");
        } else if (tkz.peek("while")) {
            parseWhileStatement();
        }else{
            System.out.println("before command");
            parseCommand();
        }
    }

    private void parseBlockStatement() {
        parseStatement();
    }

    private void parseWhileStatement() {
        if(tkz.peek("while")){
            tkz.consume();
            if(tkz.peek("(")){
                tkz.consume();
                parseExpression();
                if(tkz.peek(")")) tkz.consume();
                parseStatement();
            }
        }
    }

    private void parseIfStatement() {

        if(tkz.peek("if")){
            tkz.consume();

            if(tkz.peek("(")){
                tkz.consume();
                parseExpression();
                if(!tkz.hasNextToken() ){
                    throw new SyntaxError("expected : " + ")");
                } else if (tkz.peek(")")) {
                    tkz.consume();
                } else throw new SyntaxError(tkz.toString());
            }
            if(tkz.peek("then")){
                tkz.consume();
                parseStatement();
            }
            if(tkz.peek("else")){
                tkz.consume();
                parseStatement();
            }
        }
    }

    private void parseCommand() {
        System.out.println("in cm");
        parseAssignmentStatement();
//        parseActionCommand();
    }

    private void parseActionCommand() {
        if(tkz.peek("done")){
            //done
            tkz.consume();
        }else if(tkz.peek("relocate")) {
            //relocate
            tkz.consume();
        }else if(tkz.peek("move")){
            parseMoveCommand();
        } else if (tkz.peek("invest") || tkz.peek("collect")) {
            parseRegionCommand();
        } else if (tkz.peek("shoot")) {
            parseAttackCommand();
        }else throw new SyntaxError("unknown action");

    }

    private void parseAttackCommand() {
        if(tkz.peek("shoot")){
            tkz.consume();
            parseDirection();
            parseExpression();
        }
    }

    private void parseRegionCommand() {
        if(tkz.peek("invest")){
            tkz.consume();
            parseExpression();
            
        } else if (tkz.peek("collect")) {
            tkz.consume();
            parseExpression();
        }
    }

    private void parseMoveCommand() {
        if(tkz.peek("move")){
            //move
            tkz.consume();
            parseDirection();
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


    private void parseAssignmentStatement() {
        System.out.println("in assign");
        String identifier = tkz.consume();
        if(tkz.peek("=")) {
            System.out.println("in check =");
            System.out.println(tkz.peek());
            tkz.consume();
        }else throw new SyntaxError("expected =");
        parseExpression();
    }

    private void parseExpression() {
        System.out.println("exp");
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
        System.out.println("in term");
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
        System.out.println("in fac");
        parsePower();
        if(tkz.hasNextToken() && tkz.peek("^")){
            tkz.consume();
            parseFactor();
        }
    }

    private void parsePower() {
        System.out.println("in power");
        if(Character.isDigit((tkz.peek().charAt(0)))){
            tkz.consume();
            System.out.println("now in digit");
        } else if (Character.isAlphabetic(tkz.peek().charAt(0))) {
            tkz.consume();
        }
        if(tkz.hasNextToken() && tkz.peek("(")){
            tkz.consume("(");
            parseExpression();
            tkz.consume(")");
        }
        if(tkz.hasNextToken()) parseInfoExpression();
    }

    private void parseInfoExpression() {
        if(tkz.peek("opponent")){
            tkz.consume();
        } else if (tkz.peek("nearby")) {
            tkz.consume();
            parseDirection();
        }
    }

}
