# Duke project template

**Duke** is a desktop app for managing tasks, optimized for use via a
**Command Line Interface (CLI)**

* Quick start
* Features
    * Adding a Task
        * Adding a Todo: ```todo```
        * Adding a Deadline: ```deadline```
        * Adding an Event: ```event```
    * Listing task list: ```list```
    * Marking a task as done: ```done```
    * Deleting a task: ```delete```
    * Finding a task: ```find```
    * Exiting the program: ```bye```

## Quick Start
1. Ensure that you have Java ```11``` installed in your computer.
1. Download the latest ```duke.jar``` from here // need to hyperlink it
1. Copy the file to the folder you want to use as the home folder for your Duke.
1. Open your command prompt // insert a pic of the thingy here

## Features

### Adding a task

### Adding a Todo: ```todo```

Adds a Todo to the task list

Format: ```todo t/TASK```

Examples:
* ```todo t/play football with friends```
* ```todo t/take a nap```

### Adding a Deadline: ```deadline```

Adds a Deadline to the task list

Format: ```deadline t/TASK / b/BY d/DATE```

Examples:
* ```deadline t/complete MA4270 homework / b/by d/23 September 11pm```
* ```deadline t/complete MA4270 project / b/by d/30 October 12pm```

### Adding a Event: ```event```

Adds an Event to the task list

Format: ```event t/TASK / a/AT d/DATE```

Examples:
* ```event t/Zoukout / a/at d/31 December 2021```
* ```event t/John birthday party / a/at d/Sunday 6pm```

### Listing task list: ```list```

Shows a list of all the tasks in the task list.

Format: ```list```

### Marking a task as done: ```done```

Marks a task specified by the index in the task list as done.

Format: ```done INDEX```

* Marked the task at the specified ```INDEX``` as done
* The index refers to the index number shown in the displayed task list.
* The index **must be a positive integer** 1, 2, 3, ...

Examples:
*```done 2``` sets the 2nd task in the task list as done.
*```done 10``` sets the 10th task in the task list as done.

### Deleting a task: ```delete```

Deletes the specified task from the task list.

Format: ```delete INDEX```
* Deletes the task at the specified ```INDEX```.
* The index refers to the index number shown in the displayed task list.
*The index **must be a positive integer** 1, 2, 3, ...

Examples:
*```done 2``` deletes the 2nd task in the task list.
*```done 10``` deletes the 10th task in the task list.

### Finding a task: ```find```

Find tasks which contains any of the given keyword.

Format: ```find KEYWORD```
* The search is case-sensitive.
* Any task is searched whether it is a Todo, Event or Deadline.
* Only full words will be matched e.g. ```plays``` will not match ```plays```.
* Task matching the keyword will be returned.

Examples:
* ```find homework``` returns the complete MA4270 homework task.
* ```find play``` returns the play football with friends task.

### Exiting the program: ```bye```

Exits the program.

FormatL ```bye```

### Saving the data

Duke data are saved in the hard disk automatically after any command that changes the data. 
There is no need to save manually.

## FAQ
**Q**: How do I transfer my data to another Computer?
**A**: Install the app in the other computer and overwrite the empty data file it creates with the 
file that contains the data of your previous AddressBook home folder.

## Command summary

Action | Format/ Examples
------------ | -------------
Add a todo | ```todo t/TASK``` e.g. ```todo t/play football with friends```
Add a deadline | ```deadline t/TASK / b/BY d/DATE``` e.g. ```deadline t/complete MA4270 homework / b/by d/23 September 11pm```
Add an event | ```event t/TASK / a/AT d/DATE``` ```event t/Zoukout / a/at d/31 December 2021```
List | ```list```
Done | ```done INDEX``` e.g. ```done 2``` 
Delete | ```delete INDEX``` e.g. ```delete 2``` 
Find | ```find KEYWORD``` e.g. ```find homework```
Exit | ```bye```
