package SyntaxofGrammar.Parser;

import SyntaxofGrammar.AST.*;
import SyntaxofGrammar.Tokenizer.ExprTokenizer;
import SyntaxofGrammar.Error.SyntaxError;

public class ExprParser {
    private final ExprTokenizer tkz;

    public ExprParser(ExprTokenizer tkz) {
        if (!tkz.hasNextToken()) System.out.println("error at construct");
        this.tkz = tkz;
    }

    public NodeExpr parse() {
        NodeExpr plan = parsePlan();
        return plan;
    }
    private NodeExpr parsePlan() {
        NodeExpr state = parseStatement();
        return state;
    }
    private NodeExpr parseStatement() {
        NodeExpr node = null;
        switch (tkz.peek()){
            case "{" :
                node = parseBlockStatement();
            case "while" :
                node = parseWhileStatement();
            case "if" :
                node = parseIfStatement();
            default:
                node = parseCommand();
        }
        return node;
    }
    private NodeExpr parseCommand() {

        if (tkz.peek("done") || tkz.peek("relocate") || tkz.peek("invest") || tkz.peek("move") || tkz.peek("collect") || tkz.peek("shoot")) return parseActionCommand();
        else return parseAssignmentStatement();
    }
    private NodeExpr parseBlockStatement() {
        tkz.consume("{");
        NodeExpr state = parseStatement();
        tkz.consume("}");
        return state;
    }
    private NodeExpr parseIfStatement() {
        NodeExpr expr =null;
        NodeExpr truestate = null;
        NodeExpr falsestate = null;
        if(tkz.peek("if")){
            tkz.consume();
            if(tkz.peek("(")){
                expr = parseExpression();
                tkz.consume(")");
                if(tkz.peek("then")){
                    tkz.consume();
                    truestate =parseStatement();
                    tkz.consume();
                    falsestate =parseExpression();
                }
            }
        }
        return new NodeIfElse(expr,truestate,falsestate);
    }
    private NodeExpr parseWhileStatement() {
        NodeExpr expr = null;
        NodeExpr state=null;
        if(tkz.peek("while")){
            tkz.consume();
            if(tkz.peek("(")){
                tkz.consume();
                expr = parseExpression();
                tkz.consume();
                state = parseStatement();
            }
        }
        return new NodeWhile(expr,state);
    }
    private NodeExpr parseAssignmentStatement() {
        String identifier = tkz.consume();
        if (tkz.peek("done") || tkz.peek("relocate") || tkz.peek("invest") || tkz.peek("move") || tkz.peek("collect") || tkz.peek("shoot")||
                tkz.peek("opponent") || tkz.peek("nearby") || tkz.peek("up") || tkz.peek("upleft") || tkz.peek("upright") || tkz.peek("down") ||
                tkz.peek("downleft") || tkz.peek("downright") || tkz.peek("else") || tkz.peek("if") || tkz.peek("then") || tkz.peek("while"))
            System.out.println("error at parseAS");
        if (tkz.peek("="))
            tkz.consume();
        else
            System.out.println("error at parseAs");
        NodeExpr expr = parseExpression();
        return new NodeAssign(identifier,expr);
    }
    private NodeExpr parseActionCommand() {
        String command = tkz.consume();
        switch (command) {
            case "done" :
                //done
                return new NodeDone();
            case "relocate" :
                //relocate
                return new NodeRelocate();
            case "invest" :
                return parseInvest();

            case "move" :
                return parseMove();
            case "collect" :
                return parseCollect();
            case "shoot" :
                return parseShoot();
            default :
                throw new SyntaxError("Error in ActionCom");
        }
    }
    private NodeExpr parseInvest() {
        NodeExpr expr = parseExpression();
        return new NodeInvest(expr);
    }
    private NodeExpr parseMove() {
        String direction = parseDirection();
        return new NodeMove(direction);
    }
    private NodeExpr parseCollect() {
        NodeExpr expr = parseExpression();
        return new NodeCollect(expr);
    }
    private NodeExpr parseShoot() {
        String direction = parseDirection();
        NodeExpr expr = parseExpression();
        return new NodeShoot(expr,direction);
    }


    private NodeExpr parseExpression() {
        NodeExpr result = parseTerm();
        while(tkz.hasNextToken() && (tkz.peek("+") || tkz.peek("-"))){
            if(tkz.peek("+")){
                tkz.consume();
                result = new BinaryArithExpr(result,"+",parseTerm());
            } else if (tkz.peek("-")) {
                tkz.consume();
                result = new BinaryArithExpr(result,"-",parseTerm());
            }
        }
        return result;
    }

    private NodeExpr parseTerm() {
        NodeExpr result = parseFactor();
        while (tkz.hasNextToken() && (tkz.peek("*") || tkz.peek("/") || tkz.peek("%"))){
            if(tkz.peek("*")){
                tkz.consume();
                result = new BinaryArithExpr(result,"*",parseFactor());

            }else if(tkz.peek("/")){
                tkz.consume();
                result = new BinaryArithExpr(result,"/",parseFactor());
            }else if(tkz.peek("%")){
                tkz.consume();
                result = new BinaryArithExpr(result,"%",parseFactor());
            }
        }
        return result;
    }

    private NodeExpr parseFactor() {
        NodeExpr result = parsePower();
        if(tkz.hasNextToken() && tkz.peek("^")){
            tkz.consume();
            result = new BinaryArithExpr(result,"^",parseFactor());
        }
        return result;
    }

    private NodeExpr parsePower() {
        NodeExpr result = null;
        if(Character.isDigit((tkz.peek().charAt(0)))){
            return new NodeNumber(Long.parseLong(tkz.consume()));
        } else if (tkz.peek("opponent") || tkz.peek("nearby")) {
            return parseInfoExpression();
        }
        if(tkz.hasNextToken() && tkz.peek("(")){
            tkz.consume("(");
            result = parseExpression();
            tkz.consume(")");
        }
        return result;
    }
    private NodeExpr parseInfoExpression() {

        if (tkz.peek("opponent")) {
            tkz.consume();
            return new NodeOpponent();
        } else if (tkz.peek("nearby")) {
            tkz.consume();
            String direction = parseDirection();
            return new NodeNearby(direction);
        } else {
            System.out.println("error in info expr");
        }
        return null;
    }

    private String parseDirection() {
        if(tkz.peek("up")){
            //Up
            return tkz.consume();
        } else if (tkz.peek("down")) {
            //down
            return tkz.consume();
        } else if (tkz.peek("upleft")) {
            //upleft
            return tkz.consume();
        } else if (tkz.peek("upright")) {
            //upright
            return tkz.consume();
        } else if (tkz.peek("downleft")) {
            //downleft
            return tkz.consume();
        } else if (tkz.peek("downright")) {
            //downright
            return tkz.consume();
        }else throw new SyntaxError("unknown direction");
    }
}
