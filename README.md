>”This is no time to take your chips down. A million dollars isn’t cool, you know what’s cool?"
>”You?"
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
