package duke.fileManager;
import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;
import duke.output.DisplayHandler;
import duke.storage.ListHandler;
import duke.task.Task;

import java.io.*;
import java.util.Iterator;
import java.util.Vector;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileManager {

    protected String fileName;
    protected File dataFile;
    protected String filePath;

    public FileManager(String fileName) {
        this.fileName = fileName;
    }

    public void ReadFile(ListHandler list) {
        // Check if file exists
        dataFile = new File(fileName);
        DisplayHandler.ReadDataMsg(dataFile.getAbsolutePath()); // debug statement

        // Read file format and load it in Duke
        try {
            BufferedReader br = new BufferedReader(new FileReader(dataFile));

            String eachLineOfFile;
            while ((eachLineOfFile = br.readLine()) != null){
                // Parse File Data & Insert to Duke
                InsertFileContent(list, eachLineOfFile);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File does not exists yet : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("File cannot be read : " + e.getMessage());
        }
    }

    private void InsertFileContent(ListHandler list, String eachLineOfFile) {
        String[] eachLineContent = eachLineOfFile.split(" ");

        checkTaskType(list, eachLineContent);
    }

    private void checkTaskType(ListHandler list, String[] eachLineContent) {
        String taskType = eachLineContent[0];
        taskType = taskType.trim();

        switch(taskType) {
            case "[T]":
                InsertTodo(list, eachLineContent);
                break;

            case "[D]":
                InsertDeadline(list, eachLineContent);
                break;

            case "[E]":
                InsertEvent(list, eachLineContent);
                break;

            default:
                System.out.println("There is a unrecognised text format in DUKE data file");
        }
    }

    private void InsertTodo(ListHandler list, String[] eachLineContent) {
        String doneStatus = eachLineContent[1];
        int begin = 2, end = eachLineContent.length-1;
        String[] todoBody = new String[ (end+1) - begin];
        System.arraycopy(eachLineContent, begin, todoBody, 0, todoBody.length);
        list.addToDo(convertArrayToString(todoBody));

        if(doneStatus.equals("[✓]")){
            Vector List = list.GetList();
            Task justInserted = (Task)List.lastElement();
            justInserted.markAsDone();
        }
    }

    private void InsertDeadline(ListHandler list, String[] eachLineContent) {
        String doneStatus = eachLineContent[1];
        int begin = 2, end = eachLineContent.length-4;
        String[] deadlineBody = new String[ (end+1) - begin];
        System.arraycopy(eachLineContent, begin, deadlineBody, 0, deadlineBody.length);
        String deadlineDate = getDateContent(eachLineContent);
        String deadlineTime = getTimeContent(eachLineContent);
        list.addDeadline(convertArrayToString(deadlineBody), deadlineDate, deadlineTime);

        if(doneStatus.equals("[✓]")){
            Vector List = list.GetList();
            Task justInserted = (Task)List.lastElement();
            justInserted.markAsDone();
        }
    }

    private void InsertEvent(ListHandler list, String[] eachLineContent) {
        String doneStatus = eachLineContent[1];
        int begin = 2, end = eachLineContent.length-4;
        String[] eventBody = new String[ (end+1) - begin];
        System.arraycopy(eachLineContent, begin, eventBody, 0, eventBody.length);
        String eventDate = getDateContent(eachLineContent);
        String eventTime = getTimeContent(eachLineContent);
        list.addEvent(convertArrayToString(eventBody), eventDate, eventTime);

        if(doneStatus.equals("[✓]")){
            Vector List = list.GetList();
            Task justInserted = (Task)List.lastElement();
            justInserted.markAsDone();
        }
    }

    private String getDateContent(String[] eachLineContent) {
        String date = eachLineContent[eachLineContent.length - 2];
        return date;
    }

    private String getTimeContent(String[] eachLineContent) {
        String time = eachLineContent[eachLineContent.length - 1];
        time = charRemoveAt(time, time.length()-1);
        return time;
    }

    public static String charRemoveAt(String str, int p) {
        return str.substring(0, p) + str.substring(p + 1);
    }

    private String convertArrayToString(String[] array) {
        StringBuilder builder = new StringBuilder();
        for(String value : array){
            builder.append(" " + value);
        }
        builder.append(" ");
        return builder.toString();
    }

    public void SaveFile(Vector ListStorage) {

        dataFile = CreateFile();
        Iterator dukeTask = ListStorage.iterator();
        ClearFileContent();

        while(dukeTask.hasNext()){
            try{
                Task toBeStored = (Task) dukeTask.next(); // Read the Tasks from Duke
                WriteToFile(toBeStored.toString()); // Write Tasks to File

            } catch (IOException e) {
                System.out.println("Something went wrong: " + e.getMessage());
            }
        }
    }

    private File CreateFile() {
        File createdFile = new File(fileName);
        filePath = createdFile.getAbsolutePath();
        System.out.println("created data file at: " + createdFile.getAbsolutePath()); // debug statement

        return createdFile;
    }

    private void WriteToFile(String textToAppend) throws IOException {
        FileWriter fw = new FileWriter(fileName, true);
        fw.write(textToAppend + "\n");
        fw.close();
    }

    private void ClearFileContent() {
        try {
            PrintWriter writer = new PrintWriter(dataFile);
            writer.print("");
            writer.close();

        } catch (FileNotFoundException e) {
            System.out.println("Unable to clear file content: " + e.getMessage());
        }
    }
}