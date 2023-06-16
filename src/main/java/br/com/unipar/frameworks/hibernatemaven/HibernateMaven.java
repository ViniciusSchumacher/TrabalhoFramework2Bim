package br.com.unipar.frameworks.hibernatemaven;

import br.com.unipar.frameworks.model.Cidade;
import br.com.unipar.frameworks.model.Cliente;
import br.com.unipar.frameworks.model.Endereco;
import br.com.unipar.frameworks.model.dao.CidadeDAO;
import br.com.unipar.frameworks.model.dao.ClienteDAO;
import br.com.unipar.frameworks.model.util.EntityManagerUtil;
import br.com.unipar.frameworks.model.util.PetDoguiLog;

import javax.persistence.EntityManager;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class HibernateMaven {

    public static void main(String[] args) {
        EntityManager em = EntityManagerUtil.getManager();  // Obtem a instancia do EntityManager
        try {
            new ClienteDAO(em).save(new Cliente());  // passa a instancia do EntityManager para o DAO
        } catch (Exception e) {
            PetDoguiLog.erroPersistencia(e);
        }
        PetDoguiLog.infoGeral("TESTE LOG");
    }
}
