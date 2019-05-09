package ST6404;
import ST6404.prescriptedDrugModel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.*;
import java.util.stream.*;

public class medicineCardModel {
    private List medicineList;


    public medicineCardModel(List medicineList) {
        this.medicineList = medicineList;
    }

    public List getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List medicineList) {
        this.medicineList = medicineList;
    }
}
