package org.tds.epsib3;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("Virement")
public class Virement extends Operation {
    @Column(name = "beneficiaire", nullable = false)
    private String beneficiaire;

    //<editor-fold desc="Constructeurs">
    public Virement() {}

    public Virement(LocalDateTime date, double montant, String motif, String beneficiaire) {
        super(date, montant, motif);
        this.beneficiaire = beneficiaire;
    }
    //</editor-fold>

    //<editor-fold desc="Getter">
    public String getBeneficiaire() {
        return beneficiaire;
    }
    //</editor-fold>

    //<editor-fold desc="Setter">
    public void setBeneficiaire(String beneficiaire) {
        this.beneficiaire = beneficiaire;
    }
    //</editor-fold>
}
