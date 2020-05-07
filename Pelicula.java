
public class Pelicula {

    // Atributos
    private String titulo;
    private String genero; // "Accion - Aventura"
    private String imagen; // "resources/harrypotter.jpg"

    public Pelicula(String titulo, String genero, String imagen){
        this.titulo = titulo;
        this.genero = genero;
        this.imagen = imagen;
    }

    public String getTitulo(){
        String titulo = this.titulo;
        return titulo;
    }

    public String getGenero(){
        String genero = this.genero;
        return genero;
    }

    public String getImagen(){
        String imagen = this.imagen;
        return imagen;
    }
    
}