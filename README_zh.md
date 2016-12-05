# lab11
在这个 lab 中，你需要编写一个简单的 Markdown 表格解析器。我们主要考察对象层次结构和相互关系的设计。在编码前，你将会看到一个示例，向你展示 `Aspose.Cells` 如何操作一个 CSV 格式的表格。

## Aspose.Cells

下列代码使用  `Aspose.Cells` 获取某个单元格中的值。运行 `test/TestCSVParser.java` 中的示例代码。试一试吧！

```java
//Instantiate LoadOptions specified by the LoadFormat.
LoadOptions loadOptions = new LoadOptions(LoadFormat.CSV);
//Create a Workbook object and opening the file from its path.
Workbook workbook = new Workbook("test/fixtures/score.csv", loadOptions);
Worksheet sheet = workbook.getWorksheets().get(0);
Cells cells = sheet.getCells();
String score = cells.get(23, 3).getStringValue();
System.out.println("Score of 16302010041 is: " + score);
```

更多用法可以在 [API Reference](http://www.aspose.com/api/java/cells/com.aspose.cells/classes/Worksheet) 上找到。 [Aspose](http://www.aspose.com/products/total/java) 还可以被用来操作 Word、Excel、PDF、PowerPoint、Outlook 等超过 100 种文件格式。

## Markdown 表格解析器

### Markdown是什么？

Markdown 文件 (`*.md`) 只是一种纯文本格式的文件，但是使用了轻量级的语法，使它能够被轻易地渲染成 HTML （网页）。例如，你正在阅读的文档是从 `README.md` 自动生成而来的 (对比 [README_zh.md](https://raw.githubusercontent.com/java-a/lab11/master/README_zh.md)，看看这个转换是如何发生的)。Markdown 的语法非常简单，使它极其适合文档的编写。一些快速小技巧： `**粗体**` 将会被渲染成 **粗体**， `*斜体*` 被渲染成 *斜体* 等等。

表格的语法稍微复杂一些。以下面的表格为例：

```markdown
| No   | ID          | Sex    | Score |
| ---- | ----------- | ------ | ----- |
| 1    | 13307110217 | Male   | 23.3  |
| 2    | 16302010001 | Male   | 66.6  |
| 3    | 16302010002 | Male   | 66.6  |
| 4    | 16302010003 | Male   | 66.6  |
| 5    | 16302010005 | Male   | 88.8  |
```

第一行为表头 (table header)，第二行作为分隔符，没有实质作用。文件中剩余的行包含表中的记录 (table record)。在每一行中，列之间被 `|` 分隔开来。注意，你可以在行中添加任意多的空格，因为它们被解析时会被忽略。这张表会被渲染成：

| No   | ID          | Sex  | Score |
| ---- | ----------- | ---- | ----- |
| 1    | 13307110217 | Male | 23.3  |
| 2    | 16302010001 | Male | 66.6  |
| 3    | 16302010002 | Male | 66.6  |
| 4    | 16302010003 | Male | 66.6  |
| 5    | 16302010005 | Male | 88.8  |

### 编写一个解析器

假设我们已有一个 `score.md`，其中只包含一个 Markdown 格式的表格。用户需要做到：

- 读/写一个 Markdown 表格。
- 获取/更新表中某个单元格。

你需要使用面向对象的思想，设计并实现四个对象。它们之间的关系如下图所示。

![image](https://cloud.githubusercontent.com/assets/7262715/20804637/ae1552ac-b82e-11e6-9073-08f4aa7c6cdb.png)

#### `MarkdownTableRow`

表示表中的一行。该类从一个字符串数组读取该行的每一列。将这些列存为类的属性，并提供 setter 和 getter 方法。此外，该类应该提供方法来设置和获取给定下标所对应的列。

#### `MarkdownTableHead`

继承自 `MarkdownTableRow` 。表示表中的第一行，也就是表头。该类应该提供方法来获取给定名称的表头所对应的下标。

#### `MarkdownTableRecord`

继承自 `MarkdownTableRow` 。表示表中某一行记录。不需要提供其它方法。

#### `MarkdownTable`

表示表格本身。该类接受文件路径，将该文件解析成一个 `MarkdownTableHead` 和一列 `MarkdownTableRecord`。 注意，行数不会超过 `1024`。且表中所有值都视为纯字符串。你需要提供以下功能：

- 获取/更新给定行和列的某个单元格。
- 获取/更新给定行和给定表头的某个单元格。
- [选做] 当用户显式调用时，将表格写回到文件。
- [选做] 添加你认为合适的其它功能。

### 开始编写

**第 0 步:** 仔细阅读上一节中的说明。确保你理解你将要做的事。

**第 1 步:** 熟悉项目结构。待完成的对象位于 `src`，`score.md` 位于 `test/fixtures`。你需要运行 `TestMarkdownTableParser` 来测试你的程序，而不是在这些对象中添加 `main` 入口。

**第 2 步:** 自底向上地（从简单的开始）设计每个对象中你所需要的方法的签名。从构造方法开始着手。

**第 3 步:** 实现你在第 2 步中写下的方法。

**第 4 步:** 检查你的设计。它是否满足了所有需求？

此外，`String[] splitTableRow(String line) ` 可以帮助你分割某一行中的所有列。

## 提交

**截止日期:** 星期二，2016.12.06 23:59:59 (UTC+8)

将你的作业上传至：

```shell
ftp://10.132.141.33/classes/16/161 程序设计A （戴开宇）/WORK_UPLOAD/lab11
```
