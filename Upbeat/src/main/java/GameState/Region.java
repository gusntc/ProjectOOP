package GameState;

import SyntaxofGrammar.AST.NodeCollect;

import java.util.LinkedList;

public class Region implements IRegion{
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
    @Override
    public int RegionPosition(){
        return  CrewPos;
    }
    @Override
    public int RegionCol(){
        return col;
    }
    @Override
    public int RegionRow(){
        return row;
    }
    @Override
    public int RegionDeposit(){
        return (int)deposit;
    }
    @Override
    public void DepositUp(int cash){
        deposit += cash;
    }
    @Override
    public Player UpOwner(Player owner){
        this.owner = owner;
        return this.owner;
    }

}
