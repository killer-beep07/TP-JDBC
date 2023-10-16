
package ma.ui;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import ma.connexion.Connexion;
import static ma.connexion.Connexion.getConnection;
import javax.swing.table.DefaultTableModel;
import ma.beans.Client;
import ma.beans.Service;
import ma.service.ClientService;
import ma.service.ServiceService;


public class ServicesForm extends javax.swing.JInternalFrame {
    
    PreparedStatement ps = null;
    ResultSet rs = null;
    ServiceService ss;
    ClientService cs;
    DefaultTableModel model;

   
    public ServicesForm() {
        initComponents();
        model = (DefaultTableModel) listeClient.getModel();
        ss = new ServiceService();
        cs = new ClientService();
        remplirCombobox();
        load();
        
    }
    
    public void remplirCombobox() {
        
        String sql = "select * from service ";
        
        try{
            listeService.removeAllItems();
         ps = getConnection().prepareStatement(sql);
         rs = ps.executeQuery();
         
         while(rs.next()){
             String nom = rs.getString("nom").toString();
             listeService.addItem(nom); 
             ;
         }
        
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
     void load(){
        model.setRowCount(0);
       for(Service s : ss.findAll()){
           model.setRowCount(0);
           for(Client c : cs.findAll()){
                if(c.getService().getId() == ss.findByName(listeService.getSelectedItem().toString()).getId()){
                    model.addRow(new Object[]{
                c.getId(),
                c.getNom(),
                c.getPrenom(),
                c.getDate(),
                c.getService().getNom()
            });
            }
           }
       }
    
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        servicesTxt = new javax.swing.JLabel();
        listeService = new javax.swing.JComboBox();
        RechercherButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listeClient = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        servicesTxt.setText("Services :");

        listeService.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Finance", "Marketing", "RH", "Info", "Media" }));
        listeService.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listeServiceActionPerformed(evt);
            }
        });

        RechercherButton.setText("Rechercher");
        RechercherButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                RechercherButtonMouseClicked(evt);
            }
        });
        RechercherButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RechercherButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(servicesTxt)
                .addGap(40, 40, 40)
                .addComponent(listeService, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 81, Short.MAX_VALUE)
                .addComponent(RechercherButton)
                .addGap(70, 70, 70))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(listeService, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(servicesTxt)
                    .addComponent(RechercherButton))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        listeClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nom", "Prénom", "Date", "Service"
            }
        ));
        jScrollPane1.setViewportView(listeClient);
        if (listeClient.getColumnModel().getColumnCount() > 0) {
            listeClient.getColumnModel().getColumn(2).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(269, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 221, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listeServiceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listeServiceActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_listeServiceActionPerformed

    private void RechercherButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RechercherButtonActionPerformed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_RechercherButtonActionPerformed

    private void RechercherButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_RechercherButtonMouseClicked
        // TODO add your handling code here:
        load();
    }//GEN-LAST:event_RechercherButtonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RechercherButton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable listeClient;
    private javax.swing.JComboBox listeService;
    private javax.swing.JLabel servicesTxt;
    // End of variables declaration//GEN-END:variables
}
