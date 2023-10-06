package com.giordanacontini;

import java.util.Scanner;

public class Sistema {
    public static void main(String[] args) {
        ContaBancaria contaBancaria = new ContaBancaria(100, "Giordana", 200);

        ContaBancaria.menu();

        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        do {

            switch (opcao) {
                case 1:
                    System.out.println("Informe o valor para deposito: ");
                    double valorDeposito = scanner.nextDouble();
                    contaBancaria.depositar(valorDeposito);
                    break;
                case 2:
                    System.out.println("Informe o valor que deseja sacar: ");
                    double valorSacar = scanner.nextDouble();
                    contaBancaria.sacar(valorSacar);
                    break;
                case 3:
                    System.out.println("Seu saldo é de: " + contaBancaria.getSaldo());
                    System.out.println("Seu limite é de: " + contaBancaria.getLimite());
                    contaBancaria.getSaldo();
                    contaBancaria.getLimite();
                    break;
                case 4:
                    System.out.println("Saindo do programa. Até logo!");
                    break;
                default:
                    System.out.println("Opção invalida. Tente novamente");
                    break;
            }

            System.out.println("O que deseja fazer a seguir? ");
            opcao = scanner.nextInt();

        } while (opcao != 4);

    }
}
