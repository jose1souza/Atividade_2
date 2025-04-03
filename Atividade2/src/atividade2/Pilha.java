    package atividade2;
    import java.util.Arrays;

    public class Pilha <T> {
        private T[] elementos;
        private int topo;
             public Pilha(int tamanho) { 
            // Construtor que inicializa o array de elementos com o tamanho especificado
            this.elementos = (T[]) new Object[tamanho]; // Inicialização do array com tipo genérico
            this.topo = -1; // Inicializa o índice do topo como -1, indicando que a pilha está vazia
        } // fim do construtor da Pilha

         private void aumentaCapacidade() {
    if (this.isFull()) { // Verifica se a pilha está cheia
        T[] elementosNovos = (T[]) new Object[this.elementos.length * 2]; // Cria um novo array do tipo T
        for (int i = 0; i < this.elementos.length; i++) {
            elementosNovos[i] = this.elementos[i]; // Copia os elementos do array antigo para o novo
        }
        this.elementos = elementosNovos; // Atualiza a referência do array de elementos
    }
}

          public boolean isEmpty() {
            // Verifica se a pilha está vazia
            return this.topo == -1; 
            // Retorna true se o índice do topo for -1 (pilha vazia)
            // Isso equivale ao seguinte código:
            /*
            if (this.topo == -1) {
                return true;
            } else {
                return false;
            }
            */
        } // fim do isEmpty

        public boolean isFull() {
            // Verifica se a pilha está cheia
            return this.topo == this.elementos.length - 1; 
            // Retorna true se o índice do topo for igual ao último índice do array
            // Essa lógica também pode ser escrita como:
            // return this.elementos.length - 1 == this.topo;
        } // fim do isFull

        public boolean push(T dado) {
        if (this.isFull()) { 
          aumentaCapacidade();
            }
            // Verifica se a pilha não está cheia antes de adicionar o elemento
            // Em uma única linha:
            this.elementos[++this.topo] = dado; 
            // Ou, em duas linhas:
            /*
            this.topo++; // Incrementa o índice do topo
            this.elementos[this.topo] = dado; // Adiciona o elemento no novo topo
            */
            return true; // Retorna true indicando que a operação foi bem-sucedida
    } // fim do push

        // função genérica do tipo T que retorna o valor que está no topo
        public T pop(){
            // Em uma linha
            return this.elementos[this.topo--];

            /* 3 linhas
            // armazenando o dado do topo da pilha
            T retorno = this.elementos[this.topo];

            // decrementando o topo
            this.topo--;

            // retornando o valor do topo
            return retorno;*/
        } // fim do pop

        public T peek(){
            // olhar o valor do topo
            return this.elementos[this.topo];
        }

              @Override
        public String toString() {
            // Este método sobrescreve o `toString` padrão da classe Object para retornar
            // uma representação personalizada dos elementos da pilha, do topo até o início.
            StringBuilder retorno = 
                    new StringBuilder("Topo\n"); // Adiciona a palavra "Topo" ao início da visualização
                    for (int i = this.topo; i >= 0; i--) {
                        retorno.append(this.elementos[i] + "\n"); // Adiciona cada elemento, linha por linha
                    }

                    return retorno.toString(); // Retorna a String construída com todos os elementos
        }
    }
