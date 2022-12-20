package com.solvd.linkedList;
import org.apache.log4j.Logger;

public class MyLinkedList<T>  implements IStructure<T>{
    private Node<T> first;
    private Node<T> last;
    private int size;

    private static final Logger LOGGER = Logger.getLogger(MyLinkedList.class);

    public static void testLinkedList() {
        MyLinkedList<String> myLinkedList = new MyLinkedList<>();
        LOGGER.info(myLinkedList.get(7));
        myLinkedList.add("1 string");
        myLinkedList.add("2 string");
        myLinkedList.add("3 string");
        LOGGER.info(myLinkedList);
        myLinkedList.remove("2 string");
        myLinkedList.add("3 string", "4 string");
        LOGGER.info(myLinkedList);
        LOGGER.info(myLinkedList.getSize());
        myLinkedList.add(2, "5 string");
        myLinkedList.add(2, "5 string");
        myLinkedList.add(2, "5 string");
        myLinkedList.add(3, "6 string");
        myLinkedList.add(0, "7 string");
        myLinkedList.add(7, "8 string");
        myLinkedList.addToFront("9 string");
        LOGGER.info(myLinkedList.get(7));
        LOGGER.info(myLinkedList);
        LOGGER.info(myLinkedList.getSize());
        for (int i = myLinkedList.getSize(); i >= 0; i--)
            LOGGER.info(myLinkedList.get(i));
    }

    @Override
    public void add(T toAdd) {
        size++;
        Node<T> node = new Node<>(toAdd);
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
        Node<T> afterThatNode = search(afterThat);
        helpToAdd(afterThatNode, toAdd);
    }

    public void add(int index, T toAdd) {
        Node<T> afterThatNode = get(index);
        helpToAdd(afterThatNode, toAdd);
    }

    @Override
    public void addToFront(T toAdd) {
        size++;
        Node<T> node = new Node<>(toAdd);
        node.setNext(first);
        first.setPrev(node);
        first = node;
    }

    @Override
    public Node<T> get(int index) {
        if(first == null || index < 0 || index > size) {
            LOGGER.warn("element can't be found");
            return null;
        }
        else {
            Node<T> current = first;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            return current;
        }
    }

    @Override
    public boolean remove(T toRemove) {
        Node<T> node = search(toRemove);
        if(node != null){
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            size--;
            return true;
        }
        return false;
    }

    @Override
    public Node<T> search(T searchNode) {
        Node<T> node = first;
        while (node != null && !node.getValue().equals(searchNode)) {
            if(node.getNext() == null)
                break;
            node = node.getNext();
        }
        if(node != null && node.equals(last) && !last.getValue().equals(searchNode)) {
            LOGGER.warn("No such element in list");
            return null;
        }
        return node;
    }

    public int getSize() {
        return size;
    }

    private void helpToAdd(Node<T> afterThatNode, T toAdd) {
        if(afterThatNode == null || afterThatNode.getNext() == null){
            add(toAdd);
        } else  {
            size++;
            Node<T> toInsert = new Node<>(toAdd);
            toInsert.setNext(afterThatNode.getNext());
            afterThatNode.getNext().setPrev(toInsert);
            afterThatNode.setNext(toInsert);
            toInsert.setPrev(afterThatNode);
        }
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
