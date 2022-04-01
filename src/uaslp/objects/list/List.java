package uaslp.objects.list;

import uaslp.objects.list.exception.NotNullValuesAllowedException;
import uaslp.objects.list.exception.NotValidIndexException;

public interface List<T>{

    void addAtTail(T data) throws NotNullValuesAllowedException;
    void addAtFront(T data) throws NotNullValuesAllowedException;
    void removeAll();
    void remove(int index)throws NotValidIndexException;
    void setAt(int index,T data) throws NotValidIndexException, NotNullValuesAllowedException ;
    T getAt(int index) throws NotValidIndexException;
    Iterator<T> getIterator();
    int getSize();

}