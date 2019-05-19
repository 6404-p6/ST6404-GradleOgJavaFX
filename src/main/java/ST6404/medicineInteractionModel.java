package ST6404;


public class medicineInteractionModel {
    public String medicamentA;
    public String medicamentB;
    public int severity;
    private int documentationLevel;
    private String recommendationText;
    private String descriptionOfEffect;
    /* Død kode, men det bliver liggende for at vise intentionen. Det skulle være blevet brugt i en algoritme,
    som sendte ATC koder til SQL, fik alternative medikamenter tilbage og derefter beregnede det bedste alternativ
    som havde færrest interaktioner over hele interaktionslisten*/
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

   public String getMedicamentB() {
        return medicamentB;
    }

    public int getSeverity() {
        return severity;
    }

    public int getDocumentationLevel() {
        return documentationLevel;
    }

    public String getRecommendationText() {
        return recommendationText;
    }

    public String getDescriptionOfEffect() {
        return descriptionOfEffect;
    }

}
