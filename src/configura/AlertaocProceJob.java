/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package configura;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class AlertaocProceJob {

    AlertaJob job = new AlertaJob();

    public int ProceJob() throws SchedulerException {

        JobDetail j = JobBuilder.newJob(job.getClass()).build();
        Trigger t = TriggerBuilder.newTrigger().withIdentity("CroneTrigger")
                .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(02)
                        .repeatForever()).build();
        Scheduler s = StdSchedulerFactory.getDefaultScheduler();
        s.start();
        s.scheduleJob(j, t);
        return 1;
    }
    public void StopJob()throws SchedulerException{
    Scheduler s = StdSchedulerFactory.getDefaultScheduler();
        s.shutdown();
    }
    
}
