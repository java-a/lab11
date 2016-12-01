import java.util.Objects;

/**
 * Created by ztong on 12/1/16.
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
