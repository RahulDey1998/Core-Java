package tree.generic;

public class DiameterCalc {


    static int maxDiameter = 0;

    public static void main(String[] args) {

        Integer[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1,
                90, -1, -1, 40, 100, -1, -1, -1};
        GenericTree<Integer> tree = new GenericTree<>(array);

        calcDiameterByGettingMaxHeight(tree.root);

        System.out.println(maxDiameter);


    }

    public static <T> int calcDiameterByGettingMaxHeight(Node<Integer> root) {
        int maxHeight = -1;
        int secondMaxHeight = -1;


        for (Node<Integer> node : root.childs) {
            int height = calcDiameterByGettingMaxHeight(node);

            if (height > maxHeight) {
                maxHeight = height;
                secondMaxHeight = maxHeight;
            } else if (height > secondMaxHeight) {
                secondMaxHeight = height;
            }
        }

        int distanceBetweenTwo = maxHeight + secondMaxHeight + 2;
        if (distanceBetweenTwo > maxDiameter) {
            maxDiameter = distanceBetweenTwo;
        }

        maxHeight += 1;
        return maxHeight;
    }

}
