package org.example;

/*

class Cuenta {
    private double saldo;

    public Cuenta() {
        this.saldo = 10000;
    }

    public void depositar(double cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("No se puede depositar una cantidad negativa.");
        } else if (cantidad == 0) {
            throw new IllegalArgumentException("No se puede depositar 0 euros.");
        } else {
            saldo += cantidad;
            System.out.println("Depósito de " + cantidad + " euros. Saldo actual: " + saldo + " euros.");
        }
    }

    public void retirar(double cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("No se puede retirar una cantidad negativa.");
        } else if (cantidad == 0) {
            throw new IllegalArgumentException("No se puede retirar 0 euros.");
        } else if (cantidad > saldo) {
            throw new IllegalArgumentException("No se puede retirar más dinero del que hay en la cuenta.");
        } else {
            saldo -= cantidad;
            System.out.println("Retiro de " + cantidad + " euros. Saldo actual: " + saldo + " euros.");
        }
    }

    public double obtenerSaldo() {
        return saldo;
    }
}

 */

import java.util.concurrent.atomic.AtomicInteger;

class Cuenta {
    private AtomicInteger saldo = new AtomicInteger(10000);

    public void depositar(int cantidad) {
        saldo.addAndGet(cantidad);
    }

    public void retirar(int cantidad) {
        saldo.addAndGet(-cantidad);
    }

    public int obtenerSaldo() {
        return saldo.get();
    }
}

