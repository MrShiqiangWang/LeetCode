package increasingbst;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IncreasingBST {
	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode increasingBST(TreeNode root) {
      TreeNode node=root;
      Stack<TreeNode>stack=new Stack<>();
      List<Integer>valus=new ArrayList<>();
      while(!stack.isEmpty()||node!=null) {
    	  if(node!=null) {
    		  stack.push(node);
    		  valus.add(node.val);
    		  node=node.left;
    	  }else {
    		  TreeNode node2=stack.pop();
    		  node=node2.right;
    	  }
      }
      if(valus.size()==0) {
    	  return null;
      }
      TreeNode newRoot=new TreeNode(valus.get(0));
      TreeNode myNode=newRoot;
      for(int i=1;i<valus.size();i++) {
    	  TreeNode sn=new TreeNode(valus.get(i));
    	  myNode.right=sn;
    	  myNode=sn;
      }
      return newRoot;
    }
}
