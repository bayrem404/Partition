package com.list.partition;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ListPartition<T> implements ListPartitionInterface<T> {

    @Override
    public Collection<List<T>> partition(List<T> list, int chunkSize) {
        AtomicInteger counter = new AtomicInteger();
        return list.stream()
                .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / chunkSize))
                .values();
    }
}
