package org.example;

import org.exceptions.ElementNotFoundException;
import org.exceptions.IndexNotFoundException;
import org.exceptions.ParamNullException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.example.ConstantsIntegerForTest.ELEVEN_N;
import static org.example.ConstantsIntegerForTest.NUMS;
import static org.example.ConstantsSort.*;
import static org.example.ConstantsStringForTest.*;
import static org.junit.jupiter.api.Assertions.*;

class StringListImpTest {

    public static Stream<Arguments> getParamsForAddIndexTest() {
        return Stream.of(
                Arguments.of(INDEX_TWO, BETWEEN, ARRAY_STRING_WITH_BETWEEN_ELEMENT, ARRAY_STRING_ALL),
                Arguments.of(INDEX_FIRST, FIRST, ARRAY_STRING_WITH_FIRST_ELEMENT, ARRAY_STRING_ALL),
                Arguments.of(INDEX_LAST, LAST, ARRAY_STRING_WITH_LAST_ELEMENT, ARRAY_STRING_ALL),
                Arguments.of(INDEX_TWO, BETWEEN, ARRAY_STRING_ALL_BETWEEN, ARRAY_STRING_ALL)
        );
    }
    @ParameterizedTest
    @MethodSource("getParamsForAddIndexTest")
    void whenAddIndexThenEqualsArrays(int index, Integer item, String[] expect, Integer[] arr) {
        StringList<String> listImp = new StringListImp<>(arr);
        listImp.add(index, item);
        assertArrayEquals(listImp.toArray(), expect);
    }

    @Test
    public void whenFindIndexThenIndex() {
        StringList<String> listImp = new StringListImp<>(ARRAY_STRING_FIRST_INDEX);
        assertEquals(INDEX_TWO, listImp.indexOf(BETWEEN));
    }

    @Test
    public void whenFindIndexThenNotIndex() {
        StringList<String> listImp = new StringListImp<>(ARRAY_STRING_FIRST_INDEX);
        assertEquals(ConstantsStringForTest.INDEX_NOT, listImp.indexOf(FIVE));
    }

    @Test
    public void whenFindLastIndexThenIndex() {
        StringList<String> listImp = new StringListImp<>(ARRAY_STRING_FIRST_INDEX);
        assertEquals(ConstantsStringForTest.INDEX_LAST, listImp.lastIndexOf(BETWEEN));
    }

    @Test
    public void whenAddElementThenAddSize() {
        StringList<String> listImp = new StringListImp<>();
        Arrays.stream(ARRAY_STRING_ALL).forEach(listImp::add);
        assertEquals(SIZE_FiVE, listImp.size());
    }

    @Test
    public void whenAddElementThenEqualArray() {
        StringList<String> listImp = new StringListImp<>();
        Arrays.stream(ARRAY_STRING_ALL).forEach(listImp::add);
        assertTrue(listImp.equals(new StringListImp<>(ARRAY_STRING_ALL)));
    }

    @Test
    public void whenGetForIndexThenElement() {
        StringList<String> listImp = new StringListImp<>();
        Arrays.stream(ARRAY_STRING_ALL).forEach(listImp::add);
        assertEquals(THREE, listImp.get(INDEX_TWO));
    }

    @Test
    public void whenRemoveForIndexThenElement() {
        StringList<String> listImp = new StringListImp<>(ARRAY_STRING_ALL);
        assertEquals(THREE, listImp.remove(INDEX_TWO));
        assertArrayEquals(ARRAY_STRING_AFTER_REMOVE, listImp.toArray());
    }

    @Test
    public void whenRemoveForNameThenElement() {
        StringList<String> listImp = new StringListImp<>(ARRAY_STRING_ALL);
        assertEquals(THREE, listImp.remove(THREE));
        assertArrayEquals(ARRAY_STRING_AFTER_REMOVE, listImp.toArray());
    }

    @Test
    public void whenAddNullThenException() {
        StringList<String> listImp = new StringListImp<>();
        assertThrows(ParamNullException.class, () -> listImp.add(null));
    }

    @Test
    public void whenInsertElementThenException() {
        StringList<String> listImp = new StringListImp<>(ARRAY_STRING_ALL);
        assertThrows(IndexNotFoundException.class, () -> listImp.add(INDEX_NOT, BETWEEN));
    }

    @Test
    public void whenRemoveLastIndex() {
        StringList<String> listImp = new StringListImp<>(ARRAY_STRING_ALL);
        listImp.remove(INDEX_LAST);
        assertArrayEquals(ARRAY_STRING_AFTER_REMOVE_LAST_INDEX, listImp.toArray());
    }

    @Test
    public void whenRemoveItemThenException() {
        StringList<String> listImp = new StringListImp<>(ARRAY_STRING_ALL);
        assertThrows(ElementNotFoundException.class, () -> listImp.remove(ELEMENT1));
    }

    @Test
    public void whenAddElementThenGetLastElement() {
        StringList<Integer> stringList = new StringListImp<>(NUMS);
        stringList.add(ELEVEN_N);
        assertEquals(ELEVEN_N, stringList.get(stringList.size() - 1));
    }

    @Test
    public void whenEqualsNumsThen() {
        StringList<Integer> stringList = new StringListImp<>(NUMS);
        assertArrayEquals(NUMS, stringList.toArray());
    }

    @Test
    public void whenSortBubbleThenEqualSortArray() {
        StringListImp<Integer> stringList = new StringListImp<>(TEST_ARRAY, BUBBLE_SORT);
        stringList.sort();
        assertArrayEquals(SORT_ARRAY, stringList.toArray());
    }

    @Test
    public void whenSortSelectThenEqualSortArray() {
        StringListImp<Integer> stringList = new StringListImp<>(TEST_ARRAY, SELECT_SORT);
        stringList.sort();
        assertArrayEquals(SORT_ARRAY, stringList.toArray());
    }

    @Test
    public void whenSortInsertThenEqualSortArray() {
        StringListImp<Integer> stringList = new StringListImp<>(TEST_ARRAY, INSERT_SORT);
        stringList.sort();
        assertArrayEquals(SORT_ARRAY, stringList.toArray());
    }

    @Test
    public void whenContainElement() {
        StringList<Integer> stringList = new StringListImp<>(TEST_ARRAY, INSERT_SORT, BINARY_COMPARATOR);
        assertTrue(stringList.contains(NUM_FOR_TEST_ARRAY));
    }
}