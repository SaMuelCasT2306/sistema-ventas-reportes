package com.poo.edu.utp.ingenieria.sistemaventas.ui;

import com.poo.edu.utp.ingenieria.sistemaventas.controladores.Controlador;
import com.poo.edu.utp.ingenieria.sistemaventas.modelos.Cliente;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

public class PantallaClientes extends javax.swing.JFrame {

    Controlador control = null;

    public PantallaClientes() {
        control = new Controlador();
        initComponents();
        MenuContextual();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(39, 39, 39));

        jLabel1.setFont(new java.awt.Font("Yu Gothic Light", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("REPORTE CLIENTES");

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

        jButton2.setForeground(new java.awt.Color(102, 102, 102));
        jButton2.setText("Salir");
        jButton2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setForeground(new java.awt.Color(102, 102, 102));
        jButton1.setText("Agregar cliente");
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 686, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 369, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 76, Short.MAX_VALUE))))
                .addContainerGap(34, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(33, 33, 33)
                    .addComponent(jSeparator1)
                    .addGap(34, 34, 34)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 30, Short.MAX_VALUE)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(49, 49, 49)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(477, Short.MAX_VALUE)))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        PantallaCrearCliente pcc = new PantallaCrearCliente();
        pcc.setVisible(true);
        pcc.setLocationRelativeTo(null);
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
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables

    private void CargarTabla() throws SQLException {
        // Definir modelo de la tabla
        DefaultTableModel modeloTabla = new DefaultTableModel() {

            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }

        };

        //Cabeceras de la tabla
        String cabeceras[] = {"Id", "RUC", "Nombre", "Direccion"};
        modeloTabla.setColumnIdentifiers(cabeceras);

        List<Cliente> listaClientes = control.cargarTablaClientes();
        if (listaClientes != null) {

            for (Cliente c : listaClientes) {

                Object itemsTabla[] = {c.getId(), c.getRuc(), c.getNombre(), c.getDireccion()};
                modeloTabla.addRow(itemsTabla);

            }
            jTable1.setModel(modeloTabla);
            jLabel3.setText("Cantidad de clientes: " + listaClientes.size());

        }
    }

    private void MenuContextual() {

        JPopupMenu menuContextual = new JPopupMenu();
        // Crear las opciones del menú
        JMenuItem itemEditar = new JMenuItem("Actualizar Cliente");
        JMenuItem itemEliminar = new JMenuItem("Eliminar Cliente");
        // Asignar acciones a cada opción
        itemEditar.addActionListener(e -> editarCliente());
        itemEliminar.addActionListener(e -> eliminarCliente());
        // Agregar las opciones al menú
        menuContextual.add(itemEditar);
        menuContextual.addSeparator(); // Línea separadora
        menuContextual.add(itemEliminar);
        // Asociar el menú contextual a la tabla
        jTable1.setComponentPopupMenu(menuContextual);
    }

    private void editarCliente() {
        int filaSeleccionada = jTable1.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, seleccione un cliente primero",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            // Obtener datos de la fila seleccionada
            int id = (int) jTable1.getValueAt(filaSeleccionada, 0);
            long ruc = (long) jTable1.getValueAt(filaSeleccionada, 1);
            String nombre = (String) jTable1.getValueAt(filaSeleccionada, 2);
            String direccion = (String) jTable1.getValueAt(filaSeleccionada, 3);
            // Crear objeto con los datos
            Cliente cliente = new Cliente();
            cliente.setId(id);
            cliente.setRuc(ruc);
            cliente.setNombre(nombre);
            cliente.setDireccion(direccion);
            // Abrir ventana de edición
            PantallaEditarCliente ventanaEditar = new PantallaEditarCliente(cliente);
            ventanaEditar.setVisible(true);
            ventanaEditar.setLocationRelativeTo(null);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void eliminarCliente() {
        int filaSeleccionada = jTable1.getSelectedRow();

        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this,
                    "Por favor, seleccione un cliente primero",
                    "Advertencia",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Confirmación antes de eliminar
        int confirmacion = JOptionPane.showConfirmDialog(this,
                "¿Está seguro de eliminar este cliente?",
                "Confirmar eliminación",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);

        if (confirmacion != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            // Obtener datos de la fila seleccionada
            int id = (int) jTable1.getValueAt(filaSeleccionada, 0);
            long ruc = (long) jTable1.getValueAt(filaSeleccionada, 1);
            String nombre = (String) jTable1.getValueAt(filaSeleccionada, 2);
            String direccion = (String) jTable1.getValueAt(filaSeleccionada, 3);
            // Crear objeto con los datos
            Cliente cliente = new Cliente();
            cliente.setId(id);
            cliente.setRuc(ruc);
            cliente.setNombre(nombre);
            cliente.setDireccion(direccion);
            // Llamar al controlador
            control.eliminarCliente(cliente);
            //Ventana emergente de confirmación
            JOptionPane.showMessageDialog(this,
                    "Cliente eliminado exitosamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception ex) {
            // Verificar si es un error de llave foránea
            if (ex.getMessage().contains("FK_")
                    || ex.getMessage().contains("foreign key")) {

                JOptionPane.showMessageDialog(this,
                        "No se puede eliminar este cliente porque tiene ventas o registros asociados.\n"
                        + "Por favor, elimine primero los registros relacionados.",
                        "Error: Cliente en uso",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this,
                        "Error al eliminar el cliente: " + ex.getMessage(),
                        "Error de base de datos",
                        JOptionPane.ERROR_MESSAGE);
            }
            ex.printStackTrace();

        }
    }
}
