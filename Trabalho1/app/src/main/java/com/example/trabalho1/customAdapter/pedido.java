package com.example.trabalho1.customAdapter;

public class pedido {
    public pedido(String pedido, String sobremesa) {
        this.pedido = pedido;
        this.sobremesa = sobremesa;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public void setSobremesa(String sobremesa) {
        this.sobremesa = sobremesa;
    }

    String pedido;
    String sobremesa;

    public String toString(){
        String s;
        s = pedido;
        if(!sobremesa.equals("")){
            s += ", "+sobremesa;
        }
        return s;
    }
}
