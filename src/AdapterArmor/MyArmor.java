package AdapterArmor;
public class MyArmor implements Armor{
    private int armor;

    public MyArmor(int armor){
        this.armor=armor;
    }

    @Override
    public double getArmor() {
        return this.armor;
    }
}
