package ST6404;

import java.util.ArrayList;
import java.util.List;

public class interactionSummarizerModel {

    private int numberOfErrors;
    private int highestSeverity;
    private List interactionList;


    public interactionSummarizerModel() {
    }

    //Metoder
    public int getNumberOfErrors() {
        return numberOfErrors;
    }

    public void setNumberOfErrors(int numberOfErrors) {
        this.numberOfErrors = numberOfErrors;
    }

    public int getHighestSeverity() {
        return highestSeverity;
    }

    public void setHighestSeverity(int highestSeverity) {
        this.highestSeverity = highestSeverity;
    }

    public List getInteractionList() {
        return interactionList;
    }

    public void setInteractionList(List interactionList) {
        this.interactionList = interactionList;
    }


    //Metoden udtrækker antallet af interaktioner fra listen interactionList.
    public String calculateNumberOfErrors() {
        String numberOfErrorsString = Integer.toString(interactionList.size());
        return numberOfErrorsString;
    }

    //Metoden udregner den samlede severity for alle interaktioner på interactionList, som medikamentet under ordination
    //indgår i. Der er lavet kode, så der kan returneres højeste severity i stedet
    public int calculateHighestSeverity(drugModel new1, ArrayList interactionList) {
        int highestSeverity = 0;
        for (int i = 0; i < interactionList.size(); i++) {
            medicineInteractionModel test = (medicineInteractionModel) interactionList.get(i);
            if (test.medicamentA == new1.getMedicationName() || test.medicamentB == new1.getMedicationName()) {
                if (highestSeverity < test.severity) {
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