package br.com.unipar.frameworks.hibernatemaven;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JButton cadastrarClienteButton;
    private JButton cadastrarPetButton;
    private JButton agendarAtendimentoButton;
    private JButton listarClientesButton;
    private JButton listarPetsButton;
    private JButton listarAgendamentosButton;

    private static final Logger logger = LogManager.getLogger(Menu.class);


    public Menu() {
        initComponents();
    }

    private void initComponents() {
        // Loga a abertura da tela
        logger.info("A tela 'Menu' foi aberta"); //criado para gerar log na abertura da tela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cadastrarClienteButton = new JButton("Cadastrar Cliente");
        cadastrarPetButton = new JButton("Cadastrar Pet");
        agendarAtendimentoButton = new JButton("Agendar Atendimento");
        listarClientesButton = new JButton("Listar Clientes");
        listarPetsButton = new JButton("Listar Pets");
        listarAgendamentosButton = new JButton("Listar Agendamentos");

        // Adicionando ActionListener ao botão "Cadastrar Cliente"
        cadastrarClienteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroCliente cadastroCliente = new CadastroCliente(null, true);
                cadastroCliente.setVisible(true);
            }
        });

        // Adicionando ActionListener ao botão "Cadastrar Pet"
        cadastrarPetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroPet cadastroPet = new CadastroPet(null, true);
                cadastroPet.setVisible(true);
            }
        });

        // Adicionando ActionListener ao botão "Agendar Atendimento"
        agendarAtendimentoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaAgendamento telaAgendamento = new TelaAgendamento();
                telaAgendamento.setVisible(true);
            }
        });

        // Adicionando ActionListener ao botão "Listar Pets"
        listarPetsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultaPet consultaPet = new ConsultaPet(null, true);
                consultaPet.setVisible(true);
            }
        });

        // Adicionando ActionListener ao botão "Listar Agendamentos"
        listarAgendamentosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TelaListaAgendamento telaListaAgendamento = new TelaListaAgendamento();
                telaListaAgendamento.setVisible(true);
            }
        });

        // Adicionando o botão à tela
        this.add(listarAgendamentosButton);

// Botão "Cadastrar Serviços"
        JButton cadastrarServicosButton = new JButton("Cadastrar Serviços");
        cadastrarServicosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroServico cadastroServico = new CadastroServico();
                cadastroServico.setVisible(true);
            }
        });
        this.add(cadastrarServicosButton);

        // Adicionando ActionListener ao botão "Listar Clientes"
        listarClientesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConsultaCliente consultaCliente = new ConsultaCliente(null, true);
                consultaCliente.setVisible(true);
            }
        });


        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        this.add(cadastrarClienteButton);
        this.add(cadastrarPetButton);
        this.add(agendarAtendimentoButton);
        this.add(listarClientesButton);
        this.add(listarPetsButton);
        this.add(listarAgendamentosButton);

        pack();
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> {
            new Menu().setVisible(true);
        });
    }
}
