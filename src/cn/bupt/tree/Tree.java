package cn.bupt.tree;

import java.util.Stack;

public class Tree {

	private TreeNode root;
	
	public TreeNode getRoot() {
		return root;
	}

	public void setRoot(TreeNode root) {
		this.root = root;
	}

	public void insert(int data){
		
		TreeNode newNode=new TreeNode();
		newNode.setData(data);
		
		boolean isLeftChild=false;
		if(root==null){
			root=newNode;
		}else{
			TreeNode current=root;
			TreeNode parent=current;
			while(current!=null){
				parent=current;
				if(data<current.getData()){
					isLeftChild=true;
					current=current.getLeftChild();
				}else{
					isLeftChild=false;
					current=current.getRightChild();
				}
			}
			if(isLeftChild){
				parent.setLeftChild(newNode);
			}else{
				parent.setRightChild(newNode);
			}
		}
		
	}
	
	public TreeNode getNode(int data){
		TreeNode node=root;
		while(node!=null&&node.getData()!=data){
			if(data<node.getData()){
				node=node.getLeftChild();
			}else{
				node=node.getRightChild();
			}
		}
		return node;
		
		
	}
	
	public TreeNode getMin(){
		if(root==null){
			try {
				throw new Exception("树为空");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}else{
			TreeNode current=root;
			TreeNode parent=current;
			while(current!=null){
				parent=current;
				current=current.getLeftChild();
			}
			return parent;
		}
		
	}
	public TreeNode getMax(){
		if(root==null){
			try {
				throw new Exception("树为空");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}else{
			TreeNode current=root;
			TreeNode parent=current;
			while(current!=null){
				parent=current;
				current=current.getRightChild();
			}
			return parent;
		}
		
	}
	
	public void delete(int data){
		TreeNode current=root;
		TreeNode parent=null;
		boolean isLeftChild=false;
		while(current!=null&&data!=current.getData()){
			parent=current;
			if(data<current.getData()){
				isLeftChild=true;
				current=current.getLeftChild();
			}else{
				isLeftChild=false;
				current=current.getRightChild();
			}
		}
		if(current==null){
			System.out.println("树中不存在该节点");
		}else{
			if(current.getLeftChild()==null&&current.getRightChild()==null){
				if(current==root){
					root=null;
				}else if(isLeftChild){
					parent.setLeftChild(null);
				}else{
					parent.setRightChild(null);
				}
			}else if(current.getLeftChild()!=null&&current.getRightChild()!=null){
				TreeNode successor=current.getRightChild();
				TreeNode successorParent=current;
				while(successor.getLeftChild()!=null){
					successorParent=successor;
					successor=successor.getLeftChild();
				}
				if(successor==current.getRightChild()){
					successor.setLeftChild(current.getLeftChild());
					if(current==root){
						root=successor;
					}else{
						if(isLeftChild){
							parent.setLeftChild(successor);
						}else{
							parent.setRightChild(successor);
						}
					}
				}else{
					successorParent.setLeftChild(successor.getRightChild());
					successor.setRightChild(current.getRightChild());
					successor.setLeftChild(current.getLeftChild());
					if(current==root){
						root=successor;
					}else{
						if(isLeftChild){
							parent.setLeftChild(successor);
						}else{
							parent.setRightChild(successor);
						}
					}
				}
				
			}else if(current.getLeftChild()!=null){
				if(current==root){
					root=current.getLeftChild();
				}else{
					if(isLeftChild){
						parent.setLeftChild(current.getLeftChild());
					}else{
						parent.setRightChild(current.getLeftChild());
		
					}
				}
				
			}else{
				if(current==root){
					root=current.getRightChild();
				}else{
					if(isLeftChild){
						parent.setLeftChild(current.getRightChild());
					}else{
						parent.setRightChild(current.getRightChild());
					}
				}
				
			}
		}
		
	}
	
	
	public void preOrder(){
		preOrder(root);
	}
	private void preOrder(TreeNode node){
		if(node!=null){
			System.out.println(node.getData());
			preOrder(node.getLeftChild());
			preOrder(node.getRightChild());
		}
		
	}
	public void inOrder(){
		inOrder(root);
	}
	private void inOrder(TreeNode node){
		if(node!=null){
			inOrder(node.getLeftChild());
			System.out.println(node.getData());
			inOrder(node.getRightChild());
		}
	}
	
	
	public void lastOrder(){
		lastOrder(root);
	}
	
	public void inOrderNoRecursion(){
		TreeNode curr=root;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		while(curr!=null || !stack.isEmpty()){
			stack.add(curr);
			curr=curr.getLeftChild();
			while(curr==null&&!stack.isEmpty()){
				TreeNode temp=stack.pop();
				System.out.println(temp.getData());
				curr=temp.getRightChild();
			}
		}
	}
	
	public void lastOrderNoRecursion(){
		TreeNode pre=null;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		stack.add(root);
		while(!stack.isEmpty()){
			TreeNode temp=stack.peek();
			if((temp.getLeftChild()==null&&temp.getRightChild()==null)
					||pre!=null&&(temp.getLeftChild()==pre||temp.getRightChild()==pre)){
				TreeNode node=stack.pop();
				System.out.println(node.getData());
				pre=node;
			}else{
				if(temp.getRightChild()!=null){
					stack.add(temp.getRightChild());
				}
				if(temp.getLeftChild()!=null){
					stack.add(temp.getLeftChild());
				}
			}
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void preOrderNoRecursion(){
		TreeNode curr=root;
		Stack<TreeNode> stack=new Stack<TreeNode>();
		while(curr!=null || !stack.isEmpty()){
			System.out.println(curr.getData());
			stack.push(curr);
			curr=curr.getLeftChild();
			while(curr==null&&!stack.isEmpty()){
				TreeNode temp=stack.pop();
				curr=temp.getRightChild();
			}
		}
	}
	
	
	private void lastOrder(TreeNode node){
		if(node!=null){
			lastOrder(node.getLeftChild());
			lastOrder(node.getRightChild());
			System.out.println(node.getData());
		}
	}

}
