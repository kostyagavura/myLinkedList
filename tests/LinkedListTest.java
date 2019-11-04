import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class LinkedListTest {
    @Test
    public void testConstructor() {
        try {
            new LinkedList();
        } catch (RuntimeException e) {
            e.getStackTrace();
        }
    }

    @Test
    public void size() {
    }

    @Test
    public void addFirstElement() {
        List list = new LinkedList();
        list.addFirstElement("Last");
        assertSame("Last", list.getFirstElement());
        assertSame("Last", list.getLastElement());
        list.addFirstElement("First");
        assertSame("First", list.getFirstElement());
        assertSame("Last", list.getLastElement());
    }

    @Test
    public void addLastElement() {
        List list = new LinkedList();
        list.addLastElement("First");
        assertSame("First", list.getFirstElement());
        assertSame("First", list.getLastElement());
        list.addLastElement("Last");
        assertSame("First", list.getFirstElement());
        assertSame("Last", list.getLastElement());
    }

    @Test
    public void get() {
    }

    @Test
    public void getFirstElement() {
        List testList = new LinkedList();
        try {
            testList.getFirstElement();
            fail("An exception should be thrown the empty list");

        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getLastElement() {
        List testList = new LinkedList();
        try {
            testList.getLastElement();
            fail("This should throw the exception - empty list");
        } catch (NoSuchElementException e) { //
            e.printStackTrace();
        }
    }


    @Test
    public void removeFirstElement() {
        List list = new LinkedList();
        list.addLastElement("First");
        list.addLastElement("Last");
        assertSame("First", list.getFirstElement());
        assertSame("Last", list.getLastElement());
        assertSame("First", list.removeFirstElement());
        assertSame("Last", list.getFirstElement());
        assertSame("Last", list.getLastElement());
        assertSame("Last", list.removeFirstElement());
        try {
            list.removeFirstElement();
            fail("This should throw the exception");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void removeLastElement() {
        List list = new LinkedList();
        list.addLastElement("First");
        list.addLastElement("Last");
        assertSame("First", list.getFirstElement());
        assertSame("Last", list.getLastElement());
        assertSame("Last", list.removeLastElement());
        assertSame("First", list.getFirstElement());
        assertSame("First", list.getLastElement());
        assertSame("First", list.removeFirstElement());
        try {
            list.removeFirstElement();
            fail("This should throw the exception");
        } catch (NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testIteratorOnEmptyList() {
        List list = new LinkedList();
        ListIterator i = list.getIterator();
        assertNotNull(i);
        assertFalse(i.hasNext());
        try {
            i.next();
            fail("This should throw the exception");
        } catch (NoSuchElementException e) { // ok
            e.printStackTrace();
        }

    }

    @Test
    public void testIteratorOnNotEmptyList() { //Test basic iterator, if it works as expected
        List list = new LinkedList();
        Integer first = 1;
        Integer second = 2;
        Integer third = 3;
        Integer fifth = 4;
        list.addFirstElement(first);
        list.addLastElement(second);
        list.addLastElement(third);
        list.addLastElement(fifth);
        ListIterator i = list.getIterator();
        assertNotNull(i);
        assertTrue(i.hasNext());
        assertSame(i.next(), first);
        assertTrue(i.hasNext());
        assertSame(i.next(), second);
        assertTrue(i.hasNext());
        assertSame(i.next(), third);
        assertTrue(i.hasNext());
        assertSame(i.next(), fifth);
        assertFalse(i.hasNext());
    }

    @Test
    public void testIteratorAdd() {
        List list = new LinkedList();
        Integer first = 1;
        Integer second = 2;
        Integer third = 3;
        Integer fifth = 4;

        ListIterator i = list.getIterator();// Adds first element in the empty list and checks [   ] -> [ 2 ]

        i.add(second);
        assertSame(second, list.getFirstElement());
        assertSame(second,list.getLastElement());
        assertFalse(i.hasNext());

        i = list.getIterator(); //Go to head add an element after the first  [ 1 ] -> [ 1, 2 ]
        i.add(first);
        assertSame(first, list.getFirstElement());
        assertTrue(i.hasNext());
        assertSame(second, i.next());
        assertFalse(i.hasNext());

        i = list.getIterator(); //Go to beginning, skip and  add an 2 elements  [ 3, 4 ] -> [ 1, 2, 3 , 4 ]
        assertTrue(i.hasNext());
        assertSame(first, i.next());
        assertTrue(i.hasNext());
        assertSame(second, i.next());
        i.add(third);
        assertFalse(i.hasNext());
        i.add(fifth);
        assertFalse(i.hasNext());

    }

}