package org.tds.epsib3;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("LivretA")
public class LivretA extends Compte {
    @Column(name = "taux", nullable = false)
    private Double taux;

    //<editor-fold desc="Constructeurs">
    public LivretA () {}

    public LivretA(String numero, double solde, Double taux) {
        super(numero, solde);
        this.taux = taux;
    }
    //</editor-fold>

    //<editor-fold desc="Getter">
    public Double getTaux() {
        return taux;
    }
    //</editor-fold>

    //<editor-fold desc="Setter">
    public void setTaux(Double taux) {
        this.taux = taux;
    }
    //</editor-fold>
}
