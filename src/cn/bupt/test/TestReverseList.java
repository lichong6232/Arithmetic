package cn.bupt.test;

import cn.bupt.lineTable.ChainTable;

public class TestReverseList {
	
	public static void main(String[] args) {
		ChainTable chainTable=new ChainTable();
		chainTable.add(5);
		chainTable.add(4);
		chainTable.add(3);
		chainTable.add(2);
		chainTable.add(1);
		
		ChainTable chainTable1=new ChainTable();
		chainTable1.add(7);
		chainTable1.add(6);
		chainTable1.add(5);
		chainTable1.add(4);
		chainTable1.add(0);
		chainTable.Merge(chainTable1);
		chainTable.outPut();
	}

}
