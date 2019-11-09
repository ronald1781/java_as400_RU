package controlador;

import configura.AlertaocProceJob;
import org.quartz.SchedulerException;
import vista.Alertaoc_view;

public class Principal_control {

    public static void main(String args[]) throws SchedulerException {
        
    Alertaoc_view v = new Alertaoc_view();
        Alertaoc_control c = new Alertaoc_control(v);
        
        
    }
}
