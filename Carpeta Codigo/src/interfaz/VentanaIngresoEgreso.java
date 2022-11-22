// Sebastian Vega 28183, Alejo Fraga 281542
package interfaz;

import dominio.*;
import java.awt.*;
import java.awt.event.*;
import java.beans.*;
import javax.swing.*;


public class VentanaIngresoEgreso extends javax.swing.JFrame implements PropertyChangeListener {

    private Sistema modelo;
    private JButton[][] matBotones = new JButton[12][10];
    int fila = 0;
    int columna = 0;

    public VentanaIngresoEgreso(Sistema sistema) {
        initComponents();
        this.modelo = sistema;
        this.modelo.addPropertyChangeListener(this);
        panelIngreso.setVisible(false);
        panelEgreso.setVisible(false);
        this.modelo.addPropertyChangeListener(this);
        cargarTabla();
        cargarListaFuncionarios();
        cargarListaArticulos();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelEspacios = new javax.swing.JPanel();
        panelIngreso = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaArticulos = new javax.swing.JList<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaFuncionarios = new javax.swing.JList<>();
        txtCantidad = new javax.swing.JTextField();
        txtCodigo = new javax.swing.JTextField();
        btnIngresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblFuncionario = new javax.swing.JLabel();
        lblArticulo = new javax.swing.JLabel();
        lblCantidad = new javax.swing.JLabel();
        lblCodigo = new javax.swing.JLabel();
        btnDerecha = new javax.swing.JButton();
        btnIzquierda = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblArea = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        panelEgreso = new javax.swing.JPanel();
        btnEgresar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        lblCodigoEgreso = new javax.swing.JLabel();
        lblArticuloEgreso = new javax.swing.JLabel();
        lblCantidadEgreso = new javax.swing.JLabel();
        lblFuncionarioEgreso = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Ingreso/Egreso manual de carga");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelEspacios.setBackground(new java.awt.Color(255, 255, 204));
        panelEspacios.setLayout(new java.awt.GridLayout(12, 10, 10, 10));
        getContentPane().add(panelEspacios, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 68, 456, 355));

        panelIngreso.setBackground(new java.awt.Color(65, 170, 117));
        panelIngreso.setLayout(null);

        jScrollPane1.setViewportView(listaArticulos);

        panelIngreso.add(jScrollPane1);
        jScrollPane1.setBounds(214, 118, 162, 111);

        jScrollPane2.setViewportView(listaFuncionarios);

        panelIngreso.add(jScrollPane2);
        jScrollPane2.setBounds(24, 118, 162, 111);
        panelIngreso.add(txtCantidad);
        txtCantidad.setBounds(440, 120, 90, 20);

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        panelIngreso.add(txtCodigo);
        txtCodigo.setBounds(440, 180, 90, 20);

        btnIngresar.setBackground(new java.awt.Color(204, 204, 204));
        btnIngresar.setText("Ingresar");
        btnIngresar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnIngresarMousePressed(evt);
            }
        });
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });
        panelIngreso.add(btnIngresar);
        btnIngresar.setBounds(430, 240, 110, 23);

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Ingreso");
        panelIngreso.add(jLabel1);
        jLabel1.setBounds(10, 20, 60, 30);

        lblFuncionario.setText("Funcionarios");
        panelIngreso.add(lblFuncionario);
        lblFuncionario.setBounds(30, 80, 110, 14);

        lblArticulo.setText("Articulos");
        panelIngreso.add(lblArticulo);
        lblArticulo.setBounds(220, 80, 120, 14);

        lblCantidad.setText("Cantidad");
        panelIngreso.add(lblCantidad);
        lblCantidad.setBounds(440, 100, 80, 14);

        lblCodigo.setText("Código");
        panelIngreso.add(lblCodigo);
        lblCodigo.setBounds(440, 160, 80, 14);

        getContentPane().add(panelIngreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 580, 311));

        btnDerecha.setText(">>");
        btnDerecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDerechaActionPerformed(evt);
            }
        });
        getContentPane().add(btnDerecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(447, 457, -1, -1));

        btnIzquierda.setText("<<");
        btnIzquierda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIzquierdaActionPerformed(evt);
            }
        });
        getContentPane().add(btnIzquierda, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 457, -1, -1));

        jLabel2.setText("Área:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 40, -1));

        lblArea.setText("A");
        getContentPane().add(lblArea, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, 20, -1));

        jLabel4.setText("1              2             3              4              5             6              7             8              9            10");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 50, 480, -1));

        jLabel5.setText("1");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 20, -1));

        jLabel6.setText("2");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 20, -1));

        jLabel7.setText("3");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 20, -1));

        jLabel8.setText("4");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, 20, -1));

        jLabel9.setText("5");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 20, -1));

        jLabel10.setText("6");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, 20, -1));

        jLabel11.setText("7");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 20, -1));

        jLabel12.setText("8");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 290, 20, -1));

        jLabel13.setText("9");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 20, -1));

        jLabel14.setText("10");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 20, -1));

        jLabel15.setText("11");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 20, -1));

        jLabel16.setText("12");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 20, -1));
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, -1, -1));

        panelEgreso.setBackground(new java.awt.Color(79, 169, 214));
        panelEgreso.setLayout(null);

        btnEgresar.setText("Egresar");
        btnEgresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEgresarActionPerformed(evt);
            }
        });
        panelEgreso.add(btnEgresar);
        btnEgresar.setBounds(435, 260, 100, 23);

        jLabel3.setText("Egreso");
        panelEgreso.add(jLabel3);
        jLabel3.setBounds(20, 30, 80, 14);

        jLabel17.setText("Código");
        panelEgreso.add(jLabel17);
        jLabel17.setBounds(50, 70, 90, 14);

        jLabel18.setText("Artículo");
        panelEgreso.add(jLabel18);
        jLabel18.setBounds(50, 110, 80, 14);

        jLabel19.setText("Cantidad");
        panelEgreso.add(jLabel19);
        jLabel19.setBounds(50, 150, 80, 14);

        jLabel20.setText("Funcionario");
        panelEgreso.add(jLabel20);
        jLabel20.setBounds(50, 190, 80, 14);

        lblCodigoEgreso.setText("-");
        panelEgreso.add(lblCodigoEgreso);
        lblCodigoEgreso.setBounds(190, 70, 170, 14);

        lblArticuloEgreso.setText("-");
        panelEgreso.add(lblArticuloEgreso);
        lblArticuloEgreso.setBounds(190, 110, 160, 14);

        lblCantidadEgreso.setText("-");
        panelEgreso.add(lblCantidadEgreso);
        lblCantidadEgreso.setBounds(190, 150, 150, 14);

        lblFuncionarioEgreso.setText("-");
        panelEgreso.add(lblFuncionarioEgreso);
        lblFuncionarioEgreso.setBounds(190, 190, 160, 14);

        getContentPane().add(panelEgreso, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 580, 310));

        setBounds(0, 0, 1170, 558);
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        if(modelo.puedeIngresar(fila, columna)){
            try {
            Funcionario f = this.modelo.getListaFuncionarios().get(this.listaFuncionarios.getSelectedIndex());
            Articulo a = this.modelo.getListaArticulos().get(this.listaArticulos.getSelectedIndex());
            String cantidad = (txtCantidad.getText().trim());
            String codigo = txtCodigo.getText().trim();

                if (f != null && a != null && Integer.parseInt(cantidad) > 0 && Integer.parseInt(codigo) > 0 && modelo.codigoCargaUnico(codigo)) {

                    Carga c = new Carga(f, a, Integer.parseInt(cantidad), codigo);
                    modelo.agregarCargaALista(c);
                    modelo.agregarCarga(modelo.getAreaActual(), fila, columna, c);
                    //
                    listaFuncionarios.clearSelection();
                    listaArticulos.clearSelection();
                    txtCantidad.setText("");
                    txtCodigo.setText("");
                    //
                    lblCodigoEgreso.setText(c.getCodigo());
                    lblArticuloEgreso.setText(c.getArticulo().getNombre());
                    lblFuncionarioEgreso.setText(c.getFuncionario().getNombre());
                    lblCantidadEgreso.setText(c.getCantidad() + "");
                    //
                    panelIngreso.setVisible(false);
                    panelEgreso.setVisible(true);
                } else if (!modelo.codigoCargaUnico(codigo)) {
                    JOptionPane.showMessageDialog(this, "El código debe ser único, reingrese", "ERROR", JOptionPane.WARNING_MESSAGE);
                    txtCodigo.setText("");
                } else if (Integer.parseInt(codigo) <= 0) {
                    JOptionPane.showMessageDialog(this, "El código debe ser mayor a 0, reingrese", "ERROR", JOptionPane.WARNING_MESSAGE);
                    txtCodigo.setText("");
                } 
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "La cantidad/código debe ser un numero, reingrese", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
            catch (IndexOutOfBoundsException e ){
                JOptionPane.showMessageDialog(this, "No se aceptan ingresos vacíos, reingrese", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        } else{
            JOptionPane.showMessageDialog(this, "Ya hay una carga ingresada en esa posición", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnIngresarActionPerformed
   
    private void cargarListaFuncionarios() {
        //Crear un objeto DefaultListModel
        DefaultListModel listModel = new DefaultListModel();
        //Recorrer el contenido del ArrayList
        for (int i = 0; i < this.modelo.getListaFuncionarios().size(); i++) {
            //Añadir cada elemento del ArrayList en el modelo de la lista
            listModel.add(i, this.modelo.getListaFuncionarios().get(i).toString());
        }
        //Asociar el modelo de lista al JList
        this.listaFuncionarios.setModel(listModel);
    }

    private void cargarListaArticulos() {
        //Crear un objeto DefaultListModel
        DefaultListModel listModel = new DefaultListModel();
        //Recorrer el contenido del ArrayList
        for (int i = 0; i < this.modelo.getListaArticulos().size(); i++) {
            //Añadir cada elemento del ArrayList en el modelo de la lista
            listModel.add(i, this.modelo.getListaArticulos().get(i).toString());

        }
        //Asociar el modelo de lista al JList
        this.listaArticulos.setModel(listModel);
    }
    private void btnIngresarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnIngresarMousePressed
 
    }//GEN-LAST:event_btnIngresarMousePressed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed

    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnIzquierdaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIzquierdaActionPerformed
        recorrerYPintarMatriz(matBotones);
        modelo.moverAreaHaciaIzquierda(lblArea.getText());
        lblArea.setText(modelo.getAreaActual());
        panelIngreso.setVisible(false);
        panelEgreso.setVisible(false);
    }//GEN-LAST:event_btnIzquierdaActionPerformed

    private void btnDerechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDerechaActionPerformed
        recorrerYPintarMatriz(matBotones);
        modelo.moverAreaHaciaDerecha(lblArea.getText());
        lblArea.setText(modelo.getAreaActual());
        panelIngreso.setVisible(false);
        panelEgreso.setVisible(false);
    }//GEN-LAST:event_btnDerechaActionPerformed

    private void btnEgresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEgresarActionPerformed
        if(!modelo.puedeIngresar(fila, columna)){
            modelo.eliminarCarga(modelo.getAreaActual(), fila, columna);
            //eliminar carga de la lista de cargas
            panelIngreso.setVisible(true);
            panelEgreso.setVisible(false);
        } else{
            JOptionPane.showMessageDialog(this, "Esa posicion ya fue egresada", "ERROR", JOptionPane.WARNING_MESSAGE);
            panelEgreso.setVisible(false);
            panelIngreso.setVisible(true);
        }
    }//GEN-LAST:event_btnEgresarActionPerformed

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("listaFuncionarios")) {
            cargarListaFuncionarios();
        } else if (evt.getPropertyName().equals("listaArticulos")) {
            cargarListaArticulos();
        }
    }

    private class EspacioListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            // este código se ejecutará al presionar el botón, obtengo cuál botón
            JButton cual = ((JButton) e.getSource());
            // código a completar según el botón presionad

            String[] indices = cual.getText().split(":");
            fila = Integer.parseInt(indices[0]) - 1;
            columna = Integer.parseInt(indices[1]) - 1;

            recorrerYPintarMatriz(matBotones);
            cual.setBackground(Color.red);

            switch (modelo.getAreaActual()) {
                case "A": {
                    accionarPaneles(modelo.getMatA(), fila, columna);
                    break;
                }
                case "B": {
                    accionarPaneles(modelo.getMatB(), fila, columna);
                    break;
                }
                case "C": {
                    accionarPaneles(modelo.getMatC(), fila, columna);
                    break;
                }
                case "D": {
                    accionarPaneles(modelo.getMatD(), fila, columna);
                    break;
                }
                case "E": {
                    accionarPaneles(modelo.getMatE(), fila, columna);
                    break;
                }
            }
        }
    }

    public void accionarPaneles(Carga[][] matCarga, int i, int j) {
        if (matCarga[i][j] == null) {
            panelEgreso.setVisible(false);
            panelIngreso.setVisible(true);
            
        } else {
            lblCodigoEgreso.setText(matCarga[i][j].getCodigo());
            lblArticuloEgreso.setText(matCarga[i][j].getArticulo().getNombre());
            lblFuncionarioEgreso.setText(matCarga[i][j].getFuncionario().getNombre());
            lblCantidadEgreso.setText(matCarga[i][j].getCantidad() + "");
            panelIngreso.setVisible(false);
            panelEgreso.setVisible(true);
        } 
    }
    
    public void cargarTabla() {
        for (int i = 1; i < 13; i++) {
            for (int j = 1; j < 11; j++) {
                JButton nuevo = new JButton(" ");
                nuevo.setMargin(new Insets(-5, -5, -5, -5));
                nuevo.setBackground(Color.GRAY);
                nuevo.setForeground(Color.WHITE);
                nuevo.setText(i + ":" + j); // texto ejemplo, a completar
                nuevo.addActionListener(new EspacioListener());
                panelEspacios.add(nuevo);
                matBotones[i - 1][j - 1] = nuevo;
            }
        }
    }

    public void recorrerYPintarMatriz(JButton[][] mat) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 10; j++) {
                mat[i][j].setBackground(Color.GRAY);
            }
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDerecha;
    private javax.swing.JButton btnEgresar;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnIzquierda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblArticulo;
    private javax.swing.JLabel lblArticuloEgreso;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCantidadEgreso;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCodigoEgreso;
    private javax.swing.JLabel lblFuncionario;
    private javax.swing.JLabel lblFuncionarioEgreso;
    private javax.swing.JList<String> listaArticulos;
    private javax.swing.JList<String> listaFuncionarios;
    private javax.swing.JPanel panelEgreso;
    private javax.swing.JPanel panelEspacios;
    private javax.swing.JPanel panelIngreso;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCodigo;
    // End of variables declaration//GEN-END:variables
}
