package vista;

import controle.AppDAO;
import modelo.Arma;
import modelo.Crime;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaArma extends TelaBase implements ActionListener {
    private JTextField txtTipo;
    private JTextField txtNome;
    private JTextField txtIdCrime;
    private String txtID;

    public TelaArma() {
        super();

        setTitle("Cadastro de Armas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 556, 413);

        txtTipo = new JTextField();
        txtTipo.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtTipo.setBounds(129, 76, 283, 20);
        contentPane.add(txtTipo);
        txtTipo.setColumns(10);

        JLabel lblTipo = new JLabel("Tipo:");
        lblTipo.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblTipo.setBounds(10, 79, 109, 14);
        contentPane.add(lblTipo);

        txtNome = new JTextField();
        txtNome.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtNome.setBounds(129, 96, 283, 20);
        contentPane.add(txtNome);
        txtNome.setColumns(10);

        JLabel lblNome = new JLabel("Nome:");
        lblNome.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblNome.setBounds(10, 99, 109, 14);
        contentPane.add(lblNome);

        txtIdCrime = new JTextField();
        txtIdCrime.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        txtIdCrime.setBounds(129, 116, 283, 20);
        contentPane.add(txtIdCrime);
        txtIdCrime.setColumns(10);

        JLabel lblIdCrime = new JLabel("IdCrime:");
        lblIdCrime.setFont(new Font("Franklin Gothic Book", Font.BOLD, 12));
        lblIdCrime.setBounds(10, 116, 109, 14);
        contentPane.add(lblIdCrime);

        setBotoes();
    }

    public void setBotoes(){
        btnSalvar.addActionListener(this);
        btnEditar.addActionListener(this);
        btnExcluir.addActionListener(this);
        btnLimpar.addActionListener(this);
        btnPesquisar.addActionListener(this);

    }

    public Arma montaArma() {
        AppDAO<Crime> appDAO = new AppDAO<>();
        Arma c = new Arma();

        c.setTipo(this.txtTipo.getText());
        c.setNome(this.txtNome.getText());
        c.setCrime(appDAO.getById(Integer.parseInt(this.txtIdCrime.getText()), Crime.class));

        return c;
    }

    public Arma editaArma(int i) {
        Arma c = new Arma();
        c.setId(i);
        c.setTipo(this.txtTipo.getText());
        return c;
    }

    public void carregaArmanaTela(Arma c2) {
        this.txtTipo.setText(c2.getTipo());

    }

    public void limpaTela() {
        for (int i = 0; i < contentPane.getComponentCount(); i++) {
            Component c = contentPane.getComponent(i);
            if (c instanceof JTextField) {
                JTextField campo = (JTextField) c;
                campo.setText(null);
            }
        }

    }

    public void carregaLista() {
        AppDAO<Arma> appDAO = new AppDAO<>();

        List<Arma> ArmaBd = appDAO.getAll(Arma.class);
        cbPesquisar.removeAllItems();
        for (Arma Arma : ArmaBd) {
            cbPesquisar.addItem(Arma.getId());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println(e.getActionCommand());

        if (e.getActionCommand().equals(this.btnSalvar.getActionCommand())) {
            Arma c = this.montaArma();

            AppDAO<Arma> appDAO = new AppDAO<>();

            appDAO.insert(c);

            this.limpaTela();

            this.carregaLista();

            JOptionPane.showMessageDialog(null, "Arma " + txtTipo.getText() + " cadastrada...");
        } else if (e.getActionCommand().equals(this.btnPesquisar.getActionCommand())) {
            AppDAO<Arma> appDAO = new AppDAO<>();

            String nomeDigitado = cbPesquisar.getSelectedItem().toString().trim();

            Arma cbusca = appDAO.getById(Integer.parseInt(nomeDigitado), Arma.class);

            if (cbusca.getTipo().equals(nomeDigitado)) {
                JOptionPane.showMessageDialog(null, "Arma encontrada!");
                this.carregaArmanaTela(cbusca);
            } else {
                JOptionPane.showMessageDialog(null, "Arma nao cadastrada...");

            }
        } else if (e.getActionCommand().equals(this.btnLimpar.getActionCommand())) {
            this.limpaTela();
        } else if (e.getActionCommand().equals(this.btnExcluir.getActionCommand())) {
            AppDAO<Arma> appDAO = new AppDAO<>();

            Arma cbusca = appDAO.getById(Integer.parseInt(cbPesquisar.getSelectedItem().toString()), Arma.class);
            if (cbusca == null)
                JOptionPane.showMessageDialog(null, "Arma nao cadastrada...");
            else {
                JOptionPane.showMessageDialog(null, "Arma excluida!");
                this.carregaArmanaTela(cbusca);
                appDAO.delete(cbusca);
                this.limpaTela();
                this.carregaLista();
            }
        }
        if (e.getActionCommand().equals(this.btnEditar.getActionCommand())) {
            AppDAO<Arma> appDAO = new AppDAO<>();

            Arma cbusca = appDAO.getById(Integer.parseInt(cbPesquisar.getSelectedItem().toString()), Arma.class);
            if (cbusca == null)
                JOptionPane.showMessageDialog(null, "Arma nao cadastrada...");
            else {
                JOptionPane.showMessageDialog(null, "Arma editada!");

                appDAO.update(this.editaArma(cbusca.getId()));
                this.limpaTela();
                this.carregaLista();
            }
        }


    }

}
