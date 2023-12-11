package org.example;

import org.junit.jupiter.api.Test;

import static org.example.ConstantsSort.*;
import static org.junit.jupiter.api.Assertions.*;

class SortedMethodAnaliseTest {
    @Test
    public void whenMethodSort() {
        SortedMethod<Integer>[] methods = new SortedMethod[]{
                BUBBLE_SORT,
                SELECT_SORT,
                INSERT_SORT
        };
        SortedMethodAnalise<Integer> analise = new SortedMethodAnalise<>(ARRAY, methods);
        for (int i = 0; i < 10; i++) {
            System.out.println(analise.getFastMethod());
        }
    }

}