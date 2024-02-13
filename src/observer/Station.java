package observer;

import java.util.ArrayList;
import java.util.List;
import visitor.*;
import bike.*;
import state.*;
import java.util.Date;


public class Station implements Subject {
    private List<Observer> observers = new ArrayList<>();

    private int id;
    private int maxCapacity;
    private List<Bike> bikes;
    private List<Bike> rentedBikes;

    /**
     * Constructs a Station with a specific ID and maximum capacity.
     *
     * @param id The unique identifier for the station.
     * @param maxCapacity The maximum number of bikes that the station can hold.
     */
    public Station(int id, int maxCapacity) {
        this.id = id;
        this.maxCapacity = maxCapacity;
        this.bikes = new ArrayList<>();
        this.rentedBikes=new ArrayList<>();
        
    }

    /**
     * Gets the ID of the station.
     *
     * @return the ID of the station.
     */
    public int getId(){
        return this.id;
    } 

    /**
     * Removes a bike from the station.
     *
     * @param b The bike to be removed.
     */
    public void removeBike(Bike b) {
        this.bikes.remove(b);
    }

   
    /**
     * Gets a list of bikes currently rented from this station.
     *
     * @return the list of rented bikes.
     */
    public List<Bike> getRentedBikes() {
        return this.rentedBikes;
    } 
   

    /**
     * Gets the maximum capacity of the station.
     *
     * @return the maximum capacity of the station.
     */
    public int getmaxCapacity() {
        return this.maxCapacity;
    }

    

    public List<Bike> getBikes() {
        return this.bikes;
    }

    /**
     * Gets the number of bikes present at the station.
     *
     * @return the number of bikes at the station.
     */
    public int nbBikes(){
        return this.bikes.size();
    } 

    /**
     * Adds a bike to the station.
     *
     * @param b The bike to be added.
     */
    public void addBike (Bike b) {
        this.bikes.add(b);
    } 

    /**
     * Rents a bike from the station. Removes the bike from the list of available bikes and adds it to the list of rented bikes.
     *
     * @param b The bike to be rented.
     */
    public void rentBike (Bike b) {     
           if (b.getNbMaxUsage() > b.getNbused() &&  !this.isEmpty() && b.getBikeState() instanceof BikeIsWorking)  {
                this.bikes.remove(b);
                this.rentedBikes.add(b);
                b.setRented(true);
                b.setNbused(b.getNbused()+1);
            }else if (b.getNbMaxUsage()==b.getNbused() ){
                b.setState(new BikeIsNotWorking());
            }
         this.notifyObserver();

    }

    /**
     * Returns a bike to the station. Adds the bike to the list of available bikes and removes it from the list of rented bikes.
     *
     * @param bike The bike to be returned.
     */
    public void returnBike(Bike bike) { 
        if (this.rentedBikes.contains(bike)) {
            this.bikes.add(bike);
                        this.rentedBikes.remove(bike);
                        bike.setRented(false);

             System.out.println("un depot a eu lieu a la sation "+this.getId()+ " et cette station a à present "+this.nbBikes());            
        }
            this.notifyObserver();

    }

   
    /**
     * Gets the list of observers attached to this station.
     *
     * @return the list of observers.
     */
    public List<Observer> getObservers() {
        return this.observers;
    }


    /**
     * Attaches an observer to the station.
     *
     * @param observer The observer to be attached.
     */
    public void attach(Observer observer) {
        observers.add(observer);
    }

    /**
     * Detaches an observer from the station.
     *
     * @param observer The observer to be detached.
     */
    public void detach(Observer observer) {
        observers.remove(observer);
    }

    
    /**
     * Notifies all observers of a state change in the station.
     */
    public void notifyObserver() { 
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    /**
     * Gets a list of available bikes at the station.
     *
     * @return the list of available bikes.
     */
    public List<Bike> getAvaiableBikes () {
        List<Bike> avaiableBikes = new ArrayList<>();
        for (Bike b: this.bikes) {
            if (!b.getRented()) {
                avaiableBikes.add(b);

            }
        }
        return avaiableBikes;
    }
  
 
    /**
     * Checks if the station is empty.
     *
     * @return true if the station is empty, false otherwise.
     */
     public boolean isEmpty(){
        return this.bikes.size() == 0;
    }

    /**
     * Checks if the station is full.
     *
     * @return true if the station is full, false otherwise.
     */
    public boolean isFull(){
        return this.bikes.size() == this.maxCapacity;
     }
}
