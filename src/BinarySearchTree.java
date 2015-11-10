
import java.util.Random;

public class BinarySearchTree{
    BinaryTreeRootNode tree;
    int numItems;

    public static void main(String[] args) {
   BinarySearchTree bst = new BinarySearchTree();
   Random rand = new Random();
   for (int i = 0; i < 20;i++){
       bst.insert(rand.nextInt(100) + 1);
   }
        System.out.println("The total number of leaves are: " + bst.getLeafCount());
        System.out.println("The total of all values in the tree are: " + bst.TotalCount());
        System.out.println("The root of this tree is: " + bst.getRoot());
        System.out.println("The lowest value in the tree is: " + bst.getLowest());
        System.out.println("The number of items in this tree are: " + bst.getNumItems());
        System.out.println("The height of this tree is: " + bst.getHeight());
}
    
public void insert(int value){
    if (tree == null){
        tree = new BinaryTreeRootNode(value);
        numItems++;
    }
    else {
        BinaryTreeRootNode temp = new BinaryTreeRootNode(value);
        InsertIntoTree(tree,temp);
    }
    
}

public int getRoot(){
    return tree.value;
}
public int getNumItems(){
    return this.numItems;
}
public int getHeight(){
    return this.getHeight(this.tree);
}
public int getLeafCount(){
    return numberOfLeaves(tree);
}
public int getLowest(){
    return ReturnMin(tree);
}
public int TotalCount(){
    return SumOfItems(tree);
}
private int ReturnMin(BinaryTreeRootNode node){
    if (node.left == null) return node.value;
    else return ReturnMin(node.left);
}
private int numberOfLeaves(BinaryTreeRootNode node){
    if (node.left == null && node.right == null) return 1;
    else if (node.left == null) return numberOfLeaves(node.right);
    else if (node.right == null) return numberOfLeaves(node.left);
    else return numberOfLeaves(node.left) + numberOfLeaves(node.right);
}

private int SumOfItems(BinaryTreeRootNode node){
    if (node.left == null && node.right == null) return node.value;
    else if (node.left == null) return SumOfItems(node.right) + node.value;
    else if (node.right == null) return SumOfItems(node.left) + node.value;
    else return SumOfItems(node.left) + SumOfItems(node.right) + node.value;
}
private int getHeight(BinaryTreeRootNode node){
    if (node.left == null && node.right == null) return 1;
    else if (node.left == null) return 1 + getHeight(node.right);
    else if (node.right == null) return 1 + getHeight(node.left);
    else {
        int r = 1 + getHeight(node.right);
        int l = 1 + getHeight(node.left);
        if (r > l) return r;
        else return l;
    }
}
private boolean InsertIntoTree(BinaryTreeRootNode node, BinaryTreeRootNode added){
    if (added.value < node.value && node.left == null){
        node.left = added;
        numItems++;
        return true;
    }
    else if (added.value > node.value && node.right == null){
        node.right = added;
        numItems++;
        return true;
    }
    else if (added.value < node.value){
        InsertIntoTree(node.left, added);
    }
    else if (added.value > node.value){
        InsertIntoTree(node.right, added);
    }
    return false;
}

    private class BinaryTreeRootNode {
        int value;
        private BinaryTreeRootNode left, right;
        
        public BinaryTreeRootNode(){
            left = null;
            right = null;
        }
        public BinaryTreeRootNode(int v) {
            this.value = v;
            left = null;
            right = null;
        }
    }
}