/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.gui;

/** @author maximemivilledeschenes */
public class AjoutClientJFrame extends javax.swing.JFrame {

  /** Creates new form AjoutClientJFrame */
  public AjoutClientJFrame() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    filler1 =
        new javax.swing.Box.Filler(
            new java.awt.Dimension(0, 0),
            new java.awt.Dimension(0, 0),
            new java.awt.Dimension(0, 0));
    jLabel1 = new javax.swing.JLabel();
    jLabel2 = new javax.swing.JLabel();
    jLabel3 = new javax.swing.JLabel();
    jLabel4 = new javax.swing.JLabel();
    textFieldNomClient = new javax.swing.JTextField();
    jComboBox1 = new javax.swing.JComboBox<>();
    jButton1 = new javax.swing.JButton();
    jSpinner1 = new javax.swing.JSpinner();

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

    jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
    jLabel1.setText("Ajout d'un client");

    jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
    jLabel2.setText("Nom du client :");

    jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
    jLabel3.setText("Type de produit :");

    jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 15)); // NOI18N
    jLabel4.setText("Quantité :");

    textFieldNomClient.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            textFieldNomClientActionPerformed(evt);
          }
        });

    jComboBox1.setModel(
        new javax.swing.DefaultComboBoxModel<>(
            new String[] {"Item 1", "Item 2", "Item 3", "Item 4"}));

    jButton1.setText("OK");
    jButton1.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            jButton1ActionPerformed(evt);
          }
        });

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addContainerGap(27, Short.MAX_VALUE)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                layout
                                    .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(
                                        layout
                                            .createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addGap(112, 112, 112))
                                    .addGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING,
                                        layout
                                            .createSequentialGroup()
                                            .addGroup(
                                                layout
                                                    .createParallelGroup(
                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                        layout
                                                            .createSequentialGroup()
                                                            .addComponent(jLabel2)
                                                            .addGap(30, 30, 30)
                                                            .addComponent(
                                                                textFieldNomClient,
                                                                javax.swing.GroupLayout
                                                                    .PREFERRED_SIZE,
                                                                191,
                                                                javax.swing.GroupLayout
                                                                    .PREFERRED_SIZE))
                                                    .addGroup(
                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                        layout
                                                            .createSequentialGroup()
                                                            .addGroup(
                                                                layout
                                                                    .createParallelGroup(
                                                                        javax.swing.GroupLayout
                                                                            .Alignment.LEADING)
                                                                    .addGroup(
                                                                        layout
                                                                            .createSequentialGroup()
                                                                            .addComponent(jLabel3)
                                                                            .addGap(53, 53, 53))
                                                                    .addGroup(
                                                                        javax.swing.GroupLayout
                                                                            .Alignment.TRAILING,
                                                                        layout
                                                                            .createSequentialGroup()
                                                                            .addComponent(jLabel4)
                                                                            .addGap(104, 104, 104)))
                                                            .addGroup(
                                                                layout
                                                                    .createParallelGroup(
                                                                        javax.swing.GroupLayout
                                                                            .Alignment.LEADING,
                                                                        false)
                                                                    .addComponent(
                                                                        jComboBox1,
                                                                        0,
                                                                        javax.swing.GroupLayout
                                                                            .DEFAULT_SIZE,
                                                                        Short.MAX_VALUE)
                                                                    .addComponent(jSpinner1))))
                                            .addGap(66, 66, 66)))
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                layout
                                    .createSequentialGroup()
                                    .addComponent(
                                        jButton1,
                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                        64,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(183, 183, 183)))));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                layout
                    .createSequentialGroup()
                    .addGap(27, 27, 27)
                    .addComponent(
                        jLabel1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        32,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(24, 24, 24)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(
                                textFieldNomClient,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                38,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(24, 24, 24)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(
                                jComboBox1,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGap(29, 29, 29)
                    .addGroup(
                        layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(
                                jSpinner1,
                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(
                        javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                    .addComponent(jButton1)
                    .addGap(17, 17, 17)));

    pack();
    setLocationRelativeTo(null);
  } // </editor-fold>//GEN-END:initComponents

  private void jButton1ActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_jButton1ActionPerformed

  private void textFieldNomClientActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_textFieldNomClientActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_textFieldNomClientActionPerformed

  /** @param args the command line arguments */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info :
          javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(AjoutClientJFrame.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(AjoutClientJFrame.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(AjoutClientJFrame.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(AjoutClientJFrame.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
        new Runnable() {
          public void run() {
            new AjoutClientJFrame().setVisible(true);
          }
        });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.Box.Filler filler1;
  private javax.swing.JButton jButton1;
  private javax.swing.JComboBox<String> jComboBox1;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JLabel jLabel3;
  private javax.swing.JLabel jLabel4;
  private javax.swing.JSpinner jSpinner1;
  private javax.swing.JTextField textFieldNomClient;
  // End of variables declaration//GEN-END:variables
}
