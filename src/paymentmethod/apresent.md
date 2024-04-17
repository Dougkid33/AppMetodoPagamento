

## Estrutura do Sistema de Pagamento

A estrutura do sistema foi projetada para suportar diferentes métodos de pagamento, validar esses métodos, e registrar cada transação, envolvendo os seguintes componentes principais:

### Interfaces Comuns

- **PaymentMethod**: Interface que define o método `pay(double amount)`. Qualquer classe que represente um método de pagamento deve implementar essa interface, permitindo que diferentes métodos de pagamento sejam tratados polimorficamente.
- **PaymentValidator**: Interface que define o método `validatePaymentDetails()`. Isso permite diferentes implementações de validação para diferentes métodos de pagamento.

### Implementações de Métodos de Pagamento

- **CreditCard, PayPal, Boleto, Debit**: Cada uma destas classes implementa a interface `PaymentMethod`. Algumas também implementam `PaymentValidator` para fornecer validações específicas antes de processar pagamentos.

### Log de Transações

- **TransactionLogger**: Uma classe dedicada para registrar detalhes das transações, demonstrando a aplicação do princípio da responsabilidade única, um dos padrões GRASP, onde a classe tem um único motivo para mudar, que é registrar transações.

### Controlador de Pagamento

- **PaymentController**: Atua como uma fachada para operações de pagamento, integrando validação, execução de pagamento, e registro em um único ponto de controle, o que simplifica a interação com o sistema de pagamento do ponto de vista dos clientes do sistema.

## Aplicação dos Padrões GRASP

Vamos analisar como os padrões GRASP foram aplicados neste exemplo:

### Baixo Acoplamento

- **Implementado através da utilização de interfaces** (`PaymentMethod` e `PaymentValidator`), o que reduz a dependência direta entre a lógica de processamento de pagamentos (`PaymentController`) e os métodos de pagamento específicos (`CreditCard`, `PayPal`, etc.).
- **Injeção de dependência** é usada para fornecer ao `PaymentController` instâncias de `PaymentMethod` e `PaymentValidator`, permitindo que sua configuração seja flexível e facilmente alterada ou expandida com novos métodos de pagamento.

### Polimorfismo

- As diversas classes de métodos de pagamento são tratadas de maneira uniforme através das interfaces que implementam. Isso permite que o `PaymentController` invoque o método `pay` de qualquer implementação concreta de `PaymentMethod` sem conhecer os detalhes internos de cada uma.

### Alta Coesão

- Cada classe tem uma responsabilidade clara e bem definida. Por exemplo, as classes de método de pagamento focam exclusivamente em detalhes de pagamento, enquanto `TransactionLogger` cuida apenas de registrar transações.

### Controlador

- `PaymentController` serve como um ponto central para gerenciar o processo de pagamento, encapsulando a lógica de validação e pagamento e o registro de transações, o que facilita a manutenção e escalabilidade do sistema.

### Fabricação Pura

- Utiliza classes como `TransactionLogger` para realizar funções específicas como log de transações, evitando misturar essas responsabilidades com outras classes, o que melhora a organização e a clareza do código.
