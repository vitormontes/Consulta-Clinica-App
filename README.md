# Clínica do Vitor — App de Agendamento de Consultas

Aplicativo Android para agendamento simples de consultas, desenvolvido em **Kotlin** no **Android Studio**, com persistência local via **Room** e navegação entre telas por **Intent**.

## 📱 Sobre o projeto

O app permite que o usuário visualize, agende e acompanhe consultas de forma simples e direta, com foco em usabilidade para um público leigo em tecnologia (perfil comum de pacientes de uma clínica).

## ✨ Funcionalidades

- **Tela principal (Minhas Consultas)**
  - Resumo com contadores: consultas de **hoje**, **desta semana** e **total**
  - Lista de próximas consultas
  - Estado vazio ilustrado quando não há consultas agendadas
  - Botão flutuante (FAB) para agendar uma nova consulta

- **Tela de Nova Consulta**
  - Campo para nome do paciente
  - Seleção de data via **DatePicker**
  - Seleção de horário via **TimePicker**
  - Campo de observação opcional
  - Confirmação do agendamento com feedback ao usuário (Toast/Snackbar)

- **Persistência de dados**
  - Uso do **Room** para armazenar as consultas localmente no dispositivo

## 🏗️ Arquitetura e conceitos aplicados

- **Activities**: cada tela é uma unidade independente com seu próprio ciclo de vida (`onCreate`, `onStart`, `onResume`, `onPause`, `onStop`, `onDestroy`)
- **Navegação por Intent**: comunicação entre a tela principal e a tela de nova consulta
- **ConstraintLayout**: construção dos layouts das telas
- **Room**: banco de dados local para persistir as consultas
- **Styles e Themes**: padronização visual (cores, tipografia e botões) centralizada em `themes.xml`, garantindo identidade visual consistente entre as telas

## 🎨 Princípios de usabilidade

O design segue heurísticas de usabilidade (Nielsen) e diretrizes do Material Design:

- Botões com área de toque de 56dp (acima do mínimo recomendado de 48dp)
- Contraste de cor adequado (texto branco sobre azul) seguindo a WCAG
- Hierarquia visual clara entre título e ação principal
- Campos com *hint* indicando o formato esperado
- Feedback imediato ao usuário após ações (Toast/Snackbar)

## 🛠️ Tecnologias

| Tecnologia | Uso |
|---|---|
| Kotlin | Linguagem de programação |
| Android Studio | IDE |
| ConstraintLayout | Construção de layouts |
| Room | Persistência de dados local |
| Material Design | Diretrizes visuais e de componentes |

## 📂 Estrutura do projeto

```
app/
├── manifests/
│   └── AndroidManifest.xml
├── java/com.exemplo.agendaconsulta/
│   ├── MainActivity.kt
│   └── FormActivity.kt
├── res/
│   ├── layout/
│   │   ├── activity_main.xml
│   │   └── activity_form.xml
│   ├── values/
│   │   ├── colors.xml
│   │   ├── strings.xml
│   │   └── themes.xml
│   ├── drawable/
│   └── mipmap/
```

## 🚀 Próximos passos

- Validação de conflitos de horário
- Notificações de lembrete de consulta
- Edição e exclusão de consultas agendadas

## 📸 Capturas de tela

| Minhas Consultas | Nova Consulta |
|---|---|
| Tela principal com resumo e lista de consultas | Formulário de agendamento com data e horário |
<img width="1125" height="2436" alt="MinhasConsultas" src="https://github.com/user-attachments/assets/00ad02ef-38e0-4b23-8375-ca13332cfdce" />

<img width="1125" height="2436" alt="NovaConsulta" src="https://github.com/user-attachments/assets/ca91d1fc-7a77-4e72-be56-d8690def2942" />



---

Desenvolvido por **Vitor Montes**
