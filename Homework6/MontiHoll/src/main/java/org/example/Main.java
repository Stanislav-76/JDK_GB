package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Boolean> result = new HashMap<>();
        Random random = new Random();

        for (int i = 0; i < 1000; i++) {
            List<Integer> startDoor = Arrays.asList(0,0,0);
            startDoor.set(random.nextInt(3),1);
            int selectDoor = random.nextInt(3);
            int openDoor = -1;
            while (openDoor == -1) {
                openDoor = random.nextInt(3);
                if(openDoor == selectDoor || startDoor.get(openDoor) == 1) {
                    openDoor = -1;
                }
            }
            if (i < 500){
                // Variant1 выбор не меняем
                result.put(i, startDoor.get(selectDoor) == 1);

            } else {
                // Variant2 меняем выбор
                result.put(i, startDoor.get(3-selectDoor-openDoor) == 1);
            }
        }
        int statsVariant1 = 0;
        int statsVariant2 = 0;
        for (int i = 0; i < 500; i++) {
            if(result.get(i).equals(true)) statsVariant1++;
        }
        for (int i = 500; i < 1000; i++) {
            if(result.get(i).equals(true)) statsVariant2++;
        }
        System.out.println("Стратегия 1 (не менять выбор) ≈ " + statsVariant1*100/500 + "%");
        System.out.println("Стратегия 2 (изменить выбор) ≈ " + statsVariant2*100/500 + "%");
    }
}