import java.awt.*;
import javax.swing.*;

public class Cine extends JFrame {

    // Componentes
    private JPanel cPrincipal, cCelda, cImagen, cTextos;
    private JLabel lblImagen, lblTitulo, lblGenero;

    private JScrollPane scroll;

    // Lista de peliculas
    private Pelicula[] peliculas;

    // Tamaños:
    private int ventana_sizeX = 480, ventana_sizeY = 640;

    private int celda_sizeX = 460, celda_sizeY = 260;

    private int imagen_sizeX = 180, imagen_sizeY = celda_sizeY;

    public Cine() {
        initVentana();
        initComponentes();

    }

    private void initVentana() {
        this.setTitle("Cartelera de Cine");
        this.setSize(ventana_sizeX, ventana_sizeY);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void initComponentes() {
        initPanel();
        crearPeliculas();
        initCeldas(); // Por cada pelicula, se genera una celda.
    }

    private void initPanel() {
        // Contenedor principal.
        cPrincipal = new JPanel();
        cPrincipal.setLayout(new BoxLayout(cPrincipal, BoxLayout.Y_AXIS));
        cPrincipal.setBackground(Color.WHITE);
        this.add(cPrincipal);

        scroll = new JScrollPane(cPrincipal);
        cPrincipal.setAutoscrolls(true);
        this.add(scroll);

    }

    private void crearPeliculas() {
        peliculas = new Pelicula[3];
        peliculas[0] = new Pelicula("Spiderman", "Accion", "resources/spiderman.jpg");
        peliculas[1] = new Pelicula("Harry Potter", "Aventuras", "resources/harrypotter.jpg");
        peliculas[2] = new Pelicula("Naruto: The last", "Anime", "resources/naruto.jpg");
    }

    private void initPanelesPeliculas() {
        // Celdas por cada pelicula
        cCelda = new JPanel();
        cCelda.setMinimumSize(new Dimension(celda_sizeX, celda_sizeY));
        cCelda.setLayout(new BorderLayout());
        cCelda.setBackground(Color.WHITE);
        cPrincipal.add(cCelda);

        // Portada de celda
        cImagen = new JPanel();
        cImagen.setBackground(Color.WHITE);
        cImagen.setSize(imagen_sizeX, imagen_sizeY); // para la imagen.
        cCelda.add(cImagen, BorderLayout.WEST);

        // Datos ce celda
        cTextos = new JPanel();
        cTextos.setBackground(Color.WHITE);
        cTextos.setPreferredSize(new Dimension(celda_sizeX - imagen_sizeX - 20, imagen_sizeY)); // La altura debe
                                                                                                // coincidir con la
                                                                                                // altura de la imagen
        cTextos.setLayout(new BoxLayout(cTextos, BoxLayout.Y_AXIS));
        cCelda.add(cTextos, BorderLayout.EAST);

    }

    private void initContenidoPeliculas(int num) {
        // Portada pelicula
        ImageIcon imagenOriginal = new ImageIcon(peliculas[num].getImagen()); // string de la ruta a la pelicula
        Icon imagenAdaptada = new ImageIcon(imagenOriginal.getImage().getScaledInstance(cImagen.getWidth(),
                cImagen.getHeight(), Image.SCALE_DEFAULT));
        // Debe ser igual al tamaño del panel

        lblImagen = new JLabel();
        lblImagen.setIcon(imagenAdaptada);
        cImagen.add(lblImagen);

        // ETIQUETA DEL TITULO

        lblTitulo = new JLabel(peliculas[num].getTitulo(), SwingConstants.CENTER);
        cTextos.add(lblTitulo);

        // ETIQUETA DEL GENERO
        lblGenero = new JLabel(peliculas[num].getGenero(), SwingConstants.CENTER);
        cTextos.add(lblGenero);
    }

    private void initCeldas() {

        for (int i = 0; i < peliculas.length; i++) {
            initPanelesPeliculas();
            initContenidoPeliculas(i);
        }

    }

    public static void main(String[] args) {
        Cine c = new Cine();
        c.setVisible(true);
    }

}