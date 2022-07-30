package stack.problem.dijkstra;

import java.util.Stack;

/**
 * @author rahul_dey
 */
public class DijkstraAlgorithm {

    private Stack<String> operationStack;
    private Stack<Double> valueStack;

    public DijkstraAlgorithm() {
        this.operationStack = new Stack<>();
        this.valueStack = new Stack<>();
    }


    public void interpretExpression(String expression) {

        String[] characters = expression.trim().split(" ");

        for (String character : characters) {
            if ("(".equals(character)) {
                //do nothing
            } else if ("+".equals(character)) {
                operationStack.push(character);
            } else if ("*".equals(character)) {
                operationStack.push(character);
            } else if (")".equals(character)) {
                String operation = operationStack.pop();

                if ("+".equals(operation)) {
                    valueStack.push(valueStack.pop() + valueStack.pop());
                }
                if ("*".equals(operation)) {
                    valueStack.push(valueStack.pop() * valueStack.pop());
                }
            } else {
                valueStack.push(Double.valueOf(character));
            }
        }

        System.out.println(valueStack.pop());

    }
}
