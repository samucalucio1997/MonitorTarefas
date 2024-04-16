# Projeto de Monitoramento de Tarefas

Este é um projeto de monitoramento de tarefas desenvolvido com Java 11 no backend, Angular 17 no frontend, utilizando Maven como gerenciador de dependências e PostgreSQL como banco de dados. O objetivo principal é fornecer uma plataforma para gerenciamento de tarefas, onde os usuários podem visualizar, criar e atribuir tarefas a outros usuários.

## Funcionalidades Principais

1. **Cadastro de Tarefas**: Os administradores têm a capacidade de cadastrar novas tarefas no sistema. Cada tarefa pode conter informações como título, descrição, data de vencimento, prioridade e o responsável.(restrito aos usuários admin's)

2. **Atribuição de Tarefas**: Os administradores podem atribuir tarefas aos usuários do sistema. Isso permite que as tarefas sejam distribuídas de forma eficiente entre os membros da equipe.(restrito aos usuários admin's)

3. **Edição e atualização de tarefas**: O sistema permite editar as tarefas como bem entender(sendo autorizado para esta somente o admin).

4. **Visualização de Tarefas**: Os usuários podem visualizar as tarefas atribuídas a eles, bem como as tarefas gerais disponíveis no sistema. Isso fornece uma visão clara das responsabilidades de cada membro da equipe. Vale ressaltar que qualquer usuário logado pode ver a lista de tarefas inclusives as concluidas.

## Tecnologias Utilizadas

- **Backend**: Java 11 é utilizado para desenvolver a lógica de negócios e a API RESTful. O Maven é utilizado para gerenciar as dependências do projeto.
- **Frontend**: Angular 17 é utilizado para criar a interface do usuário dinâmica e responsiva. O Angular facilita a criação de componentes reutilizáveis e a interação com a API backend.
- **Banco de Dados**: PostgreSQL é escolhido como o banco de dados principal devido à sua confiabilidade e capacidade de lidar com grandes volumes de dados.
- **Segurança**: Mecanismos de autenticação e autorização são implementados para garantir que apenas usuários autorizados possam acessar determinadas partes do sistema. Isso é especialmente importante para garantir a segurança dos dados confidenciais do usuário.

## Próximos Passos

- **Implementação de Notificações**: Adicionar a funcionalidade de notificação para informar os usuários sobre novas tarefas atribuídas, alterações no status das tarefas, etc.
- **Melhorias na Interface do Usuário**: Continuar aprimorando a interface do usuário para tornar a experiência do usuário mais intuitiva e eficiente.
- **Relatórios e Estatísticas**: Implementar recursos para gerar relatórios e estatísticas sobre o desempenho individual e coletivo dos usuários na conclusão das tarefas.

## Execução do Projeto

Para executar o projeto localmente, siga estas etapas:

1. Certifique-se de ter o Java 11 e o Maven instalados em sua máquina.
2. Configure um banco de dados PostgreSQL e atualize as configurações de conexão no arquivo de configuração do backend.
3. Navegue até o diretório do backend e execute `mvn spring-boot:run` para iniciar o servidor backend, ou instale as extensões Extension Pack For Java e o Spring Boot Extension Pack, entre em qualquer arquivo .java e pressione F5.
4. Navegue até o diretório do frontend e execute `ng serve` para iniciar o servidor de desenvolvimento do Angular.
5. Abra seu navegador e acesse `http://localhost:4200` para visualizar o aplicativo.

Para implantar o projeto em um ambiente de produção, consulte a documentação específica para cada tecnologia utilizada.

Este README fornece uma visão geral do projeto de monitoramento de tarefas. Para obter mais detalhes sobre a implementação e a arquitetura, consulte a documentação do código-fonte.
