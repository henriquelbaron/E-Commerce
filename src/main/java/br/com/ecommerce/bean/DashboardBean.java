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
import br.com.ecommerce.domain.dto.ProdutoDTO;

@Named
@ViewScoped
public class DashboardBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Inject
	private ProdutoDao produtoDao;
	private List<ProdutoDTO> produtoDTOs;

	private PieChartModel produtosPorCategoriaModel;

	private final List<String> cores = Arrays.asList("#ff8a73", "#e8cd74", "#74d5e8", "#a2ff8c", "#c8a3ff");

	@PostConstruct
	public void init() {
		produtoDTOs = produtoDao.buscaProdutosPorCategoria();
		inicializarGraficoPessoasPorProfissao();
	}

	private void inicializarGraficoPessoasPorProfissao() {
		produtosPorCategoriaModel = new PieChartModel();

		List<Number> valores = new ArrayList<>();
		List<String> rotulos = new ArrayList<>();

		for (ProdutoDTO dto : produtoDTOs) {
			rotulos.add(dto.getCategoria());
			valores.add(dto.getQuantidadeProdutos());
		}

		PieChartDataSet dataset = new PieChartDataSet();
		dataset.setData(valores);
		dataset.setBackgroundColor(cores);

		ChartData dados = new ChartData();
		dados.addChartDataSet(dataset);
		dados.setLabels(rotulos);

		produtosPorCategoriaModel.setData(dados);

	}

	public PieChartModel getProdutosPorCategoriaModel() {
		return produtosPorCategoriaModel;
	}

}
