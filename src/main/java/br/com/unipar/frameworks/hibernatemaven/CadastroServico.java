package br.com.unipar.frameworks.hibernatemaven;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import br.com.unipar.frameworks.model.Servico;
import br.com.unipar.frameworks.model.dao.ServicoDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class CadastroServico extends JFrame {
    private JTextField textFieldDescricao;
    private JTextField textFieldValor;
    private JButton buttonCadastrar;
    private ServicoDAO servicoDAO;

    private static final Logger logger = LogManager.getLogger(CadastroServico.class);


    public CadastroServico() {
        servicoDAO = new ServicoDAO();
        initComponents();
        logger.info("A tela 'Cadastro de Serviço' foi aberta"); //criado para gerar log na abertura da tela

    }

    private void initComponents() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Serviço");

        // Painel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        getContentPane().add(mainPanel);

        // Painel de descrição
        JPanel descricaoPanel = new JPanel();
        descricaoPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        descricaoPanel.add(new JLabel("Descrição:"));
        textFieldDescricao = new JTextField(20);
        descricaoPanel.add(textFieldDescricao);
        mainPanel.add(descricaoPanel);

        // Painel de valor
        JPanel valorPanel = new JPanel();
        valorPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        valorPanel.add(new JLabel("Valor:"));
        textFieldValor = new JTextField(10);
        valorPanel.add(textFieldValor);
        mainPanel.add(valorPanel);

        // Botão Cadastrar
        buttonCadastrar = new JButton("Cadastrar");
        buttonCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarServico();
            }
        });
        mainPanel.add(buttonCadastrar);

        pack();
        setLocationRelativeTo(null); // Centralizar a janela na tela
    }

    private void cadastrarServico() {
        logger.info("Botão 'Cadastrar' pressionado");
        try {
            String descricao = textFieldDescricao.getText();
            BigDecimal valor = new BigDecimal(textFieldValor.getText());

            Servico servico = new Servico(descricao, valor);
            servicoDAO.save(servico);

            JOptionPane.showMessageDialog(this, "Serviço cadastrado com sucesso!");
            logger.info("Serviço cadastrado com sucesso");

            textFieldDescricao.setText("");
            textFieldValor.setText("");
        } catch (Exception e) {
            logger.error("Erro ao cadastrar serviço", e);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CadastroServico().setVisible(true);
            }
        });
    }
}
