package GameState;

import SyntaxofGrammar.AST.NodeCollect;

import java.util.LinkedList;

public class Region {
    private long deposit;
    private long maxdeposit;
    private Player owner;
    private int col,row;
    private int CrewPos;

    public Region(int col,int row){
        this.CrewPos = col*row;
        this.col = col;
        this.row = row;
        deposit = 0;
        owner = null;
    }

    public int RegionPosition(){
        return  CrewPos;
    }

    public int RegionCol(){
        return col;
    }

    public int RegionRow(){
        return row;
    }

    public int RegionDeposit(){
        return (int)deposit;
    }

    public void DepositUp(int cash){
        deposit += cash;
    }

    public Player UpOwner(Player owner){
        this.owner = owner;
        return this.owner;
    }

    public Player Owner(){
        return this.owner;
    }

    public int RegionMaxDeposit(){
        return (int)maxdeposit;
    }

}
