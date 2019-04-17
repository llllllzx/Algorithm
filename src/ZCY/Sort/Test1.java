package ZCY.Sort;

import java.util.ArrayList;

/**
 * Created by zhaoxinliu on 2019/4/10
 */
public class Test1 {
    public static void main(String[] args) {
    }
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if(root != null){
            helper(root,target,result,list);
        }
        return result;
    }
    public void helper(TreeNode root,int target,ArrayList<ArrayList<Integer>> result,ArrayList<Integer> list){
        list.add(root.val);
        if(root.left != null && root.right != null){
            if(target == root.val){
                result.add(new ArrayList<>(list));
            }
        }
        if(root.left != null){
            helper(root.left,target - root.val,result,list);
        }
        if(root.right != null){
            helper(root.right,target - root.val,result,list);
        }
        list.remove(list.size() - 1);
    }
}

class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
