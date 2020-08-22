import jdk.internal.util.xml.impl.Input;

import java.util.Vector;

public class commandHandler {

    displayHandler DisplayUnit = new displayHandler();
    inputParser InputUnit = new inputParser();

    public void checkCommandType(String KeyWord, String Body, listHandler List) {

        KEYWORD keyword = KEYWORD.valueOf(KeyWord.toUpperCase());

        try{

            switch(keyword){
                case TODO:
                    List.addToDo(Body);
                    Task todoTaskAdded = (Task) List.GetList().lastElement();
                    DisplayUnit.ShowTaskAdded(List.GetList().size(), todoTaskAdded);
                    break;

                case DEADLINE:
                    String deadlineBody = InputUnit.extractDeadlineBody(Body);
                    String deadlineByDate = InputUnit.extractDeadlineByDay(Body);
                    String deadlineByTime = InputUnit.extractDeadlineByTime(Body);
                    List.addDeadline(deadlineBody, deadlineByDate, deadlineByTime);
                    Task deadlineTaskAdded = (Task) List.GetList().lastElement();
                    DisplayUnit.ShowTaskAdded(List.GetList().size(), deadlineTaskAdded);
                    break;

                case EVENT:
                    String eventBody = InputUnit.extractEventBody(Body);
                    String eventDay = InputUnit.extractEventAtDay(Body);;
                    String eventTime = InputUnit.extractEventAtTime(Body);
                    List.addEvent(eventBody, eventDay, eventTime);
                    Task EventTaskAdded = (Task) List.GetList().lastElement();
                    DisplayUnit.ShowTaskAdded(List.GetList().size(), EventTaskAdded);
                    break;

                case LIST:
                    DisplayUnit.DisplayList(List.GetList());
                    break;

                case DONE:
                    Task task = List.UpdateListItem(Body);
                    DisplayUnit.DisplayChanges(task);
                    break;

                case BYE:
                    DisplayUnit.ProgramEnding();
                    System.exit(0);
                    break;
            }

        } catch (Exception e){
            DisplayUnit.DisplayInvalidInput();
        }
    }
}
