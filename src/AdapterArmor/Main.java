package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        MyArmor myArmor=new MyArmor(20);
        ToHPImplementation toHPImplementation=new ToHPImplementation(myArmor);
        System.out.println(toHPImplementation.getArmorHPValue());
    }
}
