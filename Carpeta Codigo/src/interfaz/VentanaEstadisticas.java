// Sebastian Vega 28183, Alejo Fraga 281542
package interfaz;

import dominio.*;
import java.util.ArrayList;
import javax.swing.*;

public class VentanaEstadisticas extends javax.swing.JFrame {

    private Sistema modelo;

    public VentanaEstadisticas(Sistema sistema) {
        initComponents();
        modelo = sistema;
        this.setLocationRelativeTo(null);
        cargarListaSinVuelos();
        cargarListaConVuelos();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listaConVuelos = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        listaInfo = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        listaSinVuelos = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Emisión de estadísticas");
        setResizable(false);
        getContentPane().setLayout(null);

        listaConVuelos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaConVuelosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(listaConVuelos);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(60, 180, 140, 130);

        jScrollPane2.setViewportView(listaInfo);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(60, 360, 600, 130);

        listaSinVuelos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listaSinVuelosMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(listaSinVuelos);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(510, 180, 140, 130);

        jLabel1.setText("Drones con vuelos");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(60, 160, 258, 14);

        jLabel2.setText("Drones sin vuelos");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(510, 160, 136, 14);

        jLabel3.setText("Informacion de vuelos");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(60, 340, 258, 14);

        setBounds(0, 0, 725, 549);
    }// </editor-fold>//GEN-END:initComponents

    private void listaConVuelosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaConVuelosMouseClicked
        try{
        Dron d = (Dron) listaConVuelos.getSelectedValue();
        ArrayList<Vuelo> vuelos = new ArrayList<>(); 
        for (int i = 0; i < modelo.getListaVuelosExitosos().size(); i++) {
            if (d.getIdentificacion().equals(modelo.getListaVuelosExitosos().get(i).getDron().getIdentificacion())) {
                vuelos.add(modelo.getListaVuelosExitosos().get(i));//pasar a array nombre de archivo, fila y area
            }
        }
        for (int i = 0; i < modelo.getListaVuelosNoExitosos().size(); i++) {
            if (d.getIdentificacion().equals(modelo.getListaVuelosNoExitosos().get(i).getDron().getIdentificacion())) {
                vuelos.add(modelo.getListaVuelosNoExitosos().get(i));//pasar a array cantidad de lineas
            }
        }
        listaInfo.setListData(vuelos.toArray());
        }
        catch (NullPointerException e){
            JOptionPane.showMessageDialog(this, "No se selecciono ningun Dron", "ERROR", JOptionPane.WARNING_MESSAGE);
        }
        
    }//GEN-LAST:event_listaConVuelosMouseClicked

    private void listaSinVuelosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listaSinVuelosMouseClicked

    }//GEN-LAST:event_listaSinVuelosMouseClicked

    public void cargarListaSinVuelos() {
        ArrayList<Dron> dronesSinVuelos = new ArrayList<>();
        for (int i = 0; i < modelo.getListaDrones().size(); i++) {
            if (!modelo.getListaDrones().get(i).tieneVuelo()) {
                dronesSinVuelos.add(modelo.getListaDrones().get(i));
            }
        }
        listaSinVuelos.setListData(dronesSinVuelos.toArray());
    }

    public void cargarListaConVuelos() {
        ArrayList<Dron> dronesConVuelos = new ArrayList<>();
        for (int i = 0; i < modelo.getListaDrones().size(); i++) {
            if (modelo.getListaDrones().get(i).tieneVuelo()) {
                dronesConVuelos.add(modelo.getListaDrones().get(i));
            }
        }
        listaConVuelos.setListData(dronesConVuelos.toArray());
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList listaConVuelos;
    private javax.swing.JList listaInfo;
    private javax.swing.JList listaSinVuelos;
    // End of variables declaration//GEN-END:variables

   
}
