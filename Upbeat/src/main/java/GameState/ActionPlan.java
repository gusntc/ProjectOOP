package GameState;

public interface ActionPlan {
    public void Relocate();
    public void Invest(int cash);
    public void Move(Direction direction);
    public void Collect(int cash);
    public void Shoot(Direction direction,int cash);
    public void Opponent();
    public void Nearby();
}
