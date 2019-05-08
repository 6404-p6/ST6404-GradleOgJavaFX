package ST6404;

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


    static void calculateNumberOfErrors(){

    }

/*
Metoder:
- calculateNumberOfErrors ()
- showIndicator ()
- viewInteractions ()
 */
    public int getNumberOfErrors() { return numberOfErrors; }

    public void setNumberOfErrors(int numberOfErrors) { this.numberOfErrors = numberOfErrors;  }

    public int getHighestSeverity() { return highestSeverity; }

    public void setHighestSeverity(int highestSeverity) { this.highestSeverity = highestSeverity; }

    public List getInteractionList() { return interactionList; }

    public void setInteractionList(List interactionList) { this.interactionList = interactionList; }

}
