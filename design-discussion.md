Design Discussion

IndividualDesign-XiangnanHe

Pro:
1) Concise and clear layout with detailed CryptogramStats relationships and attibutes in Cryptogram class are presented
2) Player meets all requirements and has solid attributes and operations by considering most of the requirements
3) Clear on the major classes to completeness of the attributes and methods
4) Use of lists to track completed, unsolved cryptograms, and players. Each player owns his or her own lists
5) Descriptive names for attirbutes and operations

Con:
1) Less clear on the interaction between the classes or subclasses due to crossing connections. Relationships need to be made based on association, used by sublclass etc.Missing proper connection between entities (should use the right arrow), could use different types of connections
2) No variables or return types, attributes and methods need datatypes
3) Need user to create a player or select one
4) SolveCryptogram doesn’t need a relationship to Player because Cryptogram has one.
5) Should remove the classes that have no attributes or methods. Not clear on smaller boxes whether they are classes or relationships.
6) Missing classes, such as User, and should put some of the method in players in User, such as create new player and choose a player8) 
7) Does not include multiplicity


Team-Design
"User" Class: 
1) A "User" class was built to manage the user activites. 
2) A method called "addPlayer()" was setup to be able to create a new player. 
3) A method called "playerLogin()" was added to be able to log in as specific player. 
4) A method called "usernameIsUnique()" was added with return type of boolean to be able to check if username is unique or not. 

"Player" Class: 
1) Attributes with type of tring was setup, including "firstName", "lastName", "username", "email" to represent player information
2) A method called "chooseCryptogram()" was setup to select the cryptogram to solve, with return type of Cryptogram. After choosing a cryptogram, its stats will be called through "Cryptogram" class "viewCryptogramStats()". So the players will have a view of the stats of the specific cryptogram.
3) A method called "viewCompleted" was added to view completed cryptograms
4) A method called "viewUnsolved" was added to view unsolved cryptograms
5) Data of the user, player, cryptogram, and etc, will be stored and managed through SQLlite.


