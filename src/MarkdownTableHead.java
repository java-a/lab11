import java.util.Objects;

/**
 * Created by Zhongyi Tong on 12/1/16.
 * <p>
 * #### `MarkdownTableHead`
 * Extends `MarkdownTableRow`. Represents the first row of a table, i.e. the header.
 * It should provide a method to get the index of a header with a given name.
 */
public class MarkdownTableHead extends MarkdownTableRow {
    public MarkdownTableHead(String[] columns) {
        super(columns);
    }

    public int getIndex(String colName) {
        String[] columns = this.getColumns();
        for (int i = 0; i < columns.length; i++) {
            if (Objects.equals(colName, columns[i])) {
                return i;
            }
        }
        return -1;
    }
}