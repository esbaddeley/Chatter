>”This is no time to take your chips down. A million dollars isn’t cool, you know what’s cool "<br>
>”You?"<br>
>”A social network implemented in Java"
​
Chatter is a basic social network Command Line App built in Java.

### Installation

* Fork or Clone the repo on Github and clone down onto your local machine.
* Install Gradle if not already installed (brew install gradle) and
* Navigate to the main folder (/chatter) and run 'gradle dependencies' command to install dependencies.
* Navigate to /chatter/scr/main/java then run 'javac Chatter.java && java Chatter' to launch the command line app.

### Instructions/Features

When the app launches you will be presented with a menu of options. Key features are;

* Creating Users - you can create a user with a username and a handle
* Posting - you can add a post which will be added to the timeline of the current user (user most recently created)
* View - see who the other user's on the Platform are
* Posts - see the posts of any particular user by entering their name
* Subscribe - select a user to subscribe to
* Subscriptions - view the posts of all user's subscribed to
* Quit - Quit the app
​
### Technologies/Approach

* The app is built in Java using the Intellij IDEA IDE and the Gradle build management tool.
* Key functionality is tested using JUnit and Mockito

* I chose to the following classes to implement the key functionality:
    - Chatter, App launcher class
    - Chatter Interface, provides the command line interface for the application
    - Chatter App, controller passing information between the key Models and the Interface

    - User Repository, responsible for created, storing and updating users.
    - User class, responsible for storing information specific to each user (messages,      subscriptions)
    - Message class, responsible for storing information specific to each message
    - Message printer, responsible for printing message timelines

 * There are some elements to this design structure which I think could benefit from further refactoring, particular the User repository class which currently is also implementing functionality relating to the updating of messages.

### Challenges

* Learning and implementing a project in Java in a short timescale was a challenge, but working with the Intellij IDEA made development process considerably more streamlined.

* Working with a statically typed language when my previous coding experience was in a dynamically typed language was difficult, however explicitly declaring types ensures a greater focus on the interface between objects, and helps to improve the debugging process as more errors are picked during compilation.

* Working with the more complex data structures of Java also required a depper level of understanding of how I expected information to be used and accessed. This has helped to improve my understanding of key programming concepts and language constructs.

### Further Developments

* There are currently some edge cases that haven't been accounted for in the current version of the application, in addition to which i'd like to implement more CRUD functionality for both users and messages.

* Implementing an SQL database to persist the data in the application.

* Refactoring to focus on smaller classes with key responsibilities and the use of design patterns to rationalise design.


