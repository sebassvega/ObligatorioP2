// Sebastian Vega 28183, Alejo Fraga 281542
package interfaz;

import dominio.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import static java.lang.Integer.parseInt;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VentanaRegistrarFuncionario extends javax.swing.JFrame implements PropertyChangeListener{

    private final Sistema modelo;

    public VentanaRegistrarFuncionario(Sistema sistema) {
        initComponents();
        this.modelo = sistema;
        this.setLocationRelativeTo(null);
        this.modelo.addPropertyChangeListener(this);
        cargarLista();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lblNombre = new javax.swing.JLabel();
        lblEdad = new javax.swing.JLabel();
        lblNumero = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtEdad = new javax.swing.JTextField();
        txtNumero = new javax.swing.JTextField();
        btnAgregarFuncionario = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaFuncionarios = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar funcionario");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(null);

        lblNombre.setText("Nombre");

        lblEdad.setText("Edad");

        lblNumero.setText("Número de funcionario");

        btnAgregarFuncionario.setText("Agregar");
        btnAgregarFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarFuncionarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblEdad)
                    .addComponent(lblNombre))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtNombre)
                    .addComponent(txtEdad)
                    .addComponent(txtNumero, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnAgregarFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNombre)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEdad)
                    .addComponent(txtEdad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNumero)
                    .addComponent(txtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(btnAgregarFuncionario)
                .addGap(26, 26, 26))
        );

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, -10, 441, 308);

        tablaFuncionarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Edad", "Número de funcionario"
            }
        ));
        jScrollPane1.setViewportView(tablaFuncionarios);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(510, 20, 452, 278);

        setBounds(0, 0, 1016, 361);
    }// </editor-fold>//GEN-END:initComponents
    private void cargarLista(){
        DefaultTableModel tblModel = (DefaultTableModel) tablaFuncionarios.getModel();
        tblModel.setRowCount(0);
        for (int i = 0; i < this.modelo.getListaFuncionarios().size(); i++) {
            String[] arr = {this.modelo.getListaFuncionarios().get(i).getNombre(), ""+this.modelo.getListaFuncionarios().get(i).getEdad(), this.modelo.getListaFuncionarios().get(i).getNumeroDeFuncionario()};
            tblModel.addRow(arr);     
        }
    }
    private void btnAgregarFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarFuncionarioActionPerformed
        String nombre = txtNombre.getText().trim();
        String edad = txtEdad.getText().trim();
        String numeroDeFuncionario = txtNumero.getText().trim();
        //Crear al funcionario
        Funcionario f = new Funcionario();
        try {
            f.setNombre(nombre);
            f.setEdad(parseInt(edad));
            f.setNumeroDeFuncionario(numeroDeFuncionario);
            //Rellenar la tabla de funcionarios
            if (this.modelo.numeroDeFuncionarioUnico(numeroDeFuncionario) && this.modelo.ingresoNoVacio(nombre) && this.modelo.ingresoNoVacio(edad) && this.modelo.ingresoNoVacio(numeroDeFuncionario)) {
                String[] data = {nombre, edad, numeroDeFuncionario};
                DefaultTableModel tblModel = (DefaultTableModel) tablaFuncionarios.getModel();
                tblModel.addRow(data);
                //Agregar a la lista de funcionarios
                this.modelo.agregarFuncionario(f);
                txtNombre.setText("");
                txtEdad.setText("");
                txtNumero.setText("");
            } else if (!this.modelo.numeroDeFuncionarioUnico(numeroDeFuncionario)) {
                JOptionPane.showMessageDialog(this, "No se acepta número de funcionario repetido, reingrese", "ERROR", JOptionPane.WARNING_MESSAGE);
            } 
            
            if (!this.modelo.ingresoNoVacio(nombre) || !this.modelo.ingresoNoVacio(edad) || !this.modelo.ingresoNoVacio(numeroDeFuncionario)){
                JOptionPane.showMessageDialog(this, "No se aceptan ingresos vacíos, reingrese", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            if (edad.equals("")){
                JOptionPane.showMessageDialog(this, "No se aceptan ingresos vacíos, reingrese", "ERROR", JOptionPane.WARNING_MESSAGE);
            }else{
            JOptionPane.showMessageDialog(this, "La edad debe ser un número, reingrese", "ERROR", JOptionPane.WARNING_MESSAGE);
        }}
    }//GEN-LAST:event_btnAgregarFuncionarioActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        modelo.removePropertyChangeListener(this);
    }//GEN-LAST:event_formWindowClosed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarFuncionario;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEdad;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblNumero;
    private javax.swing.JTable tablaFuncionarios;
    private javax.swing.JTextField txtEdad;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumero;
    // End of variables declaration//GEN-END:variables

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("listaFuncionarios")){
            cargarLista();
        }
    }
}
