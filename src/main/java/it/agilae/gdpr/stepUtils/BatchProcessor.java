package it.agilae.gdpr.stepUtils;

import org.springframework.batch.item.ItemProcessor;

public class BatchProcessor<Notifica> implements ItemProcessor<Notifica,Notifica> {
    @Override
    public Notifica process(Notifica notifica) throws Exception {
        return null;
    }
}
