// Sebastian Vega 28183, Alejo Fraga 281542
package interfaz;

import dominio.Sistema;

import java.util.Scanner;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import archivo.ArchivoLectura;
import javax.swing.table.DefaultTableModel;
import dominio.*;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableCellRenderer;
import java.io.File;



public class VentanaRegistroDeVuelo extends javax.swing.JFrame {

    private final Sistema modelo;

    public VentanaRegistroDeVuelo(Sistema sistema) {
        UIManager.put("FileChooser.lookInLabelText", "Mirar en");
        UIManager.put("FileChooser.openButtonText", "Abrir");
        UIManager.put("FileChooser.cancelButtonText", "Cancelar");
        UIManager.put("FileChooser.fileNameLabelText", "Archivo");
        UIManager.put("FileChooser.openButtonToolTipText", "Abrir archivo seleccionado");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Cancelar");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Tipo");
        initComponents();
        this.modelo = sistema;
        this.setLocationRelativeTo(null);

        JFileChooser fileChooser = jFileChooser1;

        fileChooser.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Archivo de texto", "txt");
        fileChooser.addChoosableFileFilter(filter);
    }

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser("src//txt");
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaVuelos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        lblArea = new javax.swing.JLabel();
        lblFila = new javax.swing.JLabel();
        lblCoincidencias = new javax.swing.JLabel();
        lblDiferencias = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Registrar vuelo de dron");
        setResizable(false);
        getContentPane().setLayout(null);

        jFileChooser1.setFileFilter(null);
        jFileChooser1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser1ActionPerformed(evt);
            }
        });
        getContentPane().add(jFileChooser1);
        jFileChooser1.setBounds(20, 10, 500, 326);

        tablaVuelos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        tablaVuelos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "De", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"
            }
        ));
        tablaVuelos.setRowSelectionAllowed(false);
        jScrollPane1.setViewportView(tablaVuelos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 450, 740, 75);

        jLabel1.setText("Área: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(30, 410, 45, 14);

        jLabel2.setText("Fila: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(100, 410, 41, 14);

        jLabel3.setText("Total coincidencias:");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 540, 120, 14);

        jLabel4.setText("Total diferencias:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(30, 580, 110, 14);

        lblArea.setText("-");
        getContentPane().add(lblArea);
        lblArea.setBounds(70, 410, 41, 14);

        lblFila.setText("-");
        getContentPane().add(lblFila);
        lblFila.setBounds(130, 410, 56, 14);

        lblCoincidencias.setText("-");
        getContentPane().add(lblCoincidencias);
        lblCoincidencias.setBounds(150, 540, 48, 14);

        lblDiferencias.setText("-");
        getContentPane().add(lblDiferencias);
        lblDiferencias.setBounds(130, 580, 61, 14);

        setBounds(0, 0, 835, 646);
    }// </editor-fold>//GEN-END:initComponents

    private void jFileChooser1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser1ActionPerformed
        DefaultTableModel model = (DefaultTableModel) tablaVuelos.getModel();

        //limpiar la tabla
        int rowCount = model.getRowCount();
        for (int i = rowCount - 1; i >= 0; i--) {
            model.removeRow(i);
        }

        Scanner entrada = null;

        String nombreArchivo = "";

        JFileChooser fileChooser = jFileChooser1;

        if (evt.getActionCommand().equals("ApproveSelection")){         
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            File f = new File(ruta);
            if(f.exists()){
                nombreArchivo = fileChooser.getSelectedFile().getName();
                ArchivoLectura arch = new ArchivoLectura(ruta);
                ArrayList<String> codigosArchivo = new ArrayList<>();
                boolean esExitoso = true;
                String area = "";
                String identificador = "";
                int fila = 0;
                int coincidencias = 0;
                int diferencias = 0;
                if (arch.hayMasLineas()) {
                    identificador = arch.linea();
                }
                if (arch.hayMasLineas()) {
                    String[] areaYFila = arch.linea().split("#");
                    area = areaYFila[0];
                    fila = Integer.parseInt(areaYFila[1]);
                    lblArea.setText(area);
                    lblFila.setText(fila + "");
                }
                while (arch.hayMasLineas()) {
                    codigosArchivo.add(arch.linea());
                }
                if (codigosArchivo.size() != 10) {
                    esExitoso = false;
                    //meterlos a un array list de vuelos no exitosos
                }
                if (esExitoso) {

                    String[] codigosArchivoArray = arrayListToArray(codigosArchivo);

                    model.addRow(codigosArchivoArray);
                    //meterlos a un array list de vuelos exitosos
                    //meter la fila que me pide
                    String[] codigosManual = modelo.codigosDeLaFila(area, fila - 1);
                    model.addRow(codigosManual);
                    //
                    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
                    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                    tablaVuelos.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
                    //volver a pintar de blanco
                    tablaVuelos.setBackground(Color.lightGray);
                    for (int j = 1; j < 11; j++) {
                        if (codigosArchivoArray[j].equals(codigosManual[j])) {
                            coincidencias++;
                            diferencias = 10 - coincidencias;
                            //pintar de verde las coincidencias
                            tablaVuelos.getColumnModel().getColumn(j).setCellRenderer(
                                    new DefaultTableCellRenderer() {
                                public Component getTableCellRendererComponent(JTable table,
                                        Object value,
                                        boolean isSelected,
                                        boolean hasFocus,
                                        int row,
                                        int column) {
                                    setText(value.toString());
                                    setHorizontalAlignment(JLabel.CENTER); //esto es para que los codigos esten centrados pero no funciona
                                    setBorder(new MatteBorder(1,0,1,0,Color.BLACK));
                                    setBackground(Color.green);
                                    return this;
                                }
                            });
                        } else {
                            diferencias = 10 - coincidencias;
                            //pintar de rojo las diferencias
                            tablaVuelos.getColumnModel().getColumn(j).setCellRenderer(
                                    new DefaultTableCellRenderer() {
                                public Component getTableCellRendererComponent(JTable table,
                                        Object value,
                                        boolean isSelected,
                                        boolean hasFocus,
                                        int row,
                                        int column) {
                                    setText(value.toString());
                                    setHorizontalAlignment(JLabel.CENTER);
                                    setBorder(new MatteBorder(1,1,1,1,Color.BLACK));
                                    setBackground(Color.red);
                                    return this;
                                }
                            });
                        }
                    }
                    if (!modelo.vueloExitosoRepetido(nombreArchivo)) {
                        VueloExitoso vE = new VueloExitoso(coincidencias, diferencias, modelo.buscarDronPorId(identificador), area, fila, nombreArchivo);
                        modelo.agregarVueloExitoso(vE);
                        modelo.buscarDronPorId(identificador).setTieneVuelo(true);
                        lblCoincidencias.setText(coincidencias + "");
                        lblDiferencias.setText(diferencias + "");
                    } else {
                        JOptionPane.showMessageDialog(this, "Vuelo ya registrado", "ERROR", JOptionPane.WARNING_MESSAGE);
                    }
                } else {
                    if (!modelo.vueloNoExitosoRepetido(nombreArchivo)) {
                        VueloNoExitoso vNE = new VueloNoExitoso(codigosArchivo.size(), modelo.buscarDronPorId(identificador), area, fila, nombreArchivo);
                        modelo.agregarVueloNoExitoso(vNE);
                        modelo.buscarDronPorId(identificador).setTieneVuelo(true);
                    } else {
                        JOptionPane.showMessageDialog(this, "Vuelo ya registrado", "ERROR", JOptionPane.WARNING_MESSAGE);
                    }
                    JOptionPane.showMessageDialog(this, "El archivo tiene " + (codigosArchivo.size()) + " linea/s de código de carga, no es exitoso ya que debe tener 10 lineas", "ERROR", JOptionPane.WARNING_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "El archivo elegido no existe, reingrese", "ERROR", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            
        }


    }//GEN-LAST:event_jFileChooser1ActionPerformed

    public String[] arrayListToArray(ArrayList<String> arrList) {
        String[] arr = new String[11];
        arr[0] = "Archivo";
        for (int i = 0; i < arrList.size(); i++) {
            arr[i + 1] = arrList.get(i);
        }
        return arr;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblArea;
    private javax.swing.JLabel lblCoincidencias;
    private javax.swing.JLabel lblDiferencias;
    private javax.swing.JLabel lblFila;
    private javax.swing.JTable tablaVuelos;
    // End of variables declaration//GEN-END:variables
}
