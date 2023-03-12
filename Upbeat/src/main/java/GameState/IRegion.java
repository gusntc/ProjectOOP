package GameState;

public interface IRegion {
    public int RegionPosition();
    public int RegionCol();
    public int RegionRow();
    public int RegionDeposit();
    public void DepositUp(int cash);
    public Player UpOwner(Player owner);
}
