package Exercicio12;

public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    public void inserir(T valor) {
        NoArvoreBinaria<T> novo = new NoArvoreBinaria<>(valor);

        if (estaVazia()) {
            setRaiz(novo);
        } else {
            NoArvoreBinaria<T> p = getRaiz();
            NoArvoreBinaria<T> pai;

            while (true) {
                pai = p;
                if (valor.compareTo(p.getInfo()) < 0) {
                    p = pai.getEsquerda();
                    if (p == null) {
                        pai.setEsquerda(novo);
                        return;
                    }
                } else {
                    p = pai.getDireita();
                    if (p == null) {
                        pai.setDireita(novo);
                        return;
                    }
                }
            }

        }
    }

    public NoArvoreBinaria<T> buscar(T info) {
        NoArvoreBinaria<T> p;

        p = getRaiz();

        while (p != null && !p.getInfo().equals(info)) {
            if (info.compareTo(p.getInfo()) < 0) {
                p = p.getEsquerda();
            } else {
                p = p.getDireita();
            }
        }

        return p;
    }

    // public NoArvoreBinaria<T> buscar(T info) {
    // return buscarRecursivo(info, getRaiz());
    // }

    // private NoArvoreBinaria<T> buscarRecursivo(T info, NoArvoreBinaria<T> no) {
    // if (no == null) {
    // return null;
    // }

    // if (info.equals(no.getInfo())) {
    // return no;
    // } else if (info.compareTo(no.getInfo()) < 0) {
    // return buscarRecursivo(info, no.getEsquerda());
    // } else {
    // return buscarRecursivo(info, no.getDireita());
    // }
    // }

    private NoArvoreBinaria<T> extrairSucessor(NoArvoreBinaria<T> p) {
        NoArvoreBinaria<T> atual = p.getDireita();
        NoArvoreBinaria<T> paiSucessor = p;
        NoArvoreBinaria<T> sucessor = p;

        while (atual != null) {
            paiSucessor = sucessor;
            sucessor = atual;
            atual = atual.getEsquerda();
        }

        if (sucessor != p.getDireita()) {
            paiSucessor.setEsquerda((sucessor.getDireita()));
            sucessor.setDireita(p.getDireita());
        }

        return sucessor;
    }

    public void retirar(T info) {
        NoArvoreBinaria<T> p = getRaiz();
        NoArvoreBinaria<T> pai = null;
        boolean filhoEsquerda = false;

        // Localiza o nó a ser removido;
        while ((p != null) && (!p.getInfo().equals(info))) {
            pai = p;

            if (info.compareTo(p.getInfo()) < 0) {
                filhoEsquerda = true;
                p = p.getEsquerda();
            } else {
                filhoEsquerda = false;
                p = p.getDireita();
            }
        }

        if (p != null) {

            if ((p.getEsquerda() == null) && (p.getDireita() == null)) {

                if (p == getRaiz()) {
                    setRaiz(null);
                } else {
                    if (filhoEsquerda) {
                        pai.setEsquerda(null);
                    } else {
                        pai.setDireita(null);
                    }

                }

            } else {
                if (p.getDireita() == null) {
                    // no com apenas um filho à esquerda
                    // 2 Caso
                    if (p == getRaiz()) {
                        setRaiz(p.getEsquerda());
                    } else {

                        if (filhoEsquerda) {
                            pai.setEsquerda(p.getEsquerda());
                        } else {
                            pai.setDireita(p.getEsquerda());
                        }
                    }

                } else {
                    if (p.getEsquerda() == null) {
                        // no com apenas um filho à direita
                        // 2 Caso

                        if (p == getRaiz()) {
                            setRaiz(p.getDireita());
                        } else {

                            if (filhoEsquerda) {
                                pai.setEsquerda(p.getDireita());
                            } else {
                                pai.setDireita(p.getDireita());
                            }
                        }
                    } else {
                        // no com filho a esquerda e à direita
                        // 3 caso
                        // Talvez esta no lugar errado

                        NoArvoreBinaria<T> sucessor = extrairSucessor(p);

                        if (p == getRaiz()) {
                            setRaiz(sucessor);
                        } else {
                            if (filhoEsquerda) {
                                pai.setEsquerda(sucessor);
                            } else {
                                pai.setDireita(sucessor);
                            }
                        }
                        sucessor.setEsquerda(p.getEsquerda());

                    }
                }

            }
        }

    }
}