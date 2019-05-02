package ST6404;

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

    public medicineInteractionModel (String medicamentA, String medicamentB, int probability, int severity){
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

    private String getRecommendationText () {return recommendationText;}

    private void setRecommendationText (String recommendationText) {this.recommendationText = recommendationText;}

    private String getDescriptionOfEffect() {
        return descriptionOfEffect;
    }

    private void setDescriptionOfEffect(String descriptionOfEffect) {
        this.descriptionOfEffect = descriptionOfEffect;
    }

    private String getSuggestionForAlternative() {
        return suggestionForAlternative;
    }

    private void setSuggestionForAlternative(String suggestionForAlternative) { this.suggestionForAlternative = suggestionForAlternative; }


}
