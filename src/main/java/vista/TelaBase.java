package vista;

import controle.AppDAO;
import controle.ContatoCT;
import modelo.Contato;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.List;

public class TelaBase<T> extends JFrame{
    private JPanel contentPane;
    private JComboBox cbPesquisar;

    private JButton btnSalvar;
    private JButton btnExcluir;
    private JButton btnEditar;
    private JButton btnPesquisar;
    private JButton btnLimpar;

    public TelaBase() {
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);

        contentPane.setLayout(null);

        mostrarFuncoesBase();
    }

    public void mostrarFuncoesBase(){
        mostrarBtnPesquisar();
        mostrarBtnIncluir();
        mostrarBtnEditar();
        mostrarBtnLimpar();
        mostrarBtnExcluir();
        mostrarBtnBuscar();
    }

    public void mostrarBtnPesquisar() {
        // Label
        JLabel lblPesquisar = new JLabel("Pesquisar:");
        lblPesquisar.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblPesquisar.setBounds(10, 31, 109, 14);

        contentPane.add(lblPesquisar);

        // Caixa
        cbPesquisar = new JComboBox<>();
        cbPesquisar.setEditable(true);
        cbPesquisar.setBounds(129, 28, 283, 20);

        contentPane.add(cbPesquisar);

        // Botão
        btnPesquisar = new JButton("Buscar");
        btnPesquisar.setBounds(422, 22, 80, 23);
        btnPesquisar.setActionCommand("pesquisar");

        contentPane.add(btnPesquisar);
    }

    public void mostrarBtnIncluir() {
        btnSalvar = new JButton("Incluir");
        btnSalvar.setBounds(193, 327, 75, 23);
        btnSalvar.setActionCommand("salvar");

        contentPane.add(btnSalvar);
    }

    public void mostrarBtnEditar() {
        btnEditar = new JButton("Editar");
        btnEditar.setBounds(280, 327, 75, 23);
        btnEditar.setActionCommand("editar");

        contentPane.add(btnEditar);
    }

    public void mostrarBtnLimpar() {
        btnLimpar = new JButton("Limpar");
        btnLimpar.setBounds(360, 327, 75, 23);
        btnLimpar.setActionCommand("limpar");

        contentPane.add(btnLimpar);
    }

    public void mostrarBtnExcluir(){
        btnExcluir = new JButton("Excluir");
        btnExcluir.setBounds(440, 327, 75, 23);
        btnExcluir.setActionCommand("excluir");

        contentPane.add(btnExcluir);
    }

    public void mostrarBtnBuscar() {
        btnPesquisar = new JButton("Buscar");
        btnPesquisar.setBounds(422, 22, 80, 23);
        btnPesquisar.setActionCommand("pesquisar");
        contentPane.add(btnPesquisar);

    }

    public void limparTela(){
        for(int i = 0; i < contentPane.getComponentCount(); i++){
            Component c = contentPane.getComponent(i);

            if(c instanceof JTextField){
                JTextField campo = (JTextField) c;
                campo.setText(null);
            }
        }

    }
}
