package br.com.unipar.frameworks.hibernatemaven.tableModels;

import br.com.unipar.frameworks.model.Agendamento;
import br.com.unipar.frameworks.model.Pet;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PetTableModel extends DefaultTableModel {

    //titulos das colunas
    public PetTableModel() {
        this.addColumn("Código");
        this.addColumn("Pet");
        this.addColumn("Tamanho");
        this.addColumn("Dono/Cliente");
    }
    
    //puxando da listPets para preencher as linhas da table
    public PetTableModel(List<Pet> listPets) {
        this();
        for (Pet c : listPets) {
            //criando cada linha
            this.addRow(new String[]{
                c.getId().toString(), 
                c.getNome(),
                c.getTamanho(),
                c.getCliente().getNome()});
        }
    }

    //retornar o objeto da linha selecionada
    public Pet getSelectedPet(JTable table, 
            List<Pet> pets) {
        //pegamos a linha selecionada
        int rowIndex = table.getSelectedRow();
        if (rowIndex < 0) {
            return null;
        }
        //pegamos o objeto da linha selecionada
        Object idObj = table.getValueAt(rowIndex, 0);
        Long id = Long.valueOf(idObj.toString());
        //varremos a lista procurando qual é igual
        for (Pet c : pets) {
            if (c.getId().equals(id)) {
                return c; //retornamos o objeto que for igual
            }
        }
        return null; //se não encontrar, retorna null
    }
}
