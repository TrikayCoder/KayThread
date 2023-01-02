package org.example;

import KayThread.KayThread;
import KayThread.KayThreadInterface;

import java.util.ArrayList;

public class Main {
    private static int x;
    public static void main(String[] args) {
        KayThread kayThread = new KayThread();
        int id1 = kayThread.start(new KayThreadInterface() {
            @Override
            public void kayRun() {
              for(int i=0; i< 5; i++){
                  System.out.println("1: " + i);
              }
            }

            @Override
            public void kayFinish(int id) {
                System.out.println("id1=: " + id);
                System.out.println("========: " + KayThread.getKayThreadHashMap().size());
            }
        });

        int id2 = kayThread.start(new KayThreadInterface() {
            @Override
            public void kayRun() {
                for(int i=0; i< 10; i++){
                    System.out.println("2: " + i);
                }
            }

            @Override
            public void kayFinish(int id) {
                System.out.println("id2=: " + id);
                System.out.println("========: " + KayThread.getKayThreadHashMap().size());
            }
        });
//        ArrayList<Integer> arrayList = new ArrayList<>();
//        arrayList.add(id2);
//        arrayList.add(id1);
//        KayThread.synchronizeThreads(arrayList);
    }
}