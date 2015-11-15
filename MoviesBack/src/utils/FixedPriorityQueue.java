package utils;

import java.util.PriorityQueue;

public class FixedPriorityQueue<T extends Comparable<? super T>> extends PriorityQueue<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3769232648476568441L;
	
	private final int fixedSize;

	public FixedPriorityQueue(int n) {
		super(n);
		this.fixedSize = n;
	}
	
	@Override
	public boolean add(T e) {
		if (!this.isEmpty() && fixedSize == this.size()) {
			T elem = this.peek();
			if (elem.compareTo(e) < 0) {
				this.poll();
			} else {
				return false;
			}
		} 
		return super.add(e);
	}
}
