package br.com.unipar.frameworks.hibernatemaven.tableModels;

import br.com.unipar.frameworks.model.Cliente;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ClienteTableModel extends DefaultTableModel {

    private List<Cliente> listClientes;

    public ClienteTableModel() {
        this.addColumn("ID");
        this.addColumn("NOME");
        this.addColumn("CPF");
        this.addColumn("EMAIL");
        this.addColumn("ATIVO");
    }

    public ClienteTableModel(List<Cliente> listClientes) {
        this();
        this.listClientes = listClientes;
        for (Cliente c : listClientes) {
            this.addRow(new Object[]{c.getIdCliente(), c.getNome(), c.getCpf(), c.getEmail(), c.getAtivo()});
        }
    }

    public Cliente getSelectedCliente(JTable table) {
        int rowIndex = table.getSelectedRow();
        if (rowIndex < 0) {
            return null;
        }
        Long id = (Long) table.getValueAt(rowIndex, 0);
        for (Cliente c : listClientes) {
            if (c.getIdCliente().equals(id)) {
                return c;
            }
        }
        return null;
    }
}
