# Developer Guide

## Design

### Architecture

![Image of SoftwareArchitecture](https://github.com/tototto/ip/blob/master/docs/images/architecture.jpg?raw=true)

The Architecture Diagram given above explains the high-level design of the App. Given below is a quick overview of each component.

The App consist of 9 components.

UI: The UI of the App.
Duke: The main logic handler of the App.
Command: The control variable of the App.
FileManager: Reads data from, and writes data to, the hard disk.
Search: Searches the data
IssueList: Define the structure of each issue to track.

### How the architecture components interact with each other

![Image of SequenceDiagram](https://github.com/tototto/ip/blob/master/docs/images/Interaction.jpg?raw=true)

### Duke component

![Image of DukeComponent](https://github.com/tototto/ip/blob/master/docs/images/Duke.jpg?raw=true)

### Command component

![Image of CommandComponent](https://github.com/tototto/ip/blob/master/docs/images/CmdComponent.jpg?raw=true)

## Implementation

![Image of CommandComponent](https://github.com/tototto/ip/blob/master/docs/images/AddTodoImplementation.jpg?raw=true)

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
