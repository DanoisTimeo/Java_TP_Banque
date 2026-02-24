package org.tds.epsib3;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Compte")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TYPE")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "numero", length = 100, nullable = false)
    private String numero;

    @Column(name = "solde", nullable = false)
    private double solde;

    // Relation vers Client
    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id", nullable = false)
    private Client client;

    @OneToMany(mappedBy = "compte", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Operation> operations;

    //<editor-fold desc="Constructeurs">
    public Compte() {}

    public Compte(String numero, double solde, Client client) {
        this.numero = numero;
        this.solde = solde;
        this.client = client;
    }
    //</editor-fold>

    //<editor-fold desc="Getter">
    public Integer getId() {
        return id;
    }

    public String getNumero() {
        return numero;
    }

    public double getSolde() {
        return solde;
    }

    public Client getClient() {
        return client;
    }

    public List<Operation> getOperations() {
        return operations;
    }
    //</editor-fold>

    //<editor-fold desc="Setter">
    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setOperations(List<Operation> operations) {
        this.operations = operations;
    }
    //</editor-fold>
}
