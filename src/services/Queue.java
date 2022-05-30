package services;

public class Queue {

	private int first;
	private int last;
	private int elements;
	private double queue[];
	
	public Queue(int size) {
		first = -1;
		last = -1;
		elements = 0;
		queue = new double[size];
	}
	
	public boolean isEmpty() {
		if(elements == 0) {
			return true;
		}
		return false;
	}
	
	public void addToQueue(double num) {
		if (first == -1) {
			first = 0;
		}
		last++;
		queue[last] = num;
		elements++;
	}
	
	public void removeFromQueue() {
		if(! isEmpty()) {
			first++;
			elements--;
		}
	}
	
	public void removeFromTheMiddleQueue(int pos) {
		for(int i = pos; i < last; i++) {
			queue[pos] = queue[pos+1];
		}
		last--;
		elements--;
	}
	
	public String showQueue() {
		String q="";
		for(int i = first; i <= last; i++) {
			q += queue[i] + " - ";
		}
		return q;
	}
	
}
