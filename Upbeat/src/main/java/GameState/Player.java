package GameState;

public class Player {
    private String name;
    private long budget;
    private CityCenter cityCenter;

    private int Hp;

    public Player(String name, long budget,CityCenter cityCenter){
        this.name = name;
        this.budget = budget;
        this.cityCenter = cityCenter;
    }

    public String PlayerName(){
        return name;
    }

    public int PlayerBudget(){
        return (int)budget;
    }

    public int BudgetUp(int cash){
        this.budget += cash;
        return (int)this.budget;
    }

    public CityCenter PlayerCityCenter(){
        return cityCenter;
    }

}
