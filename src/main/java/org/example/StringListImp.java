package org.example;

import org.exceptions.ElementNotFoundException;
import org.exceptions.IndexNotFoundException;
import org.exceptions.NotMethodSortException;
import org.exceptions.ParamNullException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class StringListImp<E> implements StringList<E> {
    private static final int CAPACITY = 10;
    private int size = 0;
    private Object[] elements;
    private SortedMethod<E> sortedMethod;
    private Comparator<Integer> binaryComparator;
    private Integer item;

    public StringListImp() {
        this.elements = new Object[CAPACITY];
    }
    public StringListImp(Integer[] elements) {
        this.elements = Arrays.copyOf(elements, elements.length);
        this.size = elements.length;
    }

    public StringListImp(Integer[] elements, SortedMethod<E> sortedMethod) {
        this(elements);
        this.sortedMethod = sortedMethod;
    }

    public StringListImp(Integer[] elements, SortedMethod<E> sortedMethod, Comparator<Integer> binaryComparator) {
        this(elements);
        this.sortedMethod = sortedMethod;
        this.binaryComparator = binaryComparator;
    }

    @Override
    public Integer add(Integer item) {
        validateElement(item);
        resizeArray();
        elements[size++] = item;
        return item;
    }

    @Override
    public Integer add(int index, Integer item) {
        validateElement(item);
        validateIndex(index);
        resizeArray();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = item;
        size++;
        return item;
    }

    @Override
    public Integer set(int index, Integer item) {
        validateIndex(index);
        validateElement(item);
        elements[index] =  item;
        return item;
    }

    @Override
    public Integer remove(Integer item) {
        validateElement(item);
        int index = indexOf(item);
        if (index < 0) {
            throw new ElementNotFoundException(
                    String.format(ElementNotFoundException.TEMPLATE_MESSAGE, item));
        }
        return remove(index);
    }

    @Override
    public Integer remove(int index) {
        validateIndex(index);
        E item = (E) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[size - 1] = null;
        size--;
        return (Integer) item;
    }

    @Override
    public boolean contains(Integer item) {
        validateElement(item);
        if (binaryComparator == null) {
            return indexOf(item) >= 0;
        }
        return containBinary(item);
    }

    @Override
    public int indexOf(Integer item) {
        validateElement(item);
        return IntStream.range(0, size)
                .filter(e -> elements[e].equals(item))
                .findFirst()
                .orElse(-1);
    }

    @Override
    public int lastIndexOf(Integer item) {
        validateElement(item);
        return IntStream.range(0, size)
                .map(e -> size - 1 - e)
                .filter(e -> elements[e].equals(item))
                .findFirst()
                .orElse(-1);
    }

    @Override
    public Integer get(int index) {
        validateIndex(index);
        return (Integer) elements[index];
    }

    @Override
    public boolean equals(StringList<E> otherList) {
        validateElement(otherList);
        return Arrays.equals(this.toArray(), otherList.toArray());
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        this.elements = new String[CAPACITY];
        size = 0;
    }

    @Override
    public Integer[] toArray() {
        return (Integer[]) Arrays.copyOf(elements, size);
    }

    @Override
    public void sort() {
        sort((Integer[])elements);
    }

    private void sort(Integer[] array) {
        if (sortedMethod == null) {
            throw new NotMethodSortException();
        }
        sortedMethod.getBiConsumer().accept((E[]) array, sortedMethod.getComparator());
    }

    private void resizeArray() {
        if (size >= elements.length) {
            elements = Arrays.copyOf(elements, elements.length + CAPACITY);
        }
    }

    private void validateIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexNotFoundException(
                    String.format(IndexNotFoundException.TEMPLATE_MESSAGE, index));
        }
    }

    private void validateElement(Object item) {
        if (item == null) {
            throw new ParamNullException();
        }
    }

    private boolean containBinary(Integer item) {
        this.item = item;
        Integer[] a = (Integer[]) Arrays.copyOf(elements, elements.length);
        sort(a);
        int min = 0;
        int max = a.length;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (a[mid].equals(item)) {
                return true;
            }
            if (binaryComparator.compare(item, a[mid]) < 0) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }
}