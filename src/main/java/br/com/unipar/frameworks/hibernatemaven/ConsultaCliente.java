package br.com.unipar.frameworks.hibernatemaven;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.unipar.frameworks.model.Cliente;
import br.com.unipar.frameworks.model.dao.ClienteDAO;
import br.com.unipar.frameworks.hibernatemaven.tableModels.ClienteTableModel;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class ConsultaCliente extends javax.swing.JDialog {

    private Cliente clienteSelecionado;
    private ClienteTableModel model;
    private List<Cliente> listClientes;

    private static final Logger logger = LogManager.getLogger(ConsultaCliente.class);


    public Cliente getClienteSelecionado() {
        return clienteSelecionado;
    }

    public void setClienteSelecionado(Cliente clienteSelecionado) {
        this.clienteSelecionado = clienteSelecionado;
    }

    public ConsultaCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();


        EntityManager em = Persistence.createEntityManagerFactory("HibernateMaven").createEntityManager();
        ClienteDAO dao = new ClienteDAO(em);

        listClientes = dao.findAll();
        model = new ClienteTableModel(listClientes);
        jTableClientes.setModel(model);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {
        logger.info("A tela 'Consulta de Clientes' foi aberta"); //criado para gerar log na abertura da tela
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableClientes = new javax.swing.JTable();
        jButtonSelecionarCliente = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jTableClientes.setModel(new ClienteTableModel());
        jScrollPane1.setViewportView(jTableClientes);

        jButtonSelecionarCliente.setText("Selecionar");
        jButtonSelecionarCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarClienteActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonSelecionarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonSelecionarCliente)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButtonSelecionarClienteActionPerformed(java.awt.event.ActionEvent evt) {
        setClienteSelecionado(model.getSelectedCliente(jTableClientes));
        this.dispose();
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ConsultaCliente dialog = new ConsultaCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JButton jButtonSelecionarCliente;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableClientes;
    // End of variables declaration
}
