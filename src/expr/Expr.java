package expr;

import net.gnim.math.MathExpr;
import net.gnim.math.MathExpr.ExprException;

/**
 *
 * @author ming
 */
public class Expr {

    public static void main(String[] args) throws ExprException {
        //contant expression compute
        String expr1 = "12+4*25";
        echo(expr1 + "=" + MathExpr.compute(expr1));
        //variable expression compute
        MathExpr expr2 = new MathExpr("sin(pi/2)+4*x");
        expr2.setVar("x", 25.0);
        echo(expr2.getExprStr() + "=" + expr2.compute());
        //user function expression compute
        MathExpr expr3 = new MathExpr("sum(4,3,2,1)+4*x");
        expr3.setVar("x", 25.0);
        expr3.setFunc("sum", new MathExpr.Func() {

            @Override
            public double compute(double[] params) {
                double sum = 0;
                for (int i = 0; i < params.length; i++) {
                    sum += params[i];
                }
                return sum;
            }
        });
        echo(expr3.getExprStr() + "=" + expr3.compute());
    }

    public static String echo(String str) {
        System.out.println(str);
        return str;
    }
}
