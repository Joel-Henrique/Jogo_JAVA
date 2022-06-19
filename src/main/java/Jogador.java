import javax.swing.*;

public class Jogador {
    private int nivel;
    private int experiencia;
    private int ptvida;

    public Jogador(int nv, int exp, int ptv){
        setNivel(nv);
        setExperiencia(exp);
        setPtvida(ptv);
        //valida(exp ,nv);
    }

    private boolean valida(int experiencia,int nivel){
        if(experiencia >= 0 && nivel >= 0){
            return true;
        }else
            return false;
    }

    public void setNivel(int nv) {
        if(nv >=0 ){
            this.nivel = nv;
        }else
            JOptionPane.showMessageDialog(null, "Nível ìnvalido", "Jogo", JOptionPane.INFORMATION_MESSAGE, null);
    }

    public void setExperiencia(int exp) {
        if(exp >=0 ){
            this.experiencia = exp;
        }else
            JOptionPane.showMessageDialog(null, "Experiencia Ínvalida", "Jogo", JOptionPane.INFORMATION_MESSAGE, null);
    }

    public void setPtvida(int hp) {
        if(hp>= 0)
            this.ptvida = hp;
        else
            JOptionPane.showMessageDialog(null, "HP Ínvalido", "Jogo", JOptionPane.INFORMATION_MESSAGE, null);
    }


    public int getPtvida(){
        return ptvida;
    }
    public int FD(){
        if (valida(experiencia,nivel)) {
            return (nivel * (experiencia * experiencia));
        }else
            return 0;

    }
    public int FA(){
        if (valida(experiencia,nivel)) {
            return ((2 * experiencia)*(nivel * nivel));
        }else
            return 0;
    }
    public void aumentanivel(){
        nivel++;
    }
    public void ataque(Jogador jg2){
        if(jg2.FA() == this.FD()){
            JOptionPane.showMessageDialog(null, "Jogadores emapataram! ", "Jogo", JOptionPane.INFORMATION_MESSAGE, null);

            jg2.aumentanivel();
            this.aumentanivel();

        }else if(this.FA() > jg2.FD()){
            int dano;
            dano = this.FA() - jg2.FD();
            JOptionPane.showMessageDialog(null, "Jogador Atacado Levou " + dano + " De Dano!", "Jogo", JOptionPane.INFORMATION_MESSAGE, null);
            this.aumentanivel();
            jg2.ptvida = jg2.ptvida - dano;
            if(this.ptvida <= 0 )
                JOptionPane.showMessageDialog(null, "Jogador Atacado Morreu", "Jogo", JOptionPane.INFORMATION_MESSAGE, null);
        }else
            JOptionPane.showMessageDialog(null, "Jogador não sofreu Dano", "Jogo", JOptionPane.INFORMATION_MESSAGE, null);
    }

}
