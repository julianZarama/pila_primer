import java.util.ArrayList;
import java.util.Scanner;

public class Pila {
    private ArrayList<Integer> datos;
    private int maxSize; 


    public Pila(int maxSize) {
        this.maxSize = maxSize;
        datos = new ArrayList<>(maxSize); 
    }

    public void push(int valor) {
        if (isFull()) {
            System.out.println("La pila está llena.");
        } else {
            datos.add(valor);
            System.out.println("Elemento " + valor + " agregado a la pila.");
        }
    }
    public Integer pop(){
        if(isEmpty()){
            System.out.println("La pila esta vacia.No se puede desapilar");
            return null;
        }else{
            int valor= datos.remove(datos.size()-1);
            System.out.println("ELement0 "+valor +" desapilado.");
            return valor;
        }
    }
    public Integer top(){
        if(isEmpty()){
            System.out.println("La pila esta vacia. No hay tope.");
            return null;

        }else{
            return datos.get(datos.size()-1);
        }

    }
    public boolean isEmpty() {
        return datos.isEmpty();
    }

    public boolean isFull() {
        return datos.size() == maxSize;
    }

    public void mostrarPila() {
        if (isEmpty()) {
            System.out.println("La pila está vacía.");
        } else {
            System.out.println("Elementos en la pila: " + datos);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese el tamaño máximo de la pila (0 para ilimitado): ");
        int maxSize = sc.nextInt();
        Pila pila = new Pila(maxSize);

        int opcion;

        do {
            System.out.println("------------------------");
            System.out.println("---------- MENÚ ----------");
            System.out.println("------------------------");
            System.out.println("1. Apilar o insertar elemento");
            System.out.println("2. Desapilar elemento");
            System.out.println("3. Obtener el tope de la pila");
            System.out.println("4. Mostrar elementos de la pila");
            System.out.println("5. Verificar si la pila está vacía");
            System.out.println("6. Verificar si la pila está llena");
            System.out.println("7. Obtener el tamaño de la pila");
            System.out.println("8. Vaciar la pila");
            System.out.println("9. Salir");
            System.out.println("-------------------------");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingresa el valor a agregar en la pila: ");
                    int valor = sc.nextInt();
                    pila.push(valor);
                    break;
                case 2:
                pila.pop();
                break;
                   //dasapilar
                case 3:
                Integer tope = pila.top();
                if(tope!= null){
                    System.out.println("El tope de la pila es: "+tope);
                }
                //obtener tope
                case 4:
                pila.mostrarPila();
                break;
                    //mostrar elementos de esta pila
                case 5:
 
                    if (pila.isEmpty()) {
                        System.out.println("Esta vacia.");
                    }else{
                        System.out.println("Tiene elementos.");
                    } 
                    break;
                case 6:
                    
                    if (pila.isFull()) {
                        System.out.println("La Pila esta llena.");
                    }else{
                        System.out.println("Le faltan elementos.");
                    }
                    break;
                case 7:
                    System.out.println("El tamaño de la pila es: " + maxSize);
                    break;
                case 8:
                    pila.datos.clear();
                    System.out.println("La pila ha sido vaciada.");
                    break;
                case 9:
                System.out.println("Saliendo del programa. ¡CHAO! :)");
                    
                    return; 
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 9);
    }
}