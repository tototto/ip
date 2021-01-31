package duke.fileManager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Vector;

import duke.output.DisplayHandler;
import duke.storage.ListHandler;
import duke.task.Task;

public class FileManager {

    protected String fileName;
    protected File dataFile;
    protected String filePath;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Read the file and load data into duke
     * @param list the list to be populated
     * @return the result of the file loading
     */
    public String readFile(ListHandler list) {
        // Check if file exists
        dataFile = new File(fileName);

        // Read file format and load it in Duke
        try {
            BufferedReader br = new BufferedReader(new FileReader(dataFile));
            String eachLineOfFile;
            while ((eachLineOfFile = br.readLine()) != null) {
                // Parse File Data & Insert to Duke
                insertFileContent(list, eachLineOfFile);
            }

        } catch (FileNotFoundException e) {
            DisplayHandler.fileNotFound(e.getMessage());
        } catch (IOException e) {
            DisplayHandler.cannotReadFile(e.getMessage());
        }

        return "Reading data from: " + dataFile.getAbsolutePath(); // debug statement
    }

    private void insertFileContent(ListHandler list, String eachLineOfFile) {
        String[] eachLineContent = eachLineOfFile.split(" ");

        checkTaskType(list, eachLineContent);
    }

    private void checkTaskType(ListHandler list, String[] eachLineContent) {
        String taskType = eachLineContent[0];
        taskType = taskType.trim();

        switch(taskType) {
        case "[T]":
            insertTodo(list, eachLineContent);
            break;

        case "[D]":
            insertDeadline(list, eachLineContent);
            break;

        case "[E]":
            insertEvent(list, eachLineContent);
            break;

        default:
            DisplayHandler.encounterWrongFormat();
        }
    }

    private void insertTodo(ListHandler list, String[] eachLineContent) {
        String doneStatus = eachLineContent[1];
        int begin = 2;
        int end = eachLineContent.length - 1;
        String[] todoBody = new String[ (end + 1) - begin];
        System.arraycopy(eachLineContent, begin, todoBody, 0, todoBody.length);
        list.addToDo(convertArrayToString(todoBody));

        if (doneStatus.equals("[✓]")) {
            Vector List = list.getList();
            Task justInserted = (Task) List.lastElement();
            justInserted.markAsDone();
        }
    }

    private void insertDeadline(ListHandler list, String[] eachLineContent) {
        String doneStatus = eachLineContent[1];
        int begin = 2;
        int end = eachLineContent.length - 4;
        String[] deadlineBody = new String[ (end + 1) - begin];
        System.arraycopy(eachLineContent, begin, deadlineBody, 0, deadlineBody.length);
        String deadlineDate = getDateContent(eachLineContent);
        String deadlineTime = getTimeContent(eachLineContent);
        list.addDeadline(convertArrayToString(deadlineBody), deadlineDate, deadlineTime);

        if (doneStatus.equals("[✓]")) {
            Vector List = list.getList();
            Task justInserted = (Task) List.lastElement();
            justInserted.markAsDone();
        }
    }

    private void insertEvent(ListHandler list, String[] eachLineContent) {
        String doneStatus = eachLineContent[1];
        int begin = 2;
        int end = eachLineContent.length - 4;
        String[] eventBody = new String[ (end + 1) - begin];
        System.arraycopy(eachLineContent, begin, eventBody, 0, eventBody.length);
        String eventDate = getDateContent(eachLineContent);
        String eventTime = getTimeContent(eachLineContent);
        list.addEvent(convertArrayToString(eventBody), eventDate, eventTime);

        if (doneStatus.equals("[✓]")) {
            Vector List = list.getList();
            Task justInserted = (Task) List.lastElement();
            justInserted.markAsDone();
        }
    }

    private String getDateContent(String[] eachLineContent) {
        String date = eachLineContent[eachLineContent.length - 2];
        return date;
    }

    private String getTimeContent(String[] eachLineContent) {
        String time = eachLineContent[eachLineContent.length - 1];
        time = charRemoveAt(time, time.length() - 1);
        return time;
    }

    public static String charRemoveAt(String str, int p) {
        return str.substring(0, p) + str.substring(p + 1);
    }

    private String convertArrayToString(String[] array) {
        StringBuilder builder = new StringBuilder();
        for (String value : array) {
            builder.append(" " + value);
        }
        builder.append(" ");
        return builder.toString();
    }

    /**
     * Store all task in duke as a data file
     * @param ListStorage data to be stored in file
     */
    public void saveFile(Vector ListStorage) {

        dataFile = createFile();
        Iterator dukeTask = ListStorage.iterator();
        clearFileContent();

        while (dukeTask.hasNext()) {
            try {
                Task toBeStored = (Task) dukeTask.next(); // Read the Tasks from Duke
                writeToFile(toBeStored.toString()); // Write Tasks to File

            } catch (IOException e) {
                DisplayHandler.writeFileError(e.getMessage());
            }
        }
    }

    private File createFile() {
        File createdFile = new File(fileName);
        filePath = createdFile.getAbsolutePath();
        DisplayHandler.createdFile(createdFile.getAbsolutePath()); // debug statement

        return createdFile;
    }

    private void writeToFile(String textToAppend) throws IOException {
        FileWriter fw = new FileWriter(fileName, true);
        fw.write(textToAppend + "\n");
        fw.close();
    }

    private void clearFileContent() {
        try {
            PrintWriter writer = new PrintWriter(dataFile);
            writer.print("");
            writer.close();

        } catch (FileNotFoundException e) {
            DisplayHandler.clearFileFailure(e.getMessage());
        }
    }
}
