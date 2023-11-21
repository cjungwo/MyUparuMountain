package UparuMountainGame;

public class WaterUparu extends Uparu{
    double attackValue = 10;
    double defenceValue = 10;

    public WaterUparu(String name, double moneyPerSecond, int price) {
        super(name, moneyPerSecond, price);
        property = Property.Water;
    }

    public void setAttackValue(int level) {
        attackValue = attackValue * level;
    }

    public void setDefenceValue(int level) {
        defenceValue = (attackValue + 4) * level - 1;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nAttack: " + attackValue +
                "\nDefence: " + defenceValue +
                "\n-------------------------";
    }
}
