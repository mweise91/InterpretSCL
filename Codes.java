package Project;

import Project.TokenType;

import java.util.HashMap;
import java.util.Map;

public class Codes {

    public static final int INT_CODE = 1;
    public static final int ID_CODE =  2;
    public static final int ASS_CODE = 3;
    public static final int LE_CODE =  4;
    public static final int LT_CODE =  5;
    public static final int GE_CODE =  6;
    public static final int GT_CODE =  7;
    public static final int EQ_CODE =  8;
    public static final int NE_CODE =  9;
    public static final int ADD_CODE = 10;
    public static final int SUB_CODE = 11;
    public static final int MUL_CODE = 12;
    public static final int DIV_CODE = 13;
    public static final int NIL_CODE = 14;
    public static final int NOT_CODE = 15;
    public static final int OR_CODE =  16;
    public static final int REPEAT_CODE = 17;
    public static final int RETURN_CODE = 18;
    public static final int THEN_CODE =   19;
    public static final int TRUE_CODE =   20;
    public static final int UNTIL_CODE =  21;
    public static final int WHILE_CODE =  22;
    public static final int LEFT_CODE =   23;
    public static final int RIGHT_CODE =  24;
    public static final int AND_CODE =    25;
    public static final int BREAK_CODE =  26;
    public static final int DO_CODE =     27;
    public static final int ELSE_CODE =   28;
    public static final int ELSEIF_CODE = 29;
    public static final int END_CODE =    30;
    public static final int FALSE_CODE =  31;
    public static final int FOR_CODE =    32;
    public static final int FUNCTION_CODE = 33;
    public static final int IF_CODE =     34;
    public static final int IN_CODE =     35;
    public static final int LOCAL_CODE =  36;
    public static final int COMMENTS_CODE = 37;
    public static final int  EOF_CODE =   38;

    private Codes() {

    }

    private static Map<TokenType, Integer> codeLookup = new HashMap<>();

    static {
        codeLookup.put(TokenType.INTEGER, INT_CODE);
        codeLookup.put(TokenType.ID_TOK, ID_CODE);
        codeLookup.put(TokenType.ASS_TOK, ASS_CODE);
        codeLookup.put(TokenType.LE_OPERATOR, LE_CODE);
        codeLookup.put(TokenType.LT_OPERATOR, LT_CODE);
        codeLookup.put(TokenType.GE_TOK, GE_CODE);
        codeLookup.put(TokenType.GT_TOK, GT_CODE);
        codeLookup.put(TokenType.EQ_TOK, EQ_CODE);
        codeLookup.put(TokenType.NE_TOK, NE_CODE);
        codeLookup.put(TokenType.LOCAL, LOCAL_CODE);
        codeLookup.put(TokenType.NIL, NIL_CODE);
        codeLookup.put(TokenType.NOT, NOT_CODE);
        codeLookup.put(TokenType.OR, OR_CODE);
        codeLookup.put(TokenType.REPEAT, REPEAT_CODE);
        codeLookup.put(TokenType.RETURN, RETURN_CODE);
        codeLookup.put(TokenType.THEN, THEN_CODE);
        codeLookup.put(TokenType.TRUE, TRUE_CODE);
        codeLookup.put(TokenType.ADD_TOK, ADD_CODE);
        codeLookup.put(TokenType.SUB_TOK, SUB_CODE);
        codeLookup.put(TokenType.MUL_TOK, MUL_CODE);
        codeLookup.put(TokenType.DIV_TOK, DIV_CODE);
        codeLookup.put(TokenType.LP_TOK, LEFT_CODE);
        codeLookup.put(TokenType.RP_TOK, RIGHT_CODE);

        codeLookup.put(TokenType.AND, AND_CODE);
        codeLookup.put(TokenType.BREAK, BREAK_CODE);
        codeLookup.put(TokenType.DO, DO_CODE);
        codeLookup.put(TokenType.ELSE, ELSE_CODE);
        codeLookup.put(TokenType.ELSEIF, ELSEIF_CODE);
        codeLookup.put(TokenType.END, END_CODE);
        codeLookup.put(TokenType.FALSE, FALSE_CODE);
        codeLookup.put(TokenType.FOR, FOR_CODE);
        codeLookup.put(TokenType.FUNCTION, FUNCTION_CODE);
        codeLookup.put(TokenType.IF, IF_CODE);
        codeLookup.put(TokenType.IN, IN_CODE);
        codeLookup.put(TokenType.UNTIL, UNTIL_CODE);
        codeLookup.put(TokenType.WHILE, WHILE_CODE);
        codeLookup.put(TokenType.COMMENTS, COMMENTS_CODE);
        codeLookup.put(TokenType.EOF, EOF_CODE);

    }

    public static Integer getCodeFromTokenType(final TokenType tokenType) {
        return codeLookup.get(tokenType);
    }
}
