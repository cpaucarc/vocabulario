package Ventanas;

import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class Ventana extends javax.swing.JFrame {

    int cantidadVocabulario = 1; //Hasta un maximo de 5
    String[] palabrasReservadas = new String[]{"abstract", "assert", "boolean", "break", "byte", "case", "catch", "char", "class", "const", "continue", "default", "do", "double", "else", "enum", "extends", "final", "finally", "float", "for", "goto", "if", "implements", "import", "instanceof", "int", "interface", "long", "native", "new", "package", "private", "protected", "public", "return", "short", "static", "strictfp", "super", "switch", "synchronized", "this", "throw", "throws", "transient", "try", "void", "volatile", "while"};
    ArrayList<ArrayList<String>> vocabularios = new ArrayList<>();
    ArrayList<String> auxiliar = new ArrayList<>();
    JLabel label;

    public Ventana() {
        initComponents();
        mostrarCantidadVocabulario();
    }

    public void mostrarCantidadVocabulario() {
        lbCantidadVocabulario.setText("Vocabulario Actual: N° " + cantidadVocabulario);
    }

    public boolean buscarEnPalabrasReservadas(String elemento) {
        for (String palabrasReservada : palabrasReservadas) {
            if (elemento.equals(palabrasReservada)) {
                return true;
            }
        }
        return false;
    }

    public void agregarAVocabulario(ArrayList<String> vocabulario, String elemento) {
        if (vocabulario.size() <= 8) {
            if (elemento.length() == 1 || buscarEnPalabrasReservadas(elemento)) {
                if (!vocabulario.contains(elemento)) {
                    vocabulario.add(elemento);
                    campo.setText(null);
                    campo.grabFocus();
                } else {
                    JOptionPane.showMessageDialog(null, "Este elemento '" + elemento + "' ya existe en el vocabulario");
                    campo.select(0, campo.getText().length()-1);
                }
            } else {
                JOptionPane.showMessageDialog(null, "La palabra '" + elemento + "' no es un simbolo.");
                campo.select(0, campo.getText().length());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Solo puede ingresar 8 elementos al vocabulario");
        }
    }

    public void mostrarContenidoVocabulario(ArrayList<ArrayList<String>> vocabularios) {
        int cantidad = vocabularios.size();
        if (cantidad == 0) {
            jTextArea1.setText("V1 = " + obtenerElementosJuntos(auxiliar));
        } else {
            jTextArea1.setText(null);
            String texto = "";
            for (int i = 0; i < cantidad; i++) {
                texto += "V" + (i + 1) + " = " + obtenerElementosJuntos(vocabularios.get(i)) + "\n";
            }
            if(auxiliar.size()>0){
                texto += "V"+cantidadVocabulario+" = "+obtenerElementosJuntos(auxiliar);
            }else{
                texto += "V"+cantidadVocabulario+" = {}";
            }
            jTextArea1.setText(texto);
        }
    }

    public void agregarElementos(String elemento) {
        agregarAVocabulario(auxiliar, elemento);
    }

    public void crearNuevoVocabulario() {
        if(!auxiliar.isEmpty()){
            cantidadVocabulario++;
            ArrayList<String> vocabulario = new ArrayList<>(auxiliar);
            vocabularios.add(vocabulario);
            auxiliar.clear();
            campo.setText(null);
            campo.grabFocus();
            mostrarContenidoVocabulario(vocabularios);
        }else{
            JOptionPane.showMessageDialog(null, "El vocabulario "+cantidadVocabulario+" no puede estar vacio");
        }
    }

    public String obtenerElementosJuntos(ArrayList<String> vocabulario) {
        String elementos = "{";
        for (String elemento : vocabulario) {
            elementos += elemento + ", ";
        }
        return elementos.substring(0, elementos.length() - 2) + "}";
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        campo = new javax.swing.JTextField();
        agregar = new javax.swing.JButton();
        nuevo = new javax.swing.JButton();
        lbCantidadVocabulario = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 400));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel1.setText("Elemento");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 100, -1, 20));

        campo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jPanel1.add(campo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 300, 30));

        agregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        agregar.setText("Agregar");
        agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                agregarActionPerformed(evt);
            }
        });
        jPanel1.add(agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 120, 100, 30));

        nuevo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        nuevo.setText("Nuevo Alfabeto");
        nuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nuevoActionPerformed(evt);
            }
        });
        jPanel1.add(nuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 130, 30));

        lbCantidadVocabulario.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbCantidadVocabulario.setText("jLabel2");
        jPanel1.add(lbCantidadVocabulario, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 310, 30));

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTextArea1.setRows(5);
        jTextArea1.setText("V1 = {}");
        jTextArea1.setWrapStyleWord(true);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 490, 160));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nuevoActionPerformed
        if (cantidadVocabulario < 5) {
            crearNuevoVocabulario();
        } else {
            JOptionPane.showMessageDialog(null, "Solo se puede crear hasta un maximo de 5 vocabularios.");
        }
        mostrarCantidadVocabulario();
    }//GEN-LAST:event_nuevoActionPerformed

    private void agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_agregarActionPerformed
        if (campo.getText().length() != 0) {
            agregarElementos(campo.getText());
            if (auxiliar.size() > 0 || vocabularios.size() > 0) {
                mostrarContenidoVocabulario(vocabularios);
            }
        }
    }//GEN-LAST:event_agregarActionPerformed

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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Ventana().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton agregar;
    private javax.swing.JTextField campo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel lbCantidadVocabulario;
    private javax.swing.JButton nuevo;
    // End of variables declaration//GEN-END:variables
}
