package com.list.partition;

import java.util.Collection;
import java.util.List;

public interface ListPartitionInterface<T> {
    public Collection<List<T>> partition(List<T> list, int chunkSize);
}
