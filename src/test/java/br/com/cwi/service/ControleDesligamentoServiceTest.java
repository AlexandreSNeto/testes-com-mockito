package br.com.cwi.service;

import br.com.cwi.dao.ControleDesligamentoDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ControleDesligamentoServiceTest {

    @Mock
    private ControleDesligamentoDAO controleDesligamentoDAO;

    @InjectMocks
    private ControleDesligamentoService controleDesligamentoService = new ControleDesligamentoService();

    @Test
    public void deve() {
        
    }

}