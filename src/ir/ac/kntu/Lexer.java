package ir.ac.kntu;

import java.util.Arrays;

public class Lexer {


    private final String code;
    private final int codeLength;

    private boolean isEndOfCode=false;

    private int currentIndex;

    private Token currentToken;
    private Token previousToken;

    private String currentNumber,currentVariable;

    public Lexer(String code) {
        this.code = code;
        this.currentIndex = 0;
        this.codeLength = code.length();
    }

    /**
     * Updates currentToken to the next valid Token if it is available.
     *
     * @return true, if a valid token is available next.
     */
    public boolean nextToken() {

        while (!isEndOfCode) { // while loop is to fetch nextToken, if a skipWS occurs.

            previousToken = currentToken; // in case you need the previous token

            final char currentChar = code.charAt(currentIndex);

            if (Arrays.asList(' ', '\r', '\t', '\n').contains(currentChar)) { // 1. WS
                skipWhiteSpace();
                continue;
            } else if (currentChar == '=') { // 2. LET
                currentToken = new Token(Token.TokenType.EQUALS_OPERATOR);
                currentIndex++;
            } else if (Character.isDigit(currentChar)) { // 3. INT
                currentToken = new Token(Token.TokenType.NUMBER, readNumber());
            } else if (Character.isLetter(currentChar)) {
                String variableName = readVariable();
                if (variableName.equalsIgnoreCase("show")) { // 4. SHOW
                    currentToken = new Token(Token.TokenType.SHOW);
                } else { // 5. VAR
                    currentToken = new Token(Token.TokenType.VARIABLE, variableName);
                }
            } else {
                try {
                    throw new LexerException("Token not defined.");
                } catch (LexerException e) {
                    e.printStackTrace();
                }
            }
            return true;
        }
        return false;
    }

    /**
     * Read Integer as String
     *
     * @return String value of Integer Number.
     */
    private String readNumber() {
      return currentNumber;
    }

    /**
     * @return String read from current index.
     */
    private String readVariable() {
     return currentVariable;
    }

    /**
     * Skip WhiteSpace(WS)
     */
    private void skipWhiteSpace() {
    }

    /**
     * Get current Token.
     */
    public Token getCurrentToken() {
        return currentToken;
    }

}
