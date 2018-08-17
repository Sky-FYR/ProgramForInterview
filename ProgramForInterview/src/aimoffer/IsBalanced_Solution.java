package aimoffer;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 */
public class IsBalanced_Solution {

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
//        t3.left = t6;
//        t3.right = t7;
        t4.left = t8;

        System.out.println(new IsBalanced_Solution().IsBalanced_Solution(t1));
    }
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        boolean flag = (Math.abs(left-right)<=1);

        return flag && IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //递归
        int leftCount = TreeDepth(root.left);
        int rightCount = TreeDepth(root.right);

        return 1+(leftCount>rightCount?leftCount:rightCount);
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
