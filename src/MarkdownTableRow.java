/**
 * Created by Zhongyi Tong on 12/1/16.
 * <p>
 * #### `MarkdownTableRow`
 * Represents a single row in a table. It takes a list of columns from a string array.
 * Store these columns as its field and provide a setter and a getter for it.
 * Besides, it should provide methods to set and get a single column with a given index.
 */
public class MarkdownTableRow {
    private String[] columns;

    public MarkdownTableRow(String[] columns) {
        this.columns = columns;
    }

    public String[] getColumns() {
        return columns;
    }

    public String getColumn(int index) {
        if (this.checkIsOutOfBounds(index)) return null;
        return this.columns[index];
    }

    public void setColumn(int index, String value) {
        if (this.checkIsOutOfBounds(index)) return;
        this.columns[index] = value;
    }

    private boolean checkIsOutOfBounds(int index) {
        return !(index >= 0 && index < this.columns.length);
    }
}