# User Guide

## Quick Start

1. Ensure you have Java 11 or above installed in your Computer.

1. Download the latest Duke.jar from the release page.

1. Copy the file to the folder you want to use as the home folder for Duke.

1. Double-click the file to start the app.

## Features 
Allows user to add task to Duke and manage a list of pending items.

### Features
* Adding task to Duke
  * Adding a simple task 
  * Adding a task with a deadline (date & time)
  * Adding an event with a deadline (date & time range)
* Allowing user to mark a task as completed 
* Viewing a list of task

### `Keyword` - Describe action

Keyword | 
------------ | 
```todo```  | 
```deadline```  | 
```event```  | 
```list```  | 
```done```  | 
```delete```  | 
```bye```  | 
```help```|

## Usage

##### ```todo```
Adds a task to Duke with task description given in ```<task desc>```.
##### Usage: ```todo <task desc>``` 

##### Examples:
* ```todo Buy an iPhone 12 at launch date```

##### ```deadline```
Adds a task with deadline to Duke with task description given in ```<task desc>```.
State completion deadline of the date & the time in ```<date> <time>```.
##### Usage: ```deadline <task desc> /by <date> <time>``` 

##### Examples:
* ```todo Buy an iPhone 12 at launch date /by 30/10/2020 12pm```

##### ```event```
Adds an event to Duke with task description given in ```<task desc>```.
State event period listing the date & the time period in ```<date> <time>```.
Usage: ```event <event desc> /at <date> <time period>``` 

##### Examples:
* ```event Attend Apple's WWDC /at 12/06/2020 4am```

##### ```list```
List down all task that are logged in Duke.
##### Usage: ```list``` 

##### Examples:
* ```list```

##### ```done```
Mark tasks in Duke as completed.
Usage: ```done <task id>``` 

##### Examples:
* ```done 4```

##### ```delete```
Mark tasks in Duke as completed.
Usage: ```delete <id>``` 

##### Examples:
* ```delete 4```

##### ```find```
Loop up all task with a given a word.
Usage: ```find <Search String>``` 

##### Examples:
* ```find book```

##### ```help```
Display the usage guide for Duke command.

##### Examples:
* ```help```

##### ```bye```
Exit Duke program.
##### Usage: ```bye``` 

##### Examples:
* ```bye```

## Saving the data
Data is saved in the hard disk automatically after any command that changes the data. There is no need to save manually.


