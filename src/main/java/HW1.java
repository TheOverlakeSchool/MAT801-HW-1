public class HW1 {

    /**
     * Returns the index of a particular value in an array of integers.
     *
     * The method should return the index of the first occurrence of the target value in the array. If the value is not
     * in the array, it should return -1. For example, if an array called list stores the following values:
     *
     * int[] list = {42, 7, -9, 14, 8, 39, 42, 8, 19, 0};
     *
     * Then the call indexOf(list, 8) should return 4 because the index of the first occurrence of value 8 in the array
     * is at index 4. The call indexOf(list, 2) should return -1 because value 2 is not in the array.
     */

    public static int indexOf(int[] list, int lookup) {

        for (int index = 0; index < list.length; index++)
        {
            if (list[index] == lookup)
                return index;
        }
        return -1;
    }

    /**
     * Accepts an array of integers as a parameter and prints the contents of the array to System.out as a bracketed,
     * comma-separated list.
     *
     * For example, if a variable called list stores the following values:
     *
     * int[] list = {3, 19, 27, 4, 98, 304, -9, 72};
     *
     * Then the call of print(list); should produce the following output:
     *
     * [3, 19, 27, 4, 98, 304, -9, 72]
     *
     * Your method should produce a complete line of output.
     */

    public static void print(int[] list) {
        System.out.print("[");
        for (int index = 0; index < list.length - 1; index++)
            System.out.print(list[index] + ", ");
        if (list.length > 0)
            System.out.print(list[list.length - 1]);
        System.out.print("]");
    }
    /**
     * Returns the minimum value in an array of integers.
     *
     * For example, if an array named list contains the values
     * {16, 12, 25, 44}, the call of findMin(list) should return 12. You may assume that the array has at least one
     * element.
     */

    public static int findMin(int[] list) {
        int min = list[0];
        for (int current: list)
            if (min > current)
                min = current;
        return min;
    }

    /**
     * Accepts a sorted array of integers as a parameter and returns the number of unique values in the array. The
     * array is guaranteed to be in sorted order, which means that duplicates will be grouped together.
     *
     * For example, if a variable called list stores the following values:
     *
     * int[] list = {5, 7, 7, 7, 8, 22, 22, 23, 31, 35, 35, 40, 40, 40, 41};
     *
     * then the call of numUnique(list) should return 9 because this list has 9 unique values
     * (5, 7, 8, 22, 23, 31, 35, 40 and 41).
     *
     * It is possible that the list might not have any duplicates. For example if list instead stored this sequence of
     * values:
     *
     * int[] list = {1, 2, 11, 17, 19, 20, 23, 24, 25, 26, 31, 34, 37, 40, 41};
     *
     * Then a call on the method would return 15 because this list contains 15 different values.
     *
     * If passed an empty list, your method should return 0. Remember that you can assume that the values in the array
     * appear in sorted (nondecreasing) order.
     */

    public static int numUnique(int[] list) {
        if (list.length == 0)
            return 0;
        int numDifferent = 0;
        int currentValue = list[0];
        boolean duplicate = false;
        for (int index = 0; index < list.length - 2; index++)
        {
            currentValue = list[index];
            duplicate = false;
            for (int index2 = 0; index2 < list.length - 1; index2++)
               if ((list[index2] == currentValue) && (index != index2)) {
                    duplicate = true;
                }
            if (duplicate == false)
                    numDifferent++;
        }
        return numDifferent;
    }

    /**
     * Accepts an array of integers as a parameter and returns a new array twice as large as the original, replacing
     * every integer from the original array with a pair of integers, each half the original. If a number in the
     * original array is odd, then the first number in the new pair should be one higher than the second so that the sum
     * equals the original number.
     *
     * For example, if a variable named list refers to an array storing the values {18, 7, 4, 24, 11}, the call of
     * stretch(list) should return a new array containing {9, 9, 4, 3, 2, 2, 12, 12, 6, 5}. (The number 18 is stretched
     * into the pair 9, 9, the number 7 is stretched into 4, 3, the number 4 is stretched into 2, 2, the number 24 is
     * stretched into 12, 12 and the number 11 is stretched into 6, 5.)
     */

    public static int[] stretch(int[] list) {
        int[] returnArray = new int[list.length * 2];
        for (int index = 0; index <list.length; index++)
        {
            returnArray[index*2] = (int) Math.ceil(((double)list[index])/2);
            returnArray[index*2+1] = (int) Math.floor(((double)list[index])/2);
        }
        return returnArray;
    }

    /**
     * Accepts an array of integers as a parameter and rotates the values in the array to the right (i.e., forward in
     * position) by one. Each element moves right by one, except the last element, which moves to the front.
     *
     * For example, if a variable named list refers to an array containing the values {3, 8, 19, 7}, the call of
     * rotateRight(list) should modify it to store {7, 3, 8, 19}. A subsequent call of rotateRight(list) would leave the
     * array as follows: {19, 7, 3, 8}
     */

    public static void rotateRight(int[] list) {
        int last = list[list.length - 1];
        for (int index = list.length - 1; index > 0; index--)
        {
            list[index] = list[index-1];
        }
        list[0] = last;
    }
}
