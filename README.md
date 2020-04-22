# CSX42: Assignment 4
## Name: Sagar Toke

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in numberPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

```commandline
ant -buildfile spendingPotentialState/src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

```commandline
ant -buildfile spendingPotentialState/src/build.xml all
```

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

Requirement: input file should be in numberPlay folder
#### Use the below command to run the program.

```commandline
ant run -buildfile spendingPotentialState/src/build.xml  
-DinputFile=<!-- Input filename.--> 
-DavailableItemsFile=<!-- Available items file.-->
-DrunningAverageWindowSize=<!-- Window size for running average calculation -->
-DoutputFile=<!-- Output filename. -->

-----------------------------------------------------------------------
## Description:


##References and citation

-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [02/25/2020]

