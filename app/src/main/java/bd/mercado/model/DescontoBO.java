package bd.mercado.model;

public class DescontoBO {
    private Produto produto;

    public DescontoBO() {
    }

    public DescontoBO(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    private double jurosEntrada(){
        return ((produto.getJuros() - 5) /100) * (produto.getValor() / produto.getParcela());
    }

    private double jurosTotal(){
        return jurosEntrada() * produto.getParcela();
    }

    public double parcelaEntrada(){
        return (produto.getValor() / produto.getParcela()) + jurosEntrada();
    }

    public double valorEntrada(){
        return parcelaEntrada() * produto.getParcela();
    }

    @Override
    public String toString() {
        return "Produto: " + produto.getNome() + "\n" +
                "Valor inicial: R$ " + produto.getValor() + "\n" +
                "Valor das parcelas: R$ " + parcelaEntrada() + "\n" +
                "Valor total: R$ " + valorEntrada() + "\n" +
                "Total de juros: R$ " + jurosTotal();
    }
}
