package CA;

import interfaces.IList;

import java.util.*;
import java.util.NoSuchElementException;

public class GenericCollections {

    public static <T extends Comparable<T>> void sort(IList<T> listToSort) {
        for (int i = 0; i < listToSort.size(); i++) //number of passes
        {
            //keeps track of positions per pass
            for (int j = 0; j < (listToSort.size() - 1 - i); j++) {
                //if left value is greater than right value
                if (listToSort.get(j).compareTo(listToSort.get(j + 1)) > 0) {
                    //swap values
                    T temp = listToSort.get(j);
                    listToSort.set(j, listToSort.get(j + 1));
                    listToSort.set(j + 1, temp);
                }
            }
        }
    }

    /**
     * Returns the maximum element of the given collection, according to the natural ordering
     of its elements.
     * @param list the collection whose maximum element is to be determined
     * @return the maximum element of the given collection, according to the natural ordering
    of its elements.
     * Throws:
     * NoSuchElementException - if the collection is empty.
     */

    public static <T extends Comparable<T>> T max(IList<T> list) {
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        }
        Iterator<T> iterator = list.iterator();
        T set = iterator.next();

        while (iterator.hasNext()) {
            T next = iterator.next();
            if (next.compareTo(set) > 0) {
                set = next;
            }
        }

        return set;
    }

    /**
     *
     * @param list the list to be rotated.
     * @param distance the distance to rotate the list. There are no constraints on this
     * value; it may be zero, negative, or greater than list.size().
     * @param <T>
     */

    public static <T extends Comparable<T>> void rotate(IList<T> list, int distance) {
        T remaining;
        int size = list.size();

        if(distance < 0) {
            distance = distance + size;

        }

        if(distance == 0) {
            return;
        }

        int i = 0;
        while(i < distance){
            remaining = list.get(size - 1);

            int j = size - 1;
            while(j > 0){
                T data = list.get(j - 1);
                list.set(j, data);
                j--;
            }
            list.set(0, remaining);
            i++;
        }

    }


    public static <T extends Comparable<T>> void rotate2(IList<T> list, int distance) {

        list.rotate2(distance);

    }

}
