package com.solvd.linkedList;

public interface IStructure<T> {
    void add(T toAdd);
    void addToFront(T toAdd);
    boolean remove(T toRemove);
    Node<T> search(T searchNode);
    Node<T> get(int index);
}
