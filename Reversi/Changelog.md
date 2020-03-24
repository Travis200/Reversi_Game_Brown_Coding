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

Date 24/03/20  
Class: MoveCheckerTest  
Method: findPotentialMoves
```(CellStatus.DARK)``` &rarr; ```(CellStatus.GRAY)```
