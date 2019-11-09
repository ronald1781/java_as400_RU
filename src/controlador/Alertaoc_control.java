package controlador;

import configura.AlertaocProceJob;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import modelo.Alertaoc;
import modelo.Alertaoc_model;
import org.quartz.SchedulerException;
import vista.Alertaoc_view;

public class Alertaoc_control implements ActionListener {

    int proc = 0;
    AlertaocProceJob pjob = new AlertaocProceJob();
    Alertaoc_model mdl = new Alertaoc_model();
    Alertaoc a = new Alertaoc();
    Alertaoc_view vista = new Alertaoc_view();
    DefaultTableModel modelo = new DefaultTableModel();
    Clip clip;
    String ruta = "/sonido/";
    String file = "gorrion2";
    Date date = new Date();
    DateFormat hourFormat = new SimpleDateFormat("HH:mm:ss");
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    DateFormat hourdateFormat = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
    String usuarioin;
    String hora = hourFormat.format(date);
    String h = hora.substring(0, 2);
    String m = hora.substring(3, 5);
    String s = hora.substring(6, 8);
    int horac = Integer.parseInt(h + m + s);
    String fecha = dateFormat.format(date);
    String fd = fecha.substring(0, 2);
    String fm = fecha.substring(3, 5);
    String fa = fecha.substring(6, 10);
    int fechac = Integer.parseInt(fa + fm + fd);
    String titulo = "LISTA DE MODIFICACIONES DE ORDENES DE COMPRA " + hourdateFormat.format(date);

    String datospc = "";

    public Alertaoc_control(Alertaoc_view v) {
        this.vista = v;
        try {
            ejecutarTarea();
        } catch (SchedulerException ex) {
            Logger.getLogger(Alertaoc_control.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Alertaoc_control() {
    }
    public void optenerippc() throws UnknownHostException {
        InetAddress localHost = InetAddress.getLocalHost();
        datospc = localHost.getHostName() + "##" + localHost.getHostAddress();

    }

    void Venta() {
        this.vista.btnAceptar.addActionListener(this);
        this.vista.lblTitulo.setText(titulo);
        listar(vista.tbOrdenc);
        generarsonidoalerta(file);
        vista.setVisible(true);
        vista.setLocationRelativeTo(null);
        vista.setResizable(false);
        vista.setExtendedState(vista.MAXIMIZED_BOTH);
        vista.setUndecorated(true);
    }

    public void ejecutarTarea() throws SchedulerException {
        this.pjob.ProceJob();

    }

    public void mostrarVentana(int proc) throws SchedulerException {
        if (proc == 1) {
            this.pjob.StopJob();
            this.Venta();
        } else {

            System.out.println("Llego para ejecutar " + new Date() + " " + datospc);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.btnAceptar) {
            IngresarUsuario();
        }
    }

    public void IngresarUsuario() {
        String usuario;
        usuario = JOptionPane.showInputDialog("Ingrese Su Usuario").trim().toUpperCase();

        /*java //a.setUSERID(usuario);
         List<Alertaoc> lista = mdl.NomusUario(usuario);
         //NomusUario
         int r = mdl.NomusUario(a);
         String usuario1= a.getUSERID();
         System.out.println("Usuario : "+r+" "+usuario1);
         */
        if ((usuario != "") && ((usuario.length() > 3) || (usuario.length() < 10))) {
            usuarioin = usuario;
            Aceptar_mensaje();
            limpiarTabla();
            listar(vista.tbOrdenc);
        } else {
            JOptionPane.showMessageDialog(vista, "Error al ingresar Usuario " + usuario + " " + usuario.length());
            this.IngresarUsuario();
        }

    }

    public boolean haylista() {
        boolean r = false;
        List<Alertaoc> lista = mdl.listar();
        if (lista.size() > 0) {
            r = true;
        } else {
            r = false;
        }
        return r;
    }

    public void listar(JTable tabla) {
        centrarCeldas(tabla);
        modelo = (DefaultTableModel) tabla.getModel();
        vista.tbOrdenc.setModel(modelo);
        List<Alertaoc> lista = mdl.listar();
        Object[] object = new Object[9];
        for (int i = 0; i < lista.size(); i++) {
            object[0] = lista.get(i).getNROOCP();
            object[1] = lista.get(i).getCODFAB();
            object[2] = lista.get(i).getCODLIN();
            object[3] = lista.get(i).getCODART();
            object[4] = lista.get(i).getCODORI();
            object[5] = lista.get(i).getCODMAR() + " " + lista.get(i).getNOMMAR();
            object[6] = lista.get(i).getCANINI();
            object[7] = lista.get(i).getCANFIN();
            object[8] = lista.get(i).getTIPACT();
            modelo.addRow(object);
        }
        tabla.setRowHeight(35);
        tabla.setRowMargin(10);

    }

    void centrarCeldas(JTable tabla) {

        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        for (int i = 0; i < vista.tbOrdenc.getColumnCount(); i++) {
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
        }
    }

    void limpiarTabla() {
        for (int i = 0; i < vista.tbOrdenc.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    public void generarsonidoalerta(String archivo) {
        try {
            /*
             String prb=ruta + archivo + ".mp3";
             System.out.println("Generar el sonido " + prb);
             */
            clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta + archivo + ".wav")));
            clip.start();
        } catch (Exception e) {
            System.out.println("Error en generar el sonido " + e);
        }
    }

    public void Aceptar_mensaje() {
        try {
            optenerippc();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Alertaoc_control.class.getName()).log(Level.SEVERE, null, ex);
        }
        String FLGPRC = "1";
        String USRPRC = usuarioin;
        String JOBPRC = "APJAVALERT";
        int JDTPRC = fechac;
        int JTMPRC = horac;
        a.setFLGPRC(FLGPRC.trim());
        a.setUSRPRC(USRPRC.trim());
        a.setJOBPRC(JOBPRC.trim());
        a.setJDTPRC(JDTPRC);
        a.setJTMPRC(JTMPRC);
        a.setIPXPRC(datospc);
        int r = mdl.actualizar_mensaje(a);
        if (r == 1) {
            JOptionPane.showMessageDialog(vista, "Alerta Verificado Gracias!!");
            vista.setVisible(false);
            try {
                ejecutarTarea();
            } catch (SchedulerException ex) {
                Logger.getLogger(Alertaoc_control.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(vista, "Error " + r);
            vista.setVisible(false);
            try {
                ejecutarTarea();
            } catch (SchedulerException ex) {
                Logger.getLogger(Alertaoc_control.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
