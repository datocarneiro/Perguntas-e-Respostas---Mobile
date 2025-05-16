package com.example.perguntas_e_respostas;

import java.util.List;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;


@Dao
public interface MeuDao {
    @Insert
    long inserirQuestao(Questao questao);


    //listarTodos() → é um nome que você escolheu para esse método.
    //Ele pode ser qualquer nome válido, como buscarTodasQuestoes() ou getAll() —
    // o importante é a anotação @Query.
    @Query("SELECT * FROM Questao")
    List<Questao> pesquisarTodasQuatoes();


};
