package it.agilae.gdpr.stepUtils;

import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class BatchRead<T> implements ItemReader<T> {


    @Override
    public T read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {


    }
}
