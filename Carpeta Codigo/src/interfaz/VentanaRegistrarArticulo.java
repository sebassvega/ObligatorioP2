// Sebastian Vega 28183, Alejo Fraga 281542
package interfaz;

import dominio.Articulo;
import dominio.Sistema;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VentanaRegistrarArticulo extends javax.swing.JFrame implements PropertyChangeListener{

    private final Sistema modelo;

    public VentanaRegistrarArticulo(Sistema sistema) {
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
        lblNombre = new javax.swing.JLabel();
        lblDesc = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtDesc = new javax.swing.JTextField();
        btnAgregarArticulo = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaArticulos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar artículo");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        jPanel1.setToolTipText("");

        lblNombre.setText("Nombre");

        lblDesc.setText("Descripcion");

        btnAgregarArticulo.setText("Agregar");
        btnAgregarArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarArticuloActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(lblNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNombre)
                    .addComponent(txtDesc, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE))
                .addGap(40, 40, 40))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarArticulo)
                .addGap(57, 57, 57))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNombre))
                        .addGap(37, 37, 37)
                        .addComponent(txtDesc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblDesc))
                .addGap(46, 46, 46)
                .addComponent(btnAgregarArticulo)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(20, 0, 398, 227);

        tablaArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Descripcion"
            }
        ));
        jScrollPane1.setViewportView(tablaArticulos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(430, 30, 452, 180);

        setBounds(0, 0, 916, 265);
    }// </editor-fold>//GEN-END:initComponents
    
    private void cargarLista(){
        DefaultTableModel tblModel = (DefaultTableModel) tablaArticulos.getModel();
        tblModel.setRowCount(0);
        for (int i = 0; i < this.modelo.getListaArticulos().size(); i++) {
            String[] arr = {this.modelo.getListaArticulos().get(i).getNombre(), this.modelo.getListaArticulos().get(i).getDescripcion()};
            tblModel.addRow(arr);     
        }
    }
    
    private void btnAgregarArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarArticuloActionPerformed
        String nombre = txtNombre.getText().trim();
        String descripcion = txtDesc.getText().trim();
        //Crear un articulo
        Articulo a = new Articulo(nombre, descripcion);
        //Rellenar la tabla
        if (this.modelo.nombreUnico(nombre) && this.modelo.ingresoNoVacio(nombre) && this.modelo.ingresoNoVacio(descripcion)) {
            String[] data = {nombre, descripcion};
            DefaultTableModel tblModel = (DefaultTableModel) tablaArticulos.getModel();
            tblModel.addRow(data);
            //Agregar a la lista de Articulos
            this.modelo.agregarArticulo(a);
            txtNombre.setText("");
            txtDesc.setText("");
        } else if (!this.modelo.nombreUnico(nombre)) {
            JOptionPane.showMessageDialog(this, "No se aceptan nombres repetidos, reingrese", "ERROR", JOptionPane.WARNING_MESSAGE);
        } else if (!this.modelo.ingresoNoVacio(nombre) || !this.modelo.ingresoNoVacio(descripcion)) {
            JOptionPane.showMessageDialog(this, "No se aceptan ingresos vacios, reingrese", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnAgregarArticuloActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        modelo.removePropertyChangeListener(this);
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarArticulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDesc;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JTable tablaArticulos;
    private javax.swing.JTextField txtDesc;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("listaArticulos")){
            cargarLista();
        }
    }
}
