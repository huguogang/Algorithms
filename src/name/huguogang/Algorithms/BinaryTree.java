package name.huguogang.Algorithms;

import java.util.ArrayList;
import java.util.List;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class BinaryTree {
    public static class TreeNode<T> {
        public T element;
        public TreeNode<T> left, right;
        
        public TreeNode(T element) {
            this.element = element;
        }
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
    
    public static<T> List<T> preorderTraverse(TreeNode<T> root) {
        throw new NotImplementedException();    
    }
    
    public static<T> List<T> postorderTraverse(TreeNode<T> root) {
        throw new NotImplementedException();    
    }
    
    public static<T> List<T> inorderTraverse(TreeNode<T> root) {
        throw new NotImplementedException();    
    }
    
    public static<T> boolean isSameTree(TreeNode<T> t1, TreeNode<T> t2) {
        throw new NotImplementedException();    
    }
    
    /**
     * Given preorder and inorder traversal of a tree, construct the binary tree.
     * Note: You may assume that duplicates do not exist in the tree.
     * 
     * @param preorder
     * @param inorder
     * @return
     */
    public static<T> TreeNode<T> buildTreeFromPreIn(List<T> preorder, List<T> inorder) {
        return buildTreeFromPreInHelper(preorder, inorder, 0, 0, inorder.size());
    }
    
    private static<T> TreeNode<T> buildTreeFromPreInHelper(List<T> preorder, List<T> inorder,
            int preorderHead, int inorderHead, int subTreeSize) {
        if(subTreeSize <= 0) {
            return null;
        }
        T rootVal = preorder.get(preorderHead);
        TreeNode<T> root = new TreeNode<T>(rootVal);
        for(int i = 0; i < subTreeSize; i++) {
            if(inorder.get(i + inorderHead).equals(rootVal)) {
                root.left = buildTreeFromPreInHelper(preorder, inorder, preorderHead + 1, 
                        inorderHead, i);
                root.right = buildTreeFromPreInHelper(preorder, inorder, 
                        preorderHead + 1 + i, inorderHead + i + 1, subTreeSize - i - 1);
            }
        }
        return root;
    }
    
    /**
     * Given postorder and inorder traversal of a tree, construct the binary tree.
     * Note: You may assume that duplicates do not exist in the tree.
     * 
     * @param postorder
     * @param inorder
     * @return
     */
    public static<T> TreeNode<T> buildTreeFromPostIn(List<T> postorder, List<T> inorder) {
        return buildTreeFromPostInHelper(postorder, inorder, 0, 0, inorder.size());
    }
    
    private static<T> TreeNode<T> buildTreeFromPostInHelper(List<T> postorder, List<T> inorder,
            int postorderHead, int inorderHead, int subTreeSize) {
        if(subTreeSize <= 0) {
            return null;
        }
        T rootVal = postorder.get(postorderHead + subTreeSize - 1);
        TreeNode<T> root = new TreeNode<T>(rootVal);
        for(int i = 0; i < subTreeSize; i++) {
            if(inorder.get(i + inorderHead).equals(rootVal)) {
                root.left = buildTreeFromPostInHelper(postorder, inorder, postorderHead, 
                        inorderHead, i);
                root.right = buildTreeFromPostInHelper(postorder, inorder, 
                        postorderHead + i, inorderHead + i + 1, subTreeSize - i - 1);
            }
        }
        return root;
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
    
    /**
     * data structure for flatten tree
     * 
     * @author ghu
     *
     */
    private static class Pair<T> {
       TreeNode<T> head;
       TreeNode<T> tail;
       
       public Pair (TreeNode<T> head, TreeNode<T> tail) {
           this.head = head;
           this.tail = tail;
       }
    }
    
    /**
     * Given a binary tree, flatten it to a linked list in-place.
     * For example, Given
     *     1
     *    / \
     *    2 5
     *   / \ \
     *   3 4 6
     * The flattened tree should look like:
     * 1
     *  \
     *  2
     *   \
     *   3
     *    \
     *    4
     *     \
     *     5
     *      \
     *      6
     * 
     * @param root
     * @return
     */
    public static<T> TreeNode<T> flattenTree(TreeNode<T> root) {
        //in place
        Pair<T> p = flattenTreeR(root);
        return p.head;
    }
    /**
     * Flatten a tree, return head and tail of the linked list
     * 
     * @param root
     * @return
     */
    private static<T> Pair<T> flattenTreeR(TreeNode<T> root) {
        if(root == null || (root.left == null && root.right == null)) {
            return new Pair<T>(root, root);
        }
        //post order
        Pair<T> left = flattenTreeR(root.left);
        Pair<T> right = flattenTreeR(root.right);
        TreeNode<T> tail = (right.tail == null) ? left.tail : right.tail;
        
        if(left.head != null) {
            root.right = left.head;
            left.tail.right = right.head;
        }
        
        return new Pair<T>(root, tail);
    }
}
