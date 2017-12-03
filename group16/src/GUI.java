/**
 * Created by njosepa on 23/01/2017.
 * Contributed by all team members
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTable table;
    public static String f;

    /**
     * Create the frame.
     */
    public GUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Group 16 Module Analyser");
        setResizable(false);
        setBounds(0, 0, 900, 850);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        Object frame = null;
        JOptionPane.showMessageDialog((Component) frame, "Welcome to GradeUtil by Group 16 , if you are a beginner please use our guide as tutorial.");

        JFileChooser chooser = new JFileChooser();
        int returnVal = chooser.showOpenDialog(getParent());
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            f = chooser.getSelectedFile().getAbsolutePath();
            Import.fileRead();
            Modules.runAllMethods();                    //Modules Average

            SwingUtilities.invokeLater(new Runnable() { //Graph creation
                @Override
                public void run() {
                    Bargraph.window();
                    Bargraph2.window();
                    Bargraph3.window();
                    Bargraph4.window();
                    Bargraph5.window();
                    PieCharts.window();
                }
            });

            Weight.weighting();
            Data.frame();   //Table with module average
        }

        Panel piePanel = new Panel();
        piePanel.setBounds(50, 50, 775, 550);
        piePanel.add(PieCharts.fxPie);
        contentPane.add(piePanel);

        Panel guide = new Panel();
        guide.setBounds(50, 50, 775, 550);
        JTextArea text = new JTextArea();
        text.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        text.setText("Help guide: \nThere is a menu bar at the top left that says View Filter.\n It gives options of what data or graphs you would" +
                "like to see.\n After all the data has been seen, " +
                "you will be able to export\n those images and data as a pdf file for the data to\n be more readable and in a good format.");

        guide.add(text);
        contentPane.add(guide);

        JPanel tablePanel = new JPanel();
        tablePanel.setBounds(50, 50, 775, 550);
        JLabel title = new JLabel("Final Module Rank");
        tablePanel.add(title);
        tablePanel.add(Data.test);
        contentPane.add(tablePanel);

        Panel tablePanel2 = new Panel();
        tablePanel2.setBounds(50, 50, 775, 550);
        JLabel titleSS = new JLabel("Strong Students");
        tablePanel2.add(titleSS);
        tablePanel2.add(Data.StrongS);
        contentPane.add(tablePanel2);

        Panel tablePanel3 = new Panel();
        tablePanel3.setBounds(50, 50, 775, 550);
        JLabel titleWS = new JLabel("Weak Students");
        tablePanel3.add(titleWS);
        tablePanel3.add(Data.WeakS);
        contentPane.add(tablePanel3);

        Panel barPanel1 = new Panel();
        barPanel1.setBounds(50, 50, 775, 550);
        barPanel1.add(Bargraph.fxPanel);
        contentPane.add(barPanel1);

        Panel barPanel2 = new Panel();
        barPanel2.setBounds(50, 50, 775, 550);
        barPanel2.add(Bargraph2.fxPanel2);
        contentPane.add(barPanel2);

        Panel barPanel3 = new Panel();
        barPanel3.setBounds(50, 50, 775, 550);
        barPanel3.add(Bargraph3.fxPanel);
        contentPane.add(barPanel3);

        Panel barPanel4 = new Panel();
        barPanel4.setBounds(50, 50, 775, 550);
        barPanel4.add(Bargraph4.fxPanel);
        contentPane.add(barPanel4);

        Panel barPanel5 = new Panel();
        barPanel5.setBounds(50, 50, 775, 550);
        barPanel5.add(Bargraph5.fxPanel);
        contentPane.add(barPanel5);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setBounds(0, 0, 890, 21);
        contentPane.add(menuBar);

        JMenu mnFile = new JMenu("View Filters");
        menuBar.add(mnFile);

        JMenuItem tableBar0 = new JMenuItem(new AbstractAction("Final Module Rank") {
            public void actionPerformed(ActionEvent e) {
                tablePanel.setVisible(true);
                ChartImg.makePanelImage(tablePanel, "Ftable.png");
                tablePanel2.setVisible(false);
                tablePanel3.setVisible(false);
                piePanel.setVisible(false);
                barPanel1.setVisible(false);
                barPanel2.setVisible(false);
                barPanel3.setVisible(false);
                barPanel4.setVisible(false);
                barPanel5.setVisible(false);
                guide.setVisible(false);
            }
        });
        mnFile.add(tableBar0);

        JMenuItem tableBar1 = new JMenuItem(new AbstractAction("Strong Students Module Ranking") {
            public void actionPerformed(ActionEvent e) {
                tablePanel.setVisible(false);
                tablePanel2.setVisible(true);
                ChartImg.makePanelImage(tablePanel2, "Stable.png");
                tablePanel3.setVisible(false);
                piePanel.setVisible(false);
                barPanel1.setVisible(false);
                barPanel2.setVisible(false);
                barPanel3.setVisible(false);
                barPanel4.setVisible(false);
                barPanel5.setVisible(false);
                guide.setVisible(false);
            }
        });
        mnFile.add(tableBar1);

        JMenuItem tableBar2 = new JMenuItem(new AbstractAction("Weak Students Module Ranking") {
            public void actionPerformed(ActionEvent e) {
                tablePanel.setVisible(false);
                tablePanel2.setVisible(false);
                tablePanel3.setVisible(true);
                ChartImg.makePanelImage(tablePanel3, "Wtable.png");
                piePanel.setVisible(false);
                barPanel1.setVisible(false);
                barPanel2.setVisible(false);
                barPanel3.setVisible(false);
                barPanel4.setVisible(false);
                barPanel5.setVisible(false);
                guide.setVisible(false);
            }
        });
        mnFile.add(tableBar2);

        JMenuItem menuBar0 = new JMenuItem(new AbstractAction("Module Average") {
            public void actionPerformed(ActionEvent e) {
                tablePanel.setVisible(false);
                tablePanel2.setVisible(false);
                tablePanel3.setVisible(false);
                piePanel.setVisible(true);
                barPanel1.setVisible(false);
                barPanel2.setVisible(false);
                barPanel3.setVisible(false);
                barPanel4.setVisible(false);
                barPanel5.setVisible(false);
                guide.setVisible(false);
            }
        });
        mnFile.add(menuBar0);

        JMenuItem menuBar1 = new JMenuItem(new AbstractAction("Module Average for first class") {
            public void actionPerformed(ActionEvent e) {
                tablePanel.setVisible(false);
                tablePanel2.setVisible(false);
                tablePanel3.setVisible(false);
                piePanel.setVisible(false);
                barPanel1.setVisible(true);
                barPanel2.setVisible(false);
                barPanel3.setVisible(false);
                barPanel4.setVisible(false);
                barPanel5.setVisible(false);
                guide.setVisible(false);
            }
        });
        mnFile.add(menuBar1);

        JMenuItem menuBar2 = new JMenuItem(new AbstractAction("Module Average for 2:1 class") {
            public void actionPerformed(ActionEvent e) {
                tablePanel.setVisible(false);
                tablePanel2.setVisible(false);
                tablePanel3.setVisible(false);
                piePanel.setVisible(false);
                barPanel1.setVisible(false);
                barPanel2.setVisible(true);
                barPanel3.setVisible(false);
                barPanel4.setVisible(false);
                barPanel5.setVisible(false);
                guide.setVisible(false);
            }
        });
        mnFile.add(menuBar2);

        JMenuItem menuBar3 = new JMenuItem(new AbstractAction("Module Average for 2:2 class") {
            public void actionPerformed(ActionEvent e) {
                tablePanel.setVisible(false);
                tablePanel2.setVisible(false);
                tablePanel3.setVisible(false);
                piePanel.setVisible(false);
                barPanel1.setVisible(false);
                barPanel2.setVisible(false);
                barPanel3.setVisible(true);
                barPanel4.setVisible(false);
                barPanel5.setVisible(false);
                guide.setVisible(false);
            }
        });
        mnFile.add(menuBar3);

        JMenuItem menuBar4 = new JMenuItem(new AbstractAction("Module Average for Pass Class") {
            public void actionPerformed(ActionEvent e) {
                tablePanel.setVisible(false);
                tablePanel2.setVisible(false);
                tablePanel3.setVisible(false);
                piePanel.setVisible(false);
                barPanel1.setVisible(false);
                barPanel2.setVisible(false);
                barPanel3.setVisible(false);
                barPanel4.setVisible(true);
                barPanel5.setVisible(false);
                guide.setVisible(false);
            }
        });
        mnFile.add(menuBar4);

        JMenuItem menuBar5 = new JMenuItem(new AbstractAction("Module Average for Fail Class") {
            public void actionPerformed(ActionEvent e) {
                tablePanel.setVisible(false);
                tablePanel2.setVisible(false);
                tablePanel3.setVisible(false);
                piePanel.setVisible(false);
                barPanel1.setVisible(false);
                barPanel2.setVisible(false);
                barPanel3.setVisible(false);
                barPanel4.setVisible(false);
                barPanel5.setVisible(true);
                guide.setVisible(false);
            }
        });
        mnFile.add(menuBar5);

        JMenu mnNewMenu = new JMenu("About");
        menuBar.add(mnNewMenu);

        JMenuItem mntmNewMenuItem = new JMenuItem(new AbstractAction("Guide") {
            public void actionPerformed(ActionEvent e) {
                tablePanel.setVisible(false);
                tablePanel2.setVisible(false);
                tablePanel3.setVisible(false);
                piePanel.setVisible(false);
                barPanel1.setVisible(false);
                barPanel2.setVisible(false);
                barPanel3.setVisible(false);
                barPanel4.setVisible(false);
                barPanel5.setVisible(false);
                guide.setVisible(true);
            }
        });
        mnNewMenu.add(mntmNewMenuItem);

        table = new JTable();
        table.setForeground(Color.WHITE);
        barPanel1.add(table);

        JButton button = new JButton("Export to PDF");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Export.pdfexport();
            }
        });
        button.setBounds(360, 700, 170, 22);
        contentPane.add(button);
    }
}