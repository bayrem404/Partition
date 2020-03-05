package com.list.partition;

import com.list.partition.exception.NotAuthorizedSizeException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class ListPartitionTest {

    @InjectMocks
    private ListPartition listPartition;

    @Test
    public void partition_shouldReturnListsFromIntegerList() throws NotAuthorizedSizeException {
        List<Integer> l = Arrays.asList(1,2,3,4,5);
        Collection<List<Integer>> actual= listPartition.partition(l,2);
        assertThat(actual.size(), is(3));
    }

    @Test
    public void partition_shouldReturnListsFromStringList() throws NotAuthorizedSizeException {
        List<String> l = Arrays.asList("1","2","3","4","5","6");
        Collection<List<String>> actual= listPartition.partition(l,3);
        assertThat(actual.size(), is(2));
    }
    @Test
    public void partition_shouldReturnListsFromObjectList() throws NotAuthorizedSizeException {

        List<Object> l = Arrays.asList(new Object(),new String(),Long.valueOf(27), 32d, Boolean.valueOf(true));
        Collection<List<String>> actual= listPartition.partition(l,3);
        assertThat(actual.size(), is(2));
    }

    @Test
    public void partition_shouldReturnEmptyListFromEmptyList() throws NotAuthorizedSizeException {

        List<Object> l = Collections.emptyList();
        Collection<List<String>> actual= listPartition.partition(l,3);
        assertThat(actual.size(), is(0));
    }

    @Test
    public void partition_shouldThrowNotAuthorizedSizeExceptionWhenChunkSizeIsNegativeInt() throws NotAuthorizedSizeException {
        List<Object> l = Arrays.asList(new Object(),new String(),Long.valueOf(27), 32d, Boolean.valueOf(true));
        try {
            listPartition.partition(l, -3);
            fail();
        } catch (NotAuthorizedSizeException exception) {
            assertThat(exception.getMessage(), is("Negative size is not a valid size to perform the list partion."));
        }
    }

    @Test
    public void partition_shouldReturnOneListWhenListSizeISEqualToChunkSize() throws NotAuthorizedSizeException {
        List<Object> l = Arrays.asList(new Object(),new String(),Long.valueOf(27), 32d, Boolean.valueOf(true));
        Collection<List<String>> actual= listPartition.partition(l, 5);
        assertThat(actual.size(), is(1));
    }

    @Test
    public void partition_shouldReturnOneListWhenListSizeISLessThanChunkSize() throws NotAuthorizedSizeException {
        List<Object> l = Arrays.asList(new Object(),new String(),Long.valueOf(27), 32d, Boolean.valueOf(true));
        Collection<List<String>> actual= listPartition.partition(l, 8);
        assertThat(actual.size(), is(1));
    }

    @Test
    public void partition_shouldThrowNotAuthorizedSizeExceptionWhenChunkSizeIsZero() throws NotAuthorizedSizeException {
        List<Object> l = Arrays.asList(new Object(),new String(),Long.valueOf(27), 32d, Boolean.valueOf(true));
        try {
            listPartition.partition(l, 0);
            fail();
        } catch (NotAuthorizedSizeException exception) {
            assertThat(exception.getMessage(), is("zero is not a valid size to perform the list partion."));
        }
    }
}
