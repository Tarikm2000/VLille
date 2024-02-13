package observer;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Date;

import bike.Bike;
import sharingStrategies.*;
import visitor.*;
import state.*;

    /**
     * Constructs a ControlCenter with a list of stations, a sharing strategy, and a delay for distribution tasks.
     *
     * @param stations  The list of stations to be managed.
     * @param strategy  The sharing strategy to be applied for bike distribution.
     * @param delay     The delay in seconds before starting the distribution task and between subsequent runs.
     */
    public class ControlCenter implements Observer {
        private List<Station> stations;
        private SharingStrategy strategy;
        private Timer timer;
        private long delay; 
        private TimerTask task;
        
        /**
         * Constructs a ControlCenter with a list of stations, a sharing strategy, and a delay for distribution tasks.
         *
         * @param stations  The list of stations to be managed.
         * @param strategy  The sharing strategy to be applied for bike distribution.
         * @param delay     The delay in seconds before starting the distribution task and between subsequent runs.
         */
        public ControlCenter(List<Station> stations, SharingStrategy strategy, long delay)  {
            this.stations = stations;
            this.strategy = strategy;
            this.delay = delay * 1000 ; 
            this.timer = new Timer("Timer");
            this.task = new DistributeTask(this);
            this.timer.scheduleAtFixedRate(task, 2*this.delay,10000);
            
        };

        /**
        * Retrieves the list of all stations managed by the control center.
        *
        * @return A list of Station objects.
        */
        public List<Station> getStations() {
            return this.stations;
        }

        /**
         * Counts the number of stations managed by the control center.
         *
         * @return The total number of stations.
         */
        public int nbStations() {
            int res=0;
            for (Station st:this.stations) {
                res++;
            }
            return res;
        }

        /**
         * Retrieves the sharing strategy used by the control center.
         *
         * @return The SharingStrategy object.
         */
        public SharingStrategy getStrategy() {
            return this.strategy;
        }
        
        

        /**
         * This method is called when a Station object being observed notifies the ControlCenter of a change.
         *
         * @param station The Station object that has changed.
         */
        @Override
        public void update(Station station) {
            
            System.out.println("On vient d'etre notifié d'un changement");
            
        }
                    
        
        /**
        * Gathers all bikes from all stations managed by the control center.
        *
        * @return A list of all Bike objects across the network of stations.
        */
        public List<Bike> getAllBikes() {
            List<Bike> allBikes = new ArrayList<>();
            for (Station station : this.stations) {
                allBikes.addAll(station.getBikes());
            }
            return allBikes;
        }

        /**
        * Distributes bikes across the network of stations according to the control center's sharing strategy.
        *
        * @param stations The list of stations to distribute bikes to.
        * @param bikes    The list of bikes to be distributed.
        */
        public void distribute(List<Station> stations, List<Bike> bikes) {
            for (Station st : this.getStations()) {
                st.getBikes().clear();
            }
        
            this.getStrategy().shareBikes(stations, bikes);
        
            for (Station st : this.getStations()) {
                System.out.println("La station " + st.getId() + " a " + st.nbBikes() + " bikes après la distribution.");
            }
        }
        
        /**
         * Checks whether a given station is empty.
         *
         * @param s The Station object to check.
         * @return true if the station has no bikes, false otherwise.
         */
        public boolean checkEmpty(Station s) {
            return s.getBikes().isEmpty();
        }

        /**
         * Retrieves a list of available bikes that are in working condition.
         *
         * @return A list of available Bike objects.
         */
        public List<Bike> getAvaiableBikes() {
                        List<Bike> avaiableBikes = new ArrayList<>();

            for (Station st: this.getStations()) {
                for (Bike b : st.getBikes()) {
                    if (b.getBikeState() instanceof BikeIsWorking) {
                        avaiableBikes.add(b);
                    }
                }


            }
            return avaiableBikes;
        }
        
    }
