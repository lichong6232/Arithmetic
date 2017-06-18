package cn.bupt.tree;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
class HaffNode{
	protected char label;
	protected int weight;
	protected HaffNode left;
	protected HaffNode right;
	public HaffNode(char label,int weight){
		this.label=label;
		this.weight=weight;
	}
}

public class HuffmanTree {
	
	public static void main(String[] args) {
		HuffmanTree huffmanTree=new HuffmanTree();
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		map.put('M', 1);
		map.put('U', 1);
		map.put('T', 1);
		map.put('Y', 2);
		map.put('E', 2);
		map.put('A', 2);
		map.put('P', 4);
		map.put('S', 5);
		
		Map<Character,String> result=huffmanTree.code(map);
		Set<Character> set=result.keySet();
		for(Character key:set){
			System.out.println(key+":"+result.get(key));
		}
		
	}
	
	public Map<Character,String> code(Map<Character,Integer> map){
		Map<Character,String> result=new HashMap<Character,String>();
		
		HaffNode root=buildHaffMan(map);
		List<String> tempCode=new ArrayList<String>();
		getCode(root, result, tempCode);
		
		return result;
	}
	
	private void getCode(HaffNode root,Map<Character,String> map,List<String> tempCode){
		if(root==null)
			return;
		if(root.left==null&&root.right==null){
			String code="";
			for(String s:tempCode){
				code+=s;
			}
			map.put(root.label, code);
		}
		tempCode.add("0");
		getCode(root.left, map, tempCode);
		tempCode.remove(tempCode.size()-1);
		tempCode.add("1");
		getCode(root.right, map, tempCode);
		tempCode.remove(tempCode.size()-1);
		
	}
	
	
	public HaffNode buildHaffMan(Map<Character,Integer> map){
		PriorityQueue<HaffNode> queue=readData(map);
		while(queue.size()>1){
			HaffNode haffNodeLeft=queue.poll();
			HaffNode haffNodeRight=queue.poll();
			HaffNode haffNode=new HaffNode('#', haffNodeLeft.weight+haffNodeRight.weight);
			haffNode.left=haffNodeLeft;
			haffNode.right=haffNodeRight;
			queue.add(haffNode);
		}
		return queue.poll();
		
	}
	
	private PriorityQueue<HaffNode> readData(Map<Character,Integer> map){
		PriorityQueue<HaffNode> queue=new PriorityQueue<HaffNode>(20,new Comparator<HaffNode>() {
			@Override
			public int compare(HaffNode o1, HaffNode o2) {
				// TODO Auto-generated method stub
				return o1.weight-o2.weight;
			}
		});
		Iterator<Map.Entry<Character, Integer>> it=map.entrySet().iterator();
		while(it.hasNext()){
			Map.Entry<Character, Integer> entry=it.next();
			HaffNode haffNode=new HaffNode(entry.getKey(), entry.getValue());
			queue.add(haffNode);
		}
		return queue;
	}
}
