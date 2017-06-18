package cn.bupt.sort;

import cn.bupt.lineTable.ChainTable;

public class BaseSort {
	
	public static ChainTable sort(ChainTable chain,int digitN,int currentDigit,int base){
		if(currentDigit>digitN){
			return chain;
		}else{
			ChainTable box[]=new ChainTable[base];
			ChainTable result=new ChainTable();
			for(int i=0;i<base;i++){
				box[i]=new ChainTable();
			}
			for(int i=0;i<chain.size();i++){
				int value=(int) chain.get(i);
				box[(value%((int)Math.pow(base, currentDigit)))/(int)Math.pow(base, currentDigit-1)].add(value);
			}
			for(int i=base-1;i>=0;i--){
				for(int j=0;j<box[i].size();j++){
					result.add(box[i].get(j));
				}
			}
			return sort(result, digitN, currentDigit+1, base);
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		
	}

}
