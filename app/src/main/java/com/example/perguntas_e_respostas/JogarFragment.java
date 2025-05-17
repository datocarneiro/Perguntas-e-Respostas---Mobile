package com.example.perguntas_e_respostas;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.perguntas_e_respostas.Questao;
import com.example.perguntas_e_respostas.BancoDeDados;
import com.example.perguntas_e_respostas.MeuDao;

public class JogarFragment extends Fragment {
    private Questao questaoAtual;

    Button mButtonCadastrarPR;
    Button mButtonPular;
    TextView mTextResposta;
    Button mButtonResposta;
    TextView mTextPergunta;


    public JogarFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_jogar, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mTextPergunta = view.findViewById(R.id.IdPerguntaJogar);
        mButtonCadastrarPR = view.findViewById(R.id.IdButtonCadastrarJogar);
        mButtonPular = view.findViewById(R.id.IdButtonPularJogar);
        mButtonResposta = view.findViewById(R.id.IdButtonRespostaJogar);
        mTextResposta = view.findViewById(R.id.IdRespostaJogar);

        mButtonCadastrarPR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requireActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.frameLayout, new CadastrarFragment())
                        .commit();
            }
        });

        mButtonPular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoDeDados db = BancoDeDados.getBancoDeDados(requireContext());
                questaoAtual = db.meuDao().pegarPerguntaAleatoria();
                mTextResposta.setText("");
                if (questaoAtual != null) {
                    Log.d("TAG", "Pergunta: \n" + questaoAtual.getPergunta());
                    mTextPergunta.setText(questaoAtual.getPergunta());
                } else {
                    mTextPergunta.setText("Nenhuma pergunta cadastrada.");

                }
            }
        });

        mButtonResposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (questaoAtual != null) {
                    Log.d("TAG", "Resposta: \n" + questaoAtual.getResposta());
                    mTextResposta.setText("Resposta: \n" + questaoAtual.getResposta());
                } else {
                    mTextResposta.setText("Nenhuma pergunta cadastrada.");
                }
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        BancoDeDados db = BancoDeDados.getBancoDeDados(requireContext());
        questaoAtual = db.meuDao().pegarPerguntaAleatoria();

        mTextResposta.setText("");
        if (questaoAtual != null) {
            Log.d("TAG", "Pergunta: \n" + questaoAtual.getPergunta());
            mTextPergunta.setText("Pergunta: \n" + questaoAtual.getPergunta());
        } else {
            mTextPergunta.setText("Nenhuma pergunta cadastrada.");
        }
    }


}