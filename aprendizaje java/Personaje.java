public class Personaje {
    private String nombre;
    private String raza;
    private int ki;
    private int ataque;
    private String planeta;
    private int poder; 

    public Personaje(String nombre, String raza, int ki, int ataque, String planeta, int poder) {
        this.nombre = nombre;
        this.raza = raza;
        this.ki = ki;
        this.ataque = ataque;
        this.planeta = planeta;
        this.poder = poder;
    }

    public void mostrarPersonaje() {
        System.out.println("\n=== ESTADO DEL PERSONAJE ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Raza: " + raza);
        System.out.println("Ki: " + ki);
        System.out.println("Ataque: " + ataque);
        System.out.println("Planeta: " + planeta);
        System.out.println("Poder: " + poder);
    }

    public void atacar(Personaje objetivo) {
        System.out.println("\n" + this.nombre + " ataca a " + objetivo.nombre + " con un ataque de " + this.ataque + " puntos de ki.");
        
        objetivo.ki -= this.ataque;
        if (objetivo.ki < 0) {
            objetivo.ki = 0;
        }
        
        System.out.println(objetivo.nombre + " ahora tiene " + objetivo.ki + " puntos de ki.");
    }

    public void curar(int cantidad) {
        this.ki += cantidad;
        System.out.println("\n" + this.nombre + " se ha curado " + cantidad + " puntos de ki.");
        System.out.println("Ki actual: " + this.ki);
    }

    public static void main(String[] args) {
        // Creación de personajes con todos los parámetros necesarios (incluyendo poder)
        Personaje goku = new Personaje("Gokú", "Saiyajin", 1000, 100, "Tierra", 9000);
        Personaje vegeta = new Personaje("Vegeta", "Saiyajin", 950, 95, "Vegeta", 8500);

        // Mostrar estado inicial
        System.out.println("=== ESTADO INICIAL ===");
        goku.mostrarPersonaje();
        vegeta.mostrarPersonaje();

        // Simulación de batalla
        goku.atacar(vegeta);
        vegeta.atacar(goku);
        
        // Vegeta se cura
        vegeta.curar(200);
        
        // Segundo ataque
        goku.atacar(vegeta);
        
        // Mostrar estado final
        System.out.println("\n=== ESTADO FINAL ===");
        goku.mostrarPersonaje();
        vegeta.mostrarPersonaje();
    }
}



