package atividade2;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class Recorde {
    
    private LocalDate dataRecorde;
    double tempo;
    private String nome;
    
    public LocalDate getData(){
        return dataRecorde;
    }
    public double getTempo(){
        return tempo;
    }
    public String getNome(){
        return nome;
    }

    public void setDataRecorde(LocalDate dataRecorde) {
        this.dataRecorde = dataRecorde;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    @Override
    public String toString(){
        // data formatada em dia mês e ano
        String dataFormatada = this.dataRecorde.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); 
        return "Nome: " + this.nome + " Tempo: " + this.tempo + " Data: " + dataFormatada;
    }
}
