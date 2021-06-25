package it.agilae.gdpr.stepUtils;

import it.agilae.gdpr.model.Notifica;
import org.springframework.batch.item.*;

import java.util.List;

public class BatchWrite implements ItemWriter<Notifica> {

    @Override
    public void write(List<? extends Notifica> list) throws Exception {

    }
}