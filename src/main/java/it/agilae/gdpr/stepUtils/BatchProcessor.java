package it.agilae.gdpr.stepUtils;

import org.springframework.batch.item.ItemProcessor;

public class BatchProcessor<T> implements ItemProcessor<T,T> {
    @Override
    public T process(T t) throws Exception {
        return null;
    }
}
