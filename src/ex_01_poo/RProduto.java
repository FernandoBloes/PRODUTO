package ex_01_poo;

import java.util.Scanner;

public class RProduto {
    // Atributos da classe
    private String nome;
    private String marca;
    private double precoCusto;
    private double precoVenda;

    // Construtor
    public RProduto(String nome, String marca, double precoCusto, double precoVenda) {
        this.nome = nome;
        this.marca = marca;
        this.precoCusto = precoCusto;
        this.precoVenda = precoVenda;
    }

    // Método para calcular e retornar o lucro
    public double calcularLucro() {
        return precoVenda - precoCusto;
    }

    // Método para exibir os atributos do produto
    public void exibirProduto() {
        System.out.println("Nome do Produto: " + nome);
        System.out.println("Marca: " + marca);
        System.out.println("Preço de Custo: R$" + precoCusto);
        System.out.println("Preço de Venda: R$" + precoVenda);
        System.out.println("Lucro: R$" + calcularLucro());
        System.out.println();
    }

    // Método main para capturar as informações do usuário e testar a classe RProduto
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Capturando informações do primeiro produto
        System.out.println("Insira o nome do produto:");
        String nome = scanner.nextLine();

        System.out.println("Insira a marca do produto:");
        String marca = scanner.nextLine();

        System.out.println("Insira o preço de custo do produto:");
        double precoCusto = scanner.nextDouble();

        System.out.println("Insira o preço de venda do produto:");
        double precoVenda = scanner.nextDouble();

        // Criando objeto da classe RProduto com os valores inseridos
        RProduto produto = new RProduto(nome, marca, precoCusto, precoVenda);

        // Exibindo as informações do produto e o lucro
        produto.exibirProduto();

        scanner.close();
    }
}
