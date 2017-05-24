//PROFESSOR DECIDI IMPLEMENTAR TRATAMENTO DE EXCEÇÃO LOGO AQUI, TENDO A CERTEZA QUE OS METODOS DAS DEMAIS 
//CLASSES IRÃO FUNCIONAR POIS OS PARAMETROS PASSADOS VÃO ESTAR CERTOS.
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Principal {
	public static void main(String []args){
		double comissao = 0;
		String ch;
		boolean promo = false;
		
		Extra extra = new Extra();
		
		Scanner leitor = new Scanner(System.in);
		Scanner bol = new Scanner(System.in);
		
		System.out.println("Digite o codigo do Produto: ");
		ch = leitor.nextLine();
		int codigo = extra.verificarI(ch);//PASSO O VALOR QUE OBTIVE NO SCANNER PARA UMA VERIFICAÇÃO
		
		System.out.println(codigo);
		
		System.out.println("Digite o descrição do Produto: ");
		String descricao = leitor.nextLine();
		
		System.out.println("Digite o valor da venda do Produto: ");
		ch = leitor.nextLine();
		float valorVenda = extra.verificarF(ch);//PASSO O VALOR QUE OBTIVE NO SCANNER PARA UMA VERIFICAÇÃO
		
		
		
		System.out.println("Digite o valor de compra do Produto: ");
		ch = leitor.nextLine();
		float valorCompra = extra.verificarF(ch);//PASSO O VALOR QUE OBTIVE NO SCANNER PARA UMA VERIFICAÇÃO
		
		boolean counter = true;
		while(counter == true){//PROF ACHEI MORAL, CONSERTEI ESSE BAGUI, TAVA DANDO Unreachable code LÁ EM BAIXO:V :V :V
			System.out.println("O produto está em promoção? S - sim ou N - não");
			ch = leitor.nextLine();
			
			switch (ch) {
				case "S":
					promo = true;
					counter = false;
					break;
				case "N":
					promo = false;
					counter = false;
					break;
		
				default:
					System.out.println("Opção invalida\n");
					break;
			}
		}
		
		Produto produto = new Produto(codigo, descricao, valorVenda, valorCompra, promo);
		
		System.out.println("\n=============================================\n");
		
		System.out.println("Digite o nome do vendedor: ");
		String nome = leitor.nextLine();
		
		System.out.println("Digite o codigo: ");
		ch = leitor.nextLine();
		int id = extra.verificarI(ch);//PASSO O VALOR QUE OBTIVE NO SCANNER PARA UMA VERIFICAÇÃO
		
		System.out.println("Digite o endereço: ");
		String end = leitor.nextLine();
		
		Vendedor vendedor = new Vendedor(nome,id,end);
		
		Venda novavenda = new Venda();
		
		novavenda.setProduto(produto);
		novavenda.setVendedor(vendedor);
		
		System.out.println("Quantidade de itens: ");
		ch = leitor.nextLine();
		int qtd = extra.verificarI(ch);//PASSO O VALOR QUE OBTIVE NO SCANNER PARA UMA VERIFICAÇÃO
		novavenda.setQuantidadeItens(qtd);
		
		System.out.println("Qual a porcentagem de desconto do produto? ");//NESSE CASO PROFESSOR, ERA PRA EU TER O VALOR DO DESCONTO DO BANCO, SERIA MAIS FACIL
		ch = leitor.nextLine();
		float desconto = extra.verificarF(ch);//PASSO O VALOR QUE OBTIVE NO SCANNER PARA UMA VERIFICAÇÃO
		
		novavenda.efetuarDesconto(desconto);//SE TRATANDO DE VENDA, O VALOR DO DESCONTO JÁ DEVERIA TER SIDO PASSADA NA HORA DO CADASTRO DO MESMO.
		if(novavenda.desconto != -1){
			novavenda.calcularValor();
			
			comissao = novavenda.calcularComissao(comissao);
			
			JOptionPane.showMessageDialog(null, "O Valor da comissao é: "+comissao);
			
			novavenda.imprimir();
		
		
		
		
		
		
	}
	
	
}
}
	


