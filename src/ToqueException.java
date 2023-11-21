public class ToqueException extends Exception{
    
    int variavelPontos;

    public ToqueException(int pontuacao){
        variavelPontos = variavelPontos + pontuacao;
        System.out.println("Sua pontuação é de: " + variavelPontos);
    }


}
