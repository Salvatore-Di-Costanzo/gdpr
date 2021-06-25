package it.agilae.gdpr.stepUtils;

import it.agilae.gdpr.model.Notifica;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

public class BatchRead implements ItemReader<Notifica> {


    @Override
    public Notifica read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {

        return null;

    }
}
