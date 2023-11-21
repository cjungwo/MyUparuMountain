package UparuMountainGame;

public class PlantUparu extends Uparu{
    double attackValue = 10;
    double defenceValue = 10;

    public PlantUparu(String name, double moneyPerSecond, int price) {
        super(name, moneyPerSecond, price);
        property = Property.Plant;
    }

    public void setAttackValue(int level) {
        this.attackValue *= level;
    }
    public void setDefenceValue(int level) {
        this.defenceValue *= level;
    }

    @Override
    public String toString() {
        return super.toString() + 
        "\nAttack: " + attackValue +
        "\nDefence: " + defenceValue +
        "\n-------------------------";
    }
}
