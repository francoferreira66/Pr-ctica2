package repositorio;

import Modelo.Vehiculos;
import java.util.HashMap;
import java.util.Map;
import java.util.Comparator;

public class RepositorioVehiculo implements RepositorioV<Vehiculos> {

    // La clave del mapa es la chapa del vehículo
    private final Map<String, Vehiculos> vehiculos = new HashMap<>();

    //Ejercicio 1: CRUD
    @Override
    public void crear(Vehiculos v) {
        if (vehiculos.containsKey(v.getChapa())) {
            System.out.println("Error: El vehículo con chapa " + v.getChapa() + " ya existe.");
        } else {
            vehiculos.put(v.getChapa(), v);
            System.out.println("Vehículo registrado: " + v.getChapa());
        }
    }

    @Override
    public void listar() {
        if (vehiculos.isEmpty()) {
            System.out.println("No hay vehículos en la flota logistica.");
        } else {
            vehiculos.forEach((chapa, v) ->
                System.out.printf("Chapa/ID: %-10s | Marca: %-12s | Modelo/Tipo: %-12s | Año: %d | Conectable: %b%n",
                    chapa, v.getMarca(), v.getModelo(), v.getAnhoFabricacion(), v.isConectable())
            );
        }
    }

    @Override
    public void buscarV(String id) {
        if (!vehiculos.containsKey(id)) {
            System.out.println("El vehículo con Chapa/ID " + id + " no existe.");
        } else {
            Vehiculos v = vehiculos.get(id);
            System.out.println("Vehículo encontrado:");
            System.out.printf("  Chapa/ID            : %s%n", v.getChapa());
            System.out.printf("  Marca               : %s%n", v.getMarca());
            System.out.printf("  Modelo/Tipo         : %s%n", v.getModelo());
            System.out.printf("  Año de Fabricación  : %d%n", v.getAnhoFabricacion());
            System.out.printf("  Conectable          : %b%n", v.isConectable());
        }
    }

    @Override
    public void editar(String id, Vehiculos v) {
        if (!vehiculos.containsKey(id)) {
            System.out.println("Error: El vehículo con Chapa/ID " + id + " no existe.");
        } else {
            vehiculos.put(id, v);
            System.out.println("Vehículo con Chapa/ID " + id + " actualizado exitosamente.");
        }
    }

    @Override
    public void borrar(String id) {
        if (!vehiculos.containsKey(id)) {
            System.out.println("Error: El vehículo con Chapa/ID " + id + " no existe.");
        } else {
            vehiculos.remove(id);
            System.out.println("Vehículo con Chapa/ID " + id + " eliminado.");
        }
    }

    //Ejercicio 2: Lambda
    @Override
    public void mostrarConLambda() {
        System.out.println("\n--- Mapeo de Flota (Lambda forEach) ---");
        vehiculos.forEach((chapa, v) ->
            System.out.printf("Chapa: %-10s -> [%s, %s]%n", chapa, v.getMarca(), v.getModelo())
        );
    }

    //Ejercicio 3: Streams
    @Override
    public void filtrarConectables() {
        System.out.println("\n--- Vehículos Conectables (Streams Filter) ---");
        vehiculos.values().stream()
            .filter(Vehiculos::isConectable)
            .forEach(v -> System.out.printf("Chapa: %-10s | Tipo: %-12s | Estado: Conectado%n", v.getChapa(), v.getModelo()));
    }

    @Override
    public void obtenerListaIds() {
        System.out.println("\n--- Mapeo de IDs/Chapas en Sistema ---");
        vehiculos.keySet().stream()
            .sorted()
            .forEach(chapa -> System.out.printf("ID Identificado: %s%n", chapa));
    }

    @Override
    public long contarVehiculos() {
        long total = vehiculos.values().stream().count();
        System.out.printf("Conteo de Flota por Streams: %d unidades.%n", total);
        return total;
    }

    @Override
    public void buscarPorTipo(String tipo) {
        vehiculos.values().stream()
            .filter(v -> v.getModelo().equalsIgnoreCase(tipo))
            .forEach(v -> System.out.printf("Chapa: %-10s | Marca: %-12s | Tipo: %s%n", v.getChapa(), v.getMarca(), v.getModelo()));
    }

    //Ejercicio 4: Ordenamiento
    @Override
    public void ordenarPorId() {
        System.out.println("\n--- Ordenado Alfabéticamente por ID (Chapa) ---");
        vehiculos.values().stream()
            .sorted(Comparator.comparing(Vehiculos::getId))
            .forEach(v -> System.out.printf("ID: %-10s | Tipo: %s%n", v.getId(), v.getModelo()));
    }

    @Override
    public void ordenarPorTipo() {
        System.out.println("\n--- Ordenado Alfabéticamente por Tipo (Modelo) ---");
        vehiculos.values().stream()
            .sorted(Comparator.comparing(Vehiculos::getModelo))
            .forEach(v -> System.out.printf("Tipo: %-12s | ID/Chapa: %s%n", v.getModelo(), v.getId()));
    }
}