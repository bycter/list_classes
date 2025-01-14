package org.example.myCollection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ArrayListCustom<E> extends AbstractListCustom<E> implements ListCustom<E> {

    private Object[] arrayElements;

    private int arraySize;

    /**
     * Shared empty array instance used for empty instances.
     */
    private static final Object[] EMPTY_ARRAY = {};

    /**
     * Constructs an empty list with an initial capacity of zero.
     */
    public ArrayListCustom() {
        this.arrayElements = EMPTY_ARRAY;
        this.arraySize = 0;
    }

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param startCapacity the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *                                  is negative
     */
    public ArrayListCustom(int startCapacity) {
        this();
        if (startCapacity >= 0) {
            this.arrayElements = new Object[startCapacity];
        } else {
            throw new IllegalArgumentException("Wrong value of array capacity: " + startCapacity);
        }
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param newElements the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public ArrayListCustom(Collection<? extends E> newElements) {
        this();

        Object[] newElementsArray = newElements.toArray();
        if (newElementsArray.length > 0) {
            if (newElements.getClass() == ArrayList.class) {
                arrayElements = newElementsArray;
            } else {
                arrayElements = Arrays.copyOf(newElementsArray, newElementsArray.length, Object[].class);
            }
            arraySize = newElementsArray.length;
        }
    }

    /**
     * Returns element at the specified position in this list.
     *
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException – if the index is out of range (index < 0 || index >= size())
     */
    public E get(int index) {
        checkElementIndex(index, arraySize);

        return (E) arrayElements[index];
    }

    /**
     * Inserts the specified element at the end position in this list.
     *
     * @param element - element to be inserted
     * @throws IndexOutOfBoundsException – if the index is out of range (index < 0 || index > size())
     */
    public void add(E element) {
        add(arraySize, element);
    }

    /**
     * Inserts the specified element at the specified position in this list.
     *
     * @param index   - index at which the specified element is to be inserted
     * @param element - element to be inserted
     * @throws IndexOutOfBoundsException – if the index is out of range (index < 0 || index > size())
     */
    public void add(int index, E element) {
        checkPositionIndex(index, arraySize);

        Object[] elements = this.arrayElements;

        if (arraySize == elements.length) {
            elements = growArray();
        }

        System.arraycopy(elements,
                index,
                elements,
                index + 1,
                arraySize - index);

        elements[index] = element;
        arraySize = arraySize + 1;
    }

    /**
     * Inserts the specified elements at the end position in this list.
     *
     * @param newElements - elements to be inserted
     * @throws IndexOutOfBoundsException – if the index is out of range (index < 0 || index > size())
     */
    public void addAll(Collection<? extends E> newElements) {
        addAll(arraySize, newElements);
    }

    /**
     * Inserts the specified elements at the specified position in this list.
     *
     * @param index       - index at which the specified element is to be inserted
     * @param newElements - elements to be inserted
     * @throws IndexOutOfBoundsException – if the index is out of range (index < 0 || index > size())
     */
    public void addAll(int index, Collection<? extends E> newElements) {
        Object[] cArray = newElements.toArray();

        checkPositionIndex(index, arraySize);

        Object[] elements = this.arrayElements;

        if (arraySize + cArray.length >= elements.length) {
            elements = growArray(elements.length + cArray.length);
        }

        System.arraycopy(elements,
                index,
                elements,
                index + cArray.length,
                arraySize - index);

        System.arraycopy(cArray, 0, elements, index, cArray.length);
        arraySize = arraySize + cArray.length;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index   - index of the element to replace
     * @param element - element to be stored at the specified position
     * @throws IndexOutOfBoundsException – if the index is out of range (index < 0 || index >= size())
     */
    public void set(int index, E element) {
        checkElementIndex(index, arraySize);

        arrayElements[index] = element;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param o - element to be removed from this list, if present
     */
    public void remove(Object o) {
        int foundIndex = -1;
        for (int i = 0; i < arraySize; i++) {
            if (o == null) {
                if (arrayElements[i] == null) {
                    foundIndex = i;
                    break;
                }
            } else {
                if (o.equals(arrayElements[i])) {
                    foundIndex = i;
                    break;
                }
            }
        }
        if (foundIndex > -1) {
            remove(foundIndex);
        }
    }

    /**
     * Removes the element at the specified position in this list.
     *
     * @param index - the index of the element to be removed
     * @throws IndexOutOfBoundsException – if the index is out of range (index < 0 || index >= size())
     */
    public void remove(int index) {
        checkElementIndex(index, arraySize);

        Object[] elements = this.arrayElements;

        if ((arraySize - 1) > index) {
            System.arraycopy(elements,
                    index + 1,
                    elements,
                    index,
                    arraySize - index - 1);

        } else {
            arrayElements[index] = null;
        }

        arraySize = arraySize - 1;
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int size() {
        return arraySize;
    }

    /**
     * Returns a view of the portion of this list between the specified fromIndex and toIndex.
     * @param startIndex - start index for giving portion of elements
     * @param endIndex - end index for giving portion of elements
     * @return a list of elements
     * @throws  IndexOutOfBoundsException – for an illegal endpoint index value (fromIndex < 0 || toIndex > size || fromIndex > toIndex)
     * @throws IllegalArgumentException – if the endpoint indices are out of order (fromIndex > toIndex)
     */
    public List<E> subList(int startIndex, int endIndex) {
        subListRangeCheck(startIndex, endIndex, arraySize);

        int destArraySize = endIndex - startIndex;
        Object[] result = new Object[destArraySize];

        System.arraycopy(arrayElements,
                startIndex,
                result,
                0,
                destArraySize);

        return (List<E>) List.of(result);
    }

    private Object[] growArray() {
        return growArray(arraySize + 1);
    }

    private Object[] growArray(int capacityValue) {
        int currentSize = arrayElements.length;

        if (capacityValue > currentSize) {
            return arrayElements = Arrays.copyOf(arrayElements, capacityValue);
        }

        return arrayElements;
    }
}
