import java.util.Objects;

/**
 * Created by ztong on 12/1/16.
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
