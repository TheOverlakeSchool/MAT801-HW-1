import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class HW1Test {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    HW1 hw1 = new HW1();

    @BeforeAll
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    public void restoreStreams() {
        System.setOut(originalOut);
    }

    @ParameterizedTest
    @MethodSource
    void testIndexOf(int[] list, int lookup, int expected) {
        int actual = hw1.indexOf(list, lookup);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource
    void testPrint(int[] list, String expected) {
        outContent.reset();
        hw1.print(list);
        assertEquals(expected, outContent.toString());
    }

    @ParameterizedTest
    @MethodSource
    void testFindMin(int[] list, int expected) {
        int actual = hw1.findMin(list);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource
    void testNumUnique(int[] list, int expected) {
        int actual = hw1.numUnique(list);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource
    void testStretch(int[] list, int[] expected) {
        int[] actual = hw1.stretch(list);
        assertArrayEquals(actual, expected);
    }

    @ParameterizedTest
    @MethodSource
    void testRotateRight(int[] list, int[] expected) {
        hw1.rotateRight(list);
        assertArrayEquals(list, expected);
    }

    private static Stream<Arguments> testIndexOf() {
        return Stream.of(
                Arguments.of(new int[]{42, 7, -9, 14, 8, 39, 42, 8, 19, 0}, 8, 4),
                Arguments.of(new int[]{42, 7, -9, 14, 8, 39, 42, 8, 19, 0}, 2, -1),
                Arguments.of(new int[]{74, 85, 102, 99, 101, 85, 56}, 85, 1),
                Arguments.of(new int[]{74, 85, 102, 99, 101, 85, 56}, 58, -1),
                Arguments.of(new int[]{12, 34, 56, 90, 78, 24, 68, 10}, 90, 3),
                Arguments.of(new int[]{10, 34, 56, 10, 90, 10, 68, 10}, 10, 0),
                Arguments.of(new int[]{4, 4}, 4, 0),
                Arguments.of(new int[]{42}, 42, 0),
                Arguments.of(new int[]{42}, 24, -1),
                Arguments.of(new int[]{}, 42, -1)
        );
    }

    private static Stream<Arguments> testPrint() {
        return Stream.of(
                Arguments.of(new int[]{3, 19, 27, 4, 98, 304, -9, 72}, "[3, 19, 27, 4, 98, 304, -9, 72]"),
                Arguments.of(new int[]{42, 7, -9, 14, 8, 39, 42, 8, 19, 0}, "[42, 7, -9, 14, 8, 39, 42, 8, 19, 0]"),
                Arguments.of(new int[]{4, 4}, "[4, 4]"),
                Arguments.of(new int[]{42}, "[42]"),
                Arguments.of(new int[]{}, "[]")
        );
    }

    private static Stream<Arguments> testFindMin() {
        return Stream.of(
                Arguments.of(new int[]{16, 12, 25, 44}, 12),
                Arguments.of(new int[]{1, 2, 3, 4}, 1),
                Arguments.of(new int[]{4, 17, -9, 3, -2, 21}, -9),
                Arguments.of(new int[]{42}, 42)
        );
    }

    private static Stream<Arguments> testNumUnique() {
        return Stream.of(
                Arguments.of(new int[]{5, 7, 7, 7, 8, 22, 22, 23, 31, 35, 35, 40, 40, 40, 41}, 9),
                Arguments.of(new int[]{1, 2, 11, 17, 19, 20, 23, 24, 25, 26, 31, 34, 37, 40, 41}, 15),
                Arguments.of(new int[]{2, 4, 6}, 3),
                Arguments.of(new int[]{}, 0),
                Arguments.of(new int[]{1}, 1),
                Arguments.of(new int[]{1, 3, 3}, 2),
                Arguments.of(new int[]{-4, -2, 2, 4, 6, 8, 10, 12}, 8),
                Arguments.of(new int[]{-4, -2, 2, 4, 6, 8, 10, 12, 12}, 8),
                Arguments.of(new int[]{-4, -4, -2, 2, 4, 6, 8, 10, 12}, 8),
                Arguments.of(new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1}, 2)
        );
    }

    private static Stream<Arguments> testStretch() {
        return Stream.of(
                Arguments.of(new int[]{18, 7, 4, 24, 11}, new int[]{9, 9, 4, 3, 2, 2, 12, 12, 6, 5}),
                Arguments.of(new int[]{87, 14, 67, 3, 0, 1, 19, 29}, new int[]{44, 43, 7, 7, 34, 33, 2, 1, 0, 0, 1, 0, 10, 9, 15, 14}),
                Arguments.of(new int[]{42}, new int[]{21, 21}),
                Arguments.of(new int[]{}, new int[]{})
        );
    }
    private static Stream<Arguments> testRotateRight() {
        return Stream.of(
                Arguments.of(new int[]{3, 8, 19, 7}, new int[]{7, 3, 8, 19}),
                Arguments.of(new int[]{10, 20, 30, 40, 50, 60, 70}, new int[]{70, 10, 20, 30, 40, 50, 60}),
                Arguments.of(new int[]{100, 200}, new int[]{200, 100}),
                Arguments.of(new int[]{42}, new int[]{42})
        );
    }
}