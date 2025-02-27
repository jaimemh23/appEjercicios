package pe.edu.unc.apptomarfoto;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ActividadLista extends ListActivity {
    String[] ejercicios ={"TomarFoto","Juego","Sonidos"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,ejercicios));
    }

    @Override
    protected void onListItemClick(ListView l, View v, int index, long id) {
        super.onListItemClick(l, v, index, id);
        //Toast.makeText(this,"Opción "+index,Toast.LENGTH_LONG).show();
        Intent oIntento= null;
        try{
            //Declarar un objeto de una clase genérica
            Class<?> ActividadDestino=Class.
                    forName("pe.edu.unc.apptomarfoto.Actividad"+ejercicios[index]);
            oIntento= new Intent(this, ActividadDestino);
            startActivity(oIntento);
        }catch (Exception ex){
            Log.d("Error",ex.getMessage());
        }


    }
}