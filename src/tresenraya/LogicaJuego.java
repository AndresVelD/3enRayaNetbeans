package tresenraya;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class LogicaJuego {
    int turno, pX, pO; // Turno del jugador
    boolean habilitado; // Habilita y deshabilita el tablero

    /**
     * Inicializaremos el juego con las siguientes variables_
     * @param turno (Nos indicará el turno del jugador: 0 - X, 1 - O)
     * @param pX (Contiene el valor total de las victorias de este jugador)
     * @param pO (Contiene el valor total de las victorias de este jugador)
     */
    public LogicaJuego(int turno, int pX, int pO) {
        this.turno = turno;
        this.pX = pX;
        this.pO = pO;
    }

    /**
     * Obtener turno
     * @return 
     */
    public int getTurno() {
        return turno;
    }

    /**
     * Insertar turno
     * @param turno 
     */
    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getpX() {
        return pX;
    }

    public void setpX(int pX) {
        this.pX = pX;
    }

    public int getpO() {
        return pO;
    }

    public void setpO(int pO) {
        this.pO = pO;
    }
    
    /**
     * Llamaremos a este método para cambiar de turno
     */
    public void cambioTurno() {
        // Inserta código aquí...
        if (turno == 0) {
            turno = 1; //Cambiar turno al del jugador O.
        } else {
            turno = 0; //Cambiar turno al jugador X.
        }
    }
    
    /**
     * Comprobar si se ha conseguido un tres en raya, 
     * en caso que se haya conseguido devolverá 1, en caso contrario retorna 0 y continúa el juego
     * @param matriz (Tablero de juego)
     * @return 
     */
    public int comprobarJuego(int matriz[][]){
    /* se tendrá que comprobar que las posiciones correspondientes tengan el 
       mismo valor; es decir se tiene que ir comparando las casillas entre sí; 
       de forma horizontal, vertical y diagonal, obligatoriamente.  . 
       Se evalúa utilizar las estructuras correctas, para reducir el número de 
       iteraciones. Todo de forma organizada y optimizada recordemos 
       que estamos en un módulo del tercer semestre del ciclo.  Pero, 
       por si acaso posible pseudocódigo:   
        Comprobar si existe tres en raya:
            Comprobar horizontal			
            si no, Comprobar vertical        
            si no, Comprobar en diagonal
        Si no hay tres en raya:
    */   
    // Inserta código aquí...
    // Comprobar filas
    for (int i = 0; i < 3; i++) {
        if (matriz[i][0] == matriz[i][1] && matriz[i][1] == matriz[i][2]) {
            return matriz[i][0];
        }
    }

    // Comprobar columnas
    for (int i = 0; i < 3; i++) {
        if (matriz[0][i] == matriz[1][i] && matriz[1][i] == matriz[2][i]) {
            return matriz[0][i];
        }
    }

    // Comprobar diagonales
    if (matriz[0][0] == matriz[1][1] && matriz[1][1] == matriz[2][2]) {
        return matriz[0][0];
    }

    if (matriz[0][2] == matriz[1][1] && matriz[1][1] == matriz[2][0]) {
        return matriz[0][2];
    }



   
         
        return 0;
    
    } 
     /**
     * En caso de Ganador, mostrará la ventana, dentro del tablero; con el 
     * mensaje de enhorabuena al gandador; y le preguntará si desea continuar 
     * jugando.Se valorará el código limpio, comprensible, organizado y optimizado; 
     *  se puede implementar en 3 o 4 líneas de código
     *  Obligatorio utilizar el operador condicional ?
     * @param mensajeGanador (Contiene el mensaje para el ganador siguiendo las
     * especificaciones del enunciado; tiene que aparecer el nombre del Onliner; 
     * el jugador que ha ganado; y preguntar si quiere seguir jungando)
     * @param jp (panel donde está situado el tablero)
     * variable local String mensajeGanador
     */   
    public void mostrarVentanaGanador(javax.swing.JPanel jp) {
        String mensajeGanador = "¡Enhorabuena, jugador " + (turno == 0 ? "X" : "O") + "!\n¿Deseas continuar jugando?";
        int opcionElegida = JOptionPane.showConfirmDialog(null, mensajeGanador, "Enhorabuena Ganador", JOptionPane.YES_NO_OPTION);

        if (opcionElegida == JOptionPane.YES_OPTION) {
            // Continuar jugando, iniciar una nueva partida
            // El maestro en la videotutoria lo tiene vacio, porque no hace nada.
        } else {
            // Salir del juego o realizar otra acción(poner que cierre la aplicacion)
            // Puedes implementar esto según tus necesidades
//             JFrame frame = (JFrame) jp.getTopLevelAncestor();
//             frame.dispose();
            System.exit(0);
        }
    }
     
    /**
     * Deshabilitará el botón para evitar que se vuelva a posicionar una ficha en ese hueco
     * @param bt (Botón seleccionado)
     * @param x (Posición x en el tablero)
     * @param y (Posición y en el tablero)
     * @param matriz (Tablero de juego)
     * @param jp (Panel dónde se sitúa el tablero de juego)
     * @param lX (JLabel del jugador X)
     * @param lO (JLabel del jugador O)
     * @return 
     */
    public int tiradaJugador(javax.swing.JButton bt, int x, int y, 
            int matriz[][], javax.swing.JPanel jp, 
            javax.swing.JLabel lX, javax.swing.JLabel lO){
        // Inserta código aquí...
        // Deshabilita el botón
       // Insertar la ficha en el botón
        // Comprobar si se ha ganado la partida y mostrar la ventana con el
        // mensaje cuando corresponda         
         // Deshabilitar tablero}
    
      if (habilitado) {
        // Llama al método para poner la ficha en la matriz y actualizar la representación visual en el botón
        ponerFicha(matriz, x, y, bt);

        // Comprueba si hay un ganador
        int resultado = comprobarJuego(matriz);
        if (resultado != 0) {
            // Si hay un ganador, muestra la ventana de ganador y actualiza la puntuación
            mostrarVentanaGanador(jp);
            ganador(lX, lO);

            // Deshabilita el tablero hasta que se inicie una nueva partida
            habilitado = false;
        } else {
            // Si no hay un ganador, cambia el turno
            cambioTurno();
        }
      
        // Devuelve el nuevo turno
        return turno;
        
      }
        return turno;
     }
    /**
     * Actualizar la puntuación de cada jugador al ganar la partida
     * Al finalizar el incremento de puntuación es necesario cambiar de turno
     * @param lX (JLabel del jugador X)
     * @param lO (JLabel del jugador O)
     */
    public void ganador(javax.swing.JLabel lX, javax.swing.JLabel lO){
        // Inserta código aquí...        
        // Incrementa jugador ganador e inserta resultado en jLabel    
       if(turno==0){
           pX++;
           lX.setText(String.valueOf(pX));
       }else{
           pO++;
            lO.setText(String.valueOf(pO));
       }
    }
    
    /**
     * Habilitará o deshabilitará el tablero dependiendo del estado de la variable 
     * GLOBAL a la clase LogicaJuego: habilitado
     * @param jp  (Panel dónde se sitúa el tablero de juego)
     */
    public void habilitarTablero( javax.swing.JPanel jp){
        // Inserta código aquí...
        // Bloquea todos los elementos del JPanel
       for (Component component : jp.getComponents()) {
        if (component instanceof JButton) {
            JButton button = (JButton) component;
            button.setEnabled(habilitado);
        }
       
    }
    }  
    /**
     * En ponerFicha, Insertaremos la ficha en la posición correspondiente de la matriz
     * Llamaremos al método pintarFicha
     * @param matriz (Tablero de juego)
     * @param x (Posición x en el tablero)
     * @param y (Posición y en el tablero)
     * @param bt (Botón pulsado)
     * turno  (para saber que ficha poner)
     */
    public void ponerFicha(int matriz[][], int x, int y, javax.swing.JButton bt){
        // Inserta código aquí... 
     
        
        // Insertar ficha en la posición de la matriz
        // mostrar la ficha correspondiente
        
        
       if (matriz[x][y] == 0) {
        // Asigna el valor correspondiente al jugador en la matriz
        matriz[x][y] = (turno == 0) ? 1 : 2;
        
        // Llama al método para actualizar la representación visual en el botón
        pintarFicha(bt);
    }
}
    
    
    /**
     * Pintará la ficha en el tablero de juego visual, es decir, en el botón
     * @param bt (Botón pulsado)
     */
    
    private void pintarFicha(javax.swing.JButton bt){
        // Inserta código aquí...
        // Si el turno es de 0 mostrará una X en rojo
        // Si el turno es de 1, mostrará una O en azul 
      
        if (this.getTurno() == 0) {
            bt.setForeground(Color.red);
            bt.setText("X");
        } else {
            bt.setForeground(Color.blue);
            bt.setText("O");
        }
        
    }   
          
    
    /**
     * Inicializa una nueva partida, reinicia la matriz (Tablero de juego) y habilita el tablero
     * 
     * ¡¡¡¡No es necesario modificar este método!!!!.
     * 
     * @param matriz (Tablero de juego)
     * @param jp (Panel dónde se sitúa el tablero de juego)
     */
    public void iniciarPartida(int matriz[][], javax.swing.JPanel jp){
        // Rellenamos la matriz por primera vez, evitando que se repitan los números
        for (int x = 0; x < 3; x++){
            for (int y = 0; y < 3; y++){
                matriz[x][y]=(x+10)*(y+10);
            }
        }

        // Habilitar tablero
         habilitado = true;
         habilitarTablero(jp);
    }
   
}
