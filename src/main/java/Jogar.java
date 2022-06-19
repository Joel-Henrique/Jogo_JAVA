import javax.swing.*;

public class Jogar
{
    public static void preenchevalores(Jogador jg){
        int hp,exp,nv;
        String teclado = JOptionPane.showInputDialog(null, "Digite o HP do seu Personagem:", "Jogo", JOptionPane.QUESTION_MESSAGE);
        hp = Integer.parseInt(teclado);
        teclado = JOptionPane.showInputDialog(null, "Digite o exp do seu Personagem:", "Jogo", JOptionPane.QUESTION_MESSAGE);
        exp = Integer.parseInt(teclado);
        teclado = JOptionPane.showInputDialog(null, "Digite o nv do seu Personagem:", "Jogo", JOptionPane.QUESTION_MESSAGE);
        nv = Integer.parseInt(teclado);
        jg.setPtvida(hp);
        jg.setExperiencia(exp);
        jg.setNivel(nv);
    }
    public static void main(String[] args) {
        Jogador jogador1 = new Jogador(0,0,0);
        Jogador jogador2 = new Jogador(0,0,0);
        preenchevalores(jogador1);
        preenchevalores(jogador2);

        for(int i = 0; i < 5;i++){
            JOptionPane.showMessageDialog(null, "Inicio da " +(i+1)+"a Rodada" , "Jogo", JOptionPane.INFORMATION_MESSAGE, null);
            JOptionPane.showMessageDialog(null, "Vida do jogador 1:  " +(jogador1.getPtvida())+" " , "Jogo", JOptionPane.INFORMATION_MESSAGE, null);
            JOptionPane.showMessageDialog(null, "Vida do jogador 2:  " +(jogador2.getPtvida())+" " , "Jogo", JOptionPane.INFORMATION_MESSAGE, null);
            JOptionPane.showMessageDialog(null, "Ataque do Jogador 1", "Jogo", JOptionPane.INFORMATION_MESSAGE, null);
            jogador1.ataque(jogador2);
            if(jogador1.getPtvida()<=0 || jogador2.getPtvida()<=0){
                JOptionPane.showMessageDialog(null, "Fim do jogo", "Jogo", JOptionPane.INFORMATION_MESSAGE, null);
                break;
            }
            JOptionPane.showMessageDialog(null, "Ataque do Jogador 2", "Jogo", JOptionPane.INFORMATION_MESSAGE, null);
            jogador2.ataque(jogador1);
            if(jogador1.getPtvida()<=0 || jogador2.getPtvida()<=0){
                JOptionPane.showMessageDialog(null, "Fim do jogo", "Jogo", JOptionPane.INFORMATION_MESSAGE, null);
                break;
            }
        }
        if(jogador1.getPtvida()>0){
            JOptionPane.showMessageDialog(null, "Parabéns Jogador um você Ganhou", "Jogo", JOptionPane.INFORMATION_MESSAGE, null);
        }else
            JOptionPane.showMessageDialog(null, "Parabéns Jogador Dois você Ganhou", "Jogo", JOptionPane.INFORMATION_MESSAGE, null);
//
    }
}
