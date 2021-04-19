import java.util.Random;

public class Spielfeld {
    public int boardSize;
    public int[][] minefield;
    boolean[][] flags = new boolean[10][10];
    boolean[][] bombs = new boolean[10][10];
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
            //check for mines, when field has -2, then it's a mine there
            for(int i = xRow; i < this.minefield.length; i++){
                for(int j = yCol; j < this.minefield.length; j++){
                    if(this.minefield[j][i] == -2){
                        bomb = true;
                    }
                }
            }
            if(!bomb) { //if we haven't already placed a mine earlier here...
                this.minefield[yCol][xRow] = -2; //...we do so now...
                bombs[yCol][xRow] = true;
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
            //deals with XX-numbers instead of X-numbers
            if(i >= 9) System.out.print("\n " + (i+1));
            if(i < 9) System.out.print("\n  " + (i+1));
            for(int j = 0; j < minefield.length; j++){
                if(minefield[i][j] > 0){
                    System.out.print(" " + minefield[i][j] + " ");
                } else if (minefield[i][j] == 0) {
                    System.out.print("   ");
                } else if (flags[i][j]) {
                    System.out.print(" ! ");
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
        for(int i = row>0?row-1:row; i <= (row==minefield.length-1?row:row+1); i++)
            for(int j = col>0?col-1:col; j <= (col==minefield.length-1?col:col+1); j++)
                if(minefield[i][j] == -2){
                    minefield[row][col]++; //check neighbours++
                }
        return true;
    }

    public boolean move(char action, int x, int y) {
        if(action == 'f') {
            if(flags[y][x]) {
                flags[x][y] = false;
                return true;
            } else {
                flags[y][x] = true;
                bombs[y][x] = false;
                return true;
            }
        }
        if(!testeFeld(y,x)) return false; //if it's a mine
        if(minefield[y][x] == 0) //if it's an empty space (i.e. no neighboured mines)
            for(int i = x>0?x-1:x; i <= (x==minefield.length-1?x:x+1); i++) //check neighbours
                for(int j = y>0?y-1:y; j <= (y==minefield.length-1?y:y+1); j++)
                    if(minefield[j][i] < 0) move(action, i,j); //recursive call to uncover the whole blank area
        return true;
    }

    public int getSize() {
        return minefield.length;
    }

    public boolean playerHasWon() {
        for(int i = 0; i < minefield.length; i++)
            for(int j = 0; j < minefield.length; j++)
                if(bombs[j][i]) return false;
        return true;
    }
}