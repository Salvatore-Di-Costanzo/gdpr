package it.agilae.gdpr.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "gdpr.tbl_plt_dyn_registrazione",schema = "gdpr")
public class Registrazione {
    @Id
    @Column(name = "registrazione_id", unique = true, nullable = false)
    private @Getter @Setter Long registrazione_id;

    @Column(name = "spazio_nome", unique = true, nullable = false)
    private @Getter @Setter String spazio_nome;

    @Column(name = "data_registrazione", unique = true, nullable = false)
    private @Getter @Setter Date data_registrazione;

    @Column(name = "data_scadenza", unique = true, nullable = false)
    private @Getter @Setter Date data_scadenza;

    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;

    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;
    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;
    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;
    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;
    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;
    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;
    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;
    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;
    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;
    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;
    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;
    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;
    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;
    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;
    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;
    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;
    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;
    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;
    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;
    @Column(name = "utente_cognome", unique = true, nullable = false)
    private @Getter @Setter String utente_cognome;
}
