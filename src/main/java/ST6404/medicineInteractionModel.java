package ST6404;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Scanner;

public class medicineInteractionModel {
    public String medicamentA;
    public String medicamentB;
    public int severity;
    private int documentationLevel;
    private String recommendationText;
    private String descriptionOfEffect;
    private String suggestionForAlternative;

    public medicineInteractionModel(String medicamentA, String medicamentB, int severity, int documentationLevel, String recommendationText, String descriptionOfEffect) {
        this.medicamentA = medicamentA;
        this.medicamentB = medicamentB;
        this.severity = severity;
        this.documentationLevel = documentationLevel;
        this.recommendationText = recommendationText;
        this.descriptionOfEffect = descriptionOfEffect;
    }
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

    public int calculateNumberOfMedicine(List medicineCardList) {
        return medicineCardList.size();
    }

}
