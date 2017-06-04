package com.xxx.test;

import java.util.Stack;

public class StackWithMinMax extends Stack<Integer> {

	private static final long serialVersionUID = -6517582749666057253L;

	private Stack<Integer> minStack;
	private Stack<Integer> maxStack;

	public Integer push(Integer item) {
		if(item <= min()){
			minStack.push(item);
		}
		if (item >= max()) {
			maxStack.push(item);
		}
		return super.push(item);
	}

	public StackWithMinMax() {
		minStack = new Stack<Integer>();
		maxStack = new Stack<Integer>();
	}

	public Integer pop() {
		int value = super.pop();
		if(value == min()){
			minStack.pop();
		}
		if (value == max()) {
			maxStack.pop();
		}
		return value;
	}

	public static void main(String[] args) {
		StackWithMinMax stackWithMinMax = new StackWithMinMax();
		stackWithMinMax.push(9);
		stackWithMinMax.push(5);
		stackWithMinMax.push(8);
		stackWithMinMax.push(2);
		stackWithMinMax.push(12);
		stackWithMinMax.push(6);
		stackWithMinMax.pop();
		stackWithMinMax.pop();
		System.out.println(stackWithMinMax.min() + "->" + stackWithMinMax.max());
		System.out.println(stackWithMinMax.minStack);
		System.out.println(stackWithMinMax.maxStack);
		
	}

	private Integer max() {
		if (maxStack.isEmpty()) {
			return Integer.MIN_VALUE;
		} else {
			return maxStack.peek();
		}
	}
	
	private Integer min(){
		if(minStack.isEmpty()){
			return Integer.MAX_VALUE;
		}else{
			return minStack.peek();
		}
	}

}
