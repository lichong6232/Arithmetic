package cn.bupt.interf;

public interface LineTable {
	
	public boolean isEmpty();
	public int size();
	public Object get(int index);
	public int indexOf(Object o);
	public Object remove(int index);
	public void add(int index,Object o);
	public void add(Object o);
	public void outPut();

}
