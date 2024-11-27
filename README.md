# MineSweeper
Mine Sweeper Game

Game Rules:

1. The game is text-based.

2. The project should be done using two-dimensional arrays.
   
3. It should be designed within the MineSweeper class. Code duplication should be prevented by using methods.
   
4. The matrix size, that is, the number of rows and columns, should be determined by the user. A minimum of 2x2 matrix entry should be allowed, and the user should be warned for values ​​smaller than 2x2 and asked to enter rows and columns again.
   
5. A quarter of the number of elements in the array (number of elements / 4) of random mines should be placed. The number of mines should not be less than or more than number of elements/4. For example, if the array is 4x3 in size, the number of elements should be calculated with the formula (number of rows * number of columns) and its size will be 12. In this case, the number of mines should be 12 / 4 = 3. It should not be less than or more than 3.
   
6. Hint: It will make your job easier if 2-dimensional arrays are in the string data type. You should define an array that will hold the locations of the mines and a separate array that you will show to the player.

7. You should show the boxes that have never been opened on the map shown to the player with the "-" symbol.

8. Mines should be shown with the "*" symbol. Do not use different symbols.

9. The user should select a point from the matrix and be asked to enter the row and column values ​​for the point selection.

10. It should be checked whether the selected point is within the boundaries of the array and if the condition is not met, a warning text should be printed on the console and the user should be asked for a new coordinate again.

11. When a previously entered coordinate is entered, the user should be shown a warning saying "this coordinate has been selected before, enter another coordinate" and a new entry should be made.

12. If there is a mine at the point entered by the user, the game should be lost. A message should be shown on the console accordingly.

13. If there is no mine at the point entered by the user, all neighboring locations around the point should be looked at (right, left, above, below, upper left diagonal, upper right diagonal, lower right diagonal, lower left diagonal) and the sum of the number of mines at these neighboring points should be written to the coordinate entered by the user. If there is no mine touching the point, the value "0" should be written. Do not use different values ​​and symbols.

14. If the user opens all points without stepping on any mines, he should win the game. In this case, the appropriate message should be displayed on the console.
