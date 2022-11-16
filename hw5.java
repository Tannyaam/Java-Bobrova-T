public class hw5 {
    public static void main(String[] args) {
        Tree myTree = 
                    new Tree(15, 
                                new Tree(14, new Tree(1), new Tree(2, new Tree(3), null)),
                                new Tree(4, new Tree(5), new Tree(11, new Tree (6), new Tree (7))));
        System.out.print(myTree.sum());
    }

    static class Tree {
        int value;
        Tree left;
        Tree right;

        public Tree(int value, Tree left, Tree right){
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Tree(int value){
            this.value = value;
        }

        public int sum(){
            int sum = value;

            if (right != null){
                sum += right.sum();
            }

            if (left != null){
                sum += left.sum();
            }

            return sum;
        }
    }
}
