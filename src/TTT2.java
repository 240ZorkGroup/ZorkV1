import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.GroupLayout;

import static java.awt.Color.*;
import static java.awt.Color.BLACK;
/*
 * Created by JFormDesigner on Tue Nov 15 10:57:13 EST 2016
 */


/**
 * The type Ttt 2.
 *
 * @author Billy Andrews
 */
public class TTT2 extends JFrame implements ActionListener {

    //Fields
    private String monsterName;
    private String playerName;
    private boolean xGoesFirst = true;
    private boolean player1Turn = true;
    private boolean SinglePlayerMode = true;
    private static int playerXScore = 0;
    private static int playerOScore = 0;
    private static int playerTScore = 0;
    /**
     * The But 1.
     */
    static char but1 = '\u0000';
    /**
     * The But 2.
     */
    static char but2 = '\u0000';
    /**
     * The But 3.
     */
    static char but3 = '\u0000';
    /**
     * The But 4.
     */
    static char but4 = '\u0000';
    /**
     * The But 5.
     */
    static char but5 = '\u0000';
    /**
     * The But 6.
     */
    static char but6 = '\u0000';
    /**
     * The But 7.
     */
    static char but7 = '\u0000';
    /**
     * The But 8.
     */
    static char but8 = '\u0000';
    /**
     * The But 9.
     */
    static char but9 = '\u0000';

    /**
     * Constructor for TTT2
     *
     * @param mName the monster's name
     * @param pName the player's name
     */
    public TTT2(String mName, String pName) {
        initComponents();
        monsterName = mName;
        playerName = pName;
    }

    /**
     * initComponents for GUI
     */
    private void initComponents() {
        // JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
        // Generated using JFormDesigner Evaluation license - Billy Andrews
        jPanel1 = new JPanel();
        jButton2 = new JButton();
        jButton3 = new JButton();
        jButton4 = new JButton();
        jButton5 = new JButton();
        jButton6 = new JButton();
        jButton7 = new JButton();
        jButton8 = new JButton();
        jButton9 = new JButton();
        jLabelInfoBar = new JLabel();
        jButton1 = new JButton();

        //======== this ========
        setBackground(Color.white);
        setForeground(Color.black);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setIconImage(null);
        setTitle("GRUE'S TIC TAC TOE");
        setAlwaysOnTop(true);
        setResizable(false);
        setFocusable(false);
        Container contentPane = getContentPane();

        //======== jPanel1 ========
        {
            jPanel1.setBackground(Color.black);

            // JFormDesigner evaluation mark
            jPanel1.setBorder(new javax.swing.border.CompoundBorder(
                new javax.swing.border.TitledBorder(new javax.swing.border.EmptyBorder(0, 0, 0, 0),
                    "JFormDesigner Evaluation", javax.swing.border.TitledBorder.CENTER,
                    javax.swing.border.TitledBorder.BOTTOM, new java.awt.Font("Dialog", java.awt.Font.BOLD, 12),
                    java.awt.Color.red), jPanel1.getBorder())); jPanel1.addPropertyChangeListener(new java.beans.PropertyChangeListener(){public void propertyChange(java.beans.PropertyChangeEvent e){if("border".equals(e.getPropertyName()))throw new RuntimeException();}});


            //---- jButton2 ----
            jButton2.setMaximumSize(new Dimension(75, 75));
            jButton2.setMinimumSize(new Dimension(75, 75));
            jButton2.setPreferredSize(new Dimension(75, 75));
            jButton2.setFocusable(false);
            jButton2.addActionListener(e -> {
                try {
                    jButton2ActionPerformed(e);
                } catch (InterruptedException | NPC.NoNPCException e1) {
                    e1.printStackTrace();
                }
            });

            //---- jButton3 ----
            jButton3.setPreferredSize(new Dimension(75, 75));
            jButton3.setMinimumSize(new Dimension(75, 75));
            jButton3.setMaximumSize(new Dimension(75, 75));
            jButton3.setFocusable(false);
            jButton3.addActionListener(e -> {
                try {
                    jButton3ActionPerformed(e);
                } catch (InterruptedException | NPC.NoNPCException e1) {
                    e1.printStackTrace();
                }
            });

            //---- jButton4 ----
            jButton4.setMaximumSize(new Dimension(75, 75));
            jButton4.setMinimumSize(new Dimension(75, 75));
            jButton4.setPreferredSize(new Dimension(75, 75));
            jButton4.setFocusable(false);
            jButton4.addActionListener(e -> {
                try {
                    jButton4ActionPerformed(e);
                } catch (InterruptedException | NPC.NoNPCException e1) {
                    e1.printStackTrace();
                }
            });

            //---- jButton5 ----
            jButton5.setPreferredSize(new Dimension(75, 75));
            jButton5.setMinimumSize(new Dimension(75, 75));
            jButton5.setMaximumSize(new Dimension(75, 75));
            jButton5.setFocusable(false);
            jButton5.addActionListener(e -> {
                try {
                    jButton5ActionPerformed(e);
                } catch (InterruptedException | NPC.NoNPCException e1) {
                    e1.printStackTrace();
                }
            });

            //---- jButton6 ----
            jButton6.setMaximumSize(new Dimension(75, 75));
            jButton6.setMinimumSize(new Dimension(75, 75));
            jButton6.setPreferredSize(new Dimension(75, 75));
            jButton6.setFocusable(false);
            jButton6.addActionListener(e -> {
                try {
                    jButton6ActionPerformed(e);
                } catch (InterruptedException | NPC.NoNPCException e1) {
                    e1.printStackTrace();
                }
            });

            //---- jButton7 ----
            jButton7.setMaximumSize(new Dimension(75, 75));
            jButton7.setMinimumSize(new Dimension(75, 75));
            jButton7.setPreferredSize(new Dimension(75, 75));
            jButton7.setFocusable(false);
            jButton7.addActionListener(e -> {
                try {
                    jButton7ActionPerformed(e);
                } catch (InterruptedException | NPC.NoNPCException e1) {
                    e1.printStackTrace();
                }
            });

            //---- jButton8 ----
            jButton8.setPreferredSize(new Dimension(75, 75));
            jButton8.setMinimumSize(new Dimension(75, 75));
            jButton8.setMaximumSize(new Dimension(75, 75));
            jButton8.setFocusable(false);
            jButton8.addActionListener(e -> {
                try {
                    jButton8ActionPerformed(e);
                } catch (InterruptedException | NPC.NoNPCException e1) {
                    e1.printStackTrace();
                }
            });

            //---- jButton9 ----
            jButton9.setPreferredSize(new Dimension(75, 75));
            jButton9.setMinimumSize(new Dimension(75, 75));
            jButton9.setMaximumSize(new Dimension(75, 75));
            jButton9.setFocusable(false);
            jButton9.addActionListener(e -> {
                try {
                    jButton9ActionPerformed(e);
                } catch (InterruptedException | NPC.NoNPCException e1) {
                    e1.printStackTrace();
                }
            });

            //---- jLabelInfoBar ----
            jLabelInfoBar.setText("Your turn");
            jLabelInfoBar.setHorizontalAlignment(SwingConstants.CENTER);
            jLabelInfoBar.setFont(new Font("Dialog", Font.BOLD, 16));
            jLabelInfoBar.setMaximumSize(new Dimension(75, 40));
            jLabelInfoBar.setMinimumSize(new Dimension(75, 40));
            jLabelInfoBar.setPreferredSize(new Dimension(75, 40));
            jLabelInfoBar.setHorizontalTextPosition(SwingConstants.CENTER);
            jLabelInfoBar.setOpaque(true);
            jLabelInfoBar.setFocusable(false);

            //---- jButton1 ----
            jButton1.setMaximumSize(new Dimension(75, 75));
            jButton1.setMinimumSize(new Dimension(75, 75));
            jButton1.setPreferredSize(new Dimension(75, 75));
            jButton1.setFocusable(false);
            jButton1.addActionListener(e -> {
                try {
                    jButton1ActionPerformed(e);
                } catch (InterruptedException | NPC.NoNPCException e1) {
                    e1.printStackTrace();
                }
            });

            GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
            jPanel1.setLayout(jPanel1Layout);
            jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup()
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabelInfoBar, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
            );
            jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup()
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton4, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton6, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton7, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton8, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton9, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelInfoBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))
            );
        }

        GroupLayout contentPaneLayout = new GroupLayout(contentPane);
        contentPane.setLayout(contentPaneLayout);
        contentPaneLayout.setHorizontalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        contentPaneLayout.setVerticalGroup(
            contentPaneLayout.createParallelGroup()
                .addGroup(contentPaneLayout.createSequentialGroup()
                    .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE))
        );
        pack();
        setLocationRelativeTo(getOwner());
        // JFormDesigner - End of component initialization  //GEN-END:initComponents
    }

    // JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
    // Generated using JFormDesigner Evaluation license - Billy Andrews
    private JPanel jPanel1;
    private JButton jButton2;
    private JButton jButton3;
    private JButton jButton4;
    private JButton jButton5;
    private JButton jButton6;
    private JButton jButton7;
    private JButton jButton8;
    private JButton jButton9;
    private JLabel jLabelInfoBar;
    private JButton jButton1;
    // JFormDesigner - End of variables declaration  //GEN-END:variables


    /**
     * COMPUTER, GO!
     * <p>
     * The code for when it's the computer's turn. An excessively long algorithm I created.
     */
    void computerGo() {
        String[] buttonListStrings = {jButton1.getText(), jButton2.getText(), jButton3.getText(),
                jButton4.getText(), jButton5.getText(), jButton6.getText(),
                jButton7.getText(), jButton8.getText(), jButton9.getText()};
        int rando = 1 + (int) (Math.random() * ((9 - 1) + 1));
        //System.out.print(rando);
            if (!"".equals(buttonListStrings[rando - 1])) {
                computerGo();
            } else if (but1 == '\u0000' && but2 == '\u0000' && but3 == '\u0000' &&
                    but4 == '\u0000' && but5 == '\u0000' && but6 == '\u0000' &&
                    but7 == '\u0000' && but8 == '\u0000' && but9 == '\u0000'){
                switch (rando) {
                    case 1:
                        jButton1.doClick(250);
                        break;
                    case 2:
                        jButton2.doClick(250);
                        break;
                    case 3:
                        jButton3.doClick(250);
                        break;
                    case 4:
                        jButton4.doClick(250);
                        break;
                    case 5:
                        jButton5.doClick(250);
                        break;
                    case 6:
                        jButton6.doClick(250);
                        break;
                    case 7:
                        jButton7.doClick(250);
                        break;
                    case 8:
                        jButton8.doClick(250);
                        break;
                    case 9:
                        jButton9.doClick(250);
                        break;
                }
            } else if (but1 == 'o' && but2 == 'o' && but3 == '\u0000') {
                jButton3.doClick(250);
            } else if (but1 == 'o' && but2 == '\u0000' && but3 == 'o') {
                jButton2.doClick(250);
            } else if (but1 == '\u0000' && but2 == 'o' && but3 == 'o') {
                jButton1.doClick(250);
            } else if (but4 == '\u0000' && but5 == 'o' && but6 == 'o') {
                jButton4.doClick(250);
            } else if (but4 == 'o' && but5 == '\u0000' && but6 == 'o') {
                jButton5.doClick(250);
            } else if (but4 == 'o' && but5 == 'o' && but6 == '\u0000') {
                jButton6.doClick(250);
            } else if (but7 == '\u0000' && but8 == 'o' && but9 == 'o') {
                jButton7.doClick(250);
            } else if (but7 == 'o' && but8 == '\u0000' && but9 == 'o') {
                jButton8.doClick(250);
            } else if (but7 == 'o' && but8 == 'o' && but9 == '\u0000') {
                jButton9.doClick(250);
            } else if (but1 == '\u0000' && but4 == 'o' && but7 == 'o') {
                jButton1.doClick(250);
            } else if (but1 == 'o' && but4 == '\u0000' && but7 == 'o') {
                jButton4.doClick(250);
            } else if (but1 == 'o' && but4 == 'o' && but7 == '\u0000') {
                jButton7.doClick(250);
            } else if (but2 == '\u0000' && but5 == 'o' && but8 == 'o') {
                jButton2.doClick(250);
            } else if (but2 == 'o' && but5 == '\u0000' && but8 == 'o') {
                jButton5.doClick(250);
            } else if (but2 == 'o' && but5 == 'o' && but8 == '\u0000') {
                jButton8.doClick(250);
            } else if (but3 == '\u0000' && but6 == 'o' && but9 == 'o') {
                jButton3.doClick(250);
            } else if (but3 == 'o' && but6 == '\u0000' && but9 == 'o') {
                jButton6.doClick(250);
            } else if (but3 == 'o' && but6 == 'o' && but9 == '\u0000') {
                jButton9.doClick(250);
            } else if (but1 == '\u0000' && but5 == 'o' && but9 == 'o') {
                jButton1.doClick(250);
            } else if (but1 == 'o' && but5 == '\u0000' && but9 == 'o') {
                jButton5.doClick(250);
            } else if (but1 == 'o' && but5 == 'o' && but9 == '\u0000') {
                jButton9.doClick(250);
            } else if (but7 == '\u0000' && but5 == 'o' && but3 == 'o') {
                jButton7.doClick(250);
            } else if (but7 == 'o' && but5 == '\u0000' && but3 == 'o') {
                jButton5.doClick(250);
            } else if (but7 == 'o' && but5 == 'o' && but3 == '\u0000') {
                // If the CPU can block the PLAYER from winning:
                jButton3.doClick(250);
            } else if (but1 == 'x' && but2 == 'x' && but3 == '\u0000') {
                jButton3.doClick(250);
            } else if (but1 == 'x' && but2 == '\u0000' && but3 == 'x') {
                jButton2.doClick(250);
            } else if (but1 == '\u0000' && but2 == 'x' && but3 == 'x') {
                jButton1.doClick(250);
            } else if (but4 == '\u0000' && but5 == 'x' && but6 == 'x') {
                jButton4.doClick(250);
            } else if (but4 == 'x' && but5 == '\u0000' && but6 == 'x') {
                jButton5.doClick(250);
            } else if (but4 == 'x' && but5 == 'x' && but6 == '\u0000') {
                jButton6.doClick(250);
            } else if (but7 == '\u0000' && but8 == 'x' && but9 == 'x') {
                jButton7.doClick(250);
            } else if (but7 == 'x' && but8 == '\u0000' && but9 == 'x') {
                jButton8.doClick(250);
            } else if (but7 == 'x' && but8 == 'x' && but9 == '\u0000') {
                jButton9.doClick(250);
            } else if (but1 == '\u0000' && but4 == 'x' && but7 == 'x') {
                jButton1.doClick(250);
            } else if (but1 == 'x' && but4 == '\u0000' && but7 == 'x') {
                jButton4.doClick(250);
            } else if (but1 == 'x' && but4 == 'x' && but7 == '\u0000') {
                jButton7.doClick(250);
            } else if (but2 == '\u0000' && but5 == 'x' && but8 == 'x') {
                jButton2.doClick(250);
            } else if (but2 == 'x' && but5 == '\u0000' && but8 == 'x') {
                jButton5.doClick(250);
            } else if (but2 == 'x' && but5 == 'x' && but8 == '\u0000') {
                jButton8.doClick(250);
            } else if (but3 == '\u0000' && but6 == 'x' && but9 == 'x') {
                jButton3.doClick(250);
            } else if (but3 == 'x' && but6 == '\u0000' && but9 == 'x') {
                jButton6.doClick(250);
            } else if (but3 == 'x' && but6 == 'x' && but9 == '\u0000') {
                jButton9.doClick(250);
            } else if (but1 == '\u0000' && but5 == 'x' && but9 == 'x') {
                jButton1.doClick(250);
            } else if (but1 == 'x' && but5 == '\u0000' && but9 == 'x') {
                jButton5.doClick(250);
            } else if (but1 == 'x' && but5 == 'x' && but9 == '\u0000') {
                jButton9.doClick(250);
            } else if (but7 == '\u0000' && but5 == 'x' && but3 == 'x') {
                jButton7.doClick(250);
            } else if (but7 == 'x' && but5 == '\u0000' && but3 == 'x') {
                jButton5.doClick(250);
            } else if (but7 == 'x' && but5 == 'x' && but3 == '\u0000') {
                // If there are two open spaces:
                jButton3.doClick(250);
            } else if (but1 == 'o' && but2 == '\u0000' && but3 == '\u0000') {
                if (rando%2==1)
                    jButton3.doClick(250);
                else
                    jButton2.doClick(250);
            } else if (but1 == '\u0000' && but2 == '\u0000' && but3 == 'o') {
                if (rando%2==1)
                    jButton2.doClick(250);
                else
                    jButton1.doClick(250);
            } else if (but1 == '\u0000' && but2 == 'o' && but3 == '\u0000') {
                if (rando%2==1)
                    jButton1.doClick(250);
                else
                    jButton3.doClick(250);
            } else if (but4 == '\u0000' && but5 == '\u0000' && but6 == 'o') {
                if (rando%2==1)
                    jButton4.doClick(250);
                else
                    jButton5.doClick(250);
            } else if (but4 == 'o' && but5 == '\u0000' && but6 == '\u0000') {
                if (rando%2==1)
                    jButton5.doClick(250);
                else
                    jButton6.doClick(250);
            } else if (but4 == '\u0000' && but5 == 'o' && but6 == '\u0000') {
                if (rando%2==1)
                    jButton6.doClick(250);
                else
                    jButton4.doClick(250);
            } else if (but7 == '\u0000' && but8 == '\u0000' && but9 == 'o') {
                if (rando%2==1)
                    jButton7.doClick(250);
                else
                    jButton8.doClick(250);
            } else if (but7 == 'o' && but8 == '\u0000' && but9 == '\u0000') {
                if (rando%2==1)
                    jButton8.doClick(250);
                else
                    jButton9.doClick(250);
            } else if (but7 == '\u0000' && but8 == 'o' && but9 == '\u0000') {
                if (rando%2==1)
                    jButton9.doClick(250);
                else
                    jButton7.doClick(250);
            } else if (but1 == '\u0000' && but4 == 'o' && but7 == '\u0000') {
                if (rando%2==1)
                    jButton1.doClick(250);
                else
                    jButton7.doClick(250);
            } else if (but1 == '\u0000' && but4 == '\u0000' && but7 == 'o') {
                if (rando%2==1)
                    jButton4.doClick(250);
                else
                    jButton1.doClick(250);
            } else if (but1 == 'o' && but4 == '\u0000' && but7 == '\u0000') {
                if (rando%2==1)
                    jButton7.doClick(250);
                else
                    jButton4.doClick(250);
            } else if (but2 == '\u0000' && but5 == 'o' && but8 == '\u0000') {
                if (rando%2==1)
                    jButton2.doClick(250);
                else
                    jButton8.doClick(250);
            } else if (but2 == '\u0000' && but5 == '\u0000' && but8 == 'o') {
                if (rando%2==1)
                    jButton5.doClick(250);
                else
                    jButton2.doClick(250);
            } else if (but2 == 'o' && but5 == '\u0000' && but8 == '\u0000') {
                if (rando%2==1)
                    jButton8.doClick(250);
                else
                    jButton5.doClick(250);
            } else if (but3 == '\u0000' && but6 == 'o' && but9 == '\u0000') {
                if (rando%2==1)
                    jButton3.doClick(250);
                else
                    jButton9.doClick(250);
            } else if (but3 == '\u0000' && but6 == '\u0000' && but9 == 'o') {
                if (rando%2==1)
                    jButton6.doClick(250);
                else
                    jButton3.doClick(250);
            } else if (but3 == 'o' && but6 == '\u0000' && but9 == '\u0000') {
                if (rando%2==1)
                    jButton9.doClick(250);
                else
                    jButton6.doClick(250);
            } else if (but1 == '\u0000' && but5 == '\u0000' && but9 == 'o') {
                if (rando%2==1)
                    jButton1.doClick(250);
                else
                    jButton5.doClick(250);
            } else if (but1 == 'o' && but5 == '\u0000' && but9 == '\u0000') {
                if (rando%2==1)
                    jButton5.doClick(250);
                else
                    jButton9.doClick(250);
            } else if (but1 == '\u0000' && but5 == 'o' && but9 == '\u0000') {
                if (rando%2==1)
                    jButton9.doClick(250);
                else
                    jButton1.doClick(250);
            } else if (but7 == '\u0000' && but5 == '\u0000' && but3 == 'o') {
                if (rando%2==1)
                    jButton7.doClick(250);
                else
                    jButton5.doClick(250);
            } else if (but7 == '\u0000' && but5 == '\u0000' && but3 == 'o') {
                if (rando%2==1)
                    jButton5.doClick(250);
                else
                    jButton7.doClick(250);
            } else if (but7 == 'o' && but5 == '\u0000' && but3 == '\u0000') {
                if (rando%2==1)
                    jButton3.doClick(250);
                else
                    jButton5.doClick(250);
            } else if (but1 == 'x' && but2 == '\u0000' && but3 == '\u0000') {
                if (rando%2==1)
                    jButton3.doClick(250);
                else
                    jButton2.doClick(250);
            } else if (but1 == '\u0000' && but2 == '\u0000' && but3 == 'x') {
                if (rando%2==1)
                    jButton2.doClick(250);
                else
                    jButton1.doClick(250);
            } else if (but1 == '\u0000' && but2 == 'x' && but3 == '\u0000') {
                if (rando%2==1)
                    jButton1.doClick(250);
                else
                    jButton3.doClick(250);
            } else if (but4 == '\u0000' && but5 == '\u0000' && but6 == 'x') {
                if (rando%2==1)
                    jButton4.doClick(250);
                else
                    jButton5.doClick(250);
            } else if (but4 == 'x' && but5 == '\u0000' && but6 == '\u0000') {
                if (rando%2==1)
                    jButton5.doClick(250);
                else
                    jButton6.doClick(250);
            } else if (but4 == '\u0000' && but5 == 'x' && but6 == '\u0000') {
                if (rando%2==1)
                    jButton6.doClick(250);
                else
                    jButton4.doClick(250);
            } else if (but7 == '\u0000' && but8 == '\u0000' && but9 == 'x') {
                if (rando%2==1)
                    jButton7.doClick(250);
                else
                    jButton8.doClick(250);
            } else if (but7 == 'x' && but8 == '\u0000' && but9 == '\u0000') {
                if (rando%2==1)
                    jButton8.doClick(250);
                else
                    jButton9.doClick(250);
            } else if (but7 == '\u0000' && but8 == 'x' && but9 == '\u0000') {
                if (rando%2==1)
                    jButton9.doClick(250);
                else
                    jButton7.doClick(250);
            } else if (but1 == '\u0000' && but4 == 'x' && but7 == '\u0000') {
                if (rando%2==1)
                    jButton1.doClick(250);
                else
                    jButton7.doClick(250);
            } else if (but1 == '\u0000' && but4 == '\u0000' && but7 == 'x') {
                if (rando%2==1)
                    jButton4.doClick(250);
                else
                    jButton1.doClick(250);
            } else if (but1 == 'x' && but4 == '\u0000' && but7 == '\u0000') {
                if (rando%2==1)
                    jButton7.doClick(250);
                else
                    jButton4.doClick(250);
            } else if (but2 == '\u0000' && but5 == 'x' && but8 == '\u0000') {
                if (rando%2==1)
                    jButton2.doClick(250);
                else
                    jButton8.doClick(250);
            } else if (but2 == '\u0000' && but5 == '\u0000' && but8 == 'x') {
                if (rando%2==1)
                    jButton5.doClick(250);
                else
                    jButton2.doClick(250);
            } else if (but2 == 'x' && but5 == '\u0000' && but8 == '\u0000') {
                if (rando%2==1)
                    jButton8.doClick(250);
                else
                    jButton5.doClick(250);
            } else if (but3 == '\u0000' && but6 == 'x' && but9 == '\u0000') {
                if (rando%2==1)
                    jButton3.doClick(250);
                else
                    jButton9.doClick(250);
            } else if (but3 == '\u0000' && but6 == '\u0000' && but9 == 'x') {
                if (rando%2==1)
                    jButton6.doClick(250);
                else
                    jButton3.doClick(250);
            } else if (but3 == 'x' && but6 == '\u0000' && but9 == '\u0000') {
                if (rando%2==1)
                    jButton9.doClick(250);
                else
                    jButton6.doClick(250);
            } else if (but1 == '\u0000' && but5 == '\u0000' && but9 == 'x') {
                if (rando%2==1)
                    jButton1.doClick(250);
                else
                    jButton5.doClick(250);
            } else if (but1 == 'x' && but5 == '\u0000' && but9 == '\u0000') {
                if (rando%2==1)
                    jButton5.doClick(250);
                else
                    jButton9.doClick(250);
            } else if (but1 == '\u0000' && but5 == 'x' && but9 == '\u0000') {
                if (rando%2==1)
                    jButton9.doClick(250);
                else
                    jButton1.doClick(250);
            } else if (but7 == '\u0000' && but5 == '\u0000' && but3 == 'x') {
                if (rando%2==1)
                    jButton7.doClick(250);
                else
                    jButton5.doClick(250);
            } else if (but7 == '\u0000' && but5 == '\u0000' && but3 == 'x') {
                if (rando%2==1)
                    jButton5.doClick(250);
                else
                    jButton7.doClick(250);
            } else if (but7 == 'x' && but5 == '\u0000' && but3 == '\u0000') {
                if (rando%2==1)
                    jButton3.doClick(250);
                else
                    jButton5.doClick(250);
            }
            player1Turn = true;
        }


    /**
     * Keeps track of who's turn it is.
     */
    void changeFirstPlayer() {
        if (xGoesFirst) {
            xGoesFirst = false;
        } else {
            xGoesFirst = true;
        }
    }

    /**
     * Changes the button's colors if triple is a winner
     */
    void changeButtonColor() {
        if (but1 == 'x' && but2 == 'x' && but3 == 'x') {
            jButton1.setForeground(RED);
            jButton2.setForeground(RED);
            jButton3.setForeground(RED);
        } else if (but4 == 'x' && but5 == 'x' && but6 == 'x') {
            jButton4.setForeground(RED);
            jButton5.setForeground(RED);
            jButton6.setForeground(RED);
        } else if (but7 == 'x' && but8 == 'x' && but9 == 'x') {
            jButton7.setForeground(RED);
            jButton8.setForeground(RED);
            jButton9.setForeground(RED);
        } else if (but1 == 'x' && but4 == 'x' && but7 == 'x') {
            jButton1.setForeground(RED);
            jButton4.setForeground(RED);
            jButton7.setForeground(RED);
        } else if (but2 == 'x' && but5 == 'x' && but8 == 'x') {
            jButton2.setForeground(RED);
            jButton5.setForeground(RED);
            jButton8.setForeground(RED);
        } else if (but3 == 'x' && but6 == 'x' && but9 == 'x') {
            jButton3.setForeground(RED);
            jButton6.setForeground(RED);
            jButton9.setForeground(RED);
        } else if (but1 == 'x' && but5 == 'x' && but9 == 'x') {
            jButton1.setForeground(RED);
            jButton5.setForeground(RED);
            jButton9.setForeground(RED);
        } else if (but7 == 'x' && but5 == 'x' && but3 == 'x') {
            jButton7.setForeground(RED);
            jButton5.setForeground(RED);
            jButton3.setForeground(RED);
        } else if (but1 == 'o' && but2 == 'o' && but3 == 'o') {
            jButton1.setForeground(BLUE);
            jButton2.setForeground(BLUE);
            jButton3.setForeground(BLUE);
        } else if (but4 == 'o' && but5 == 'o' && but6 == 'o') {
            jButton4.setForeground(BLUE);
            jButton5.setForeground(BLUE);
            jButton6.setForeground(BLUE);
        } else if (but7 == 'o' && but8 == 'o' && but9 == 'o') {
            jButton7.setForeground(BLUE);
            jButton8.setForeground(BLUE);
            jButton9.setForeground(BLUE);
        } else if (but1 == 'o' && but4 == 'o' && but7 == 'o') {
            jButton1.setForeground(BLUE);
            jButton4.setForeground(BLUE);
            jButton7.setForeground(BLUE);
        } else if (but2 == 'o' && but5 == 'o' && but8 == 'o') {
            jButton2.setForeground(BLUE);
            jButton5.setForeground(BLUE);
            jButton8.setForeground(BLUE);
        } else if (but3 == 'o' && but6 == 'o' && but9 == 'o') {
            jButton3.setForeground(BLUE);
            jButton6.setForeground(BLUE);
            jButton9.setForeground(BLUE);
        } else if (but1 == 'o' && but5 == 'o' && but9 == 'o') {
            jButton1.setForeground(BLUE);
            jButton5.setForeground(BLUE);
            jButton9.setForeground(BLUE);
        } else if (but7 == 'o' && but5 == 'o' && but3 == 'o') {
            jButton7.setForeground(BLUE);
            jButton5.setForeground(BLUE);
            jButton3.setForeground(BLUE);
        }
    }

    /**
     * Disables the board's buttons.
     */
    private void disableButtons() {
        jButton1.setEnabled(false);
        jButton2.setEnabled(false);
        jButton3.setEnabled(false);
        jButton4.setEnabled(false);
        jButton5.setEnabled(false);
        jButton6.setEnabled(false);
        jButton7.setEnabled(false);
        jButton8.setEnabled(false);
        jButton9.setEnabled(false);
    }

    /**
     * Resets the colors and clears the board.
     */
    public void reset() {

        jButton1.setText("");
        jButton2.setText("");
        jButton3.setText("");
        jButton4.setText("");
        jButton5.setText("");
        jButton6.setText("");
        jButton7.setText("");
        jButton8.setText("");
        jButton9.setText("");
        jButton1.setForeground(BLACK);
        jButton2.setForeground(BLACK);
        jButton3.setForeground(BLACK);
        jButton4.setForeground(BLACK);
        jButton5.setForeground(BLACK);
        jButton6.setForeground(BLACK);
        jButton7.setForeground(BLACK);
        jButton8.setForeground(BLACK);
        jButton9.setForeground(BLACK);
        but1 = '\u0000';
        but2 = '\u0000';
        but3 = '\u0000';
        but4 = '\u0000';
        but5 = '\u0000';
        but6 = '\u0000';
        but7 = '\u0000';
        but8 = '\u0000';
        but9 = '\u0000';
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
        jButton3.setEnabled(true);
        jButton4.setEnabled(true);
        jButton5.setEnabled(true);
        jButton6.setEnabled(true);
        jButton7.setEnabled(true);
        jButton8.setEnabled(true);
        jButton9.setEnabled(true);
    }


    // Board buttons

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException, NPC.NoNPCException {//GEN-FIRST:event_jButton1ActionPerformed
        if (jButton1.getText() == "") {
            if (player1Turn == true) {
                jButton1.setText("X");
                player1Turn = false;
                jLabelInfoBar.setText(monsterName + "'s turn!");
                but1 = 'x';
                if (playerXWin() == true) {
                    playerXScore += 1;
                    jLabelInfoBar.setText(playerName + " WINS!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                } else if (full() == true) {
                    jLabelInfoBar.setText("TIE!");
                    playerTScore += 1;
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                } else {
                    if (SinglePlayerMode) {
                        computerGo();
                    }
                }
                changeButtonColor();
            } else {
                jButton1.setText("O");
                player1Turn = true;
                jLabelInfoBar.setText(playerName + "'s turn!");
                but1 = 'o';
                if (playerOWin() == true) {
                    playerOScore += 1;
                    jLabelInfoBar.setText(monsterName + " WINS!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                } else if (full() == true) {
                    jLabelInfoBar.setText("TIE!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                    playerTScore += 1;
                }
                changeButtonColor();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException, NPC.NoNPCException {//GEN-FIRST:event_jButton2ActionPerformed
        if (jButton2.getText() == "") {
            if (player1Turn == true) {
                jButton2.setText("X");
                player1Turn = false;
                jLabelInfoBar.setText(monsterName + "'s turn!");
                but2 = 'x';
                if (playerXWin() == true) {
                    playerXScore += 1;
                    jLabelInfoBar.setText(playerName + " WINS!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                } else if (full() == true) {
                    jLabelInfoBar.setText("TIE!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                    playerTScore += 1;
                } else {
                    if (SinglePlayerMode) {
                        computerGo();
                    }
                }
                changeButtonColor();
            } else {
                jButton2.setText("O");
                player1Turn = true;
                jLabelInfoBar.setText(playerName + "'s turn!");
                but2 = 'o';
                if (playerOWin() == true) {
                    playerOScore += 1;
                    jLabelInfoBar.setText(monsterName + " WINS!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                } else if (full() == true) {
                    jLabelInfoBar.setText("TIE!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                    playerTScore += 1;
                }
                changeButtonColor();
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException, NPC.NoNPCException {//GEN-FIRST:event_jButton3ActionPerformed
        if (jButton3.getText() == "") {
            if (player1Turn == true) {
                jButton3.setText("X");
                player1Turn = false;
                jLabelInfoBar.setText(monsterName + "'s turn!");
                but3 = 'x';
                if (playerXWin() == true) {
                    playerXScore += 1;
                    jLabelInfoBar.setText(playerName + " WINS!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                } else if (full() == true) {
                    jLabelInfoBar.setText("TIE!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                    playerTScore += 1;
                } else {
                    if (SinglePlayerMode) {
                        computerGo();
                    }
                }
                changeButtonColor();
            } else {
                jButton3.setText("O");
                player1Turn = true;
                jLabelInfoBar.setText(playerName + "'s turn!");
                but3 = 'o';
                if (playerOWin() == true) {
                    playerOScore += 1;
                    jLabelInfoBar.setText(monsterName + " WINS!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                } else if (full() == true) {
                    jLabelInfoBar.setText("TIE!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                    playerTScore += 1;
                }
                changeButtonColor();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException, NPC.NoNPCException {//GEN-FIRST:event_jButton4ActionPerformed
        if (jButton4.getText() == "") {
            if (player1Turn == true) {
                jButton4.setText("X");
                player1Turn = false;
                jLabelInfoBar.setText(monsterName + "'s turn!");
                but4 = 'x';
                if (playerXWin() == true) {
                    playerXScore += 1;
                    jLabelInfoBar.setText(playerName + " WINS!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                } else if (full() == true) {
                    jLabelInfoBar.setText("TIE!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                    playerTScore += 1;
                } else {
                    if (SinglePlayerMode) {
                        computerGo();
                    }
                }
                changeButtonColor();
            } else {
                jButton4.setText("O");
                player1Turn = true;
                jLabelInfoBar.setText(playerName + "'s turn!");
                but4 = 'o';
                if (playerOWin() == true) {
                    playerOScore += 1;
                    jLabelInfoBar.setText(monsterName + " WINS!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                } else if (full() == true) {
                    jLabelInfoBar.setText("TIE!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                    playerTScore += 1;
                }
                changeButtonColor();
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException, NPC.NoNPCException {//GEN-FIRST:event_jButton5ActionPerformed
        if (jButton5.getText() == "") {
            if (player1Turn == true) {
                jButton5.setText("X");
                player1Turn = false;
                jLabelInfoBar.setText(monsterName + "'s turn!");
                but5 = 'x';
                if (playerXWin() == true) {
                    playerXScore += 1;
                    jLabelInfoBar.setText(playerName + " WINS!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                } else if (full() == true) {
                    jLabelInfoBar.setText("TIE!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                    playerTScore += 1;
                } else {
                    if (SinglePlayerMode) {
                        computerGo();
                    }
                }
                changeButtonColor();
            } else {
                jButton5.setText("O");
                player1Turn = true;
                jLabelInfoBar.setText(playerName + "'s turn!");
                but5 = 'o';
                if (playerOWin() == true) {
                    playerOScore += 1;
                    jLabelInfoBar.setText(monsterName + " WINS!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                } else if (full() == true) {
                    jLabelInfoBar.setText("TIE!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                    playerTScore += 1;
                }
                changeButtonColor();
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException, NPC.NoNPCException {//GEN-FIRST:event_jButton6ActionPerformed
        if (jButton6.getText() == "") {
            if (player1Turn == true) {
                jButton6.setText("X");
                player1Turn = false;
                jLabelInfoBar.setText(monsterName + "'s turn!");
                but6 = 'x';
                if (playerXWin() == true) {
                    playerXScore += 1;
                    jLabelInfoBar.setText(playerName + " WINS!");
                    disableButtons();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                    changeFirstPlayer();
                } else if (full() == true) {
                    jLabelInfoBar.setText("TIE!");
                    disableButtons();
                    changeFirstPlayer();
                    playerTScore += 1;
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                } else {
                    if (SinglePlayerMode) {
                        computerGo();
                    }
                }
                changeButtonColor();
            } else {
                jButton6.setText("O");
                player1Turn = true;
                jLabelInfoBar.setText(playerName + "'s turn!");
                but6 = 'o';
                if (playerOWin() == true) {
                    playerOScore += 1;
                    jLabelInfoBar.setText(monsterName + " WINS!");
                    disableButtons();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                    changeFirstPlayer();
                } else if (full() == true) {
                    jLabelInfoBar.setText("TIE!");
                    disableButtons();
                    changeFirstPlayer();
                    playerTScore += 1;
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                }
                changeButtonColor();
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException, NPC.NoNPCException {//GEN-FIRST:event_jButton7ActionPerformed
        if (jButton7.getText() == "") {
            if (player1Turn == true) {
                jButton7.setText("X");
                player1Turn = false;
                jLabelInfoBar.setText(monsterName + "'s turn!");
                but7 = 'x';
                if (playerXWin() == true) {
                    playerXScore += 1;
                    jLabelInfoBar.setText(playerName + " WINS!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                } else if (full() == true) {
                    jLabelInfoBar.setText("TIE!");
                    disableButtons();
                    changeFirstPlayer();
                    playerTScore += 1;
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                } else {
                    if (SinglePlayerMode) {
                        computerGo();
                    }
                }
                changeButtonColor();
            } else {
                jButton7.setText("O");
                player1Turn = true;
                jLabelInfoBar.setText(playerName + "'s turn!");
                but7 = 'o';
                if (playerOWin() == true) {
                    playerOScore += 1;
                    jLabelInfoBar.setText(monsterName + " WINS!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                } else if (full() == true) {
                    jLabelInfoBar.setText("TIE!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                    playerTScore += 1;
                }
                changeButtonColor();
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException, NPC.NoNPCException {//GEN-FIRST:event_jButton8ActionPerformed
        if (jButton8.getText() == "") {
            if (player1Turn == true) {
                jButton8.setText("X");
                player1Turn = false;
                jLabelInfoBar.setText(monsterName + "'s turn!");
                but8 = 'x';
                if (playerXWin() == true) {
                    playerXScore += 1;
                    jLabelInfoBar.setText(playerName + " WINS!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                } else if (full() == true) {
                    jLabelInfoBar.setText("TIE!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                    playerTScore += 1;
                } else {
                    if (SinglePlayerMode) {
                        computerGo();
                    }
                }
                changeButtonColor();
            } else {
                jButton8.setText("O");
                player1Turn = true;
                jLabelInfoBar.setText(playerName + "'s turn!");
                but8 = 'o';
                if (playerOWin() == true) {
                    playerOScore += 1;
                    jLabelInfoBar.setText(monsterName + " WINS!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                } else if (full() == true) {
                    jLabelInfoBar.setText("TIE!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                    playerTScore += 1;
                }
                changeButtonColor();
            }
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) throws InterruptedException, NPC.NoNPCException {//GEN-FIRST:event_jButton9ActionPerformed
        if (jButton9.getText() == "") {
            if (player1Turn == true) {
                jButton9.setText("X");
                player1Turn = false;
                jLabelInfoBar.setText(monsterName + "'s turn!");
                but9 = 'x';
                if (playerXWin() == true) {
                    playerXScore += 1;
                    jLabelInfoBar.setText(playerName + " WINS!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                } else if (full() == true) {
                    jLabelInfoBar.setText("TIE!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                    playerTScore += 1;
                } else {
                    if (SinglePlayerMode) {
                        computerGo();
                    }
                }
                changeButtonColor();
            } else {
                jButton9.setText("O");
                player1Turn = true;
                jLabelInfoBar.setText(playerName + "'s turn!");
                but9 = 'o';
                if (playerOWin() == true) {
                    playerOScore += 1;
                    jLabelInfoBar.setText(monsterName + " WINS!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                } else if (full() == true) {
                    jLabelInfoBar.setText("TIE!");
                    disableButtons();
                    changeFirstPlayer();
                    GameState.instance().getAdventurersCurrentRoom().getNPCNamed(monsterName).changeWaitStatus(true);
                    playerTScore += 1;
                }
                changeButtonColor();
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed


    /**
     * This method checks to see if there has been a draw.
     *
     * @return if the board is full but no winner.
     */
    static boolean full() {
        if (but1 != '\u0000' && but2 != '\u0000' && but3 != '\u0000'
                && but4 != '\u0000' && but5 != '\u0000' && but6 != '\u0000'
                && but7 != '\u0000' && but8 != '\u0000' && but9 != '\u0000') {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method checks to see if X won this round
     *
     * @return if X has won
     */
    static boolean playerXWin() {
        if (but1 == 'x' && but2 == 'x' && but3 == 'x'
                || but4 == 'x' && but5 == 'x' && but6 == 'x'
                || but7 == 'x' && but8 == 'x' && but9 == 'x'
                || but1 == 'x' && but4 == 'x' && but7 == 'x'
                || but2 == 'x' && but5 == 'x' && but8 == 'x'
                || but3 == 'x' && but6 == 'x' && but9 == 'x'
                || but1 == 'x' && but5 == 'x' && but9 == 'x'
                || but7 == 'x' && but5 == 'x' && but3 == 'x') {
            return true;
        } else {
            return false;
        }
    }

    /**
     * This method checks to see if O won this round
     *
     * @return if O has won
     */
    static boolean playerOWin() {
        if (but1 == 'o' && but2 == 'o' && but3 == 'o'
                || but4 == 'o' && but5 == 'o' && but6 == 'o'
                || but7 == 'o' && but8 == 'o' && but9 == 'o'
                || but1 == 'o' && but4 == 'o' && but7 == 'o'
                || but2 == 'o' && but5 == 'o' && but8 == 'o'
                || but3 == 'o' && but6 == 'o' && but9 == 'o'
                || but1 == 'o' && but5 == 'o' && but9 == 'o'
                || but7 == 'o' && but5 == 'o' && but3 == 'o') {
            return true;
        } else {
            return false;
        }
    }


    /**
     * Invoked when an action occurs.
     *
     * @param e exception to say Not supported yet.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
