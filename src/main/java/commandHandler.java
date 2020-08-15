import java.util.Vector;

public class commandHandler {

    displayHandler DisplayUnit = new displayHandler();

    public void checkCommandType(String KeyWord, String Body, listHandler List) {

        KEYWORD keyword = KEYWORD.valueOf(KeyWord.toUpperCase());

        switch(keyword){
            case LIST:
                DisplayUnit.DisplayList(List.GetList()); break;

            case DONE:
                Task task = List.UpdateListItem(Body);
                DisplayUnit.DisplayChanges(task); break;
        }
    }
}
