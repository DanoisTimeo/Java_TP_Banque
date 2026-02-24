package org.tds.epsib3;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Operation")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "montant", nullable = false)
    private double montant;

    @Column(name = "motif", length = 100, nullable = false)
    private String motif;

    @ManyToOne(optional = false)
    @JoinColumn(name = "compte_id", nullable = false)
    private Compte compte;

    //<editor-fold desc="Constructeurs">
    public Operation() {}

    public Operation(LocalDateTime date, double montant, String motif) {
        this.date = date;
        this.montant = montant;
        this.motif = motif;
    }
    //</editor-fold>

    //<editor-fold desc="Getter">
    public Integer getId() {
        return id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public double getMontant() {
        return montant;
    }

    public String getMotif() {
        return motif;
    }

    public Compte getCompte() {
        return compte;
    }
    //</editor-fold>

    //<editor-fold desc="Setter">
    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
    //</editor-fold>
}
