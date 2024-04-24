package Trabalho1;

import exercicio5.Pilha;
import exercicio5.PilhaLista;

public class Validador {

    public static void main(String[] args) {
        String teste = "<html style={{backgroundColor: 'green'}}>\r\n" + //
                "<body>\r\n" + //
                "<h1>Aqui cabeçalho do arquivo</h1>\r\n" + //
                "<p>Meu parágrafo da página web.</p>\r\n" + //
                "<p>Meu segundo parágrafo.</p>\r\n" + //
                "</body>\r\n" + //
                "</html>";

        validar(teste);
    }

    public static Boolean validar(String texto) {
        PilhaLista<String> tags = new PilhaLista<String>();

        char[] arrayChar = texto.toCharArray();

        String tag = "";

        boolean ler = false;

        for (int i = 0; i <= arrayChar.length - 1; i++) {

            char ch = arrayChar[i];

            if (ch == '<') {
                ler = true;
            }

            if(ler){
                tag += ch;
            }

            if (ch == '>') {
                tags.push(tag);
                tag = "";
                ler = false;
            }

        }

       System.out.println( tags.toString());

        return false;
    }
}
