/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int[]solve(TreeNode root,int[]ans){
        if(root==null){
            return new int[]{Integer.MIN_VALUE,0};
        }
        int[]left=solve(root.left,ans);
        int[]right=solve(root.right,ans);
        if(root.val==left[0] && root.val==right[0]){
            ans[0]=Math.max(ans[0],left[1]+right[1]+1);
            return new int[]{root.val,Math.max(left[1],right[1])+1};
        }else if(root.val==left[0]){
            ans[0]=Math.max(ans[0],left[1]+1);
            return new int[]{root.val,left[1]+1};
        }else if(root.val==right[0]){
            ans[0]=Math.max(ans[0],right[1]+1);
            right[1]++;
            return right;
        }else{
            return new int[]{root.val,1};
        }
    }
    public int longestUnivaluePath(TreeNode root) {
        int []ans={0};
        solve(root,ans);
        return ans[0]==0?0:ans[0]-1;
    }
}