
class Stack{
	
	private final int capacity = 10;
	private int top;
	private char[] items;
	
	public Stack() {
		init(capacity);
	}
	public Stack(int capacity) {
		init(capacity);
	}
	private void init(int capacity) {
		top = -1;
		items = new char[capacity];
	}
	public boolean isEmpty() {
		return top < 0;
	}
	public boolean isFull() {
		return top >= items.length - 1;
	}
	public void push(char item) {
		if(isFull()) resize();
		items[++top] = item;
	}
	public char pop() {
		if(!isEmpty())
			return items[top--];
		return ' ';
	}
	public char peep() {
		if(!isEmpty())
			return items[top];
		return ' ';
	}
	private void resize() {
		char[] tmp = new char[items.length * 2];
		for(int i = 0; i < items.length; i++)
			tmp[i] = items[i];
		items = tmp;
		tmp = null;
	}
	
}
