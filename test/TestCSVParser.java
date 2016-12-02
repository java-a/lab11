import com.aspose.cells.*;

/**
 * Created by Zhongyi on 02/12/2016.
 * Sample usage of `Aspose.Cells`.
 */
public class TestCSVParser {
    public static void main(String[] args) throws Exception {
        //Instantiate LoadOptions specified by the LoadFormat.
        LoadOptions loadOptions = new LoadOptions(LoadFormat.CSV);

        //Create a Workbook object and opening the file from its path.
        Workbook workbook = new Workbook("test/fixtures/score.csv", loadOptions);
        Worksheet sheet = workbook.getWorksheets().get(0);

        Cells cells = sheet.getCells();
        String score = cells.get(23, 3).getStringValue();
        System.out.println("Score of 16302010041 is: " + score);
    }
}
