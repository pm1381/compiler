package ir.ac.kntu;

public interface ParseTree {
    ParseTree getParent();

    void setParent(ParseTree parent);

    String getText();

    Object getPayload();

    ParseTree getChild(int i);

    int getChildCount();

    String toStringTree();



}
