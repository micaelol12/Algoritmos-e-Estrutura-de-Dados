package Trabalho1;

import exercicio2.ListaEstatica;
import exercicio5.PilhaLista;

public class Validador {

    // Lista de singletons
    private ListaEstatica<String> singletons = new ListaEstatica<>();
    // Pilha de tags para validação
    private PilhaLista<String> tags = new PilhaLista<String>();
    //Lista para contagem de tags
    private ListaEstatica<Tag> listaTag = new ListaEstatica<Tag>();

    // Populando vetor de singletons
    public Validador() {
        singletons.inserir("meta");
        singletons.inserir("base");
        singletons.inserir("br");
        singletons.inserir("col");
        singletons.inserir("command");
        singletons.inserir("embed");
        singletons.inserir("hr");
        singletons.inserir("img");
        singletons.inserir("input");
        singletons.inserir("link");
        singletons.inserir("param");
        singletons.inserir("source");
        singletons.inserir("!DOCTYPE");
    }

    // retorna se a tag passada como parâmetro é uma tag final
    private boolean isTagFinal(String pTag) {
        return pTag.startsWith("</");
    }

    // retorna a tag final da tag passa como parâmetro
    private String getTagFinal(String pTag) {
        if (isTagFinal(pTag)) {
            throw new RuntimeException("A tag deve ser inicial");
        }

        return "</" + pTag + ">";
    }

    // Retorna a tag sem seus seus atributos
    private String limparTag(String pTag) {
        char[] arrayChar = pTag.toCharArray();

        String cleanedTag = "";

        for (int i = 1; i <= arrayChar.length - 1; i++) {

            char ch = arrayChar[i];

            if (ch == '>' || Character.isWhitespace(ch)) {
                return cleanedTag;
            }

            cleanedTag += ch;

        }

        return cleanedTag;
    }

    // Procura a tag na listagem de tags
    private int achaTag(String pTag) {
        for (int i = 0; i < listaTag.getTamanho(); i++) {
            Tag aux = listaTag.obterElemento(i);

            if (aux.getTag().equals(pTag)) {
                return i;
            }
        }
        return -1;
    }

    // Valida o texto
    public ListaEstatica<Tag> validarTexto(String texto) {

        getListaTag().liberar();
        getTags().liberar();

        char[] arrayChar = texto.toLowerCase().toCharArray();

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
                    String ultimaTag = getTags().pop();

                    String expecetedEndTag = getTagFinal(ultimaTag);

                    if (!tag.equals(expecetedEndTag)) {
                        throw new RuntimeException(
                                "Tag final inesperada,esperava-se tag " + expecetedEndTag + ". Encontrada tag " + tag);
                    }
                    ;

                } else {
                    String tagLimpa = limparTag(tag);

                    if (getSingletons().buscar(tagLimpa) == -1) {
                        getTags().push(tagLimpa);
                    }

                    int index = achaTag(tagLimpa);

                    if (index != -1) {
                        Tag p = getListaTag().obterElemento(index);
                        p.setCount(p.getCount() + 1);
                    } else {
                        getListaTag().inserir(new Tag(tagLimpa));
                    }

                }

                tag = "";
                ler = false;
            }

        }

        if (!getTags().estaVazia()) {
            String message = "Faltam tags finais. Esparadas as tags finais: ";

            while (!getTags().estaVazia()) {
                String openTag = getTags().pop();

                message += (getTagFinal(openTag) + "\n");
            }

            throw new RuntimeException(message);
        }
        ;

        return getListaTag();

    }

    public ListaEstatica<String> getSingletons() {
        return singletons;
    }

    public void setSingletons(ListaEstatica<String> singletons) {
        this.singletons = singletons;
    }

    public PilhaLista<String> getTags() {
        return tags;
    }

    public void setTags(PilhaLista<String> tags) {
        this.tags = tags;
    }

    public ListaEstatica<Tag> getListaTag() {
        return listaTag;
    }

    public void setListaTag(ListaEstatica<Tag> listaTag) {
        this.listaTag = listaTag;
    }
}
