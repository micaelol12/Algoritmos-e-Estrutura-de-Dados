package Trabalho1;

import exercicio2.ListaEstatica;
import exercicio5.PilhaLista;

// falta validar singletons e corrigir primeira celula n aparecendo

public class Validador {

    public Validador() {
    }

    // retorna se a tag passada como parâmetro é uma tag final
    private boolean isTagFinal(String pTag) {
        return pTag.startsWith("</");
    }

    // retorna a tag final da tag passa como parâmetro
    private String getTagFinal(String tag) {
        if (isTagFinal(tag)) {
            throw new RuntimeException("A tag deve ser inicial");
        }
        return "</" + tag.substring(1);
    }

    /*
     * Retorna a tag sem seus seus atributos
     */
    private String limparTag(String tag) {
        char[] arrayChar = tag.toCharArray();

        String cleanedTag = "";

        for (int i = 0; i <= arrayChar.length - 1; i++) {

            char ch = arrayChar[i];

            if (Character.isWhitespace(ch)) {
                if (tag.endsWith(">")) {
                    return cleanedTag + '>';
                }
            }

            cleanedTag += ch;

        }

        return cleanedTag;
    }

    private int achaTag(ListaEstatica<Tag> lista, String tag) {
        for (int i = 0; i < lista.getTamanho(); i++) {
            Tag aux = lista.obterElemento(i);

            if (aux.getTag().equals(tag)) {
                return i;
            }
        }
        return -1;
    }

    public ListaEstatica<Tag> validarTexto(String texto) {
        PilhaLista<String> tags = new PilhaLista<String>();
        ListaEstatica<Tag> listaTag = new ListaEstatica<Tag>();


        char[] arrayChar = texto.toCharArray();

        String tag = "";

        boolean ler = false;

        for (int i = 0; i <= arrayChar.length - 1; i++) {

            char ch = arrayChar[i];

            if (ch == '<') {
                ler = true;
            }

            if (ler) {
                tag += ch;
            }

            if (ch == '>') {
                if (isTagFinal(tag)) {
                    String ultimaTag = tags.pop();

                    String expecetedEndTag = getTagFinal(ultimaTag);

                    if (!tag.equals(expecetedEndTag)) {
                        throw new RuntimeException(
                                "Tag final inesperada,esperava-se tag " + expecetedEndTag + ". Encontrada tag " + tag);
                    }
                    ;

                } else {
                    String tagLimpa = limparTag(tag);
                    tags.push(tagLimpa);

                    int index = achaTag(listaTag, tagLimpa);

                    if (index != -1) {
                        Tag p = listaTag.obterElemento(index);
                        p.setCount(p.getCount() + 1);
                    } else {

                        listaTag.inserir(new Tag(tagLimpa));
                    }

                }

                tag = "";
                ler = false;
            }

        }

        if (!tags.estaVazia()) {
            String message = "Faltam tags finais. Esparadas as tags finais: ";

            while (!tags.estaVazia()) {
                String openTag = tags.pop();

                message += (getTagFinal(openTag) + "\n");
            }

            throw new RuntimeException(message);
        }
        ;

        return listaTag;

    }
}
