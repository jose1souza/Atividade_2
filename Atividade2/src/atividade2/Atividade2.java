package atividade2;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Atividade2 {

    static Scanner leia = new Scanner(System.in);
    private static int menu(){
        System.out.println("\n--- Menu Recorde ---");
        System.out.println("1- Inserir novo Recorde");
        System.out.println("2- Consultar Recorde");
        System.out.println("3- Remover Recorde do topo");
        System.out.println("4- Listar Recordes");
        System.out.println("0- Sair");
        System.out.printf("Digite a opção desejada:" );
    	return leia.nextInt();
    }
    
        public static void lerRecorde(Recorde recorde) {
          Scanner scanner = new Scanner(System.in);
          System.out.println("Digite o nome do atleta: ");
          recorde.setNome(scanner.nextLine());
          System.out.println("Digite a data do recorde (dd/MM/yyyy): ");
          String dataStr = scanner.nextLine();
          LocalDate dataFormatada = LocalDate.parse(dataStr,DateTimeFormatter.ofPattern("dd/MM/yyyy"));
          recorde.setDataRecorde(dataFormatada) ;
          System.out.println("Digite o tempo do recorde (em segundos): ");
          recorde.setTempo(scanner.nextDouble());
}
        
    public static void main(String[] args) {
        System.out.println("Digite o tamanho da Pilha: ");
        int tamanho = leia.nextInt();
        int opcao;
        Pilha<Recorde> minhaPilha = new Pilha(tamanho);
        
        do{
            opcao = menu();
            
            switch(opcao){
                case 1:
                        Recorde novoRecorde = new Recorde();
                        lerRecorde(novoRecorde);
                        if(minhaPilha.isEmpty() || novoRecorde.getTempo() < 
                            minhaPilha.peek().getTempo()){
                            minhaPilha.push(novoRecorde); // verificando se o tempo for menor que o anterior
                            // e inserindo se não estiver vazia
                            }
                        else{
                            System.out.println("Seu recorde não pôde ser inserido pois existe um recorde com tempo menor!");
                        }
                    break;
                case 2:
                    if(!(minhaPilha.isEmpty())){
                       System.out.println("Valor do Topo: " + minhaPilha.peek());
                    }
                    else{
                        System.out.println("Pilha vazia!");
                    }
                    break;
                case 3:
                        if(!(minhaPilha.isEmpty())){
                            System.out.println("Topo removido: " + minhaPilha.pop());
                        }
                        else{
                            System.out.println("Pilha vazia!");
                        }
                    break;
                case 4:
                        System.out.println(minhaPilha);
                    break;
                case 0:
                        System.out.println("Saindo...");
                    break;
            }
        }while(opcao != 0);
    }
}
