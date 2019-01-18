package Project;

import java.util.Iterator;

public class ScanTool implements Iterator<Token> {
    //Instantiate variables for ScanTool
    private int line = 1;
    private String input;
    private boolean finish;
    private int index = -1;

    private ScanTool(String input){
        this.input = input;
    }

    //getScanner method; Creates scanTool, advances scanTool, returns.
    public static ScanTool getScanner(final String input){
        ScanTool scanTool = new ScanTool(input);
        scanTool.advance();
        return scanTool;
    }

    //If scanner still has information to parse, continue.
    public boolean hasNext(){
        advance();
        if(this.finish){
            return false;
        }
        if(index >= input.length()){
            this.finish = true;
            return false;
        }
        return true;
    }

    //Handles next token in the input file.
    public Token next() {
        Token singleChar = singleChar();
        if (singleChar != null) {
            advanceLine();
            return singleChar;
        }

        String lexeme = "";

        while (index < input.length()) {
            singleChar = singleChar();
            if (singleChar != null || (!lexeme.isEmpty() && lexeme.charAt(0) != '"' && Character.isWhitespace(input.charAt(index)))) {
                return getTokenFromLexeme(lexeme);
            }

            lexeme = lexeme + input.charAt(index);
            advanceLine();
            TokenType tokenType = TokenType.getMatchingToken(lexeme);

            if(tokenType != null){
                return build(tokenType, lexeme);
            }

            if(lexeme.length() > 1 && lexeme.charAt(lexeme.length() - 1) == '"'){
                break;
                    }
            } //End while loop

            //Deals with EOF token type
            if (lexeme.isEmpty() || !lexeme.matches(".*\\w.*")){
                return build(TokenType.EOF, "");
            } else{
                return getTokenFromLexeme(lexeme);
            }

        }

    //Build a token from lexeme
    public Token getTokenFromLexeme(final String lexeme){
        try {
            String value = String.valueOf(Integer.parseInt(lexeme));
            return build(TokenType.CONST_TOK, value);
        } catch (NumberFormatException e){

        }
        return build (TokenType.ID_TOK, lexeme);
    }

    private Token build(final TokenType tokenType, final String lexeme){
        return new Token(line, lexeme, tokenType);

    }

    //Deals with single char
    private Token singleChar(){
        TokenType tokenType = TokenType.getMatchingToken(String.valueOf(input.charAt(index)));
        if (tokenType != null){
            return build(tokenType, String.valueOf(input.charAt(index)));
        }else{
            return null;
        }

    }

    //Advance if !Character.isWhiteSpace
    private void advance(){
        for(int i = index; i < input.length(); i++){
            if (!(i == -1) && !Character.isWhitespace(input.charAt(i))){
                break;
            }
            advanceLine();
        }

    }

    //Used in advance() to move to next line if whitespace is hit.
    private void advanceLine(){
        if (index > -1 && index < input.length() && input.charAt(index) == '\n'){
            line++;
        }
        index++;
    }

}
