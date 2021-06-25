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
@Table(name = "tbl_plt_dyn_notifica", schema = "gdpr")
public class Notifica implements IBaseEntity, Comparable<Notifica>
{

    private static final long serialVersionUID = 52841885384393932L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence")
    @SequenceGenerator(name = "sequence", allocationSize = 1, sequenceName = "seq_tnt_dyn_referente_contatto_id",schema = "gdpr")
    @Column(name = "notifica_id", unique = true, nullable = false)
    private @Getter @Setter Long notifica_id;

    @Column(name = "testo", nullable = false)
    private @Getter @Setter String referenteId;

    @Column(name = "numero_tentativi", nullable = false)
    private @Getter @Setter short numero_tentativi;

    @Column(name = "oggetto_id", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="oggetto_id", referencedColumnName="oggetto_id", nullable = false)
    private @Getter @Setter Oggetto oggetto_id;

    @Column(name = "tipologia_id", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="tipologia_id", referencedColumnName="tipologia_id", nullable = false)
    private @Getter @Setter Oggetto tipologia_id;

    @Column(name = "stato_id", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="stato_id", referencedColumnName="stato_id", nullable = false)
    private @Getter @Setter Oggetto stato_id;

    @Column(name = "utente_id", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="utente_id", referencedColumnName="utente_id", nullable = false)
    private @Getter @Setter Oggetto utente_id;

    @Column(name = "registrazione_id", nullable = false)
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="registrazione_id", referencedColumnName="registrazione_id", nullable = false)
    private @Getter @Setter Oggetto registrazione_id;

    @Override
    public int compareTo(Notifica notifica) {
        return (getNotifica_id() != null && notifica.getNotifica_id() != null) ? getNotifica_id().compareTo(notifica.getNotifica_id()) : 0;
    }
}
