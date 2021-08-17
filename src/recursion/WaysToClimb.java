package recursion;

import recursion.tree.TreeNode;

import java.util.Stack;

/**
 * Find number of ways to climb
 * If n = 10 and possible steps = [2,4,6,8]
 * then output is 11.
 */
public class WaysToClimb {

    public static void main(String[] args) {
        int[] arr = {2,5,8,4};
        TreeNode tree = new TreeNode();
//        System.out.println(getNoOfWays(10, arr, new Stack()));
        getNoOfWays(20, arr, tree);
        printTree(tree,"");
    }

    public static void printStack(Stack stack) {
        stack.forEach(a -> {
            System.out.print(a + " -- ");
        });
        System.out.println();
    }

    /**
     * Callstack Visualization
     */
    public static int getNoOfWays(int n, int[] possibleSteps, Stack stack) {
        stack.push("getNoOfWay( "+ n + " "+ possibleSteps);
        printStack(stack);
        if(n == 0) {
            stack.pop();
            printStack(stack);
            return 1;
        }
        int noOfWays = 0;
        for(int step : possibleSteps){
            if(n - step >= 0) {
                noOfWays += getNoOfWays(n-step, possibleSteps,stack);
            }
        }
        stack.pop();
        printStack(stack);
        return noOfWays;
    }


    /**
     * Recursion Tree Visualization
     */
    public static int getNoOfWays(int n, int[] possibleSteps, TreeNode tree) {
        tree.setCall("getNoOfWay( "+ n + " "+ possibleSteps);
        if(n == 0) {
            tree.setReturned("1");
            return 1;
        }
        int noOfWays = 0;
        for(int step : possibleSteps){
            if(n - step >= 0) {
                TreeNode treeNode = new TreeNode();
                tree.append(treeNode);
                noOfWays += getNoOfWays(n-step, possibleSteps,treeNode);
            }
        }
        tree.setReturned(String.valueOf(noOfWays));
        return noOfWays;
    }

    /**
     * Recursion call tree
     */

    public static void printTree(TreeNode treeNode, String indent) {
        if(treeNode.getChildren().isEmpty() && treeNode != null) {
            System.out.print(treeNode.getCall() +" returned : " + treeNode.getReturned());
            System.out.println();
        }
        else {
            System.out.print(treeNode.getCall() +" returned : " + treeNode.getReturned());
            System.out.println();
            for(int i = 0 ; i < treeNode.getChildren().size() - 1; i++) {
                System.out.print(indent + "|" + "----");
                printTree(treeNode.getChild(i), indent + "|    ");
            }
            TreeNode lastNode = treeNode.getChildren().get(treeNode.getChildren().size()-1);
            System.out.print(indent + "L" + "----");
            printTree(lastNode, indent + "    ");
        }
    }
}
