package cn.bupt.tree;

public class Test {

	public static void main(String[] args) {
		Tree tree=new Tree();
		tree.insert(50);
		tree.insert(40);
		tree.insert(30);
		tree.insert(25);
		tree.insert(35);
		tree.insert(45);
		tree.insert(75);
		tree.insert(65);
		tree.insert(62);
		tree.insert(64);
		tree.insert(70);
		tree.insert(87);
		tree.insert(80);
		tree.insert(93);
//		tree.delete(62);
//		tree.preOrder();
//		tree.preOrderNoRecursion();
//		tree.inOrderNoRecursion();
		tree.lastOrderNoRecursion();
	}

}
