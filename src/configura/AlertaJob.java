
package configura;


import controlador.Alertaoc_control;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import vista.Alertaoc_view;

public class AlertaJob implements Job {  

   
    @Override
    public void execute(JobExecutionContext jec) throws JobExecutionException {
     Alertaoc_control cc=new Alertaoc_control();   
     int proc=0;
        /*
   System.out.println("Hola!! Iniciando la tarea!! ");
        System.out.println("La hora es "+new Date());
        */              
       
       boolean e= cc.haylista();
       if(e==true){
            proc=1;
         try {
             cc.mostrarVentana(proc);
         } catch (SchedulerException ex) {
             Logger.getLogger(AlertaJob.class.getName()).log(Level.SEVERE, null, ex);
         }
       }else{
           
         try {
             cc.mostrarVentana(proc);
         } catch (SchedulerException ex) {
             Logger.getLogger(AlertaJob.class.getName()).log(Level.SEVERE, null, ex);
         }
         
       }
       
    }

  
}
