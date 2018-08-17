package aimoffer;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 */
public class TreeDepth {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);

        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;
        t4.left = t8;

        System.out.println(TreeDepth(t1));
    }
    public static int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //递归
//        int leftCount = TreeDepth(root.left);
//        int rightCount = TreeDepth(root.right);
//
//        return 1+(leftCount>rightCount?leftCount:rightCount);

        //非递归
        int level = 0;
        TreeNode curr;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            level++;
            int count = queue.size();
            while (count > 0) {
                curr = queue.poll();
                if (curr.left != null){
                    queue.add(curr.left);
                }
                if (curr.right != null) {
                    queue.add(curr.right);
                }
                count--;
            }
        }
        return level;
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
