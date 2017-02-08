import grammar.GrammarBaseVisitor;
import grammar.GrammarLexer;
import grammar.GrammarParser;

public class GrammarVisitorImpl extends GrammarBaseVisitor<Integer> {

    @Override
    public Integer visitExpression(GrammarParser.ExpressionContext ctx) {
        Number left = visit(ctx.left);
        Number right = visit(ctx.right);
        switch (ctx.operator.getTokenIndex()) {
            case GrammarLexer.MINUS:
                return left.intValue() - right.intValue();
            case GrammarLexer.PLUS:
                return left.intValue() + right.intValue();
            default:
                throw new UnsupportedOperationException("Not supported: " + ctx.operator);
        }
    }
}
