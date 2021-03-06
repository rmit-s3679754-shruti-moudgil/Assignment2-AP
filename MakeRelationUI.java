
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;


public class MakeRelationUI extends javax.swing.JDialog {

    private MiniNet miniNet;
    private DriverUI driverUI;
    DefaultComboBoxModel model1 = new DefaultComboBoxModel();
    DefaultComboBoxModel model2 = new DefaultComboBoxModel();
    List<Profile> profiles = null;
    
    /**
     * Creates new form MakeRelationUI
     */
    public MakeRelationUI(java.awt.Frame parent, boolean modal, MiniNet miniNet) {
        super(parent, modal);
        this.miniNet = miniNet;
        this.driverUI = (DriverUI)parent;
        initComponents();
        
        profiles = miniNet.getAllProfiles();
        
        jcmbxFirst.setModel(model1);
        jcmbxSecond.setModel(model2);

        for(Profile p : profiles){
            model1.addElement(p.toString());
            model2.addElement(p.toString());
        }
        
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

        jPanel1 = new javax.swing.JPanel();
        btnSubmit = new javax.swing.JButton();
        btnCancel = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jcmbxFirst = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jcmbxSecond = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jcmbxRelation = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Make a Relation");
        setPreferredSize(new java.awt.Dimension(600, 250));

        btnSubmit.setText("Submit");
        btnSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSubmitActionPerformed(evt);
            }
        });
        jPanel1.add(btnSubmit);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });
        jPanel1.add(btnCancel);

        getContentPane().add(jPanel1, java.awt.BorderLayout.SOUTH);

        jPanel2.setLayout(new java.awt.GridBagLayout());

        jLabel1.setText("Person 1:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel2.add(jLabel1, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel2.add(jcmbxFirst, gridBagConstraints);

        jLabel2.setText("Person 2:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel2.add(jLabel2, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel2.add(jcmbxSecond, gridBagConstraints);

        jLabel3.setText("Relation:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel2.add(jLabel3, gridBagConstraints);

        jcmbxRelation.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "friends", "couple", "parent", "colleagues", "classmate" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(4, 4, 4, 4);
        jPanel2.add(jcmbxRelation, gridBagConstraints);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelActionPerformed

    
    
    /*
     * SubmitButton actually submits the profile in try Block. 
     * information is sent to miniNet.java Class and it checks for the exceptions.
     * in checks if exception occur it shows on conslole and also prevents for wrong entries
     * 
     * 
     */
    private void btnSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSubmitActionPerformed
        // TODO add your handling code here:
        Profile p1 = profiles.get(jcmbxFirst.getSelectedIndex());
        Profile p2 = profiles.get(jcmbxSecond.getSelectedIndex());
        String relation = (String)jcmbxRelation.getSelectedItem();
        Connection.Type type = Connection.getTypeFromString(relation);
        try {
            miniNet.addConnection(p1, p2, type);
            driverUI.reloadConnections();
            JOptionPane.showMessageDialog(this, "Relation created between profiles.");
            this.dispose();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_btnSubmitActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnSubmit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> jcmbxFirst;
    private javax.swing.JComboBox<String> jcmbxRelation;
    private javax.swing.JComboBox<String> jcmbxSecond;
    // End of variables declaration//GEN-END:variables
}
