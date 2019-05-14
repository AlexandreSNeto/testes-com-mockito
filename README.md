# Testes Unitários

## Boas práticas

### Nomenclatura

1. **test[NomeDaFuncionalidade]**

    Fácil de ler, pois a feature que está sendo testada está no nome do teste. 
    Porém o prefixo `test` é redundante. Convenção bastante usada.

    Exemplos:
     - `testNaoSeraAdultoSeIdadeMenorQue18`
     - `testFalhaNoSaqueSeContaInvalida`
     - `testEstudanteNaoAdmitidoSeCamposObrigatoriosNaoPreenchidos`

1. **[nomeDaFuncionalidade]**

    Alguns artigos sugerem que é melhor apenas escrever a feature que está sendo testada, pois o `@Test` já está indicando que o método é um teste. 
    Também é recomendado pois os testes unitários são uma documentação alternativa.

    Exemplos:
     - `naoSeraAdultoSeIdadeMenorQue18`
     - `falhaNoSaqueSeContaInvalida`
     - `estudanteNaoAdmitidoSeCamposObrigatoriosNaoPreenchidos`

1. **[nomeDoMetodo]\_[Estado]\_[ComportamentoEsperado]**

    Os argumentos contra este modelo apontam que, se o código mudar, o nome do método de teste deverá ser mudado também. Além disso, dependendo do tamanho do nome do método principal, o nome do teste pode ficar gigante.

    Exemplos:
     - `isAdulto_IdadeMenorQue18_False`
     - `sacarDinheiro_ContaInvalida_LancarException`
     - `admitirEstudante_CamposObrigatoriosNaoPreenchidos_FalhaNaAdmissao`

1. **nomeDoMetodo[ComportamentoEsperado][Estado]**

    Versão alternativa do item anterior, porém com o mesmo "defeito", se a regra mudar, o nome do teste deverá mudar também.
    
    Exemplos:
     - `isAdultoFalseSeIdadeMenorQue18`
     - `sacarDinheiroVaiLancarExceptionSeContaInvalida`
     - `admitirEstudanteFalhaNaAdmissaoSeCamposObrigatoriosNaoPreenchidos` 

1. **given_[pré-condição]\_When_[Estado]\_Then_[ComportamentoEsperado]** ou **dado_[pré-condição]\_Quando\_[Estado]\_Entao\_[ComportamentoEsperado]**

    Esta abordagem é baseada no BDD (Behavior-Driven Development). A ideia é quebrar o teste em 3 partes: `pré-condições` > `estado` > `comportamento esperado`.
    
    Exemplos:
     - `dadoQuePessoaQuerSeCadastrarQuandoIdadeMenorQue18EntaoNaoPermitaOCadastro`
     - `dadoQueContaEstaSendoCriadaQuandoNumeroContaInvalidoEntaoLanceException`
     - `dadoQueEstudanteEstaSendoAdmitidoQuandoCamposObrigatoriosNaoPreenchidosEntaoNaoPermitaCadastro`

1. **quando_[Estado]\_EsperadoQue\_[ComportamentoEsperado]**

    De maneira semelhante à anterior, esta técnica visa deixar explicito **o que** o método está testando dado um determinado **cenário**. 
    
    Exemplos:
     - `quandoPessoaMenorDeIdadeEsperadoQueretorneFalse`
     - `quandoContaInvalidaEsperadoQuesaqueNaoSejaRealizado`
     - `quandoCamposObrigatoriosNaoPreenchidosEsperadoQueadmissaoDoEstudanteFalhe`
    
1. **deve[ComportamentoEsperado]Quando[Estado]**

    Esta técnica deixa explicito o objetivo do teste, ou seja, **o que** está sendo testado de acordo com alguma **condição**, sempre a nível de negócio, independente do nome do método que está sendo testado. Portanto não deverá mudar, a menos que a regra de negócio também mude.
    
    Exemplos:
     - `deveLancarExceptionQuandoPessoaMenorDeIdade`
     - `deveFalharOSaqueQuandoContaInvalida`
     - `deveFalharAdmissaoQuandoCamposObrigatoriosNaoPreenchidos`

### Estrutura do Método de Teste

Para que seja fácil e rápido interpretar o que está sendo feito em um método de teste, é importante que ele mantenha uma estrutura padrão e organizada. O BDD ajuda à mantermos uma estrutura comum nos métodos de teste.

Estrutura:
```java
@Test
public void deveTestarAlgumaCoisa() {
    // Given a precondition
    // Stubs

    // When a thing happens
    // Mocks
    
    // Call the method being tested

    // Then a result should be observable
    // Asserts
}
```

Exemplo:
```java
@Test
public void deveRetornarNumeroContrato() {
    // Given a precondition
    BigDecimal numeroContratoMock = new BigDecimal("123456789");
    
    PropostaVO propostaVO = new PropostaVO();
    propostaVO.setNumeroContrato(numeroContratoMock);

    // When a thing happens
    when(propostaDAO.buscarNumeroContrato(1L)).thenReturn(propostaVO);

    // Call the method being tested
    BigDecimal numeroContrato = propostaService.buscarNumeroContrato(1L);

    // Then a result should be observable
    assertEquals(numeroContratoMock, numeroContrato);
    verify(propostaDAO, times(1)).buscarNumeroContrato(1L);
}
```

### Fixture

Fixture é um padrão que define o uso de builders para construção de objetos com valores randomicos ou personalizados. O objetivo é facilitar a leitura do método e o reuso de cenários.

Exemplo:
```java
public class PessoaFixture {

    private Pessoa pessoa = new Pessoa();

    public static PessoaFixture get() {
        return new PessoaFixture();
    }

    public Pessoa build() {
        return pessoa;
    }

    public PessoaFixture comNome() {
        pessoa.setNome(Random.randomString());
        return this;
    }

    public PessoaFixture comNome(String nomePersonalizado) {
        pessoa.setNome(nomePersonalizado);
        return this;
    }

    public PessoaFixture comIdade() {
        pessoa.setIdade(Random.randomInt());
        return this;
    }

    public PessoaFixture comIdade(Integer idadePersonalizada) {
        pessoa.setIdade(idadePersonalizada);
        return this;
    }

    public PessoaFixture comIdadeAdulto() {
        pessoa.setIdade(18);
        return this;
    }

    public PessoaFixture comSexo() {
        pessoa.setSexo(Random.between(Sexo.MASCULINO, Sexo.FEMININO));
        return this;
    }

    public PessoaFixture comSexo(Sexo sexoPersonalizado) {
        pessoa.setSexo(sexoPersonalizado);
        return this;
    }

    public PessoaFixture completo() {
        comNome();
        comIdade();
        comSexo();
        return this;
    }

    public PessoaFixture comDadosMinimos() {
        comNome();
        comIdade();
        return this;
    }

}
```

Usos:
```java
Pessoa pessoaJoao = PessoaFixture.get().comNome("João").comIdadeAdulto().comSexo().build();

Pessoa pessoaFeminino = PessoaFixture.get().comNome().comIdade(15).comSexo(Sexo.FEMININO).build();

Pessoa pessoaMinima = PessoaFixture.get().comDadosMinimos().build();

Pessoa pessoaCompleta = PessoaFixture.get().completo().build();
```

## Mockito

### Funcionalidades Básicas

- `@RunWith`

    Habilita o uso das *Annotations* do Mockito ao executar a classe.
    ```java
    @RunWith(MockitoJUnitRunner.class)
    public class MyTest {
        ...
    }
    ``` 
    
    Caso não esteja presente, os Mocks não serão injetados, causado `NullPointerException` nas chamadas.

- `@Mock`

    Define que um atributo deverá ser instanciado como um *Mock*.
    ```java
    @Mock
    MyService mockedService;
    ``` 

- `@InjectMocks`

    Injecta automaticamente todos os Mocks (anotados com `@Mock`) na classe que está sendo testada.
    ```java
    @Mock
    CustomerDAO customerDAO;

    @Mock
    AddressDAO addressDAO;
     
    @InjectMocks
    CustomerService customerService = new CustomerServiceImpl();
    ``` 
    
    > Mockito will try to inject mocks only either by **constructor injection**, **setter injection**, or **property injection** in order and as described below. If any of the following strategy fail, then Mockito won't report failure; i.e. you will have to provide dependencies yourself.

- `Mockito.when().thenReturn()` 
  
  Permite definir o que deve acontecer quando um determinado mock for chamado pelo método que está sendo testado.
  
  Exemplos
    - `Mockito.when(pessoaDAO.buscar(1).thenReturn(new Pessoa());`
    - `Mockito.when(pessoaDAO.buscar(1).thenReturn(null);`
      
  Variações auto explicativas
    - `Mockito.thenThrow(new CustomException())`
    - `Mockito.thenCallRealMethod()`
 
- `Mockito.any()` / `Mockito.anyString|Int|Boolean|etc()` / `Mockito.any(SomeType.class)`

  Funciona como um "coringa", permitindo definir que não importa o valor de um determinado parâmetro.
  
  Exemplos
    - `Mockito.when(pessoaDAO.buscar(Mockito.anyInt()).thenReturn(new Pessoa());`  
    - `Mockito.when(atm.consultarSaldo(Mockito.any(ContaCorrente.class)).thenReturn(BigDecimal.ZERO);`
    - `Mockito.when(propostaService.imprimir(Mockito.any(), Mockito.any()).thenReturn(new ArquivoPdf());`

- `Mockito.verify()` & `Mockito.times()` / `Mockito.atLeastOnce()` / `Mockito.atLeast(n)` / `Mockito.atMost(n)` / `Mockito.never()`  

  Permite validar se uma determinada chamada foi realizada, validando a quantidade de vezes que foi ou não chamada.
    
  Exemplos
   - `Mockito.verify(pessoaDAO, Mockito.times(1)).buscar(1);` 
   - `Mockito.verify(pessoaDAO, Mockito.never()).buscar(1);`
   - `Mockito.verify(pessoaDAO, Mockito.atLeastOnce()).buscar(1);`
   - `Mockito.verify(pessoaDAO, Mockito.atLeast(2)).buscar(1);`
   - `Mockito.verify(pessoaDAO, Mockito.atMost(1)).buscar(1);`

### Funcionalidades Avançadas

- `@Spy`

    Permite realizar Mocks ao chamar uma instância real de uma classe.
    ```java
    @Spy
    List<String> spiedList = new ArrayList<String>();
     
    @Test
    public void deveValidarSize() {
        spiedList.add("valor1");
        spiedList.add("valor2");
     
        assertEquals(2, spiedList.size());
     
        Mockito.doReturn(100).when(spiedList).size();
        
        assertEquals(100, spiedList.size());
    }
    ```
    
    > Sometimes it's impossible or impractical to use Mockito.when(Object) for stubbing spies. Therefore for spies it is recommended to always use doReturn|Answer|Throw()|CallRealMethod family of methods for stubbing

- `@Rule` & `ExpectedException`

    Permite validar uma exception que será lançada pelo método testado.
    ```java
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void aTest() {
        ...
        thrown.expect(NotDonutException.class);
        thrown.expectMessage(containsString("Bad bad server, no donut for you."));
    }
    ```
    
- `@Captor`

    Permite capturar e obter a instância de um objeto criado (e não retornado) dentro do método testado.
    ```java
    @Captor
    ArgumentCaptor argCaptor;

    @Test
    public void whenUseCaptorAnnotation_thenTheSam() {
        mockedList.add("one");
        Mockito.verify(mockedList).add(argCaptor.capture());
     
        assertEquals("one", argCaptor.getValue());
    }
    ``` 

## Referências

- [7 Popular Unit Test Naming Conventions](https://dzone.com/articles/7-popular-unit-test-naming)
- [Writing Better Tests With JUnit](https://blog.codecentric.de/en/2016/01/writing-better-tests-junit/)
- [Mockito's Official Site](https://site.mockito.org/)
- [Baeldung's Mockito Tutorial](https://www.baeldung.com/mockito-series)
  - [Getting Started with Mockito @Mock, @Spy, @Captor and @InjectMocks](https://www.baeldung.com/mockito-annotations)
  - [Mockito’s Mock Methods](https://www.baeldung.com/mockito-mock-methods)
  - [Mockito When/Then Cookbook](https://www.baeldung.com/mockito-behavior)
  - [Mockito Verify Cookbook](https://www.baeldung.com/mockito-verify)
  - [Mocking Void Methods with Mockito](https://www.baeldung.com/mockito-void-methods) 