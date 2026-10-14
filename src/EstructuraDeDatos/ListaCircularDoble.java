
package EstructuraDeDatos;


public class ListaCircularDoble {
    private Nodo inicio;
    private Nodo finalNodo;
    private Nodo actual;
    private int size;
    private int contadorId;

    public ListaCircularDoble() {
        this.inicio = null;
        this.finalNodo = null;
        this.actual = null;
        this.size = 0;
        this.contadorId = 1;
    }

    public boolean estaVacia() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public Nodo getActual() {
        return actual;
    }

    
    public void agregarInicio(String titulo, String artista, int duracion) {
        if (duracion <= 0) {
            System.out.println("Error: La duración debe ser mayor a cero.");
            return;
        }
        Cancion nuevaCancion = new Cancion(contadorId++, titulo, artista, duracion);
        Nodo nuevoNodo = new Nodo(nuevaCancion);

        if (estaVacia()) {
            inicio = nuevoNodo;
            finalNodo = nuevoNodo;
            inicio.setSiguiente(inicio);
            inicio.setAnterior(inicio);
            actual = nuevoNodo; 
        } else {
            nuevoNodo.setSiguiente(inicio);
            nuevoNodo.setAnterior(finalNodo);
            finalNodo.setSiguiente(nuevoNodo);
            inicio.setAnterior(nuevoNodo);
            inicio = nuevoNodo;
            
        }
        size++;
        System.out.println("Canción agregada al inicio: " + nuevaCancion);
    }

    
    public void agregarFinal(String titulo, String artista, int duracion) {
        if (duracion <= 0) {
            System.out.println("Error: La duración debe ser mayor a cero.");
            return;
        }
        Cancion nuevaCancion = new Cancion(contadorId++, titulo, artista, duracion);
        Nodo nuevoNodo = new Nodo(nuevaCancion);

        if (estaVacia()) {
            inicio = nuevoNodo;
            finalNodo = nuevoNodo;
            inicio.setSiguiente(inicio);
            inicio.setAnterior(inicio);
            actual = nuevoNodo; 
        } else {
            nuevoNodo.setSiguiente(inicio);
            nuevoNodo.setAnterior(finalNodo);
            finalNodo.setSiguiente(nuevoNodo);
            inicio.setAnterior(nuevoNodo);
            finalNodo = nuevoNodo;
            
        }
        size++;
        System.out.println("Canción agregada al final: " + nuevaCancion);
    }

    
    public Nodo buscarPorId(int id) {
        if (estaVacia()) return null;
        Nodo actualRecorrido = inicio;
        for (int i = 0; i < size; i++) {
            if (actualRecorrido.getCancion().getId() == id) {
                return actualRecorrido;
            }
            actualRecorrido = actualRecorrido.getSiguiente();
        }
        return null;
    }

    
    public void seleccionarPorId(int id) {
        if (estaVacia()) {
            System.out.println("La lista de reproducción está vacía.");
            return;
        }
        Nodo encontrado = buscarPorId(id);
        if (encontrado != null) {
            actual = encontrado;
            System.out.println("Canción actual actualizada a: " + actual.getCancion());
        } else {
            System.out.println("No se encontró ninguna canción con el ID: " + id);
        }
    }

    
    public void eliminarPorId(int id) {
        if (estaVacia()) {
            System.out.println("La lista de reproducción está vacía.");
            return;
        }

        Nodo nodoAEliminar = buscarPorId(id);
        if (nodoAEliminar == null) {
            System.out.println("No se encontró ninguna canción con el ID: " + id);
            return;
        }

        eliminarNodo(nodoAEliminar);
        System.out.println(" Canción con ID " + id + " eliminada correctamente.");
    }

    
    public void eliminarActual() {
        if (estaVacia()) {
            System.out.println(" La lista de reproducción está vacía.");
            return;
        }
        if (actual == null) {
            System.out.println("No hay ninguna canción seleccionada actualmente.");
            return;
        }
        Cancion c = actual.getCancion();
        eliminarNodo(actual);
        System.out.println(" Canción actual eliminada: " + c);
    }

    
    private void eliminarNodo(Nodo nodo) {
        if (size == 1) {
            inicio = null;
            finalNodo = null;
            actual = null;
        } else {
            Nodo ant = nodo.getAnterior();
            Nodo sig = nodo.getSiguiente();

            ant.setSiguiente(sig);
            sig.setAnterior(ant);

            if (nodo == inicio) {
                inicio = sig;
            }
            if (nodo == finalNodo) {
                finalNodo = ant;
            }

            
            if (nodo == actual) {
                actual = sig;
            }
            
        }
        size--;
    }

    
    public void consultarActual() {
        if (estaVacia() || actual == null) {
            System.out.println("No hay ninguna canción reproduciéndose (lista vacía).");
        } else {
            System.out.println("[Canción Actual] " + actual.getCancion());
        }
    }

    
    public void avanzar() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }
        actual = actual.getSiguiente();
        System.out.println("Avanzando...");
        consultarActual();
    }

    
    public void retroceder() {
        if (estaVacia()) {
            System.out.println("La lista está vacía.");
            return;
        }
        actual = actual.getAnterior();
        System.out.println("Retrocediendo...");
        consultarActual();
    }

    
    public void mostrarLista() {
        if (estaVacia()) {
            System.out.println("La lista de reproducción está vacía.");
            return;
        }

        System.out.println("\n---LISTA HACIA ADELANTE ---");
        Nodo curr = inicio;
        for (int i = 0; i < size; i++) {
            String indicador = (curr == actual) ? "[ACTUAL]" : "";
            System.out.println("  " + curr.getCancion() + indicador);
            curr = curr.getSiguiente();
        }

        System.out.println("\n---LISTA HACIA ATRÁS ---");
        curr = finalNodo;
        for (int i = 0; i < size; i++) {
            String indicador = (curr == actual) ? "[ACTUAL]" : "";
            System.out.println("  " + curr.getCancion() + indicador);
            curr = curr.getAnterior();
        }
        System.out.println("--------------------------------\n");
    }

    
    public int consultarCantidad() {
        return size;
    }

    
    public void simularReproduccion(int k) {
        if (estaVacia()) {
            System.out.println(" La lista está vacía. No se puede simular reproducción.");
            return;
        }
        if (k <= 0) {
            System.out.println("Error: La cantidad 'k' debe ser un entero positivo.");
            return;
        }

        System.out.println("\nIniciando simulación de reproducción de " + k + " canciones:");
        for (int i = 1; i <= k; i++) {
            System.out.println("Paso " + i + " -> Reproduciendo: " + actual.getCancion());
            actual = actual.getSiguiente();
        }
        System.out.println("Fin de la simulación. La canción actual quedó en: " + actual.getCancion() + "\n");
    }
}