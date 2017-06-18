package cn.bupt.other.methods;

import java.util.ArrayList;
import java.util.List;

public class GradeCode {
	
	public static List<String> gradeCode(int n){
		List<String> result=new ArrayList<String>();
		if(n==1){
			result.add("0");
			result.add("1");
			return result;
		}else{
			List<String> tempList=gradeCode(n-1);
			for(int i=0;i<tempList.size();i++){
				result.add("0"+tempList.get(i));
			}
			for(int i=tempList.size()-1;i>=0;i--){
				result.add("1"+tempList.get(i));
			}
			return result;
		}
		
	}

}
