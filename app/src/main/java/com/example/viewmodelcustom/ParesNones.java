package com.example.viewmodelcustom;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.viewmodelcustom.databinding.FragmentParesNonesBinding;

public class ParesNones extends Fragment {
    private FragmentParesNonesBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return (binding = FragmentParesNonesBinding.inflate(inflater, container, false)).getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int numero = Integer.parseInt(binding.numero.getText().toString());
                int numero2 = (int) (Math.random() * 99) + 1;
                String nombre = (binding.nombre.getText().toString());
                String pr = (binding.pr.getText().toString());
                Jugar.Juego juego = new Jugar.Juego(numero, numero2);

                new AsyncTask<Jugar.Juego, Void, Integer>(){

                    @Override
                    protected Integer doInBackground(Jugar.Juego ... juegos) {
                        Jugar jugarr = new Jugar();
                        return jugarr.jugar(juegos[0]);
                    }

                    @Override
                    protected void onPostExecute(Double cuota) {
                        super.onPostExecute(cuota);

                        binding.cuota.setText(String.format("%.2f",cuota));
                    }
                }.execute(juego);



                    int suma = juego.jugar(juego);
                if(pr.equals("pares")&&suma%2==0||pr.equals("n")&&suma%2==0)

                    {
                        binding.resultado.setText(String.format(nombre + " ha ganado porque ha elegido " + pr + " y la maquina ha elegido " + numero2 + " y el total ha sido " + suma));
                    }else

                    {
                        binding.resultado.setText(String.format(nombre + " ha perdido porque ha elegido " + pr + " y la maquina ha elegido " + numero2 + " y el total ha sido " + suma));
                    }

            }

        });
    }
}