import java.util.Random;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class HeapSort {
    
    // Función para convertir el vector en un montículo (heapify)
    public static void heapify(int[] vector, int tamaño, int i) {
        int mayor = i; // Asumimos que el nodo actual es el mayor
        int izquierda = 2 * i + 1;
        int derecha = 2 * i + 2;

        // Verificar si el hijo izquierdo es mayor que el nodo actual
        if (izquierda < tamaño && vector[izquierda] > vector[mayor]) {
            mayor = izquierda;
        }

        // Verificar si el hijo derecho es mayor que el nodo actual
        if (derecha < tamaño && vector[derecha] > vector[mayor]) {
            mayor = derecha;
        }

        // Si el mayor no es el nodo actual, hacer el intercambio
        if (mayor != i) {
            int temp = vector[i];
            vector[i] = vector[mayor];
            vector[mayor] = temp;

            // Aplicar heapify nuevamente en el nodo afectado
            heapify(vector, tamaño, mayor);
        }
    }

    // Función principal de Heap Sort
    public static void heapSort(int[] vector) {
        int tamaño = vector.length;

        // Construir el montículo (max-heap)
        for (int i = tamaño / 2 - 1; i >= 0; i--) {
            heapify(vector, tamaño, i);
        }

        // Extraer elementos uno por uno del heap
        for (int i = tamaño - 1; i > 0; i--) {
            // Intercambiar el primer elemento (máximo) con el último disponible
            int temp = vector[0];
            vector[0] = vector[i];
            vector[i] = temp;

            // Llamar a heapify en el subárbol reducido
            heapify(vector, i, 0);
        }
    }

    // Función para mostrar el vector como cadena
    public static String vectorToString(int[] vector) {
        StringBuilder sb = new StringBuilder();
        for (int num : vector) {
            sb.append(num).append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        int tamaño = 10; // Tamaño fijo del vector
        int[] vector = new int[tamaño];
        Random rand = new Random();

        // Llenar el vector con números aleatorios
        for (int i = 0; i < tamaño; i++) {
            vector[i] = rand.nextInt(100); // Números entre 0 y 99
        }

        // Crear una copia del vector original para mostrarlo después
        int[] vectorOriginal = vector.clone();

        // Aplicar Heap Sort
        heapSort(vector);

        // Preparar el texto para mostrar en el JOptionPane
        JTextArea textArea = new JTextArea();
        textArea.append("Vector original (" + tamaño + " elementos):\n");
        textArea.append(vectorToString(vectorOriginal) + "\n\n");
        textArea.append("Vector ordenado:\n");
        textArea.append(vectorToString(vector));

        // Mostrar ambos vectores en un JOptionPane
        JOptionPane.showMessageDialog(null, textArea, "Resultados de Heap Sort", 
                                    JOptionPane.INFORMATION_MESSAGE);
    }
}