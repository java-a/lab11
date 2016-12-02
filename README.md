# lab11
In this lab, you are required to write a simple parser for Markdown tables. We focus on the the design of object hierarchy and relations. Before that, you are provided with an example, showing how `Aspose.Cells` can be used to manipulate a CSV format table.

## Aspose.Cells

The following code is used to get the value in a certain cell using `Aspose.Cells`. Run the sample code from `test/TestCSVParser.java` (you might need to right click on `lib/aspose-cells-16.11.0.jar` and add as library). Try it yourself!

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

More usages can be found from the [API Reference](http://www.aspose.com/api/java/cells/com.aspose.cells/classes/Worksheet). [Aspose](http://www.aspose.com/products/total/java) can also be used to manipulate Word, Excel, PDF, PowerPoint, Outlook and more than 100 other file formats.

## Markdown Table Parser

### What is Markdown?

A Markdown file is nothing but plain text using a lightweight syntax so that it can be easily converted to HTML. For example, the document you are reading now is rendered automatically from `README.md`. The syntax of Markdown is extremely simple, which makes it perfect for writing documentations. Some quick tricks: `**strong**` would be rendered to **strong**, `*italic*` to *italic*, etc.

The syntax for a table is a bit more complex. Take the following table as an example:

```markdown
| No   | ID          | Sex    | Score |
| ---- | ----------- | ------ | ----- |
| 1    | 13307110217 | Male   | 23.3  |
| 2    | 16302010001 | Male   | 66.6  |
| 3    | 16302010002 | Male   | 66.6  |
| 4    | 16302010003 | Male   | 66.6  |
| 5    | 16302010005 | Male   | 88.8  |
```

The first row is the table header, and the second row serves as the separator which takes no effect. The rest of the file contains rows of table records. In each row, columns are separated by a `|`. Especially note that, you can add as many spaces as you want, since they will be ignored when being parsed. The table will be rendered into:

| No   | ID          | Sex  | Score |
| ---- | ----------- | ---- | ----- |
| 1    | 13307110217 | Male | 23.3  |
| 2    | 16302010001 | Male | 66.6  |
| 3    | 16302010002 | Male | 66.6  |
| 4    | 16302010003 | Male | 66.6  |
| 5    | 16302010005 | Male | 88.8  |

### Writing a parser

Suppose we have a `score.md`, which only contains a Markdown flavored table. Users should be able to:

- Read and save a Markdown table.
- Get and update a certain cell in the table.

You are asked to design and implement four objects with an object-oriented thinking. Their relations are described in the graph below. 

![image](https://cloud.githubusercontent.com/assets/7262715/20804637/ae1552ac-b82e-11e6-9073-08f4aa7c6cdb.png)

#### `MarkdownTableRow`

Represents a single row in a table. It takes a list of columns from a string array. Store these columns as its field and provide a setter and a getter for it. Besides, it should provide methods to set and get a single column with a given index.

#### `MarkdownTableHead`

Extends `MarkdownTableRow`. Represents the first row of a table, i.e. the header. It should provide a method to get the index of a header with a given name.

#### `MarkdownTableRecord`

Extends `MarkdownTableRow`. Represents one record row in the table. No other methods are needed.

#### `MarkdownTable`

Represents the table itself. It takes a file path and parse the file into a `MarkdownTableHead` and an array of `MarkdownTableRecord`. Note that the number of rows will not exceed `1024`. And all of the values are considered as pure strings. You need to provide the following features:

- Get and update a cell in a given row and a given column.
- Get and update a cell in a given row and the column with a given header name.
- [Optional] Save the table back into the file when a method is explictly called.
- [Optional] Add any feature that you think is appropriate. 

### Getting started

**Step 0:** Read through the descriptions above. Make sure you understand what you are going to do.

**Step 1:** Get familiar with the project structure. Unfinished objects are stored in `src`, and `score.md` is in `test/fixtures`. You need to run `TestMarkdownTableParser`  to test your program, rather than writing a `main` entrance in these objects.

**Step 2:** Design the signatures for the methods you need in each object from the buttom up (the simple one). Start with the constructor.

**Step 3:** Implement the methods you wrote in Step 2. 

**Step 4:** Review your design. Check if it satisfies all of the requirements.

In addition, `String[] splitTableRow(String line)` is provided to help you split columns in a row.

## Submission

**Deadline:** Tuesday, 2016.12.06 23:59:59 (UTC+8)

Upload your work to:

```shell
ftp://10.132.141.33/classes/16/161 程序设计A （戴开宇）/WORK_UPLOAD/lab11
```