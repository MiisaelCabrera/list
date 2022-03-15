package uaslp.objects.list.linkedlist;
import uaslp.objects.list.Iterator;

public class LinkedListIterator<T> implements Iterator<T> {

    private Node<T> currentNode;

    LinkedListIterator(Node<T> startNode){
        currentNode=startNode;
    }

    @Override
    public boolean hasNext(){
        return currentNode != null;
    }

    @Override
    public T next(){
        T data= currentNode.data;

        currentNode=currentNode.next;

        return data;
        //return currentNode.data;
    }
}