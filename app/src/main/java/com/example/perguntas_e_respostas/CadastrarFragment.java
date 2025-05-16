package com.example.perguntas_e_respostas;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.perguntas_e_respostas.BancoDeDados;
import com.example.perguntas_e_respostas.Questao;
import com.example.perguntas_e_respostas.MeuDao;



public class CadastrarFragment extends Fragment {

    EditText mInputPergunta;
    EditText mInputResposta;
    Button mButtonRegistrar;
    Button mButtonJogar;

    public CadastrarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // vai jogar o layout na tela
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cadastrar, container, false);
    }

    // responsavel por criar ou pegar qualquer ação enquanto o Framents estiver ativo
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mInputPergunta = getActivity().findViewById(R.id.IdInputPergunta);
        mInputResposta = getActivity().findViewById(R.id.IdInputResposta);
        mButtonRegistrar = getActivity().findViewById(R.id.IdButtonRegistrar);
        mButtonJogar = getActivity().findViewById(R.id.IdButtonJogar);

        mButtonJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new JogarFragment()).commit();
            }
        });
        mButtonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pergunta = mInputPergunta.getText().toString();
                String resposta = mInputResposta.getText().toString();

                Log.d("pergunta::::%s",  pergunta);
                Log.d("resposta::::%s", resposta);
                Log.d( "TAG", "PASOUUUUUU inputss");

                if (!pergunta.isEmpty() && !resposta.isEmpty()){
                    Questao questao = new Questao(pergunta, resposta);

                    BancoDeDados.getBancoDeDados(getActivity()).meuDao().inserirQuestao(questao);

                    mInputResposta.setText("");
                    mInputPergunta.setText("");

                    Toast.makeText(getActivity(), "Inserido com sucesso!", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}