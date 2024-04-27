package Trabalho1;

import exercicio5.PilhaLista;

// falta validar singletons e retornar as tags encontradas juntas com sua quantidade

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

    public void validarTexto(String texto) {
        PilhaLista<String> tags = new PilhaLista<String>();

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
                    String ultimaTag = limparTag(tags.pop());

                    String expecetedEndTag = getTagFinal(ultimaTag);

                    if (!tag.equals(expecetedEndTag)) {
                        throw new RuntimeException(
                                "Tag final inesperada,esperava-se tag " + expecetedEndTag + ". Encontrada tag " + tag);
                    }
                    ;

                } else {
                    tags.push(tag);
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

    }
}
