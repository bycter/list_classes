package org.example.myCollection;

import java.util.*;

public class LinkedListCustom<E> extends AbstractListCustom<E> implements ListCustom<E> {

    private int arraySize = 0;

    private Node<E> firstNode;

    private Node<E> lastNode;

    /**
     * Constructs an empty list.
     */
    public LinkedListCustom() {
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param newElements the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public LinkedListCustom(Collection<? extends E> newElements) {
        this();
        addAll(newElements);
    }

    /**
     * Returns element at the specified position in this list.
     *
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException – if the index is out of range (index < 0 || index >= size())
     */
    public E get(int index) {
        return getNode(index).element;
    }

    /**
     * Returns first element of this list.
     *
     * @return the first element of this list
     */
    public E getFirst() {
        return firstNode != null ? firstNode.element : null;
    }

    /**
     * Returns last element of this list.
     *
     * @return the last element of this list
     */
    public E getLast() {
        return lastNode != null ? lastNode.element : null;
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
        addAll(index, List.of(element));
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
        if (newElements.isEmpty()) {
            return;
        }

        checkPositionIndex(index, arraySize);

        Object[] objects = newElements.toArray();

        Node<E> firstNewNode = null;
        Node<E> lastNewNode = null;

        for (Object object : objects) {

            Node<E> currentNode = new Node<E>((E) object);

            if (firstNewNode == null) {
                firstNewNode = currentNode;
            }

            if (lastNewNode != null) {
                lastNewNode.nextNode = currentNode;
                currentNode.prevNode = lastNewNode;
            }

            lastNewNode = currentNode;
        }

        if (arraySize > 0) {

            if (index == 0) {
                lastNewNode.nextNode = firstNode;
                firstNode.prevNode = lastNewNode;
                firstNode = firstNewNode;

            } else if (index == arraySize) {
                firstNewNode.prevNode = lastNode;
                lastNode.nextNode = firstNewNode;
                lastNode = lastNewNode;

            } else {
                Node<E> positionNode = getNode(index);

                firstNewNode.prevNode = positionNode.prevNode;
                positionNode.prevNode.nextNode = firstNewNode;
                lastNewNode.nextNode = positionNode;
                positionNode.prevNode = lastNewNode;
            }

        } else {
            firstNode = firstNewNode;
            lastNode = lastNewNode;
        }

        arraySize = arraySize + objects.length;
    }

    /**
     * Replaces the element at the specified position in this list with the specified element.
     *
     * @param index   - index of the element to replace
     * @param element - element to be stored at the specified position
     * @throws IndexOutOfBoundsException – if the index is out of range (index < 0 || index >= size())
     */
    public void set(int index, E element) {
        Node<E> node = getNode(index);
        node.element = element;
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present.
     *
     * @param o - element to be removed from this list, if present
     */
    public void remove(Object o) {
        int foundIndex = -1;

        Node<E> currentNode = null;
        for (int i = 0; i < arraySize; i++) {

            if (currentNode == null) {
                currentNode = firstNode;
            } else {
                currentNode = currentNode.nextNode;
            }

            if (o == null) {
                if (currentNode.element == null) {
                    foundIndex = i;
                    break;
                }
            } else {
                if (o.equals(currentNode.element)) {
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

        unLinkNode(getNode(index));

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

        List<E> elements = new ArrayList<>();

        Node<E> currentNode = null;
        for (int i = 0; i < endIndex; i++) {

            if (currentNode == null) {
                currentNode = firstNode;
            } else {
                currentNode = currentNode.nextNode;
            }

            if (i >= startIndex) {
                elements.add(currentNode.element);
            }
        }
        return elements;
    }

    private void unLinkNode(Node<E> positionNode) {
        if (positionNode.prevNode == null) {
            positionNode = firstNode;
            firstNode = positionNode.nextNode;
            firstNode.prevNode = null;

        } else if (positionNode.nextNode == null) {
            positionNode = lastNode;
            lastNode = positionNode.prevNode;
            lastNode.nextNode = null;
        } else {
            positionNode.nextNode.prevNode = positionNode.prevNode;
            positionNode.prevNode.nextNode = positionNode.nextNode;
        }

        positionNode.prevNode = null;
        positionNode.nextNode = null;
        positionNode.element = null;
    }

    private Node<E> getNode(int index) {
        checkElementIndex(index, arraySize);

        if (index == 0) {
            return firstNode;
        } else if (index == (arraySize - 1)) {
            return lastNode;
        }

        Node<E> currentNode = null;
        for (int i = 0; i < index; i++) {

            if (currentNode == null) {
                currentNode = firstNode;
            } else {
                currentNode = currentNode.nextNode;
            }
        }
        return currentNode.nextNode;
    }

    /**
     * Inner private class for defining node object
     *
     * @param <E>
     */
    private static class Node<E> {

        E element;
        Node<E> prevNode;
        Node<E> nextNode;

        public Node(E element) {
            this.element = element;
        }
    }
}
