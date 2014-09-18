import static org.junit.Assert.*;

import org.junit.Test;


public class DLinkedListTester {

	
	@Test
	 public void testtoString() {
		 DLinkedList<Integer> list = new DLinkedList<Integer>();
		 assertEquals("[]", list.toString());
		 assertEquals(0, list.size());
	 }

	@Test
	 public void testPrepend() {
		 
		DLinkedList<Integer> list = new DLinkedList<Integer>();
		assertEquals(list.size(), 0);
		assertEquals("[]", list.toString());
		list.prepend(5);
		assertEquals(list.size(), 1);
		assertEquals(list.toString(), "[5]");
		list.prepend(7);
		assertEquals(list.size(), 2);
		assertEquals(list.toString(), "[7, 5]");
		list.prepend(100);
		assertEquals(list.size(), 3);
		assertEquals(list.toString(), "[100, 7, 5]");
		list.prepend(0);
		assertEquals(list.size(), 4);
		assertEquals(list.toString(), "[0, 100, 7, 5]");

	 }
	
	@Test
	 public void testinsertBefore() {
		 
		DLinkedList<Character> list = new DLinkedList<Character>();
		list.prepend('c'); //to have something to insert before
		list.insertBefore('v', list.getHead());
		assertEquals(list.size(), 2);
		assertEquals(list.toString(), "[v, c]");
		
		list.insertBefore('a', list.getTail());
		assertEquals(list.size(), 3);
		assertEquals(list.toString(), "[v, a, c]");
		
		list.insertBefore('b', list.getHead().successor());
		assertEquals(list.size(), 4);
		assertEquals(list.toString(), "[v, b, a, c]");
		
		list.insertBefore('z', list.getTail().predecessor());
		assertEquals(list.size(), 5);
		assertEquals(list.toString(), "[v, b, z, a, c]");

	 }
	
	@Test
	 public void testRemove() {
		 
		DLinkedList<Integer> list = new DLinkedList<Integer>();
		list.prepend(2); 
		list.remove(list.getHead());
		assertEquals(list.size(), 0);
		assertEquals(list.toString(), "[]");
		
		list.prepend(2);
		list.insertBefore(4, list.getHead());
		list.insertBefore(5, list.getHead());
		list.insertBefore(6, list.getHead());
		assertEquals(list.size(), 4);
		assertEquals(list.toString(), "[6, 5, 4, 2]");
		
		list.remove(list.getHead().successor());
		assertEquals(list.size(), 3);
		assertEquals(list.toString(), "[6, 4, 2]");
		
		list.remove(list.getTail());
		assertEquals(list.size(), 2);
		assertEquals(list.toString(), "[6, 4]");
		
		list.remove(list.getTail().predecessor());
		assertEquals(list.size(), 1);
		assertEquals(list.toString(), "[4]");
		
		list.remove(list.getHead());
		assertEquals(list.size(), 0);
		assertEquals(list.toString(), "[]");

	 }
}
