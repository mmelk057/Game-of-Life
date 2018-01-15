/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.util.*;

/**
 *
 * @author Max
 */
public class GameOfLife {
    //declares variable for the game board, and it's respective number of rows and columns 
    int rows;
    int columns;
    int [][] gameBoard;
    /**
     * Constructor for GameOfLife Class
     * @param c integer for number of columns
     * @param r integer for number of rows
     */
    public GameOfLife(int c, int r){
    columns=c;
    rows=r;   
    gameBoard=new int [columns][rows];
    }
    //Life and death are binary
    //death is represented by the integer 0
    //life is represented by the integer 1
    final int death = 0;
    final int life =1;
    
    /**
     * set all cells in the board to a random state; either alive of dead.
     */
    public void generateInitialBoard(){
    Random r = new Random();
    for(int i=0;i<columns;i++){    
     for (int j=0;j<rows;j++){
     gameBoard[i][j]= r.nextInt(2);
     }   
    }
    }
    
    /**
     * All cells are dead and have a value of 0
     */
    public void clearBoard(){
    //goes through array and makes every cell's state as dead
    for(int i=0;i<columns;i++){    
     for (int j=0;j<rows;j++){
     gameBoard[i][j]=0;
     }   
    }   
    }
    
    /**
     * Generates a new board based on the rules of the Game Of Life. You must have generated an initial board before using this method. 
     * @return new board in the form of a 2d Array
     */
    public int[][] reGenerate(){
    //new board has the same dimensions as the initial board 
    int[][]nextGameBoard = new int[columns][rows];
    //loops through the cells in the middle of the board, not including edges
    //this is to avoid errors that may errupt concerning checking neighbouring cells around the edge cells
    for(int c=1;c<columns-1;c++){
      for(int r=1;r<rows-1;r++){
      //find how many neighbours each cell has for each cell coordinate
      //the neighbour count starts at zero
      int neighbours=0;
      //loops through the 8 cells around the cell being analysed
      for(int x=-1;x<=1;x++){
        for(int y=-1;y<=1;y++){
        //since a cell that's alive has a value of 1 and a dead cell has a value of zero, the values of all eight neighbouring cells will be added together
        neighbours+= gameBoard[c+x][r+y];    
        }  
      }
      //the total number of neighbouring cells automatically counts the value of the cell that's being analysed
      //therefore the total number of neighbouring cell needs to substract the value of the cell being analysed 
      neighbours-=gameBoard[c][r];
      //if the cell being analysed is alive and has less than two neighbours it dies
      if (gameBoard[c][r]==1 && neighbours<2){
      nextGameBoard[c][r]=death;    
      }
      //if the cell being analysed is alive and has more than than three neighbours it dies
      else if(gameBoard[c][r]==1 && neighbours>3){
      nextGameBoard[c][r]=death;    
      }
      //if the cell being analysed is dead and has exactly three neighbours, it it brought to life
      else if (gameBoard[c][r]==0 && neighbours==3){
      nextGameBoard[c][r]=life;    
      }
      //else, the cell being analysed will stay in the same state
      else {
      nextGameBoard[c][r]=gameBoard[c][r];    
      }
      }  
    }
    //the previous gameboard is replaced by the new one
    gameBoard=nextGameBoard;
    //return new gameboard
    return nextGameBoard;
    } 
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }
    
}
