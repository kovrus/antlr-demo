package calculator;

import calculator.antlr.GrammarBaseVisitor;
import calculator.antlr.GrammarParser;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.Locale;

public class Calculator extends GrammarBaseVisitor<Number> {

    @Override
    public Number visitDefaultEuler(GrammarParser.DefaultEulerContext ctx) {
        return Math.E;
    }

    @Override
    public Number visitDefaultOperation(GrammarParser.DefaultOperationContext ctx) {
        Number left = visit(ctx.left);
        Number right = visit(ctx.right);
        assert left != null && right != null;
        double l = left.doubleValue();
        double r = right.doubleValue();

        System.out.println(String.format(Locale.ROOT, "%s %s %s", l, ctx.op.getText(), r));

        switch (ctx.op.getText()) {
            case "+":
                return l + r;
            case "-":
                return l - r;
            case "*":
                return l * r;
            case "/":
                return l / r;
            default:
                return 0;
        }
    }

    @Override
    public Number visitDefault(GrammarParser.DefaultContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Number visitIntegerValue(GrammarParser.IntegerValueContext ctx) {
        return Integer.valueOf(ctx.getText());
    }

    @Override
    public Number visitDecimalValue(GrammarParser.DecimalValueContext ctx) {
        return Double.valueOf(ctx.getText());
    }

    @Override
    public Number visitSimpleEq(GrammarParser.SimpleEqContext ctx) {
        return visit(ctx.right);
    }

    public Number calculate(ParserRuleContext ctx) {
        return this.visit(ctx);
    }
}
