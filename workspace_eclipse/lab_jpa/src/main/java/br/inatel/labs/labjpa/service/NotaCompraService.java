package br.inatel.labs.labjpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import br.inatel.labs.labjpa.repository.NotaCompraItemRepository;
import br.inatel.labs.labjpa.repository.NotaCompraRepository;

@Service
@Transactional
public class NotaCompraService {
	@Autowired
	private NotaCompraRepository ncRepository;
	
	@Autowired
	private NotaCompraItemRepository nciRepository;
	
	public NotaCompra salvar(NotaCompra nc) {
		return ncRepository.save(nc);
	}
	
	public Optional<NotaCompra> buscarNotaCompraPeloId(Long id) {
		return ncRepository.findById(id);
	}
	
	public NotaCompra buscarNotaCompraPeloIdComListaItem(Long id) {
		Optional<NotaCompra> opNotaCompra = ncRepository.findById(id);
		if(opNotaCompra.isPresent()) {
			NotaCompra notaCompra = opNotaCompra.get();
			notaCompra.getListaNotaCompraItem().size();
			return notaCompra;
		}else {
			throw new RuntimeException("nenhuma nota compra encontrada");
		}
	}
	
	public List<NotaCompra> listaNotaCompra(){
		return ncRepository.findAll();
	}
	
	public NotaCompraItem salvar(NotaCompraItem item) {
		return nciRepository.save(item);
	}
	
	public Optional<NotaCompraItem> buscarNotaCompraItemPeloId(Long id) {
		return nciRepository.findById(id);
	}
	
	public List<NotaCompraItem> listaNotaCompraItem(){
		return nciRepository.findAll();	}
}
