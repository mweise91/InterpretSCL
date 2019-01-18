package Project;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.io.File;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Main {
    public static void main (String[] args){

        //Instantiate variables to scan sclex1.scl
        String input = null;
        Scanner scanner = new Scanner(System.in);
        File file = new File ("files/sclex1.scl");

        //Reads sclex1.scl if exists
        try{
            input = read(file.getAbsolutePath());
        }  catch(IOException q){
            System.out.println("IOException");
        }

        //Call main scan method
       scan(input);
    }

    //Creates a linked list to store tokens. Scans the document and adds to the LinkedList, and then prints them.
    static void scan (final String input){
        LinkedList<Token> tokens = new LinkedList<>();
        ScanTool.getScanner(input).forEachRemaining(tokens::add);
        tokens.forEach(Token::print);
    }

    //Parser
    static List<ParseToken> scan(
            final String input,
            final Map<Integer, String> literalLookup,
            final Map<Integer, String> parameterLookup){

        // Make and run a scanner
        LinkedList<Token> tokens = new LinkedList<>();
        ScanTool.getScanner(input).forEachRemaining(tokens::add);

        // Display info on all the token scanned
        tokens.forEach(Token::print);

        //Map tokens to codes
        return tokens.stream()
                .map(token -> {
                    Integer parameterCode = null;
                    Integer literalCode = null;
                    if (TokenType.ID_TOK.equals(token.getTokenType())) {
                        parameterCode = parameterLookup.size();
                        parameterLookup.put(parameterCode, token.getLexeme());
                    } else if (TokenType.INTEGER.equals(token.getTokenType())) {
                        literalCode = literalLookup.size();
                        literalLookup.put(literalCode, token.getLexeme());
                    }

                    return new ParseToken(
                            Codes.getCodeFromTokenType(token.getTokenType()),
                            parameterCode,
                            literalCode);
                })
                .collect(Collectors.toList());

    }


    //Method to read sclex1.scl
    static String read(String path) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, Charset.defaultCharset());
    }
}
