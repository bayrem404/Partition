package com.list.partition;

import com.list.partition.exception.NotAuthorizedSizeException;

import java.util.Collection;
import java.util.List;

public interface ListPartitionInterface<T> {
    /**
     * returns a collection of sublists, where each sublist is at most <b>sizchunkSize</b> of elements.
     * @param list
     * @param chunkSize
     * @return Collection of List
     */
    public Collection<List<T>> partition(List<T> list, int chunkSize) throws NotAuthorizedSizeException;
}
