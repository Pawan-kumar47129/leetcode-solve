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
    class Tuple{
        int depth;
        public TreeNode lca;
        Tuple(int h,TreeNode l){
            depth=h;
            lca=l;
        }
    }

    private Tuple solve(TreeNode root){
        if(root==null) return new Tuple(0,null);
        Tuple left=solve(root.left);
        Tuple right=solve(root.right);
        //both side same depth so root become lca
        if(left.depth==right.depth){
            left.depth+=1;
            left.lca=root;
            return  left;
        }else if(left.depth>right.depth){
            left.depth+=1;
            return left;
        }else {
            right.depth+=1;
            return right;
        }
    }
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        Tuple ans=solve(root);
        return ans.lca;
    }
}