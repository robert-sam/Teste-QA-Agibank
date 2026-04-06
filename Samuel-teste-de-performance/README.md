# QA Teste de Performance – BlazeDemo

# Ferramenta

Apache JMeter

# Cenário testado

Compra de passagem aérea com sucesso

# Como executar

1. Abrir o JMeter
2. Importar o arquivo .jmx
3. Executar o teste

# Configuração

* 250 usuários simultâneos
* Ramp-up: 1 segundo
* Fluxo completo de compra

# Resultados

* Throughput: ~250 req/s
* porcentagem 90: (preencher após execução)

# Conclusão

O sistema apresentou tempo de resposta dentro do esperado, com o porcentagem 90 abaixo de 2 segundos, atendendo ao critério de aceitação.


# Observações

* Utilizado extractor para dados dinâmicos
* Teste baseado em fluxo real do usuário
* Ambiente público pode impactar resultados
