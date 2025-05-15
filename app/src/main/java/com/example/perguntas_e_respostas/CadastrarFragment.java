package com.example.perguntas_e_respostas;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class CadastrarFragment extends Fragment {

    EditText mInpuyPergunta;
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

        mInpuyPergunta = getActivity().findViewById(R.id.IdInputPergunta);
        mInputResposta = getActivity().findViewById(R.id.IdInputResposta);
        mButtonRegistrar = getActivity().findViewById(R.id.IdButtonRegistrar);
        mButtonJogar = getActivity().findViewById(R.id.IdButtonJogar);

        mButtonJogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new JogarFragment()).commit();
            }
        });
    }
}