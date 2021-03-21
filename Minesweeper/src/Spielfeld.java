import java.util.Random;

public class Spielfeld {
    public int boardSize;
    public int minefield[][];
    Random rnd = new Random();

    public Spielfeld(int boardSize){
        int mines = boardSize - 2;
        this.boardSize = boardSize;
        this.minefield = new int[boardSize][boardSize];

        initializeEmptyField(boardSize);
        placeMines(mines);
    }

    public void initializeEmptyField(int boardSize) {
        for(int i = 0; i < boardSize; i++) {
            for(int j = 0; j < boardSize; j++){
                this.minefield[i][j] = -1;
            }
        }
    }

    public void placeMines(int mines) {
        boolean bomb = false;
        int xRow;
        int yCol;

        while(mines>0) {
            xRow = rnd.nextInt(boardSize);
            yCol = rnd.nextInt(boardSize);
            //check for mines
            for(int i = xRow; i < this.minefield.length; i++){
                for(int j = yCol; j < this.minefield.length; j++){
                    if(this.minefield[j][i] == -2){
                        bomb = true;
                    }
                }
            }
            if(!bomb) { //if we haven't already placed a mine earlier here...
                this.minefield[yCol][xRow] = -2; //...we do so now...
                mines--; //...and decrease the number of mines we still need to place
            }
            bomb = false;
        }
    }

    void showField() {
        System.out.print("    ");
        for(int j = 1; j <= minefield.length; j++){
            System.out.print(j + "  ");
        }
        for(int i = 0; i < minefield.length; i++) {
            if(i >= 9) System.out.printf("\n " + (i+1));
            if(i < 9) System.out.printf("\n  " + (i+1));
            for(int j = 0; j < minefield.length; j++){
                if(minefield[i][j] > 0){
                    System.out.print(" " + minefield[i][j] + " ");
                } else if (minefield[i][j] == 0) {
                    System.out.print("   ");
                } else if (minefield[i][j] == -3) {
                    System.out.print(" * ");
                } else {
                    System.out.print(" ° ");
                }
            }
        }
        System.out.println();
    }


    boolean testeFeld(int row, int col) {
        if(minefield[row][col] < -1) return false;
        minefield[row][col] = 0;
        for(int i = row>0?row-1:row; i <= (row==minefield.length-1?row:row+1); i++) //check neighbours
            for(int j = col>0?col-1:col; j <= (col==minefield.length-1?col:col+1); j++)
                if(minefield[i][j] == -2) minefield[row][col]++;
        return true;
    }

    boolean testeMine(int row, int col) {
        if(minefield[row][col] != -2) return false;
        boolean res = true;
        for(int i = row>0?row-1:row; i <= (row==minefield.length-1?row:row+1); i++) //check neighbours
            for(int j = col>0?col-1:col; j <= (col==minefield.length-1?col:col+1); j++)
                if(minefield[i][j] == -1) res = false;
        if(res) minefield[row][col] = -3;
        return res;
    }

    public boolean move(int x, int y) {
        if(!testeFeld(y,x)) { //if it's a mine
            return false;
        }
        if(minefield[y][x] == 0) //if it's an empty space (i.e. no neighboured mines)
            for(int i = x>0?x-1:x; i <= (x==minefield.length-1?x:x+1); i++) //check neighbours
                for(int j = y>0?y-1:y; j <= (y==minefield.length-1?y:y+1); j++)
                    if(minefield[j][i] < 0) move(i,j); //recursive call to uncover the whole blank area
        for(int i = x>0?x-1:x; i <= (x==minefield.length-1?x:x+1); i++) //has the mine been fully discovered?
            for(int j = y>0?y-1:y; j <= (y==minefield.length-1?y:y+1); j++) testeMine(j,i);
        return true;
    }

    public int getSize() {
        return minefield.length;
    }

    public boolean playerHasWon() {
        for(int i = 0; i < minefield.length; i++) for(int j = 0; j < minefield.length; j++)
            if(minefield[j][i] == -2) return false;
        return true;
    }
}