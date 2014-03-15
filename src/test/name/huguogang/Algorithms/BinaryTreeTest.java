/**
 * 
 */
package test.name.huguogang.Algorithms;

import static org.junit.Assert.*;
import name.huguogang.Algorithms.BinaryTree.TreeNode;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static name.huguogang.Algorithms.BinaryTree.*;

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
}
