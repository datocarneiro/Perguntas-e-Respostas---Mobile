package com.example.perguntas_e_respostas;

import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Questao {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String pergunta;
    public String resposta;

    public Questao(String pergunta, String resposta){
        this.pergunta = pergunta;
        this.resposta = resposta;
    }


    public int getID(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getPergunta(){
        return pergunta;
    }
    public void setPergunta(String pergunta){
        this.pergunta = pergunta;
    }
    public String getResposta(){
        return resposta;
    }
    public void setResposta(String resposta){
        this.resposta = resposta;
    }

}
