package stack.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import stack.EmptyStackException;
import stack.FullStackException;
import stack.Stack;

public class StackTestCase {

	private Stack stack;

	@Before
	public void initStack() {
		this.stack = new Stack(2);
	}

	@Test
	public void emptyTrue() {
		assertTrue(this.stack.isEmpty());
		assertEquals(0, this.stack.size());
	}

	@Test
	public void addElement() {
		this.stack.addElement("A");
		assertFalse(this.stack.isEmpty());
		assertEquals(1, this.stack.size());
		assertEquals("A", this.stack.top());
	}

	@Test
	public void addTwoElement() {
		this.stack.addElement("A");
		this.stack.addElement("B");
		assertEquals(2, this.stack.size());
		assertEquals("B", this.stack.top());
	}

	@Test
	public void removeElement() {
		this.stack.addElement("A");
		this.stack.addElement("B");
		assertEquals(2, this.stack.size());
		assertEquals("B", this.stack.top());
		this.stack.removeElement();
		assertEquals(1, this.stack.size());
		assertEquals("A", this.stack.top());
	}

	@Test(expected = EmptyStackException.class)
	public void removeElementFromEmptyStack() {
		this.stack.removeElement();
	}

	@Test
	public void removeElementFromFullStack() {
		for (int i = 0; i < this.stack.size(); i++) {
			this.stack.addElement("J" + i);

			try {
				this.stack.addElement("Wow");
				fail();
			} catch (FullStackException e) {
			}
		}
	}

}
