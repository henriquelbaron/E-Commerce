package br.com.ecommerce.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;

import br.com.ecommerce.dao.ProdutoDao;
import br.com.ecommerce.domain.dto.FornecedorDTO;
import br.com.ecommerce.domain.dto.ProdutoDTO;

@Named
@ViewScoped
public class DashboardBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private ProdutoDao produtoDao;
	private List<ProdutoDTO> produtoDTOs;
	private List<FornecedorDTO> fornecedorDTOs;

	private PieChartModel produtosPorCategoriaModel;
	private PieChartModel produtosPorFornecedorModel;

	private final List<String> gProdutoCategoriaCores = Arrays.asList("#ff8a73", "#e8cd74", "#74d5e8", "#a2ff8c",
			"#c8a3ff");
	private final List<String> gProdutoFornecedorCores = Arrays.asList("#D242FF", "#3C94E8", "#4FFF6F", "#E8D33C",
			"#FF8D57");

	@PostConstruct
	public void init() {
		inicializarGraficoProdutosCategoria();
		inicializarGraficoProdutoFornecedor();
	}

	private void inicializarGraficoProdutosCategoria() {
		produtosPorCategoriaModel = new PieChartModel();
		produtoDTOs = produtoDao.buscaProdutosPorCategoria();

		List<Number> valores = new ArrayList<>();
		List<String> rotulos = new ArrayList<>();

		for (ProdutoDTO dto : produtoDTOs) {
			rotulos.add(dto.getCategoria());
			valores.add(dto.getQuantidadeProdutos());
		}

		PieChartDataSet dataset = new PieChartDataSet();
		dataset.setData(valores);
		dataset.setBackgroundColor(gProdutoCategoriaCores);

		ChartData dados = new ChartData();
		dados.addChartDataSet(dataset);
		dados.setLabels(rotulos);

		produtosPorCategoriaModel.setData(dados);

	}

	private void inicializarGraficoProdutoFornecedor() {
		produtosPorFornecedorModel = new PieChartModel();
		fornecedorDTOs = produtoDao.buscaProdutosPorFornecedor();

		List<Number> valores = new ArrayList<>();
		List<String> rotulos = new ArrayList<>();

		for (FornecedorDTO dto : fornecedorDTOs) {
			rotulos.add(dto.getFornecedor());
			valores.add(dto.getQuantidadeProdutos());
		}

		PieChartDataSet dataset = new PieChartDataSet();
		dataset.setData(valores);
		dataset.setBackgroundColor(gProdutoFornecedorCores);

		ChartData dados = new ChartData();
		dados.addChartDataSet(dataset);
		dados.setLabels(rotulos);

		produtosPorFornecedorModel.setData(dados);

	}

	public PieChartModel getProdutosPorCategoriaModel() {
		return produtosPorCategoriaModel;
	}

	public PieChartModel getProdutosPorFornecedorModel() {
		return produtosPorFornecedorModel;
	}

}
