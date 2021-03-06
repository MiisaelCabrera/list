package uaslp.objects.list.arraylist;

import uaslp.objects.list.Iterator;
import uaslp.objects.list.List;
import uaslp.objects.list.exception.NotNullValuesAllowedException;
import uaslp.objects.list.exception.NotValidIndexException;

public class ArrayList<T> implements List<T> {
    private  static final int DEFAULT_SIZE = 2;
    private T[] array;
    private int size;

    public ArrayList(int size){
        array= (T[]) new Object[size];
    }

    public ArrayList(){
        array= (T[]) new Object[DEFAULT_SIZE];
    }

    @Override
    public void addAtTail(T data) throws NotNullValuesAllowedException{

        if(data == null){
            throw new NotNullValuesAllowedException();
        }

        if(size == array.length){
            increaseArrayList();
        }

        array[size]=data;
        size++;
    }

    @Override
    public void addAtFront(T data) throws NotNullValuesAllowedException{

        if(data == null){
            throw new NotNullValuesAllowedException();
        }

        if(size == array.length){
            increaseArrayList();
        }
        /*for(int i=0;i< array.length;i++){
            array[i+1]=array[i];
        }*/
        if (size >= 0) System.arraycopy(array, 0, array, 1, size);
        array[0]=data;
        size++;
    }

    @Override
    public void remove(int index){
        if (index < 0 || index >= size) {
            return;
        }

        /*for(int i=index;i<size-1;i++)
        {
            array[i]=array[i+1];
        }*/
        if (size - 1 - index >= 0) System.arraycopy(array, index + 1, array, index, size - 1 - index);
        array[size-1]=null;
        size--;
    }

    @Override
    public void removeAll(){
        for(int i=0;i<size;i++)
        {
            array[i]=null;
        }
        size=0;
    }

    @Override
    public T getAt(int index){
        return index >= 0 && index < size ? array[index] : null;
    }

    @Override
    public void setAt(int index,T data) throws NotNullValuesAllowedException {

        if(data == null){
            throw new NotNullValuesAllowedException();
        }

        if(index >= 0 && index < size)
        {
            array[index]=data;
        }
    }

    @Override
    public Iterator<T> getIterator(){
        return new ArrayListIterator<>(this);
    }

    /*
    public void removeAllWithValue(T data){

    }*/

    @Override
    public int getSize(){
        return size;
    }

    private void increaseArrayList(){
        T []newArray = (T[])new Object[array.length * 2];

        for(int i=0;i<size;i++){
            newArray[i]=array[i];
        }

        array=newArray;
    }
}