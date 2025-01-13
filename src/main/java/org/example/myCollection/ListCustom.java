package org.example.myCollection;

import java.util.Collection;
import java.util.List;

public interface ListCustom<E> {

    void add(E element);

    void add(int index, E element);

    void addAll(Collection<? extends E> elements);

    void addAll(int index, Collection<? extends E> elements);

    void set(int index, E element);

    E get(int index);

    int size();

    void remove(Object o);

    void remove(int index);

    List<E> subList(int fromIndex, int toIndex);

    boolean equals(Object o);

    int hashCode();
}
