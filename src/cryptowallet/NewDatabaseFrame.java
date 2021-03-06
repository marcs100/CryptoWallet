/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptowallet;

import extrautils.Convert;
import java.awt.event.KeyEvent;
import java.util.Arrays;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author marc
 */
public class NewDatabaseFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewDatabaseFrame
     */
    
    private boolean gotPassword1=false;
    //private boolean gotPassword2=false;
    private char[] password1;
    private byte [] saltValue;
    
    public NewDatabaseFrame() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        
    }

    /**
     * This method is called from within the constructor to initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        stage1Panel = new javax.swing.JPanel();
        createNewDBButton = new javax.swing.JButton();
        cancelNewDBButton = new javax.swing.JButton();
        newPasswordText = new javax.swing.JPasswordField();
        newPasswordLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Crypto Wallet");

        createNewDBButton.setText("Yes");
        createNewDBButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createNewDBButtonActionPerformed(evt);
            }
        });

        cancelNewDBButton.setText("Cancel");
        cancelNewDBButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelNewDBButtonActionPerformed(evt);
            }
        });

        newPasswordText.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        newPasswordText.setToolTipText("Enter Master Password for new crypto wallet database");
        newPasswordText.setEnabled(false);
        newPasswordText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                newPasswordTextKeyPressed(evt);
            }
        });

        newPasswordLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        newPasswordLabel.setText("Enter New Master Password");
        newPasswordLabel.setEnabled(false);

        javax.swing.GroupLayout stage1PanelLayout = new javax.swing.GroupLayout(stage1Panel);
        stage1Panel.setLayout(stage1PanelLayout);
        stage1PanelLayout.setHorizontalGroup(
            stage1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stage1PanelLayout.createSequentialGroup()
                .addContainerGap(74, Short.MAX_VALUE)
                .addGroup(stage1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(newPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(newPasswordLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(stage1PanelLayout.createSequentialGroup()
                        .addGap(270, 270, 270)
                        .addComponent(createNewDBButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cancelNewDBButton)))
                .addContainerGap())
        );
        stage1PanelLayout.setVerticalGroup(
            stage1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(stage1PanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(stage1PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createNewDBButton)
                    .addComponent(cancelNewDBButton))
                .addGap(26, 26, 26)
                .addComponent(newPasswordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(newPasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(91, Short.MAX_VALUE))
        );

        newPasswordLabel.getAccessibleContext().setAccessibleName("EnterPWLabel");

        jScrollPane1.setBackground(new java.awt.Color(187, 217, 246));
        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane1.setOpaque(false);

        jTextArea1.setEditable(false);
        jTextArea1.setBackground(new java.awt.Color(187, 217, 246));
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        jTextArea1.setLineWrap(true);
        jTextArea1.setRows(5);
        jTextArea1.setText("No Crypto Wallet master database found, would you like to create a new database?");
        jTextArea1.setWrapStyleWord(true);
        jTextArea1.setAutoscrolls(false);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(stage1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stage1Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    
    //-------------------------------------------------------------------------------
    // Enable user enter password for the new cryptowallet database.
    //-------------------------------------------------------------------------------
    private void createNewDBButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createNewDBButtonActionPerformed
        newPasswordLabel.setEnabled(true);
        newPasswordText.setEnabled(true);
        createNewDBButton.setEnabled(false);
        newPasswordText.setEchoChar('#');
        newPasswordText.grabFocus();
        
    }//GEN-LAST:event_createNewDBButtonActionPerformed
    
    
    private void generatePasswordHashAndSalt() {
        try{
            saltValue=HashFunctions.generateSaltValue();
            //Convert.charArrayToBytes(password1)
            byte[] pwBytes=Convert.charArrayToBytes(password1);
            byte[] pwHash=HashFunctions.hashPassword(pwBytes,"SHA-512", 1000, saltValue);
       
            //now we need to store the hash and salt values in db file
            if(!CryptoWalletDB.writeHashFile(Convert.bytesToHexString(pwHash), Convert.bytesToHexString(saltValue))){
                JOptionPane.showMessageDialog(rootPane, "Error writing hash","Cryptowallet Message",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(Exception e){
             JOptionPane.showMessageDialog(rootPane, "Error generating password/salt",
                     "Cryptowallet Message",JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    private void generateNewDB() {
        try{
            CryptoWalletDB cryptoDB=new CryptoWalletDB(password1,saltValue);
            if(!cryptoDB.writeNewBlankDatabase()){
                JOptionPane.showMessageDialog(rootPane, "Error writing new database file\n Check cryptoWallet_template.txt exists","Cryptowallet Message"
                        ,JOptionPane.ERROR_MESSAGE);
            }
            else{
                //now we can show the main frame
                new MainFrame(cryptoDB);
            }
        }    
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane,"Error writing new database file\n"+e.getMessage());
        }
        
        this.dispose();
            
    }
    
    //Check to see if user has pressed return when entering password
    private void newPasswordTextKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newPasswordTextKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            if (gotPassword1==false){
                password1=this.newPasswordText.getPassword();
                newPasswordLabel.setText("Confirm password");
                newPasswordText.setText("");
                gotPassword1=true;
            }
            else if (gotPassword1){
                //user is confirming the password
                char[] password2=newPasswordText.getPassword();
                //do the passwords match?
                if (Arrays.equals(password1, password2)){
                    this.generatePasswordHashAndSalt();
                    this.generateNewDB();
                    //clear the passwords
                    Arrays.fill(password1, '0');
                    Arrays.fill(password2, '0');
                }
                else{
                    JOptionPane.showMessageDialog(rootPane,"Passwords do not match\n");
                    gotPassword1=false;
                    newPasswordText.setText("");
                    newPasswordLabel.setText("Enter New Master Password");
                }
                    
            }
        }
    }//GEN-LAST:event_newPasswordTextKeyPressed

    private void cancelNewDBButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelNewDBButtonActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_cancelNewDBButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelNewDBButton;
    private javax.swing.JButton createNewDBButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    public javax.swing.JLabel newPasswordLabel;
    public javax.swing.JPasswordField newPasswordText;
    private javax.swing.JPanel stage1Panel;
    // End of variables declaration//GEN-END:variables
}
