package edu.dam.tiendahierro;

public class Productos {
    private String cantidad;
    private String producto;
    private String precio;
    private String id, tipo;
    private int imageView;

    public Productos(String id, String producto, String precio, int imageView, String tipo, String cantidad ) {
        this.precio = precio;
        this.producto = producto;
        this.id = id;
        this.imageView = imageView;
        this.tipo = tipo;
        this.cantidad = cantidad;
    }


    public String getCantidad() {
        return cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getImageView() {
        return imageView;
    }

    public void setImageView(int imageView) {
        this.imageView = imageView;
    }
}
