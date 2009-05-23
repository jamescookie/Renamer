package rename;

import java.io.File;
import java.util.Comparator;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class RenameFrame extends JFrame {

    JPanel contentPane;
    JButton btnBrowse = new JButton();
    JLabel jLabel1 = new JLabel();
    JLabel lblPath = new JLabel();
    JTextField txtFile = new JTextField();
    JTextField txtExt = new JTextField();
    JTextField txtStart = new JTextField();
    JLabel jLabel3 = new JLabel();
    JLabel jLabel4 = new JLabel();
    JButton btnOK = new JButton();
    JButton btnExit = new JButton();
    JPanel pnlLayout1 = new JPanel();
    JPanel pnlLayout2 = new JPanel();
    BorderLayout borderLayout2 = new BorderLayout();
    JPanel pnlLayout3 = new JPanel();
    BorderLayout borderLayout3 = new BorderLayout();
    JPanel pnlLayout4 = new JPanel();
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel pnlLayout5 = new JPanel();
    BorderLayout borderLayout4 = new BorderLayout();
    JPanel pnlLayout6 = new JPanel();
    JPanel pnlLayout7 = new JPanel();
    BorderLayout borderLayout5 = new BorderLayout();
    BorderLayout borderLayout6 = new BorderLayout();
    BorderLayout borderLayout7 = new BorderLayout();
    BorderLayout borderLayout8 = new BorderLayout();
    Border border1;
    Border border2;
    JPanel pnlLayout8 = new JPanel();
    JPanel pnlLayout9 = new JPanel();
    JPanel pnlLayout10 = new JPanel();
    JPanel pnlLayout11 = new JPanel();
    JRadioButton chkNone = new JRadioButton();
    JRadioButton chkName = new JRadioButton();
    JRadioButton chkDate = new JRadioButton();
    JLabel jLabel2 = new JLabel();
    JLabel jLabel5 = new JLabel();
    ButtonGroup sortGroup = new ButtonGroup();

    /**Construct the frame*/
    public RenameFrame() {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        try {
            jbInit();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**Component initialization*/
    private void jbInit() throws Exception  {
        //setIconImage(Toolkit.getDefaultToolkit().createImage(Frame1.class.getResource("[Your Icon]")));
        contentPane = (JPanel) this.getContentPane();
        border1 = BorderFactory.createEmptyBorder(15,15,15,15);
        border2 = BorderFactory.createEmptyBorder(5,5,5,5);
        btnBrowse.setToolTipText("");
        btnBrowse.setText("Browse...");
        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnBrowse_actionPerformed(e);
            }
        });
        contentPane.setLayout(borderLayout6);
        this.setSize(new Dimension(266, 249));
        this.setTitle("File Renamer");
        jLabel1.setText("Path:");
        jLabel3.setText("File Name");
        jLabel4.setText("Extension");
        jLabel5.setText("Start");
        btnOK.setText("OK");
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnOK_actionPerformed(e);
            }
        });
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnExit_actionPerformed(e);
            }
        });
        pnlLayout2.setLayout(borderLayout2);
        pnlLayout3.setLayout(borderLayout3);
        pnlLayout4.setLayout(borderLayout1);
        pnlLayout5.setLayout(borderLayout4);
        pnlLayout7.setLayout(borderLayout5);
        pnlLayout11.setLayout(borderLayout8);
        pnlLayout4.setBorder(border1);
        pnlLayout5.setBorder(border1);
        pnlLayout2.setBorder(border1);
        pnlLayout11.setBorder(border1);
        txtFile.setPreferredSize(new Dimension(140, 21));
        chkNone.setSelected(true);
        chkNone.setText("None");
        chkName.setMargin(new Insets(2, 2, 2, 2));
        chkName.setText("Name");
        chkDate.setText("Date");
        pnlLayout8.setLayout(borderLayout7);
        jLabel2.setText("Sort Order");
        pnlLayout8.add(pnlLayout10, BorderLayout.WEST);
        contentPane.add(pnlLayout3, BorderLayout.NORTH);
        pnlLayout2.add(jLabel1,  BorderLayout.WEST);
        pnlLayout2.add(lblPath, BorderLayout.CENTER);
        pnlLayout3.add(pnlLayout1,  BorderLayout.NORTH);
        pnlLayout1.add(btnBrowse, null);
        pnlLayout3.add(pnlLayout2,  BorderLayout.SOUTH);
        pnlLayout4.add(jLabel3, BorderLayout.NORTH);
        pnlLayout4.add(txtFile, BorderLayout.CENTER);
        pnlLayout11.add(jLabel5, BorderLayout.NORTH);
        pnlLayout11.add(txtStart, BorderLayout.CENTER);
        contentPane.add(pnlLayout8, BorderLayout.CENTER);
        pnlLayout7.add(pnlLayout5, BorderLayout.EAST);
        pnlLayout5.add(jLabel4, BorderLayout.NORTH);
        pnlLayout5.add(txtExt, BorderLayout.CENTER);
        pnlLayout7.add(pnlLayout6,  BorderLayout.SOUTH);
        pnlLayout6.add(btnOK, null);
        pnlLayout6.add(btnExit, null);
        contentPane.add(pnlLayout7,  BorderLayout.SOUTH);
        pnlLayout7.add(pnlLayout11,  BorderLayout.WEST);
        pnlLayout7.add(pnlLayout4,  BorderLayout.CENTER);
        pnlLayout8.add(pnlLayout9,  BorderLayout.CENTER);
        pnlLayout9.add(chkNone, null);
        pnlLayout9.add(chkDate, null);
        pnlLayout10.add(jLabel2, null);
        pnlLayout9.add(chkName, null);
        sortGroup.add(chkNone);
        sortGroup.add(chkDate);
        sortGroup.add(chkName);
    }

    /**Overridden so we can exit when window is closed*/
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }
    }

    void btnBrowse_actionPerformed(ActionEvent e) {
        File theFile = null;
        int retval;
        JFileChooser chooser = new JFileChooser();

        chooser.setDialogType(JFileChooser.CUSTOM_DIALOG);
        chooser.setApproveButtonText("Select");
        chooser.setDialogTitle("Choose a directory to rename");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAccessory(null);
        chooser.setFileView(null);
        chooser.setMultiSelectionEnabled(false);
        chooser.setCurrentDirectory(new File(lblPath.getText()));

        retval = chooser.showDialog(this, null);

        if (retval == JFileChooser.APPROVE_OPTION) {
            theFile = chooser.getSelectedFile();
            if (theFile != null && theFile.isDirectory()) {
                lblPath.setText(theFile.getAbsolutePath());
            }
        }
    }

    void btnOK_actionPerformed(ActionEvent e) {
        if (goodString(lblPath.getText()) &&
            goodString(txtFile.getText()) &&
            goodString(txtExt.getText())) {

            Comparator<File> c = null;
            if (chkName.isSelected()) {
                c = new FileNameComparator();
            } else if (chkDate.isSelected()) {
                c = new FileDateComparator();
            }

            int start = 1;

            if (goodString(txtStart.getText())) {
                try {
                    start = Integer.parseInt(txtStart.getText());
                } catch (NumberFormatException e1) {
                    start = 1;
                }
            }

            Utils.doUpdate(lblPath.getText(), txtFile.getText(), txtExt.getText(), c, start);

            JOptionPane.showMessageDialog(this,
                "Done.",
                "Information",
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                "Input Stuff.",
                "Information",
                JOptionPane.INFORMATION_MESSAGE);
        }
    }

    void btnExit_actionPerformed(ActionEvent e) {
        System.exit(0);
    }

    private static boolean goodString(String s) {
        return ((s != null) && (s.length() > 0));
    }

}
