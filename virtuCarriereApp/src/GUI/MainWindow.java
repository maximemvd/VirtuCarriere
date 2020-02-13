package GUI;

import javax.swing.*;

public class MainWindow extends JFrame {

    private JPanel panel1;
    private JMenuBar MenuBar;
    private JMenu menuFichier;
    private JMenu menuEdition;
    private JMenu menuAffichage;
    private JMenu menuInserer;
    private JMenuItem menuFichierNouveau;
    private JMenuItem menuFichierOuvrir;
    private JMenu menuFenetre;
    private JTabbedPane panneauPermanent;
    private JMenuItem menuFichierSauvegarder;
    private JMenuItem menuFichierSauvegarderSous;
    private JPanel menuPlan;
    private JPanel menuSimulation;
    private JMenuItem editionUndo;
    private JMenuItem editionRedo;

    public MainWindow(){
        add(panel1);
        setTitle("VirtuCarrière");
    }

}
