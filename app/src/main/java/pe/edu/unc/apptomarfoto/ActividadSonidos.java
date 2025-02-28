package pe.edu.unc.apptomarfoto;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ActividadSonidos extends AppCompatActivity {
    EditText txtMultilinea;
    String resultadofinal="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.ly_sonidos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        txtMultilinea = findViewById(R.id.txtMultiple);
    }
   public void onClickHablar(View boton){
        //Ejemplo de objecto Intento Genérico
       try {
           Intent oIntento = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
           //Enviar Parámetros
           oIntento.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "es-PE");
           oIntento.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL,
                   RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
           startActivityIfNeeded(oIntento, 200);
       }catch (Exception ex){
           Log.d("Error_sonido",ex.getMessage());
       }
   }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent oIntento) {
        super.onActivityResult(requestCode, resultCode, oIntento);
        if(requestCode==200){
            //Investigar
            if(resultCode==RESULT_OK){
                ArrayList<String> cadenas= oIntento.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                for(String palabras:cadenas){
                    resultadofinal=txtMultilinea.getText().toString()+" "+palabras+"\n";
                }
                txtMultilinea.setText(resultadofinal);
            }
        }
    }
}