/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pfcti.cbsutils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.Collator;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.prefs.BackingStoreException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
import java.util.prefs.Preferences;
import java.util.stream.Stream;
import javax.swing.JOptionPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultCaret;
import static javax.swing.text.DefaultCaret.ALWAYS_UPDATE;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 *
 * @author rodolfo.matamoros
 */
public class cbsUtils extends javax.swing.JFrame {

    public static Preferences prefs;

    public List<String> listaEsquemas = new ArrayList<String>();
    public List<String> listaCarpetas = new ArrayList<String>();
    public static String strTokenProyecto = "";
    public static String strValorProyecto = "";
    public static String strTokenCaso = "";
    public static String strValorCaso = "";
    public static String strTokenSolicitud = "";
    public static String strValorSolicitud = "";
    public static String strTokenCambio = "";
    public static String strValorCambio = "";
    public static String strTokenVersion = "";
    public static String strValorVersion = "";
    //
    public static String strPathOracleVersion;

    /**
     * Creates new form cbsUtil
     */
    public cbsUtils() {
        initComponents();
        prefs = Preferences.userNodeForPackage(this.getClass());
        try {
            nombreAnalista.setText(prefs.get("DeveloperName", ""));
            rutaRepositorio.setText(prefs.get("RepositoryName", ""));
            rutaSqlPlus.setText(prefs.get("RutaSQLPLUS", ""));
            strTokenProyecto = prefs.get("TokenProyecto", "");
            strValorProyecto = prefs.get("ValorProyecto", "");
            strTokenCaso = prefs.get("TokenCaso", "");
            strValorCaso = prefs.get("ValorCaso", "");
            strTokenSolicitud = prefs.get("TokenSolicitud", "");
            strValorSolicitud = prefs.get("ValorSolicitud", "");
            strTokenCambio = prefs.get("TokenCambio", "");
            strValorCambio = prefs.get("ValorCambio", "");
            strTokenVersion = prefs.get("TokenVersion", "");
            strValorVersion = prefs.get("ValorVersion", "");
            //
            prefs = Preferences.userNodeForPackage(this.getClass());
            tokenProyecto.setText(prefs.get("TokenProyecto", ""));
            valorProyecto.setText(prefs.get("ValorProyecto", ""));
            tokenCaso.setText(prefs.get("TokenCaso", ""));
            valorCaso.setText(prefs.get("ValorCaso", ""));
            tokenSolicitud.setText(prefs.get("TokenSolicitud", ""));
            valorSolicitud.setText(prefs.get("ValorSolicitud", ""));
            tokenCambio.setText(prefs.get("TokenCambio", ""));
            valorCambio.setText(prefs.get("ValorCambio", ""));
            tokenVersion.setText(prefs.get("TokenVersion", ""));
            valorVersion.setText(prefs.get("ValorVersion", ""));
            //
            jOracleVersionPath.setText(prefs.get(String.valueOf(jOracleVersionConfig.getSelectedItem()).toUpperCase() + "_GIT_PATH", ""));
            //
            jGuardarVersionCBS.setVisible(false);
        } catch (Exception ex) {
            prefs.put("DeveloperName", "");
            prefs.put("RepositoryName", "");
            prefs.put("RutaSQLPLUS", "");
            //
            prefs.get("TokenProyecto", "");
            prefs.get("ValorProyecto", "");
            prefs.get("TokenCaso", "");
            prefs.get("ValorCaso", "");
            prefs.get("TokenSolicitud", "");
            prefs.get("ValorSolicitud", "");
            prefs.get("TokenCambio", "");
            prefs.get("ValorCambio", "");
            prefs.get("TokenVersion", "");
            prefs.get("ValorVersion", "");
            //
            strTokenProyecto = "";
            strValorProyecto = "";
            strTokenCaso = "";
            strValorCaso = "";
            strTokenSolicitud = "";
            strValorSolicitud = "";
            strTokenCambio = "";
            strValorCambio = "";
            strTokenVersion = "";
            strValorVersion = "";
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabUtils = new javax.swing.JTabbedPane();
        jPanelEntregas = new javax.swing.JPanel();
        jOracleVersionEntrega = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        detalleAplicacionInstalacion = new javax.swing.JTextArea();
        jRutaCambio = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jNombreObjeto = new javax.swing.JTextField();
        jCheckAplicarBD = new javax.swing.JCheckBox();
        jButtonCompareVersions = new javax.swing.JButton();
        jPanelDevoluciones = new javax.swing.JPanel();
        oracleVersion = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        rutaCambio = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        devolverCmbio = new javax.swing.JButton();
        rutaRepositorio = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        nombreAnalista = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        aplicarCambio = new javax.swing.JButton();
        rutaSqlPlus = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        detalleAplicacion = new javax.swing.JTextArea();
        jPanelFolderConfig = new javax.swing.JPanel();
        tokenProyecto = new javax.swing.JTextField();
        valorProyecto = new javax.swing.JTextField();
        tokenCaso = new javax.swing.JTextField();
        valorCaso = new javax.swing.JTextField();
        tokenSolicitud = new javax.swing.JTextField();
        valorSolicitud = new javax.swing.JTextField();
        valorCambio = new javax.swing.JTextField();
        tokenCambio = new javax.swing.JTextField();
        tokenVersion = new javax.swing.JTextField();
        valorVersion = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        guardarConfiguracion = new javax.swing.JButton();
        jPanelGitConfig = new javax.swing.JPanel();
        jOracleVersionConfig = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jVersionCBS = new javax.swing.JTextField();
        jGuardarVersionCBS = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jOracleVersionPath = new javax.swing.JTextField();
        jUpdateOracleVersionPath = new javax.swing.JButton();
        jPathVersionCBS = new javax.swing.JTextField();
        jVersionesCBS = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabUtils.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jOracleVersionEntrega.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CBS6i", "CBSWL" }));

        jLabel16.setText("Versión Oracle:");

        detalleAplicacionInstalacion.setColumns(20);
        detalleAplicacionInstalacion.setRows(5);
        jScrollPane2.setViewportView(detalleAplicacionInstalacion);

        jLabel17.setText("Ruta del cambio:");

        jLabel18.setText("Objeto:");

        jNombreObjeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jNombreObjetoActionPerformed(evt);
            }
        });

        jCheckAplicarBD.setText("Aplicar en Base de Datos");

        jButtonCompareVersions.setText("Comparar Versiones");
        jButtonCompareVersions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCompareVersionsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEntregasLayout = new javax.swing.GroupLayout(jPanelEntregas);
        jPanelEntregas.setLayout(jPanelEntregasLayout);
        jPanelEntregasLayout.setHorizontalGroup(
            jPanelEntregasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEntregasLayout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addGroup(jPanelEntregasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonCompareVersions)
                    .addGroup(jPanelEntregasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanelEntregasLayout.createSequentialGroup()
                            .addComponent(jLabel18)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jNombreObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanelEntregasLayout.createSequentialGroup()
                            .addGroup(jPanelEntregasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanelEntregasLayout.createSequentialGroup()
                                    .addComponent(jLabel17)
                                    .addGap(0, 0, Short.MAX_VALUE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEntregasLayout.createSequentialGroup()
                                    .addGap(0, 0, Short.MAX_VALUE)
                                    .addComponent(jLabel16)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addGroup(jPanelEntregasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jRutaCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanelEntregasLayout.createSequentialGroup()
                                    .addComponent(jOracleVersionEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jCheckAplicarBD))))))
                .addGap(94, 94, 94))
        );
        jPanelEntregasLayout.setVerticalGroup(
            jPanelEntregasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEntregasLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanelEntregasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jOracleVersionEntrega, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(jCheckAplicarBD))
                .addGap(24, 24, 24)
                .addGroup(jPanelEntregasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jRutaCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelEntregasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jNombreObjeto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonCompareVersions)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        jTabUtils.addTab("Entregas", jPanelEntregas);

        oracleVersion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CBS6i", "CBSWL" }));

        jLabel1.setText("Versión Oracle:");

        jLabel2.setText("Ruta del cambio:");

        devolverCmbio.setText("Devolver");
        devolverCmbio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolverCmbioActionPerformed(evt);
            }
        });

        jLabel3.setText("Ruta Repositorio GIT:");

        jLabel4.setText("Analista:");

        aplicarCambio.setText("Aplicar");
        aplicarCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aplicarCambioActionPerformed(evt);
            }
        });

        jLabel5.setText("Ruta SqlPlus");

        detalleAplicacion.setColumns(20);
        detalleAplicacion.setRows(5);
        jScrollPane1.setViewportView(detalleAplicacion);

        javax.swing.GroupLayout jPanelDevolucionesLayout = new javax.swing.GroupLayout(jPanelDevoluciones);
        jPanelDevoluciones.setLayout(jPanelDevolucionesLayout);
        jPanelDevolucionesLayout.setHorizontalGroup(
            jPanelDevolucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDevolucionesLayout.createSequentialGroup()
                .addContainerGap(62, Short.MAX_VALUE)
                .addGroup(jPanelDevolucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanelDevolucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanelDevolucionesLayout.createSequentialGroup()
                            .addComponent(aplicarCambio)
                            .addGap(28, 28, 28)
                            .addComponent(devolverCmbio))
                        .addGroup(jPanelDevolucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelDevolucionesLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rutaSqlPlus, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelDevolucionesLayout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rutaCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelDevolucionesLayout.createSequentialGroup()
                                .addGroup(jPanelDevolucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4))
                                .addGap(55, 55, 55)
                                .addGroup(jPanelDevolucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(nombreAnalista, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(oracleVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rutaRepositorio, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 438, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addGap(54, 54, 54))
        );
        jPanelDevolucionesLayout.setVerticalGroup(
            jPanelDevolucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDevolucionesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDevolucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(oracleVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(21, 21, 21)
                .addGroup(jPanelDevolucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(nombreAnalista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelDevolucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rutaSqlPlus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanelDevolucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(rutaRepositorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanelDevolucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(rutaCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanelDevolucionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(devolverCmbio)
                    .addComponent(aplicarCambio))
                .addContainerGap())
        );

        jTabUtils.addTab("Devoluciones", jPanelDevoluciones);

        valorSolicitud.setToolTipText("");

        tokenCambio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tokenCambioActionPerformed(evt);
            }
        });

        jLabel7.setText("Nivel Proyecto:");

        jLabel8.setText("Token");

        jLabel9.setText("Valor");

        jLabel10.setText("Nivel Solicitud:");

        jLabel11.setText("Nivel Caso:");

        jLabel12.setText("Nivel Versión:");

        jLabel13.setText("Nivel Cambio:");

        guardarConfiguracion.setText("Guardar");
        guardarConfiguracion.setToolTipText("");
        guardarConfiguracion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarConfiguracionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFolderConfigLayout = new javax.swing.GroupLayout(jPanelFolderConfig);
        jPanelFolderConfig.setLayout(jPanelFolderConfigLayout);
        jPanelFolderConfigLayout.setHorizontalGroup(
            jPanelFolderConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFolderConfigLayout.createSequentialGroup()
                .addGroup(jPanelFolderConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFolderConfigLayout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanelFolderConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(jLabel13)
                            .addComponent(jLabel12))
                        .addGap(32, 32, 32)
                        .addGroup(jPanelFolderConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tokenProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tokenCaso, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tokenSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tokenCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tokenVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelFolderConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(valorCaso)
                            .addComponent(valorSolicitud)
                            .addComponent(valorCambio)
                            .addComponent(valorVersion)
                            .addComponent(valorProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelFolderConfigLayout.createSequentialGroup()
                        .addGap(295, 295, 295)
                        .addComponent(jLabel8)
                        .addGap(126, 126, 126)
                        .addComponent(jLabel9)))
                .addContainerGap(167, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFolderConfigLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(guardarConfiguracion)
                .addGap(99, 99, 99))
        );
        jPanelFolderConfigLayout.setVerticalGroup(
            jPanelFolderConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFolderConfigLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPanelFolderConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(0, 57, Short.MAX_VALUE)
                .addGroup(jPanelFolderConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(tokenProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorProyecto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelFolderConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tokenCaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorCaso, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanelFolderConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tokenSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addGap(18, 18, 18)
                .addGroup(jPanelFolderConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tokenCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGap(18, 18, 18)
                .addGroup(jPanelFolderConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tokenVersion, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(valorVersion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(68, 68, 68)
                .addComponent(guardarConfiguracion)
                .addGap(62, 62, 62))
        );

        jTabUtils.addTab("Configuracion Carpetas", jPanelFolderConfig);

        jOracleVersionConfig.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CBS6i", "CBSWL" }));
        jOracleVersionConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jOracleVersionConfigActionPerformed(evt);
            }
        });

        jLabel6.setText("Versión Oracle:");

        jLabel14.setText("Versión CBS:");

        jVersionCBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jVersionCBSActionPerformed(evt);
            }
        });

        jGuardarVersionCBS.setText("Agregar");
        jGuardarVersionCBS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jGuardarVersionCBSActionPerformed(evt);
            }
        });

        jLabel15.setText("Ruta Git:");

        jUpdateOracleVersionPath.setText("Actualizar");
        jUpdateOracleVersionPath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jUpdateOracleVersionPathActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelGitConfigLayout = new javax.swing.GroupLayout(jPanelGitConfig);
        jPanelGitConfig.setLayout(jPanelGitConfigLayout);
        jPanelGitConfigLayout.setHorizontalGroup(
            jPanelGitConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGitConfigLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanelGitConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel14)
                    .addComponent(jLabel15))
                .addGap(18, 18, 18)
                .addGroup(jPanelGitConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jOracleVersionConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelGitConfigLayout.createSequentialGroup()
                        .addGroup(jPanelGitConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jVersionCBS, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jOracleVersionPath, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPathVersionCBS, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelGitConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jUpdateOracleVersionPath)
                            .addComponent(jGuardarVersionCBS)))
                    .addComponent(jVersionesCBS, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanelGitConfigLayout.setVerticalGroup(
            jPanelGitConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGitConfigLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(jPanelGitConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jOracleVersionConfig, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(jPanelGitConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jOracleVersionPath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jUpdateOracleVersionPath))
                .addGap(33, 33, 33)
                .addGroup(jPanelGitConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jVersionesCBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(jVersionCBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addGroup(jPanelGitConfigLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jPathVersionCBS, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jGuardarVersionCBS))
                .addContainerGap(199, Short.MAX_VALUE))
        );

        jTabUtils.addTab("Configuracion Git", jPanelGitConfig);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addComponent(jTabUtils)
                .addGap(21, 21, 21))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabUtils)
                .addContainerGap())
        );

        jTabUtils.getAccessibleContext().setAccessibleName("jTabCbsUtils");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void devolverCmbioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolverCmbioActionPerformed
        try {
            // TODO add your handling code here:
            devolverCambio(rutaCambio.getText(), rutaRepositorio.getText());
        } catch (IOException ex) {
            Logger.getLogger(cbsUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_devolverCmbioActionPerformed

    private void aplicarCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aplicarCambioActionPerformed
        try {
            // TODO add your handling code here:
            if (validarConfiguracion()) {
                detalleAplicacion.setText("");
                aplicarCambio(rutaCambio.getText());

            } else {
                JOptionPane.showMessageDialog(null, "Inconveniente al validar la configuración de las carpetas.");
                tokenProyecto.grabFocus();
            }
        } catch (IOException ex) {
            Logger.getLogger(cbsUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(cbsUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadLocationException ex) {
            Logger.getLogger(cbsUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_aplicarCambioActionPerformed

    private void tokenCambioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tokenCambioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tokenCambioActionPerformed

    private void guardarConfiguracionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarConfiguracionActionPerformed
        /*try {
            // TODO add your handling code here:
            guardarConfiguracion();
        } catch (BackingStoreException ex) {
            Logger.getLogger(cbsUtilConfig.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }//GEN-LAST:event_guardarConfiguracionActionPerformed

    private void jUpdateOracleVersionPathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jUpdateOracleVersionPathActionPerformed
        // TODO add your handling code here:
        if (String.valueOf(jOracleVersionConfig.getSelectedItem()).equals("CBS6i")
                || String.valueOf(jOracleVersionConfig.getSelectedItem()).equals("CBSWL")) {
            prefs = Preferences.userNodeForPackage(this.getClass());
            prefs.put(String.valueOf(jOracleVersionConfig.getSelectedItem()).toUpperCase() + "_GIT_PATH", jOracleVersionPath.getText());
        }
    }//GEN-LAST:event_jUpdateOracleVersionPathActionPerformed

    private void jOracleVersionConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jOracleVersionConfigActionPerformed
        // TODO add your handling code here:
        prefs = Preferences.userNodeForPackage(this.getClass());
        System.out.println(String.valueOf(jOracleVersionConfig.getSelectedItem()));
        jOracleVersionPath.setText(prefs.get(String.valueOf(jOracleVersionConfig.getSelectedItem()).toUpperCase() + "_GIT_PATH", ""));
    }//GEN-LAST:event_jOracleVersionConfigActionPerformed

    private void jVersionCBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jVersionCBSActionPerformed
        // TODO add your handling code here:
        prefs = Preferences.userNodeForPackage(this.getClass());
        System.out.println(jVersionCBS.getText());
        Pattern patternVersion = Pattern.compile("^(CBS)([0-9]){2}([0-9]){2}");
        Matcher matcherVersion = patternVersion.matcher(jVersionCBS.getText());
        if (matcherVersion.find()) {
            jPathVersionCBS.setText(prefs.get(matcherVersion.group(0), ""));
            jPathVersionCBS.setEnabled(true);
            jGuardarVersionCBS.setVisible(true);
            if (jPathVersionCBS.getText().equals("")) {
                jGuardarVersionCBS.setText("Agregar");
            } else {
                jGuardarVersionCBS.setText("Modificar");
            }
        } else {
            jPathVersionCBS.setEnabled(false);
            JOptionPane.showMessageDialog(null, "El formato del nombre de la versión es incorrecto.");
        }
    }//GEN-LAST:event_jVersionCBSActionPerformed

    private void jGuardarVersionCBSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jGuardarVersionCBSActionPerformed
        // TODO add your handling code here:
        prefs = Preferences.userNodeForPackage(this.getClass());
        prefs.put(jVersionCBS.getText(), jPathVersionCBS.getText());
        jVersionCBS.setText("");
        jPathVersionCBS.setText("");
        jGuardarVersionCBS.setVisible(false);
    }//GEN-LAST:event_jGuardarVersionCBSActionPerformed

    private void jNombreObjetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jNombreObjetoActionPerformed
        try {
            // TODO add your handling code here:
            entregarCambio(jRutaCambio.getText(), jNombreObjeto.getText());
        } catch (IOException ex) {
            Logger.getLogger(cbsUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(cbsUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadLocationException ex) {
            Logger.getLogger(cbsUtils.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jNombreObjetoActionPerformed

    private void jButtonCompareVersionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCompareVersionsActionPerformed
        // TODO add your handling code here:
        java.util.Collections.sort(listaCarpetas, Collator.getInstance());
        //public List<String> listaCarpet = java.util.Collections.sort(listaCarpetas, Collator.getInstance());
        //public List<String> lista = new List<String>();
        System.out.println(listaCarpetas.size());
        //Integer i;
        for (int i = 0; i <= listaCarpetas.size() - 2; i++) {
            try {
                ProcessBuilder processBuilder = new ProcessBuilder("C:\\Program Files (x86)\\WinMerge\\WinMergeU.exe",
                        "\"" + listaCarpetas.get(0) + "\"", "\"" + listaCarpetas.get(i + 1) + "\"");
                //script_location = "-i" + list_files[i].getAbsolutePath();
                //  processBuilder = new ProcessBuilder("sqlplus", "-Udeep-Pdumbhead-Spc-de-deep\\sqlexpress-de_com",script_location);
                processBuilder.redirectErrorStream(true);
                Process process = processBuilder.start();
                BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
                String currentLine = null;
                try {
                    while ((currentLine = in.readLine()) != null) {
                        String s = currentLine.toUpperCase();
                        System.out.println(s);

                    }
                } catch (IOException ex) {
                    Logger.getLogger(cbsUtils.class.getName()).log(Level.SEVERE, null, ex);
                }
            } catch (IOException ex) {
                Logger.getLogger(cbsUtils.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }//GEN-LAST:event_jButtonCompareVersionsActionPerformed

    private void guardarConfiguracion() throws BackingStoreException {
        prefs = Preferences.userNodeForPackage(this.getClass());
        prefs.put("TokenProyecto", tokenProyecto.getText());
        prefs.put("ValorProyecto", valorProyecto.getText());
        prefs.put("TokenCaso", tokenCaso.getText());
        prefs.put("ValorCaso", valorCaso.getText());
        prefs.put("TokenSolicitud", tokenSolicitud.getText());
        prefs.put("ValorSolicitud", valorSolicitud.getText());
        prefs.put("TokenCambio", tokenCambio.getText());
        prefs.put("ValorCambio", valorCambio.getText());
        prefs.put("TokenVersion", tokenVersion.getText());
        prefs.put("ValorVersion", valorVersion.getText());
        prefs.sync();
        //
        strTokenProyecto = prefs.get("TokenProyecto", "");;
        strValorProyecto = prefs.get("ValorProyecto", "");
        strTokenCaso = prefs.get("TokenCaso", "");
        strValorCaso = prefs.get("ValorCaso", "");
        strTokenSolicitud = prefs.get("TokenSolicitud", "");
        strValorSolicitud = prefs.get("ValorSolicitud", "");
        strTokenCambio = prefs.get("TokenCambio", "");
        strValorCambio = prefs.get("ValorCambio", "");
        strTokenVersion = prefs.get("TokenVersion", "");
        strValorVersion = prefs.get("ValorVersion", "");
        //this.setVisible(false);
    }

    private Boolean validarConfiguracion() {
        if (tokenProyecto.equals("")
                || valorProyecto.equals("")
                || tokenCaso.equals("")
                || valorCaso.equals("")
                || tokenSolicitud.equals("")
                || valorSolicitud.equals("")
                || tokenCambio.equals("")
                || valorCambio.equals("")
                || tokenVersion.equals("")
                || valorVersion.equals("")) {
            JOptionPane.showMessageDialog(null, "Configuración incompleta");
            return false;
        } else {
            return true;
        }
    }

    public static void pack(String sourceDirPath, String zipFilePath) throws IOException {
        Path p = Files.createFile(Paths.get(zipFilePath));
        try (ZipOutputStream zs = new ZipOutputStream(Files.newOutputStream(p))) {
            Path pp = Paths.get(sourceDirPath);
            Files.walk(pp)
                    .filter(path -> !Files.isDirectory(path))
                    .forEach(path -> {
                        ZipEntry zipEntry = new ZipEntry(pp.relativize(path).toString());
                        try {
                            zs.putNextEntry(zipEntry);
                            Files.copy(path, zs);
                            zs.closeEntry();
                        } catch (IOException e) {
                            System.err.println(e);
                        }
                    });
        }
    }

    private static String fileToString(String path, Charset encoding)
            throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, "Cp1252");
    }

    private void agregarEsquema(String nombreEsquema) {
        Boolean existeEsquema = false;
        for (String element : listaEsquemas) {
            if (element.equals(nombreEsquema)) {
                existeEsquema = true;
            }
            //System.out.println(element);
        }
        if (!existeEsquema) {
            listaEsquemas.add(nombreEsquema);
        }
    }

    private File buscarArchivo(File file, String objectName) throws IOException {
        if (file.isDirectory()) {
            File[] arr = file.listFiles();
            for (File f : arr) {
                File found = buscarArchivo(f, objectName);
                if (found != null) {
                    return found;
                }
            }
        } else {
            if (file.getName().toUpperCase().startsWith(objectName.toUpperCase())) {
                return file;
            } else {
                System.out.println(file.getName());
            }
        }
        return null;
    }

    private void ejecutarBusqueda(String objectName, File rutaVersion, File rutaGit) throws SQLException, IOException, BadLocationException {
        File archivoEncontrado = buscarArchivo(rutaGit, objectName);
        //List<File> archivosEncontrados = new ArrayList<File>();
        if (archivoEncontrado != null) {
            detalleAplicacionInstalacion.append("Entregando Objeto: " + archivoEncontrado.getName().toUpperCase() + System.getProperty("line.separator"));
            detalleAplicacionInstalacion.append(System.getProperty("line.separator"));
            detalleAplicacionInstalacion.append(System.getProperty("line.separator"));
            File archivoNuevo = new File(rutaVersion.getAbsoluteFile() + "\\" + archivoEncontrado.getName().toUpperCase());
            FileUtils.copyFile(archivoEncontrado, archivoNuevo);
            String FileName = FilenameUtils.getBaseName(archivoEncontrado.getName().toUpperCase());
            String FileExtension = FilenameUtils.getExtension(archivoEncontrado.getName().toUpperCase());

            if (jCheckAplicarBD.isSelected()) {
                Pattern patternsSepVersion = Pattern.compile("^(CBS)([0-9]{2})([0-9]{2})");
                Matcher matcherSepVersion = patternsSepVersion.matcher(rutaVersion.getName());
                if (matcherSepVersion.matches()) {
                    String productName = matcherSepVersion.group(1);
                    String productVersion = matcherSepVersion.group(2);
                    String productRelease = matcherSepVersion.group(3);
                    instalarObjeto(productName, productVersion, productRelease, archivoEncontrado);
                } else {
                    JOptionPane.showMessageDialog(null, "No se ha definido la ruta para la versión: " + rutaVersion.getName());
                    jVersionCBS.grabFocus();
                    return;

                }
            }
            if (FileExtension.equals("OBE")) {
                ejecutarBusqueda(FileName + ".FMB", rutaVersion, rutaGit);
            }
            if (FileExtension.equals("PKB")) {
                ejecutarBusqueda(FileName + ".PKS", rutaVersion, rutaGit);
            }
        }
    }

    private void entregarCambio(String directorioCambio, String objectName) throws IOException, SQLException, BadLocationException {

        //
        File fCambio = new File(directorioCambio);
        File fCaso = null;
        File fProyecto = null;
        //
        listaCarpetas.clear();
        listaEsquemas.clear();
        //
        fCaso = fCambio.getParentFile();
        //
        detalleAplicacionInstalacion.setText("");
        //
        fProyecto = fCaso.getParentFile();
        Pattern patternProyecto = Pattern.compile(strTokenProyecto);
        Matcher matcherProyecto = patternProyecto.matcher(fProyecto.getName());
        if (!matcherProyecto.find()) {
            JOptionPane.showMessageDialog(null, "El nombre de la carpeta del proyecto es inválido. Patrón RegExp: " + tokenProyecto);
            return;
        }
        String sVersionCBS;
        File[] listaDirectorios = fCambio.listFiles(File::isDirectory);
        for (File subDirectorio : listaDirectorios) {
            System.out.println(subDirectorio.getName());
            File[] listaVersiones = subDirectorio.listFiles(File::isDirectory);
            for (File rutaVersion : listaVersiones) {
                System.out.println(rutaVersion.getName());
                Pattern patternVersion = Pattern.compile(strTokenVersion);
                Matcher matcherVersion = patternVersion.matcher(rutaVersion.getName());
                if (matcherVersion.matches()) {
                    sVersionCBS = matcherVersion.group(strValorVersion);
                    File directorioPadre = rutaVersion.getParentFile();
                    Pattern patternNumeroCambio = Pattern.compile(strTokenCambio);
                    Matcher matcherNumeroCambio = patternNumeroCambio.matcher(directorioPadre.getName());
                    if (!matcherNumeroCambio.matches()) {
                        JOptionPane.showMessageDialog(null, "El nombre de la carpeta del cambio es inválido. Patrón RegExp: " + strTokenCambio);
                        return;
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "El nombre de la carpeta de la versión es inválido. Patrón RegExp: " + strTokenVersion);
                    return;
                }
                listaCarpetas.add(rutaVersion.getAbsolutePath());
                prefs = Preferences.userNodeForPackage(this.getClass());

                String strRutaGit = prefs.get(String.valueOf(jOracleVersionEntrega.getSelectedItem()).toUpperCase() + "_GIT_PATH", "");
                String strRutaVersion = prefs.get(sVersionCBS, "");
                if (!strRutaVersion.equals("")) {
                    strRutaGit = strRutaGit + "\\" + prefs.get(sVersionCBS, "");
                    File fRutaGit = new File(strRutaGit);
                    //
                    ejecutarBusqueda(jNombreObjeto.getText(), rutaVersion, fRutaGit);
                    //
                    /*if (f.exists()) {
                        File archivoEncontrado = buscarArchivo(f, jNombreObjeto.getText());
                        //List<File> archivosEncontrados = new ArrayList<File>();
                        if (archivoEncontrado != null) {
                            detalleAplicacionInstalacion.append("Entregando Objeto: " + archivoEncontrado.getName().toUpperCase() + System.getProperty("line.separator"));
                            detalleAplicacionInstalacion.append(System.getProperty("line.separator"));
                            detalleAplicacionInstalacion.append(System.getProperty("line.separator"));
                            File archivoNuevo = new File(rutaVersion.getAbsoluteFile() + "\\" + archivoEncontrado.getName().toUpperCase());
                            FileUtils.copyFile(archivoEncontrado, archivoNuevo);
                            String FileName = FilenameUtils.getBaseName(archivoEncontrado.getName());
                            String FileExtension = FilenameUtils.getExtension(archivoEncontrado.getName());

                            if (jCheckAplicarBD.isSelected()) {
                                Pattern patternsSepVersion = Pattern.compile("^(CBS)([0-9]{2})([0-9]{2})");
                                Matcher matcherSepVersion = patternsSepVersion.matcher(rutaVersion.getName());
                                if (matcherSepVersion.matches()) {
                                    String productName = matcherSepVersion.group(1);
                                    String productVersion = matcherSepVersion.group(2);
                                    String productRelease = matcherSepVersion.group(3);
                                    instalarObjeto(productName, productVersion, productRelease, archivoEncontrado);
                                } else {
                                    JOptionPane.showMessageDialog(null, "No se ha definido la ruta para la versión: " + sVersionCBS);
                                    jVersionCBS.grabFocus();
                                    return;

                                }
                            }
                        }
                    }*/
                }
                compilarSchemaInstalacion(rutaVersion);
            }
        }
    }

    private void compilarSchema(String productName, String productVersion, String productRelease, File rutaCambio) throws IOException {
        String databaseVersion = productName + "D" + productVersion.replaceFirst("^0+(?!$)", "") + productRelease;
        //

        //
        for (String nombreEsquema : listaEsquemas) {
            String userName = nombreEsquema;
            String userPassword = userName.toLowerCase();
            //
            PrintWriter writer = new PrintWriter(rutaCambio + "\\" + nombreEsquema + "_COMPILE.SQL", "UTF-8");
            writer.println("BEGIN");
            writer.println("DBMS_UTILITY.COMPILE_SCHEMA('" + nombreEsquema + "', FALSE);");
            writer.println("END;");
            writer.println("/");
            writer.println("SELECT COUNT(1) DESCOMPILACIONES FROM ALL_OBJECTS O WHERE O.OWNER = '" + nombreEsquema + "' AND O.STATUS = 'INVALID';");
            writer.close();
//
            File scriptCompilar = new File(rutaCambio + "\\" + nombreEsquema + "_COMPILE.SQL");
            detalleAplicacion.append("Compilando Script: " + scriptCompilar.getName() + " Base de Datos: "
                    + databaseVersion + System.getProperty("line.separator"));
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "echo exit | " + "\"" + rutaSqlPlus.getText() + "\"" + " " + userName
                    + "/" + userPassword + "@" + databaseVersion + " " + "\"" + "@" + scriptCompilar.getAbsolutePath() + "\"" + " quit;");
            //script_location = "-i" + list_files[i].getAbsolutePath();
            //  processBuilder = new ProcessBuilder("sqlplus", "-Udeep-Pdumbhead-Spc-de-deep\\sqlexpress-de_com",script_location);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String currentLine = null;
            while ((currentLine = in.readLine()) != null) {
                String s = currentLine.toUpperCase();
                //Boolean startWithSQL = s.toUpperCase().startsWith("SQL");
                //Boolean startCopyright = s.toUpperCase().startsWith("COPYRIGHT");
                if (currentLine.toUpperCase().startsWith("SQL") == false
                        && currentLine.toUpperCase().startsWith("COPYRIGHT") == false
                        && currentLine.toUpperCase().startsWith("CONNECTED") == false
                        && currentLine.toUpperCase().startsWith("ORACLE") == false
                        && currentLine.toUpperCase().startsWith("ORACLE") == false
                        && currentLine.equals("") == false) {
                    System.out.println(" " + currentLine);
                    detalleAplicacion.append(currentLine + System.getProperty("line.separator"));

                }
            }
            detalleAplicacion.append(System.getProperty("line.separator"));
            detalleAplicacion.append(System.getProperty("line.separator"));
            scriptCompilar.delete();
        }
    }

    private void compilarSchemaInstalacion(File rutaVersion) throws IOException {
        String productName;
        String productVersion;
        String productRelease;
        Pattern patternsSepVersion = Pattern.compile("^(CBS)([0-9]{2})([0-9]{2})");
        Matcher matcherSepVersion = patternsSepVersion.matcher(rutaVersion.getName());
        if (matcherSepVersion.matches()) {
            productName = matcherSepVersion.group(1);
            productVersion = matcherSepVersion.group(2);
            productRelease = matcherSepVersion.group(3);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha definido la ruta para la versión: " + rutaVersion.getName());
            jVersionCBS.grabFocus();
            return;

        }
        String databaseVersion = productName + "D" + productVersion.replaceFirst("^0+(?!$)", "") + productRelease;
        //

        //
        for (String nombreEsquema : listaEsquemas) {
            String userName = nombreEsquema;
            String userPassword = userName.toLowerCase();
            //
            PrintWriter writer = new PrintWriter(rutaVersion.getAbsoluteFile() + "\\" + nombreEsquema + "_COMPILE.SQL", "UTF-8");
            writer.println("BEGIN");
            writer.println("DBMS_UTILITY.COMPILE_SCHEMA('" + nombreEsquema + "', FALSE);");
            writer.println("END;");
            writer.println("/");
            writer.println("SELECT COUNT(1) DESCOMPILACIONES FROM ALL_OBJECTS O WHERE O.OWNER = '" + nombreEsquema + "' AND O.STATUS = 'INVALID';");
            writer.close();
//
            File scriptCompilar = new File(rutaVersion.getAbsoluteFile() + "\\" + nombreEsquema + "_COMPILE.SQL");
            detalleAplicacionInstalacion.append("Compilando Script: " + scriptCompilar.getName() + " Base de Datos: "
                    + databaseVersion + System.getProperty("line.separator"));
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "echo exit | " + "\"" + rutaSqlPlus.getText() + "\"" + " " + userName
                    + "/" + userPassword + "@" + databaseVersion + " " + "\"" + "@" + scriptCompilar.getAbsolutePath() + "\"" + " quit;");
            //script_location = "-i" + list_files[i].getAbsolutePath();
            //  processBuilder = new ProcessBuilder("sqlplus", "-Udeep-Pdumbhead-Spc-de-deep\\sqlexpress-de_com",script_location);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String currentLine = null;
            while ((currentLine = in.readLine()) != null) {
                String s = currentLine.toUpperCase();
                //Boolean startWithSQL = s.toUpperCase().startsWith("SQL");
                //Boolean startCopyright = s.toUpperCase().startsWith("COPYRIGHT");
                if (currentLine.toUpperCase().startsWith("SQL") == false
                        && currentLine.toUpperCase().startsWith("COPYRIGHT") == false
                        && currentLine.toUpperCase().startsWith("CONNECTED") == false
                        && currentLine.toUpperCase().startsWith("ORACLE") == false
                        && currentLine.toUpperCase().startsWith("ORACLE") == false
                        && currentLine.equals("") == false) {
                    System.out.println(" " + currentLine);
                    detalleAplicacionInstalacion.append(currentLine + System.getProperty("line.separator"));

                }
            }
            detalleAplicacionInstalacion.append(System.getProperty("line.separator"));
            detalleAplicacionInstalacion.append(System.getProperty("line.separator"));
            scriptCompilar.delete();
        }
    }

    private void instalarObjeto(String productName, String productVersion, String productRelease, File scriptFile) throws SQLException, IOException, BadLocationException {
        String userName = null;
        String userPassword = null;
        String databaseVersion = productName + "D" + productVersion.replaceFirst("^0+(?!$)", "") + productRelease;
        String databaseScript = null;
        Boolean validScript = false;
        //

        //
        String fileExtension = FilenameUtils.getExtension(scriptFile.getName());
        if (fileExtension.toUpperCase().equals("SQL")) {
            userName = scriptFile.getName().substring(7, 9);
            userPassword = userName.toLowerCase();
            validScript = true;
        }
        if (fileExtension.toUpperCase().equals("PRC")
                || fileExtension.toUpperCase().equals("FNC")
                || fileExtension.toUpperCase().equals("PKB")
                || fileExtension.toUpperCase().equals("PKS")
                || fileExtension.toUpperCase().equals("VW")
                || fileExtension.toUpperCase().equals("TPS")
                || fileExtension.toUpperCase().equals("TYP")
                || fileExtension.toUpperCase().equals("TRG")) {
            userName = scriptFile.getName().substring(0, 2);
            userPassword = userName.toLowerCase();
            validScript = true;
            agregarEsquema(userName);
        }
        if (validScript) {
            String script_location = "@" + scriptFile.getAbsolutePath();
            //detalleAplicacion.append("Aplicando SCRIPT:  " + script_location + System.getProperty("line.separator"));
            detalleAplicacionInstalacion.append("Aplicando " + scriptFile.getName() + " en: " + databaseVersion + System.getProperty("line.separator"));
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "SET NLS_LANG=SPANISH_SPAIN.WE8MSWIN1252 && echo exit | "
                    + "\"" + rutaSqlPlus.getText() + "\"" + " " + userName
                    + "/" + userPassword + "@" + databaseVersion + " " + "\"" + script_location + "\"" + " quit;");
            //script_location = "-i" + list_files[i].getAbsolutePath();
            //  processBuilder = new ProcessBuilder("sqlplus", "-Udeep-Pdumbhead-Spc-de-deep\\sqlexpress-de_com",script_location);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String currentLine = null;
            while ((currentLine = in.readLine()) != null) {
                String s = currentLine.toUpperCase();
                //Boolean startWithSQL = s.toUpperCase().startsWith("SQL");
                //Boolean startCopyright = s.toUpperCase().startsWith("COPYRIGHT");
                if (currentLine.toUpperCase().startsWith("SQL") == false
                        && currentLine.toUpperCase().startsWith("COPYRIGHT") == false
                        && currentLine.toUpperCase().startsWith("CONNECTED") == false
                        && currentLine.toUpperCase().startsWith("ORACLE") == false
                        && currentLine.toUpperCase().startsWith("ORACLE") == false
                        && currentLine.equals("") == false) {
                    System.out.println(" " + currentLine);
                    detalleAplicacionInstalacion.append(currentLine + System.getProperty("line.separator"));

                    //DefaultCaret caret = (DefaultCaret) detalleAplicacion.getCaret();
                    //caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
                    detalleAplicacionInstalacion.update(detalleAplicacionInstalacion.getGraphics());
                    //detalleAplicacion.append(System.getProperty("line.separator"));
                    //detalleAplicacion.append(System.getProperty("line.separator"));
                }
            }
            detalleAplicacionInstalacion.append(System.getProperty("line.separator"));
            detalleAplicacionInstalacion.append(System.getProperty("line.separator"));
            detalleAplicacionInstalacion.setCaretPosition(detalleAplicacionInstalacion.getText().length());
            detalleAplicacionInstalacion.getCaret().setVisible(true);
            detalleAplicacionInstalacion.scrollRectToVisible(detalleAplicacionInstalacion.modelToView(detalleAplicacionInstalacion.getLineStartOffset(detalleAplicacionInstalacion.getLineCount() - 1)));
            detalleAplicacionInstalacion.update(detalleAplicacionInstalacion.getGraphics());
        }
    }

    private void aplicarDB(String productName, String productVersion, String productRelease, File scriptFile) throws SQLException, IOException, BadLocationException {
        String userName = null;
        String userPassword = null;
        String databaseVersion = productName + "D" + productVersion.replaceFirst("^0+(?!$)", "") + productRelease;
        String databaseScript = null;
        Boolean validScript = false;
        //

        //
        String fileExtension = FilenameUtils.getExtension(scriptFile.getName());
        if (fileExtension.toUpperCase().equals("SQL")) {
            userName = scriptFile.getName().substring(7, 9);
            userPassword = userName.toLowerCase();
            validScript = true;
        }
        if (fileExtension.toUpperCase().equals("PRC")
                || fileExtension.toUpperCase().equals("FNC")
                || fileExtension.toUpperCase().equals("PKB")
                || fileExtension.toUpperCase().equals("PKS")
                || fileExtension.toUpperCase().equals("VW")
                || fileExtension.toUpperCase().equals("TPS")
                || fileExtension.toUpperCase().equals("TYP")
                || fileExtension.toUpperCase().equals("TRG")) {
            userName = scriptFile.getName().substring(0, 2);
            userPassword = userName.toLowerCase();
            validScript = true;
            agregarEsquema(userName);
        }
        if (validScript) {
            String script_location = "@" + scriptFile.getAbsolutePath();
            //detalleAplicacion.append("Aplicando SCRIPT:  " + script_location + System.getProperty("line.separator"));
            detalleAplicacion.append("Aplicando " + scriptFile.getName() + " en: " + databaseVersion + System.getProperty("line.separator"));
            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", "SET NLS_LANG=SPANISH_SPAIN.WE8MSWIN1252 && echo exit | "
                    + "\"" + rutaSqlPlus.getText() + "\"" + " " + userName
                    + "/" + userPassword + "@" + databaseVersion + " " + "\"" + script_location + "\"" + " quit;");
            //script_location = "-i" + list_files[i].getAbsolutePath();
            //  processBuilder = new ProcessBuilder("sqlplus", "-Udeep-Pdumbhead-Spc-de-deep\\sqlexpress-de_com",script_location);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();
            BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String currentLine = null;
            while ((currentLine = in.readLine()) != null) {
                String s = currentLine.toUpperCase();
                //Boolean startWithSQL = s.toUpperCase().startsWith("SQL");
                //Boolean startCopyright = s.toUpperCase().startsWith("COPYRIGHT");
                if (currentLine.toUpperCase().startsWith("SQL") == false
                        && currentLine.toUpperCase().startsWith("COPYRIGHT") == false
                        && currentLine.toUpperCase().startsWith("CONNECTED") == false
                        && currentLine.toUpperCase().startsWith("ORACLE") == false
                        && currentLine.toUpperCase().startsWith("ORACLE") == false
                        && currentLine.equals("") == false) {
                    System.out.println(" " + currentLine);
                    detalleAplicacion.append(currentLine + System.getProperty("line.separator"));

                    //DefaultCaret caret = (DefaultCaret) detalleAplicacion.getCaret();
                    //caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
                    detalleAplicacion.update(detalleAplicacion.getGraphics());
                    //detalleAplicacion.append(System.getProperty("line.separator"));
                    //detalleAplicacion.append(System.getProperty("line.separator"));
                }
            }
            detalleAplicacion.append(System.getProperty("line.separator"));
            detalleAplicacion.append(System.getProperty("line.separator"));
            detalleAplicacion.setCaretPosition(detalleAplicacion.getText().length());
            detalleAplicacion.getCaret().setVisible(true);
            detalleAplicacion.scrollRectToVisible(detalleAplicacion.modelToView(detalleAplicacion.getLineStartOffset(detalleAplicacion.getLineCount() - 1)));
            detalleAplicacion.update(detalleAplicacion.getGraphics());
        }
    }

    private void aplicarCambio(String directorioCambio) throws IOException, SQLException, BadLocationException {
        prefs = Preferences.userNodeForPackage(this.getClass());
        prefs.put("DeveloperName", nombreAnalista.getText());
        prefs.put("RepositoryName", rutaRepositorio.getText());
        prefs.put("RutaSQLPLUS", rutaSqlPlus.getText());

        File fCambio = new File(directorioCambio);
        //
        //StringTokenizer tokenizer = new StringTokenizer(numeroProyecto, "-");
        //String tipoProyecto = tokenizer.toke
        //
        File[] listaDirectorios = fCambio.listFiles(File::isDirectory);
        for (File subDirectorio : listaDirectorios) {
            System.out.println(subDirectorio.getName());
            File[] listaVersiones = subDirectorio.listFiles(File::isDirectory);
            for (File rutaVersion : listaVersiones) {
                System.out.println(rutaVersion.getName());
                Pattern pattern = Pattern.compile("(CBS)([0-9]{2})([0-9]{2})");
                Matcher matcher = pattern.matcher(rutaVersion.getName());

                if (matcher.matches()) {
                    String nombreProducto = matcher.group(1);
                    String numeroVersion = matcher.group(2);
                    String numeroRelease = matcher.group(3);
                    //
                    File dirPrev = new File(rutaVersion.getAbsoluteFile() + "\\PREV");
                    if (dirPrev.exists()) {
                        File[] objetosPrev = dirPrev.listFiles();
                        for (File file : objetosPrev) {
                            aplicarDB(nombreProducto, numeroVersion, numeroRelease, file);
                        }
                    }
                    File[] objetosCambio = rutaVersion.listFiles();
                    for (File file : objetosCambio) {
                        aplicarDB(nombreProducto, numeroVersion, numeroRelease, file);
                    }
                    File dirPost = new File(rutaVersion.getAbsoluteFile() + "\\POST");
                    if (dirPost.exists()) {
                        File[] objetosPost = dirPost.listFiles();
                        for (File file : objetosPost) {
                            aplicarDB(nombreProducto, numeroVersion, numeroRelease, file);
                        }
                    }
                    //compile
                    compilarSchema(nombreProducto, numeroVersion, numeroRelease, subDirectorio);
                }

            }

        }
    }

    private void devolverCambio(String directorioCambio, String repositorioGit) throws IOException {

        prefs = Preferences.userNodeForPackage(this.getClass());
        prefs.put("DeveloperName", nombreAnalista.getText());
        prefs.put("RepositoryName", rutaRepositorio.getText());
        prefs.put("RutaSQLPLUS", rutaSqlPlus.getText());
        //
        listaEsquemas.clear();
        //
        File fCambio = new File(directorioCambio);
        File fCaso = null;
        File fProyecto = null;
        String numeroCaso;
        String numeroProyecto;
        SimpleDateFormat fechaCambio = new SimpleDateFormat("yyyy.MM.dd");
        String nombreAnalista = "rodolfo.matamoros";
        //
        fCaso = fCambio.getParentFile();
        numeroCaso = fCaso.getName();
        //

        fProyecto = fCaso.getParentFile();
        Pattern patternProyecto = Pattern.compile(strTokenProyecto);
        Matcher matcherProyecto = patternProyecto.matcher(fProyecto.getName());
        if (matcherProyecto.find()) {
            numeroProyecto = matcherProyecto.group(strValorProyecto);

        } else {
            JOptionPane.showMessageDialog(null, "El nombre de la carpeta del proyecto es inválido. Carpeta: " + fProyecto.getName() + " Patrón RegExp: " + tokenProyecto);
            return;
        }
        //numeroProyecto = fProyecto.getName();
        //StringTokenizer tokenizer = new StringTokenizer(numeroProyecto, "-");
        //String tipoProyecto = tokenizer.toke
        Pattern patternSepararProyecto = Pattern.compile("^(?<PROYECTO>[A-Z]{1,3})(-)(?<PAIS>[A-Z]{1,4})(-)(?<TIPO>[A-Z]{1,3})(?<NUMERO>[0-9]{1,3})");
        Matcher matcherSepararProyecto = patternSepararProyecto.matcher(numeroProyecto);
        /*Pattern patternSepararProyecto = Pattern.compile("^(?<PROYECTO>[A-Z]{1,3})(-)(?<PAIS>[A-Z]{1,4})(-)(?<TIPO>[A-Z]{1,3})(?<NUMERO>[0-9]{1,3})");
        Matcher matcherSepararProyecto = patternProyecto.matcher(numeroProyecto);*/
        if (matcherSepararProyecto.find()) {
            String carpetaDevolucion = "Caso-" + numeroCaso + "_" + matcherSepararProyecto.group("TIPO") + "-" + matcherSepararProyecto.group("NUMERO");
            FileUtils.deleteDirectory(new File(directorioCambio + "\\" + carpetaDevolucion));
            new File(directorioCambio + "\\" + carpetaDevolucion).mkdirs();
            File[] listaDirectorios = fCambio.listFiles(File::isDirectory);
            for (File subDirectorio : listaDirectorios) {
                System.out.println(subDirectorio.getName());
                if (!subDirectorio.getName().equals(carpetaDevolucion)) {
                    File[] listaVersiones = subDirectorio.listFiles(File::isDirectory);
                    for (File rutaVersion : listaVersiones) {
                        System.out.println(rutaVersion.getName());
                        Pattern pattern = Pattern.compile("(CBS)([0-9]{2})([0-9]{2})");
                        Matcher matcher = pattern.matcher(rutaVersion.getName());
                        if (matcher.matches()) {
                            File directorioPadre = rutaVersion.getParentFile();
                            Pattern patternNumeroCambio = Pattern.compile(strTokenCambio);
                            Matcher matcherNumeroCambio = patternNumeroCambio.matcher(directorioPadre.getName());
                            if (matcherNumeroCambio.matches()) {
                                String numeroCambio = matcherNumeroCambio.group(strValorCambio);
                                String zipName = "Devoluciones-" + oracleVersion.getSelectedItem().toString() + "-"
                                        + numeroCambio + "-"
                                        + fechaCambio.format(new Date()) + "-" + nombreAnalista + ".zip";

                                pack(directorioPadre.getAbsolutePath(), directorioCambio + "\\" + carpetaDevolucion + "\\" + zipName);
                            } else {
                                JOptionPane.showMessageDialog(null, "El nombre de la carpeta del cambio es inválido. Patrón RegExp: " + strTokenCambio);
                                return;
                            }

                        } else {
                            JOptionPane.showMessageDialog(null, "El nombre de la carpeta de la versión es inválido. Carpeta: " + 
                                    rutaVersion.getName() + ". Patrón RegExp: " + strTokenVersion);
                            //return;
                        }
                    }
                }
            }
            File fDevolucion = new File(directorioCambio + "\\" + carpetaDevolucion);
            new File(repositorioGit + "\\" + carpetaDevolucion).mkdirs();
            File fRepositorio = new File(repositorioGit + "\\" + carpetaDevolucion);
            FileUtils.copyDirectory(fDevolucion, fRepositorio);
        } else {
            JOptionPane.showMessageDialog(null, "Inconveniente al separar el nombre del proyecto: " + tokenProyecto);
            return;
        }
        //String[] separarProyecto = numeroProyecto.split("-");
        //String tipoProyecto = separarProyecto[2];
        //System.out.println(tipoProyecto.substring(0, 3));
        //System.out.println(tipoProyecto.substring(3, 6));
        //String carpetaDevolucion = "Caso-" + numeroCaso + "_" + tipoProyecto.substring(0, 3) + "-" + tipoProyecto.substring(3, 6);
        //

        //
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
 /*
        
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(cbsUtils.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cbsUtils.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cbsUtils.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cbsUtils.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new cbsUtils().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aplicarCambio;
    private javax.swing.JTextArea detalleAplicacion;
    private javax.swing.JTextArea detalleAplicacionInstalacion;
    private javax.swing.JButton devolverCmbio;
    private javax.swing.JButton guardarConfiguracion;
    private javax.swing.JButton jButtonCompareVersions;
    private javax.swing.JCheckBox jCheckAplicarBD;
    private javax.swing.JButton jGuardarVersionCBS;
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jNombreObjeto;
    private javax.swing.JComboBox<String> jOracleVersionConfig;
    private javax.swing.JComboBox<String> jOracleVersionEntrega;
    private javax.swing.JTextField jOracleVersionPath;
    private javax.swing.JPanel jPanelDevoluciones;
    private javax.swing.JPanel jPanelEntregas;
    private javax.swing.JPanel jPanelFolderConfig;
    private javax.swing.JPanel jPanelGitConfig;
    private javax.swing.JTextField jPathVersionCBS;
    private javax.swing.JTextField jRutaCambio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabUtils;
    private javax.swing.JButton jUpdateOracleVersionPath;
    private javax.swing.JTextField jVersionCBS;
    private javax.swing.JComboBox<String> jVersionesCBS;
    private javax.swing.JTextField nombreAnalista;
    private javax.swing.JComboBox<String> oracleVersion;
    private javax.swing.JTextField rutaCambio;
    private javax.swing.JTextField rutaRepositorio;
    private javax.swing.JTextField rutaSqlPlus;
    private javax.swing.JTextField tokenCambio;
    private javax.swing.JTextField tokenCaso;
    private javax.swing.JTextField tokenProyecto;
    private javax.swing.JTextField tokenSolicitud;
    private javax.swing.JTextField tokenVersion;
    private javax.swing.JTextField valorCambio;
    private javax.swing.JTextField valorCaso;
    private javax.swing.JTextField valorProyecto;
    private javax.swing.JTextField valorSolicitud;
    private javax.swing.JTextField valorVersion;
    // End of variables declaration//GEN-END:variables
}
