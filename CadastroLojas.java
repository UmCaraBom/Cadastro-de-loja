package cadastrolojas;

import java.util.Scanner;

//entrada de dados para cadastro de lojas
public class CadastroLojas {

    public static void main(String[] args) {
        try (Scanner entrada = new Scanner(System.in)) {
            Loja loja = new Loja();
            System.out.println("Digite o nome da loja: ");
            loja.setNome(entrada.nextLine());
            System.out.println("Digite o endereço da loja: ");
            loja.setEndereco(entrada.nextLine());
            System.out.println("Digite o telefone da loja: ");
            loja.setTelefone(entrada.nextLine());
            System.out.println("Digite o email da loja: ");
            loja.setEmail(entrada.nextLine());
            System.out.println("Digite o CNPJ da loja: ");
            loja.setCnpj(entrada.nextLine());
            System.out.println("Digite a razão social da loja: ");
            loja.setRazaoSocial(entrada.nextLine());
            System.out.println("Digite o nome fantasia da loja: ");
            loja.setNomeFantasia(entrada.nextLine());
            LojaRepositorio.salvar(loja);
        }
        System.out.println("Loja cadastrada com sucesso!");
    }
}