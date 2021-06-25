package it.agilae.gdpr.stepUtils;

import it.agilae.gdpr.model.Notifica;
import org.springframework.batch.item.ItemProcessor;

public class BatchProcessor implements ItemProcessor<Notifica,Notifica> {
    @Override
    public Notifica process(Notifica notifica) throws Exception {
        return notifica;
    }
}
