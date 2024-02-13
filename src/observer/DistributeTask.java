package observer;

import java.util.List;
import java.util.TimerTask;

import bike.Bike;
import sharingStrategies.RandomSharing;
import sharingStrategies.SharingStrategy;

public class DistributeTask extends TimerTask {
    private ControlCenter cc;

    

    public DistributeTask(ControlCenter cc) {
        this.cc = cc;
    }


    @Override

    public void run() {
       boolean doit = false;
       Station stToChange = null;
       for(Station st : cc.getStations()){
           if (st.isEmpty() || st.isFull()){
               doit = true;
               stToChange = st; 
           }
       }
       if(doit){ 
           System.out.println("Une distibution est nécessaire car sation " +stToChange.getId()+ " vide trop longtemps "  );     
             this.cc.distribute(cc.getStations(), cc.getAvaiableBikes()); 
            System.out.println("apres distribution");
           for (Station station: cc.getStations()) {
            System.out.println(" la station "+station.getId() + " a apresent after the distribution "+ station.nbBikes());
           } 
   }
}}


   

