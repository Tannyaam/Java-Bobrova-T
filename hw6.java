import java.util.ArrayList;

public class hw6 {
    public static void main(String[] args) {

        Tree t1 = new Tree('F');
        Tree t2 = new Tree('B');
        Tree t3 = new Tree('G');
        Tree t4 = new Tree('A');
        Tree t5 = new Tree('D');
        Tree t6 = new Tree('I');
        Tree t7 = new Tree('C');
        Tree t8 = new Tree('E');
        Tree t9 = new Tree('H');
    
        /*t1.add(t2);
        t1.add(t3);
        t2.add(t4);
        t3.add(t5);
        t4.add(t6);
        t4.add(t7);
        t5.add(t8);
        t8.add(t9);
        t8.add(t10);
        */

        t1.left = t2;
        t1.right = t3;

        t2.left = t4;
        t2.right = t5;

        t5.left = t7;
        t5.right = t8;

        t3.right = t6;

        t6.left = t9;

        printPreOrder(t1);
        System.out.println();
        printInOrder(t1);
        System.out.println();
        printPostOrder(t1);
        System.out.println();
        printReversePostOrder(t1);
        System.out.println();
        printReversePreOrder(t1);
        System.out.println();
        printReverseInOrder(t1);
    }

    static void printPreOrder(Tree tree){
        if (tree != null){
            System.out.print(tree.value + " ");
            printPreOrder(tree.left);
            printPreOrder(tree.right);
            }
            /*for (Tree t : tree.trees){
                printPreOrder(t);
            }*/
        }

    static void printInOrder(Tree tree){
        if (tree != null){
            printInOrder(tree.left);
            System.out.print(tree.value + " ");
            printInOrder(tree.right);
        }
    }

    static void printPostOrder(Tree tree){
        if (tree != null){
            printPostOrder(tree.left);
            printPostOrder(tree.right);
            System.out.print(tree.value + " ");
        }
    }

    static void printReversePostOrder(Tree tree){
        if (tree != null){
            printReversePostOrder(tree.right);
            printReversePostOrder(tree.left);
            System.out.print(tree.value + " ");
        }
    }

    static void printReversePreOrder(Tree tree){
        if (tree != null){
            System.out.print(tree.value + " ");
            printReversePreOrder(tree.right);
            printReversePreOrder(tree.left);
        }
    }

    static void printReverseInOrder(Tree tree){
        if (tree != null){
            printReverseInOrder(tree.right);
            System.out.print(tree.value + " ");
            printReverseInOrder(tree.left);
        }
    }
}

class Tree{
    char value;
    Tree left;
    Tree right;
    public Tree(char value){
        this.value = value;
    }
    /* ArrayList<Tree> trees = new ArrayList<>();

    public void add(Tree tree){
        trees.add(tree);
    */
    }