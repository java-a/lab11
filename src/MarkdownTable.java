import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by ztong on 12/1/16.
 */
public class MarkdownTable {
    public static final int MAX_ROWS = 1024;
    private MarkdownTableRecord[] tableRecords;
    private MarkdownTableHead tableHead;

    public MarkdownTable(String filePath) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filePath));
            String line;
            int index = -2;
            tableRecords = new MarkdownTableRecord[MarkdownTable.MAX_ROWS];
            while ((line = br.readLine()) != null) {
                String[] tableRow = this.splitTableRow(line);
                switch (index) {
                    case -2:
                        // First row
                        this.tableHead = new MarkdownTableHead(tableRow);
                        break;
                    case -1:
                        // Second row
                        break;
                    default:
                        // Other rows
                        this.tableRecords[index] = new MarkdownTableRecord(tableRow);
                }
                index++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private String[] splitTableRow(String line) {
        return line.replaceFirst("^\\|\\s*", "").split("\\s*\\|\\s*");
    }

    public String getCell(int row, int col) {
        return this.tableRecords[row].getColumn(col);
    }

    public String getCell(int row, String colName) {
        int col = this.tableHead.getIndex(colName);
        if (col == -1) return "N/A";
        return this.getCell(row, col);
    }

    public void setCell(int row, int col, String value) {
        this.tableRecords[row].setColumn(col, value);
    }

    public void setCell(int row, String colName) {
        int col = this.tableHead.getIndex(colName);
        if (col == -1) return;
        this.setCell(row, col, colName);
    }
}
