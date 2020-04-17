package br.uece.peoo.view;

import br.uece.peoo.model.Canal;
import br.uece.peoo.model.ControleRemoto;
import br.uece.peoo.model.Televisao;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

/**
 * JFrame para simular um controle remoto.
 */
public class ControleRemotoJFrame extends JFrame {

    // Variáveis
    private final ControleRemoto controleRemoto;
    private final ArrayList<Canal> canais;

    // Componenetes
    private JComboBox canaisJComboBox;
    private JPanel canalJPanel;
    private JButton downCanalJButton;
    private JButton downVolumeJButton;
    private JButton informarDadosJButton;
    private JButton mostrarGradeJButton;
    private JPanel outrasOpcoesJPanel;
    private JButton sintonizarCanalJButton;
    private JButton upCanalJButton;
    private JButton upVolumeJButton;
    private JPanel volumeJPanel;

    /**
     * Creates new form ControleRemotoJFrame
     * @param controleRemoto
     * @param canais
     */
    public ControleRemotoJFrame(ControleRemoto controleRemoto, ArrayList<Canal> canais) {
        initComponents();
        this.controleRemoto = controleRemoto;
        this.canais = canais;
        this.canaisJComboBox.addItem("<Selecione um Canal>");
        this.canais.forEach(canal -> this.canaisJComboBox.addItem(canal)); // adicionando os canais no canaisJComboBox
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        outrasOpcoesJPanel = new javax.swing.JPanel();
        canaisJComboBox = new javax.swing.JComboBox();
        sintonizarCanalJButton = new javax.swing.JButton();
        informarDadosJButton = new javax.swing.JButton();
        mostrarGradeJButton = new javax.swing.JButton();
        volumeJPanel = new javax.swing.JPanel();
        upVolumeJButton = new javax.swing.JButton();
        downVolumeJButton = new javax.swing.JButton();
        canalJPanel = new javax.swing.JPanel();
        upCanalJButton = new javax.swing.JButton();
        downCanalJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Controle Remoto");
        setFont(new java.awt.Font("Agency FB", 0, 14)); // NOI18N
        setIconImages(null);
        setName("framePrincipal"); // NOI18N

        outrasOpcoesJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Canais"));
        outrasOpcoesJPanel.setToolTipText("");
        outrasOpcoesJPanel.setName(""); // NOI18N

        sintonizarCanalJButton.setText("Sintonizar Canal");
        sintonizarCanalJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sintonizarCanalJButtonActionPerformed(evt);
            }
        });

        informarDadosJButton.setText("Informar Dados");
        informarDadosJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informarDadosJButtonActionPerformed(evt);
            }
        });

        mostrarGradeJButton.setText("Mostrar Grade");
        mostrarGradeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostrarGradeJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout outrasOpcoesJPanelLayout = new javax.swing.GroupLayout(outrasOpcoesJPanel);
        outrasOpcoesJPanel.setLayout(outrasOpcoesJPanelLayout);
        outrasOpcoesJPanelLayout.setHorizontalGroup(
            outrasOpcoesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outrasOpcoesJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(outrasOpcoesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sintonizarCanalJButton, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                    .addComponent(canaisJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(mostrarGradeJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(informarDadosJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        outrasOpcoesJPanelLayout.setVerticalGroup(
            outrasOpcoesJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(outrasOpcoesJPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(canaisJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(sintonizarCanalJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(informarDadosJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mostrarGradeJButton)
                .addContainerGap())
        );

        getContentPane().add(outrasOpcoesJPanel, java.awt.BorderLayout.PAGE_END);

        volumeJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Volume"));

        upVolumeJButton.setText("+");
        upVolumeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upVolumeJButtonActionPerformed(evt);
            }
        });

        downVolumeJButton.setText("-");
        downVolumeJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downVolumeJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout volumeJPanelLayout = new javax.swing.GroupLayout(volumeJPanel);
        volumeJPanel.setLayout(volumeJPanelLayout);
        volumeJPanelLayout.setHorizontalGroup(
            volumeJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(volumeJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(volumeJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(upVolumeJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(downVolumeJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        volumeJPanelLayout.setVerticalGroup(
            volumeJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(volumeJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(upVolumeJButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(downVolumeJButton)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(volumeJPanel, java.awt.BorderLayout.LINE_START);

        canalJPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Canal"));

        upCanalJButton.setText("+");
        upCanalJButton.setMaximumSize(new java.awt.Dimension(557, 521));
        upCanalJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                upCanalJButtonActionPerformed(evt);
            }
        });

        downCanalJButton.setText("-");
        downCanalJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downCanalJButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout canalJPanelLayout = new javax.swing.GroupLayout(canalJPanel);
        canalJPanel.setLayout(canalJPanelLayout);
        canalJPanelLayout.setHorizontalGroup(
            canalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(canalJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(canalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(upCanalJButton, javax.swing.GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
                    .addComponent(downCanalJButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        canalJPanelLayout.setVerticalGroup(
            canalJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(canalJPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(upCanalJButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(downCanalJButton)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        getContentPane().add(canalJPanel, java.awt.BorderLayout.LINE_END);

        pack();
        setLocationRelativeTo(null);
    }

    /**
     * Chamado quando acionado o downVolumeJButton.
     * @param evt
     */
    private void downVolumeJButtonActionPerformed(ActionEvent evt) {
        String msg = "Antes\n";
        for (Televisao tv : this.controleRemoto.getTVs()) {
            msg += "TV{id=" + tv.getId() + ", volume=" + tv.getVolume() + "}\n";
        }
        this.controleRemoto.diminuirVolume();
        msg += "Depois\n";
        for (Televisao tv : this.controleRemoto.getTVs()) {
            msg += "TV{id=" + tv.getId() + ", volume=" + tv.getVolume() + "}\n";
        }
        JOptionPane.showMessageDialog(this, msg, "Auterar Volume", WIDTH);
    }

    /**
     * Chamado quando acionado o upCanalJButton
     * @param evt
     */
    private void upCanalJButtonActionPerformed(ActionEvent evt) {
        String msg = "Antes\n";
        for (Televisao tv : this.controleRemoto.getTVs()) {
            msg += "TV{id=" + tv.getId() + ", canalAtual=" + tv.getCanalAtual() + "}\n";
        }
        this.controleRemoto.proximoCanal();
        msg += "Depois\n";
        for (Televisao tv : this.controleRemoto.getTVs()) {
            msg += "TV{id=" + tv.getId() + ", canalAtual=" + tv.getCanalAtual() + "}\n";
        }
        JOptionPane.showMessageDialog(this, msg, "Auteração de Canal", WIDTH);
    }

    /**
     * Chamado quando acionado o upVolumeJButton
     * @param evt
     */
    private void upVolumeJButtonActionPerformed(ActionEvent evt) {
        String msg = "Antes\n";
        for (Televisao tv : this.controleRemoto.getTVs()) {
            msg += "TV{id=" + tv.getId() + ", volume=" + tv.getVolume() + "}\n";
        }
        this.controleRemoto.aumentarVolume();
        msg += "Depois\n";
        for (Televisao tv : this.controleRemoto.getTVs()) {
            msg += "TV{id=" + tv.getId() + ", volume=" + tv.getVolume() + "}\n";
        }
        JOptionPane.showMessageDialog(this, msg, "Auteração de Volume", WIDTH);
    }

    /**
     * Chamado quando acionado o downCanalJButton.
     * @param evt
     */
    private void downCanalJButtonActionPerformed(ActionEvent evt) {
        String msg = "Antes\n";
        for (Televisao tv : this.controleRemoto.getTVs()) {
            msg += "TV{id=" + tv.getId() + ", canalAtual=" + tv.getCanalAtual() + "}\n";
        }
        this.controleRemoto.anteriorCanal();
        msg += "Depois\n";
        for (Televisao tv : this.controleRemoto.getTVs()) {
            msg += "TV{id=" + tv.getId() + ", canalAtual=" + tv.getCanalAtual() + "}\n";
        }
        JOptionPane.showMessageDialog(this, msg, "Auteração de Canal", WIDTH);
    }

    /**
     * Chamado quando acionado o informarDadosJButton. Mostra as infromaçãos de cada Tv de controleRemoto.
     * @param evt
     */
    private void informarDadosJButtonActionPerformed(ActionEvent evt) {
        String msg = "Dados: \n";
        for (Televisao tv : this.controleRemoto.getTVs()) {
            msg += tv.toString() + "\n";
        }
        JOptionPane.showMessageDialog(this, msg, "Informar Dados", WIDTH);
    }

    /**
     * Chamado quando acionado o sintonizarCanalJButton. Obtem o canal selecionado em canaisJComboBox e sintoniza
     * esse canal em cada Tv do controleRemoto. Se a tv for uma {@link br.uece.peoo.model.TVHD} e o canal não for
     * HD, então o canal Atual permanece o mesmo.
     * @param evt
     */
    private void sintonizarCanalJButtonActionPerformed(ActionEvent evt) {
        if (this.canaisJComboBox.getSelectedItem().equals("<Selecione um Canal>")) {
            JOptionPane.showMessageDialog(this, "Escolha um Canal", "Erro", JOptionPane.ERROR_MESSAGE);
        } else {
            Canal canalSelecionado = (Canal) this.canaisJComboBox.getSelectedItem(); // Canal que foi selecionado.
            String msg = "";
            msg += "Canal selecionado=" + canalSelecionado + "\n";
            msg += "Antes\n";
            for (Televisao tv: controleRemoto.getTVs()) {
                msg += "TV{id=" + tv.getId() + ", canalAtual=" + tv.getCanalAtual() + "}\n";
            }
            this.controleRemoto.sintonizarCanal(canalSelecionado);
            msg += "Depois\n";
            for (Televisao tv: controleRemoto.getTVs()) {
                msg += "TV{id=" + tv.getId() + ", canalAtual=" + tv.getCanalAtual() + "}\n";
            }
            JOptionPane.showMessageDialog(this, msg, "Sintonizar Canal", WIDTH);
        }
    }

    /**
     * Chamado quando acionado o mostrarGradeJButton. Mostra a grade de canais de cada Tv do controleRemoto.
     * @param evt
     */
    private void mostrarGradeJButtonActionPerformed(ActionEvent evt) {
        String msg = "";
        for (Televisao tv : this.controleRemoto.getTVs()) {
            msg += tv.getId() + "\n";
            msg = "\t" + tv.getCanaisCadastrados().stream().map(canal -> canal + "\n").reduce(msg, String::concat);
        }
        JOptionPane.showMessageDialog(this, msg, "Grade de Canais", WIDTH);
    }

}
