/*############################################################################
	You are given an array(preor) representing preorder traversal of a special 
	binary tree where each node of this binary tree has either 0 or 2 children. 
	One more array(preorLN) is given to you to represent if the current node is 
	the leaf node or not with values "L" or "N" respectively. You have to write 
	a function to construct this special tree and return the root of this tree.
	Note: No need to print the tree. The printing of this special tree is already handled.
			completed true
			
#############################################################################*/

import java.util.Stack;
class BinaryTreeNode<T> {
	T data;
	BinaryTreeNode<T> left;
	BinaryTreeNode<T> right;

	public BinaryTreeNode(T data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
}

public class constructSpecialTree{
	
    public static BinaryTreeNode<Integer> specialtree(int[] preor, char[] preorLN, int n) {
    	if(n==0) return null;
    	Stack<BinaryTreeNode<Integer>> st = new Stack<>();
    	BinaryTreeNode<Integer> root = new BinaryTreeNode<>(preor[0]), current;
    	if(preorLN[0]=='N') st.add(root);
    	for(int i=1;i<n;i++){
    		current = new BinaryTreeNode<>(preor[i]);
    		if(preorLN[i]=='L'){
    			if(!st.isEmpty()){
    				if(st.peek().left ==null) st.peek().left = current;
    				else{
    					st.peek().right = current;
    					st.pop();
    				}
    			}
    		}else{
    			if(!st.isEmpty()){
    				if(st.peek().left ==null) st.peek().left = current;
    				else{
    					st.peek().right = current;
    					st.pop();
    				}
    			}
				st.add(current);
    		}
    	}
    	return root;
    }

	public static void main(String[] args) {
		//creting tree by level wise input
		/* following is te tree which will be printed by deferent ways

				      1
				   2  	 3
				 4   5	   7

		*/
		int[] arr = {1,2,4,5,3,7};
		char[] arr2 = {'N','N','L','L','N','L'};

		BinaryTree tree = new BinaryTree();
		tree.root = specialtree(arr, arr2, 6);
		tree.printDetail();
		// postOrder(tree.root);
	}
	
}
