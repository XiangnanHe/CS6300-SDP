Requirements
1. A user will be able to choose to log in as a specific player or create a new player when starting the application.  For simplicity, any authentication is optional, and you may assume there is a single system running the application.
To realize this requirement, a Player class was built to incoporate all the user attributes and methods. A list was added to represent player lists. Player class will be able to refer to the player list to create a new player or log in as specific player.
2. The application will allow players to  (1) create a cryptogram, (2) choose a cryptogram to solve, (3) solve cryptograms, (4) view their list of completed cryptograms, and (5) view the list of cryptogram statistics.
To realize this requirement, a operation "Create a cryptogram", "Choose a cryptogram", "Solve cryptogram" was added in the user class as operations. "View the list of cryptogram statistics" was also added.
3. A cryptogram will have an encoded phrase (encoded with a simple substitution cipher), a solution, and a maximum number of allowed solution attempts.  A cryptogram will only encode alphabetic characters, but may include other characters (such as punctuation or white space) in the puzzle, which will remain unaltered.  Capitalization is preserved when encoded.
To realize this requirement, a "Cryptogram" class was built to include all the attributes and operations, such as name, datae created, solution phrase, max number of allowed attempts, and etc. 
4. To add a player, the user will enter the following player information:
	a. A first name
	b. A last name
	c. A unique username
	d. An email
To realize this requirement, a "Player" class was built to capture all the information as attributes.
5. To add a new cryptogram, a player will:
	a.Enter a unique cryptogram puzzle name.
	b.Enter a solution (unencoded) phrase.
	c.Choose different letters to pair with every letter present in the phrase.
	d.View the encoded phrase.
	e.Enter a maximum number of allowed solution attempts.
	f.Edit any of the above steps as necessary.
	g.Save the complete cryptogram.
	h.View a confirmation that the name assigned to the cryptogram is unique and return to the main menu.
To realize these requirement, a "cryptogram" class was built to capture these either as attributes or methods.
6. To choose and solve a cryptogram, a player will:
	a.Choose a cryptogram from a list of all unsolved cryptograms.
	b.View the chosen cryptogram and number of incorrect solution submissions (starting at 0 for a cryptogram that has not previously been attempted).
	c.Match the replacement and encrypted letters together, and view the resulting potential solution.
	d.When all letters in the puzzle are replaced and they are satisfied with the potential solution, submit their answer.
	e.Get a result indicating that the solution was successful, or incrementing the number of incorrect solution submissions if it was unsuccessful.
	f.At any point, the player may return to the list of unsolved cryptograms to try another.
	g.If the number of incorrect solution attempts increases to the maximum allowed number of solution attempts, they will get a result that the cryptogram game was lost, and this cryptogram will 	be moved to the completed list.
To realize these requirements, a "solve cryptogram" class was built to include all these methods.
7. The list of unsolved cryptograms will show the cryptogram’s name and the number of incorrect solution attempts (if any) for that player.
To realzie this requirement, a list was built to initiate and update the cryptogram's name and number of incorrect solution attempts for that player.
8. The list of completed cryptograms for that player will show the cryptogram’s name, whether it was successfully solved, and the date it was completed.
To realize this requirement, a list was built to initiate and update the cryptogram's name, whether it was sucessfully solved and date.
9. The list of cryptogram statistics will display a list of cryptograms in order of creation.  Choosing each cryptogram will display the date it was created, the number of players who have solved the cryptogram, and the username of the first three players to solve the cryptogram.
To realize this requirement, a Cryptogram Statistics class was built to include the attributes and operations, such as cryptogram name, dictionary of user and date when the cryptogram was solved by the user, and etc.
10. The User Interface (UI) must be intuitive and responsive.
This is not represented in my design, as it will be handled entirely within the GUI implementation.
11. The performance of the game should be such that players does not experience any considerable lag between their actions and the response of the game.
To realize this requirement, the solve cryptogram class was directly connected to the cryptogram list and able to update that as first thing without working on other things like updating cryptogram statistics, which will be done in a later time.


