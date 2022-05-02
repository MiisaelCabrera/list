package uaslp.objects.list.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objects.list.Iterator;

public class ArrayListTest {

    @Test
    public void givenASizeOfNewList_whenGetSize_thenResultIsThree() {
        //Given:
        ArrayList<String> array=new ArrayList<>(2);

        array.addAtFront("Hola");
        array.addAtFront("Adios");

        //When:
        array.addAtFront("Help");
        int sizeOfList = array.getSize();

        //Then:
        Assertions.assertEquals(3, sizeOfList, "Expected size of 3."); //Valida que el tamaño sea 3
        Assertions.assertEquals(array.getAt(0),"Help");
        Assertions.assertEquals(array.getAt(1),"Adios");
        Assertions.assertEquals(array.getAt(2),"Hola");
    }


    @Test
    public void givenANewList_whenGetSize_thenResultIsZero() {
        //Given:
        ArrayList<String> array = new ArrayList<>();

        //When:
        int sizeOfList = array.getSize();

        //Then:
        Assertions.assertEquals(0, sizeOfList, "Size of list after creation must be zero."); //Valida que el tamaño sea 1
    }

    @Test
    public void givenANewList_whenAddAtFront_thenSizeIsOne() {
        //Given:
        ArrayList<String> array = new ArrayList<>();

        array.addAtFront("Hola");

        //When:
        int sizeOfList = array.getSize();

        //Then:
        Assertions.assertEquals(1, sizeOfList);
        Assertions.assertEquals("Hola", array.getAt(0));
    }

    @Test
    public void givenAListWithOneElement_whenAddAtFront_thenSizeIsTwo() {
        //Given:
        ArrayList<String> array = new ArrayList<>();

        array.addAtFront("Hola");

        //When:
        array.addAtFront("Mundo");

        //Then:
        int sizeOfList = array.getSize();

        Assertions.assertEquals(2, sizeOfList);
        Assertions.assertEquals("Mundo", array.getAt(0));
        Assertions.assertEquals("Hola", array.getAt(1));
    }

    @Test
    public void givenANewList_whenAddAtTail_thenSizeIsOne() {
        //Given:
        ArrayList<String> array = new ArrayList<>();

        array.addAtTail("Hola");

        //When:
        int sizeOfList = array.getSize();

        //Then:
        Assertions.assertEquals(1, sizeOfList);
        Assertions.assertEquals("Hola", array.getAt(0));
    }

    @Test
    public void givenAListWithOneElement_whenAddAtTail_thenSizeIsTwo() {
        //Given:
        ArrayList<String> array = new ArrayList<>();

        array.addAtTail("Hola");

        //When:
        array.addAtTail("Mundo");

        //Then:
        int sizeOfList = array.getSize();

        Assertions.assertEquals(2, sizeOfList);
        Assertions.assertEquals("Hola", array.getAt(0));
        Assertions.assertEquals("Mundo", array.getAt(1));
    }

    @Test
    public void givenAListWithOneElement_whenRemove_thenSizeIsZero(){
        //Given:
        ArrayList<String> array = new ArrayList<>();
        array.addAtFront("Hola");

        //When:
        array.remove(0);

        //Then:
        int sizeOfList = array.getSize();

        Assertions.assertEquals(0,sizeOfList);
    }

    @Test
    public void givenAListWithTwoElements_whenRemove_thenSizeIsOne(){
        //Given:
        ArrayList<String> array = new ArrayList<>();
        array.addAtFront("Hola");
        array.addAtTail("Mundo");

        //When:
        array.remove(0);

        //Then:
        int sizeOfList = array.getSize();

        Assertions.assertEquals(1,sizeOfList);
        Assertions.assertEquals("Mundo",array.getAt(0));
    }


    @Test
    public void givenAListWithTwoElements_whenRemoveIndex1_thenSizeIsOne(){
        //Given:
        ArrayList<String> array = new ArrayList<>(); //Crea un objeto de la lista
        array.addAtFront("Hola");
        array.addAtTail("Mundo");

        //When:
        array.remove(1);

        //Then:
        int sizeOfList = array.getSize();

        Assertions.assertEquals(1,sizeOfList);
        Assertions.assertEquals("Hola",array.getAt(0));
    }

    @Test
    public void givenAListWithThreeElements_whenRemoveIndex1_thenSizeIsTwo(){
        //Given:
        ArrayList<String> array = new ArrayList<>(); //Crea un objeto de la lista

        array.addAtTail("Mundo");
        array.addAtTail("Cruel");
        array.addAtFront("Adiós");

        //When:
        array.remove(1);

        //Then:
        int sizeOfList = array.getSize();

        Assertions.assertEquals(2,sizeOfList);
        Assertions.assertEquals("Adiós",array.getAt(0));
        Assertions.assertEquals("Cruel",array.getAt(1));
    }

    @Test
    public void givenAListWithThreeElements_whenRemoveElementAtTail_thenSizeIsTwo(){
        //Given:
        ArrayList<String> array = new ArrayList<>(); //Crea un objeto de la lista

        array.addAtFront("Adiós");
        array.addAtTail("Mundo");
        array.addAtTail("Cruel");

        //When:
        array.remove(2);

        //Then:
        int sizeOfList = array.getSize();

        Assertions.assertEquals(2,sizeOfList);
        Assertions.assertEquals("Adiós",array.getAt(0));
        Assertions.assertEquals("Mundo",array.getAt(1));
    }

    @Test
    public void givenAListWithThreeElements_whenRemoveAll_thenSizeIsZero(){
        //Given:
        ArrayList<String> array = new ArrayList<>(); //Crea un objeto de la lista

        array.addAtFront("Adiós");
        array.addAtTail("Mundo");
        array.addAtTail("Cruel");

        //When:
        array.removeAll();

        //Then:
        int sizeOfList = array.getSize();

        Assertions.assertEquals(0,sizeOfList);
    }

    @Test
    public void givenAListWithTwoElements_whenSetAt_thenElementIsModified(){
        //Given:
        ArrayList<String> array = new ArrayList<>(); //Crea un objeto de la lista

        array.addAtTail("Mundo");
        array.addAtFront("Adiós");

        //When:
        array.setAt(0,"Hola");

        //Then:
        int sizeOfList = array.getSize();

        Assertions.assertEquals(2,sizeOfList);
        Assertions.assertEquals("Hola",array.getAt(0));
        Assertions.assertEquals("Mundo",array.getAt(1));
    }

    @Test
    public void givenAListWithThreeElements_whenGetIterator_thenIteratorWorksOverThreeElements(){
        //Given:
        ArrayList<String> array = new ArrayList<>(); //Crea un objeto de la lista

        array.addAtFront("Adiós");
        array.addAtTail("Mundo");
        array.addAtTail("Cruel");

        //When:
        Iterator<String> iterator = array.getIterator();

        //Then:
        int sizeOfList = array.getSize();

        Assertions.assertEquals(3,sizeOfList);
        Assertions.assertNotNull(iterator);
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Adiós",iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Mundo",iterator.next());
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals("Cruel",iterator.next());
        Assertions.assertFalse(iterator.hasNext());
    }
}