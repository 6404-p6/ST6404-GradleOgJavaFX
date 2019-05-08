package ST6404;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

public class medicineInteractionModel {
    private String medicamentA;
    private String medicamentB;
    private int probability;

    private enum severity {
        mild,
        moderate,
        severe;
    }

    private int severity;
    private String documentationLevel;
    private String recommendationText;
    private String descriptionOfEffect;
    private String suggestionForAlternative;

    public medicineInteractionModel(String medicamentA, String medicamentB, int probability, int severity) {
        this.setMedicamentA(medicamentA);
        this.setMedicamentB(medicamentB);
        this.setProbability(probability);
        this.setSeverity(severity);
    }

    /*
     Metoder:
        - retrieveInteractionsInformation ()
        - retrieveSimilarDrugs ()
        - calculationBestMedicine ()
        - showInteractionsInformation ()
     */
    private String getMedicamentA() {
        return medicamentA;
    }

    private void setMedicamentA(String medicamentA) {
        this.medicamentA = medicamentA;
    }

    private String getMedicamentB() {
        return medicamentB;
    }

    private void setMedicamentB(String medicamentB) {
        this.medicamentB = medicamentB;
    }

    private int getProbability() {
        return probability;
    }

    private void setProbability(int probability) {
        this.probability = probability;
    }

    private int getSeverity() {
        return severity;
    }

    private void setSeverity(int severity) {
        this.severity = severity;
    }

    private String getDocumentationLevel() {
        return documentationLevel;
    }

    private void setDocumentationLevel(String documentationLevel) {
        this.documentationLevel = documentationLevel;
    }

    private String getRecommendationText() {
        return recommendationText;
    }

    private void setRecommendationText(String recommendationText) {
        this.recommendationText = recommendationText;
    }

    private String getDescriptionOfEffect() {
        return descriptionOfEffect;
    }

    private void setDescriptionOfEffect(String descriptionOfEffect) {
        this.descriptionOfEffect = descriptionOfEffect;
    }

    private String getSuggestionForAlternative() {
        return suggestionForAlternative;
    }

    private void setSuggestionForAlternative(String suggestionForAlternative) {
        this.suggestionForAlternative = suggestionForAlternative;
    }


/*
    public static void main(String[] args) {

        String MedicamentA;
        String MedicamentB;

        MedicamentA = "Medikament A";
        MedicamentB = "Medikament B";

        Scanner input1 = new Scanner(System.in);
        System.out.println("Medikament A : ");
        String medicamentA = input1.next();

        Scanner input2 = new Scanner(System.in);
        System.out.println("Medikament B : ");
        String medicamentB = input2.next();

        if (medicamentA.equals(input1) && medicamentB.equals(input2)) {

            System.out.println("Access Granted! Welcome!");
        } else if (medicamentA.equals(input1)) {
            System.out.println("Invalid Password!");
        } else if (medicamentB.equals(input2)) {
            System.out.println("Invalid Username!");
        } else {
            System.out.println("Invalid Username & Password!");
        }

    }*/

}
