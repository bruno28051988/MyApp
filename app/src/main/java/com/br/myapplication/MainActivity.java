package com.br.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView resultadoDados, resultadoLing, resultadoSexo;
    private CheckBox checkJava, checkJS, checkPython, checkC2;
    private RadioButton sexoMas, sexoFem, sexoInd;
    private RadioGroup radioGroupSexo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNome = findViewById(R.id.edit_nome);
        campoEmail = findViewById(R.id.edit_email);
        resultadoDados = findViewById(R.id.text_ResutadosDados);

        checkJava = findViewById(R.id.check_java);
        checkJS = findViewById(R.id.check_js);
        checkPython = findViewById(R.id.check_python);
        checkC2 = findViewById(R.id.check_c2);
        resultadoLing = findViewById(R.id.text_ResutadosLing);
        radioGroupSexo = findViewById(R.id.radioGroup_Sexo);

        sexoMas = findViewById(R.id.radioButton_Masc);
        sexoFem = findViewById(R.id.radioButton_Fem);
        sexoInd = findViewById(R.id.radioButton_Ind);
        resultadoSexo = findViewById(R.id.text_ResutadosSexo);

        radioButton();

    }

    public void radioButton(){

        radioGroupSexo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                String sexo="";
                if (i == R.id.radioButton_Masc){
                    String opcaoSexo = sexoMas.getText().toString();
                    sexo = opcaoSexo;

                }else if (i == R.id.radioButton_Fem){
                    String opcaoSexo = sexoFem.getText().toString();
                    sexo = opcaoSexo;

                }else{
                    String opcaoSexo = sexoInd.getText().toString();
                    sexo = opcaoSexo;
                }

                resultadoSexo.setText(sexo);
            }
        });

        /*
        String sexo = "";
        if(sexoMas.isChecked()){
            String opcapSexo = sexoMas.getText().toString();
            sexo = opcapSexo;

        }else if(sexoFem.isChecked()){
            String opcapSexo = sexoFem.getText().toString();
            sexo = opcapSexo;

        }else{
            String opcapSexo = sexoInd.getText().toString();
            sexo = opcapSexo;

        }

        resultadoSexo.setText(sexo);
        */
    }


    public void checkbox(){
        String texto = "";
        if (checkJava.isChecked()){
            String opcaoSelecionada = checkJava.getText().toString();
            texto = opcaoSelecionada;
        }
        if (checkJS.isChecked()){
            String opcaoSelecionada = checkJS.getText().toString();
            texto = texto + opcaoSelecionada;
        }
        if (checkPython.isChecked()){
            String opcaoSelecionada = checkPython.getText().toString();
            texto = texto + opcaoSelecionada;
        }
        if (checkC2.isChecked()){
            String opcaoSelecionada = checkC2.getText().toString();
            texto = texto + opcaoSelecionada;
        }

        resultadoLing.setText(texto);
    }

    public void salvar(View view){
       // radioButton();
        checkbox();

        String nome = campoNome.getText().toString();
        String email = campoEmail.getText().toString();

        resultadoDados.setText("Nome: " + nome + "\nE-mail: "+ email);
    }

    public void limpar(View view){

        campoEmail.setText("");
        campoNome.setText("");
        resultadoDados.setText("Resultado Dados");

        checkC2.setChecked(false);
        checkPython.setChecked(false);
        checkJava.setChecked(false);
        checkJS.setChecked(false);
        resultadoLing.setText("Resultado Linguagens");
    }
}
