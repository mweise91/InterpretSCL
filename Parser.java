package Project;

import java.util.*;
import java.util.LinkedList;
import java.util.List;



public class Parser{

    LinkedList<Token> tokens;
    Token look;

    public void parse(List<Token> tokens)
    {
        this.tokens = (LinkedList<Token>) tokens;
        look = this.tokens.getFirst();
        expression();
    }

    private void nextToken()
    {
            tokens.pop();
            look = tokens.getFirst();
    }

    private void expression()
    {
        while(!tokens.isEmpty()){
            if (look.getTokenType() == TokenType.ID_TOK){
                assign();
            }
            else if (look.getTokenType() == TokenType.WHILE){
                whileLoop();
            }
            else if (look.getTokenType() == TokenType.IF){
                ifLoop();
            }
            else if (look.getTokenType() == TokenType.REPEAT){
                repeat();
            }
        }
    }

    private void assign()
    {
        nextToken();
        arith();
    }



    private void whileLoop()
    {
        nextToken();
        booleanOp();


        while(look.getTokenType() == TokenType.END){
            statement();
        }
        nextToken();
    }


    private void repeat()
    {
        nextToken();
        while(look.getTokenType() != TokenType.UNTIL){
            statement();
        }
        nextToken();
        booleanOp();
    }


    private void ifLoop()
    {
        nextToken();
        booleanOp();

        while(look.getTokenType() != TokenType.ELSE){
            statement();
        }
        nextToken();
        while(look.getTokenType() != TokenType.END){
            statement();
        }
        nextToken();
    }

    private void print()
    {
        nextToken();
        if(look.getTokenType() != TokenType.LP_TOK){
        }
        else{
            nextToken();
        }
        arith();
        nextToken();

    }

    private void booleanOp()
    {
        relOp();
        arith();
        arith();
    }

    private void relOp()
    {
        if(look.getTokenType() == TokenType.LE_OPERATOR || look.getTokenType() == TokenType.LT_OPERATOR || look.getTokenType() == TokenType.GE_TOK
                || look.getTokenType() == TokenType.GT_TOK || look.getTokenType() == TokenType.EQ_TOK || look.getTokenType() == TokenType.NE_TOK){
            nextToken();
        }
    }

    private void statement()
    {
        if (look.getTokenType() == TokenType.ID_TOK){
            assign();
        }
        else if (look.getTokenType() == TokenType.WHILE){
            whileLoop();
        }
        else if (look.getTokenType() == TokenType.IF){
            ifLoop();
        }
        else if (look.getTokenType() == TokenType.REPEAT){
            repeat();
        }

    }

    private void arith()
    {

        if(look.getTokenType() == TokenType.ID_TOK || look.getTokenType() == TokenType.INTEGER){
            nextToken();
        }
        else if(look.getTokenType() == TokenType.ADD_TOK || look.getTokenType() == TokenType.SUB_TOK
                || look.getTokenType() == TokenType.MUL_TOK || look.getTokenType() == TokenType.DIV_TOK){
            arith();
            arith();
        }
    }



}