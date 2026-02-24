package org.tds.epsib3;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu"); EntityManager em = emf.createEntityManager();) {
            em.getTransaction().begin();

            Banque banque = new Banque();
            banque.setNom("BNP");

            Client client = new Client();
            client.setNom("Dupont");
            client.setPrenom("Jean");
            client.setDateNaissance(LocalDate.of(1990, 1, 1));
            client.setBanque(banque);

            Compte compte = new LivretA();
            compte.setNumero("A123");
            compte.setSolde(1000);
            compte.setClient(client);

            em.persist(banque);

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("oups");
            throw new RuntimeException(e);
        }
    }
}