package ir.ac.kntu;


import java.util.HashMap;
import java.util.Map;

/**
 * NOTE: checking whether the variable is declared before "SHOW VAR" is an example of `Semantic`
 * check.
 */
public class SemanticAnalyzer {

    private final Map<String, String> variableMap;

    public SemanticAnalyzer() {
        super();
        this.variableMap = new HashMap<>();
    }

    /** Validate LET Semantics. */
    public void visitLet(LetContext context) {

        String variableName = context.getVariableName().getText();
        String variableValue = context.getVariableValue().getText();

        // Check if variable value is Integer. In our case, this will be already handled in the
        // Tokenizer.
        try {
            Integer.parseInt(variableValue);
        } catch (NumberFormatException | NullPointerException ex) {
            try {
                throw new SemanticException("Variable value should be integer.");
            } catch (SemanticException e) {
                e.printStackTrace();
            }
        }

        // This will be used to check whether variable is declared using LET before invoking SHOW for
        // the variable.
        variableMap.put(variableName, variableValue);
    }

    /**
     * Validate SHOW Semantics.
     *
     * <p>NOTE: We validate if the variable is previously declared using LET.
     */
    public void visitShow(Context context) {

        TerminalNode variableNameTN = context.getVariableName();

        /* if SHOW Argument is Variable, check if the variable is declared previously.*/
        if (variableNameTN != null && !variableMap.containsKey(variableNameTN.getText())) {
            try {
                throw new SemanticException("SHOW argument variable is not declared.");
            } catch (SemanticException e) {
                e.printStackTrace();
            }
        }
    }
}
