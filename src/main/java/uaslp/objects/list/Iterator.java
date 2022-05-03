package uaslp.objects.list;

import uaslp.objects.list.exception.NotValidIndexException;

public interface Iterator <T>{
    boolean hasNext();
    T next() throws NotValidIndexException;
}