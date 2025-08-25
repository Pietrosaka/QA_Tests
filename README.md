# 📊 Projeto Apdex - Application Performance Index

## 🎯 Visão Geral

Este projeto implementa e testa o cálculo do **APDEX (Application Performance Index)**, uma métrica fundamental para medir a satisfação do usuário com base no tempo de resposta de aplicações.

## 📚 O que é APDEX?

**APDEX** é um padrão da indústria que converte múltiplas medidas de performance em uma única pontuação de 0 a 1, representando a satisfação do usuário.

### 🏷️ Categorias de Usuários

| Categoria | Descrição | Impacto no Score |
|-----------|-----------|------------------|
| **Satisfeitos** | Resposta rápida (dentro do tempo esperado) | Conta como 1.0 |
| **Tolerados** | Resposta lenta (acima do esperado, mas aceitável) | Conta como 0.5 |
| **Frustrados** | Resposta muito lenta (inaceitável) | Conta como 0.0 |

### 🧮 Fórmula do APDEX



**Exemplo:**
- Total de usuários: 100
- Satisfeitos: 80
- Tolerados: 15
- Frustrados: 5


---

## 🧪 Testes Implementados (Base: TOTAL_AMOSTRAS = 555839)

### **1. Teste Básico - Apdex 90%**
```java

@Test
public void calcularApdex() {
    int satisfeitos = 500255; // 90% de 555839
    int tolerados = 0;

    double apdexBom = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);

    assertEquals(0.9, apdexBom, 0.01);
}

@Test
public void validarApdexExcelente() {
    int satisfeitos = 533605;
    int tolerados = 5057;

    double valor = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);

    assertEquals(0.96, valor, 0.01);
}

@Test
public void validarApdexBom() {
    int satisfeitos = 472463; // 85% de 555839
    int tolerados = 0;

    double valor = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);

    assertEquals(0.85, valor, 0.01);
}

@Test
public void validarApdexRegular() {
    int satisfeitos = 389087; // 70% de 555839
    int tolerados = 0;

    double valor = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);

    assertEquals(0.70, valor, 0.01);
}

@Test
public void validarApdexRuim() {
    int satisfeitos = 333503; // 60% de 555839
    int tolerados = 0;

    double valor = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);

    assertEquals(0.60, valor, 0.01);
}

@Test
public void validarApdexInaceitavel() {
    int satisfeitos = 127842; // 23% de 555839
    int tolerados = 0;

    double valor = apdex.calcularApdex(satisfeitos, tolerados, TOTAL_AMOSTRAS);

    assertEquals(0.23, valor, 0.01);
}

📈 Saídas Esperadas dos Testes
Teste	                Status	    Tempo	Score Apdex	    Usuários Satisfeitos	Usuários Tolerados
calcularApdex	        ✅ PASS	    ~5ms	   0.90	                500,255	                0
validarApdexExcelente	✅ PASS	~3ms	   0.96	                533,605	              5,057
validarApdexBom	        ✅ PASS	    ~2ms	   0.85	                472,463	                0
validarApdexRegular	    ✅ PASS	    ~2ms	   0.70	                389,087	                0
validarApdexRuim	    ✅ PASS	    ~2ms	   0.60	                333,503	                0
validarApdexInaceitavel	✅ PASS	~2ms	   0.23	                127,842	                0

👨‍💻 Autor

Pietro Cougo | RM: 555839
