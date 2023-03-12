package GameState;

import SyntaxofGrammar.AST.NodeExpr;

import java.util.ArrayList;

public class Territory implements ActionPlan {
    private final Player p1;
    private final Player p2;
    private Region cityCrew;
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


    // default spent do action define = 1;

    @Override
    public void Relocate() {
        if(CurrentPlayer.PlayerBudget() < 1){
            return ;
        }else{
            CurrentPlayer.BudgetUp(-1);
            int distance = (int) Math.floor(Math.sqrt(Math.pow(CurrentPlayer.PlayerCityCenter().RegionRow() - cityCrew.RegionRow(), 2) + Math.pow(CurrentPlayer.PlayerCityCenter().RegionCol() - cityCrew.RegionCol(), 2)));
            if (distance < 0) distance = 1;
            int cost = 5 * distance + 10;
            if(CurrentPlayer.PlayerBudget() >= cost + 1){
                CurrentPlayer.PlayerCityCenter().UpOwner(null);
                cityCrew.UpOwner(CurrentPlayer);
                CurrentPlayer.UpCityCenter(cityCrew);

            }
        }
    }

    @Override
    public void Invest(int cash) {
        if(CurrentPlayer.PlayerBudget() < 1){
            return;
        }else{
            CurrentPlayer.BudgetUp(-1);
        }
    }

    @Override
    public void Move(Direction direction) {
        if(CurrentPlayer.PlayerBudget() < 1){
            return;
        }else{
            CurrentPlayer.BudgetUp(-1);
        }
    }

    @Override
    public void Collect(int cash) {
        if(CurrentPlayer.PlayerBudget() < 1){
            return;
        }else if(cash < 0){
            return;
        }else{
            CurrentPlayer.BudgetUp(-1);
            if(cash > cityCrew.RegionDeposit()){
                cityCrew.DepositUp(-cash);
                CurrentPlayer.BudgetUp(cash);
            }
            if(cityCrew.RegionDeposit() == 0){
                cityCrew.UpOwner(null);
            }
        }
    }

    @Override
    public void Shoot(Direction direction, int cash) {
        if(CurrentPlayer.PlayerBudget() < 1 || cash < 0 ){
            return;
        }else if(cash > CurrentPlayer.PlayerBudget()){
            return;
        }else{
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
