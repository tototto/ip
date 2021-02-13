# Developer Guide

## Design

### Architecture

![Image of SoftwareArchitecture](https://github.com/tototto/ip/blob/master/docs/images/architecture.jpg?raw=true)

The Architecture Diagram given above explains the high-level design of the App. Given below is a quick overview of each component.

The App consist of 9 components.

UI: The UI of the App.
Main: The main logic handler of the App.
Commons: The control variable of the App.
Storage: Reads data from, and writes data to, the hard disk.
Finder: Searches and sort the data
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
* Is a developer, tester or member of the project team.
* prefer desktop apps over other types.
* can type fast.
* prefers typing to mouse interactions.
* is reasonably comfortable using CLI apps.


### Value proposition
manage defects faster than a typical mouse/GUI driven app. Allows the user to better manage the project issues.

## User Stories
 
|Priority| As a … | I want to … | So that I can… |
|--------|----------|---------------|------------------|
|* * * |new user|add issues into IT logger|track my issues|
|* * * |New user|view an issue that is based on the ticket number|see its progress.|
|* * * |New user|delete a defect|remove defects that are resolved or no longer required|
|* * * |New user|list all issues currently in the ITLogger|find all of the recorded issues currently in ITLogger.|
|* * |New user|I would like a given issue format|so that I can know a structured way of using the app|
|* |New user|I would like the issue I logged to be date stamped|so that I know when it was raised|
|* * * |User|be able to load defects from a text file or database|View and track all defects previously recorded in the system|
|* * * |User|Have a help guide|View the usage of the app|
|* * * |User|Update information of existing defects|Keep track of those defects that have changed|
|* * |user|Search defects based on my preference|Narrow down the search result based on what i want to look up|
|* * * |User|Automatically save my records when the defect list has been changed|progression will not be lost|
|* * |User|View my defect in a sorted order|More easily track my list of items|
|* * * |Forgetful user|Be notified of my task that are due|Not forget what i need to fix and close|
|* * * |User|Have a robust app|So that my data integrity is maintained (e.g. no deletion, cannot reopen after close)|


## Non-Functional Requirements

* Should work on any mainstream OS as long as it has Java 11 or above installed.
* Should be able to hold up to 1000 defects without a noticeable sluggishness in performance for typical usage.
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

### Adding a defect
1. Add the Defect through following command:
    1. add t/<TITLE> s/<STATUS> sv/<SEVERITY in integer from 0 to 10> dl/<DEADLINE in dd-mm-yyyy format> o/<OWNER>
 
### Updating a defect
1. Enter the update mode for a defect:
    1. update u/<TICKET in integer>
2. When in update mode, update the title of the defect:
    1. update t/<NEW TITLE>
3. When in update mode, update the severity of the defect:
    1. update sv/<NEW SEVERITY in integer from 0 to 10>

### Listing all Defects in the system
1. Enter the command
    1. List
2. List of all Defects in the system will be listed in the order they were created.

### Viewing a particular Defect in the system
1. Enter the command
    1. View /index. Eg:View 1
2. The second Defect created will be shown on screen in details.

### Delete a particular Defect in the system
1. Enter the command
    1. Delete d/index. Eg:Delete d/1
2. The second Defect will be deleted.

### Load a list of Defects into the progam upon lauch
1. Program looks for and loads itlogger.txt
2. If file is not found, no Defects will be preloaded. Program starts as per normal operation.

### Save a list of Defects into itlogger.txt upon exit
1. Saves all Defects into the itlogger.txt file when user enters the Exit command.
2. If file does not exist, itlogger.txt will be created.
