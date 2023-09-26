package org.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Lanzador {
    public static void main(String[] args) {
        Cuenta cuenta = new Cuenta();

        int numOperaciones100 = 400;
        int numOperaciones50 = 200;
        int numOperaciones20 = 600;

        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < numOperaciones100; i++) {
            executor.execute(new HiloCliente(cuenta, 100, true));
        }

        for (int i = 0; i < numOperaciones50; i++) {
            executor.execute(new HiloCliente(cuenta, 50, true));
        }

        for (int i = 0; i < numOperaciones20; i++) {
            executor.execute(new HiloCliente(cuenta, 20, true));
        }

        for (int i = 0; i < numOperaciones100; i++) {
            executor.execute(new HiloCliente(cuenta, 100, false));
        }

        for (int i = 0; i < numOperaciones50; i++) {
            executor.execute(new HiloCliente(cuenta, 50, false));
        }

        for (int i = 0; i < numOperaciones20; i++) {
            executor.execute(new HiloCliente(cuenta, 20, false));
        }

        executor.shutdown();
        try {
            executor.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int saldoFinal = cuenta.obtenerSaldo();
        if (saldoFinal == 10000) {
            System.out.println("La simulación ha terminado correctamente. Saldo final: " + saldoFinal);
        } else {
            System.out.println("La simulación ha fallado. Saldo final: " + saldoFinal);
        }
    }
}