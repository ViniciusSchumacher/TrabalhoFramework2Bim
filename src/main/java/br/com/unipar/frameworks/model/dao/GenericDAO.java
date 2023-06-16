package br.com.unipar.frameworks.model.dao;

import br.com.unipar.frameworks.model.util.EntityManagerUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import java.util.List;

public abstract class GenericDAO<T> {

    private final Class<T> clazz;
    protected EntityManager em;

    // Logger inicializado para esta classe
    private static final Logger logger = LogManager.getLogger(GenericDAO.class);

    public GenericDAO(Class<T> clazz) {
        this.clazz = clazz;
        this.em = EntityManagerUtil.getManager();
    }

    public void fechar() {
        em.close();
        System.out.println("entity manager fechada!");
    }

    public T save(T entity) {
        try {
            em.getTransaction().begin();
            em.persist(entity);
            em.getTransaction().commit();
            logger.info("Objeto salvo com sucesso: " + entity);
        } catch (Exception e) {
            logger.error("Erro ao salvar o objeto: " + entity, e);
            JOptionPane.showMessageDialog(
                    null, "Ops, algo deu errado =( \n" + e);
        } finally {
            fechar();
        }

        return entity;
    }

    public T update(T entity) {
        try {
            em.getTransaction().begin();
            em.merge(entity);
            em.getTransaction().commit();
            logger.info("Objeto atualizado com sucesso: " + entity);
        } catch (Exception e) {
            logger.error("Erro ao atualizar o objeto: " + entity, e);
        } finally {
            fechar();
        }

        return entity;
    }

    public void delete(T entity) {
        try {
            em.getTransaction().begin();
            em.remove(entity);
            em.getTransaction().commit();
            logger.info("Objeto excluído com sucesso: " + entity);
        } catch (Exception e) {
            logger.error("Erro ao excluir o objeto: " + entity, e);
        } finally {
            fechar();
        }
    }

    public T findById(Long id) {
        try {
            T entity = em.find(clazz, id);
            logger.info("Objeto encontrado com o ID: " + id);
            return entity;
        } catch (Exception e) {
            logger.error("Erro ao encontrar o objeto com o ID: " + id, e);
            return null;
        }
    }

    public List<T> findAll() {
        try {
            String jpql = "from " + clazz.getSimpleName();
            TypedQuery<T> query = em.createQuery(jpql, clazz);
            logger.info("Todos os objetos foram encontrados com sucesso da classe: " + clazz.getSimpleName());
            return query.getResultList();
        } catch (Exception e) {
            logger.error("Erro ao encontrar todos os objetos da classe: " + clazz.getSimpleName(), e);
            return null;
        }
    }
}
