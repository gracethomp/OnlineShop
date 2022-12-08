package com.solvd.linkedList;

import com.solvd.entity.lists.WishList;
import org.apache.log4j.Logger;

public class MyLinkedList<T>  implements IStructure<T>{
    private Node<T> first;
    private Node<T> last;
    private int size;

    private static final Logger LOGGER = Logger.getLogger(MyLinkedList.class);

    @Override
    public void add(T toAdd) {
        Node<T> node = new Node<>(toAdd);
        size++;
        if(first == null) {
            first = node;
            first.setNext(last);
            last = node;
            last.setPrev(first);
            return;
        }
        last.setNext(node);
        node.setPrev(last);
        last = node;
    }

    public void add(T afterThat, T toAdd) {
        Node<T> node = search(afterThat);
        if(node == null){
            last.setNext(new Node<>(toAdd));
        }
    }

    @Override
    public void remove(T toRemove) {
        Node<T> node = search(toRemove);
        if(node != null){
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }
    }

    @Override
    public Node<T> search(T searchNode) {
        Node<T> node = first;
        while (!node.getValue().equals(searchNode)) {
            if(node.getNext() == null)
                break;
            node = node.getNext();
        }
        if(node.equals(last) && !last.getValue().equals(searchNode)) {
            LOGGER.warn("No such element in list");
            return null;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder("List: ");
        Node<T> current = first;
        while (current != null) {
            string.append(current);
            current = current.getNext();
            if(current != null)
                string.append(", ");
        }
        return string.toString();
    }
}
