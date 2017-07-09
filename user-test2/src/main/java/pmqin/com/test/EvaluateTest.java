package pmqin.com.test;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

public class EvaluateTest {

	public static void main(String[] args) throws NumberFormatException, EvaluationException {
		// TODO Auto-generated method stub
		 test();
	}

	public static void test() throws NumberFormatException, EvaluationException {
		Evaluator evaluator = new Evaluator();
		evaluator.putVariable("T1", "12");
		evaluator.putVariable("T2", "12");
		evaluator.putVariable("T3", "20");
		String ruleExpression1 = "#{T1}>10";
		String ruleExpression2 = "#{T2}>20";
		String ruleExpression3 = "#{T3}>30";
		String ruleExpression4 = "#{T1}*0.5==#{T2}*0.5"; //注意不能只有一个=
		Double evalResult1 = Double.parseDouble(evaluator.evaluate(ruleExpression1));
		Double evalResult2 = Double.parseDouble(evaluator.evaluate(ruleExpression2));
		Double evalResult3 = Double.parseDouble(evaluator.evaluate(ruleExpression3));
		Double evalResult4 = Double.parseDouble(evaluator.evaluate(ruleExpression4));
		System.out.println(evaluator.evaluate("4 + 1"));
		 System.out.println(evaluator.evaluate("1/3"));
		System.out.println("ruleExpression1=" + evaluator.replaceVariables(ruleExpression1) + ",evalResult=" + (evalResult1>=1));
		System.out.println("ruleExpression2=" + evaluator.replaceVariables(ruleExpression2) + ",evalResult=" + evalResult2);
		System.out.println("ruleExpression3=" + evaluator.replaceVariables(ruleExpression3) + ",evalResult=" + evalResult3);
		System.out.println("ruleExpression4=" + evaluator.replaceVariables(ruleExpression4) + ",evalResult=" + evalResult4);

	}

}
