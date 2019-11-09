package modelo;

import configura.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Alertaoc_model {

    Conexion conexion = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Statement cst;

    public List listar() {
        List<Alertaoc> datos = new ArrayList<>();
        String sql = "select a.LONROOCP,a.LOCODFAB,a.LOCODLIN,a.LOCODART,a.LOCODORI,a.LOCODMAR,(case when a.LOTIPACT='A' THEN 'Adicion' when a.LOTIPACT='M' THEN 'Modificacion' when a.LOTIPACT='E' THEN 'Eliminado' end) as LOTIPACT,a.LOCANINI,a.LOCANFIN,b.EYDSCLAR from LIBPRDDAT.LOORCLOGL0 a left join LIBPRDDAT.mmeyrel0 b on a.LOCODMAR=b.EYCODMAR WHERE a.LOFLGPRC=''";
        try {
            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Alertaoc p = new Alertaoc();
                p.setNROOCP(rs.getInt(1));
                p.setCODFAB(rs.getString(2));
                p.setCODLIN(rs.getString(3));
                p.setCODART(rs.getString(4));
                p.setCODORI(rs.getString(5));
                p.setCODMAR(rs.getString(6));
                p.setTIPACT(rs.getString(7));
                p.setCANINI(rs.getInt(8));
                p.setCANFIN(rs.getInt(9));
                p.setNOMMAR(rs.getString(10));
                datos.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error en modelo listar " + e);
        }
        return datos;
       
    }

    public int actualizar_mensaje(Alertaoc a) {
        int r = 0;
        String sql = "update LIBPRDDAT.LOORCLOGL0 b set b.LOFLGPRC=?,b.LOUSRPRC=?,b.LOJOBPRC=?,b.LOJDTPRC=?,b.LOJTMPRC=?,LOIPXPRC=? WHERE b.LOFLGPRC=''";//
        try {
            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
           
            ps.setString(1, a.getFLGPRC());
            ps.setString(2, a.getUSRPRC());
            ps.setString(3, a.getJOBPRC());
            ps.setInt(4, a.getJDTPRC());
            ps.setInt(5, a.getJTMPRC());
            ps.setString(6, a.getIPXPRC());
            r = ps.executeUpdate();
            if (r == 1) {
                r = 2;
            } else {
                r = 1;
            }

        } catch (Exception e) {
            System.out.println("Error en Actualziar data: " + e );
        }
        return r;
    }

    public List NomusUario(String usuario) {

        List<Alertaoc> datos = new ArrayList<>();
        String sql = "select d.BMUSERID from LIBPRDDAT.mmbmrel0 d where d.BMUSERID=" + usuario + " AND d.BMCODCIA='10'";
        try {
            con = conexion.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Alertaoc p = new Alertaoc();
                p.setUSERID(rs.getString(1));
                datos.add(p);
            }
        } catch (Exception e) {
            System.out.println("Error en modelo listar " + e);
        }
        return datos;
    }

}
