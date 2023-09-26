package org.example;

class HiloCliente implements Runnable {
    private Cuenta cuenta;
    private int cantidad;
    private boolean deposito;

    public HiloCliente(Cuenta cuenta, int cantidad, boolean deposito) {
        this.cuenta = cuenta;
        this.cantidad = cantidad;
        this.deposito = deposito;
    }

    @Override
    public void run() {
        if (deposito) {
            cuenta.depositar(cantidad);
        } else {
            cuenta.retirar(cantidad);
        }
    }
}
