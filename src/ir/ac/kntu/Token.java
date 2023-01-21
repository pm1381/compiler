package ir.ac.kntu;

public class Token {
    enum TokenType{
        VARIABLE,
        SHOW,
        NUMBER,
        EQUALS_OPERATOR
    }

    String variableName;

    public Token(TokenType type) {
    }

    public Token(TokenType type,String variableName) {
        this.variableName = variableName;
    }
}
