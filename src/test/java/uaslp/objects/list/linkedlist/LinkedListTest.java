package uaslp.objects.list.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objects.list.Iterator;
import uaslp.objects.list.exception.NotNullValuesAllowedException;
import uaslp.objects.list.exception.NotValidIndexException;

public class LinkedListTest {

    @Test
    public void givenANewList_whenGetSize_thenResultIsZero(){
        //Given:
        LinkedList<String> list = new LinkedList<>();

        //When:
        int sizeOfList = list.getSize();

        //Then:
        Assertions.assertEquals(0, sizeOfList, "Size of list after creation must be zero");
    }

    @Test
    public void givenANewList_whenAddAtFrontAnElement_thenSizeIsOne() throws NotNullValuesAllowedException, NotValidIndexException {
        //Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");

        //When:
        int size = list.getSize();

        //Then:
        Assertions.assertEquals(1, size);
        Assertions.assertEquals("Hola", list.getAt(0));
    }

    @Test
    public void givenANewList_whenAddAtTailAnElement_thenSizeIsOne() throws NotNullValuesAllowedException, NotValidIndexException {
        //Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtTail("Hola");

        //When:
        int size = list.getSize();

        //Then:
        Assertions.assertEquals(1, size);
        Assertions.assertEquals("Hola", list.getAt(0));
    }

    @Test
    public void givenAListWithElement_whenAddAtFrontAnElement_thenSizeIsTwo() throws NotNullValuesAllowedException, NotValidIndexException {
        //Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");

        //When:
        list.addAtFront("Mundo");

        //Then:
        int size = list.getSize();
        Assertions.assertEquals(2, size);
        Assertions.assertEquals("Mundo", list.getAt(0));
        Assertions.assertEquals("Hola", list.getAt(1));
    }

    @Test
    public void givenAListWithElement_whenAddAtTailAnElement_thenSizeIsTwo() throws NotNullValuesAllowedException, NotValidIndexException {
        //Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtTail("Hola");

        //When:
        list.addAtTail("Mundo");

        //Then:
        int size = list.getSize();

        Assertions.assertEquals(2, size);
        Assertions.assertEquals("Hola", list.getAt(0));
        Assertions.assertEquals("Mundo", list.getAt(1));
    }

    @Test
    public void givenAListWithOneElement_whenRemove_thenSizeIsZero() throws NotValidIndexException, NotNullValuesAllowedException {
        //Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");

        //When:
        list.remove(0);

        //Then:
        int size = list.getSize();

        Assertions.assertEquals(0, size);
    }

    @Test
    public void givenAListWithTwoElements_whenRemoveIndex1_thenSizeIsOne() throws NotValidIndexException, NotNullValuesAllowedException {
        //Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        //When:
        list.remove(1);

        //Then:
        int size = list.getSize();

        Assertions.assertEquals(1, size);
        Assertions.assertEquals("Hola", list.getAt(0));
    }

    @Test
    public void givenAListWithTwoElements_whenRemove_thenSizeIsOne() throws NotValidIndexException, NotNullValuesAllowedException {
        //Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");

        //When:
        list.remove(0);

        //Then:
        int size = list.getSize();

        Assertions.assertEquals(1, size);
        Assertions.assertEquals("Mundo", list.getAt(0));
    }

    @Test
    public void givenAListWithThreeElements_whenRemoveIndex1_thenSizeIsTwo() throws NotValidIndexException, NotNullValuesAllowedException {
        //Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtTail("Mundo");
        list.addAtTail("Cruel");
        list.addAtFront("Adi??s");

        //When:
        list.remove(1);

        //Then:
        int size = list.getSize();

        Assertions.assertEquals(2, size);
        Assertions.assertEquals("Adi??s", list.getAt(0));
        Assertions.assertEquals("Cruel", list.getAt(1));
    }

    @Test
    public void givenAListWithThreeElements_whenRemoveElementAtTail_thenSizeIsTwo() throws NotValidIndexException, NotNullValuesAllowedException {
        //Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Adi??s");
        list.addAtTail("Mundo");
        list.addAtTail("Cruel");

        //When:
        list.remove(2);

        //Then:
        int size = list.getSize();

        Assertions.assertEquals(2, size);
        Assertions.assertEquals("Adi??s", list.getAt(0));
        Assertions.assertEquals("Mundo", list.getAt(1));
    }

    @Test
    public void givenAListWithThreeElements_whenRemoveAll_thenSizeIsZero() throws NotNullValuesAllowedException {
        //Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Adi??s");
        list.addAtTail("Mundo");
        list.addAtTail("Cruel");

        //When:
        list.removeAll();

        //Then:
        int size = list.getSize();

        Assertions.assertEquals(0, size);
    }
    @Test
    public void givenAListWithTwoElements_whenSetAt_thenElementIsModified() throws NotNullValuesAllowedException, NotValidIndexException {
        //Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtTail("Mundo");
        list.addAtFront("Adi??s");


        //When:
        list.setAt(0, "Hola");

        //Then:
        int size = list.getSize();

        Assertions.assertEquals(2, size);
        Assertions.assertEquals("Hola", list.getAt(0));
        Assertions.assertEquals("Mundo", list.getAt(1));
    }

    @Test
    public void givenAListWithThreeElements_whenGetIterator_thenIteratorWorksOverAllThreeElements() throws NotNullValuesAllowedException, NotValidIndexException {
        //Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtTail("Mundo");
        list.addAtTail("Cruel");
        list.addAtFront("Adi??s");

        //When:
        Iterator<String> iterator = list.getIterator();

        //Then:
        int size = list.getSize();

        Assertions.assertEquals(3, size);
        Assertions.assertNotNull(iterator);
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Adi??s", iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Mundo", iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Cruel", iterator.next());
        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    public void givenAListWithOneElement_whenGetAt_thenNotValidIndexExceptionIsThrown() throws NotValidIndexException, NotNullValuesAllowedException {
        //Given:
        LinkedList<String> list = new LinkedList<>();
        list.addAtFront("Hola");

        //When:
        list.getAt(0);
        //Then:
        Assertions.assertThrows(NotValidIndexException.class, ()->list.getAt(1));

    }

    @Test
    public void givenAListWithTwoElements_whenRemoveIndexThree_thenNotVallidIndexExceptionIsThrown() throws  NotNullValuesAllowedException {
        //Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");


        //When:
        //Then:
        Assertions.assertThrows(NotValidIndexException.class, ()->list.remove(3));

    }

    @Test
    public void givenAListWithTwoElements_whenSetAtIndexThree_thenNotVallidIndexExceptionIsThrown() throws  NotNullValuesAllowedException {
        //Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");


        //When:
        //Then:
        Assertions.assertThrows(NotValidIndexException.class, ()->list.setAt(3, "Valor"));
    }

    @Test
    public void givenAListWithTwoElements_whenAddAtFrontNullValues_thenNotNullValuesAllowedExceptionIsThrown() throws  NotNullValuesAllowedException {
        //Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");


        //When:
        //Then:
        Assertions.assertThrows(NotNullValuesAllowedException.class, ()->list.addAtFront(null));
    }

    @Test
    public void givenAListWithTwoElements_whenAddAtTailNullValues_thenNotNullValuesAllowedExceptionIsThrown() throws  NotNullValuesAllowedException {
        //Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");


        //When:
        //Then:
        Assertions.assertThrows(NotNullValuesAllowedException.class, ()->list.addAtTail(null));
    }

    @Test
    public void givenAListWithTwoElements_whenASetAtNullValues_thenNotNullValuesAllowedExceptionIsThrown() throws  NotNullValuesAllowedException {
        //Given:
        LinkedList<String> list = new LinkedList<>();

        list.addAtFront("Hola");
        list.addAtTail("Mundo");
        //When:
        //Then:
        Assertions.assertThrows(NotNullValuesAllowedException.class, ()->list.setAt(0,null));
    }
}