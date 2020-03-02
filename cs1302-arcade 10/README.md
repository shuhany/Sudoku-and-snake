# CSCI 1302 - Arcade App v2018.fa

This document contains the description for the `cs1302-arcade` project
assigned to the students in the Fall 2018 CSCI 1302 classes
at the University of Georgia.

**Please read the entirety of this file before
beginning your project.** 

## Due Dates

* Team Application ([link](https://ugeorgia.ca1.qualtrics.com/jfe/form/SV_29LGjGh45Ei6OEd)) deadline extended to **MON 2018-11-26 @ 11:55 PM**.
  * _Note: originally due **FRI 2018-11-16 @ 11:55 PM**. Please see [Updates](#updates) below._
* Partial Submision due by **FRI 2018-11-30 @ 11:55 PM**.
* Partial Submision due by **FRI 2018-12-07 @ 11:55 PM**.
* Final Submision due by **TUE 2018-12-11 @ 03:30 PM**.

Please note that due to the day and time of the final submission, 
no late submissions will be accepted for grading.
Please also note that submissions from teams who did not submit 
a team application before the application deadline will not be 
accepted for grading.
These are firm policies and will not be ammended. 
Exceptions will not be granted.

## Table of Contents

* [Academic Honesty](#academic-honesty)
* [Updates](#updates)
* [Project Description](#project-description)
* [Project Requirements & Grading](#project-requirements--grading)
  * [Functional Requirements](#functional-requirements)
  * [Non-Functional Requirements](#non-functional-requirements)
* [How to Download the Project](#how-to-download-the-project)
* [Submission Instructions](#submission-instructions)
* [Appendix - Useful Links](#appendix---useful-links)
* [Appendix - FAQ](#appendix---faq)

## Academic Honesty

You agree to the Academic Honesty policy as outlined in the course syllabus, 
course website, and your team application. Furthermore, you must adhere to
the copyright notice and licensing information at the bottom of this document.

## Updates

Updates will be posted here.
If there has been an update and you have already cloned the project to Nike, 
then you can update your copy of the project using the <code>$ git pull</code>
command while inside of your project directory.

* **2018-11-07:** Extended the team application deadline and added an additional
  extra credit opportunity for those who submitted their applications before
  the original deadline.

## Project Description

Your goal is to implement a single GUI application in Java using JavaFX 8 that 
provides an arcade with your own Java+JavaFX implementations of at least two 
playable games.

Your team must choose one game from each of the following groups:

* **Group 1**
  * [Snake](https://en.wikipedia.org/wiki/Snake_(video_game_genre))
  * [Tetris](https://en.wikipedia.org/wiki/Tetris) 
  * [Space Invaders](https://en.wikipedia.org/wiki/Space_Invaders)
* **Group 2**
  * [Sudoku](https://en.wikipedia.org/wiki/Sudoku)
  * [Go](https://en.wikipedia.org/wiki/Go_(game))
  * [American Checkers](https://en.wikipedia.org/wiki/Draughts)

You have a lot of flexibility with regard to the visuals of your games. As long
as the functional requirements are met and the game mechanics are easily
recognizable, you are free to make each game look and feel however you want
(please keep it appropriate).
The general functional requirements for each group are provided later in this document.

Part of software development is being given a goal but not necessarily being 
given instruction on all of the details needed to accomplish that goal. For example,
even though working with things like keyboard and mouse-related events 
haven't been explicitly covered in class, you are going to need to lookup how to do 
these things in order to complete this project. Starter code and a generously 
helpful [FAQ](#appendix---faq) are provided.

This project is also designed to help you better understand the usefulness of good
class design. While you can technically write your entire JavaFX-based
GUI application entirely in the `start` method, this will make your code messy, 
hard to read, possibly redundant, and likely more prone to errors.
Before you write any code, you should plan out your application's scene graph
(i.e., the containment hierarchy), and design custom components as needed.
If you find that you are writing a lot of code related to a specific component
(e.g., setting styling, adding event handlers, etc.), then it's probably 
a good idea to make a custom version of that component in order to reduce
clutter. You are strongly encouraged to consider swapping out multiple scenes
for this project. 

### Learning Outcomes

* Plan, design, implement, test, debug, and deploy a complete object-oriented
  software solution in Linux/Unix environment (1302-LO1)
* Utilitze inheritance and polymorphism in a software project (1302-LO3-LO4).
* Develop a GUI for a software project (1302-LO7).
* Implement exception-handling in a software project (1302-LO8).
* Understand and apply langauge basics using an OOP language (1302-LO11).

### Functional Requirements

* **Main Application Requirements (10 points):** The main part of your 
  application needs to fulfill the following functional requirements:

  * *Game List (5 points):* Your application should present
  the user with a visual list of available games. Starting a game should either
  swap the scene in the current stage or create an application modal stage on
  which to display the game's scene graph.
  
  * *Multiple Games per Execution (5 points):* Your application should allow
  users to exit one game (without exiting the entire application) and start
  the same game again (with its state reset) or start the other game. 

* **Group 1 Game Requirements (45 points):** Your Group 1 game implementation
  needs to fulfill the following functional requirements:

  * *UI, Mechanics, and Scoring (40 points):* The user interface and game mechanics
    must be easily recognizable and consistent with traditional implementations of
    the game you chose (see the Wikipedia link for more information). Your game
    must provide a consistent scoring mechanism and display the score or scores to
    the user somewhere in the user interface. Furthermore, a game in this category
    must support multiple levels of difficulty that a user will encounter as they
    play the game. The first level should be designed so that it is easily attainable
    by the grader. The current level of difficulty should always be visible to
    the user somewhere in the user interface.

  * *Controls (5 points):* You are required to provide keyboard controls 
    for a game in this group. If anything is not intuitive, then you need to let
    the user know before the game starts. 

* **Group 2 Game Requirements (45 points):** Your Group 2 game implementation
  needs to fulfill the following functional requirements:

  * *UI, Mechanics, and Scoring (40 points):* The user interface and game mechanics
    must be easily recognizable and consistent with traditional implementations of
    the game you chose (see the Wikipedia link for more information). Your game
    must provide a consistent scoring mechanism and display the score or scores to
    the users somewhere in the user interface. 

  * *Controls (5 points):* You are required to provide intuitive mouse controls 
    for a game in this group. If anything is not intuitive, then you need to let
    the user know before the game starts. 
    
  * *Note:* You are only required to provide a 
    human player vs. human player mode for for a multiplayer game in this category. 
    Feel free to add support for computer players, however, such support will not 
    contribute to your grade. 

* **Extra Credit 1 (5 points):** Add some kind of animated intro to your application.
  One potential way to accomplish this is by using a separate scene for your intro.
  This intro should include, in addition to some kind of animated element, the 
  application title (i.e., `cs1302-arcade`), your team name, and the name of each
  team member. If you want the grader to check for this requirement, then please
  make sure it is included in your last update to `REFLECTION.md`.

* **Extra Credit 2 (5 points):** Add a [high score table](https://en.wikipedia.org/wiki/Score_(game)#High_score)
  to your application, accessible via your application's menu (menu bar or otherwise).
  The table needs to actually keep track of the high scores for each game and include
  player initials. This may involve modifications in other areas of your application to
  accomodate this. In order to receive full credit for this extra credit functional
  requirement, the high score table must persist over time and over separate executions
  of your application. If you want the grader to check for this requirement, then please
  make sure it is included in your last update to `REFLECTION.md`.
  
* **Extra Credit 3 (5 points):** Submitted team application before the original
  deadline of **FRI 2018-11-16 @ 11:55 PM**. If you want the grader to check for 
  this requirement, then please make sure it is included in your last update to 
  `REFLECTION.md`. Just to be clear: we will only check our records to confirm
  your team application submission date/time if you mention it in your 
  `REFLECTION.md`.

### Non-Functional Requirements

A non-functional requirement is *subtracted* from your point total if
not satisfied. In order to emphasize the importance of these requirements,
non-compliance results in the full point amount being subtracted from your
point total. That is, they are all or nothing. 

* **(100 points) Team Application:** Team membership before the team application
  deadline is required. Furthermore, you must adhere to the policies outlined
  in the team application. Deviations will very likely result in this non-functional requirement
  being unsatisfied. If you have any problems with regard to this requirement, 
  then please contact the CSCI 1302 Support Team by sending a private post to 
  "Instructors" via the course Piazza as soon as possible.
  
* **(100 points) Project Structure:** The location of the default
  package for the source code should be a direct subdirectory called `src/main/java`.
  When the project is compiled using Maven, the the default package for compiled 
  code should be `target/classes`. 
  
  If you follow this structure, then you might type the following to compile 
  your code, assuming you are in the top-level project directory:
  ```
  $ mvn compile
  ```
  
  The driver class should be `cs1302/arcade/ArcadeApp`. 

* **(100 points) Development Environment:** This project must be implemented 
  in Java 8, and it *must compile and run* correctly on Nike using the specific
  version of Java 8 that is setup according to the instructions provided
  by your instructor (usually provided in the first homework assignment).
  
* **(100 points) No Static Variables:** Use of static variables is 
  not allowed for this assignment. Static constants are allowed. 
  
* **(100 points) No FXML or use of Scene Builder:** FXML and SceneBuilder
  are advanced tools that are not currently covered in this course. Use of
  either for this project is prohibited. Please note that the project is
  not necesarily easier with these tools. In most cases, they actually make the
  project harder, especially since those topics have not been covered.
  
* **(25 points) User-Friendly Experience:** Except for reasonable delays resulting from X forwarding, 
  your application should not hang/freeze or crash during execution.
  
* **(25 points) Code Style Guidelines:** You should be consistent with the style 
  aspect of your code in order to promote readability. Besides consistency, the
  following conventions will be enforced:
  
  * **Reference type names are written in _UpperCamelCase_.** Class names are  
    typically nouns or noun phrases. For example, `Character` or `ImmutableList`. 
    Interface names may also be nouns or noun phrases (for example, `List`), but 
    may sometimes be adjectives or adjective phrases instead (for example, 
    `Readable`).
  
  * **Method names are written in _lowerCamelCase_.** Method names are also 
    typically verbs or verb phrases. For example, `sendMessage` or `stop`.
  
  * **Braces are always used where optional.** Braces should be used with `if`, 
    `else`, `for`, `do`, and `while` statements, even when the body is empty or 
    contains only a single statement. Single line lambda expressions are
    permitted. 
    
  * **Column limit: 100.** You should limit the number of characters, including
    whitespace, on any given line to 100 characters. Except as noted below, any 
    line that would exceed this limit must be manually line-wrapped in a
    consistent manner. Exceptions to the column limit include:
    
    * Lines where obeying the column limit is not possible (for example, a long 
      URL in Javadoc, or a long JSNI method reference).
    * In `package` and `import` statements.
    * Command line input examples in a comment that may be cut-and-pasted into 
      a shell.
      
  * **Method height <= window height.** You should limit the number of lines for
    a method so that the entire method can be seen on the screen at once. This
    includes the line(s) with the method's signature and opening curly brace, all
    lines in the body of the mthod (including blank lines), and the line with
    the method's ending curly brace. 
    
    Of all the style guidelines, this is the probably the most subjective and 
    hardest to grade because everyone might have a different window size due
    to different terminal emulator and physical screen size configurations. 
    Therefore, graders will be checking for compliance with the spirit
    of this guideline, which is: methods that are too big and/or repetitive 
    should be refactored to include proper looping constructs and/or broken
    up into smaller methods to improve readability. 

* **(25 points) Javadoc Documentation:** Each method and class needs to be fully
  documented using Javadoc comments. Your comment should provide a description
  of the method's functionality in the first sentence of the comment.  This sentence
  needs to be a gramatically correct English sentence with proper punctuation. Further 
  description can be provided in subsequent sentence. The basic formatting of Javadoc 
  blocks is as seen in this example:
  ```java
  /**
   * Multiple lines of Javadoc text are written here,
   * wrapped normally...
   */
  public int method(String p1) { ... }
  ```
  ... or in this single-line example:
  ```java
  /** An especially short bit of Javadoc. */
  ```
  All method parameters and exceptions need to be documented.
  More information about Javadoc can be found
  [here](https://docs.oracle.com/javase/8/docs/technotes/tools/unix/javadoc.html).

* **(25 points) In-line Documentation:** Code blocks should be adequately documented
  using in-line comments. This is especially necessary when a block of code
  is not immediately understood by a reader (e.g., yourself or the grader).
  
* **(25 points) Attribution:** Proper attribution should be given for all assets (e.g.,
  art, sound, music, etc.) that is not authored by members of your project team. 
  You may consider making an `ATTRIBUTIONS.md` file that contains this information.  
  
* **(30 points; 10 points each) Reflection Updates:** Before each submission
  deadline mentioned towards the beginning of this document, you
  will need to update your project's `REFLECTION.md` file to include a new 
  section describing: i) what work has been done; ii) what work do you plan
  to complete before the next deadline (except for the last submission); and 
  what problems, if any, you have encountered related to this project.
  These changes, including your work in progress, must be submitted 
  according to the submission instructions before each deadline for them 
  to count.

### Grading

The graders will compile and run your code on Nike using Maven (likely via
the provided `Makefile`). They will test
each of the functional and non-functional requirements and total up the points
earned. This project is worth 100 points. Students have an opportunity to earn
an additional 15 points via extra credit. 

## How to Download the Project

On Nike, execute the following terminal command in order to download the project
files into sub-directory within your present working directory:

```
$ git clone https://github.com/cs1302uga/cs1302-arcade.git
```

This should create a directory called <code>cs1302-arcade</code> in
your present working directory that contains the project files.

If any updates to the project files are announced by your instructor, you can
merge those changes into your copy by changing into your project's directory
on Nike and issuing the following terminal command:

```
$ git pull
```

If you have any problems with any of these procedures, then please contact
your instructor.

## Submission Instructions

You will be submitting your project via Nike before the deadline indicated
near the top of this document. Make sure your project files are on 
`nike.cs.uga.edu`. Change into the parent directory of your project directory. 
If you've followed the instructions provided in this document, then the name 
of your project directory is likely `cs1302-arcade`. 
While in your project's parent directory, execute the following command: 
```
$ submit cs1302-arcade cs1302a
```

It is also a good idea to email a copy to yourself. To do this, simply execute 
the following command, replacing the email address with your email address:
```
$ tar zcvf cs1302-arcade.tar.gz cs1302-arcade
$ mutt -s "[cs1302] cs1302-arcade" -a cs1302-arcade.tar.gz -- your@email.com < /dev/null
```

If you have any problems submitting your project, then please contact the CSCI
1302 Support Team by sending a private post to "Instructors" via the course 
Piazza as soon as possible. 

# Appendix - Useful Links

## JavaFX 8

* [Package: `javafx`](https://docs.oracle.com/javase/8/javafx/api/toc.htm)
* [JavaFX CSS Reference Guide](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/doc-files/cssref.html)
* [Styling UI Controls with CSS](https://docs.oracle.com/javase/8/javafx/user-interface-tutorial/apply-css.htm)

# Appendix - FAQ

Below are some frequently asked questions related to this project.

1. **How do I make a code snippet execute repeatedly with a delay between executions?**

   The easiest way to accomplish this in a JavaFX application is using the
   [`Timeline`](https://docs.oracle.com/javase/8/javafx/api/javafx/animation/Timeline.html) 
   and [`KeyFrame`](https://docs.oracle.com/javase/8/javafx/api/javafx/animation/KeyFrame.html) 
   classes. Here is an example that prints the current time (using 
   [`LocalTime`](https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html)) to 
   standard output every two (2) seconds (specified using
   [`Duration`](https://docs.oracle.com/javase/8/javafx/api/javafx/util/Duration.html)), indefinitely:
   ```java
   EventHandler<ActionEvent> handler = event -> System.out.println(LocalTime.now());
   KeyFrame keyFrame = new KeyFrame(Duration.seconds(2), handler);
   TimeLine timeline = new Timeline();
   timeline.setCycleCount(Timeline.INDEFINITE);
   timeline.getKeyFrames().add(keyFrame);
   timeline.play();
   ```
   The `Timeline` object also has a `pause` method to pause the execution of the timeline.

2. **How do I make my game run at *x* frames per second (e.g., 60 FPS)?**

   If you are using a single `Timeline` object for your main game loop, then duration of all
   key frames in the main game loop should sum to exactly `1000 / x` ms (e.g., 
   `Duration.ofMillis(1000 / 60)`). 
   The easiest way to ensure this is to have only one key frame with that duration.

3. **What is a good GUI container for games?**

   You already know that you can setup your scene graph however you want by using and nesting
   different types of layour panes. If you need explicit control over the `x` and `y` positions
   of some nodes, then I reccommend using the 
   [`Group`](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Group.html) class.
   Since `Group` is subsumed by `Node`, you should be able to add a `Group` object anywhere in
   your scene graph just like any other node.
   
4. **How do I setup event handlers related to mouse and keyboard events?**

   Look at the Javadoc documentation for the 
   [`Node`](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Node.html) class,
   specifically the methods that start with `setOnMouse` and `setOnKey`, to see the 
   different types of mouse and keyboard events you can handle. Here is a simple example 
   that prints the current time (using 
   [`LocalTime`](https://docs.oracle.com/javase/8/docs/api/java/time/LocalTime.html)) to 
   standard output when a user clicks on an `ImageView` object (referenced by `iv`) that 
   is assumed to be visible within the current scene graph:
   ```java
   iv.setOnMouseClicked(event -> System.out.println(LocalTime.now()));
   ```
   Remember, you can setup these event handlers for any node in the scene graph, including
   the containers.
   
5. **How can I detect if two nodes in my scene collide?**

   Look at the "Bounding Rectangles" section in the Javadoc documentation for the 
   [`Node`](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/Node.html) class.
   The getter methods described in that section return references to 
   [`Bounds`](https://docs.oracle.com/javase/8/javafx/api/javafx/geometry/Bounds.html)
   objects, which likely contain useful information regarding the whereabouts of
   node. I would reccommend taking a very close look at the methods in that class.
   
6. **How do I add sound?**

   While JavaFX does support audio playback of various formats, this feature is not
   currently available over X11 forwarding from Nike. If you incorporate audio into
   your application, then take measures to properly deal with the unchecked exceptions
   that might get thrown if audio playback is not available. 
   
7. **How do I make basic shapes appear?**

   Look at the classes in the 
   [`javafx.scene.shape`](https://docs.oracle.com/javase/8/javafx/api/javafx/scene/shape/package-summary.html)
   package. 

Have a question? Please post it on the course Piazza.

<hr/>

[![License: CC BY-NC-ND 4.0](https://img.shields.io/badge/License-CC%20BY--NC--ND%204.0-lightgrey.svg)](http://creativecommons.org/licenses/by-nc-nd/4.0/)

<small>
Copyright &copy; Michael E. Cotterell and the University of Georgia.
This work is licensed under a <a rel="license" href="http://creativecommons.org/licenses/by-nc-nd/4.0/">Creative Commons Attribution-NonCommercial-NoDerivatives 4.0 International License</a> to students and the public.
The content and opinions expressed on this Web page do not necessarily reflect the views of nor are they endorsed by the University of Georgia or the University System of Georgia.
</small>
