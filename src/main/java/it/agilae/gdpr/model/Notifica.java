package it.agilae.gdpr.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_plt_dyn_notifica", schema = "gdpr")
public class Notifica {

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
    private @Getter @Setter Long oggetto_id;
}
