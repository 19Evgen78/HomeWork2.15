package org.example;
public class ConstantsStringForTest {
    public static final Integer ONE = Integer.valueOf("one");
    public static final Integer TWO = Integer.valueOf("two");
    public static final Integer THREE = Integer.valueOf("three");
    public static final Integer FOUR = Integer.valueOf("four");
    public static final Integer FIVE = Integer.valueOf("five");
    public static final int INDEX_TWO = 2;
    public static final int INDEX_FIRST = 0;
    public static final int INDEX_LAST = 4;
    public static final int INDEX_NOT = -1;
    public static final Integer BETWEEN = Integer.valueOf("between");
    public static final Integer LAST = Integer.valueOf("last");
    public static final Integer FIRST = Integer.valueOf("first");
    public static final Integer ELEMENT1 = Integer.valueOf("element1");
    public static final Integer ELEMENT2 = Integer.valueOf("element2");
    public static final Integer ELEMENT3 = Integer.valueOf("element3");
    public static final Integer ELEMENT4 = Integer.valueOf("element4");
    public static final Integer ELEMENT5 = Integer.valueOf("element5");
    public static final Integer ELEMENT6 = Integer.valueOf("element6");

    public static final int SIZE_FiVE = 5;

    public static final Integer[] ARRAY_STRING_AFTER_REMOVE_LAST_INDEX = new Integer[]{
            ONE,
            TWO,
            THREE,
            FOUR,
    };

    public static final Integer[] ARRAY_STRING_WITH_BETWEEN_ELEMENT = new Integer[] {
            ONE,
            TWO,
            BETWEEN,
            THREE,
            FOUR,
            FIVE,
    };

    public static final Integer[] ARRAY_STRING_WITH_FIRST_ELEMENT = new Integer[] {
            FIRST,
            ONE,
            TWO,
            THREE,
            FOUR,
            FIVE,
    };

    public static final Integer[] ARRAY_STRING_WITH_LAST_ELEMENT = new Integer[] {
            ONE,
            TWO,
            THREE,
            FOUR,
            LAST,
            FIVE
    };

    public static final Integer[] ARRAY_STRING_ALL = new Integer[] {
            ONE,
            TWO,
            THREE,
            FOUR,
            FIVE,
            ELEMENT1,
            ELEMENT2,
            ELEMENT3,
            ELEMENT4,
            ELEMENT5
    };

    public static final Integer[] ARRAY_STRING_ALL_BETWEEN = new Integer[] {
            ONE,
            TWO,
            BETWEEN,
            THREE,
            FOUR,
            FIVE,
            ELEMENT1,
            ELEMENT2,
            ELEMENT3,
            ELEMENT4,
            ELEMENT5
    };

    public static final Integer[] ARRAY_STRING_FIRST_INDEX = new Integer[] {
            ONE,
            TWO,
            BETWEEN,
            THREE,
            BETWEEN,
            ELEMENT1
    };

    public static final Integer[] ARRAY_STRING_AFTER_REMOVE = new Integer[] {
            ONE,
            TWO,
            FOUR,
            FIVE,
    };
}
