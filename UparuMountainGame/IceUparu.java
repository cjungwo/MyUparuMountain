package UparuMountainGame;

public class IceUparu extends Uparu{
    double attackValue = 10;
    double defenceValue = 10;

    public IceUparu(String name, double moneyPerSecond, int price) {
        super(name, moneyPerSecond, price);
        property = Property.Ice;
    }

    public void setAttackValue(int level) {
        attackValue = (attackValue + 2) * level;
    }

    public void setDefenceValue(int level) {
        defenceValue = (attackValue + 5) * level;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nAttack: " + attackValue +
                "\nDefence: " + defenceValue +
                "\n-------------------------";
    }
}
