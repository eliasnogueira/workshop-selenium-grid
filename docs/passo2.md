# Dojo Selenium Grid

## Passo 2 - Refatoração: criando um BaseTest

Neste ponto temos um script semelhante a este:

```java
System.setProperty("webdriver.chrome.driver", "caminho_driver/chromedriver.exe");
WebDriver driver = new ChromeDriver();

driver.get("http://www.minhapagina.com.br");

driver.findElement(By.id("id")).click();
Assert.assertEquals(driver.findElement(By.id("id2")).getText(), "Resultado");

driver.quit();
```

Toda vez que houver a necessidade de criar mais de um teste (e isso vai ocorrer o tempo todo) temos ações em comum que podem ser centralizadas, como:

* Inicialização do browser
* Acesso a pagina web
* Fechamento do browser

Sempre que isso acontece criamos uma classe base que será extendida.
Essa classe base irá conter todos os itens acima.

A classe de teste, então ficará apenas com as ações, sem a necessidade dos itens que serão comuns.

```java
driver.get("http://www.minhapagina.com.br");

driver.findElement(By.id("id")).click();
Assert.assertEquals(driver.findElement(By.id("id2")).getText(), "Resultado");
```

Para que isso seja possível a classe base deve instanciar o browser em um metodo de pré-condição e fechar o browser em um método de pós-condição.

* pré-condição: adicionado pela anotação `@BeforeMethod`
* pós-condição: adicionado pela anotação `@AfterMethod`

É importante que a classe base tenha um atributo do driver como publico (`public`) ou protegido (`protected`).

[< Voltar](passo1.md) | [Lista de passos](index.md) | [Avançar >](passo3.md)