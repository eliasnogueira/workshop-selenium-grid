# Workshop Selenium GRID

Este é o projeto base para o workshop com Selenium Grid. Ao término do workshop você terá aprendido a:

* Criar testes usando o padrão Page Objects
* Utilizar de arquivos de configuração para mudanças frequêntes nos testes
* Criar um Grid local
* Executar testes em paralelo
* Executar testes qualquer grid (local [máqiona ou container] e remota)

## Instalações

Você precisa ter instalado e/ou configurado na máquina...

### Java JDK

Recomendo a instalação do JDK 8. Você pode fazer o download, de acordo com o seu sistema operacional, em [http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)

Também será necessário:

* Criar a variável JAVA_HOME onde o valor é o diretório onde o JDK está instalado
* Adicionar no PATH o valor _%JAVA_HOME%/bin_

### IDE de desenvolvimento Java

Você pode usar a IDE de sua escolha.
Eu usarei o [IntelliJ IDEA](https://www.jetbrains.com/idea/)

### Efetuar o download do selenium-server

Ele é um dos pontos principais para inicializar uma grid local.
Efetue o download, sempre da última versão disponível clicando no link abaixo e depois no link referente a versão do selenium-server
[https://www.seleniumhq.org/download/](https://www.seleniumhq.org/download/)

### Efetuar o download dos browser drivers

Para iniciar, localmente, cada browser é necessário inicar o seu driver.
Efetue o download da versão mais atual de cada driver. Também não esqueça de deixar o seu browser atualizado.

* [chromedriver (Google Chrome)](https://sites.google.com/a/chromium.org/chromedriver/downloads)
* [geckodriver (Firefox)](https://github.com/mozilla/geckodriver/releases)

### Docker

Para a execução via container é necessário que você efetue o download e instale o Docker através do link [https://www.docker.com/community-edition#/download](https://www.docker.com/community-edition#/download)

Também será necessário utilizar a imagem [elgalu/selenium](https://github.com/elgalu/docker-selenium). Para isso execute um pull

`docker pull elgalu/selenium`