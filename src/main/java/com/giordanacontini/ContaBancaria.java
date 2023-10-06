package com.giordanacontini;

public class ContaBancaria {
    private double saldo;
    private final String proprietario;
    private double limite;

    public ContaBancaria(double saldo, String proprietario, double limite) {
        this.saldo = saldo;
        this.proprietario = proprietario;
        this.limite = limite;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getProprietario() {
        return proprietario;
    }

    public double getLimite() {
        return limite;
    }

    public void depositar(double valor) {
        possuiValorPositivoParaOperacao(valor);
        this.saldo += valor;
    }

    public void sacar(double valor) {
        possuiValorPositivoParaOperacao(valor);

        if (!temSaldoSuficiente(valor)) {
            System.err.print("Não possui saldo o suficiente");
            throw new EstouroDeLimiteException("Limite insuficiente para a operação");
        }

        descontarValorSaldo(valor);
    }

    private void descontarValorSaldo(double valor) {
        this.saldo -= valor;
    }

    private static void possuiValorPositivoParaOperacao(double valor) {
        if (valor <= 0) {
            System.err.println("Saldo inválido");
            throw new IllegalArgumentException("Valor inválido para a operação requisitada");
        }
    }

    private boolean temSaldoSuficiente(double valor) {
        return (saldo - valor) >= -limite;
    }

    public static void menu() {
        System.out.println("|--------------------------------------------|");
        System.out.println("|                1. depositar                |");
        System.out.println("|                2. sacar                    |");
        System.out.println("|                3. exibir saldo e limite    |");
        System.out.println("|                4. sair                     |");
        System.out.println("|--------------------------------------------|");
    }
}