# Responsável pelo projeto
- José Arthur Paim Perius - Sistemas de Informação

# Proposta - 📚

No começo, fiquei incerto sobre o que elaborar para essa atividade, depois de alguns dias de pensamento cheguei a seguinte conclussão - Lembro-me de na infância jogar diversos jogos como "Cookie Clicker" e "Adventure Captalist", ambos do gênero Clicker, foi ai que me surgiu a ideia. Por que não fundir esse gênero de jogos, com uma temática mais plausível e voltada a linha de pensamento da atividade proposta. 

Foi ai que surgiu o "Viral Clicker", uma pequena amostra de um jogo do estilo clicker, que ao mesmo tempo trabalha com a temática do combate a doenças virais.

# Desenvolvimento - 🖥️

Inicialmente, fui em busca de materiais educativos a respeito do LibGDX e suas capacidades, depois de vasculhar a internet me deparei com alguns tutoriais como os de [Raeleus](https://www.youtube.com/@raeleus), assim, tive meu primeiro contato com o framework proposto. A partir daí, tentei dar início ao desenvolvimento do projeto, porém meu principal desafio foi dar o pontapé inicial. Depois de pensar em algumas possíveis rotas pra iniciar o projeto optei por elaborar uma tela de menu principal, afinal, todo jogo precisa de um menu. Foi aí que os problemas começaram

De cara, tentei utilizar skins personalizadas para os diferentes widgets que o framework proporciona, porém não obtive sucesso. Passei a usar um conjunto de texturas prontas como placeholder, até que eu criasse coragem para resolver essa pendência. No fim, acabei implementando uma classe mestra que serviria com base para as demais telas do jogo, assim não seria necessário gerar um novo stage e nem reajustar a tela a cada mudança de cenário.

Depois, fiz alguns testes com os diferentes tipos de botões disponíveis, e estipulei um protótipo da ideia final, claro que sem muitos dos detalhes. Também me aprofundei no uso das ferramentas [Skin Composer](https://libgdx.com/wiki/tools/skin-composer) e [Hiero](https://libgdx.com/wiki/tools/hiero) para aperfeiçoar as texturas e fontes que seriam utilizadas posteriormente.

Para isso, utilizei uma das [skins](https://github.com/czyzby/gdx-skins) disponibilizadas pelo [czyzby](https://github.com/czyzby). Com o sprite base dos botões, foi possível customizá-los de acordo com a minha preferência através do Skin Composer, a mesma coisa foi feita no Hiero para as fontes utilizadas.

Ademais, foi implementado um sistema de aumento no ganho de pontos por click, uma geração de pontos passiva e um evento aleatório que pode ocorrer toda vez que o usuário clica no botão principal - Essa foi a forma que encontrei para prevenir que o jogador automatizasse o click no botão, pois o mesmo é interrompido por um pop-up, assim como pela perda de um percentual de seus pontos.

Por fim, outro problema encontrado foi o deslocamento inesperado dos widgets, isso ocorria pois o texto inserido em 2 dos botões sofre alterações em tempo real, e essa mudança de tamanho no texto fazia com que os demais widgets fossem empurrados para fora da tela. A solução foi definir uma largura e altura fixa para cada botão usando width() e height(). Dessa forma, não importa se o texto dentro fica maior ou menor, o botão sempre vai ter o mesmo tamanho e vai ficar na mesma posição.

# Diagrama
Diagrama gerado automáticamente através do plugin UML Generator, disponível no IntelliJ IDEA.

<img width="3421" height="1704" alt="," src="https://github.com/user-attachments/assets/fc605df5-026f-4623-b726-057ab249e6f3" />

# Resultado Final - 🔚
![Desktop 2025 11 27 - 00 (online-video-cutter com)](https://github.com/user-attachments/assets/d6192b79-4826-4c22-996d-2c48fe01e052)

# Referências

[Guillotine Clicker](https://github.com/elc117/t4-2022a-flavio_gregori_matheus) - https://github.com/elc117/t4-2022a-flavio_gregori_matheus

[LibGDX scenes wiki](https://libgdx.com/wiki/graphics/2d/scene2d/scene2d)

Prompts - Como animar um ImageButton, Como converter arquivos .ttf para .fnt com Hiero



