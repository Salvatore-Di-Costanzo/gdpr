package it.agilae.gdpr.model;

import it.agilae.gdpr.model.entity.IBaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_plt_stc_notifica_oggetto",schema = "gdpr")
public class Oggetto implements IBaseEntity, Comparable<Oggetto> {
    @Id
    @Column(name = "oggetto_id", unique = true, nullable = false)
    private @Getter
    @Setter
    Long oggetto_id;

    @Override
    public int compareTo(Oggetto oggetto) {
        return (getOggetto_id() != null && oggetto.getOggetto_id() != null) ? getOggetto_id().compareTo(oggetto.getOggetto_id()) : 0;
    }
}
