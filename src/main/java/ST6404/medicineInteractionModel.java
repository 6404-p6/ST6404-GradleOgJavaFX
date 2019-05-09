package ST6404;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class medicineInteractionModel {
    private String medicamentA;
    private String medicamentB;

    private enum severity {
        mild,
        moderate,
        severe;
    }

    private int severity;
    private int documentationLevel;
    private String recommendationText;
    private String descriptionOfEffect;
    private String suggestionForAlternative;

    public medicineInteractionModel(String medicamentA, String medicamentB, int documentationLevel, int severity, String recommendationText, String descriptionOfEffect) {
        this.setMedicamentA(medicamentA);
        this.setMedicamentB(medicamentB);
        this.setSeverity(severity);
        this.setDocumentationLevel(documentationLevel);
        this.setRecommendationText(recommendationText);
        this.setDescriptionOfEffect(descriptionOfEffect);
    }

    /*
     Metoder:
        - retrieveInteractionsInformation ()
        - retrieveSimilarDrugs ()
        - calculationBestMedicine ()
        - showInteractionsInformation ()
     */
    public String getMedicamentA() {
        return medicamentA;
    }

    private void setMedicamentA(String medicamentA) {
        this.medicamentA = medicamentA;
    }

   public String getMedicamentB() {
        return medicamentB;
    }

    private void setMedicamentB(String medicamentB) {
        this.medicamentB = medicamentB;
    }


    public int getSeverity() {
        return severity;
    }

    private void setSeverity(int severity) {
        this.severity = severity;
    }

    public int getDocumentationLevel() {
        return documentationLevel;
    }

    public void setDocumentationLevel(int documentationLevel) {
        this.documentationLevel = documentationLevel;
    }

    public String getRecommendationText() {
        return recommendationText;
    }

    private void setRecommendationText(String recommendationText) {
        this.recommendationText = recommendationText;
    }

    public String getDescriptionOfEffect() {
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


}
