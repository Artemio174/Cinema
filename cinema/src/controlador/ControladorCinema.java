/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import dao.DaoCinema;
import javax.swing.JOptionPane;
import modelo.Cinema;
import tela.manutencao.ManutencaoCinema;

import java.util.List;

import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Administrador
 */
public class ControladorCinema {

  public static void inserir(ManutencaoCinema man){
        Cinema objeto = new Cinema();
        objeto.setEndereco(man.jtfendereco.getText());
        objeto.setCapacidade(Integer.parseInt(man.jtfcapacidade.getText()));
        
        boolean resultado = DaoCinema.inserir(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Inserido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
}   
 public static void alterar(ManutencaoCinema man){
        Cinema objeto = new Cinema();
        //definir todos os atributos
        objeto.setCodigo(Integer.parseInt(man.jtfcodigo.getText()));
        objeto.setEndereco(man.jtfendereco.getText());
        objeto.setCapacidade(Integer.parseInt(man.jtfcapacidade.getText()));
       
        
        boolean resultado = DaoCinema.alterar(objeto);
        if (resultado) {
            JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Erro!");
        }
    }
  public static void atualizarTabela(JTable tabela) {
        DefaultTableModel modelo = new DefaultTableModel();
        //definindo o cabeçalho da tabela
        modelo.addColumn("Codigo");
        modelo.addColumn("Endereço");
        modelo.addColumn("Capacidade");
        List<Cinema> resultados = DaoCinema.consultar();
        for (Cinema objeto : resultados) {
            Vector linha = new Vector();
            
            //definindo o conteúdo da tabela
            linha.add(objeto.getCodigo());
            linha.add(objeto.getEndereco());
            linha.add(objeto.getCapacidade());
            modelo.addRow(linha); //adicionando a linha na tabela
        }
        tabela.setModel(modelo);
    }
}
