package br.com.ecommerce.bean.lazytable;

import java.util.List;
import java.util.Map;

import org.primefaces.model.LazyDataModel;
import org.primefaces.model.SortOrder;

import br.com.ecommerce.dao.ClienteDao;
import br.com.ecommerce.dao.filter.ClienteFilter;
import br.com.ecommerce.domain.Cliente;

public class ClienteLazyModel extends LazyDataModel<Cliente> {
	private static final long serialVersionUID = 1L;

	private ClienteDao clienteDao;

	private ClienteFilter filter;

	public ClienteLazyModel(ClienteDao dao) {
		this.clienteDao = dao;
	}

	@Override
	public List<Cliente> load(int first, int pageSize, String sortField, SortOrder sortOrder,
			Map<String, Object> filters) {
		filter = new ClienteFilter();
		filter.setFirst(first);
		filter.setPageSize(pageSize);
		filter.setSortField(sortField);
		filter.setSortOrder(SortOrder.ASCENDING.equals(sortOrder));
		filter.setFilters(filters);
		setRowCount(clienteDao.count());

		return clienteDao.buscar(filter);
	}

}
