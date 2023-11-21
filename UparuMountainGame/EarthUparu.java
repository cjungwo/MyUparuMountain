package UparuMountainGame;

public class EarthUparu extends Uparu{
    double attackValue = 10;
    double defenceValue = 10;

    public EarthUparu(String name, double moneyPerSecond, int price) {
        super(name, moneyPerSecond, price);
        property = Property.Earth;
    }

    public void setAttackValue(int level) {
        attackValue = (attackValue - 3) * level;
    }

    public void setDefenceValue(int level) {
        defenceValue = (attackValue + 3) * level + 4;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nAttack: " + attackValue +
                "\nDefence: " + defenceValue +
                "\n-------------------------";
    }
}
