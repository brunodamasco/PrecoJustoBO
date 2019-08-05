package bd.mercado.model;

public class ProdutoBO {
    private Produto produto;

    public ProdutoBO() {
    }

    public ProdutoBO(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public static boolean validaNome(Produto p) {
        return p.getNome() != null;
    }

    public static boolean validaValor(Produto p) {
        return p.getValor() != null;
    }

    public static boolean validaParcela(Produto p) {
        return p.getParcela() != null;
    }

    public static boolean validaJuros(Produto p) {
        return p.getJuros() != null;
    }

    public double juros(){
        return (produto.getValor() * produto.getJuros()/100);
    }

    private double jurosEntrada(){
        return juros() - (juros() * 0.05);
    }

    public double valorParcela(){
        return valorTotal() / produto.getParcela();
    }

    public double parcelaEntrada(){
        return (valorTotal() / produto.getParcela()) + (jurosEntrada() / produto.getParcela());
    }

    public double valorTotal(){
        return produto.getValor() + juros();
    }

    public double valorEntrada(){
        return parcelaEntrada() * produto.getParcela();
    }

    @Override
    public String toString() {
        return "Produto: " + produto.getNome() + "\n" +
                "Valor inicial: R$ " + produto.getValor() + "\n" +
                "Valor das parcelas: R$ " + valorParcela() + "\n" +
                "Valor total: R$ " + valorTotal() + "\n" +
                "Total de juros: R$ " + juros();

    }
}
