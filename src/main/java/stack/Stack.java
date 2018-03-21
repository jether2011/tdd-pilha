package stack;

public class Stack {

	private Object[] elements;
	private int length;
	
	public Stack(int max) {
		this.elements = new Object[max];
	}

	public boolean isEmpty() {		
		return this.length == 0;
	}

	public int size() {		
		return this.length;
	}

	public void addElement(Object element) {
		if(this.length == this.elements.length)
			throw new FullStackException();
		
		this.elements[this.length] = element;
		this.length++;
	}

	public Object top() {
		return this.elements[this.length - 1];
	}

	public Object removeElement() {
		if(this.length == 0)
			throw new EmptyStackException();		
		this.length--;
		return this.elements[this.length];
	}
	
}
