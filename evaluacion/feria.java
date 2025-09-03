class Inventor {
    private String nombre;
    private int edad;
    private String nivelCreatividad;
    private int creativityPoints; 

    public  Inventor(String nombre, int edad, String nivelCreatividad) {
        this.nombre = nombre;
        this.edad = edad;
        this.nivelCreatividad = nivelCreatividad;
        this.creativityPoints = 0; 
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    protected String getNivelCreatividad() {
        return nivelCreatividad;
    }

    public int getCreativityPoints() { 
        return creativityPoints;
    }

    public void ganarPuntos(int puntos) {
        creativityPoints += puntos; 
        if (creativityPoints >= 25) {
            nivelCreatividad = "Alta";
        } else if (creativityPoints >= 15) {
            nivelCreatividad = "Media";
        } else {
            nivelCreatividad = "Baja";
        }
        System.out.println(nombre + " se ganó " + puntos + " puntos. Nivel actual: " + nivelCreatividad + " (" + creativityPoints + " puntos)");
    }

   
    public void presentarInvento() {
        System.out.println("Hola, soy " + nombre + " y tengo un invento para presentar.");
    }

    @Override
    public String toString() {
        return "Inventor: " + nombre + ", Edad: " + edad + ", Creatividad: " + nivelCreatividad;
    }
}

class InventorMecanico extends Inventor {
    private String tipoMaquina;

    public InventorMecanico(String nombre, int edad, String nivelCreatividad, String tipoMaquina) {
        super(nombre, edad, nivelCreatividad);
        this.tipoMaquina = tipoMaquina;
    }

    @Override
    public void presentarInvento() {
        System.out.println("Hola Soy " + getNombre() + " y les traigo mi " + tipoMaquina);
        System.out.println("Mi máquina tiene " + getNivelCreatividad() + " puntos de creatividad");
        System.out.println("Miren como funciona ...");
        System.out.println("Enciende la máquina con movimientos precisos");
        System.out.println("que tal le parecio el resultado de mi maquina");
        System.out.println();
    }
}

class InventorSoftware extends Inventor {
    private String lenguajeProgramacion;

    public InventorSoftware(String nombre, int edad, String nivelCreatividad, String lenguajeProgramacion) {
        super(nombre, edad, nivelCreatividad);
        this.lenguajeProgramacion = lenguajeProgramacion;
    }

    @Override
    public void presentarInvento() {
        System.out.println("Hola Soy "+ getNombre());
        System.out.println("Programé esta aplicación en " + lenguajeProgramacion + " que está gusta mucho");
        System.out.println("Con " + getNivelCreatividad() + " puntos de creatividad, miren esta maravilla:");
        System.out.println("Abre la laptop y ejecuta el código");
        System.out.println("vieron la interfaz de mi pagina ");
        System.out.println("Esta app va a estar muy buena");
        System.out.println();
    }
}

class InventorQuimico extends Inventor {
    private String tipoExperimento;

    public InventorQuimico(String nombre, int edad, String nivelCreatividad, String tipoExperimento) {
        super(nombre, edad, nivelCreatividad);
        this.tipoExperimento = tipoExperimento;
    }

    @Override
    public void presentarInvento() {
        System.out.println("Señores del jurado, mi nombre es " + getNombre());
        System.out.println("Hoy les presento mi experimento de " + tipoExperimento);
        System.out.println("Este experimento tiene " + getNivelCreatividad() + " puntos de creatividad");
        System.out.println("Mezcla cuidadosamente los químicos");
        System.out.println(" miren esa reacción tan brutal!");
        System.out.println("Esta fórmula va a revolucionar la ciencia");
        System.out.println();
    }
}

public class feria {
    public static void main(String[] args) {
        Inventor[] inventores = {
            new InventorMecanico("Juan", 16, "Alta", "Robot Asistente"),
            new InventorSoftware("Ana", 15, "Media", "Java"),
            new InventorQuimico("Luis", 17, "Baja", "Reacción de Colores"),
            new InventorMecanico("Maria", 16, "Alta", "Dron de Entrega"),
            new InventorSoftware("Carlos", 15, "Media", "Python")
        };

        System.out.println("=== FERIA DE CIENCIA - COMPETENCIA DE INVENTORES ===");
        System.out.println();
        System.out.println("INVENTORES REGISTRADOS:");
        for (Inventor inventor : inventores) {
            System.out.println(inventor);
        }
        System.out.println();
        System.out.println("=== RONDA DE PUNTOS DE CREATIVIDAD ===");
        inventores[0].ganarPuntos(15);
        inventores[1].ganarPuntos(20);
        inventores[2].ganarPuntos(10);
        inventores[3].ganarPuntos(25);
        inventores[4].ganarPuntos(5);
        System.out.println();
        System.out.println("=== PRESENTACIONES ANTE EL JURADO ===");
        for (Inventor inventor : inventores) {
            inventor.presentarInvento();
        }
        System.out.println("¡La competencia estuvo muy bacana! Todos los inventores mostraron sus proyectos únicos.");
    }

}
