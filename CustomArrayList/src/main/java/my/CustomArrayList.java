package my;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;

public class CustomArrayList<T> {

    private T[] arr;
    private int size = 0;
    private final int DEFAULTCAPACITY = 3;
    private int capacity = DEFAULTCAPACITY;


    public CustomArrayList() {
        arr = (T[]) new Object[DEFAULTCAPACITY];
    }

    public CustomArrayList(int capacity) {
        if (capacity <= 0) throw new IllegalArgumentException("CAPACITY <= 0");
        else arr = (T[]) new Object[capacity];
    }

    public void add(T element) {
        if (size + 1 > capacity) resize(arr);
        arr[size++] = element;
    }

    public void add(int index, T element) {
        if (size + 1 > capacity) resize(arr);
        if (index >= size) throw new ArrayIndexOutOfBoundsException("Index out of Array");
        else {
            for (int i = size; i > index; i--) arr[i] = arr[i - 1];
            arr[index] = element;
            size++;
        }
    }

    public void addAll(Collection<? extends T> list) {
        if (size + list.size() > capacity) resize(arr);
        for (T x : list) this.add(x);
    }

    public void remove(int index) {
        if (index >= size) throw new ArrayIndexOutOfBoundsException("Index out of Array");
        else {
            for (int i = index; i < size; i++) arr[i] = arr[i + 1];
            size--;
            arr[size] = null;
        }
    }

    public void remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (arr[i].equals(o)) remove(i);
        }
    }

    public void clear() {
        for (int i = 0; i < getSize(); i++) arr[i] = null;
        size = 0;
    }

    public T get(int index) {
        return arr[index];
    }

    public boolean isEmpty() {
        if (getSize() == 0) return true;
        else return false;
    }

    public void sort(Comparator<T> comparator) {
        int low = 0;
        int high = size - 1;
        quickSort(comparator, low, high);
    }

    private void quickSort(Comparator<T> comparator, int low, int high) {
        if (size == 0 || low >= high) return;

        int middle = low + (high - low) / 2;
        T mid = arr[middle];

        int i = low;
        int j = high;
        while (i <= j) {

            while (comparator.compare(mid, arr[i]) > 0) i++;
            while (comparator.compare(mid, arr[j]) < 0) j--;

            if (i <= j) {
                T swap = arr[i];
                arr[i] = arr[j];
                arr[j] = swap;
                i++;
                j--;
            }
        }
        if (low < j) quickSort(comparator, low, j);
        if (high > i) quickSort(comparator, i, high);
    }

    public int getSize() {
        return size;
    }

    public void resize(T[] arr) {
        capacity *= 2;
        T[] tempArr = (T[]) new Object[capacity];
        System.arraycopy(arr, 0, tempArr, 0, size);
        this.arr = tempArr;
        tempArr = null;
    }

    @Override
    public String toString() {
        return "CustomArrayList" + Arrays.toString(arr);
    }
}
