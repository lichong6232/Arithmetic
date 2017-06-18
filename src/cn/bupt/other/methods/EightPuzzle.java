package cn.bupt.other.methods;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 八数码问题求解
 * 
 * @author kaiser
 *
 */
public class EightPuzzle {

	

	/**
	 * 启发式搜索，选择最优希望的节点加以扩展,估价函数为f(n)=d(n)+W(n) ;d(n)为搜索树中节点n的深度；W(n)为位置错误的个数
	 * 
	 * @param node1
	 *            初始状态节点
	 * @param node2
	 *            目标状态节点
	 */
	public void heuristicSearch(int[] node1, int[] node2) {
		List<int[]> open = new ArrayList<int[]>();// 存放待扩展的结点
		List<int[]> close = new ArrayList<int[]>();// 存放已经访问扩展过的结点
		int d = 0; // 节点n的深度
		int w = 0; // 错放位置数
		int f = 0;
		int swap;
		int index = 0;// 自加标记
		for (int i = 0; i < node1.length; i++) {
			if (node1[i] != node2[i]) {
				w++;
			}
		}
		f = d + w;
		int[] node = new int[13];
		for (int i = 0; i < node1.length; i++) {
			node[i] = node1[i];
		}
		node[9] = f; // 存放估价代价
		node[10] = -1; // 存放父节点
		node[11] = 0; // 存放深度d
		node[12] = 0; // 标记自己标志
		open.add(node); // 初始化open表
		while (!open.isEmpty()) {
			int flag = 0;
			int[] sub = new int[9];
			if(open.size()==1){  //如果open表中只有一个节点然后比较
				for (int j = 0; j < sub.length; j++) { 
					sub[j] = open.get(0)[j];
				}
				if (Arrays.equals(sub, node2)) {
					System.out.print("已达到目标情况:");
					for (int j = 0; j < 9; j++) {
						System.out.print(" " + sub[j]);
					}
					System.out.println();
					return;
				}
			}
			for (int i = 1; i < open.size(); i++) {
				if (open.get(i)[9] < open.get(flag)[9]) {
					flag = i;
					for (int j = 0; j < sub.length; j++) { // 如果有几个节点合格，判断其中是否有目标结点
						sub[j] = open.get(i)[j];
					}
					if (Arrays.equals(sub, node2)) {
						System.out.print("已达到目标情况:");
						for (int j = 0; j < 9; j++) {
							System.out.print(" " + sub[j]);
						}
						System.out.println();
						return;
					}
				}
			}
			int[] a = open.remove(flag);
			close.add(a); // 加入close表
			int k = 0;// 存放空格位置
			for (int j = 0; j < 9; j++) {
				if (a[j] == 0) {
					k = j;
					break;
				}
			}
			int flag1 = 0, flag2 = 0; // 判断是否被访问的标志位
			if (k - 3 >= 0) { // 判断可否上移
				int[] succeed1 = new int[13];
				for (int p = 0; p < 9; p++) {
					succeed1[p] = a[p];
				}
				swap = succeed1[k];
				succeed1[k] = succeed1[k - 3];
				succeed1[k - 3] = swap;
				w = 0;
				d = 0;
				f = 0;
				for (int i = 0; i < 9; i++) {
					if (succeed1[i] != node2[i]) {
						w++; // 错放数
					}
				}
				d = a[11] + 1;
				f = w + d;
				succeed1[9] = f;
				succeed1[10] = a[12];
				succeed1[11] = d;
				succeed1[12] = ++index;
				flag1 = closeSerach(close, succeed1);
				// System.out.println("1"+"---"+flag);
				if (flag1 == 0) {
					flag2 = openSearch(open, succeed1);
					if (flag2 == 0) {
						open.add(succeed1);
					}

				}
			}
			if (k + 3 <= 8) { // 判断可否下移
				int[] succeed2 = new int[13];
				for (int p = 0; p < 9; p++) {
					succeed2[p] = a[p];
				}
				swap = succeed2[k];
				succeed2[k] = succeed2[k + 3];
				succeed2[k + 3] = swap;

				w = 0;
				d = 0;
				f = 0;
				for (int i = 0; i < 9; i++) {
					if (succeed2[i] != node2[i]) {
						w++; // 错放数
					}
				}
				d = a[11] + 1;
				f = w + d;
				succeed2[9] = f;
				succeed2[10] = a[12];
				succeed2[11] = d;
				succeed2[12] = ++index;
				flag1 = closeSerach(close, succeed2);
				// System.out.println("1"+"---"+flag1);
				if (flag1 == 0) {
					flag2 = openSearch(open, succeed2);
					if (flag2 == 0) {
						open.add(succeed2);
					}

				}
			}
			if (k + 1 <= 8) { // 判断可否右移
				int[] succeed3 = new int[13];
				for (int p = 0; p < 9; p++) {
					succeed3[p] = a[p];
				}
				swap = succeed3[k];
				succeed3[k] = succeed3[k + 1];
				succeed3[k + 1] = swap;

				w = 0;
				d = 0;
				f = 0;
				for (int i = 0; i < 9; i++) {
					if (succeed3[i] != node2[i]) {
						w++; // 错放数
					}
				}
				d = a[11] + 1;
				f = w + d;
				succeed3[9] = f;
				succeed3[10] = a[12];
				succeed3[11] = d;
				succeed3[12] = ++index;

				flag1 = closeSerach(close, succeed3);
				if (flag1 == 0) {
					flag2 = openSearch(open, succeed3);
					if (flag2 == 0) {
						open.add(succeed3);
					}
				}
			}
			if (k - 1 >= 0) { // 判断可否左移
				int[] succeed4 = new int[13];
				for (int p = 0; p < 9; p++) {
					succeed4[p] = a[p];
				}
				swap = succeed4[k];
				succeed4[k] = succeed4[k - 1];
				succeed4[k - 1] = swap;

				w = 0;
				d = 0;
				f = 0;
				for (int i = 0; i < 9; i++) {
					if (succeed4[i] != node2[i]) {
						w++; // 错放数
					}
				}
				d = a[11] + 1;
				f = w + d;
				succeed4[9] = f;
				succeed4[10] = a[12];
				succeed4[11] = d;
				succeed4[12] = ++index;
				flag1 = closeSerach(close, succeed4);

				if (flag1 == 0) {
					flag2 = openSearch(open, succeed4);
					if (flag2 == 0) {
						open.add(succeed4);
					}
				}
			}

			for (int i = 0; i < 9; i++) {
				System.out.print(a[i] + " ");
			}
			System.out.println("----" + a[9]);
		}

	}

	/**
	 * 查找判断close表中是否有相同节点，比较代价值
	 * 
	 * @param close
	 * @param succeed
	 * @return
	 */
	public int closeSerach(List<int[]> close, int[] succeed) {
		int flag = 0, flag1 = 0, a = 0;
		for (int k = 0; k < close.size(); k++) {
			int[] o1 = new int[9];
			int[] o2 = new int[9];
			for (int i = 0; i < 9; i++) {
				o1[i] = close.get(k)[i];
				;
				o2[i] = succeed[i];
			}
			if (Arrays.equals(o1, o2)) { // 判断是否被访问过
				if (succeed[9] > close.get(k)[9]) {
					flag = 1;
					break;
				} else {
					a = k ;
					flag1 = 1;
				}
			}
		}
		if (flag1 == 1) {
			close.remove(a); // 从close表中移除比当前节点代价值大的节点 当前节点移入open表
		}
		return flag;
	}

	/**
	 * 查找open表中是是否有与当前节点相同内容的节点，如果有，且代价值比该节点大，则移除这个节点，将当前节点添加进open表中
	 * 
	 * @param open
	 * @param succeed
	 */
	public int openSearch(List<int[]> open, int[] succeed) {
		int a = 0, flag = 0, flag1 = 0;
		for (int k = 0; k < open.size(); k++) {
			int[] o1 = new int[9];
			int[] o2 = new int[9];
			for (int i = 0; i < 9; i++) {
				o1[i] = open.get(k)[i];
				o2[i] = succeed[i];
			}
			if (Arrays.equals(o1, o2)) { // 如果open表中有相同节点顺序，但是比该节点的f值小的话，用该节点替换，移除open表中原来的节点
				if (succeed[9] < open.get(k)[9]) {
					a = k;
					flag = 1;
				} else {
					flag1 = 1;// ????如果open表中的f值小于该节点的f值呢？存？不存？
				}
			}
		}
		if (flag == 1) {
			open.remove(a);
		}
		return flag1;
	}
   
	
	/**
	 * 判断输入的开始和结束序列是否为相同排列，若为相同排列则返回true ,否则返回false
	 * @param a
	 * @param b
	 * @return
	 */
	public Boolean judgeArray(int[] a, int[] b) {
		int na = 0, nb = 0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[i] > a[j]) {
					na++;
				}
			}
		}
		System.out.println(na);
		for (int i = 0; i < b.length; i++) {
			for (int j = i + 1; j < b.length; j++) {
				if (b[i] > b[j]) {
					nb++;
				}
			}
		}
		System.out.println(nb);
		if (na % 2 == nb % 2) {
			return true;
		}
		System.out.println("输入错误！初始序列和目标序列逆序数的奇偶性不同！请重新输入！");
		return false;

	}

	public static void main(String[] args) {
		int[] a = new int[9];// 存放初始位置
		int[] b = new int[9];// 存放目标位置
		boolean  flag=false;
		EightPuzzle et = new EightPuzzle();
		Scanner scanner = new Scanner(System.in);
		while(!flag){			
			// 输入初始位置
			System.out.println("请输入初始位置（其中输入0代表空白块，例如：1 2 3 4 5 6 7 8 0）：");
			for (int i = 0; i < 9; i++) {
				a[i] = scanner.nextInt();

			}

			// 输入目标位置
			System.out.println("请输入目标位置（其中输入0代表空白块，例如：1 2 3 4 5 6 7 8 0）：");
			for (int i = 0; i < 9; i++) {
				b[i] = scanner.nextInt();
			}
			flag=et.judgeArray(a, b);
		}	
		// et.breadthFirstSearch(a, b);
		et.heuristicSearch(a, b);
		
	}
}
