class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root.left,root.right);
    }

    boolean isMirror(TreeNode left,TreeNode right) {
        if(left==null && right==null) {
            return true;
        } else if(left==null || right ==null) return false;

        if(left.val == right.val) {
            return isMirror(left.right,right.left) && isMirror(left.left,right.right);
        }
        return false;
    }
}
