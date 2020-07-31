package com.cheng.exer;
/**
 * 
 * 给定长度的数组，创建栈结构和队列结构
 * @author 86182
 *
 */
public class ArrToStackQueue {
	
	
	public static void main(String[] args) {
//		ArrayStack arrayStack = new ArrayStack(6);
//		arrayStack.push(10);
//		arrayStack.push(1);
//		arrayStack.push(11);
//		System.out.println(arrayStack.peek());
		
		ArrayQueue arrayQueue = new ArrayQueue(5);
		arrayQueue.push(10);
		System.out.println(arrayQueue.pop());
		
	}

}

class ArrayQueue {
	
	private Integer[] arr;
	private int size = 0;
	private int start;//负责取数
	private int end;//负责加数
	
	public ArrayQueue(Integer initSize) {
		if(initSize < 0) {
			throw new IllegalArgumentException("the imit size is less than 0");
		}
		arr = new Integer[initSize];
		
		this.size = 0;
		this.start = 0;
		this.end = 0;
	}
	
	
	public void push(int value) {
		if(size == arr.length) {
			throw new ArrayIndexOutOfBoundsException("the queue is full");
		}
		arr[end] = value;
		end = (end+1)%arr.length;
		size++;
	}
	
	public Integer pop() {
		if(size == 0) {
			throw new ArrayIndexOutOfBoundsException("the queue is empty");
		}
		size--;
		int value = arr[start];
		start = (start+1)%arr.length;
		return value;
	}
	
	public Integer peek() {
		if(size == 0) {
			throw new ArrayIndexOutOfBoundsException("the queue is empty");
		}
		return arr[start];
	}
	
	
}




class ArrayStack {
	
	private Integer[] arr;
	private Integer size;
	
	public ArrayStack(int initSize) {
		if(initSize < 0) {
			throw new IllegalArgumentException("the imit size is less than 0");
		}
		arr = new Integer[initSize];
		size = 0;
	}
	
	public Integer peek() {
		if(size == 0) {
			return null;
		}
		return arr[size - 1];
	}
	
	public void push(int obj) {
		if(size == arr.length) {
			throw new ArrayIndexOutOfBoundsException("the stack is full");
		}
		arr[size++] = obj;
	}
	
	public Integer pop() {
		if(size == 0) {
			throw new ArrayIndexOutOfBoundsException("the stack is empty");
		}
		return arr[--size];
	}
	
	
	
	
	
	
	
}
