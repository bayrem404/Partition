package com.list.partition;

import static org.junit.Assert.*;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.*;

@RunWith(MockitoJUnitRunner.class)
public class ListPartitionTest {

    @InjectMocks
    private ListPartition listPartition;

    @Test
    public void partition_shouldReturnListsFromIntegerList() {
        List<Integer> l = Arrays.asList(1,2,3,4,5);
        Collection<List<Integer>> actual= listPartition.partition(l,2);
        assertThat(actual.size(), Is.is(3));
    }

    @Test
    public void partition_shouldReturnListsFromStringList() {
        List<String> l = Arrays.asList("1","2","3","4","5","6");
        Collection<List<String>> actual= listPartition.partition(l,3);
        assertThat(actual.size(), Is.is(2));
    }
    @Test
    public void partition_shouldReturnListsFromObjectList() {

        List<Object> l = Arrays.asList(new Object(),new String(),Long.valueOf(27), 32d, Boolean.valueOf(true));
        Collection<List<String>> actual= listPartition.partition(l,3);
        assertThat(actual.size(), Is.is(2));
    }

    @Test
    public void partition_shouldReturnEmptyListFromEmptyList() {

        List<Object> l = Collections.emptyList();
        Collection<List<String>> actual= listPartition.partition(l,3);
        assertThat(actual.size(), Is.is(0));
    }

    @Test
    public void partition_shouldReturnListsWhenChunkSizeIsNegativeInt() {
        List<Object> l = Arrays.asList(new Object(),new String(),Long.valueOf(27), 32d, Boolean.valueOf(true));
        Collection<List<String>> actual= listPartition.partition(l, -3);
        assertThat(actual.size(), Is.is(2));
    }

    @Test
    public void partition_shouldReturnOneListWhenListSizeISEqualToChunkSize() {
        List<Object> l = Arrays.asList(new Object(),new String(),Long.valueOf(27), 32d, Boolean.valueOf(true));
        Collection<List<String>> actual= listPartition.partition(l, 5);
        assertThat(actual.size(), Is.is(1));
    }

    @Test
    public void partition_shouldReturnOneListWhenListSizeISLessThanChunkSize() {
        List<Object> l = Arrays.asList(new Object(),new String(),Long.valueOf(27), 32d, Boolean.valueOf(true));
        Collection<List<String>> actual= listPartition.partition(l, 8);
        assertThat(actual.size(), Is.is(1));
    }
}
