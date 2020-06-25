package com.pucrs;

import javax.swing.*;

public class Main {
    static int count = 0;
    public static void main(String[] args) {
        KMPSearch("ADF", "ABCDCBDCBDACBDABDCBADF");
        KMPSearch("campo dos fatos naturais", "É importante desde logo salientar que, assim como não existe apenas um modelo de pensamento ético na história da filosofia, tampouco há uma única forma de classificação desses modelos. A depender do contexto, da Escola filosófica, dos autores, o próprio entendimento do que são a ética e a moral varia a tal ponto que os seus significados estão em disputa no campo filosófico.\n" +
                "\n" +
                "Um estudo sobre as classificações éticas, relativamente recente e bastante didático, foi oferecido por Cortina e Martínez, no livro Ética (2015). A sua principal contribuição foi evidenciar que as classificações éticas expressam diversos modos de pensamento para construir a ação moral, de maneira que cada uma dessas classificações destacam aspectos do fenômeno moral que podem ser combinados com outras dimensões classificatórias. Além disso, o texto de Cortina e Martínez mostra-se abrangente em suas classificações, tanto no sentido histórico quando no sentido das temáticas abordadas. Por essas razões, o seu texto mostrou-se inspirador para formular o quadro de classificações a seguir (CORTINA; MARTÍNEZ, 2015, pp. 103-116).\n" +
                "\n" +
                "A ética define-se pela busca da realização do bem ou pela determinação do dever ser? Essa pergunta divide as escolas éticas em éticas teleológicas e éticas deontológicas. As éticas teleológicas investigam a correção das ações conforme a sua tendência a realizar o bem. Por outro lado, as éticas deontológicas afirmam que o próprio bem não pode ser especificado se não houver previamente uma determinação daquilo que deve ser feito.\n" +
                "\n" +
                "A ética é um fenômeno que pode ser explicado através da própria natureza, ou seja, dos fenômenos naturais? Diante dessa pergunta, as escolas dividem-se em naturalistas e não naturalistas. As éticas naturalistas afirmam que o conteúdo moral se relaciona com a dimensão natural, podendo, portanto, ser estudada no âmbito dos fenômenos naturais. As éticas não naturalistas negam que a moral possa ser reduzida ao campo natural, uma vez que o âmbito das normas morais não se reduz ao campo dos fatos naturais.");
    }

    public static void KMPSearch(String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();

        // cria lps[] que vai guardar o maior
        // valor prefixo sufixo para o padrão
        int lps[] = new int[M];
        int j = 0; // index for pat[]

        // Calcula lps[]
        computeLPSArray(pat, M, lps);

        int i = 0; // index for txt[]
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                System.out.println("Found pattern "
                        + "at index " + (i - j));
                j = lps[j - 1];
            }

            // mismatch após j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                // Não faz match dos caracteres lps[0..lps[j-1]],
                // não é necesssário, eles combinarão
                if (j != 0)
                    j = lps[j - 1];
                else
                    i = i + 1;
            }
            count++;
        }
        System.out.println("Iterações: " + count);
    }

    public static void computeLPSArray(String pat, int M, int lps[])
    {
        // tamanho do maior prefixo sufixo anterior
        int len = 0;
        int i = 1;
        lps[0] = 0; // lps[0] is always 0

        // loop calcula lps[i] for i = 1 to M-1
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else // (pat[i] != pat[len])
            {
                if (len != 0) {
                    len = lps[len - 1];
                }
                else // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
            count++;
        }
    }
}
