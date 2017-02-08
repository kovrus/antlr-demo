package calculator;

import calculator.antlr.GrammarLexer;
import calculator.antlr.GrammarParser;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

    private static final Calculator CALC = new Calculator();

    public static void main(String [] args) {
        try {
            GrammarLexer lexer = new GrammarLexer(new ANTLRInputStream(args[0]));
            CommonTokenStream tokenStream = new CommonTokenStream(lexer);
            GrammarParser parser = new GrammarParser(tokenStream);
            System.out.println(CALC.calculate(parser.simpleEq()));
        } catch (StackOverflowError e) {
            System.out.println("Too large (stack overflow while parsing)");
        }
    }

}
