**Changelog**

Date: 17/03/20  
Class: MoveCheckerTest  
Changed:  
```import uk.ac.ncl.entity.Cell``` &rarr; ```import uk.ac.ncl.entity.Cell;```

Date: 17/03/20  
Class: MoveChecker  
Method: getFinalScore  
Changed:  
```else if this.cells[row][column].getValue() == CellStatus.DARK```   
&darr;   
```else if (this.cells[row][column].getValue() == CellStatus.DARK)```

Date: 17/03/20  
Class: Cell  
Changed:       
```public int getRow() {return column; }```   
&darr;   
```public int getRow() {return row; }```

Date: 24/03/20  
Class: MoveCheckerTest  
Method: findPotentialMoves  
Changed:  
```(CellStatus.DARK)``` &rarr; ```(CellStatus.GRAY)```

Date: 24/03/20  
Class: MoveCheckerTest   
Method: findPotentialMoves  
Changed:   
```grayCells.size() == 5``` &rarr; ```grayCells.size() == 4```

Date: 24/03/20  
Class: MoveChecker  
Constructor: MoveChecker  
Changed:  
Added in ```this.cells = cells;``` into the constructor

Date: 24/03/20  
Class: MoveChecker  
Method: findPotentialMoves  
Changed ```i <= BOARD_SIZE``` &rarr; ```i < BOARD_SIZE```
in for loops.

Date: 24/03/20  
Class: Cell  
Method: isLegal 
Changed:   
```d_col += dir[0];``` &rarr; ```d_col += dir[1];```

Date: 24/03/20  
Class: Cell  
Method: isLegal    
Added break statements into while loop.

Date: 11/04/20  
Class: MoveChecker  
Method: flipPieces  
Changed ```&&``` &rarr; ```||``` in the while loop condition.

Date: 11/04/20  
Class: Cell  
Method: isLegal  
Removed element ```{0, 0}``` from ```DIRS``` 2D array. 

Date: 11/04/20  
Class: MoveChecker  
Method: generateOpponent  
Changed:  
```ArrayList<Cell> potentialMoves = findPotentialMoves(CellStatus.DARK)```   
&darr;  
```ArrayList<Cell> potentialMoves = null;```    
    ```if (cellStatus == DARK) {```    
        ```potentialMoves = findPotentialMoves(CellStatus.DARK);```    
    ```}```          
    ```else if (cellStatus == LIGHT) {```     
        ```potentialMoves = findPotentialMoves(CellStatus.LIGHT);```    
    ```}```  
Note: On the 20/04/20 I replaced the if/else statement with ```potentialMoves = findPotentialMoves(cellStatus);```
as I realised this would be a more efficient way of writing the code. I also removed ```= null``` from the 
potentialMoves array list as this is redundant. 
    
Date: 13/04/20  
Class: MoveChecker  
Method: flipPieces  
Added ```cells[d_row][d_col].setValue(colour);``` into for loop. 

Date: 15/04/20  
Class: MoveChecker  
Method: flipPieces  
Added and changed code so that pieces flip correctly (including so that multiple pieces of opposite colour between two pieces 
of the same colour flip automatically). However there is a bug that causes the program to sometimes crash when pieces 
on the edge of the board are flipped.  
Also removed ```while (d_col != move.getCell().getColumn() || d_row != move.getCell().getRow())```

Date: 16/04/20  
Class: Cell  
Method: isLegal  
Changed ```if (0 <= d_col &&  d_col < BOARD_SIZE && 0 <=  d_row
&& cells[d_row][d_col].getValue() != CellStatus.EMPTY)```  
&darr;  
```if (0 <= d_col &&  d_col < 8 && 0 <=  d_row && d_row < 8```
```&& cells[d_row][d_col].getValue() != CellStatus.EMPTY)```   
Note: on the 20/04/20 I later changed ```8``` &rarr; ```BOARD_SIZE``` to improve the versatility of the code. 


Date: 19/04/20  
Class: MoveChecker   
Method: flipCheckers  
Created pause method which is called in the flipCheckers class so that there is a delay between flipping
so that the user can see what is happening between their and the opponents moves.

Date: 20/04/20  
Class: Cell   
Method: isLegal   
Changed:     
```if (cells[d_row][d_col].getValue() == colour)```  
&darr;  
```while (cells[d_row][d_col].getValue() == colour)```  
This fixes a bug so that now potential moves appear for where there is more than one of the opponents colours 
between the players and the space where there is a potential move whereas before they did not. 

Date: 20/04/20  
Class: MoveChecker   
Method: getFinalScore  
Changed:     
```else if (this.cells[column][row].getValue() == DARK)```    
&darr;   
```else if (this.cells[row][column].getValue() == DARK)```  
Also added else statement to wrap the code if the result not a draw.
Scoring system works correctly when the program is run however the getFinalScore test still fails.

Date: 20/04/20  
Class: MoveCheckerTest   
Method: getFinalScore  
Corrected bug in getFinalScore test. Added ```+ " pieces"``` to the String result. All tests now pass
except findPotentialMoves.

Date: 20/04/20  
Class: MoveCheckerTest   
Method: findPotentialMoves  
Corrected bug which I had created by mistake in the findPotentialMoves test. All tests now pass.    
Changed:     
```moveChecker.findPotentialMoves(CellStatus.GRAY);```  
&darr;  
```moveChecker.findPotentialMoves(CellStatus.DARK);```


