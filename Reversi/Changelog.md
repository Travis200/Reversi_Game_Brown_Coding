**Changelog**

Date: 17/03/20  
Class: MoveCheckerTest  
```import uk.ac.ncl.entity.Cell``` &rarr; ```import uk.ac.ncl.entity.Cell;```

Date: 17/03/20  
Class: MoveChecker  
Method: getFinalScore
```else if this.cells[row][column].getValue() == CellStatus.DARK```   
&darr;   
```else if (this.cells[row][column].getValue() == CellStatus.DARK)```

Date: 17/03/20  
Class: Cell  
```public int getRow() {return column; }``` &rarr; ```public int getRow() {return row; }```

Date: 24/03/20  
Class: MoveCheckerTest  
Method: findPotentialMoves
```(CellStatus.DARK)``` &rarr; ```(CellStatus.GRAY)```

Date: 24/03/20  
Class: MoveCheckerTest   
Method: findPotentialMoves   
```grayCells.size() == 5``` &rarr; ```grayCells.size() == 4```

Date: 24/03/20  
Class: MoveChecker
Constructor: MoveChecker  
Added in ```this.cells = cells;``` into the constructor

Date: 24/03/20  
Class: MoveChecker  
Method: findPotentialMoves  
Changed ```i <= BOARD_SIZE``` &rarr; ```i < BOARD_SIZE```
in for loops

Date: 24/03/20  
Class: Cell  
Method: isLegal  
```d_col += dir[0];``` &rarr; ```d_col += dir[1];```

Date: 24/03/20  
Class: Cell  
Method: isLegal  
Added break statements into while loop

Date: 11/04/20  
Class: MoveChecker  
Method: flipPieces  
Changed ```&&``` &rarr; ```||``` in the while loop condition

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
    
Date: 13/04/20  
Class: MoveChecker  
Method: flipPieces  
Added ```cells[d_row][d_col].setValue(colour);``` into for loop. 

Date: 15/04/20  
Class: MoveChecker  
Method: flipPieces  
Added and changed code so that pieces flip correctly (including so that the pieces of opposite colour between two pieces 
of the same colour flip automatically). However there is a bug that causes the program to sometimes crash when pieces 
on the edge of the board are flipped.  
Also removed ```while (d_col != move.getCell().getColumn() || d_row != move.getCell().getRow())```

Date: 16/04/20  
Class: Cell  
Method: isLegal  
Changed ```if (0 <= d_col &&  d_col < BOARD_SIZE && 0 <=  d_row
&& cells[d_row][d_col].getValue() != CellStatus.EMPTY)```  
&darr;  
```if if (0 <= d_col &&  d_col < 8 && 0 <=  d_row && d_row < 8```
```&& cells[d_row][d_col].getValue() != CellStatus.EMPTY)``` 



    

