/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package virtucarriere.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics2D;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import virtucarriere.Domaine.Carriere.Plan.Element;
import virtucarriere.Domaine.Controller.Controller;
import virtucarriere.Domaine.Controller.Controller.EquipementModes;
import virtucarriere.Domaine.Controller.ElementContainer;

public class MainWindow extends JFrame {

  public Controller controller;
  public ElementContainer elementContainer;

  public EquipementModes selectedEquipementMode;

  private MeasurementUnitMode currentMeasurementUnitMode = MeasurementUnitMode.METRIC;
  private ApplicationMode currentApplicationMode;

  public Point currentMousePoint;
  public Point delta;
  public Point initMousePoint = new Point();

  /** Creates new form MainWindow */
  public MainWindow() {
    controller = new Controller();
    initComponents();
    // setFocusable(true);
  }

  public void setAppMode(ApplicationMode newMode) {
    this.currentApplicationMode = newMode;
  }

  public void setMode(EquipementModes newMode) {
    this.selectedEquipementMode = newMode;
  }

  public enum MeasurementUnitMode {
    METRIC,
    IMPERIAL
  }

  public enum ApplicationMode {
    SELECT,
    ADD_PLAN,
    ADD_SIMULATION
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
    return this.drawingPanel;
  }

  /**
   * This method is called from within the constructor to initialize the form. WARNING: Do NOT
   * modify this code. The content of this method is always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    buttonGroup1 = new javax.swing.ButtonGroup();
    mainPanel = new javax.swing.JPanel();
    buttonTopPanel = new javax.swing.JPanel(new FlowLayout(FlowLayout.LEFT));
    modeSelection = new javax.swing.JToggleButton();
    mainScrollPane = new javax.swing.JScrollPane();
    drawingPanel = new virtucarriere.gui.DrawingPanel(this);
    jPanel1 = new javax.swing.JPanel();
    jTabbedPane = new javax.swing.JTabbedPane();
    jPanel2 = new javax.swing.JPanel();
    jComboBox1 = new javax.swing.JComboBox<>();
    jLabel2 = new javax.swing.JLabel();
    ajoutElement = new javax.swing.JToggleButton();
    jScrollPane1 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    jTextField1 = new javax.swing.JTextField();
    jPanel3 = new javax.swing.JPanel();
    ajoutCamion = new javax.swing.JToggleButton();
    ajoutChargeur = new javax.swing.JToggleButton();
    ajoutSimulation = new javax.swing.JToggleButton();
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

    buttonGroup1.add(modeSelection);
    buttonGroup1.add(ajoutElement);
    buttonGroup1.add(ajoutSimulation);

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    addMouseWheelListener(
        new java.awt.event.MouseWheelListener() {
          public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
            formMouseWheelMoved(evt);
          }
        });

    mainPanel.setLayout(new java.awt.BorderLayout());

    buttonTopPanel.setToolTipText("");
    buttonTopPanel.setPreferredSize(new java.awt.Dimension(1410, 35));

    modeSelection.setText("Sélection");
    modeSelection.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            modeSelectionActionPerformed(evt);
          }
        });
    buttonTopPanel.add(modeSelection);

    mainPanel.add(buttonTopPanel, java.awt.BorderLayout.NORTH);

    mainScrollPane.addMouseWheelListener(
        new java.awt.event.MouseWheelListener() {
          public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
            mainScrollPaneMouseWheelMoved(evt);
          }
        });

    drawingPanel.setOpaque(false);
    drawingPanel.addMouseMotionListener(
        new java.awt.event.MouseMotionAdapter() {
          public void mouseDragged(java.awt.event.MouseEvent evt) {
            drawingPanelMouseDragged(evt);
          }
        });
    drawingPanel.addMouseWheelListener(
        new java.awt.event.MouseWheelListener() {
          public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
            drawingPanelMouseWheelMoved(evt);
          }
        });
    drawingPanel.addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mousePressed(java.awt.event.MouseEvent evt) {
            drawingPanelMousePressed(evt);
          }
        });
    drawingPanel.addMouseMotionListener(
        new java.awt.event.MouseMotionAdapter() {
          public void mouseMoved(java.awt.event.MouseEvent evt) {
            drawingPanelMouseMoved(evt);
          }
        });
    drawingPanel.setLayout(new java.awt.BorderLayout());
    mainScrollPane.setViewportView(drawingPanel);

    mainPanel.add(mainScrollPane, java.awt.BorderLayout.CENTER);

    jPanel1.setPreferredSize(new java.awt.Dimension(300, 765));

    jComboBox1.setModel(
        new javax.swing.DefaultComboBoxModel<>(
            new String[] {
              "Sélectionner", "Broyeur", "Concasseur", "Crible", "Convoyeur", "Noeud"
            }));
    jComboBox1.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            jComboBox1ActionPerformed(evt);
          }
        });

    jLabel2.setText("Ajouter un équipement");

    ajoutElement.setText("Ajout Plan");
    ajoutElement.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            ajoutElementActionPerformed(evt);
          }
        });

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jTextArea1.addContainerListener(
        new java.awt.event.ContainerAdapter() {
          public void componentAdded(java.awt.event.ContainerEvent evt) {
            jTextArea1ComponentAdded(evt);
          }
        });
    jScrollPane1.setViewportView(jTextArea1);

    jTextField1.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            jTextField1ActionPerformed(evt);
          }
        });

    javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
    jPanel2.setLayout(jPanel2Layout);
    jPanel2Layout.setHorizontalGroup(
        jPanel2Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel2Layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addGroup(
                        jPanel2Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(
                                javax.swing.GroupLayout.Alignment.TRAILING,
                                jPanel2Layout
                                    .createSequentialGroup()
                                    .addGap(0, 63, Short.MAX_VALUE)
                                    .addGroup(
                                        jPanel2Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                jPanel2Layout
                                                    .createSequentialGroup()
                                                    .addComponent(ajoutElement)
                                                    .addGap(79, 79, 79))
                                            .addGroup(
                                                javax.swing.GroupLayout.Alignment.TRAILING,
                                                jPanel2Layout
                                                    .createSequentialGroup()
                                                    .addComponent(
                                                        jComboBox1,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(65, 65, 65))))
                            .addGroup(
                                jPanel2Layout
                                    .createSequentialGroup()
                                    .addGroup(
                                        jPanel2Layout
                                            .createParallelGroup(
                                                javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(
                                                jPanel2Layout
                                                    .createSequentialGroup()
                                                    .addComponent(jLabel2)
                                                    .addGap(0, 0, Short.MAX_VALUE))
                                            .addComponent(jTextField1)
                                            .addComponent(
                                                jScrollPane1,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addContainerGap()))));
    jPanel2Layout.setVerticalGroup(
        jPanel2Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel2Layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(ajoutElement)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(jLabel2)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                    .addComponent(
                        jComboBox1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        javax.swing.GroupLayout.DEFAULT_SIZE,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(199, 199, 199)
                    .addComponent(
                        jScrollPane1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        107,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(32, 32, 32)
                    .addComponent(
                        jTextField1,
                        javax.swing.GroupLayout.PREFERRED_SIZE,
                        146,
                        javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(127, Short.MAX_VALUE)));

    jTabbedPane.addTab("Plan", jPanel2);

    ajoutCamion.setText("Ajouter un camion");
    ajoutCamion.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            ajoutCamionActionPerformed(evt);
          }
        });

    ajoutChargeur.setText("Ajouter un chargeur");

    ajoutSimulation.setText("Ajout Simulation");
    ajoutSimulation.addActionListener(
        new java.awt.event.ActionListener() {
          public void actionPerformed(java.awt.event.ActionEvent evt) {
            ajoutSimulationActionPerformed(evt);
          }
        });

    javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
    jPanel3.setLayout(jPanel3Layout);
    jPanel3Layout.setHorizontalGroup(
        jPanel3Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                jPanel3Layout
                    .createSequentialGroup()
                    .addContainerGap(45, Short.MAX_VALUE)
                    .addGroup(
                        jPanel3Layout
                            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(
                                ajoutChargeur,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE)
                            .addComponent(
                                ajoutCamion,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE))
                    .addGap(53, 53, 53))
            .addGroup(
                jPanel3Layout
                    .createSequentialGroup()
                    .addGap(56, 56, 56)
                    .addComponent(ajoutSimulation)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));
    jPanel3Layout.setVerticalGroup(
        jPanel3Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel3Layout
                    .createSequentialGroup()
                    .addGap(29, 29, 29)
                    .addComponent(ajoutSimulation)
                    .addGap(33, 33, 33)
                    .addComponent(ajoutCamion)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(ajoutChargeur)
                    .addContainerGap(558, Short.MAX_VALUE)));

    jTabbedPane.addTab("Simulation", jPanel3);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                jPanel1Layout
                    .createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane)
                    .addContainerGap()));
    jPanel1Layout.setVerticalGroup(
        jPanel1Layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(
                javax.swing.GroupLayout.Alignment.TRAILING,
                jPanel1Layout.createSequentialGroup().addComponent(jTabbedPane).addContainerGap()));

    mainPanel.add(jPanel1, java.awt.BorderLayout.EAST);

    fichierMenu.setText("Fichier");

    menuNouveauProjet.setText("Nouveau projet");
    menuNouveauProjet.addActionListener(
        new java.awt.event.ActionListener() {
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
    menuQuitter.addActionListener(
        new java.awt.event.ActionListener() {
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
    menuAffichageGrille.addMouseListener(
        new java.awt.event.MouseAdapter() {
          public void mouseClicked(java.awt.event.MouseEvent evt) {
            menuAffichageGrilleMouseClicked(evt);
          }
        });
    menuAffichageGrille.addActionListener(
        new java.awt.event.ActionListener() {
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
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 1524, Short.MAX_VALUE));
    layout.setVerticalGroup(
        layout
            .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(
                mainPanel,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                javax.swing.GroupLayout.DEFAULT_SIZE,
                Short.MAX_VALUE));

    pack();
  } // </editor-fold>//GEN-END:initComponents

  private void jTextArea1ComponentAdded(
      java.awt.event.ContainerEvent evt) { // GEN-FIRST:event_jTextArea1ComponentAdded
  } // GEN-LAST:event_jTextArea1ComponentAdded

  private void jTextField1ActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jTextField1ActionPerformed
    for (Element item : elementContainer.getEquipemenetList()) {
      if (item.isSelected()) {
        System.out.println(item.getX());
      }
    }
  } // GEN-LAST:event_jTextField1ActionPerformed

  private void drawingPanelMouseDragged(java.awt.event.MouseEvent evt) {
    if (SwingUtilities.isRightMouseButton(evt)) {
      delta.setLocation(
          (evt.getX() - this.currentMousePoint.getX()),
          (evt.getY() - this.currentMousePoint.getY()));
      this.controller.updateSelectedItemsPositions(delta);
      this.currentMousePoint = evt.getPoint();
      drawingPanel.repaint();
    }
  } // GEN-LAST:event_drawingPanelMouseDragged

  private void ajoutSimulationActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_ajoutSimulationActionPerformed
    this.setAppMode(ApplicationMode.ADD_SIMULATION);
  } // GEN-LAST:event_ajoutSimulationActionPerformed

  private void ajoutElementActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_ajoutElementActionPerformed
    this.setAppMode(ApplicationMode.ADD_PLAN);
  } // GEN-LAST:event_ajoutElementActionPerformed

  private void ajoutCamionActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_ajoutCamionActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_ajoutCamionActionPerformed

  private void drawingPanelMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
    Point point = evt.getPoint();
    this.currentMousePoint = evt.getPoint();
    if (evt.getPreciseWheelRotation() > 0) {
      drawingPanel.zoomIn(point);
    } else {
      drawingPanel.zoomOut(point);
    }
  } // GEN-LAST:event_drawingPanelMouseWheelMoved

  private void jComboBox1ActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jComboBox1ActionPerformed
    if (jComboBox1.getSelectedItem() == "Broyeur") {
      this.setMode(EquipementModes.BROYEUR);

    } else if (jComboBox1.getSelectedItem() == "Concasseur") {
      this.setMode(EquipementModes.CONCASSEUR);

    } else if (jComboBox1.getSelectedItem() == "Crible") {
      this.setMode(EquipementModes.CRIBLE);

    } else if (jComboBox1.getSelectedItem() == "Convoyeur") {
      this.setMode(EquipementModes.CONVOYEUR);
    } else if (jComboBox1.getSelectedItem() == "Noeud") {
      this.setMode(EquipementModes.NOEUD);
    }
  } // GEN-LAST:event_jComboBox1ActionPerformed

  private void modeSelectionActionPerformed(java.awt.event.ActionEvent evt) {
    this.setAppMode(ApplicationMode.SELECT);
  }

  private void AddBroyeurActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_AddBroyeurActionPerformed
    // TODO add your handling code here:
    this.setMode(EquipementModes.BROYEUR);
  } // GEN-LAST:event_AddBroyeurActionPerformed

  private void addConcasseurActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_addConcasseurActionPerformed
    this.setMode(EquipementModes.CONCASSEUR);
  } // GEN-LAST:event_addConcasseurActionPerformed

  private void addCribleActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_addCribleActionPerformed
    this.setMode(EquipementModes.CRIBLE);
  } // GEN-LAST:event_addCribleActionPerformed

  private void addConvoyeurActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_addConvoyeurActionPerformed
    // TODO add your handling code here:
    this.setMode(EquipementModes.CONVOYEUR);
  } // GEN-LAST:event_addConvoyeurActionPerformed

  private void drawingPanelMousePressed(java.awt.event.MouseEvent evt) {
    Point mousePoint = evt.getPoint();
    this.currentMousePoint = mousePoint;

    if (this.currentApplicationMode == ApplicationMode.SELECT
        && SwingUtilities.isLeftMouseButton(evt)) {
      // double xPos = this.currentMousePoint.getX();
      // double yPos = this.currentMousePoint.getY();
      this.controller.switchSelectionStatus(
          mousePoint.getX(), mousePoint.getY(), evt.isShiftDown());
      drawingPanel.repaint();
    } else if (this.currentApplicationMode == ApplicationMode.ADD_PLAN
        && SwingUtilities.isLeftMouseButton(evt)) {
      Controller.EquipementModes actualEquipement = this.selectedEquipementMode;
      this.controller.addEquipement(actualEquipement, mousePoint);
      drawingPanel.repaint();
    }
  }

  private void drawingPanelMouseMoved(java.awt.event.MouseEvent evt) {

    Point mousePoint = evt.getPoint();
    drawingPanel.setMouseX(mousePoint.getX());
    drawingPanel.setMouseY(mousePoint.getY());
    drawingPanel.repaint();
  }

  private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {}

  private void mainScrollPaneMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
    Point point = evt.getPoint();
    this.currentMousePoint = evt.getPoint();
    if (evt.getPreciseWheelRotation() > 0) {
      drawingPanel.zoomIn(point);
    } else {
      drawingPanel.zoomOut(point);
    }
  }

  private void menuNouveauProjetActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_menuNouveauProjetActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_menuNouveauProjetActionPerformed

  private void menuQuitterActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_menuQuitterActionPerformed
    System.exit(0);
  } // GEN-LAST:event_menuQuitterActionPerformed

  private void buttonAjouterNoeudActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_buttonAjouterNoeudActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_buttonAjouterNoeudActionPerformed

  private void buttonAjouterArcActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_buttonAjouterArcActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_buttonAjouterArcActionPerformed

  private void buttonAjouterConcasseurActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_buttonAjouterConcasseurActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_buttonAjouterConcasseurActionPerformed

  private void buttonAjouterConvoyeurActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_buttonAjouterConvoyeurActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_buttonAjouterConvoyeurActionPerformed

  private void jButton1ActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jButton1ActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_jButton1ActionPerformed

  private void jButton4ActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_jButton4ActionPerformed
    // TODO add your handling code here:
  } // GEN-LAST:event_jButton4ActionPerformed

  private void menuAffichageGrilleActionPerformed(
      java.awt.event.ActionEvent evt) { // GEN-FIRST:event_menuAffichageGrilleActionPerformed
    drawingPanel.setGridLines();
  } // GEN-LAST:event_menuAffichageGrilleActionPerformed

  private void menuAffichageGrilleMouseClicked(
      java.awt.event.MouseEvent evt) { // GEN-FIRST:event_menuAffichageGrilleMouseClicked
    // TODO add your handling code here:
  } // GEN-LAST:event_menuAffichageGrilleMouseClicked

  /** @param args the command line arguments */
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
      for (javax.swing.UIManager.LookAndFeelInfo info :
          javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(MainWindow.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(MainWindow.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(MainWindow.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(MainWindow.class.getName())
          .log(java.util.logging.Level.SEVERE, null, ex);
    }
    // </editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(
        new Runnable() {
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

  public void draw(Graphics2D g, DrawingPanel drawingPanel, double zoom) {
    // controller.draw(g, getCurrentMeasurementUnitMode(), drawingPanel, zoom, currentMousePoint);
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JMenu affichageMenu;
  private javax.swing.JToggleButton ajoutCamion;
  private javax.swing.JToggleButton ajoutChargeur;
  private javax.swing.JToggleButton ajoutElement;
  private javax.swing.JToggleButton ajoutSimulation;
  private javax.swing.ButtonGroup buttonGroup1;
  private javax.swing.JPanel buttonTopPanel;
  private virtucarriere.gui.DrawingPanel drawingPanel;
  private javax.swing.JMenu editionMenu;
  private javax.swing.JMenu fenetreMenu;
  private javax.swing.JMenu fichierMenu;
  private javax.swing.JMenuItem importerCarriereMenu;
  private javax.swing.JMenu importerMenu;
  private javax.swing.JMenuItem importerSimulationMenu;
  private javax.swing.JComboBox<String> jComboBox1;
  private javax.swing.JLabel jLabel2;
  private javax.swing.JMenuBar jMenuBar1;
  private javax.swing.JMenuItem jMenuItem6;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JPanel jPanel2;
  private javax.swing.JPanel jPanel3;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JTabbedPane jTabbedPane;
  private javax.swing.JTextArea jTextArea1;
  private javax.swing.JTextField jTextField1;
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
  private javax.swing.JToggleButton modeSelection;
  // End of variables declaration//GEN-END:variables
}
