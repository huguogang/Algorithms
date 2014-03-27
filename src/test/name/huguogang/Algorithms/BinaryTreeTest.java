/**
 * 
 */
package test.name.huguogang.Algorithms;

import static name.huguogang.Algorithms.BinaryTree.*;
import static name.huguogang.Algorithms.CollectionUtil.*;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import name.huguogang.Algorithms.BinaryTree.TreeNode;

import org.junit.Test;

/**
 * @author ghu
 *
 */
public class BinaryTreeTest {

    @Test
    public void printByLevelTest() {
        //build tree
        //          1
        //         2  3
        //       4   5  6
        //         7
        TreeNode<Integer> node = new TreeNode<Integer>(1);
        TreeNode<Integer> root = node;
        node.left = new TreeNode<Integer>(2);
        node.right = new TreeNode<Integer>(3);
        node = node.left;
        node.left = new TreeNode<Integer>(4);
        node = node.left;
        node.right = new TreeNode<Integer>(7);
        node = root.right;
        node.left = new TreeNode<Integer>(5);
        node.right = new TreeNode<Integer>(6);
        String actual = printByLevel(root);
        String expected = "1\n23\n456\n7";
        assertEquals(expected, actual);
    }
    
    @Test
    public void buildTreeFromPreInTest() {
        ArrayList<Integer> preorder;
        ArrayList<Integer> inorder;
        TreeNode<Integer> root;
        
        preorder = new ArrayList<Integer>();
        inorder = new ArrayList<Integer>();
        
        preorder.clear();
        addAll(preorder, 1, 2, 3);        
        inorder.clear();
        addAll(inorder, 2, 1, 3);
        root = buildTreeFromPreIn(preorder, inorder);
        System.out.println(printByLevel(root));
        
        preorder.clear();
        addAll(preorder, 1, 2, 4, 5, 3, 6, 7, 8);        
        inorder.clear();
        addAll(inorder, 4, 5, 2, 1, 7, 6, 8, 3);
        root = buildTreeFromPreIn(preorder, inorder);
        System.out.println(printByLevel(root));
    }
    
    @Test
    public void buildTreeFromPostInTest() {
        ArrayList<Integer> postorder;
        ArrayList<Integer> inorder;
        TreeNode<Integer> root;
        
        postorder = new ArrayList<Integer>();
        inorder = new ArrayList<Integer>();
        
        postorder.clear();
        addAll(postorder, 2, 3, 1);        
        inorder.clear();
        addAll(inorder, 2, 1, 3);
        root = buildTreeFromPostIn(postorder, inorder);
        System.out.println(printByLevel(root));
        
        postorder.clear();
        addAll(postorder, 5, 4, 2, 7, 8, 6, 3, 1);        
        inorder.clear();
        addAll(inorder, 4, 5, 2, 1, 7, 6, 8, 3);
        root = buildTreeFromPostIn(postorder, inorder);
        System.out.println(printByLevel(root));
    }
    
    @Test
    public void flattenTreeTest() {
        //build tree
        //          1
        //         2  3
        //       4   5  6
        //         7
        TreeNode<Integer> node = new TreeNode<Integer>(1);
        TreeNode<Integer> root = node;
        node.left = new TreeNode<Integer>(2);
        node.right = new TreeNode<Integer>(3);
        node = node.left;
        node.left = new TreeNode<Integer>(4);
        node = node.left;
        node.right = new TreeNode<Integer>(7);
        node = root.right;
        node.left = new TreeNode<Integer>(5);
        node.right = new TreeNode<Integer>(6);
        
        root = flattenTree(root);
        dumpLinkedListTree(root);
    }
    
    private<T> void dumpLinkedListTree(TreeNode<T> root) {
        while(root != null) {
            System.out.println(root.element);
            root = root.right;
        }
    }
}
