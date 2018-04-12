# Dojo Selenium Grid

[Voltar](index.md)

## Passo 1 - Criando scripts de teste

### Pre condição

Criar uma classe de teste na sua IDE.

### Selenium

Selenium é uma API Open Source e um padrão no W3C para simular as ações de um usuário em uma página web.

Existe bibliotecas para diferentes linguagens de programação, que podem ser visualizadas no seu site oficial [https://www.seleniumhq.org](https://www.seleniumhq.org)

#### Iniciando um browser web

O ponto de partida é a classe `WebDriver` onde é preciso instanciar o browser para a execução do teste. No nosso caso usaremos o Google Chrome e Firefox, sendo as classes:

* `ChromeDriver()`
* `FirefoxDriver()`

Exemplo:

```java
WebDriver driver = new ChromeDriver();
```

Para inicializar qualquer driver, é necessário executar o driver daquele browser. Podemos fazer isso programaticamente através do seguinte exemplo, e esta linha deve estar antes da inicialização do browser:

```java
System.setProperty("webdriver.chrome.driver", "caminho_driver/chromedriver.exe");
```

Caso a execução seja via Firefox, o primeiro parâmetro da propriedade será _webdriver.gecko.driver_ e o seguindo o caminho para o executável _gehckodriver_.

#### Abrindo uma URL

Para abrir uma URL usamos a instância do browser para acessar diversos métodos, entre eles o _get_ que é responsável pelo acesso a uma página web:

```java
driver.get("http://google.com");
```

#### Interagindo e manipulando elementos web

Será necessário interagir com os elementos (clicar, pegar texto, preencher, etc..). O ponto de partida é utilizar o "Dev Tools" embutido no seu browser web para descobrir facilmente o código HTML do elemento web.

Poderemos, durante o workshop, usar 3 formas de localizar elementos:

* id: utilizando o valor do atributo ID do elemento web
* cssSelector: utilizando seletores CSS
* xpath: utilizando expressões XPATH

A interação é feita pelo método _findElement_, onde o parâmetro é o tipo de localização e a forma.

```java
driver.findElement(By.id("user")).sendKeys("elias");
driver.findElement(By.xpath("//input[@type='radio']")).click();
driver.findElement(By.cssSelector(".btn.primary")).getText();
```

#### Validação dos resultados de teste

Toda e qualquer validação precisa do suporte de um framework de teste unitário. Em nosso dojo estamos usando o TestNG.

Ele possui métodos de asserção através da classe Assertions, onde o mais comum é validar o resultado obtido versus o resultado esperado. Usamos o método `assertEquals` para isso.

O _resultado obtido_ é aquele que vem da interface gráfica, geralmente um texto.

O _resultado esperado_ é aquele que temos certeza que é o correto, e que deve ser comparado com o resultado obtido.

```java
Assertion.assertEquals(driver.findElement(By.id("mensagem").getText()), "Salvo com sucesso!");
```

#### Fechando o browser web

Ao final das ações e validações é necessário fechar o browser web.
Fazemos isso através do método `quit()` do `driver`.

```java
driver.quit();
```

[Lista de passos](index.md) | [Próximo >](passo2.md)