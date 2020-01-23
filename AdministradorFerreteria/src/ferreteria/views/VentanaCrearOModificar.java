package ferreteria.views;

import ferrateria.control.ControlFerreteria;
import ferreteria.model.entidades.Producto;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

public class VentanaCrearOModificar extends javax.swing.JFrame implements Observer {

    private ControlFerreteria gestor;
    private Producto productoSinModificar;
    private Producto productoNuevo;
    private Boolean estaModificando;

    /**
     * Creates new form VentanaCrearOModificar
     */
    public VentanaCrearOModificar() {
        initComponents();
    }

    public VentanaCrearOModificar(ControlFerreteria gestor) {
        initComponents();
        this.gestor = gestor;
        productoNuevo = new Producto();
        lblID.setVisible(false);
        txfID.setVisible(false);
        estaModificando = false;
    }

    public VentanaCrearOModificar(ControlFerreteria gestor, Producto productoAModificar) {
        initComponents();
        this.gestor = gestor;
        productoSinModificar = new Producto(productoAModificar);
        if (productoSinModificar.getTipo().equals("Material")) {
            btnMaterial.setSelected(true);
            btnHerramienta.setEnabled(false);
        } else {
            btnHerramienta.setSelected(true);
            btnMaterial.setEnabled(false);
            cmbCapacidadTrabajo.setSelectedItem(productoSinModificar.getCapacidadTrabajo());
        }
        this.txfID.setText(String.valueOf(productoSinModificar.getId()));
        this.txfPrecio.setText(String.valueOf(productoSinModificar.getPrecio()));
        this.txfCantidad.setText(String.valueOf(productoSinModificar.getCantidad()));
        this.txfNombre.setText(productoSinModificar.getNombre());
        estaModificando = true;
        productoNuevo = productoSinModificar;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        lblID = new javax.swing.JLabel();
        txfNombre = new javax.swing.JTextField();
        lblNombre = new javax.swing.JLabel();
        txfID = new javax.swing.JTextField();
        lblPrecio = new javax.swing.JLabel();
        txfPrecio = new javax.swing.JTextField();
        lblCantidad = new javax.swing.JLabel();
        txfCantidad = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnHerramienta = new javax.swing.JRadioButton();
        btnMaterial = new javax.swing.JRadioButton();
        lblCapacidadDeTrabajo = new javax.swing.JLabel();
        cmbCapacidadTrabajo = new javax.swing.JComboBox<>();
        txfLongitud = new javax.swing.JTextField();
        lblLongitud = new javax.swing.JLabel();
        lblDescripcion = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txfDescripcion = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inventario - UNA");
        setPreferredSize(new java.awt.Dimension(600, 400));

        lblID.setText("ID:");

        txfNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfNombreActionPerformed(evt);
            }
        });

        lblNombre.setText("Nombre:");

        txfID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfIDActionPerformed(evt);
            }
        });

        lblPrecio.setText("Precio:");

        txfPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfPrecioActionPerformed(evt);
            }
        });

        lblCantidad.setText("Cantidad:");

        txfCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txfCantidadActionPerformed(evt);
            }
        });

        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnHerramienta);
        btnHerramienta.setSelected(true);
        btnHerramienta.setText("Herramienta");
        btnHerramienta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHerramientaActionPerformed(evt);
            }
        });

        buttonGroup1.add(btnMaterial);
        btnMaterial.setText("Material");
        btnMaterial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMaterialActionPerformed(evt);
            }
        });

        lblCapacidadDeTrabajo.setText("Capacidad de Trabajo:");

        cmbCapacidadTrabajo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblLongitud.setText("Longitud:");

        lblDescripcion.setText("Descripcion:");

        txfDescripcion.setColumns(20);
        txfDescripcion.setRows(5);
        jScrollPane1.setViewportView(txfDescripcion);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblLongitud)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txfLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblCapacidadDeTrabajo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbCapacidadTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblNombre)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblID)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txfID, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(139, 139, 139)
                            .addComponent(btnHerramienta)
                            .addGap(18, 18, 18)
                            .addComponent(btnMaterial))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(lblPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblDescripcion)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(lblCantidad)
                                    .addGap(18, 18, 18)
                                    .addComponent(txfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(43, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCancelar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnAceptar)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(13, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblID)
                    .addComponent(txfID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnHerramienta)
                    .addComponent(btnMaterial))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNombre)
                            .addComponent(txfNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(lblDescripcion)
                                .addGap(42, 42, 42))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPrecio)
                    .addComponent(txfPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCantidad)
                    .addComponent(txfCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbCapacidadTrabajo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCapacidadDeTrabajo))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLongitud)
                    .addComponent(txfLongitud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAceptar)
                    .addComponent(btnCancelar))
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txfNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfNombreActionPerformed

    private void txfIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfIDActionPerformed

    private void txfPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfPrecioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfPrecioActionPerformed

    private void txfCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txfCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txfCantidadActionPerformed

    private void btnMaterialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMaterialActionPerformed
        setTipoProducto();
    }//GEN-LAST:event_btnMaterialActionPerformed

    private void btnHerramientaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHerramientaActionPerformed
        setTipoProducto();
    }//GEN-LAST:event_btnHerramientaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        cerrarVentana();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        intentarGuardar();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void setTipoProducto() {
        if (btnHerramienta.isSelected()) {
            lblCapacidadDeTrabajo.setVisible(true);
            cmbCapacidadTrabajo.setVisible(true);
            lblLongitud.setVisible(false);
            txfLongitud.setVisible(false);
        } else {
            lblCapacidadDeTrabajo.setVisible(false);
            cmbCapacidadTrabajo.setVisible(false);
            lblLongitud.setVisible(true);
            txfLongitud.setVisible(true);
        }
    }

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
            java.util.logging.Logger.getLogger(VentanaCrearOModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaCrearOModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaCrearOModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaCrearOModificar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaCrearOModificar().setVisible(true);
            }
        });
    }

    void init() {
        gestor.registrar(this);
        configurar();
        setVisible(true);
    }

    private void configurar() {
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {

            @Override
            public void windowClosing(WindowEvent e) {
                cerrarVentana();
            }

        });
        setResizable(false);
        setLocationRelativeTo(null);
        setTipoProducto();
        txfID.setEditable(false);
        cmbCapacidadTrabajo.removeAllItems();
        cmbCapacidadTrabajo.addItem("Liviano");
        cmbCapacidadTrabajo.addItem("Mediano");
        cmbCapacidadTrabajo.addItem("Pesado");
    }

    private void cerrarVentana() {
        gestor.suprimir(this);
        dispose();
    }

    @Override
    public void update(Observable o, Object arg) {
    }

    private void intentarGuardar() {
        if (todoValido()) {
            try {
                productoNuevo.setCantidad(Integer.valueOf(txfCantidad.getText()));
                productoNuevo.setDescripcion(txfDescripcion.getText());
                productoNuevo.setNombre(txfNombre.getText().trim());
                productoNuevo.setPrecio(Double.valueOf(txfPrecio.getText().trim()));
                if (btnHerramienta.isSelected()) {
                    productoNuevo.setTipo("Herramienta");
                    productoNuevo.setCapacidadTrabajo((String) cmbCapacidadTrabajo.getSelectedItem());
                    productoNuevo.setLongitud(null);
                } else {
                    //es material
                    productoNuevo.setTipo("Material");
                    productoNuevo.setLongitud(Double.valueOf(txfLongitud.getText().trim()));
                    productoNuevo.setCapacidadTrabajo(null);
                }
                
                //todo se setio bien, intentar guardarNuevo o modificar
                if(estaModificando){
                    productoNuevo.setId(productoSinModificar.getId());
                    gestor.modificarEnInventario(productoNuevo);
                    cerrarVentana();
                }else{
                    gestor.agregarAInventario(productoNuevo);
                    cerrarVentana();
                }
                
            } catch (Exception e) {
                //algo paso, lo mas seguro es que no el usuario no digito descripcion, ya que todoValido() no revisa ese campo
                System.out.println("Error: "+e.getLocalizedMessage() + e.getMessage());
            }
            
        } else {
            JOptionPane.showMessageDialog(this, "Existen campos con errores.");
        }
    }

    private Boolean todoValido() {
        Boolean todoValido = true;
        try {
            if (Integer.valueOf(txfCantidad.getText()) < 0) {
                todoValido = false;
            }
            if (txfNombre.getText().trim().isEmpty()) {
                todoValido = false;
            }
            if (Double.valueOf(txfPrecio.getText()) < 0) {
                todoValido = false;
            }
            if (btnMaterial.isSelected()) {
                if (Integer.valueOf(txfLongitud.getText()) < 0) {
                    todoValido = false;
                }
            }
        } catch (Exception e) {
            todoValido = false;
        }
        return todoValido;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JRadioButton btnHerramienta;
    private javax.swing.JRadioButton btnMaterial;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cmbCapacidadTrabajo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCantidad;
    private javax.swing.JLabel lblCapacidadDeTrabajo;
    private javax.swing.JLabel lblDescripcion;
    private javax.swing.JLabel lblID;
    private javax.swing.JLabel lblLongitud;
    private javax.swing.JLabel lblNombre;
    private javax.swing.JLabel lblPrecio;
    private javax.swing.JTextField txfCantidad;
    private javax.swing.JTextArea txfDescripcion;
    private javax.swing.JTextField txfID;
    private javax.swing.JTextField txfLongitud;
    private javax.swing.JTextField txfNombre;
    private javax.swing.JTextField txfPrecio;
    // End of variables declaration//GEN-END:variables
}
