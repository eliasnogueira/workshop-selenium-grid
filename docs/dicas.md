# Dojo Selenium Grid

## Execução em uma máquina diferente da local

Se você executar em uma máquina diferente da sua própria o comando de inicialização do selenium-server deverá ser executado nesta máquina.

Você precisará adicionar mais um parâmetro na linha de comando referente ao driver do browser.

```bash
java -Dwebdriver.chrome.driver="caminho_driver/chromedriver.exe" -jar selenium-server-standalone-3.9.1.jar -role node  -hub http://localhost:4444/grid/register
```

É a mesma forma que fizemos com o método `System.setProperty`, porém estamos passando a responsabilidade do selenium-server da máquina remota inicializar o driver.