/*En un reino lejano, diferentes tipos de personajes habitan y cada uno guarda un secreto. Todos comparten rasgos comunes que los hacen parte del mismo mundo, pero a la hora de actuar, cada uno responde de manera única: algunos sorprenden con su fuerza, otros con su inteligencia, y otros con habilidades inesperadas.
Sin embargo, no cualquiera puede modificar sus datos más importantes, ya que están protegidos bajo reglas estrictas que solo permiten cambios de forma controlada.

Tu misión es crear en Java un programa que modele este mundo de personajes, asegurando que:

Los aspectos comunes estén organizados en un mismo lugar.
Cada tipo de personaje pueda expresar sus propias variaciones en las acciones.
La información delicada esté resguardada para que no cualquiera la manipule directamente. */

import java.util.Random;

public class Historia {

   private String nombre;
   private String rasgos;
   private String mundo;
   private String[] habilidad = {"fuerza","inteligencia","habilidad inesperada"};

   public Historia(String nombre, String rasgos, String mundo, String[] habilidad) {
       this.nombre = nombre;
       this.rasgos = rasgos;
       this.mundo = mundo;
       this.habilidad = habilidad;
   }
   
   public String getNombre() {
       return nombre;
   }

   public void setNombre(String nombre) {
       this.nombre = nombre;
   }

   public String getRasgos() {
       return rasgos;
   }

   public void setRasgos(String rasgos) {
       this.rasgos = rasgos;
   }

   public String getMundo() {
       return mundo;
   }

   public void setMundo(String mundo) {
       this.mundo = mundo;
   }

   public String[] getHabilidad() {
       return habilidad;
   }

   public void setHabilidad(String[] habilidad) {
       this.habilidad = habilidad;
   }

 
   public String getHabilidadAleatoria() {
       Random random = new Random();
       int indiceAleatorio = random.nextInt(habilidad.length);
       return habilidad[indiceAleatorio];
   }

   protected void mostrarHabilidad() {
       System.out.println("Habilidades disponibles: " + java.util.Arrays.toString(habilidad));
   }

   class Guerrero extends Historia {
       public Guerrero(String nombre, String rasgos, String mundo, String[] habilidad) {
           super(nombre, rasgos, mundo, habilidad);
       }

       @Override
       protected void mostrarHabilidad() {
           
           System.out.println("El guerrero " + nombre + " del mundo "+ mundo + " con los rasgos " + rasgos + " tiene la habilidad especial de: " + getHabilidadAleatoria());
           
          
       }
   }
}

class Main {
   public static void main(String[] args) {
       String[] habilidadesGuerrero = {"fuerza", "inteligencia", "habilidad inesperada"};
       
       Historia historia = new Historia("Reino Mágico", "valiente", "Fantasia", habilidadesGuerrero);


       
       Historia.Guerrero guerrero = historia.new Guerrero("Aragorn", "valiente", "Fantasia", habilidadesGuerrero);
     
      
       for (int i = 1; i <= 1; i++) {
           guerrero.mostrarHabilidad();
       }
   }
}













    

