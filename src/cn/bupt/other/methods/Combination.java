package cn.bupt.other.methods;

import java.util.*;

public class Combination {
	
	public static void main(String[] args) {
//		System.out.println(num2Binary(10, 4));
//		System.out.println((1<<3)-1);
		/*String word[]={"A","B","C","D","E","F","G","H","I","J","k","L","M","N","O","P","Q","R"};
		String result[]=getCombination(word);*/
		/*for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}*/
		/*System.out.println(result.length);
		for(String s:result){
			System.out.println(s);
		}*/
		
		/*Set<String> set=getMFromN(2,4);
		System.out.println(set);
		System.out.println(set.size());*/
        List<List<Integer>> mFromNByRecursion = getMFromNByRecursion(4, 4);
        System.out.println(mFromNByRecursion);


    }



	public static void move(int a[],int tag){
		int sum=0;
		for(int i=0;i<tag;i++){
			if(a[i]==1){
				++sum;
			}
		}
		
		for(int i=0;i<tag;i++){
			if(i<sum){
				a[i]=1;
			}else{
				a[i]=0;
			}
		}
		
	}
	
	public static String getValue(int a[]){
		StringBuffer sb=new StringBuffer();
		for(int i:a){
			sb.append(i);
		}
		return sb.toString();
	}

    /**
     * 通过递归算法实现
     * @param m
     * @param n
     * @return
     */
	public static List<List<Integer>> getMFromNByRecursion(int m,int n){
        List<Integer> list = new ArrayList<>();
        for (int i=1;i<=n;i++){
            list.add(i);
        }
        return getMFromNByRecursion(list,m);
    }

    public static List<List<Integer>> allSort(int m,int n){
        List<Integer> list = new ArrayList<>();
        for (int i=1;i<=n;i++){
            list.add(i);
        }
        return allSort(list,m);
    }

    public static List<List<Integer>> allSort(List<Integer> list,int m){
        List<List<Integer>> result = new ArrayList<>();

        if (list.size()==0){
            return result;
        }

        if (m==1){
            for (int i=0;i<list.size();i++){
                List<Integer> temp = new ArrayList<>();
                temp.add(list.get(i));
                result.add(temp);
            }
            return result;
        }
        for (int i=0;i<list.size();i++){
            Integer removed = list.remove(i);
            for (List<Integer> chileResult : allSort(list, m - 1) ){
                List<Integer> temp = new ArrayList<>();
                temp.add(removed);
                temp.addAll(chileResult);
                result.add(temp);
            }
            list.add(i,removed);

        }

        return result;

    }

    public static List<List<Integer>> getMFromNByRecursion(List<Integer> list,int m){
	    List<List<Integer>> result = new ArrayList<>();

	    if (list.size()==0){
	        return result;
        }

	    if (m==1){
	        for (int i=0;i<list.size();i++){
	            List<Integer> temp = new ArrayList<>();
	            temp.add(list.get(i));
	            result.add(temp);
            }
            return result;
        }
        int i=0;
        Integer removed = list.remove(i);
        for (List<Integer> chileResult : getMFromNByRecursion(list, m - 1) ){
            List<Integer> temp = new ArrayList<>();
            temp.add(removed);
            temp.addAll(chileResult);
            result.add(temp);
        }

        for (List<Integer> chileResult : getMFromNByRecursion(list, m) ){
            List<Integer> temp = new ArrayList<>();
            temp.addAll(chileResult);
            result.add(temp);
        }

        list.add(i,removed);


        return result;

    }



    /**
     * 算法思想：本程序的思路是开一个数组b，其长度和数据数组一致，其前N位为1，N就是要取的数的个数，然后按照b的数据为1的下标来取数据数组的数字
     然后从左到右扫描数组b元素值的“10”组合，找到第一个“10”组合后将其变为
     “01”组合，同时将其左边的所有“1”全部移动到数组的最左端，“0”移到所有“1”和变为了“01”的中间
     当b数组最右边的N个元素全部为1时 组合完毕
     * @param m
     * @param n
     * @return
     */
	public static Set<String> getMFromN(int m,int n){
		Set<String> set=new HashSet<String>();
		int temp[]=new int[n];
		for(int i=0;i<m;i++){
			temp[i]=1;
		}
		
		while(true){
			
			set.add(getValue(temp));
			
			boolean tempTag=false;
			int i=0;
			for(;i<n-1;i++){
				if(temp[i]==1&&temp[i+1]==0){
					tempTag=true;
					break;
				}
			}
			
			if(tempTag){
				move(temp,i);
				swap(temp, i, i+1);
			}else{
				return set;
			}
		}
		
		
		
		
	}
	
	public static void swap(int a[],int i,int j){
		a[i]=a[i]^a[j];
		a[j]=a[i]^a[j];
		a[i]=a[i]^a[j];
	}
	
	public static String[] getCombination(String word[]){
		int length=word.length;
		int resultLength=(1<<length)-1;
		String result[]=new String[resultLength];
		for(int i=1;i<=resultLength;i++){
			String s=num2Binary(i,length);
			char c[]=s.toCharArray();
			String temp="";
			for(int j=0;j<length;j++){
				if(c[j]=='1'){
					temp+=word[j];
				}
			}
			result[i-1]=temp;
		}
		
		return result;
	}
	
	
	
	public static String num2Binary(int num,int nbit){
		String s="";
		
		for(int i=nbit-1;i>=0;i--){
			s+=(num>>i)&1;
		}
		
		return s;
	}

}
