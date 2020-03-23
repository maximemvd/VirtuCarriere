/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Point;

import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import virtucarriere.Domaine.Controller.Controller;
import virtucarriere.Domaine.Controller.Controller.ElementModes;

public class MainWindow extends JFrame {
    
    public Controller controller;
    
    public ElementModes  selectedElementModes;
    
    public DrawingPanel drawingPanel;

    private MeasurementUnitMode currentMeasurementUnitMode = MeasurementUnitMode.METRIC;
    private ApplicationMode currentApplicationMode = ApplicationMode.SELECT;

    public Point currentMousePoint = new Point();
    public Point initMousePoint = new Point();
    /**
     * Creates new form MainWindow
     */
    public MainWindow() {
        controller = new Controller();
        initComponents();
    }
    
        public void setMode(ElementModes newMode) {
        this.selectedElementModes = newMode;
    }

    public enum MeasurementUnitMode {
        METRIC, IMPERIAL
    }

    public enum ApplicationMode {
        SELECT, ADD_PLAN, ADD_SIMULATION
    }

    public MeasurementUnitMode getCurrentMeasurementUnitMode() {
        return currentMeasurementUnitMode;
    }

    public void setCurrentMeasurementUnitMode(MeasurementUnitMode newMeasurementUnitMode) {
        this.currentMeasurementUnitMode = newMeasurementUnitMode;
    }

    public void setCurrentApplicationMode(ApplicationMode newApplicationMode) {
        this.currentApplicationMode = newApplicationMode;
    }

    public DrawingPanel getDrawingPanel() {
        return drawingPanel;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        buttonTopPanel = new javax.swing.JPanel(new FlowLayout(FlowLayout.LEFT));
        jToggleButton1 = new javax.swing.JToggleButton();
        mainScrollPane = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        AddBroyeur = new javax.swing.JButton();
        AddConcasseur = new javax.swing.JButton();
        AddConvoyeur = new javax.swing.JButton();
        AddCrible = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        fichierMenu = new javax.swing.JMenu();
        menuNouveauProjet = new javax.swing.JMenuItem();
        menuOuvrirProjet = new javax.swing.JMenuItem();
        menuSauvegarderProjet = new javax.swing.JMenuItem();
        menuSauvegarderSous = new javax.swing.JMenuItem();
        menuQuitter = new javax.swing.JMenuItem();
        editionMenu = new javax.swing.JMenu();
        menuUndo = new javax.swing.JMenuItem();
        menuRedo = new javax.swing.JMenuItem();
        menuCopier = new javax.swing.JMenuItem();
        menuColler = new javax.swing.JMenuItem();
        menuCouper = new javax.swing.JMenuItem();
        affichageMenu = new javax.swing.JMenu();
        menuZoomer = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        menuAffichageGrille = new javax.swing.JMenuItem();
        importerMenu = new javax.swing.JMenu();
        importerCarriereMenu = new javax.swing.JMenuItem();
        importerSimulationMenu = new javax.swing.JMenuItem();
        fenetreMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setLayout(new java.awt.BorderLayout());

        buttonTopPanel.setToolTipText("");
        buttonTopPanel.setPreferredSize(new java.awt.Dimension(1410, 35));

        jToggleButton1.setText("SELECT");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });
        buttonTopPanel.add(jToggleButton1);

        mainPanel.add(buttonTopPanel, java.awt.BorderLayout.NORTH);

        mainScrollPane.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                mainScrollPaneMousePressed(evt);
            }
        });
        mainPanel.add(mainScrollPane, java.awt.BorderLayout.CENTER);

        AddBroyeur.setText("Ajout Broyeur");
        AddBroyeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddBroyeurActionPerformed(evt);
            }
        });

        AddConcasseur.setText("Ajout Concasseur");
        AddConcasseur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddConcasseurActionPerformed(evt);
            }
        });

        AddConvoyeur.setText("Ajout Convoyeur");
        AddConvoyeur.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddConvoyeurActionPerformed(evt);
            }
        });

        AddCrible.setText("Add Crible");
        AddCrible.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddCribleActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(89, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(AddConvoyeur)
                            .addComponent(AddConcasseur)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(AddBroyeur)
                                .addGap(20, 20, 20)))
                        .addGap(70, 70, 70))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(AddCrible)
                        .addGap(95, 95, 95))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(125, 125, 125)
                .addComponent(AddBroyeur)
                .addGap(74, 74, 74)
                .addComponent(AddConcasseur)
                .addGap(68, 68, 68)
                .addComponent(AddConvoyeur)
                .addGap(72, 72, 72)
                .addComponent(AddCrible)
                .addContainerGap(310, Short.MAX_VALUE))
        );

        mainPanel.add(jPanel1, java.awt.BorderLayout.EAST);

        fichierMenu.setText("Fichier");

        menuNouveauProjet.setText("Nouveau projet");
        menuNouveauProjet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNouveauProjetActionPerformed(evt);
            }
        });
        fichierMenu.add(menuNouveauProjet);

        menuOuvrirProjet.setText("Ouvrir un projet");
        fichierMenu.add(menuOuvrirProjet);

        menuSauvegarderProjet.setText("Sauvegarder");
        fichierMenu.add(menuSauvegarderProjet);

        menuSauvegarderSous.setText("Sauvegarder sous...");
        fichierMenu.add(menuSauvegarderSous);

        menuQuitter.setText("Quitter");
        menuQuitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuQuitterActionPerformed(evt);
            }
        });
        fichierMenu.add(menuQuitter);

        jMenuBar1.add(fichierMenu);

        editionMenu.setText("Édition");

        menuUndo.setText("Undo");
        editionMenu.add(menuUndo);

        menuRedo.setText("Redo");
        editionMenu.add(menuRedo);

        menuCopier.setText("Copier");
        editionMenu.add(menuCopier);

        menuColler.setText("Coller");
        editionMenu.add(menuColler);

        menuCouper.setText("Couper");
        editionMenu.add(menuCouper);

        jMenuBar1.add(editionMenu);

        affichageMenu.setText("Affichage");

        menuZoomer.setText("Zoomer");
        affichageMenu.add(menuZoomer);

        jMenuItem6.setText("Dézoomer");
        affichageMenu.add(jMenuItem6);

        menuAffichageGrille.setText("Grille magnétique");
        menuAffichageGrille.setSelected(drawingPanel.getGridlines());
        menuAffichageGrille.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAffichageGrilleMouseClicked(evt);
            }
        });
        menuAffichageGrille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAffichageGrilleActionPerformed(evt);
            }
        });
        affichageMenu.add(menuAffichageGrille);

        jMenuBar1.add(affichageMenu);

        importerMenu.setText("Importer");
        importerMenu.setToolTipText("");

        importerCarriereMenu.setText("Importer une carrière");
        importerMenu.add(importerCarriereMenu);

        importerSimulationMenu.setText("Importer une simulation");
        importerMenu.add(importerSimulationMenu);

        jMenuBar1.add(importerMenu);

        fenetreMenu.setText("Fenêtre");
        jMenuBar1.add(fenetreMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1524, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void mainScrollPaneMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mainScrollPaneMousePressed
        // TODO add your handling code here:
        Point mousePoint = evt.getPoint();
        Controller.ElementModes actualMode = this.selectedElementModes;
        this.controller.addElements(actualMode,mousePoint);
        drawingPanel.repaint();
    }//GEN-LAST:event_mainScrollPaneMousePressed

    private void AddConcasseurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddConcasseurActionPerformed
        this.setMode(ElementModes.CONCASSEUR);
    }//GEN-LAST:event_AddConcasseurActionPerformed

    private void AddBroyeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddBroyeurActionPerformed
        this.setMode(ElementModes.BROYEUR);
    }//GEN-LAST:event_AddBroyeurActionPerformed

    private void AddConvoyeurActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddConvoyeurActionPerformed
        this.setMode(ElementModes.CONVOYEUR);
    }//GEN-LAST:event_AddConvoyeurActionPerformed

    private void AddCribleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddCribleActionPerformed
        this.setMode(ElementModes.CRIBLE);
    }//GEN-LAST:event_AddCribleActionPerformed

    private void menuNouveauProjetActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuNouveauProjetActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_menuNouveauProjetActionPerformed

    private void menuQuitterActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuQuitterActionPerformed
        System.exit(0);
    }// GEN-LAST:event_menuQuitterActionPerformed

    private void buttonAjouterNoeudActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonAjouterNoeudActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_buttonAjouterNoeudActionPerformed

    private void buttonAjouterArcActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonAjouterArcActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_buttonAjouterArcActionPerformed

    private void buttonAjouterConcasseurActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonAjouterConcasseurActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_buttonAjouterConcasseurActionPerformed

    private void buttonAjouterConvoyeurActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonAjouterConvoyeurActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_buttonAjouterConvoyeurActionPerformed



    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jButton4ActionPerformed

    private void menuAffichageGrilleActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_menuAffichageGrilleActionPerformed
        drawingPanel.setGridLines();
    }// GEN-LAST:event_menuAffichageGrilleActionPerformed

    private void menuAffichageGrilleMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_menuAffichageGrilleMouseClicked
        // TODO add your handling code here:
    }// GEN-LAST:event_menuAffichageGrilleMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainWindow.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }
        // </editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainWindow().setVisible(true);
            }
        });
    }

    public Dimension getMainScrollPaneDimension() {
        return mainScrollPane.getSize();
    }

    public JScrollPane getMainScrollPane() {
        return this.mainScrollPane;
    }

    public void setMainScrollPanePosition(Point point) {
        this.mainScrollPane.getViewport().setViewPosition(point);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddBroyeur;
    private javax.swing.JButton AddConcasseur;
    private javax.swing.JButton AddConvoyeur;
    private javax.swing.JButton AddCrible;
    private javax.swing.JMenu affichageMenu;
    private javax.swing.JPanel buttonTopPanel;
    private javax.swing.JMenu editionMenu;
    private javax.swing.JMenu fenetreMenu;
    private javax.swing.JMenu fichierMenu;
    private javax.swing.JMenuItem importerCarriereMenu;
    private javax.swing.JMenu importerMenu;
    private javax.swing.JMenuItem importerSimulationMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane mainScrollPane;
    private javax.swing.JMenuItem menuAffichageGrille;
    private javax.swing.JMenuItem menuColler;
    private javax.swing.JMenuItem menuCopier;
    private javax.swing.JMenuItem menuCouper;
    private javax.swing.JMenuItem menuNouveauProjet;
    private javax.swing.JMenuItem menuOuvrirProjet;
    private javax.swing.JMenuItem menuQuitter;
    private javax.swing.JMenuItem menuRedo;
    private javax.swing.JMenuItem menuSauvegarderProjet;
    private javax.swing.JMenuItem menuSauvegarderSous;
    private javax.swing.JMenuItem menuUndo;
    private javax.swing.JMenuItem menuZoomer;
    // End of variables declaration//GEN-END:variables
}
