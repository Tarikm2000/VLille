package observer;

import java.util.*;
import bike.Bike;
import state.BikeIsNotWorking;
import state.BikeIsWorking;
import visitor.Repairer;
import visitor.Thief;


public class StealTask extends TimerTask {
    private ControlCenter cc;

    
    /**
     * Constructs a StealTask for the specified control center.
     *
     * @param cc The ControlCenter instance that this task will simulate bike thefts for.
     */
    public StealTask(ControlCenter cc) {
        this.cc = cc;
    }


    /**
     * The action to be performed by this timer task. This method checks each station and simulates the theft of a bike 
     * if there is only one bike left at the station.
     */
    @Override
    public void run() {
        for (Station station : this.cc.getStations()) {
            if (station.getBikes().size() ==1) {
                Thief thief=new Thief(station);
                if (!station.isEmpty()) {
                thief.visit(station.getBikes().get(0));
                System.out.println("Un vélo a été volé à la station " + station.getId());;
                }
            }
       
        
        }
    }
}