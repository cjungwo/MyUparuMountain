package UparuMountainGame;

public class WindUparu extends Uparu{
    double attackValue = 10;
    double defenceValue = 10;

    public WindUparu(String name, double moneyPerSecond, int price) {
        super(name, moneyPerSecond, price);
        property = Property.Wind;
    }

    public void setAttackValue(int level) {
        attackValue = (attackValue + 3) * level;
    }

    public void setDefenceValue(int level) {
        defenceValue = (defenceValue - 2) * level - 3;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nAttack: " + attackValue +
                "\nDefence: " + defenceValue +
                "\n-------------------------";
    }
}
