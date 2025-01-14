package org.example.myCollection;

import java.util.Collection;
import java.util.List;

public abstract class AbstractListCustom<E> {

    public abstract int size();

    public abstract E get(int index);

    public void add(E e) {
        add(size(), e);
    }

    public void add(int index, E element) {
        throw new UnsupportedOperationException();
    }

    public void addAll(Collection<? extends E> elements) {
        throw new UnsupportedOperationException();
    }

    public void addAll(int index, Collection<? extends E> elements) {
        throw new UnsupportedOperationException();
    }

    public void set(int index, E element) {
        throw new UnsupportedOperationException();
    }

    public void remove(Object o) {
        throw new UnsupportedOperationException();
    }

    public void remove(int index) {
        throw new UnsupportedOperationException();
    }

    public List<E> subList(int startIndex, int endIndex) {
        subListRangeCheck(startIndex, endIndex, size());
        throw new UnsupportedOperationException();
    }


    static void checkElementIndex(int index, int arraySize) {
        if (index < 0 || index >= arraySize) {
            throw new IndexOutOfBoundsException("Wrong array index (" + index + ")");
        }
    }

    static void checkPositionIndex(int index, int arraySize) {
        if (index < 0 || index > arraySize) {
            throw new IndexOutOfBoundsException("Wrong array index (" + index + ")");
        }
    }

    static void subListRangeCheck(int startIndex, int endIndex, int size) {
        String startIndexStr = "startIndex(" + startIndex + ")";
        String endIndexStr = "endIndex(" + endIndex + ")";

        if (startIndex < 0)
            throw new IndexOutOfBoundsException(startIndexStr + " should be greater than 0");
        if (endIndex > size)
            throw new IndexOutOfBoundsException(endIndexStr + " should be less than size of array = \"" + size + "\"");
        if (startIndex > endIndex)
            throw new IllegalArgumentException("Incorrect parameter values. " + startIndexStr + " should be greater than " + endIndexStr);
    }

}