/**
 * Created by ztong on 12/1/16.
 */
public class TestMarkdownTableParser {
    public static void main(String[] args) {
        MarkdownTable table = new MarkdownTable("test/fixtures/score.md");
        System.out.println(table.getCell(1, "Sex"));
        table.setCell(1, "Sex", "Female");
        System.out.println(table.getCell(1, 2));
        table.setCell(1, 2, "Unknown");
        System.out.println(table.getCell(1, "Sex"));
    }
}
