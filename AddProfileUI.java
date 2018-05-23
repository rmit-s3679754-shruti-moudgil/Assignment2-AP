
import javax.swing.JOptionPane;


public class AddProfileUI extends javax.swing.JDialog {

    private MiniNet miniNet;
    private DriverUI driverUI;
    
    /**
     * Creates new form AddProfileUI
     * It maintains the UI of DriveUI.java, initializes the components.
     */
    public AddProfileUI(java.awt.Frame parent, boolean modal, MiniNet miniNet) {
        super(parent, modal);
        this.driverUI = (DriverUI)parent;
        this.miniNet = miniNet;
        initComponents();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanelForm = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtAge = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtStatus = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtImage = new javax.swing.JTextField();
        jPanelActions = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add a Profile");
        setPreferredSize(new java.awt.Dimension(400, 300));

        jPanelForm.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanelForm.add(jLabel1, gridBagConstraints);

        txtName.setColumns(15);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanelForm.add(txtName, gridBagConstraints);

        jLabel2.setText("Age:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanelForm.add(jLabel2, gridBagConstraints);

        txtAge.setColumns(5);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanelForm.add(txtAge, gridBagConstraints);

        jLabel3.setText("Status:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanelForm.add(jLabel3, gridBagConstraints);

        txtStatus.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanelForm.add(txtStatus, gridBagConstraints);

        jLabel4.setText("Image:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanelForm.add(jLabel4, gridBagConstraints);

        txtImage.setColumns(15);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(3, 3, 3, 3);
        jPanelForm.add(txtImage, gridBagConstraints);

        getContentPane().add(jPanelForm, java.awt.BorderLayout.CENTER);

        btnAdd.setText("Add");
        btnAdd.setPreferredSize(new java.awt.Dimension(100, 29));
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jPanelActions.add(btnAdd);

        btnCancel.setText("Cancel");
        btnCancel.setPreferredSize(new java.awt.Dimension(100, 29));
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanelActions.add(btnCancel);

        getContentPane().add(jPanelActions, java.awt.BorderLayout.SOUTH);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    
    
    /*
     * ButtonAddActionPerformed() is basically checks which tag to put (youngChild, Child, Adult) 
     * by its age.
     * if age> 16, it would be an adult
     * if age> 2, it would be a child
     * Otherwise, it would be a youngerChild
     */
    
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        try {
            // TODO add your handling code here:
            String name = txtName.getText().trim();
            String status = txtStatus.getText().trim();
            int age = Integer.parseInt(txtAge.getText().trim());
            String image = txtImage.getText().trim();
            Profile p = null;
            if(age > 16)
                p = new Adult(name, image, status, age);
            else if(age > 2)
                p = new Child(name, image, status, age);
            else
                p = new YoungChild(name, image, status, age);
            
            miniNet.addProfile(p);
            driverUI.reloadProfiles();
            JOptionPane.showMessageDialog(this, "Profile created successfully");
            this.dispose();
            
            sqlLiteDatabase database = new sqlLiteDatabase();
            database.insert(name, age, status, image) ;
        } catch (NoSuchAgeException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnAddActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnCancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanelActions;
    private javax.swing.JPanel jPanelForm;
    private javax.swing.JTextField txtAge;
    private javax.swing.JTextField txtImage;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtStatus;
    // End of variables declaration//GEN-END:variables
}
