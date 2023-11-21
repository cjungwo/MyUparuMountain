package UparuMountainGame;

public class FireUparu extends Uparu{
    double attackValue = 10;
    double defenceValue = 10;

    public FireUparu(String name, double moneyPerSecond, int price) {
        super(name, moneyPerSecond, price);
        property = Property.Fire;
    }

    public void setAttackValue(int level) {
        attackValue = (attackValue+3)*level;
    }
    public void setDefenceValue(int level) {
        defenceValue = (attackValue-3)*level;
    }

    @Override
    public String toString() {
        return super.toString() + 
        "\nAttack: " + attackValue +
        "\nDefence: " + defenceValue +
        "\n-------------------------";
    }
}
