package View;
import Controller.MaquinariaController;
import Model.Marca;
import javax.swing.JOptionPane;
import java.util.List;

public class RegistrarMaquinaria extends javax.swing.JFrame {

    public RegistrarMaquinaria() {
        initComponents();
        cargarMarcas();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jButton1.setText("Registrar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextField1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jTextField2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel1.setText("Nombre:");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel2.setText("Modelo:");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        jLabel3.setText("Marca:");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(136, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 68, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                    .addComponent(jTextField2)
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(228, 228, 228))
            .addGroup(layout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(64, 64, 64)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(jButton1)
                .addContainerGap(133, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void cargarMarcas() {
    // Obtener todas las marcas desde el controlador
    List<Marca> marcas = new MaquinariaController().obtenerMarcas();
    // Limpiar el ComboBox
    jComboBox1.removeAllItems();
    // Llenar el ComboBox con los nombres de las marcas
    for (Marca marca : marcas) {
        // Agregar solo el nombre de la marca como String al ComboBox
        jComboBox1.addItem(marca.getNombre());  // Asumiendo que 'getNombre()' devuelve el nombre de la marca
    }
    // Ahora, guarda las marcas de alguna manera para poder accederlas más tarde
    // Asegúrate de que el ComboBox tiene la lista de las marcas para hacer el mapeo
    jComboBox1.setActionCommand("Marca");  // Opcional, para asegurar que se puede hacer referencia
}
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    // Obtener los valores de los campos de texto
    String nombre = jTextField1.getText();
    String modelo = jTextField2.getText();

    // Obtener el nombre de la marca seleccionada
    String nombreMarcaSeleccionada = (String) jComboBox1.getSelectedItem();

    // Buscar el objeto Marca que corresponda al nombre seleccionado
    Marca marcaSeleccionada = null;
    List<Marca> marcas = new MaquinariaController().obtenerMarcas();  // Asumiendo que tienes acceso a la lista de marcas
    for (Marca marca : marcas) {
        if (marca.getNombre().equals(nombreMarcaSeleccionada)) {
            marcaSeleccionada = marca;
            break;
        }
    }
    // Asegúrate de que se haya encontrado una marca
    if (marcaSeleccionada != null) {
        // Obtener el idmarca de la marca seleccionada
        int idmarca = marcaSeleccionada.getIdmarca();

        // Crear un controlador para insertar la maquinaria
        MaquinariaController controlador = new MaquinariaController();

        // Llamar al controlador para insertar la maquinaria con idMarca
        boolean exito = controlador.insertarSuministro(nombre, modelo, idmarca);

        if (exito) {
            JOptionPane.showMessageDialog(this, "Maquinaria insertada exitosamente.");
        } else {
            JOptionPane.showMessageDialog(this, "Hubo un error al insertar la maquinaria.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(this, "No se ha seleccionado una marca válida.", "Error", JOptionPane.ERROR_MESSAGE);
    }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(RegistrarMaquinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegistrarMaquinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegistrarMaquinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegistrarMaquinaria.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegistrarMaquinaria().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
