package br.edu.utfpr.arthursottile.doremix;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PessoaActivity extends AppCompatActivity {

    private EditText editTextNome, editTextEmail, editTextNascimento;
    private CheckBox checkBoxTermos;
    private RadioGroup radioGroupNivel;
    private Spinner spinnerInstrumento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pessoa);

        editTextNome       = findViewById(R.id.editTextNome);
        editTextEmail      = findViewById(R.id.editTextEmail);
        editTextNascimento = findViewById(R.id.editTextNascimento);
        checkBoxTermos     = findViewById(R.id.checkBoxTermos);
        radioGroupNivel    = findViewById(R.id.radioGroupNivel);
        spinnerInstrumento = findViewById(R.id.spinnerInstrumento);

       // popularSpinner();
    }

//    private void popularSpinner() {
//        ArrayList<String> lista = new ArrayList<>();
//
//        lista.add(getString(R.string.guitarra));
//        lista.add(getString(R.string.violao));
//        lista.add(getString(R.string.bateria));
//        lista.add(getString(R.string.baixo));
//        lista.add(getString(R.string.teclado));
//        lista.add(getString(R.string.canto));
//        lista.add(getString(R.string.outros));
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
//                                                          android.R.layout.simple_list_item_1,
//                                                          lista);
//    spinnerInstrumento.setAdapter(adapter);
//    }


/*Função pra limpar todos os campos.
Implementados até então: Nome, Email, Data de Nascimento e Termos de Uso.*/
    public void limparCampos(View view){
        editTextNome.setText(null);
        editTextEmail.setText(null);
        editTextNascimento.setText(null);
        checkBoxTermos.setChecked(false);
        radioGroupNivel.clearCheck();
        spinnerInstrumento.setSelection(0);

        editTextNome.requestFocus();

        Toast.makeText(this,
                R.string.entradas_apagadas,
                Toast.LENGTH_LONG).show();
    }

/*Função para salvar todos os dados do usuário
Implementados até então: Nome, Email, Data de Nascimento e Termos de Uso.*/

        public void salvarValores(View view){

        String nome = editTextNome.getText().toString();

        if(nome == null || nome.trim().isEmpty()){

            Toast.makeText(this,
                    R.string.nome_nao_informado,
                    Toast.LENGTH_LONG).show();

            editTextNome.requestFocus();
            return;
        }

        String email = editTextEmail.getText().toString();

            if(email == null || email.trim().isEmpty()){

                Toast.makeText(this,
                        R.string.e_mail_nao_informado,
                        Toast.LENGTH_LONG).show();

                editTextEmail.requestFocus();
                return;
            }

            if(!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                Toast.makeText(this,
                        R.string.email_invalido,
                        Toast.LENGTH_LONG).show();

                editTextEmail.requestFocus();
                return;
            }

        String nascimento = editTextNascimento.getText().toString();

            if(nascimento == null || nascimento.trim().isEmpty()){
                Toast.makeText(this,
                        R.string.data_de_nascimento_nao_informada,
                        Toast.LENGTH_LONG).show();

                editTextNascimento.requestFocus();
                return;
            }

            if(!nascimento.matches("\\d{2}/\\d{2}/\\d{4}")){
                Toast.makeText(this,
                        R.string.data_de_nascimento_invalida,
                        Toast.LENGTH_LONG).show();

                editTextNascimento.requestFocus();
                return;
            }

            String nivel = "";
            int radioButtonId = radioGroupNivel.getCheckedRadioButtonId();

            if(radioButtonId == R.id.radioButtonIniciante){
                nivel = getString(R.string.iniciante);
            }else if(radioButtonId == R.id.radioButtonIntermediario){
                nivel = getString(R.string.intermediario);
            }else if(radioButtonId == R.id.radioButtonAvancado){
                nivel = getString(R.string.avancado);
            }else{
                Toast.makeText(this,
                        R.string.selecione_um_nivel_de_experiencia,
                        Toast.LENGTH_LONG).show();
                return;
            }


            String instrumento = spinnerInstrumento.getSelectedItem().toString();

            if(instrumento == null){
                Toast.makeText(this,
                               R.string.selecione_um_instrumento,
                               Toast.LENGTH_LONG).show();
                return;
            }

            boolean termos = checkBoxTermos.isChecked();

            if(termos == false){
                Toast.makeText(this,
                        R.string.aceite_os_termos,
                        Toast.LENGTH_LONG).show();
            }

            Toast.makeText(this,
                            getString(R.string.nome_valor)         + nome       + "\n" +
                            getString(R.string.email_valor)             + email      + "\n" +
                            getString(R.string.data_de_nascimento)      + nascimento + "\n" +
                            getString(R.string.nivel_de_experiencia)    + nivel      + "\n" +
                            getString(R.string.instrumento_principal)   + instrumento,
                    Toast.LENGTH_LONG).show();
        }
    }