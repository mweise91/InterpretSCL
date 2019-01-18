package Project;

public class Token {

    private int line;

    private String lexeme;
    private TokenType tokenType;

    //Constructor
    public Token(final int line,  final String lexeme, final TokenType tokenType) {
        this.lexeme = lexeme;
        this.tokenType = tokenType;
        this.line = line;

    }

    //Return lexeme
    public String getLexeme(){
        return lexeme;
    }

    //Return tokenType
    public TokenType getTokenType() {
        return tokenType;
    }

    //Return line
    public int getLine(){
        return line;
    }


    //Output tokens scanned
    public void print(){
        System.out.format("%-15s%-30s%-60s%n",
                "Line#:" + getLine(),
                "Token#:" + getTokenType().name(),
                "Lexeme:" + getLexeme());
    }


}
