package name.huguogang.Algorithms;

import java.util.ArrayList;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BinaryTree {
    public static class TreeNode<T> {
        public T element;
        public TreeNode<T> left, right;
        
        public TreeNode(T element) {
            this.element = element;
        }
    }
    public static<T> boolean isBalanced(TreeNode<T> root) {
        //by definition, left and right children depth are within 1
        throw new NotImplementedException();
    }
    /**
     * Parse a string representation of tree in Newick tree format
     * 
     * @param input
     * @return Root of the tree
     */
    public static<T> TreeNode<T> parseNewick(String input) {
        throw new NotImplementedException();
    }
    
    
    /**
     * Print binary tree one level at a time, with space between elements,
     * new line between levels. Null nodes can be skipped.
     *  
     * @param root
     * @return
     */
    public static <T> String printByLevel(TreeNode<T> root) {
        if(root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<TreeNode<T>> currentLevel = new ArrayList<TreeNode<T>>();
        ArrayList<TreeNode<T>> nextLevel;
        currentLevel.add(root);
        while(!currentLevel.isEmpty()) {
            nextLevel = new ArrayList<TreeNode<T>>();
            for(TreeNode<T> node : currentLevel) {
                sb.append(node.element.toString());
                if(node.left != null) {
                    nextLevel.add(node.left);
                }
                if(node.right != null) {
                    nextLevel.add(node.right);
                }
            }
            if(!nextLevel.isEmpty()) {
                sb.append("\n");
            }
            currentLevel = nextLevel;
            nextLevel = null;
        }
        return sb.toString();
    }
}
