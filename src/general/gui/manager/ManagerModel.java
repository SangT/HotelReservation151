package general.gui.manager;

import general.Room;

import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * A class to manage accounts, reservations, and rooms of manager
 * @author Sang To
 * @version 1.0
 */
public class ManagerModel {

    private ArrayList<Room> rooms;
    private ArrayList<ChangeListener> listeners;

    /**
     Constructs a GuestModel object
     @param r the data to model
     */
    public ManagerModel(ArrayList<Room> r){
        rooms = r;
        listeners = new ArrayList<ChangeListener>();
    }

    /**
     * Constructs a GuestModel object
     * @return the data in an ArrayList
     */
    public ArrayList<Room> getRoom(){
        return (ArrayList<Room>) (rooms.clone());
    }

    /**
     * Attach a listener to the Model
     * @param l
     */
    public void attach(ChangeListener l){
        listeners.add(l);
    }

    /**
     * Change the data in the model according to a specific choice of room
     * @param r
     */
    public void update(Room r){
        rooms.add(r);
        ChangeEvent event = new ChangeEvent(this);
        for(ChangeListener l : listeners){
            l.stateChanged(event);
        }
    }
}
