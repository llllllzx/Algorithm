package Offer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhaoxinliu on 2019/3/31
 */
public class _04ReConstructBinaryTree {
    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        TreeNode root = new _04ReConstructBinaryTree().reConstructBinaryTree(pre, in);
        System.out.println(root);
    }
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre == null || in == null){
            return null;
        }
        //创建一个map，用来记录中序遍历数组各个数字对应的数组下标。
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i< in.length;i++){
            map.put(in[i],i);
        }

        TreeNode root = constructBinaryTree(pre,0,pre.length-1,in,0,in.length -1,map);
        return root;
    }

    public TreeNode constructBinaryTree(int[] pre,int preStart,int preEnd,int[] in,int inStart,int inEnd,Map<Integer,Integer> map){
        if(preStart > preEnd){
            return null;
        }
        TreeNode node = new TreeNode(pre[preStart]);
        int index = map.get(pre[preStart]);
        //将
        node.left = constructBinaryTree(pre,preStart + 1,preStart + index - inStart,in,inStart,index -1,map);
        node.right = constructBinaryTree(pre,preStart + index - inStart + 1,preEnd,in,index + 1 ,inEnd,map);
        return node;
    }
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
