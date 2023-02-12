package com.insy2s.E_Redux.Services;

import com.insy2s.E_Redux.Entites.Panier;
import com.insy2s.E_Redux.Entites.Product;
import com.insy2s.E_Redux.Repository.PanierRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PanierServiceImpl implements IPanierService {
    @Autowired
    private PanierRepository panierRepository;
    @Override
    public Panier save(Panier panier) {


        return panierRepository.save(panier);
    }
}
