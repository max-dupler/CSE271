import java.util.Arrays;

/**
 * Methods to apply some of the concepts of searching and sorting for
 * problem-solving. These problems are commonly asked on Job-interviews and
 * hence also included in exams.
 */
public class SearchSort {
    /**
     * Complete the following insert method that must create a new list that
     * contains all the elements in list and the given item inserted
     * appropriately into the new list. Assume that the original list is
     * initially sorted in descending order (i.e., from largest to smallest).
     * For example insert({2,3,5,6}, 4) should return new list containing the
     * values {2,3,4,5,6}.
     * 
     * @see Arrays.binarySearch
     * @see System.arraycopy
     * 
     * @param list Sorted (in descending order) list of values. Do not modify
     *             this list.
     * @param item The item to be inserted into the newly created list.
     * @return A new sorted list (in descending order) with the item inserted at
     *         the appropriate location.
     */
    public static int[] insert(int[] list, int item) {
        int[] newList = new int[list.length + 1];
        // checks if item would be the lowest or highest value in the array

        boolean keepGoing = true;

        for (int i = 0; i < newList.length; i++) {
            if (keepGoing) {
                if (i == newList.length - 1 || list[i] > item) {
                    newList[i] = item;
                    keepGoing = false;
                } else {
                    newList[i] = list[i];
                }
            } else {
                newList[i] = list[i - 1];
            }
        }

        return newList;
    }

    /**
     * Implement this method to counts how many value occur in both list1 and
     * list2. Assume both lists are sorted in ascending order. Also assume that
     * neither list1 nor list2 has any duplicates in itself. For example
     * countDuplicates({1,2,4,5}, {2,3,5,6}) should return 2 (since both lists
     * contain the numbers 2 and 5). You are expected to achieve this task
     * without making multiple passes over either list (your code should only
     * have a single loop)
     * 
     * @note Your implementation must be O(n).
     * 
     * @param list1 The first sorted list. Do not modify.
     * @param list2 The second sorted list. Do not modify.
     * @return The number of values that occur in both lists.
     */
    public static int countDuplicates(int[] list1, int[] list2) {
        // find bigger and smaller array
        int[] big = list1.length > list2.length ? list1 : list2;
        int[] small = list1.length > list2.length ? list2 : list1;

        // duplicate count
        int count = 0;

        // holds the position of small and big array
        int bigCount = 0;
        int smallCount = 0;

        while (bigCount < big.length && smallCount < small.length) {
            if (big[bigCount] == small[smallCount]) {
                count++;
                smallCount++;
                bigCount++;
            } else {
                if (big[bigCount] > small[smallCount]) {
                    smallCount++;
                } else {
                    bigCount++;
                }
            }
        }

        return count;
    }
}
