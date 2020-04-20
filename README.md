# Terceiro Trabalho PEOO

> **PROJETO MERAMENTE ACADÊMICO**

> Trabalho referente à disciplina PEOO 2019.2 da UECE.

**Equipe**

Nome                                        | Matrícula
:-------------------------------------------|-------------:
Éricson Rogério Moreira                     |1538663
Paulo Henrique Souza Filho                  |1509022 

### O que é proposto?

Uma simples aplicação que simula o funcionamento de um controle remoto que 
controla Televisões. Nesse controle remoto já estarão pre-cadastrados duas Tvs. Cada Tv
terá um canal atual, uma lista de canais disponíveis e uma outra lista de canais 
cadastrados.

Funcionalidades:

* **Aumentar volume**: incrementa em uma unidade o volume de todas Tvs que são 
    controladas pelo controle remoto e depois mostra essa informação. 
* **Diminiur volume**: decrementar em uma unidade o volume de todas Tvs que são 
    controladas pelo controle remoto e depois mostra essa informação.
* **Próximo canal**: sintoniza o canal atual de todas Tvs que são controladas pelo 
    controle remoto para o próximo canal da lista de canais cadastrados na Tv 
    respectiva e depois mostra essa informação.
* **Canal anterior**: sintoniza o canal atual de todas Tvs que são controladas pelo 
    controle remoto para o canal anterior da lista de canais cadastrados na Tv 
    respectiva e depois mostra essa informação.
* **Sintonizar canal**: sintozina um canal escolhido em cada Tv, caso esse canal 
    possa ser sintonizado pela Tv respectiva.
* **Informar dados**: Informa os dados de cada Tv controlada pelo controle remoto.
* **Mostrar grade**: Mostra as informações dos canais cadastrados em cada Tv.

### Classes Usadas

* Exceptions
    * **CanalInexistenceException**: Exception disparada quando se tenta adicionar um canal na lista de canais 
    cadastrados em uma TV porém esse canal não está entre os canais disponíveis nessa TV.
    * **TvJaCadastradaException**: Exception disparada quando se tenta adicionar uma TV já existente na lista de TVs que
     um objeto ControleRemoto tem.
* Model's:
    * **Canal**: Classe que representa um Canal de uma TV.
    * **ControleRemoto**: Classe que representa uma controle remoto que pode manipular TVs.
    * **SmartTV**: Subclasse de Televisão.
    * **Televisao**: Classe abstrata
    * **TVHD**: Subclasse de Televisão.
* View:
    * **ControleRemotoJFrame**: JFrame da interface gráfica do programa.
* Outras classes:
    * **Principal**: Classe onde tem no método main.
    
