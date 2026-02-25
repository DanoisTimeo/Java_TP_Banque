package org.tds.epsib3;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("AssuranceVie")
public class AssuranceVie extends Compte {
    @Column(name = "taux", nullable = false)
    private Double taux;

    @Column(name = "dateFin", nullable = false)
    private LocalDateTime dateFin;

    //<editor-fold desc="Constructeurs">
    public AssuranceVie() {}

    public AssuranceVie(String numero, double solde, Double taux, LocalDateTime dateFin) {
        super(numero, solde);
        this.taux = taux;
        this.dateFin = dateFin;
    }

    //</editor-fold>

    //<editor-fold desc="Getter">
    public Double getTaux() {
        return taux;
    }

    public LocalDateTime getDateFin() {
        return dateFin;
    }
    //</editor-fold>

    //<editor-fold desc="Setter">
    public void setTaux(Double taux) {
        this.taux = taux;
    }

    public void setDateFin(LocalDateTime dateFin) {
        this.dateFin = dateFin;
    }
    //</editor-fold>
}
