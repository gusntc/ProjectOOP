package org.example;

public class ExprParser implements Parser {

    private  Tokenizer tkz;

    public  ExprParser(Tokenizer tkz){
        this.tkz = tkz;
    }

    @Override
    public void parse() throws SyntaxError {
        System.out.println("before plan");
            parsePlan();
//            if(tkz.hasNextToken()){
//                throw new SyntaxError(tkz.peek());
//            }
            

    }

    private void parsePlan() throws SyntaxError{
        System.out.println("before statement");
        parseStament();
    }

    private void parseStament() {
//        if(tkz.peek("Command"))
//        parseCommand();
//        else if (tkz.peek("{")) {
//            tkz.consume();
//            parseBlockStament();
//            if(tkz.peek("}")) tkz.consume();
//            else throw new SyntaxError("expected : " + "}");
//        }
        System.out.println("before ifstatement");
        parseIfStatement();
//        parseWhileStatement();

    }

    private void parseBlockStament() {
        parseStament();
    }

    private void parseWhileStatement() {
        if(tkz.peek("while")){
            tkz.consume();
            if(tkz.peek("(")){
                tkz.consume();
                parseStament();
                if(tkz.peek(")")) tkz.consume();
                parseStament();
            }

        }
    }

    private void parseIfStatement() {

        if(tkz.peek("if")){
            tkz.consume();

            if(tkz.peek("(")){
                tkz.consume();
//                parseExpression();
                if(!tkz.hasNextToken() ){
                    throw new SyntaxError("expected : " + ")");
                } else if (tkz.peek(")")) {
                    tkz.consume();
                } else throw new SyntaxError(tkz.toString());
            }
            if(tkz.peek("then")){
                tkz.consume();
                parseStament();
            }
            if(tkz.peek("else")){
                tkz.consume();
                parseStament();
            }
        }
    }

    private void parseCommand() {
        parseAssignmentStatement();
        parseActionCommand();
    }

    private void parseActionCommand() {
        if(tkz.peek("done")){
            //done
        } else if (tkz.peek("relocate")) {
            //relocate
        }
        parseMoveCommand();
        parseRegionCommand();
        parseAttackCommand();
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
            parseDirection();
        }
        
    }

    private void parseDirection() {
        if(tkz.peek("up")){
            //Up
        } else if (tkz.peek("down")) {
            //down
        } else if (tkz.peek("upleft")) {
            //upleft
        } else if (tkz.peek("upright")) {
            //upright
        } else if (tkz.peek("downleft")) {
            //downleft
        } else if (tkz.peek("downright")) {
            //downright
        }else throw new SyntaxError("unknown direction");
    }


    private void parseAssignmentStatement() {
        parseExpression();
    }

    private void parseExpression() {
        parseTerm();
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
        if(tkz.peek("^")){
            tkz.consume();
            parseFactor();
        }
    }

    private void parsePower() {
        int sth;
        String sone;
        if(tkz.peek("(")){
            parseExpression();
        }
        parseInfoExpression();

    }

    private void parseInfoExpression() {
        //Opponent();
        //parseNearby();
    }




}
