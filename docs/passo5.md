# Dojo Selenium Grid

## Passo 5 - Criando estratégia de teste em paralelo

Para a execução de testes em paralelo, ou seja, mais de um teste ao mesmo tempo seja no mesmo browser ou em browsers diferentes é necessário ter algum código ou abordagem para gerar o paralelismo.

O TestNG possui um suporte nativo ao paralelismo. Para isso precisamos efetuar uma modificação e uma criação de arquivo.

### Criação de arquivo

O TestNG executa seus testes através de um arquivo XML. Nós não enxergamos isso porque a IDE gerencia tudo "por debaixo dos panos". Mas para executar em paralelo precisamos criar um arquivo XML, com qualquer nome como o exemplo abaixo:

```xml
<suite name="Suite" parallel="tests" thread-count="3" >

    <test name="Teste1">
        <parameter name="browser" value="meuBrowser1"/>
        <classes>
            <class name="pacote.ClasseDeTeste"/>
        </classes>
    </test>

    <test name="Teste2">
        <parameter name="browser" value="meuBrowser2"/>
        <classes>
            <class name="pacote.ClasseDeTeste"/>
        </classes>
    </test>
</suite>
```

O arquivo acima, que é uma suite de teste possui um atributo `parallel` para os testes (toda a tag `test`) que estiver neste arquivo. O `thread-count` é o número de execuções simultâneas.

Cada tag `test` passa um parâmetro `browser` com browser que desejamos executar. Para a execução é necessário informar qual(is) classe(s) de teste desejamos executar. Devemos informar o nome completo no caso de `classes`. Há outras possibilidades como `package`.

### Refatoração

É necessário, no método de pré-condição da classe base inserir um parâmetro, que será injetado pelo arquivo XML no momento da execução.

Também é necessário informar a anotação `@Parameters` informando o nome do parâmetro no arquivo XML.

```java
@BeforeMethod
@Parameters("browser")
public void preCondicao(@Optional("chrome") String browser)  {
   // maquica de inicialização do browser
}
```

A execução do paralelismo sempre deve ser feita através do arquivo XML.

A anotação dentro do parâmetro serve para a execução sem o paralelismo, caso você queira executar apenas um teste (digamos que você esta refatorando, criando ou resolvendo um problema nele) o browser que será passado, caso você não informe será o opcional.

[< Voltar](passo4.md) | [Lista de passos](index.md)