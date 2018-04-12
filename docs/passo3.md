# Dojo Selenium Grid

## Passo 3 - Refatoração: multibrowser

Para que seja possível ter um script multibrowser é necessário criar uma lógica na classe base para que ele retorne o driver que desejamos informar.

Um simples `switch-case` com o nome do browser resolve o nosso problema.

A ideia é ter um método que retornará a instância de um browser, dado um parâmetro com o nome do browser.

Lembrando da sintaxe do `switch-case`:

```java
// JKD do browser deve estar 'setado' como 7 ou superior
switch(parametro) {

   case "browser1":
       // a magica vai aqui
       break;

    case "browser2":
       // a magina vai aqui
       break;

    default:
       // algum retorno de erro
}
```

### Arquivo de propriedade

Para que seja possível alterar o browser que executará o teste é necessário criar um arquivo de propriedades contendo o browser. Assim a troca do browser não implica na mudança de código e compilação.

Crie um arquivo `.properties` com o conteudo

`
browser = chrome
`

O código para o carregamento e utilização do valor da propriedade do browser pode ser:

```java
public static String getValueFromConf(String property) {
    Properties properties;
    String value = null;
    try {
        properties = new Properties();
        properties.load(new FileReader(new File("conf/config.properties")));

        value =  properties.getProperty(property);
        } catch (IOException e) {
            LOGGER.log(Level.ALL, e.getMessage());
        }
        return value;
    }
```

Utilize o método `getValueFromConf` passando como parâmetro a propriedade do browser.

[< Voltar](passo2.md) | [Lista de passos](index.md) | [Avançar >](passo3.md)