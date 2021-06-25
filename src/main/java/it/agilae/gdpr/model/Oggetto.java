package it.agilae.gdpr.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_plt_stc_notifica_oggetto",schema = "gdpr")
public class Oggetto {
    @Id
    @Column(name = "oggetto_id", unique = true, nullable = false)
    private @Getter @Setter Long notifica_id;

    @Column(name = "oggetto", unique = true, nullable = false)
    private @Getter @Setter String oggetto;

    @Column(name = "enabled", unique = true, nullable = false)
    private @Getter @Setter Boolean enabled;

}
