package Modelo;

public class Vehiculos {
    private String marca;
    private String modelo; // Actúa como el "Tipo" (SUV, Sedan, Camioneta)
    private int anhoFabricacion;
    private String chapa;  // Este será nuestro Identificador Único (ID)
    private boolean conectable;

    public Vehiculos(String marca, String modelo, int anhoFabricacion, String chapa, boolean conectable) {
        this.marca = marca;
        this.modelo = modelo;
        this.anhoFabricacion = anhoFabricacion;
        this.chapa = chapa;
        this.conectable = conectable;
    }

    // Para cumplir con el getId() que pide el ordenamiento de la guía, retornamos la chapa
    public String getId() {
        return chapa;
    }

    public String getChapa() { return chapa; }
    public void setChapa(String chapa) { this.chapa = chapa; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public int getAnhoFabricacion() { return anhoFabricacion; }
    public void setAnhoFabricacion(int anhoFabricacion) { this.anhoFabricacion = anhoFabricacion; }
    public boolean isConectable() { return conectable; }
    public void setConectable(boolean conectable) { this.conectable = conectable; }
}