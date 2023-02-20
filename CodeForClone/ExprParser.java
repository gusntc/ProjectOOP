package org.example;

import java.util.NoSuchElementException;

public class ExprParser implements Parser {
    /*
    Plan → Statement+
    Statement → Command | BlockStatement | IfStatement | WhileStatement
    Command → AssignmentStatement | ActionCommand
    AssignmentStatement → <identifier> = Expression
    ActionCommand → done | relocate | MoveCommand | RegionCommand | AttackCommand
    MoveCommand → move Direction
    RegionCommand → invest Expression | collect Expression
    AttackCommand → shoot Direction Expression
    Direction → up | down | upleft | upright | downleft | downright
    BlockStatement → { Statement* }
    IfStatement → if ( Expression ) then Statement else Statement
    WhileStatement → while ( Expression ) Statement
    Expression → Expression + Term | Expression - Term | Term
    Term → Term * Factor | Term / Factor | Term % Factor | Factor
    Factor → Power ^ Factor | Power
    Power → <number> | <identifier> | ( Expression ) | InfoExpression
    InfoExpression → opponent | nearby Direction
     */
    private  Tokenizer tkz;

    public  ExprParser(Tokenizer tkz){
        this.tkz = tkz;
    }

    @Override
    public int parse() throws SyntaxError {
        try{
            parsePlan();
            if(tkz.hasNextToken()){
                throw new SyntaxError(tkz.peek());
            }
            
        }catch (SyntaxError e){
            throw new SyntaxError(e.getMessage());
        }
    }

    private void parsePlan() throws SyntaxError{
        parseStament();
    }

    private void parseStament() {
        if(tkz.peek("Command"))
        parseCommand();
        else if (tkz.peek("{")) {
            tkz.consume();
            parseBlockStament();
            if(tkz.peek("}")) tkz.consume();
            //else throw new SyntaxError;
        }

        parseIfStatement();
        parseWhileStatement();

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
        String indentifier = String.valueOf(parseExpression());
    }

    private double parseExpression() {
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
        parseOpponent();
        parseNearby();
    }

    private void parseNearby() {
    }

    private void parseOpponent() {
    }


}
