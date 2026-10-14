
package EstructuraDeDatos;

public class Cancion {
    private int id;
    private String titulo;
    private String artista;
    private int duracion; 

    public Cancion(int id, String titulo, String artista, int duracion) {
        this.id = id;
        this.titulo = titulo;
        this.artista = artista;
        this.duracion = duracion;
    }

    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getArtista() { return artista; }
    public int getDuracion() { return duracion; }

    @Override
    public String toString() {
        int minutos = duracion / 60;
        int segundos = duracion % 60;
        return String.format("[ID: %d] \"%s\" - %s (%d:%02d min)", id, titulo, artista, minutos, segundos);
    }
}