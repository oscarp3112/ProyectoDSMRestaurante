package sv.edu.udb.proyectodsm.Data;

public class modeloPedidos {
    String Fecha, Pedido;
    double Total;

    modeloPedidos()
    {

    }

    public modeloPedidos(String Pedido, String Fecha, double Total) {
        this.Pedido = Pedido;
        this.Fecha = Fecha;
        this.Total = Total;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String fecha) {
        Fecha = fecha;
    }

    public String getPedido() {
        return Pedido;
    }

    public void setPedido(String pedido) {
        Pedido = pedido;
    }

    public double getTotal() {
        return Total;
    }

    public void setTotal(double total) {
        Total = total;
    }
}