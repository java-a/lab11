/**
 * Created by Zhongyi Tong on 12/1/16.
 * <p>
 * #### `MarkdownTable`
 * Represents the table itself.
 * It takes a file path and parse the file into a `MarkdownTableHead` and an array of `MarkdownTableRecord`.
 * Note that the number of rows will not exceed `1024`. And all of the values are considered as pure strings.
 * You need to provide the following features:
 * - Get and update a cell in a given row and a given column.
 * - Get and update a cell in a given row and the column with a given header name.
 * - [Optional] Save the table back into the file when a method is explictly called.
 * - [Optional] Add any feature that you think is appropriate.
 */
public class MarkdownTable {
    /**
     * Split a given row into an array of strings.
     * <p>
     * Example:
     *
     * @param line: | 1    | 13307110217 | Male   | 23.3  |
     * @return : ["1, "13307110217", "Male", "23.3"]
     */
    private static String[] splitTableRow(String line) {
        return line.replaceFirst("^\\|\\s*", "").split("\\s*\\|\\s*");
    }
}
