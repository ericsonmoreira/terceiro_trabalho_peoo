# Terceiro Trabalho PEOO

> Trabalho referente à disciplina PEOO 2019.2 da UECE.

**Equipe**

Nome                                        | Matrícula
:-------------------------------------------|-------------:
Éricson Rogério Moreira                     |1538663
Paulo Henrique Souza Filho                  |1509022 

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
* Outras classes:
    * **Menu**: Classe responsável por abistrair um menu. Usada para faciliar a adição e manipulação de opções no 
    programa.
    * **Principal**: Classe onde tem no método main.
    