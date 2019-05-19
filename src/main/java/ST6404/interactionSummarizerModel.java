package ST6404;

import java.util.ArrayList;
import java.util.List;

public class interactionSummarizerModel {

    private int numberOfErrors;
    private int highestSeverity;
    private List interactionList;


    public interactionSummarizerModel() {
    }

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


    // Gennemgår hele interaktionslisten for om nogle har en severity på 2. Hvis ja, er highest severity = 2 og der
    // breakes i for-loopet.
    public void calculateHighestSeverity(){
        for (int i = 0; i < interactionList.size(); i++) {
            medicineInteractionModel tempInteraction = (medicineInteractionModel) interactionList.get(i);
            if (tempInteraction.getSeverity() == 2) {
                setHighestSeverity(2);
                break;
            } else {setHighestSeverity(1);}
        }
    }
}