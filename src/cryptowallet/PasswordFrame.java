/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * NewJFrame.java
 *
 * Created on 16-Aug-2012, 20:55:08
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
public class PasswordFrame extends javax.swing.JFrame {

    private boolean gotPassword1=false;
    private char[] password1;
    private CryptoWalletDB.PWCredentials credentials;
    
    
    /** Creates new form NewJFrame */
    public PasswordFrame() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        passwordText.grabFocus();
        passwordText.setEchoChar('#');
    }

    /** This method is called from within the constructor to
     * initialise the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        passwordText = new javax.swing.JPasswordField();
        passwordLabel = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        jLabel2.setText("jLabel2");

        jScrollPane1.setViewportView(jTextPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Crypto Wallet");
        setBackground(new java.awt.Color(0, 153, 204));
        setName("PasswordFrame"); // NOI18N
        setResizable(false);

        passwordText.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        passwordText.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        passwordText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordTextActionPerformed(evt);
            }
        });
        passwordText.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordTextKeyPressed(evt);
            }
        });

        passwordLabel.setBackground(new java.awt.Color(187, 217, 246));
        passwordLabel.setFont(new java.awt.Font("DejaVu Sans", 1, 12)); // NOI18N
        passwordLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        passwordLabel.setText(" Enter Master Password");
        passwordLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        passwordLabel.setOpaque(true);

        jButton1.setText("cancel");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(passwordLabel, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 362, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(passwordText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 274, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(52, 52, 52))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(jButton1)
                                .addContainerGap())))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(passwordLabel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 35, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jButton1)
                .add(18, 18, 18)
                .add(passwordText, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void passwordTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordTextActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordTextActionPerformed

    private void showMainFrame(){
        try{
            
            CryptoWalletDB cryptodb = new CryptoWalletDB(password1,Convert.stringToHexBytes(credentials.salt));
            new MainFrame(cryptodb);

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Error creating database object/n"+e.getMessage(),"Cryptowallet Message",
                        JOptionPane.ERROR_MESSAGE);
        }
            
        this.dispose();
    }
    
    private void passwordTextKeyPressed(java.awt.event.KeyEvent evt) {                                        
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER) {
            password1=this.passwordText.getPassword();
            if(!checkPasswordHashes(password1)){
                JOptionPane.showMessageDialog(rootPane,"Password is incorrect\n");
                gotPassword1=false;
                passwordText.setText("");
                passwordLabel.setText("Enter Master Password");
                
            }
            else{
                //passed so we can now show the main form                
                showMainFrame();
                Arrays.fill(password1, '0'); //clear the password
                this.dispose();
            }
        }
    } 
  

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    
    private boolean checkPasswordHashes(char[] passwordEntered){
        //get stored hash and salt value
        boolean result=true;
        credentials = CryptoWalletDB.readHashAndSalt();
        if (!credentials.hash.isEmpty() && !credentials.salt.isEmpty()){
            
            //hash the given password
            byte[] pwBytes=Convert.charArrayToBytes(password1);
            byte[] pwHash=HashFunctions.hashPassword(pwBytes,"SHA-512", 
                    1000, Convert.stringToHexBytes(credentials.salt));
            String genHash=Convert.bytesToHexString(pwHash);
            
            //check the hashes match
            if (genHash.compareTo(credentials.hash)!=0){
                JOptionPane.showMessageDialog(rootPane,"Password incorrect");
                result=false;
            }
             
            
        }
        else{
            JOptionPane.showMessageDialog(rootPane,"Could not get stored hash from file");
            result=false;
        }
        
        return result;
    }
    
    
    
    
    /**
     * @param args the command line arguments
     */
   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JPasswordField passwordText;
    // End of variables declaration//GEN-END:variables
}
