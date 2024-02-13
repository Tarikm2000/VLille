package observer;

import java.util.*;
import bike.Bike;
import state.BikeIsNotWorking;
import state.BikeIsWorking;
import visitor.Repairer;
import visitor.Thief;


public class RepairTask extends TimerTask {
    private ControlCenter cc;
    
    /**
     * Constructs a RepairTask for the specified control center.
     *
     * @param cc The ControlCenter instance that this task will handle repairs for.
     */
    public RepairTask(ControlCenter cc) {
        this.cc = cc;
    }

    /**
     * The action to be performed by this timer task. This method checks all bikes in the system and repairs those
     * in a 'not working' state.
     */
    @Override
    public void run() {
                List<Bike> bikes= new ArrayList<>();

       for (Station st :cc.getStations()) {

            bikes.addAll(st.getBikes());
       }
    
    
    for (Bike b:bikes) {
         if (b.getBikeState() instanceof BikeIsNotWorking) {
            Repairer repaire=new Repairer("momo");
            repaire.visit(b);
             System.out.println("un velo a été reparé");
    }}
}

}