package GameState;

import SyntaxofGrammar.AST.NodeExpr;

import java.util.ArrayList;

public class Territory implements ActionPlan {
    private final Player p1;
    private final Player p2;
    private Region crew;
    private int CurrentTurn;
    private Player CurrentPlayer;
    private ArrayList<NodeExpr> territoty;

    public Territory(Player p1,Player p2){
        this.p1 = p1;
        this.p2 = p2;
        territoty = new ArrayList<>();
        CurrentTurn = 1;
        CurrentPlayer = this.p1;
    }


    @Override
    public void Relocate() {
        if(CurrentPlayer.PlayerBudget() >= 1){
            CurrentPlayer.BudgetUp(-1);
        }
    }

    @Override
    public void Invest(int cash) {
        if(CurrentPlayer.PlayerBudget() >= 1){
            CurrentPlayer.BudgetUp(-1);
        }
    }

    @Override
    public void Move(Direction direction) {
        if(CurrentPlayer.PlayerBudget() >= 1){
            CurrentPlayer.BudgetUp(-1);
        }
    }

    @Override
    public void Collect(int cash) {
        if(CurrentPlayer.PlayerBudget() >= 1){
            CurrentPlayer.BudgetUp(-1);
        }
    }

    @Override
    public void Shoot(Direction direction, int cash) {
        if(CurrentPlayer.PlayerBudget() >= 1){
            CurrentPlayer.BudgetUp(-1);
        }
    }

    @Override
    public void Opponent() {

    }

    @Override
    public void Nearby() {

    }
}
