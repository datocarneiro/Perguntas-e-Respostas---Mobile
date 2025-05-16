package com.example.perguntas_e_respostas;


import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Questao.class}, version = 1)
public abstract class BancoDeDados extends RoomDatabase{
    public abstract MeuDao meuDao();
    public static BancoDeDados INSTANCIA;
    public static BancoDeDados getBancoDeDados(final Context context){
        if (INSTANCIA == null){
            synchronized (BancoDeDados.class){
                if (INSTANCIA == null){
                    INSTANCIA = Room.databaseBuilder(context.getApplicationContext(), BancoDeDados.class, "db_questoes").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCIA;
    }
}
