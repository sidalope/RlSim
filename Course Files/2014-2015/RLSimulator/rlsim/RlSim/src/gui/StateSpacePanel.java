/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import java.util.ArrayList;

/**
 *
 * @author alessandrobisiani
 */
public class StateSpacePanel extends javax.swing.JPanel {

    ArrayList<String> listOfStates = new ArrayList<String>();
    /**
     * Creates new form NewJPanel
     */
    public StateSpacePanel() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        stateSpace = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        stateSpace.setColumns(20);
        stateSpace.setRows(5);
        jScrollPane1.setViewportView(stateSpace);

        jButton1.setText("Create");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Enter the desired states below, separated by a space.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(17, 17, 17)
                                .addComponent(jLabel1))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(137, 137, 137)
                                .addComponent(jButton1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    //Harvest JTextArea input and enter each state name in an ArrayList<String> for use.
    //The states entered should be divided by a space.
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String states = stateSpace.getText();
        String word = "";
        int lengthOfStates = states.length();
        //CharSequence sepChar = System.getProperty("line.separator");
        
        for(int i=0; i<lengthOfStates; i++){
            
            if(i==lengthOfStates-1 && states.charAt(i)==' '){
                listOfStates.add(word);
            } else if(i==lengthOfStates-1){
                word = word + states.charAt(i);
                listOfStates.add(word);
            } else if(states.charAt(i) ==' '){
                listOfStates.add(word);
                System.out.println(word);                //A test to check whether the loop cycles through each word
                word = "";
            } else {
                word = word + states.charAt(i);
            }
            
        }
        getListOfStates();
        
        //Tests
        System.out.println(states);
        System.out.println(states.length());
        System.out.println(listOfStates);
        
        gui.MainFrame.closeLabelFrame();
        /**
        Window f = SwingUtilities.windowForComponent(this);
        f.removeAll();
        
        JFrame t = null;
        Container temp = this;
        while(temp.getParent() != null){
            temp = temp.getParent();
            if (temp.getParent() instanceof JFrame){
                temp.getParent().removeAll();
            }
        }  */      
    }//GEN-LAST:event_jButton1ActionPerformed

    public ArrayList<String> getListOfStates(){
        return listOfStates;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea stateSpace;
    // End of variables declaration//GEN-END:variables
}
