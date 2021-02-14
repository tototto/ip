# Developer Guide

## Design

### Architecture

![Image of SoftwareArchitecture](https://github.com/tototto/ip/blob/master/docs/images/architecture.jpg?raw=true)

The Architecture Diagram given above explains the high-level design of the App. Given below is a quick overview of each component.

The App consist of 9 components.

* UI: The UI of the App.
* Duke: The main logic handler of the App.
* Command: The control variable of the App.
* FileManager: Reads data from, and writes data to, the hard disk.
* Storage: Contains the in-memory data of the app.
* Search: Searches the data
* Task: Define the structure of each task.
* Input: Define how input is recieved.
* Output: Define how output is displayed.

### How the architecture components interact with each other

The Sequence Diagram below shows how the components interact with each other for the scenario where the user issues the command todo xxx.

![Image of SequenceDiagram](https://github.com/tototto/ip/blob/master/docs/images/Interaction.jpg?raw=true)

The sections below give more details of some of each component.

### Duke component

![Image of DukeComponent](https://github.com/tototto/ip/blob/master/docs/images/Duke.jpg?raw=true)

The Duke componenet is the main handler of the App logic. It is associated with and contains all other classes as they are needed and necessary for the sucessful implementation of the logic in Duke. Duke uses the other classes in the order that is required to work the logic.

The Duke componenet is called by the UI componenet which is implemented using JavaFX.

### Command component

![Image of CommandComponent](https://github.com/tototto/ip/blob/master/docs/images/CmdComponent.jpg?raw=true)

User provide input to the App and they are pared by the InputParser class to produce a Keyword String object.
Command and input entered by the user with the keyword are passed into the Command componenet by Duke.
Command Components handles the different input of user entered into Duke based on the keyword extracted. 
Based on the keywords that was parsed, different actions are taken by the Command componenet.

Such as: 
    * Adding a todo
    * Adding a deadline
    * Marking a task as done
    * Deleting a task

Based on the different keywords, the user remaning input are further parsed using the API of other componenet such as the InputParser.
Task can then be created or updated or action can be taken, such as deleting or displaying help.
The storage can be updated based on the result of the command executed.
The result of the command execution is encapsulated as a output string object and is passed back to the Ui.
In addition, the Command Component can also instruct the Ui to perform certain actions, such as displaying help to the user.
The result is stored in the Storage componenet and then written to the file by the FileManager Component.

## Implementation

Add todo task Implementation

The add todo feature add items in Duke. It is facillated by the Command Class which comprises of the following implementation for the add functionality:

* ```InputParser``` - Parses the remaining input after keyword and prepares them to be added to the App
* ```ListHandler``` - Add the input to the in-memory storage list
* ```Task``` - Define how the task is structured in the App
* ```DisplayHandler``` - Controls the result of the command execution

The following sequence diagram shows how the Add todo operation works.

![Image of CommandComponent](https://github.com/tototto/ip/blob/master/docs/images/AddTodoImplementation.jpg?raw=true)

##### Design consideration:
Aspect: Add Todo can otherwise be implemented

###### Alternative 1: Allow user to store all task including Events & Deadline using the Todo command instead of having seperate command such as Deadline & Event for each of them.
Pros: Improve usability. User now only needs to remember one command. <br>
Cons: difficult to implement.


## Product scope
### Target user profile
* Is a manager, student or individual who needs to manage tasks.
* prefer desktop apps over other types.
* can type fast.
* prefers typing to mouse interactions.
* is reasonably comfortable using CLI apps.

### Value proposition
manage defects faster than a typical mouse/GUI driven app. Allows the user to better manage the personal or work issues.

## Non-Functional Requirements

* Should work on any mainstream OS as long as it has Java 11 or above installed.
* Should be able to hold up to 1000 task without a noticeable sluggishness in performance for typical usage.
* A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse
* Should load from and save to from a text files


## Glossary

* *Mainstream OS:* Windows, Linux, Unix, OS-X.

## Instructions for manual testing

### Launch and Shutdown

1. Initial launch
    1. Download the jar file and copy into an empty folder
    2. Use Command Prompt to run jar file with `java -jar` command.
    3. type exit command to exit from the program.

2. Re-launch the app by running `java -jar` command with Command Prompt.

### Adding a todo task
1. Add the Todo task through following command:
    1. Todo {task description here}

### Listing all task in the system
1. Enter the command
    1. List
2. List of all task in the system will be listed in the order they were created.

### Delete a particular task in the system
1. Enter the command
    1. Delete {index}. Eg: Delete 1
2. The first Defect will be deleted.

### Load a list of Defects into the progam upon lauch
1. Program looks for and loads data.txt
2. If file is not found, no task will be preloaded. Program starts as per normal operation.

### Save a list of task into itlogger.txt upon exit
1. Saves all task into the data.txt file when user issues any command.
2. If file does not exist, data.txt will be created.
