/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.TravelCard;

import java.util.ArrayList;

/**
 *
 * @author Mugdha
 */
public class TravelCardHistory {
  
     private ArrayList<TravelCard> history;

    public TravelCardHistory() {
        history = new ArrayList<>();
    }

    public ArrayList<TravelCard> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<TravelCard> history) {
        this.history = history;
    }

    public TravelCard createAndAddTravelCard() {
        TravelCard travelCard = new TravelCard();
        history.add(travelCard);
        return  travelCard;
    }

    public void deleteTravelCard(TravelCard travelCard) {
        history.remove(travelCard);
    }
}
