import java.util.Scanner;

public class ArrayDinamico{

    static int tamanho = 5;
    static int posicao = 0;
    static int[] array = new int[tamanho];

    public static void main(String[] args){

        //objetivo: criar um array dinamico
        //logica: preciso de uma variavel contendo o tamanho inicial do meu array,
        //uma variavel para percorrer as posições do meu array, e um array inicial
        
        Scanner sc = new Scanner(System.in);

        adicionarValor(15);
        adicionarValor(16);
        adicionarValor(17);
        adicionarValor(18);
        adicionarValor(19);
        adicionarValor(20);
        adicionarValor(21);

        System.out.println("Array na posição 5: " + getPosicao(5));

        System.out.println();
        for(int i=0; i<array.length; i++){
            System.out.print(" " + array[i]);
        }

        System.out.println();
        System.out.println("Primeiro pop:");
        removerUltimoElemento();
        for(int i=0; i<array.length; i++){
            System.out.print(" " + array[i]);
        }

        System.out.println();
        System.out.println("Segundo pop:");
        removerUltimoElemento();
        for(int i=0; i<array.length; i++){
            System.out.print(" " + array[i]);
        }

        System.out.println();
        System.out.println("Removendo por valor");
        removerPorValor(17);
        for(int i=0; i<array.length; i++){
            System.out.print(" " + array[i]);
        }

        sc.close();
    }

    public static void adicionarValor(int valor){
        if(tamanho == posicao){
            tamanho = tamanho * 2;
            int[] copia = new int[tamanho];

            for(int i=0; i<array.length; i++){
                copia[i] = array[i];
            }

            array = copia;
        }

        array[posicao] = valor;
        posicao++;
    }

    public static int getPosicao(int indece){
        if (indece >= posicao) {
            throw new RuntimeException("Esse valor não existe!");
        }
        return array[indece];        
    }

    public static void removerUltimoElemento(){
        if (posicao == 0) {
            System.out.println("Está vazio!");            
        }

        tamanho = posicao;

        int[] copia = new int[tamanho-1];

        for(int i=0; i<copia.length; i++){
            copia[i] = array[i];
        }

        array = copia;
        posicao--;
    }

    public static void removerPorValor(int valor){
        if (posicao == 0) {
            System.out.println("Está vazio!");
        }
        tamanho = posicao;

        int posicaoValor = 0;
        for(int i=0; i<tamanho; i++){
            if (array[i] == valor) {
                posicaoValor = i;
            }
        }

        for(int i=posicaoValor; i<tamanho-1; i++){
            array[i] = array[i+1];
        }


        int[] copia = new int[tamanho-1];

        for(int i=0; i<copia.length; i++){
            copia[i] = array[i];
        }

        array = copia;
        posicao--;
    }
}