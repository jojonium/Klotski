# Klotski

A simple puzzle game implemented in Java using Swing. The purpose of this
project is to demonstrate the Entity-Boundary-Controller design paradigm in a
GUI application.

### How to run

Simply run the `main` method in the class Main

### How to play

The goal is to release the large 2x2 tile from the board through the opening
centered at the bottom of the board. To select a piece, click on it. Then it can
be moved in any direction with the arroy keys, WASD, HJKL, or the arrow buttons.
You can also move pieces by dragging them across the board with the mouse.

Only the large 2x2 tile can leave the board, so you must plan carefully to
complete the puzzle in the fewest moves.

To reset the board to its original state, use the "reset" button or press
ctrl-R. To quit the game, use the "quit" button, ctrl-Q, or simply close the
window.

You can save the current game state to a text file with ctrl-S, or read in a
board state from a properly formatted text file with ctrl-O.

There are four different starting configurations built-in, which can be selected
with ctrl-1 through ctrl-4.

### Testing

All my test cases are in the `test` folder, divided into packages the same way
as the `src` folder. The source code has 81.0% code coverage. 
