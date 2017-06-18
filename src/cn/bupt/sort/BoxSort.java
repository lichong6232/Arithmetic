package cn.bupt.sort;

import cn.bupt.lineTable.ChainTable;

public class BoxSort {
	
	public static ChainTable binSort(ChainTable chain,int range){
		ChainTable box[]=new ChainTable[range+1];
		ChainTable result=new ChainTable();
		for(int i=0;i<=range;i++){
			box[i]=new ChainTable();
		}
		for(int i=0;i<chain.size();i++){
			int value=(int) chain.get(i);
			box[value].add(value);
		}
		for(int i=range;i>=0;i--){
			for(int j=0;j<box[i].size();j++){
				result.add(box[i].get(j));
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		ChainTable chain=new ChainTable();
		chain.add(5);
		chain.add(1);
		chain.add(8);
		chain.add(3);
		chain.add(9);
		chain.add(2);
		chain.add(1);
		chain.add(5);
		ChainTable sortResult=binSort(chain, 9);
		
		/*System.out.println(chain.size());
		System.out.println(sortResult.size());*/
		sortResult.outPut();
		
	}

}
