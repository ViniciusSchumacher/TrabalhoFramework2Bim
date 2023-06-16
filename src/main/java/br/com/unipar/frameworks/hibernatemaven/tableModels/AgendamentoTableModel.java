package br.com.unipar.frameworks.hibernatemaven.tableModels;

import br.com.unipar.frameworks.model.Agendamento;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class AgendamentoTableModel extends DefaultTableModel {

    //titulos das colunas
    public AgendamentoTableModel() {
        this.addColumn("Código");
        this.addColumn("Pet");
        this.addColumn("Data/Hora");
        this.addColumn("Serviços");
    }
    
    //puxando da listAgendamentos para preencher as linhas da table
    public AgendamentoTableModel(List<Agendamento> listAgendamentos) {
        this();
        for (Agendamento c : listAgendamentos) {
            //criando cada linha
            this.addRow(new String[]{
                c.getId().toString(), 
                c.getPet().getNome(),
                c.getDatahora().toString(),
                c.toStringListaServicos()});
        }
    }

    //retornar o objeto da linha selecionada
    public Agendamento getSelectedAgendamento(JTable table, 
            List<Agendamento> agendamentos) {
        //pegamos a linha selecionada
        int rowIndex = table.getSelectedRow();
        if (rowIndex < 0) {
            return null;
        }
        //pegamos o objeto da linha selecionada
        Object idObj = table.getValueAt(rowIndex, 0);
        Long id = Long.valueOf(idObj.toString());
        //varremos a lista procurando qual é igual
        for (Agendamento c : agendamentos) {
            if (c.getId().equals(id)) {
                return c; //retornamos o objeto que for igual
            }
        }
        return null; //se não encontrar, retorna null
    }
}
