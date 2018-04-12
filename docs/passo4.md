# Dojo Selenium Grid

## Passo 4 - Criando uma grid

[https://github.com/SeleniumHQ/selenium/wiki/Grid2](https://github.com/SeleniumHQ/selenium/wiki/Grid2)

A criação inicial de um grid, basicamente, é a execução do selenium-server de dois modos:

* hub: o controlador que será responsável por enviar o teste para as máquinas (nós)
* node: os nós (máquinas) que receberão os testes

### Criação do hub

Basta executar a seguinte linha de comando no seu Prompt de Comando/Terminal. Lembrando estar no diretório onde o arquivo do selenium-server está.

```bash
java -jar selenium-server-standalone-X.X.X.jar -role hub
```

Note que há um parâmetro `-role` indicando que estamos iniciando o selenium-server em modo _hub_ (controlador).

Algumas informações irão aparecer no console. No final das informações deve aparecer um texto como este:

`HH:mm:ss.SSS INFO - Selenium Grid hub is up and running`

Para verificar se tudo está certo acesse a seguinte URL [http://localhost:4444/grid/console](http://localhost:4444/grid/console)

### Criação do nó

Como estamos em caráter educativo nosso mesmo hub será o mesmo node, em resumo: a mesma máquina que irá controlar o teste será a mesma que irá executará o teste.

Basta executar a seguinte linha de comando no seu Prompt de Comando/Terminal. Lembrando estar no diretório onde o arquivo do selenium-server está.

```bash
java -jar selenium-server-standalone-3.9.1.jar -role node  -hub http://localhost:4444/grid/register
```

Note que há um parâmetro `-hub` indicando a URL de conexão ao hub e o parâmetro `-role` iniciando o selenium-serve em modo _node_ (executor).

### Alteração no BaseTest

Nossa classe base agora precisa mudar.
Como o teste pode ser uma máquina remota é necessário:

* mudar a instância do browser
* indicar a URL do _hub_ (controlador)

#### Mudar a instiancia do browser

Será necessário agora usar a classe `RemoteWebDriver` para gerenciar o browser. Esta classe espera dois parâmetros:

* URL: a URL de conexão com o _hub_ (controlador)
* a capacidade necessária (qual browser)

A capacidade é indicada pela classe `DesiredCapabilities`

```java
// para iniciar o GoogleChrome
DesiredCapabilities = desiredCapabilities = DesiredCapabilities.chrome();

// para iniciar o Firefox
DesiredCapabilities = desiredCapabilities = DesiredCapabilities.firefox();
```

### Refatoração necessária

Agora é hora de refatorar a clase BaseTest inserindo o retorno de uma DesiredCapability ao invés da instância do browser.

E depois, usar a capacidade retornada para iniciar o browser.

A nova inicialização ficará como o código abaixo:

```java
WebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), desiredCapability);
```

[< Voltar](passo3.md) | [Lista de passos](index.md) | [Avançar >](passo5.md)