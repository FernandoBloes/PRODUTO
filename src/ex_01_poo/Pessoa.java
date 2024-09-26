package ex_01_poo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import java.util.Scanner;

public class Pessoa {
    private String nome;
    private double altura;
    private LocalDate dataNascimento;
    private String email;

    // Construtor
    public Pessoa(String nome, double altura, LocalDate dataNascimento) {
        this.nome = nome;
        this.altura = altura;
        
        // Verificando se a data de nascimento é posterior à data atual
        if (dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("A data de nascimento não pode ser posterior à data atual.");
        }
        this.dataNascimento = dataNascimento;

        // Gerando o email
        this.email = gerarEmail(nome);
    }

    // Método para gerar o e-mail no formato "nome.sobrenome@dominio.com"
    private String gerarEmail(String nomeCompleto) {
        // Separando o nome e o sobrenome
        String[] partes = nomeCompleto.split(" ");
        String primeiroNome = partes[0].toLowerCase();
        String sobrenome = partes[partes.length - 1].toLowerCase();

        // Retornando o email no formato nome.sobrenome@dominio.com
        return primeiroNome + "." + sobrenome + "@dominio.com";
    }

    // Método para calcular a idade
    public int calcularIdade() {
        return Period.between(this.dataNascimento, LocalDate.now()).getYears();
    }

    // Método para mostrar as informações da pessoa
    public void exibirPessoa() {
        System.out.println("Nome: " + nome);
        System.out.println("Altura: " + altura + " metros");
        System.out.println("Data de Nascimento: " + dataNascimento);
        System.out.println("Idade: " + calcularIdade() + " anos");
        System.out.println("Email: " + email);
    }

    // Uso do método main para testar a classe, captura as informações e faz o teste
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Capturando informações do usuário
        System.out.println("Insira o nome completo da pessoa:");
        String nome = scanner.nextLine();

        System.out.println("Insira a altura (em metros):");
        double altura = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Insira a data de nascimento (formato dd/MM/yyyy):");
        String dataNascimentoStr = scanner.nextLine();
        
        // Formatando a data de nascimento
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataNascimento = LocalDate.parse(dataNascimentoStr, formatter);

        // Criando o objeto Pessoa
        try {
            Pessoa pessoa = new Pessoa(nome, altura, dataNascimento);
            // Exibindo as informações da pessoa
            pessoa.exibirPessoa();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        scanner.close();
    }
}
