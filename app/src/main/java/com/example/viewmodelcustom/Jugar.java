package com.example.viewmodelcustom;

public class Jugar {



    public static class Juego {
        public int numero;
        public int numero2;

        public Juego(int numero, int numero2) {
            this.numero = numero;
            this.numero2 = numero2;
    }
        public Integer jugar(Juego juego) {
            try {
                Thread.sleep(3000);   // simular operacion de larga duracion (10s)
            } catch (InterruptedException e) {}
            return juego.numero + juego.numero2;
        }



    }
}
