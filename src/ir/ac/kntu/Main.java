package ir.ac.kntu;

public class Main {

    public static void main(String[] args) {


        // 0. Input Code
        String sourceCode = null;

        // 1. Lexer
        Lexer lexer = null;
        if (sourceCode != null) {
            lexer = new Lexer(sourceCode);
        }
        // 2. Parser
        Parser parser = new Parser(lexer);
        ParseTree tree = null;

        if (tree != null) {

            // 3. Semantic Analyzer Visitor
            SemanticAnalyzer semanticAnalyzer;

            // 4.1 Interpreter Visitor
            Interpreter interpreter;
        }
    }
}
