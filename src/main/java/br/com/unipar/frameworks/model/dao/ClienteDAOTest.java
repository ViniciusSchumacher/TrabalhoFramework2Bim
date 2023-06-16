package br.com.unipar.frameworks.model.dao;

import br.com.unipar.frameworks.model.Cliente;
import br.com.unipar.frameworks.model.util.EntityManagerUtil;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;

import static org.junit.jupiter.api.Assertions.*;

//Classe criada para fazer um teste de unidade como solicitado pela professora.
//Classe funcional no IntelliJ
public class ClienteDAOTest {

    @Test
    public void testFindById() {
        EntityManager em = EntityManagerUtil.getManager();
        ClienteDAO clienteDAO = new ClienteDAO(em);

        Cliente expectedCliente = new Cliente();
        expectedCliente.setNome("Test");
        expectedCliente.setEmail("test@email.com");
        expectedCliente.setCpf("55498774563");

        // Salve o cliente para obter um ID
        clienteDAO.save(expectedCliente);

        // Recupere o cliente usando o ID
        Cliente actualCliente = clienteDAO.findById(expectedCliente.getIdCliente());

        // Verifique se o cliente retornado é o esperado
        assertEquals(expectedCliente, actualCliente);
        assertNotNull(actualCliente);
    }
}
