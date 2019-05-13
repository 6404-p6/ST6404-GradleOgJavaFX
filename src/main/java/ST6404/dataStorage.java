package ST6404;

public class dataStorage {
    /*Singleton data storage klasse, som kan kaldes fra alle klasser.
    Dermed kan der indskrives forskellige informationer som er
    enten patientdata eller medicindata, som forventes at bevæge
    sig over alle klasserne.*/
    private static dataStorage dataStorageObject;

    public static patientModel chosenPatient;

    private dataStorage(){
    }
    // Metode til at enten hente eller skabe en instans af klassen.
    public static dataStorage getInstance(){
        if (dataStorageObject == null)
            dataStorageObject = new dataStorage();
        return dataStorageObject;
    }




}


