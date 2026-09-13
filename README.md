# demo-mvc

[Português](#português) · [English](#english)

---

## Português

Aplicação web de estudo em **Spring Boot + Thymeleaf**, desenvolvida acompanhando um curso de Spring MVC. O domínio é um cadastro corporativo simples: **Departamentos**, **Cargos** e **Funcionários**.

O código do curso foi gravado na época do Spring Boot 1.x, mas este projeto roda em **Spring Boot 4.1.1 / Java 17**. As diferenças de API entre as duas gerações são adaptadas conforme aparecem — veja [Notas de versão](#notas-de-versão).

### Stack

| Componente | Versão |
|---|---|
| Spring Boot | 4.1.1 |
| Java | 17 |
| Thymeleaf | via `spring-boot-starter-thymeleaf` |
| Bootstrap | 4.0.0 (WebJar) |
| jQuery | 3.3.1-1 (WebJar) |
| Open Iconic | 1.1.1 (WebJar, grupo bower) |
| jQuery Mask Plugin | 1.14.13 (WebJar, grupo bower) |

### Como executar

Pré-requisito: JDK 17 ou superior. O Maven não precisa estar instalado — o projeto traz o wrapper.

```bash
./mvnw spring-boot:run
```

A aplicação sobe em http://localhost:8080.

Para rodar os testes:

```bash
./mvnw test
```

### Estrutura

```
src/main/java/com/mballem/curso/boot/
├── DemoMvcApplication.java          # classe principal; fixa o locale em pt-BR
└── web/controller/
    └── HomeController.java          # GET / → home.html

src/main/resources/
├── application.properties
├── META-INF/resources/
│   └── webjars-locator.properties   # registra os WebJars do grupo bower
├── static/
│   ├── css/style.css
│   └── image/
└── templates/
    ├── home.html
    ├── cargo/          (cadastro.html, lista.html)
    ├── departamento/   (cadastro.html, lista.html)
    └── funcionario/    (cadastro.html, lista.html)
```

### Estado atual

Somente a rota `/` está implementada. Os templates de cadastro e listagem das três entidades já existem no projeto, mas **ainda não têm controllers nem camada de persistência** — os links do menu lateral levam a 404. É o ponto onde o curso está no momento.

### Notas de versão

Pontos em que este projeto já divergiu do material original do curso:

- **`spring-boot-starter-web` → `spring-boot-starter-webmvc`** — o starter foi renomeado no Boot 4.
- **`webjars-locator-core` → `webjars-locator-lite`** — o Boot 4 removeu o `WebJarsResourceResolver` baseado no `locator-core`. Sem a troca, todos os assets em caminho sem versão (`/webjars/bootstrap/css/bootstrap.min.css`) retornam 404.
- **`webjars-locator.properties`** — o `locator-lite` só descobre sozinho os grupos Maven `org.webjars` e `org.webjars.npm`. Os WebJars do grupo `org.webjars.bower` (aqui, Open Iconic e jQuery Mask) precisam ser registrados manualmente nesse arquivo. **Ao alterar a versão de um desses dois no `pom.xml`, atualize o arquivo junto** — as versões estão duplicadas nos dois lugares e a dessincronia volta a causar 404 silenciosamente.

O locator monta seu cache de versões na construção da classe: depois de mexer nas dependências ou no `webjars-locator.properties`, reinicie a aplicação por completo — o DevTools não basta.

---

## English

A **Spring Boot + Thymeleaf** study application, built while following a Spring MVC course. The domain is a simple corporate registry: **Departments**, **Job Titles**, and **Employees**. The UI is in Portuguese.

The course material was recorded in the Spring Boot 1.x era, but this project runs on **Spring Boot 4.1.1 / Java 17**. API differences between the two generations are adapted as they come up — see [Version notes](#version-notes).

### Stack

| Component | Version |
|---|---|
| Spring Boot | 4.1.1 |
| Java | 17 |
| Thymeleaf | via `spring-boot-starter-thymeleaf` |
| Bootstrap | 4.0.0 (WebJar) |
| jQuery | 3.3.1-1 (WebJar) |
| Open Iconic | 1.1.1 (WebJar, bower group) |
| jQuery Mask Plugin | 1.14.13 (WebJar, bower group) |

### Running

Prerequisite: JDK 17 or later. Maven does not need to be installed — the wrapper is included.

```bash
./mvnw spring-boot:run
```

The app starts on http://localhost:8080.

To run the tests:

```bash
./mvnw test
```

### Layout

```
src/main/java/com/mballem/curso/boot/
├── DemoMvcApplication.java          # main class; pins the locale to pt-BR
└── web/controller/
    └── HomeController.java          # GET / → home.html

src/main/resources/
├── application.properties
├── META-INF/resources/
│   └── webjars-locator.properties   # registers the bower-group WebJars
├── static/
│   ├── css/style.css
│   └── image/
└── templates/
    ├── home.html
    ├── cargo/          (cadastro.html, lista.html)
    ├── departamento/   (cadastro.html, lista.html)
    └── funcionario/    (cadastro.html, lista.html)
```

### Current state

Only the `/` route is implemented. The create and list templates for all three entities are already in the project, but **there are no controllers or persistence layer behind them yet** — the sidebar links lead to 404s. That is where the course currently stands.

### Version notes

Where this project has already diverged from the original course material:

- **`spring-boot-starter-web` → `spring-boot-starter-webmvc`** — the starter was renamed in Boot 4.
- **`webjars-locator-core` → `webjars-locator-lite`** — Boot 4 removed the `WebJarsResourceResolver` backed by `locator-core`. Without the swap, every version-less asset path (`/webjars/bootstrap/css/bootstrap.min.css`) returns 404.
- **`webjars-locator.properties`** — `locator-lite` only discovers the `org.webjars` and `org.webjars.npm` Maven groups on its own. WebJars from `org.webjars.bower` (here, Open Iconic and jQuery Mask) must be registered manually in that file. **When you change either version in `pom.xml`, update the file too** — the versions are duplicated across both places, and drift silently brings the 404s back.

The locator builds its version cache at class construction time: after touching the dependencies or `webjars-locator.properties`, restart the application fully — DevTools alone will not pick it up.
