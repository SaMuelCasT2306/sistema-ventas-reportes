package com.poo.edu.utp.ingenieria.sistemaventas.ui;

import com.poo.edu.utp.ingenieria.sistemaventas.controladores.Controlador;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Cliente;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import com.formdev.flatlaf.FlatDarkLaf;
import com.poo.edu.utp.ingenieria.sistemaventas.dto.FacturaClienteDTO;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Factura;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Producto;
import com.raven.datechooser.DateBetween;
import com.raven.datechooser.DateChooser;
import com.raven.datechooser.listener.DateChooserAction;
import com.raven.datechooser.listener.DateChooserAdapter;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

public class PantallaFacturas extends javax.swing.JFrame {

    private DateChooser chDate = new DateChooser();
    Controlador control = null;

    public PantallaFacturas() {
        control = new Controlador();
        initComponents();
        MenuContextual();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        //Calendario desplegable
        chDate.setTextField(jTextField1);
        chDate.setDateSelectionMode(DateChooser.DateSelectionMode.BETWEEN_DATE_SELECTED);
        chDate.setLabelCurrentDayVisible(false);
        chDate.setDateFormat(new SimpleDateFormat("yyyy-MM-dd"));
        chDate.addActionDateChooserListener(new DateChooserAdapter() {
            @Override
            public void dateBetweenChanged(DateBetween date, DateChooserAction action) {
                SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                String dateFrom = df.format(date.getFromDate());
                String toDate = df.format(date.getToDate());
                try {
                    CargarTablaFiltrada(dateFrom, toDate);
                } catch (SQLException ex) {
                    System.err.println("Error: " + ex);
                }
            }

        }
        );

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(39, 39, 39));

        jLabel1.setFont(new java.awt.Font("Ebrima", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REPORTE FACTURAS");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));

        jButton2.setFont(new java.awt.Font("Ebrima", 1, 12)); // NOI18N
        jButton2.setForeground(new java.awt.Color(102, 102, 102));
        jButton2.setText("Salir");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Ebrima", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Filtrar por fecha:");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });

        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("Agregar factura");
        jButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setForeground(new java.awt.Color(102, 102, 102));
        jButton3.setText("Actualizar");
        jButton3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 203, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(241, 241, 241)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING))))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            CargarTabla();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
    }//GEN-LAST:event_formWindowOpened

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased

    }//GEN-LAST:event_jTextField1KeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PantallaCrearFactura pcf = new PantallaCrearFactura();
        pcf.setVisible(true);
        pcf.setLocationRelativeTo(null);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            CargarTabla();
        } catch (SQLException ex) {
            System.err.println("Error: " + ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private void CargarTablaFiltrada(String dateFrom, String toDate) throws SQLException {
        // Definir modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        //Cabeceras de la tabla
        String cabeceras[] = {"Id", "Número de factura", "Fecha", "Condicion de Pago", "Subtotal", "IGV", "Total"};
        modeloTabla.setColumnIdentifiers(cabeceras);

        float importeTotal = 0;
        float importeAcumulado = 0;
        DecimalFormat df = new DecimalFormat("0.00");

        List<FacturaClienteDTO> listaFactura = control.cargarTablaFacturasPorFecha(dateFrom, toDate);
        if (listaFactura != null) {

            for (FacturaClienteDTO c : listaFactura) {

                importeAcumulado = c.getTotal();
                importeTotal += importeAcumulado;

                String totalFormatado = df.format(c.getTotal());
                String subtotalFormateado = df.format(c.getSubtotal());
                String igvFormateado = df.format(c.getIgv());
                Object itemsTabla[] = {c.getId(), c.getNroFactura(), c.getFecha(), c.getCondicionPago(), subtotalFormateado, igvFormateado, totalFormatado};
                modeloTabla.addRow(itemsTabla);

            }
            String importeTotalFormateado = df.format(importeTotal);
            jTable1.setModel(modeloTabla);
            jLabel3.setText("Monto total: S/." + importeTotalFormateado);

        }
    }

    private void CargarTabla() throws SQLException {
        // Definir modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        //Cabeceras de la tabla
        String cabeceras[] = {"Id", "Número de factura", "Fecha", "Condicion de Pago", "Subtotal", "IGV", "Total"};
        modeloTabla.setColumnIdentifiers(cabeceras);

        float importeTotal = 0;
        float importeAcumulado = 0;
        DecimalFormat df = new DecimalFormat("0.00");

        List<FacturaClienteDTO> listaFactura = control.cargarTablaFacturas();
        if (listaFactura != null) {

            for (FacturaClienteDTO c : listaFactura) {

                importeAcumulado = c.getTotal();
                importeTotal += importeAcumulado;

                String totalFormatado = df.format(c.getTotal());
                String subtotalFormateado = df.format(c.getSubtotal());
                String igvFormateado = df.format(c.getIgv());
                Object itemsTabla[] = {c.getId(), c.getNroFactura(), c.getFecha(), c.getCondicionPago(), subtotalFormateado, igvFormateado, totalFormatado};
                modeloTabla.addRow(itemsTabla);

            }
            String importeTotalFormateado = df.format(importeTotal);
            jTable1.setModel(modeloTabla);
            jLabel3.setText("Monto total: S/." + importeTotalFormateado);

        }
    }

    private void MenuContextual() {

        JPopupMenu menuContextual = new JPopupMenu();
        // Crear las opciones del menú
        JMenuItem itemEliminar = new JMenuItem("Eliminar Factura");
        // Asignar acciones a cada opción
        itemEliminar.addActionListener(e -> eliminarFactura());
        // Agregar las opciones al menú
        menuContextual.add(itemEliminar);
        // Asociar el menú contextual a la tabla
        jTable1.setComponentPopupMenu(menuContextual);
    }

    private void eliminarFactura() {

        int filaSeleccionada = jTable1.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, seleccione una factura primero",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener datos de la factura
        int id = (int) jTable1.getValueAt(filaSeleccionada, 0); // Columna oculta ID
        String nroFactura = (String) jTable1.getValueAt(filaSeleccionada, 1); // Ahora es columna 1

        // Confirmación antes de eliminar
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de eliminar la factura " + nroFactura + "?\n"
                + "Esta acción eliminará la factura y todos sus detalles asociados.",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.WARNING_MESSAGE);

        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            // Crear objeto Factura con el ID
            Factura factura = new Factura();
            factura.setId(id);
            factura.setNumeroFactura(nroFactura);

            // Llamar al controlador para eliminar
            control.eliminarFactura(factura);

            // Ventana emergente de confirmación
            JOptionPane.showMessageDialog(this,
                    "Factura eliminada exitosamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

            // Actualizar tabla
            CargarTabla();

        } catch (SQLException ex) {
            String mensajeError = ex.getMessage();
        }

    }
}
