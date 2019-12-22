package com.homework;
/**
 * 用add first或add last这套新的API改写Deque的代码
 * 分别采用了数组和链表结构进行queue的实现。
 * @author ibing
 *
 */
public class MyDeque {

	//维护数据结构（数组、容量定长、元素从中间开始添加）
	private static int arr[];
	
	public MyDeque(int size) {
		arr=new int[size];
		prev=size/2;
		next=prev+1;
		this.size=size;
	}
	public MyDeque() {
		
	}
	//链表结构使用
	int prev=0,next=0,size=0;
	private MyNode first=null,last=null;
	public static void  main(String[] args) {
		// TODO Auto-generated method stub
		//添加元素从中间下标开始，如果超过前后容量则throw IllegalStateException
		//数组结构
//		MyDeque md=new MyDeque(7);
//		md.addFirst(2);
//		md.addLast(1);
//		md.addLast(12);
//		for (int x : arr) {
//			System.out.println(x);
//		}
		//链表结构
		MyDeque md1=new MyDeque();
		md1.addFirst("c");
		md1.addLast("d");
		md1.addFirst("0");
		md1.printEmement(md1.first);
	}
	//以数组结构实现
	public void addLast(int element){
		if(next>=size) {
			throw new IllegalStateException();
		}
		arr[next++]=element;
		
	}
	public void addFirst(int element) {
		if(prev<0) {
			throw new IllegalStateException();
		}
		arr[prev--]=element;
		
	}
	
	//以链表结构实现
	public void addLast(Object element) {
		if (first == null||last == null) {
			MyNode mn=new MyNode(null,null,element);
			first = mn;
			last = mn;
		} else {
			MyNode mn=new MyNode(last,null,element);
			last.next = mn;
			last = mn;
		}
	}
	public void addFirst(Object element) {
		if (first == null||last == null) {
			MyNode mn=new MyNode(null,null,element);
			first = mn;
			last = mn;
		} else {
			MyNode mn=new MyNode(null,first,element);
			first.prev = mn;
			first = mn;
		}
	}
	//打印queue内所有元素
	public void printEmement(MyNode mn) {
		if (mn == null) {
			return ;
		}
		System.out.println(mn.node.toString());
		if (mn.next == null)
			return ;
		printEmement((MyNode)mn.next);
		
	}
	//节点对象
	class MyNode{
		Object prev;
		Object next;
		Object node;
		public MyNode(Object prev,Object next,Object node){
			this.prev=prev;
			this.next=next;
			this.node=node;
		}
	}
}
