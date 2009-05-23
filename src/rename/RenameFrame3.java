package rename;

import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import java.awt.AWTEvent;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.Comparator;

public class RenameFrame3 extends JFrame {
    private JButton btnBrowse;
    private JRadioButton chkDate;
    private JRadioButton chkName;
    private JButton btnOK;
    private JButton btnExit;
    private JTextField txtStart;
    private JTextField txtFile;
    private JTextField txtExt;
    private JLabel lblPath;
    private JPanel mainPanel;
    private JRadioButton renameRadioButton;
    private JRadioButton resizeRadioButton;
    private JRadioButton bothRadioButton;
    private JTextField txtReduce;

    public RenameFrame3() {
        enableEvents(AWTEvent.WINDOW_EVENT_MASK);
        this.setSize(new Dimension(350, 249));
        this.setTitle("File Renamer");
        this.setContentPane(mainPanel);

        btnBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnBrowse_actionPerformed();
            }
        });
        btnOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnOK_actionPerformed();
            }
        });
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(ActionEvent e) {
                btnExit_actionPerformed();
            }
        });
    }

    /**Overridden so we can exit when window is closed*/
    protected void processWindowEvent(WindowEvent e) {
        super.processWindowEvent(e);
        if (e.getID() == WindowEvent.WINDOW_CLOSING) {
            System.exit(0);
        }
    }

    private void btnBrowse_actionPerformed() {
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

    private void btnOK_actionPerformed() {
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

    private void btnExit_actionPerformed() {
        System.exit(0);
    }

    private static boolean goodString(String s) {
        return ((s != null) && (s.length() > 0));
    }

}
