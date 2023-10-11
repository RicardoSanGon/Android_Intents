package com.example.intents;

import static java.net.Proxy.Type.HTTP;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final int codigo_camara=1;
    private static final int codigo_contactos=1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button EnviarCorreo;
        Button irPagina;
        Button LlamarTelefono;
        Button Mapa;
        Button Camara;
        Button Pagina2;
        Button Contactos;

        Contactos=findViewById(R.id.btnContactos);
        Camara=findViewById(R.id.btnCamara);
        Mapa=findViewById(R.id.btnMapa);
        LlamarTelefono=findViewById(R.id.btnTelefono);
        irPagina=findViewById(R.id.btnPagina);
        EnviarCorreo=findViewById(R.id.btnCorreo);
        Pagina2=findViewById(R.id.btnPagina2);

        LlamarTelefono.setOnClickListener(this);
        EnviarCorreo.setOnClickListener(this);
        irPagina.setOnClickListener(this);
        Mapa.setOnClickListener(this);
        Camara.setOnClickListener(this);
        Pagina2.setOnClickListener(this);
        Contactos.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
            if(view.getId()==R.id.btnCorreo)
            {
                Intent emailIntent = new Intent(Intent.ACTION_SEND);

                emailIntent.setType("message/rfc822");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"22170038@uttcampus.edu.mx"}); // recipients
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Envio de correo");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Hola desde Android Studio");
                emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));
                startActivity(emailIntent);
            }
            else if(view.getId()==R.id.btnPagina)
            {
                Intent webIntent=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.youtube.com/watch?v=d1exTDqByMQ"));
                startActivity(webIntent);
            }
            else if(view.getId()==R.id.btnTelefono)
            {
                Intent callIntent=new Intent(Intent.ACTION_DIAL,Uri.parse("tel:8717876204"));
                startActivity(callIntent);
            }
            else if (view.getId()==R.id.btnCamara)
            {
                Intent intentCamara = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intentCamara, codigo_camara);
            }
            else if (view.getId()==R.id.btnPagina2)
            {
                Intent callPagina2=new Intent(this, pantalla2.class);
                startActivity(callPagina2);
            }
            else if(view.getId()==R.id.btnContactos)
            {
                Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                startActivityForResult(intent, codigo_contactos);
            }
            else
            {
                Intent mapIntent=new Intent(Intent.ACTION_VIEW,Uri.parse("geo:0,0?q=1600+Amphitheatre+Parkway,+Mountain+View,+California"));
                startActivity(mapIntent);
            }
    }
}