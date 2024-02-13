import bike.*;
import sharingStrategies.RandomSharing;
import sharingStrategies.RoundRobinSharing;

import java.util.ArrayList;
import observer.*;
import java.util.List;
import java.util.Scanner;
import java.util.Timer;

public class Main {

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                                                          ║");
        System.out.println("║  ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░    ║");
        System.out.println("║  ░░░██░░░░██░██░░░░░░░██░░░░██░░░░░░██░░░░░░██████░░░    ║");
        System.out.println("║  ░░░██░░░░██░██░░░░░░░██░░░░██░░░░░░██░░░░░░██░░░░░░░    ║");
        System.out.println("║  ░░░░██░░██░░██░░░░░░░██░░░░██░░░░░░██░░░░░░██████░░░    ║");
        System.out.println("║  ░░░░░████░░░██░░░░░░░██░░░░██░░░░░░██░░░░░░██░░░░░░░    ║");
        System.out.println("║  ░░░░░░██░░░░██████░░░██░░░░██████░░██████░░██████░░░    ║");
        System.out.println("║  ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░    ║");
        System.out.println("║                                                          ║");
        System.out.println("║                                                          ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        List<Bike> bikes = new ArrayList<>();
        List<Station> stations = new ArrayList<>();
        Basket basket=new Basket();
        for (int i = 0; i < 30; i++) {
            bikes.add(new ElectricalBike(2, false));
        }

        for (int j = 0; j < 5; j++) {
            stations.add(new Station(j, 100));
        }
            ElectricalBike b=new ElectricalBike(2, false);
            DecoratedBike decoratedBike = new DecoratedBike(b, basket);   // on a créé un velo equipé d'un panier
            bikes.add(decoratedBike);   

        ControlCenter cc = new ControlCenter(stations, new RoundRobinSharing(), 2);
        new RandomSharing().shareBikes(stations, bikes);
        for (Station s : stations) {
            s.attach(cc);
            System.out.println("La station " + s.getId() + " contient " + s.nbBikes());
        }

        DistributeTask distributeTask = new DistributeTask(cc);
        RentTask rentTask = new RentTask(cc);
        ReturnTask returnTask = new ReturnTask(cc);
        StealTask stealTask = new StealTask(cc);
        RepairTask repairTask= new RepairTask(cc);

        long distributeInterval = 2000;  
        long rentInterval = distributeInterval / 2;  
        long returnTime =distributeInterval / 2;
        long repairTaskTime = 2000;



        Timer distributeTimer = new Timer();
        Timer stealTimer= new Timer();
        Timer rentTimer = new Timer();
        Timer returnTimer= new Timer();
        Timer repairTimer= new Timer();

        distributeTimer.scheduleAtFixedRate(distributeTask, 5, 3000);
        rentTimer.scheduleAtFixedRate(rentTask, 3, 1500);
        returnTimer.scheduleAtFixedRate(returnTask, 2, 1500);
        stealTimer.scheduleAtFixedRate(stealTask,4,3000);
        repairTimer.scheduleAtFixedRate(repairTask, 1, 1500);
}

}
