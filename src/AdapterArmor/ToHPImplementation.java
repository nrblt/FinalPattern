package com.company;

public class ToHPImplementation implements ToHPAdapter{
    private MyArmor armor;
    public ToHPImplementation(MyArmor armor) {
        this.armor = armor;
    }

    @Override
    public double getArmorHPValue() {
        double sum = armor.getArmor() * 2;
        return sum;
    }
}
