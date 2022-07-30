package stack.problem.dijkstra;

/**
 * @author rahul_dey
 */
public class App {

    public static void main(String[] args) {
        DijkstraAlgorithm dijkstraAlgorithm = new DijkstraAlgorithm();

        String expression = " ( ( 1 + 2 ) * ( 4 + 9 ) )";
        dijkstraAlgorithm.interpretExpression(expression);
    }

}
