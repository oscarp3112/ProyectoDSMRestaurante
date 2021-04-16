package sv.edu.udb.proyectodsm;

public class modeloHome {
    String nombre, imgurl, precio, desc;

    modeloHome()
    {

    }

    public modeloHome(String nombre, String imgurl, String precio, String desc) {
        this.nombre = nombre;
        this.imgurl = imgurl;
        this.precio = precio;
        this.desc = desc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
