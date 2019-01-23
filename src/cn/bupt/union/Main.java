package cn.bupt.union;

import java.util.*;

/**
 * Created by chongli on 2017/9/13.
 */
public class Main {

    private static Map<String,List<String>> referMap=new HashMap<String, List<String>>();

    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt();
        int n=sc.nextInt();
        for (int i=0;i<m;i++){
            String line=sc.next();
            System.out.println(line);
            String column[]=line.split(" ");
            String first=column[0];
            String refer1=column[1];
            String refer2=column[2];
            List<String> referList=new ArrayList<String>();
            referList.add(refer1);
            if (!"*".equals(refer2)){
                referList.add(refer2);
            }
            referMap.put(first,referList);
        }
        Set<String> keySet = referMap.keySet();
        boolean tag=false;
        for (String refer:keySet){
            int referNum=getReferNum(refer).size();
            if (referNum>=n){
                System.out.println(refer+" ");
                tag=true;
            }

        }
        if (tag){
            System.out.println("None");
        }


    }

    public static Set<String> getReferNum(String refer){
        Set<String> referSet=new HashSet<String>();
        List<String> referList=referMap.get(refer);
        if (referList==null)
            return referSet;
        for (String re:referList){
            if (re.equals(refer)){
                continue;
            }
            referSet.add(re);
            referSet.addAll(getReferNum(re));
        }

        return referSet;
    }
}
