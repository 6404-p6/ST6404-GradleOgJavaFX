package ST6404;

public class globalInstanceHandler {
    private static globalInstanceHandler globalInstanceHandlerObject;

    public static patientModel chosenPatient;

    private globalInstanceHandler(){
    }

    public static globalInstanceHandler getInstance(){
        if (globalInstanceHandlerObject == null)
            globalInstanceHandlerObject = new globalInstanceHandler();
        return globalInstanceHandlerObject;
    }
}


