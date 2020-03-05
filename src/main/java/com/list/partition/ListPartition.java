package com.list.partition;

import com.list.partition.exception.NotAuthorizedSizeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ListPartition<T> implements ListPartitionInterface<T> {

    private Logger logger = LoggerFactory.getLogger(getClass());



    @Override
    public Collection<List<T>> partition(List<T> list, int chunkSize) throws NotAuthorizedSizeException {
        if (chunkSize < 0) {
            throw new NotAuthorizedSizeException("Negative size is not a valid size to perform the list partion.");
        }
        AtomicInteger counter = new AtomicInteger();

        try {
            logger.info("Partionning {} to sub lists of size at most {}",list, chunkSize);
            Collection<List<T>> partList = list.stream()
                    .collect(Collectors.groupingBy(it -> counter.getAndIncrement() / chunkSize))
                    .values();
            logger.info("Partition result is : {}", partList);
            return partList;
        } catch (ArithmeticException exception) {
            throw new NotAuthorizedSizeException("zero is not a valid size to perform the list partion.");
        }
    }
}
