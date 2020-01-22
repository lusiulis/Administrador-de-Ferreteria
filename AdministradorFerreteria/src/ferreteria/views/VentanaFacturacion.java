/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ferreteria.views;

import ferrateria.control.ControlFerreteria;
import ferreteria.model.DAO.ProductoDAO;
import ferreteria.model.entidades.Detalle;
import ferreteria.model.entidades.Factura;
import ferreteria.model.entidades.Producto;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author Kevin
 */
public class VentanaFacturacion extends javax.swing.JFrame implements Observer {

    private ControlFerreteria gestor;
    private DefaultTableModel modeloTabla;

    public VentanaFacturacion(ControlFerreteria gestor) {
        this.gestor = gestor;
    }

    public void init() {
        gestor.registrar(this);
        initComponents();
        configurar();
        setVisible(true);
        gestor.solicitarFacturaActual();
    }

    private void configurar() {
        setResizable(false);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
            }

        });
        itemSalir.addActionListener((ActionEvent e) -> {
            cerrarVentana();
        });
        itemEditarInventario.addActionListener((ActionEvent e) -> {
            new VentanaInventario(gestor).init();
        });
        String[] nombreColumnas
                = {"Articulo",
                    "Cantidad",
                    "Precio Individual",
                    "Total"
                };

        modeloTabla = new DefaultTableModel(nombreColumnas, 0);
        tablaArticulos.setModel(modeloTabla);
    }

    private void cerrarVentana() {
        gestor.cerrarAplicacion();
    }

    /**
     * Creates new form VentanaFacturacion
     */
    public VentanaFacturacion() {
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

        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaArticulos = new javax.swing.JTable();
        btnVender = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnEliminar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();
        txfCodigoArticulo = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        txfCantidad = new javax.swing.JSpinner();
        lblCantidad = new javax.swing.JLabel();
        txfVendedor = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lblMensaje = new javax.swing.JLabel();
        Menu = new javax.swing.JMenuBar();
        MenuArchivo = new javax.swing.JMenu();
        itemSalir = new javax.swing.JMenuItem();
        MenuInventario = new javax.swing.JMenu();
        itemEditarInventario = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Facturacion - UNA");
        setLocationByPlatform(true);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(jSeparator1, java.awt.BorderLayout.PAGE_END);

        jPanel3.setPreferredSize(new java.awt.Dimension(0, 475));
        jPanel3.setRequestFocusEnabled(false);

        tablaArticulos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Articulo", "Cantidad", "Precio Individual", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaArticulos);
        if (tablaArticulos.getColumnModel().getColumnCount() > 0) {
            tablaArticulos.getColumnModel().getColumn(0).setResizable(false);
            tablaArticulos.getColumnModel().getColumn(1).setResizable(false);
            tablaArticulos.getColumnModel().getColumn(2).setResizable(false);
            tablaArticulos.getColumnModel().getColumn(3).setResizable(false);
        }

        btnVender.setText("Vender");
        btnVender.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVenderActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        txfCodigoArticulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCodigoArticuloActionPerformed(evt);
            }
        });

        lblCodigo.setText("Codigo:");

        lblTotal.setText("Total:");

        lblCantidad.setText("Cantidad:");

        txfVendedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfVendedorActionPerformed(evt);
            }
        });

        jLabel1.setText("Vendedor:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfCodigoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblCantidad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAgregar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 747, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnVender))
                    .addComponent(btnEliminar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTotal))
                .addContainerGap(42, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txfCodigoArticulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregar)
                    .addComponent(lblCodigo)
                    .addComponent(txfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidad)
                    .addComponent(txfVendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addGap(17, 17, 17)
                .addComponent(lblTotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 64, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVender)
                    .addComponent(btnCancelar)))
        );

        lblMensaje.setText("Promedio: ");

        MenuArchivo.setText("Archivo");

        itemSalir.setText("Salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        MenuArchivo.add(itemSalir);

        Menu.add(MenuArchivo);

        MenuInventario.setText("Inventario");

        itemEditarInventario.setText("Editar");
        itemEditarInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemEditarInventarioActionPerformed(evt);
            }
        });
        MenuInventario.add(itemEditarInventario);

        Menu.add(MenuInventario);

        setJMenuBar(Menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 904, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblMensaje))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 801, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblMensaje)
                .addGap(26, 26, 26))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemSalirActionPerformed

    private void itemEditarInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemEditarInventarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_itemEditarInventarioActionPerformed

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVenderActionPerformed
        try {
            gestor.vender(txfVendedor.getText());
        } catch (NullPointerException e) {
            gestor.vender(" ");
        }
    }//GEN-LAST:event_btnVenderActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        gestor.cancelarFactura();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        if (tablaArticulos.getSelectedRow() != -1) {
            gestor.eliminarArticuloDeFactura(tablaArticulos.getSelectedRow());
        }

    }//GEN-LAST:event_btnEliminarActionPerformed

    private void txfCodigoArticuloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCodigoArticuloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCodigoArticuloActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (camposValidos()) {
            gestor.agregarProductoAFactura(Integer.valueOf(txfCodigoArticulo.getText()), Integer.valueOf((Integer) txfCantidad.getValue()));
        } else {
            JOptionPane.showMessageDialog(null, "Existe un error con el campo de codigo o el campo de cantidad.");
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private Boolean camposValidos() {
        Boolean todoBien = true;
        //revisar que el campo de articulo este bien
        if (txfCodigoArticulo.getText() != null) {
            try {
                Integer.valueOf(txfCodigoArticulo.getText());
            } catch (NumberFormatException e) {
                todoBien = false;
            }
        }
        try {
            //revisar que el campo de cantidad este bien
            txfCantidad.commitEdit();
            if ((Integer) txfCantidad.getValue() <= 0) {
                todoBien = false;
            }
        } catch (ParseException ex) {
            todoBien = false;
        }

        return todoBien;
    }
    private void txfVendedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfVendedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfVendedorActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaFacturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaFacturacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar Menu;
    private javax.swing.JMenu MenuArchivo;
    private javax.swing.JMenu MenuInventario;
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnVender;
    private javax.swing.JMenuItem itemEditarInventario;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblMensaje;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JTable tablaArticulos;
    private javax.swing.JSpinner txfCantidad;
    private javax.swing.JTextField txfCodigoArticulo;
    private javax.swing.JTextField txfVendedor;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof Factura) {
            actualizoFactura((Factura) arg);
        }
    }

    private void actualizoFactura(Factura facturaNueva) {
        //actualizar montos
        lblTotal.setText("Total: " + String.valueOf(facturaNueva.getTotal()));

        //actualizar lista
        actualizarListaProductos(facturaNueva.getDetalles());
        
        //reset campos
        txfCantidad.setValue(1);
        txfCodigoArticulo.setText("");
    }

    private void actualizarListaProductos(List<Detalle> lista) {
        modeloTabla.setRowCount(0);
        for (Detalle d : lista) {
            Producto p = ProductoDAO.getInstancia().recuperarProducto(d.getIdProducto());
            Object[] datos = {p.getNombre(), d.getCantidad(), p.getPrecio(), p.getPrecio() * d.getCantidad()};
            modeloTabla.addRow(datos);
        }
    }

    
}
