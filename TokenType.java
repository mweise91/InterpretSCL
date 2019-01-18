package Project;

import java.util.HashMap;

    public enum TokenType {

        //List of keywords
        SPECIFICATIONS("specifications"),
        SYMBOL("symbol"),
        FORWARD("forward"),
        REFERENCES("references"),
        FUNCTION("function"),
        POINTER("pointer"),
        ARRAY("array"),
        TYPE("type"),
        STRUCT("struct"),
        ENUM("enum"),
        GLOBAL("global"),
        DECLARATIONS("declarations"),
        IMPLEMENTATIONS("implementations"),
        MAIN("main"),
        PARAMETERS("parameters"),
        CONSTANT("constant"),
        BEGIN("begin"),
        ENDFUN("endfun"),
        IF("if"),
        WHILE("while"),
        THEN("then"),
        ELSE("else"),
        ENDIF("endif"),
        REPEAT("repeat"),
        UNTIL("until"),
        ENDREPEAT("endrepeat"),
        DISPLAY("display"),
        SET("set"),
        RETURN("return"),
        DO("do"),
        END("end"),
        AND("and"),
        BREAK("break"),
        ELSEIF("elseif"),
        FALSE("false"),
        FOR("for"),
        IN("in"),
        LOCAL("local"),
        NIL("nil"),
        NOT("not"),
        OR("or"),
        TRUE("true"),
        COMMENTS("--"),


        //Everything else
        STRING(null),
        INTEGER(null),
        ID_TOK("^[a-zA-Z]*$"),
        ASS_TOK("="),
        ADD_TOK("+"),
        SUB_TOK("-"),
        MUL_TOK("*"),
        DIV_TOK("/"),
        LE_TOK("<="),
        LT_TOK("<"),
        LP_TOK("("),
        RP_TOK(")"),
        GE_TOK(">="),
        GT_TOK(">"),
        EQ_TOK("="),
        NE_TOK("~="),
        EXP_TOK("^"),
        LT_OPERATOR("<"),
        LE_OPERATOR("<="),
        CONST_TOK (null),
        EOF(null);


        private static HashMap<String, TokenType> findTable = new HashMap<>();
        static {
            for (TokenType tokenType : values()) {
                if (tokenType.text != null) {
                    findTable.put(tokenType.text, tokenType);
                }
            }
        }
        private String text;
        TokenType(final String text){
            this.text = text;
        }
        public static TokenType getMatchingToken(final String lexeme) {
            return findTable.get(lexeme);
        }
    }

