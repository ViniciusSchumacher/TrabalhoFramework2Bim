package br.com.unipar.frameworks.model.dao;

import br.com.unipar.frameworks.model.Pet;
import br.com.unipar.frameworks.model.Cliente;
import br.com.unipar.frameworks.model.util.EntityManagerUtil;

import javax.persistence.EntityManager;

public class PetDAO extends GenericDAO<Pet> {

    public PetDAO() {
        super(Pet.class);
    }

    public void savePetWithCliente(Pet pet, Long idCliente) {
        EntityManager em = EntityManagerUtil.getManager(); // obtém o EntityManager
        em.getTransaction().begin();

        Cliente cliente = em.find(Cliente.class, idCliente);
        pet.setCliente(cliente);

        em.persist(pet);
        em.getTransaction().commit();
        em.close();
    }
}
