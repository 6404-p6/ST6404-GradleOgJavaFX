package ST6404;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class interactionSummarizerModel {

    private int numberOfErrors;
    private enum highestSeverity{
        risk1,
        risk2,
        risk3;
    }
    private int highestSeverity;
    private List interactionList;


    public interactionSummarizerModel(int NumberOfErrors){
        this.setNumberOfErrors(NumberOfErrors);
    }

    //Metoder
    public int getNumberOfErrors() { return numberOfErrors; }

    public void setNumberOfErrors(int numberOfErrors) { this.numberOfErrors = numberOfErrors;  }

    public int getHighestSeverity() { return highestSeverity; }

    public void setHighestSeverity(int highestSeverity) { this.highestSeverity = highestSeverity; }

    public List getInteractionList() { return interactionList; }

    public void setInteractionList(List interactionList) { this.interactionList = interactionList; }


    //Metoden udtrækker antallet af interaktioner fra listen interactionList.
    public int calculateNumberOfErrors(List interactionList) {
        return interactionList.size();
    }

    //Metoden udregner den samlede severity for alle interaktioner på interactionList, som medikamentet under ordination
    //indgår i. Der er lavet kode, så der kan returneres højeste severity i stedet
     public int function (drugModel new1, ArrayList interactionList){
        int highestSeverity = 0;
        for (int i = 0; i < interactionList.size(); i++){
            medicineInteractionModel test = (medicineInteractionModel) interactionList.get(i);
            if (test.medicamentA == new1.medicationName || test.medicamentB == new1.medicationName){
                if( highestSeverity < test.severity){
                    highestSeverity = test.severity;
                }
                /*
                highestSeverity += test.severity;
                akkumulerer highestSeverity for hele interaktionslisten
                 */
            }
        }
        return highestSeverity;
    }

}