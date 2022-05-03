package uaslp.objects.list;

import uaslp.objects.list.exception.NotNullValuesAllowedException;
import uaslp.objects.list.exception.NotValidIndexException;

public interface Set<T>{
    void add(T element) throws NotNullValuesAllowedException, NotValidIndexException;
    void remove(T element) throws NotValidIndexException;
    boolean contains(T element) throws NotValidIndexException;
    Iterator<T> iterator();
    int size();

}