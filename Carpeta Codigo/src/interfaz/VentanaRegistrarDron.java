// Sebastian Vega 28183, Alejo Fraga 281542
package interfaz;

import dominio.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import static java.lang.Integer.parseInt;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


public class VentanaRegistrarDron extends javax.swing.JFrame  implements PropertyChangeListener{

    private final Sistema modelo;

    public VentanaRegistrarDron(Sistema sistema) {
        initComponents();
        this.modelo = sistema;
        this.modelo.addPropertyChangeListener(this);
        cargarLista();
        this.setLocationRelativeTo(null);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblIdentificacion = new javax.swing.JLabel();
        lblModelo = new javax.swing.JLabel();
        lblCamara = new javax.swing.JLabel();
        txtIdentificacion = new javax.swing.JTextField();
        txtModelo = new javax.swing.JTextField();
        txtCamara = new javax.swing.JTextField();
        btnAgregarDron = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDrones = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar dron");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        lblIdentificacion.setText("Identificacion");

        lblModelo.setText("Modelo");

        lblCamara.setText("Tipo de cámara");

        btnAgregarDron.setText("Agregar");
        btnAgregarDron.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDronActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnAgregarDron, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCamara, javax.swing.GroupLayout.DEFAULT_SIZE, 106, Short.MAX_VALUE)
                            .addComponent(lblModelo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIdentificacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtIdentificacion)
                            .addComponent(txtModelo)
                            .addComponent(txtCamara, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))))
                .addGap(55, 55, 55))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblIdentificacion)
                    .addComponent(txtIdentificacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModelo)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCamara)
                    .addComponent(txtCamara, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                .addComponent(btnAgregarDron)
                .addContainerGap())
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(6, 6, 493, 304);

        tablaDrones.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Identificacion", "Modelo", "Tipo de cámara"
            }
        ));
        jScrollPane1.setViewportView(tablaDrones);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(500, 40, 452, 276);

        setBounds(0, 0, 998, 379);
    }// </editor-fold>//GEN-END:initComponents
    private void cargarLista() {
        DefaultTableModel tblModel = (DefaultTableModel) tablaDrones.getModel();
        tblModel.setRowCount(0);
        for (int i = 0; i < this.modelo.getListaDrones().size(); i++) {
            String[] arr = {this.modelo.getListaDrones().get(i).getIdentificacion(), this.modelo.getListaDrones().get(i).getModelo(), ""+this.modelo.getListaDrones().get(i).getTipoDeCamara()};
            tblModel.addRow(arr);
        }
    }
    private void btnAgregarDronActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDronActionPerformed
        String identificacion = txtIdentificacion.getText().trim();
        String modelo = txtModelo.getText().trim();
        String tipoDeCamara = txtCamara.getText().trim();
        //Creamos el dron
        Dron d = new Dron();
        try {
            d.setIdentificacion(identificacion);
            d.setModelo(modelo);
            d.setTipoDeCamara(parseInt(tipoDeCamara));
            //Rellenar la tabla de drones
            if (this.modelo.identificacionUnica(identificacion) && this.modelo.tipoDeCamaraValido(parseInt(tipoDeCamara))
                    && this.modelo.ingresoNoVacio(identificacion) && this.modelo.ingresoNoVacio(modelo) && this.modelo.ingresoNoVacio(tipoDeCamara)) {
                String[] data = {identificacion, modelo, tipoDeCamara};
                DefaultTableModel tblModel = (DefaultTableModel) tablaDrones.getModel();
                tblModel.addRow(data);
                //Agregar a la lista de funcionarios
                this.modelo.agregarDron(d);
                txtIdentificacion.setText("");
                txtModelo.setText("");
                txtCamara.setText("");
                
            }
            
            else if (!this.modelo.identificacionUnica(identificacion)) {
                JOptionPane.showMessageDialog(this, "No se acepta identificador de dron repetido, reingrese", "ERROR", JOptionPane.WARNING_MESSAGE);
            } else if (!this.modelo.tipoDeCamaraValido(parseInt(tipoDeCamara))) {
                JOptionPane.showMessageDialog(this, "Tipo de camara debe estar entre 1 y 6, reingrese", "ERROR", JOptionPane.WARNING_MESSAGE);
            } 
            else if (this.modelo.ingresoNoVacio(identificacion) || this.modelo.ingresoNoVacio(modelo) || this.modelo.ingresoNoVacio(tipoDeCamara)) {
                JOptionPane.showMessageDialog(this, "No se aceptan ingresos vacíos, reingrese", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            if (tipoDeCamara.equals("")){
                JOptionPane.showMessageDialog(this, "No se aceptan ingresos vacíos, reingrese", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else{
                
            JOptionPane.showMessageDialog(this, "El tipo de camara debe ser un numero, reingrese", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        }

    }//GEN-LAST:event_btnAgregarDronActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        modelo.removePropertyChangeListener(this);
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarDron;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCamara;
    private javax.swing.JLabel lblIdentificacion;
    private javax.swing.JLabel lblModelo;
    private javax.swing.JTable tablaDrones;
    private javax.swing.JTextField txtCamara;
    private javax.swing.JTextField txtIdentificacion;
    private javax.swing.JTextField txtModelo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("listaDrones")){
            cargarLista();
        }
    }
}
